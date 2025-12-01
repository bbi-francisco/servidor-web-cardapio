package web_cardapio.br.com.bitbyte.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	
	public Questionario selectQuestionario() throws SQLException 
	{
		
		Map<Integer, Pergunta> perguntas = new HashMap<>();
		
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
				if(!perguntas.containsKey(idPergunta)) 
				{
					Pergunta pergunta = createPergunta(rs);
					perguntas.put(idPergunta, pergunta);
				}
				
				Pergunta p = perguntas.get(idPergunta);
				Alternativa alternativa = createAlternativa(rs);
				p.getAlternativas().add(alternativa);
			}
			return new Questionario()
					.setPerguntas(new ArrayList<>(perguntas.values()));
		}
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
				.setOrdem(rs.getInt("ordem_pergunta"))
				.setAlternativas(new ArrayList<>());
		return pergunta;
	}
}
