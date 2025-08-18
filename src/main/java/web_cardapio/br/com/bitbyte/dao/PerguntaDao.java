package web_cardapio.br.com.bitbyte.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import web_cardapio.br.com.bitbyte.connection.ConnectionFactory;
import web_cardapio.br.com.bitbyte.models.Alternativa;
import web_cardapio.br.com.bitbyte.models.Pergunta;
import web_cardapio.br.com.bitbyte.models.Questionario;

@Repository
public class PerguntaDao {
	
	@Autowired
	private ConnectionFactory connectionFactory;
	
	private List<Pergunta> perguntas = new ArrayList<>();
	private List<Alternativa> alternativas = new ArrayList<>();
	private int lastIdPergunta = -1;
	private Pergunta lastPergunta = null;
	
	public Questionario selectQuestionario() throws SQLException {
		
		String sql = 
				" SELECT " + 
				" p.id_pergunta AS id_pergunta, " + 
				" p.pergunta AS descricao_pergunta, " + 
				" p.ordem AS ordem_pergunta, " +
				" a.descricao AS descricao_alternativa, " + 
				" a.alternativa AS id_alternativa " +
				" FROM tbperguntas p " + 
				" LEFT JOIN tbalternativas a ON p.id_pergunta = a.id_pergunta " +
				" WHERE p.ativo = 'S' " +
				" ORDER BY p.ordem, a.alternativa ";
		
		try(Connection conn = connectionFactory.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery())
		{
			while(rs.next()) 
			{
				int idPergunta = rs.getInt("id_pergunta"); 
				if(idPergunta != lastIdPergunta) 
				{
					fetchPergunta(lastPergunta);
					newPerguntaContext(rs);
				}
				
				Alternativa alternativa = createAlternativa(rs);
				alternativas.add(alternativa);
			}
			fetchPergunta(lastPergunta);
			return new Questionario().setPerguntas(perguntas);
		}
	}
	
	private void newPerguntaContext(ResultSet rs) throws SQLException 
	{
		lastPergunta = createPergunta(rs);
		lastIdPergunta = rs.getInt("id_pergunta"); 
		alternativas = new ArrayList<>();
	}
	
	private Alternativa createAlternativa(ResultSet rs) throws SQLException {
		Alternativa alternativa = new Alternativa()
				.setDescricao(rs.getString("descricao_alternativa"))
				.setCodigo(rs.getInt("id_alternativa"));
		return alternativa;
	}
	
	private Pergunta createPergunta(ResultSet rs) throws SQLException {
		Pergunta pergunta = new Pergunta()
				.setPergunta(rs.getString("descricao_pergunta"))
				.setId(rs.getInt("id_pergunta"))
				.setOrdem(rs.getInt("ordem_pergunta"));
		return pergunta;
	}
	
	private void fetchPergunta(Pergunta pergunta) {
		if(pergunta != null) {
			pergunta.setAlternativas(alternativas);
			perguntas.add(pergunta);
		}
	}
}
