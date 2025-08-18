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
import web_cardapio.br.com.bitbyte.models.Atendente;

@Repository
public class AtendenteDao {
	
	@Autowired
	private ConnectionFactory connectionFactory;
	
	public Atendente getAtendenteByUsuarioAndSenha(String usuario, String senha) throws SQLException {
		
		String sqlSelectAtendente = 
			" SELECT " +
			" f.codigo, " +
			" f.usuario, " +
			" f.senha " +
			" FROM " +
			" tbfunc f " +
			" WHERE f.usuario = ? AND f.senha = ? ";
		
		try(Connection conn = connectionFactory.getConnection();
			PreparedStatement pst = conn.prepareStatement(sqlSelectAtendente);)
		{
			pst.setString(1, usuario);
			pst.setString(2, senha);
			
			ResultSet rs = pst.executeQuery();
			
			if (rs.next()) 
			{
				return new Atendente()
						.setUsuario(rs.getString("usuario"))
						.setCodigo(rs.getString("codigo"))
						.setSenha(rs.getString("senha"));
			}
			return null;
		}
		
	}

	public Atendente getAtendente(String codigoAtendente) throws SQLException
	{
		codigoAtendente = String.format("%05d", Integer.parseInt(codigoAtendente));
		
		String sqlSelectAtendente = 
				" SELECT " +
				" codigo, " +
				" usuario, " +
				" senha " +
				" FROM " +
				" tbfunc " +
				" WHERE codigo = '" + codigoAtendente + "'";
		
		try(Connection conn = connectionFactory.getConnection();
			PreparedStatement pst = conn.prepareStatement(sqlSelectAtendente);
			ResultSet rs = pst.executeQuery()) 
		{
			if (rs.next()) 
			{
				return new Atendente()
						.setUsuario(rs.getString("usuario"))
						.setCodigo(rs.getString("codigo"))
						.setSenha(rs.getString("senha"));
			}
			return null;
		}
	}
	
	public List<Atendente> getAtendentes() throws SQLException
	{
		List<Atendente> atendentes = new ArrayList<>();
		String sqlSelectAtendentes =
				" SELECT " +
				" codigo " +
				" usuario, " +
				" senha " +
				" FROM " +
				" tbfunc ";
		
		try(Connection conn = connectionFactory.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sqlSelectAtendentes);
			ResultSet rs = stmt.executeQuery()) 
		{
			while(rs.next()) 
			{
				Atendente atendente = new Atendente();
				atendente.setCodigo(rs.getString("codigo"));
				atendente.setUsuario(rs.getString("usuario"));
				atendente.setSenha(rs.getString("senha"));
				atendentes.add(atendente);
			}
			return atendentes;
		}
	}
}