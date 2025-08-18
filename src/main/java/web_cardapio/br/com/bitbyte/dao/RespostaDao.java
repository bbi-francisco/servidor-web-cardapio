package web_cardapio.br.com.bitbyte.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import web_cardapio.br.com.bitbyte.connection.ConnectionFactory;
import web_cardapio.br.com.bitbyte.models.Resposta;
import web_cardapio.br.com.bitbyte.models.RespostasPesquisa;

@Repository
public class RespostaDao {
	
	@Autowired
	private ConnectionFactory connectionFactory;
	
	public void salvarRespostas(RespostasPesquisa respostas) throws SQLException 
	{
		String sql = 
				" INSERT INTO tbrespostas ( " +
				" id_pesquisa, " +
				" id_pergunta, " +
				" alternativa ) " +
				" VALUES(?, ?, ?) ";
		
		try(Connection conn = connectionFactory.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql))
		{
			for(Resposta resposta : respostas.getRespostas()) 
			{
				stmt.setInt(1, respostas.getIdPesquisa());
				stmt.setInt(2, resposta.getIdPergunta());
				stmt.setInt(3, resposta.getAlternativa());
				stmt.executeUpdate();
			}
		}
	}

}
