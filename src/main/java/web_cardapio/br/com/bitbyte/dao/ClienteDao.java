package web_cardapio.br.com.bitbyte.dao;

import web_cardapio.br.com.bitbyte.connection.ConnectionFactory;
import web_cardapio.br.com.bitbyte.models.Cliente;
import web_cardapio.br.com.bitbyte.models.Endereco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ClienteDao {
	
	@Autowired
	private ConnectionFactory connectionFactory;
	
	public Cliente selectClienteFromIdTag(String idTag) throws SQLException {
		
		String sql = 
				" SELECT " +
				" codigo, " +
				" nome, " +
				" cel, " +
				" cgc, " +
				" idcanal, " +
				" email, " +
				" endereco, " +
				" data_nascimento " + 
				" FROM tbcli cli" +
				" WHERE cli.idtag = '" +idTag + "'";
		
		try(Connection conn = connectionFactory.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery())
		{
			if(rs.next()) {
				
				Endereco endereco = new Endereco().setEndereco(rs.getString("endereco"));
				return new Cliente()
						.setDataNascimento(rs.getString("data_nascimento"))
						.setCodigo(rs.getString("codigo"))
						.setNome(rs.getString("nome"))
						.setTelefone(rs.getString("cel"))
						.setCpf(rs.getString("cgc"))
						.setIdCanal(rs.getString("idcanal"))
						.setEmail(rs.getString("email"))
						.setEndereco(endereco);
			}
		}
		return null;
	}

}
