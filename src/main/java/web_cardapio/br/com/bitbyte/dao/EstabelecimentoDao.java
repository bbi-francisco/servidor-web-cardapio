package web_cardapio.br.com.bitbyte.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import web_cardapio.br.com.bitbyte.connection.ConnectionFactory;
import web_cardapio.br.com.bitbyte.models.Estabelecimento;

@Repository
public class EstabelecimentoDao
{
	@Autowired
	private ConnectionFactory connectionFactory;
	
	public Estabelecimento getEstabelecimento() throws SQLException {
		
		String sql = 
				" SELECT " +
				" historia, " +
				" url_video, " +
				" cnpj " +
				" FROM tbemp ";
		
		try(Connection conn = connectionFactory.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery())
		{
			if(rs.next()) {
				
				Estabelecimento estabelecimento = new Estabelecimento();
				estabelecimento.setHistoria(rs.getString("historia"));
				estabelecimento.setUrlVideo(rs.getString("url_video"));
				estabelecimento.setCnpj(rs.getString("cnpj"));
				return estabelecimento;
			}
		}
		return null;
	}	
}