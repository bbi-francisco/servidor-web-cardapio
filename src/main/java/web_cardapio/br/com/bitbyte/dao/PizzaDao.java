package web_cardapio.br.com.bitbyte.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import web_cardapio.br.com.bitbyte.connection.ConnectionFactory;
import web_cardapio.br.com.bitbyte.interfaces.Quantificavel;
import web_cardapio.br.com.bitbyte.models.Adicionais;
import web_cardapio.br.com.bitbyte.models.Ingrediente;
import web_cardapio.br.com.bitbyte.models.Item;
import web_cardapio.br.com.bitbyte.models.Rational;
import web_cardapio.br.com.bitbyte.models.bbifood.AdicionaisBBIFood;
import web_cardapio.br.com.bitbyte.models.bbifood.ComandaBBIFood;
import web_cardapio.br.com.bitbyte.models.bbifood.ItemBBIFood;
import web_cardapio.br.com.bitbyte.sqlcommons.Generator;
import web_cardapio.br.com.bitbyte.utils.MapAddHelper;

@Repository
public class PizzaDao {
	
	@Autowired
	private ConnectionFactory connectionFactory;
	
	@Autowired
	private IngredienteDao ingredienteDao;
	
	@Autowired
	private Generator generator;
	
	public void insertPizzaIngredientes(ComandaBBIFood comanda, ItemBBIFood itemPedido) throws SQLException {

		String sqlInsertPizza = 
				" INSERT INTO tbcomanda_pizza ( " +
				" id_pizza, " +
				" seq, " +
				" codprod, "+
				" qtd, " +
				" id_ingre ) " +
				" VALUES (?, ?, ?, ?, ?)";
		
		int seq = 0;
		try(Connection connection = connectionFactory.getConnection();
			PreparedStatement stmt = connection.prepareStatement(sqlInsertPizza))
		{
			AdicionaisBBIFood adicionais = itemPedido.getAdicionais();
			List<ItemBBIFood> sabores = adicionais.getSabores();
			for(ItemBBIFood sabor : adicionais.getSabores())
			{
				AdicionaisBBIFood adicionaisSabor = sabor.getAdicionais();
				if(!adicionaisSabor.getIngredientes().isEmpty()) {
					sabor.setIdIngre(generator.gerarIdIngre());
					sabor.setSeqItem(generator.getSeqItem());
					ingredienteDao.salvarIngredientes(sabor, comanda);
				}
				
				stmt.setInt(1, itemPedido.getIdPizza());
				stmt.setInt(2, ++seq);
				stmt.setString(3, sabor.getCodigo());
				
				double qtd = (double) sabor.getQtd() / 
						getTotalQuantity(sabores);
				
				stmt.setDouble(4, qtd);
				stmt.setInt(5, sabor.getIdIngre());
				stmt.executeUpdate();
			}
		}
	}
	
	public Map<Integer, List<Item>> getSabores(Map<Integer, List<Ingrediente>> mapIngredientes) throws SQLException
	{
		String sql = 
				" SELECT " + 
				" p.descricao, " + 
				" p.codigo, " + 
				" com_piz.id_pizza, " + 
				" com_piz.qtd AS qtd_pizza, " + 
				" com_item.vr_unit AS vr_unit, " + 
				" com_piz.id_ingre " + 
				" FROM tbprod p " + 
				" LEFT JOIN tbcomanda_pizza com_piz ON p.codigo = com_piz.codprod " + 
				" LEFT JOIN tbcomanda_item com_item ON com_item.id_pizza = com_piz.id_pizza " + 
				" WHERE p.codigo = com_piz.codprod " + 
				" GROUP BY p.descricao, p.codigo, com_piz.id_pizza, com_piz.qtd, vr_unit, com_piz.id_ingre " +
				" ORDER BY com_piz.id_pizza";
		
		try(Connection connection = connectionFactory.getConnection();
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery())
		{
			Map<Integer, List<Item>> mapMesclaveis = new HashMap<>();
			MapAddHelper<Integer, Item> mapAddHelper = new MapAddHelper<>(rs);
			
			while(rs.next()) 
			{
				Item item = new Item();
				Adicionais adicionais = new Adicionais();
				
				item.setCodigo(rs.getString("codigo"));
				item.setDescricao(rs.getString("descricao"));
				item.setVrUnit(rs.getBigDecimal("vr_unit"));
				
				double qtdPizza = rs.getDouble("qtd_pizza");
				item.setQtd(new Rational(qtdPizza).numerator());
				
				int idIngre = rs.getInt("id_ingre");
				
				adicionais.setIngredientes(mapIngredientes.get(idIngre));
				
				item.setAdicionais(adicionais);
				int idPizza = rs.getInt("id_pizza");
				mapAddHelper.addToMap(idPizza, item);
			}
			mapMesclaveis = mapAddHelper.getMap();
			return mapMesclaveis;
		}
	}
	
	private int getTotalQuantity(List<? extends Quantificavel> quantificaveis) {
		int qtdTotal = 0;
		for(Quantificavel obj : quantificaveis) {
			qtdTotal += obj.getQtd();
		}
		return qtdTotal;
	}
}
