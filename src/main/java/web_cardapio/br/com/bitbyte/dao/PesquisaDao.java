package web_cardapio.br.com.bitbyte.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import web_cardapio.br.com.bitbyte.connection.ConnectionFactory;
import web_cardapio.br.com.bitbyte.models.RespostasPesquisa;

@Repository
public class PesquisaDao {
	
	@Autowired
	private ConnectionFactory connectionFactory;
	
	public void insertResultados(RespostasPesquisa respostasPesquisa) throws SQLException 
	{
		String sql = 
				" INSERT INTO tbpesquisa ( " +
				" id_pesquisa, " +
				" cliente, " +
				" telefone, " +
				" email, " +
				" cidade, " +
				" nascimento, " +
				" comanda, " +
				" observacao, " +
				" data, " +
				" hora ) " +
				" VALUES (?,?,?,?,?,?,?,?, current_date, current_time) ";
		
		try(Connection conn = connectionFactory.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql))
		{
			stmt.setInt(1, respostasPesquisa.getIdPesquisa());
			stmt.setString(2, "");
			stmt.setString(3, "");
			stmt.setString(4, "");
			stmt.setString(5, "");
			stmt.setString(6, "");
			stmt.setInt(7, respostasPesquisa.getNumeroComanda());
			stmt.setString(8,  "");
			stmt.executeUpdate();
		}
	}

}
