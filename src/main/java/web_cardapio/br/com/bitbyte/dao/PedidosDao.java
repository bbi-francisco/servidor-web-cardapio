package web_cardapio.br.com.bitbyte.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.gson.Gson;

import web_cardapio.br.com.bitbyte.connection.ConnectionFactory;
import web_cardapio.br.com.bitbyte.format.CodigosFormatter;
import web_cardapio.br.com.bitbyte.models.Adicionais;
import web_cardapio.br.com.bitbyte.models.AdicionaisComanda;
import web_cardapio.br.com.bitbyte.models.Comanda;
import web_cardapio.br.com.bitbyte.models.Item;
import web_cardapio.br.com.bitbyte.models.PizzaComponent;
import web_cardapio.br.com.bitbyte.models.bbifood.AdicionaisBBIFood;
import web_cardapio.br.com.bitbyte.models.bbifood.AtendenteBBIFood;
import web_cardapio.br.com.bitbyte.models.bbifood.ComandaBBIFood;
import web_cardapio.br.com.bitbyte.models.bbifood.IngredienteBBIFood;
import web_cardapio.br.com.bitbyte.models.bbifood.ItemBBIFood;
import web_cardapio.br.com.bitbyte.models.bbifood.PedidoBBIFood;
import web_cardapio.br.com.bitbyte.models.bbifood.VariacaoBBIFood;
import web_cardapio.br.com.bitbyte.services.AdicionaisComandaService;
import web_cardapio.br.com.bitbyte.sqlcommons.Generator;
import web_cardapio.br.com.bitbyte.utils.ListUtils;
import web_cardapio.br.com.bitbyte.utils.ItemPriceCalculation;
import web_cardapio.br.com.bitbyte.utils.StringUtils;

@Repository
public class PedidosDao {
	
	private static final Logger log = Logger.getLogger(PedidosDao.class);
	
	@Autowired
	private ConnectionFactory connectionFactory;
	
	@Autowired
	private MontagemDao montagemDao;
	
	@Autowired
	private Generator generator;
	
	@Autowired
	private PizzaDao pizzaDAO;
	
	@Autowired
	private ImpressaoDao impressaoDao;
	
	@Autowired
	private ComandaItemDao comandaItemDao;
	
	@Autowired
	private IngredienteDao ingredienteDao;
	
	@Autowired
	private AdicionaisComandaService adicionaisComandaService;
	
	public void insertPedido(PedidoBBIFood pedido, boolean atualizaStatusImpressao) throws SQLException 
	{
		List<ItemBBIFood> itensPedido = filtrarPedidosInseridos(pedido);
		
		ComandaBBIFood comanda = pedido.getComanda();
		
		int seqPeso = comandaItemDao.getSeqPeso(comanda.getNumero());
		
		for(ItemBBIFood itemPedido : itensPedido)
		{
			if(itemPedido.isAcessorio()) {
				impressaoDao.salvarImpressao(itemPedido, comanda);
				continue;
			}
			AdicionaisBBIFood adicionais = itemPedido.getAdicionais();
			if(ListUtils.hasItens(adicionais.getItensMontagem())) 
			{
				montagemDao.insertMontagem(pedido, itemPedido);
				continue;
			}
			List<VariacaoBBIFood> variacoes = adicionais.getVariacoes();
			List<IngredienteBBIFood> ingredientes = adicionais.getIngredientes();
			
			itemPedido.setSeqItem(generator.gerarIdItem());
			
			String sqlItens = 
				" INSERT INTO tbcomanda_item ("
				+ " comanda, " // 1
				+ " seq_item, " // 2
				+ " codprod, " // 3
				+ " codprod_2, " // 4
				+ " descricao, " // 5
				+ " qtd, " // 6
				+ " vr_unit, " // 7
				+ " funcionario, " // 8
				+ " mesa, " // 9
				+ " seq_peso, " // 10
				+ " id_ingre, " // 11
				+ " variacao, " // 12
				+ " id_pizza, " //13
				+ " cod_pizza, " //14
				+ " qtd_pizza, " //15
				+ " id_integracao_cardapio, " // 16
				+ " data, " // 17
				+ " hora) " //18
				+ " VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?, current_date, current_time)";

			try(Connection conn = connectionFactory.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sqlItens))
			{
				stmt.setInt(1, comanda.getNumero());
				stmt.setInt(2, itemPedido.getSeqItem());
				stmt.setString(3, itemPedido.getCodigo());
				stmt.setString(4, itemPedido.getCodigoPesquisa());
				stmt.setString(5, itemPedido.getDescricao());
				stmt.setDouble(6, itemPedido.getQtd());
				
				BigDecimal valorIngre = new ItemPriceCalculation()
						.getValorIngredientes(itemPedido);
				
				BigDecimal valorSabores = new ItemPriceCalculation()
						.getValorAdicionaisSabores(itemPedido);
				
				BigDecimal valor = valorIngre.add(itemPedido.getVrUnit()).add(valorSabores);
				stmt.setBigDecimal(7, valor);
				
				
				String codigoAtendente = getCodigoAtendente(comanda.getAtendente());
				stmt.setString(8, codigoAtendente);
				
				stmt.setInt(9, comanda.getMesa());
				stmt.setObject(10, ++seqPeso);
				
				if(ListUtils.isNullOrEmpty(ingredientes))
				{
					stmt.setInt(11, 0);
				}
				else 
				{
					itemPedido.setIdIngre(generator.gerarIdIngre());
					stmt.setInt(11, itemPedido.getIdIngre());
					ingredienteDao.salvarIngredientes(itemPedido, comanda);
				}
	
				CodigosFormatter<String> codigoSlashFormatter = new CodigosFormatter<>();
				codigoSlashFormatter.appendLast(false);
				codigoSlashFormatter.setSeparator("|");
				
				String variacoesFormatted = variacoes.isEmpty() ? "" : codigoSlashFormatter.format(variacoes);
				stmt.setString(12, variacoesFormatted);
				
				if(!ListUtils.isNullOrEmpty(adicionais.getSabores()))
				{
					int idPizza =  Integer.parseInt(generator.gerarId(Generator.PIZZA));
					itemPedido.setIdPizza(idPizza);
					stmt.setInt(13, idPizza);
					pizzaDAO.insertPizzaIngredientes(comanda, itemPedido);
				} else {
					stmt.setInt(13, 0);
				}
				
				PizzaComponent pizzaComponent = new PizzaComponent(adicionais.getSabores());
				stmt.setString(14, pizzaComponent.getCodigosPizzas());
				stmt.setInt(15, pizzaComponent.getQuantidadePizza());
				
				stmt.setString(16, itemPedido.getId());
				
				stmt.executeUpdate();
				log.info("Pedido inserido: " + new Gson().toJson(pedido));
				
				impressaoDao.salvarImpressao(itemPedido, comanda);
			}
		}
		if(atualizaStatusImpressao) 
		{
			impressaoDao.atualizarStatusImpressao(comanda.getNumero());
		}
	}
	
	private String getCodigoAtendente(AtendenteBBIFood atendente) {
		if(atendente == null) {
			return "";
		}
		
		return atendente.getCodigo();
	}
//	
//	private void imprimirItemPedido(ItemBBIFood itemPedido, ComandaBBIFood comanda) throws SQLException {
//		impressaoDao.salvarImpressao(itemPedido, comanda);
//		impressaoDao.atualizarStatusImpressao(itemPedido.getSeqItem());
//	}
	
	public List<Item> getItensPedido(Comanda comanda) throws SQLException
	{
		int numeroComanda = comanda.getNumero();
		
		String sqlConsultaPedidos = 
				" SELECT " + 
				" item.codprod, " + 
				" item.codprod_2, " + 
				" item.descricao AS descricao_prod, " + 
				" item.qtd AS qtd_prod, " + 
				" item.vr_unit AS vr_unit, " + 
				" item.id_ingre, " + 
				" COALESCE(item.variacao, '') AS variacao, " + 
				" item.seq_item, " + 
				" item.prod_pai, " + 
				" item.id_pizza, " + 
				" p.montagem " + 
				" FROM tbcomanda_item item " + 
				" INNER JOIN tbprod p ON item.codprod = p.codigo " + 
				" WHERE item.comanda = " +numeroComanda+ "  AND prod_pai IS null " + 
				" ORDER BY item.data DESC, item.hora DESC, item.descricao ASC";
		
		List<Item> pedidos = new ArrayList<>();
		AdicionaisComanda adicionaisComanda = adicionaisComandaService.consultar(comanda);
		
		try(Connection conn = connectionFactory.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sqlConsultaPedidos);
			ResultSet rs = stmt.executeQuery())
		{
			while(rs.next())
			{
				Item itemPedido = new Item();
				itemPedido.setCodigo(rs.getString("codprod"));
				itemPedido.setCodigoPesquisa(rs.getString("codprod_2"));
				itemPedido.setDescricao(rs.getString("descricao"));
				itemPedido.setQtd(rs.getInt("qtd_prod"));
				itemPedido.setVrUnit(BigDecimal.valueOf(rs.getDouble("vr_unit")));
				
				Adicionais adicionais = new Adicionais();
				itemPedido.setAdicionais(adicionais);
				
				int seqItem = rs.getInt("seq_item");
				boolean montagem = "S".equals(rs.getString("montagem"));
				if(montagem) 
				{
					adicionais.setItensMontagem(adicionaisComanda.getItensMontagem(seqItem));
					pedidos.add(itemPedido);
					continue;
				}
				
				int idPizza = rs.getInt("id_pizza");
				if(idPizza != 0) {
					adicionais.setSabores(adicionaisComanda.getSabores(idPizza));
				}
				
				String variacoes = rs.getString("variacao");
				if(!StringUtils.isNullOrEmpty(variacoes)) 
				{
					adicionais.setVariacoes(adicionaisComanda.getVariacoes(seqItem));
				}
				
				int idIngre = rs.getInt("id_ingre");
				if(idIngre != 0)
				{
					adicionais.setIngredientes(adicionaisComanda.getIngredientes(idIngre));
				}
				pedidos.add(itemPedido);
			}
			return pedidos;
		}
	}
	
	public List<ItemBBIFood> filtrarPedidosInseridos(PedidoBBIFood pedido) throws SQLException
	{
		List<ItemBBIFood> itens = pedido.getItens();
		if(ListUtils.isNullOrEmpty(itens)) 
		{
			return Collections.emptyList();
		}
		
		List<String> idsExistentes = comandaItemDao.getIdsExistentes(pedido);
		
		return itens.stream().filter(i-> 
			 !ListUtils.getEmptyIfNull(idsExistentes)
			 .contains(i.getId())
			)
			.collect(Collectors.toList());
	}
}
