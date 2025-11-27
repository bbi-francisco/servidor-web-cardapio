package web_cardapio.br.com.bitbyte.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import web_cardapio.br.com.bitbyte.connection.ConnectionFactory;
import web_cardapio.br.com.bitbyte.enums.RestricaoType;
import web_cardapio.br.com.bitbyte.format.Format;
import web_cardapio.br.com.bitbyte.models.Alergias;
import web_cardapio.br.com.bitbyte.models.ProdInfo;
import web_cardapio.br.com.bitbyte.models.Produto;
import web_cardapio.br.com.bitbyte.models.Promocao;
import web_cardapio.br.com.bitbyte.models.Restricao;
import web_cardapio.br.com.bitbyte.models.TamanhoPizza;
import web_cardapio.br.com.bitbyte.utils.ListUtils;
import web_cardapio.br.com.bitbyte.utils.StringUtils;

@Repository
public class ProdutoDao
{
	@Autowired
	private ConnectionFactory connectionFactory;
	
	@Autowired
	private PromocaoDao promocaoDao;
	
	@Autowired
	private RestricaoDao restricaoDao;

	public List<Produto> getProdutos(String where) throws SQLException
	{
		Map<String, List<Promocao>> mapPromocoes = promocaoDao.getMapProdutoPromocoes();
		
		Map<String, List<Restricao>> mapRestricoes = restricaoDao.getMapRestricoes(RestricaoType.PRODUTO);
		
		String sql = 
			" SELECT DISTINCT " + 
			" p.indice, " +
			" p.pvendaa AS valor," + 
			" p.codigo," + 
			" p.codpesquisa, " +
			" p.descricao, " + 
			" p.descritivo_cardapio_digital, " +
			" COALESCE(p.grupo, '') AS grupo," + 
			" p.subgrupo, " + 
			" p.tipo_produto, " +
			" p.descricao2, " + 
			" p.permite_mesclar, " + 
			" COALESCE(p.img1,'') AS img1, " + 
			" COALESCE(p.img2, '') AS img2, " + 
			" COALESCE(p.img3, '') AS img3, " +
			" p.bebida_alcoolica, " + 
			" COALESCE(p.utiliza_cardapio_digital, '') AS produto_utiliza_cardapio, " +
			" p.limitevenda, " +
			" COALESCE(p.montagem, 'N') as montagem, " +
			" p.disponivel, " +
			" COALESCE(p.codpizza, 0) as codigo_pizza, " + 
			" COALESCE(p.codtam_pizza, 0) as codigo_tamanho_pizza, " + 
			" COALESCE(piz.descricao, '') as descricao_tamanho_pizza, " + 
			" COALESCE(piz.tamanho, '') as tamanho_pizza, " + 
			" COALESCE(piz.qtdmin, -1) as qtdmin_pizza, " + 
			" COALESCE(piz.qtdmax, -1) as qtdmax_pizza, " +
			" COALESCE(p.ingrediente_obrigatorio, 'N') as ingrediente_obrigatorio, " +
			" COALESCE(p.perg_venda_sugestiva, 'N') as perg_venda_sugestiva " +
			" FROM tbprod p " + 
			" LEFT JOIN tbgrupo g ON g.codigo = p.grupo " +
			" LEFT JOIN tbsubgru sg ON sg.codigo = sg.codigo "+
			" LEFT JOIN tbtamanho_pizza piz ON piz.codigo = p.codtam_pizza " +
			" LEFT JOIN tbalergias al ON al.cod_prod = p.codigo " +
			where + 
			" ORDER BY trim (p.subgrupo), trim(p.descricao) ";
		
		
		List<Produto> produtos = new ArrayList<>();
		
		try(Connection conn = connectionFactory.getConnection();
			PreparedStatement pst = conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery())
		{
			while(rs.next())
			{
				Produto produto = new Produto();
				
				produto.setIndice(rs.getInt("indice"));

				String codigoProduto = rs.getString("codigo");
				produto.setCodigo(codigoProduto);
				produto.setCodigoPesquisa(rs.getString("codpesquisa"));
				produto.setDescricao(rs.getString("descricao"));
				produto.setDescritivoCardapioDigital(rs.getString("descritivo_cardapio_digital"));
				produto.setCodigoGrupo(rs.getString("grupo"));
				produto.setCodigoSubgrupo(rs.getString("subgrupo"));
				
				produto.setVrUnit(BigDecimal.valueOf(rs.getDouble("valor")));
				produto.setDescricaoDetalhes(rs.getString("descricao2"));
				produto.setPermiteMesclar("S".equals(rs.getString("permite_mesclar")));
				produto.setAlcoolico("S".equals(rs.getString("bebida_alcoolica")));
				produto.setMontagem("S".equals(rs.getString("montagem")));
				
				produto.setTipoProduto(rs.getInt("tipo_produto"));
				produto.setPromocoes(mapPromocoes.get(codigoProduto));
				produto.setRestricoes(mapRestricoes.get(codigoProduto));
				produto.setUtilizaCardapioDigital("S".equals(rs.getString("produto_utiliza_cardapio")));
				produto.setLimiteVenda(rs.getInt("limitevenda"));
				produto.setDisponivel("S".equals(rs.getString("disponivel")));
				
				produto.setIngredienteObrigatorio("S".equals(rs.getString("ingrediente_obrigatorio")));
				produto.setPergVendaSugestiva("S".equals(rs.getString("perg_venda_sugestiva")));
				
				handlePizza(produto, rs);
				handleImages(produto, rs);
				
				produtos.add(produto);
			}
			return produtos;
		}
	}
	
	public List<Produto> getProdutos() throws SQLException{
		return getProdutos("");
	}
	
	public Produto getProdutoByCodigoPesquisa(String codigoPesquisa) throws SQLException {
		
		String where = " WHERE p.codpesquisa = '" +codigoPesquisa+ "'";
		
		List<Produto> produtos = getProdutos(where);
		
		if(ListUtils.isNullOrEmpty(produtos)) {
			return null;
		}
		
		return produtos.get(0);
	}
	
	private void handleImages(Produto produto, ResultSet rs) throws SQLException {

		String[] images = {
				rs.getString("img1"), 
				rs.getString("img2"),
				rs.getString("img3")};
		
		produto.setImages(Arrays.asList(images));
	}
	
	private void handlePizza(Produto produto, ResultSet rs) throws SQLException {

		int codigoPizza = rs.getInt("codigo_pizza");
		if(codigoPizza != 0) 
		{
			TamanhoPizza tamanhoPizza = new TamanhoPizza();
			tamanhoPizza.setCodigoTamanhoPizza(rs.getInt("codigo_tamanho_pizza"));
			tamanhoPizza.setDescricaoTamanhoPizza(rs.getString("descricao_tamanho_pizza"));
			tamanhoPizza.setAbreviacao(rs.getString("tamanho_pizza"));
			tamanhoPizza.setQtdMaxPizza(rs.getInt("qtdmax_pizza"));
			tamanhoPizza.setQtdMinPizza(rs.getInt("qtdmin_pizza"));
			produto.setCodigoPizza(codigoPizza);
			produto.setTamanhoPizza(tamanhoPizza);
		}
	}
	
	public Map<String, String> getImages() throws SQLException
	{
		String sql = 
			" SELECT DISTINCT " + 
			" p.codigo," + 
			" COALESCE(p.img1,'') AS img1 " + 
			" FROM tbprod p " +
			" WHERE p.utiliza_cardapio_digital = 'S' AND p.disponivel = 'S'";
		
		
		List<Produto> produtos = new ArrayList<>();
		
		try(Connection conn = connectionFactory.getConnection();
			PreparedStatement pst = conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery())
		{
			Map<String, String> map = new HashMap<>();
			while(rs.next())
			{
				map.put(rs.getString("codigo"), rs.getString("img1"));
			}
			return map;
		}
	}
	
	public ProdInfo getProdInfo(String codigo) throws SQLException 
	{
		List<ProdInfo> prodInfos = getProdInfos(codigo);
		
		if(ListUtils.isNullOrEmpty(prodInfos)) {
			return new ProdInfo()
					.setCodigo(codigo)
					.setDisponivel(false)
					.setUtilizaCardapioDigital(false);
		}
		
		return prodInfos.get(0);
	}

	public List<ProdInfo> getProdInfos(String codigo) throws SQLException {
		String sql = 
				" SELECT " +
				" codigo, " +
				" disponivel, " +
				" utiliza_cardapio_digital " +
				" FROM tbprod pd ";
		
		if(!StringUtils.isNullOrEmpty(codigo)) {
			sql += " WHERE pd.codigo = " + Format.casasFormat(codigo, 6);
		}
		
		try(Connection conn = connectionFactory.getConnection();
				PreparedStatement pst = conn.prepareStatement(sql);
				ResultSet rs = pst.executeQuery())
			{
				List<ProdInfo> prodInfos = new ArrayList<>();
				while(rs.next()) 
				{
					ProdInfo p = new ProdInfo()
							.setCodigo(rs.getString("codigo"))
							.setDisponivel("S".equals(rs.getString("disponivel")))
							.setUtilizaCardapioDigital("S".equals(rs.getString("utiliza_cardapio_digital")));
					
					prodInfos.add(p);
				}
				return prodInfos;
			}
	}
}