package web_cardapio.br.com.bitbyte.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;

import web_cardapio.br.com.bitbyte.connection.ConnectionFactory;
import web_cardapio.br.com.bitbyte.format.Format;
import web_cardapio.br.com.bitbyte.models.ValoresComanda;
import web_cardapio.br.com.bitbyte.models.bbifood.AtendenteBBIFood;
import web_cardapio.br.com.bitbyte.models.bbifood.ComandaBBIFood;

public class ComandaRandomDao extends ComandaDao {
	
	private Connection connection;
	private static final Logger log = Logger.getLogger(ComandaRandomDao.class);
	
	public ComandaRandomDao() throws SQLException {
		connection = new ConnectionFactory().getConnection();
	}
	
	@Override
	public void insertOrUpdateComandas(List<ComandaBBIFood> comandas) throws SQLException 
	{
		String sql = 
				" INSERT INTO tbcomanda (" +
				" comanda, " +
				" seq, " +
				" mesa, " +
				" qtd_pessoas, " +
				" maioridade, " + 
				" limite, " +
				" tablet_numero, " +
				" tablet_atendente, " +
				" data_abertura, " + 
				" hora_abertura )" +
				" VALUES (?, ?, ?, ?, ?, ?, ?, ?, current_date, current_time) ";
			
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			for(ComandaBBIFood comanda : comandas) 
			{
				int numeroComanda = comanda.getNumero();
				stmt.setInt(1, numeroComanda);
				stmt.setInt(2, 0);
				stmt.setInt(3, comanda.getMesa());
				stmt.setInt(4, 1);
				stmt.setString(5, "S");
				stmt.setDouble(6, 0);
				stmt.setInt(7, comanda.getIdTablet());
				
				AtendenteBBIFood atendente = comanda.getAtendente();
				stmt.setString(8, Format.casasFormat(atendente.getCodigo(), 5));
				stmt.execute();
				
				comanda.setIdTablet(comanda.getIdTablet());
				
				comanda.setValoresComanda(new ValoresComanda());
				log.info("A comanda " + numeroComanda + " foi aberta com sucesso!".toUpperCase());
			}
	}
	
	public void validaComanda(ComandaBBIFood comanda) throws Exception 
	{
		String sqlSelectComanda = 
				 " SELECT numero " +
				 " FROM tbrandom " +
				 " WHERE numero = " + comanda.getNumero();
		
		PreparedStatement stmt = connection.prepareStatement(sqlSelectComanda);
		ResultSet rs = stmt.executeQuery();
		if(!rs.next()) 
		{
			String sqlInsertComanda = 
				" INSERT INTO tbrandom ( " +
				" numero, " +
				" pedido, " +
				" entrega, " +
				" dtrandom) " +
				" VALUES (?,?,?, current_date)";
			
			stmt = connection.prepareStatement(sqlInsertComanda);
			stmt.setInt(1, comanda.getNumero());
			stmt.setInt(2, comanda.getNumero());
			stmt.setString(3, "");
			insertOrUpdateComandas(Collections.singletonList(comanda));
		}
	}
}
