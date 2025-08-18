package web_cardapio.br.com.bitbyte.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import web_cardapio.br.com.bitbyte.connection.ConnectionFactory;
import web_cardapio.br.com.bitbyte.enums.TipoValor;
import web_cardapio.br.com.bitbyte.models.Adicionais;
import web_cardapio.br.com.bitbyte.models.Item;
import web_cardapio.br.com.bitbyte.models.ItemCombo;
import web_cardapio.br.com.bitbyte.models.Variacao;
import web_cardapio.br.com.bitbyte.models.bbifood.AdicionaisBBIFood;
import web_cardapio.br.com.bitbyte.models.bbifood.AtendenteBBIFood;
import web_cardapio.br.com.bitbyte.models.bbifood.ComandaBBIFood;
import web_cardapio.br.com.bitbyte.models.bbifood.ItemBBIFood;
import web_cardapio.br.com.bitbyte.models.bbifood.PedidoBBIFood;
import web_cardapio.br.com.bitbyte.models.bbifood.VariacaoBBIFood;
import web_cardapio.br.com.bitbyte.sqlcommons.Generator;
import web_cardapio.br.com.bitbyte.utils.CollectionsUtils;
import web_cardapio.br.com.bitbyte.utils.MapAddHelper;
import web_cardapio.br.com.bitbyte.utils.StringUtils;

@Repository
public class ComboDao
{
	private int seqPeso;
	
	@Autowired
	private Generator generator;
	
	@Autowired
	private ConnectionFactory connectionFactory;

	public List<ItemCombo> getItensCombo() throws SQLException
	{
		List<ItemCombo> combos = new ArrayList<ItemCombo>();
		
		String sql = 
				"	 SELECT " + 
				"    pd.codigo AS codigo_pai, " +
				"	 pd.descricao, " +
				"    pd.codpesquisa, " + 
				"	 pgc.ordem, " + 
				"    pdgc.descricao AS descricao_produto, " + 
				"    pdgc.codpesquisa AS codpesquisa_produto, " + 
				"	 pdgc.pvendaa, " +
				"    pdgc.codigo AS codigo_produto, " + 
				"    pdgc.pcusto AS custo_produto, " + 
				"    gc.codigo AS codigo_grupo, " + 
				"	 gc.tipo_valor, " +
				"	 gc.qtd_min, " +
				"	 gc.qtd_max, " +
				"	 gc.qtd_repete, " +	
				"    gc.descricao AS descricao_grupo, " +
				" 	 COALESCE (gc.valor, '0.00') AS valor_grupo," +
				"    COALESCE(v.cod_prod, '') AS variacao " + 
				" FROM tbprod pd" + 
				" INNER JOIN tbprod_grupo_combo pgc ON pd.codigo = pgc.codigo_produto " + 
				" LEFT JOIN tbgrupo_combo gc ON pgc.codigo_grupo = gc.codigo " + 
				" LEFT JOIN tbgrupo_combo_item gci ON gc.codigo = gci.codigo_grupo " + 
				" INNER JOIN (" + 
				"    SELECT CAST(codigo AS Int) AS codigo, codpesquisa, descricao, pcusto, pvendaa " + 
				"    FROM tbprod WHERE montagem = 'N' " + 
				"    ) pdgc ON gci.codigo_produto = pdgc.codigo " + 
				" LEFT JOIN tbprod_variacao v ON pdgc.codigo = v.cod_prod " + 
				" WHERE pd.montagem = 'S' " + 
				" ORDER BY ordem, descricao_produto";
		
		try(Connection conn = connectionFactory.getConnection();
			PreparedStatement pst = conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery())
		{
			while(rs.next())
			{
				ItemCombo itemCombo = new ItemCombo()
						.setCodigoPai(rs.getString("codigo_pai"))
						.setDescricaoPai(rs.getString("descricao"))
						.setDescricaoGrupo(rs.getString("descricao_grupo"))
						.setDescricao(rs.getString("descricao_produto"))
						.setCodigo(rs.getString("codigo_produto"))
						.setCodigoPesquisa(rs.getString("codpesquisa_produto"))
						.setCodigoGrupo(rs.getString("codigo_grupo"))
						.setCodigoVariacao(rs.getString("variacao"))
						.setTipoValor(rs.getInt("tipo_valor"))
						.setQtdRepete(rs.getString("qtd_repete"))
						.setQtdMax(rs.getInt("qtd_max"))
						.setQtdMin(rs.getInt("qtd_min"));
				
				if(TipoValor.PRODUTO == itemCombo.getTipoValor()) {
					itemCombo.setVrUnit(rs.getBigDecimal("pvendaa"));
				}else {
					itemCombo.setVrUnit(rs.getBigDecimal("valor_grupo"));
				}
				
				combos.add(itemCombo);
			}
			return combos;
		}
	}
	
	public void setSeqPeso(int seqPeso) {
		this.seqPeso = seqPeso;
	}
	
	public void insertItensCombo(ItemBBIFood itemPedido, PedidoBBIFood pedidoFinal) throws SQLException
	{
		ComandaBBIFood comanda = pedidoFinal.getComanda();
		
		AdicionaisBBIFood adicionais = itemPedido.getAdicionais();
		List<ItemBBIFood> itensMontagem = adicionais.getItensMontagem();
		
		for(ItemBBIFood combo : itensMontagem)
		{
			// inserindo combo na tbcomanda_item
			String sqlInsertCombosItem = "INSERT INTO tbcomanda_item (" +
				" comanda, " + // 1
				" codprod, " + // 2
				" codprod_2, " + // 3
				" descricao, " + // 4
				" qtd, " + // 5
				" vr_unit, " + // 6
				" funcionario, " + // 7
				" id_ingre, " + // 8
				" seq_item, " + // 9
				" mesa, " + // 10
				" prod_pai, " + // 11
				" variacao, " + // 12
				" seq_peso," + // 13
				" id_pizza, " + // 14
				" cod_pizza, " + // 15
				" qtd_pizza," + //16
				" id_integracao_cardapio, " + //17
				" data, " + //18
				" hora)" + // 19
				"VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,current_date, current_time)";
			
			try(Connection conn = connectionFactory.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sqlInsertCombosItem))
			{
				
				stmt.setInt(1, comanda.getNumero());
				// salvando codigo do combo (codprod)
				stmt.setString(2, combo.getCodigo());
				// salvando codigo do combo (codprod_2)
				stmt.setString(3, combo.getCodigoPesquisa());
				// salvando descricao do combo
				stmt.setString(4, combo.getDescricao());
				// salvando quantidade do combo
				stmt.setDouble(5, combo.getQtd());
				// salvando valor unitario do combo
				stmt.setBigDecimal(6, combo.getVrUnit());
				// salvando atendente
				
				AtendenteBBIFood atendente = comanda.getAtendente();
				stmt.setString(7, atendente.getCodigo());
				// salvando id_ingre
				stmt.setInt(8, itemPedido.getIdIngre());
				// salvando id do produto (seq_item)
				stmt.setInt(9, generator.gerarIdItem());
				// salvando mesa
				stmt.setInt(10, comanda.getMesa());
				// salvando produto pai
				stmt.setInt(11, itemPedido.getSeqItem());
				// salvando variacoes
				
				AdicionaisBBIFood adicionaisCombo = combo.getAdicionais();
				stmt.setString(12, getVariacoesFormatado(adicionaisCombo));
				
				// salvando seq_peso
				stmt.setInt(13, ++seqPeso);
				stmt.setInt(14, 0);
				stmt.setString(15, "");
				stmt.setInt(16, 0);
				stmt.setString(17, combo.getId());
				stmt.executeUpdate();
			}
			
		}
	}
	
	public String getVariacoesFormatado(AdicionaisBBIFood adicionais) 
	{
		if(adicionais == null) {
			return "";
		}
		List<VariacaoBBIFood> variacoes = adicionais.getVariacoes();
		if(CollectionsUtils.isNullOrEmpty(variacoes)) {
			return "";
		}
		StringBuilder sb = new StringBuilder();
		Iterator<VariacaoBBIFood> iterator = variacoes.iterator();
		while(iterator.hasNext())
		{
			VariacaoBBIFood variacao = iterator.next();
			sb.append(variacao.getCodigo());
			if(iterator.hasNext())
				sb.append("|");
		}
		return sb.toString();
	}
	
	public Map<Integer, List<Item>> getItensMontagemPorComanda(int comanda, Map<Integer, List<Variacao>> mapVariacoes) throws SQLException
	{
		String selectCombos = 
			" SELECT DISTINCT " + 
			" item.seq_item, " + 
			" item.codprod_2 AS codigo_pesquisa, " + 
			" item.descricao AS descricao_combo, " + 
			" item.qtd AS quantidade_combo, " + 
			" item.vr_unit, " + 
			" COALESCE(item.variacao, '') AS variacao, " + 
			" item.prod_pai AS seq_pai, " + 
			" gc.tipo_valor " + 
			" FROM tbcomanda_item item " + 
			" INNER JOIN tbgrupo_combo_item gci ON gci.codigo_produto = item.codprod " + 
			" INNER JOIN tbgrupo_combo gc ON gc.codigo = gci.codigo_grupo " + 
			" LEFT JOIN tbprod_variacao v ON item.codprod = v.cod_prod "  + 
			" WHERE item.comanda = " + comanda + 
			" AND item.prod_pai IS NOT NULL " + 
			" AND gc.codigo IN " + 
			" (" + 
			"    SELECT tbg.codigo_grupo FROM tbprod_grupo_combo tbg WHERE tbg.codigo_produto IN " + 
			"    (" +
			"        SELECT tbi.codprod " +
			"        FROM tbcomanda_item tbi " +
			"        WHERE tbi.seq_item = item.prod_pai" +
			"    )" + 
			" )" + 
			" ORDER BY seq_pai, item.seq_peso, descricao_combo ";
		
		Map<Integer, List<Item>> mapItensCombo = new HashMap<>();
		
		try(Connection conn = connectionFactory.getConnection();
			PreparedStatement stmt = conn.prepareStatement(selectCombos);
			ResultSet rs = stmt.executeQuery())
		{
			MapAddHelper<Integer, Item> mapAddHelper = new MapAddHelper<>(rs);
			while(rs.next()) 
			{
				int seqItem = rs.getInt("seq_item");
				int seqPai = rs.getInt("seq_pai");
				
				Item itemCombo = new Item()
						.setCodigo(String.valueOf(seqItem))
						.setCodigoPesquisa(rs.getString("codigo_pesquisa"))
						.setDescricao(rs.getString("descricao_combo"))
						.setQtd(rs.getInt("quantidade_combo"))
						.setVrUnit(BigDecimal.valueOf(rs.getDouble("vr_unit")));
				
				Adicionais adicionais = new Adicionais();
				String variacoes = rs.getString("variacao");
				if(!StringUtils.isNullOrEmpty(variacoes)) 
				{
					adicionais.setVariacoes(mapVariacoes.get(seqItem));
				}
				itemCombo.setAdicionais(adicionais);
				
				mapAddHelper.addToMap(seqPai, itemCombo);
			}
			mapItensCombo = mapAddHelper.getMap();
			return mapItensCombo;
		}
		
	}
}