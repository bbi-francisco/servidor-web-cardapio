package web_cardapio.br.com.bitbyte.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import web_cardapio.br.com.bitbyte.connection.ConnectionFactory;
import web_cardapio.br.com.bitbyte.exceptions.CaixaFechadoException;
import web_cardapio.br.com.bitbyte.models.Caixa;

@Repository
public class CaixaDao
{
	@Autowired
	private ConnectionFactory connectionFactory;
	
	public boolean verificarCaixaAberto() throws SQLException 
	{
		String sqlCaixaAberto = 
			" SELECT " +
			" id " +
			" FROM tbcaixa "+
			" WHERE aberto = 'S'";
		
		try(Connection conn = connectionFactory.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sqlCaixaAberto);
			ResultSet rs = stmt.executeQuery())
		{
			return rs.next();
		}
	}
	
	public List<Caixa> getCaixas() throws SQLException
	{
		List<Caixa> caixas = new ArrayList<>();
		String sqlSelectCaixas = 
				" SELECT " +
				" id, " +
				" aberto " +
				" FROM tbcaixa ";
		
		try(Connection conn = connectionFactory.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sqlSelectCaixas);
			ResultSet rs = stmt.executeQuery())
		{
			while(rs.next()) {
				Caixa caixa = new Caixa();
				caixa.setId(rs.getInt("id"));
				caixa.setAberto("S".equals(rs.getString("aberto")));
				caixas.add(caixa);
			}
			
			return caixas;
		}
	}

}