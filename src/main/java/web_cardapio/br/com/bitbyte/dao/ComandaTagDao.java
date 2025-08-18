package web_cardapio.br.com.bitbyte.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import web_cardapio.br.com.bitbyte.connection.ConnectionFactory;
import web_cardapio.br.com.bitbyte.models.Comanda;
import web_cardapio.br.com.bitbyte.models.ComandaTag;

@Repository
public class ComandaTagDao {
	
	@Autowired
	private ConnectionFactory connectionFactory;
	
	public ComandaTag selectComandaTag(Comanda comanda) throws SQLException 
	{
		int numeroComanda = comanda.getNumero();
		
		String sql = 
				" SELECT " +
				" tag_uid AS tag, " +
				" tag_nr_comanda AS numero_comanda " +
				" FROM tbtag " +
				" WHERE tag_nr_comanda = " +numeroComanda;
		
		try(Connection conn = connectionFactory.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery())
		{
			if(rs.next()) 
			{
				return new ComandaTag()
						.setNumeroComanda(rs.getString("tag_nr_comanda"))
						.setTagUid(rs.getString("tag"));
			}
			return null;
		}
	}
}
