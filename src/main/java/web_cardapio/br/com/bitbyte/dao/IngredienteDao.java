package web_cardapio.br.com.bitbyte.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import web_cardapio.br.com.bitbyte.connection.ConnectionFactory;
import web_cardapio.br.com.bitbyte.interfaces.ItemComandaIngrediente;
import web_cardapio.br.com.bitbyte.models.Ingrediente;
import web_cardapio.br.com.bitbyte.models.bbifood.AdicionaisBBIFood;
import web_cardapio.br.com.bitbyte.models.bbifood.ComandaBBIFood;
import web_cardapio.br.com.bitbyte.models.bbifood.IngredienteBBIFood;
import web_cardapio.br.com.bitbyte.utils.MapAddHelper;


@Repository
public class IngredienteDao {
	
	@Autowired
	private ConnectionFactory connectionFactory;
	
	public List<Ingrediente> getIngredientes() throws SQLException
	{
		List<Ingrediente> ingredientes = new ArrayList<Ingrediente>();
		
		String sql = 
				"SELECT DISTINCT " + 
				"ing.codigo, " + 
				"ing.descricao, " + 
				"ing.acres, " + 
				"ing.diminuir, " + 
				"prod_ing.codigo_prod, " + 
				"prod_ing.tipo " + 
				"FROM tbingrediente ing " + 
				"INNER JOIN tbprod_ingrediente prod_ing ON prod_ing.codigo_ingre = ing.codigo " + 
				"ORDER BY ing.descricao";
		
		try(
			Connection conn = connectionFactory.getConnection();
			PreparedStatement pst = conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery())
		{
			while(rs.next()) 
			{
				Ingrediente ingrediente = new Ingrediente();
				ingrediente.setCodigo(rs.getString("codigo"));
				ingrediente.setDescricao(rs.getString("descricao"));
				ingrediente.setCodigoPai(rs.getString("codigo_prod"));
				
				String tipo = rs.getString("tipo");
				ingrediente.setTipo(tipo);
				
				if(ingrediente.isAcrescentar()) 
					ingrediente.setVrUnit(BigDecimal.valueOf(rs.getDouble("acres")));
				else 
					ingrediente.setVrUnit(BigDecimal.valueOf(rs.getDouble("diminuir")));
				
				ingredientes.add(ingrediente);
			}
			return ingredientes;
		}
	}
	
	public void salvarIngredientes(ItemComandaIngrediente itemComandaIngrediente, ComandaBBIFood comanda) throws SQLException
	{
		AdicionaisBBIFood adicionais = itemComandaIngrediente.getAdicionais();
		List<IngredienteBBIFood> ingredientes = adicionais.getIngredientes();
		
		// Inserindo ingrediente na tabela
		String sqlInsertIngreAcresc = 
			" INSERT INTO tbcomanda_ingrediente (" +
			" comanda, " +
			" seq_item, " +
			" id, " +
			" ingrediente, " +
			" tipo_a_d, " +
			" qtd)" +
			" VALUES(?, ?, ?, ?, ?, ?)";
		
		try(Connection conn = connectionFactory.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sqlInsertIngreAcresc))
		{
			for(IngredienteBBIFood ingrediente : ingredientes)
			{
				stmt.setInt(1, comanda.getNumero());
				stmt.setInt(2, itemComandaIngrediente.getSeqItem());
				stmt.setInt(3, itemComandaIngrediente.getIdIngre());
				stmt.setString(4, ingrediente.getCodigo());
				stmt.setString(5, ingrediente.getTipo());
				int quantidade = ingrediente.getQtd();
				stmt.setInt(6, quantidade != 0 ? quantidade : 1 );
				stmt.executeUpdate();
			}
		}
	}
	
	public List<Ingrediente> getIngredientesPorComanda(String comanda) throws SQLException
	{
		List<Ingrediente> ingredientes = new ArrayList<>();
		String sqlSelectIngredientes = 
			" SELECT " + 
			" ing.descricao, " + 
			" com_ing.id AS id_prod, " +
			" ing.acres, " + 
			" ing.diminuir, " + 
			" com_ing.qtd AS qtd_ing, " + 
			" com_ing.tipo_a_d AS tipo " + 
			" FROM tbcomanda_ingrediente com_ing " + 
			" INNER JOIN tbingrediente ing " + 
			" ON ing.codigo = com_ing.ingrediente " + 
			" WHERE comanda = " + comanda;
		
		try(Connection conn = connectionFactory.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sqlSelectIngredientes);
			ResultSet rs = stmt.executeQuery())
		{
			while(rs.next()) 
			{
				Ingrediente ingrediente = new Ingrediente();
				ingrediente.setDescricao(rs.getString("descricao"));
				ingrediente.setTipo(rs.getString("tipo"));
				ingrediente.setCodigoPai(rs.getString("id_prod"));
				
				int quantidade = rs.getInt("qtd_ing");
				ingrediente.setQtd(quantidade != 0 ? quantidade : 1);
				
				if(ingrediente.isAcrescentar()) 
					ingrediente.setVrUnit(BigDecimal.valueOf(rs.getDouble("acres")));
				else 
					ingrediente.setVrUnit(BigDecimal.valueOf(rs.getDouble("diminuir")));
				
				ingredientes.add(ingrediente);
			}
			return ingredientes;
		}
	}
	
	public Map<Integer, List<Ingrediente>> getMapIngredientesPorComanda(int comanda) throws SQLException
	{
		Map<Integer, List<Ingrediente>> ingredientes = new HashMap<>();
		
		String sqlSelectIngredientes = 
			" SELECT " + 
			" ing.descricao, " + 
			" com_ing.id AS id_ingre, " + 
			" com_ing.qtd AS qtd_ing, " + 
			" com_ing.tipo_a_d AS tipo, " + 
			" CASE com_ing.tipo_a_d WHEN 'A' THEN ing.acres ELSE ing.diminuir END AS vr_unit_ingre " + 
			" FROM tbcomanda_ingrediente com_ing " + 
			" INNER JOIN tbingrediente ing " + 
			" ON ing.codigo = com_ing.ingrediente " + 
			" WHERE comanda = " +comanda + 
			" ORDER BY com_ing.id, ing.descricao ";
		
		try(Connection conn = connectionFactory.getConnection())
		{
			PreparedStatement stmt = conn.prepareStatement(sqlSelectIngredientes);
			ResultSet rs = stmt.executeQuery();
			
			MapAddHelper<Integer, Ingrediente> mapAddHelper = new MapAddHelper<>(rs);
			while(rs.next()) 
			{
				int idIngre = rs.getInt("id_ingre");
				Ingrediente ingrediente = new Ingrediente();
				ingrediente.setCodigoPai(String.valueOf(idIngre));
				ingrediente.setDescricao(rs.getString("descricao"));
				ingrediente.setTipo(rs.getString("tipo"));
				
				int quantidade = rs.getInt("qtd_ing");
				ingrediente.setQtd(quantidade != 0 ? quantidade : 1);
				ingrediente.setVrUnit(rs.getBigDecimal("vr_unit_ingre"));
				
				mapAddHelper.addToMap(idIngre, ingrediente);
			}
			ingredientes = mapAddHelper.getMap();
			return ingredientes;
		}
	}
}