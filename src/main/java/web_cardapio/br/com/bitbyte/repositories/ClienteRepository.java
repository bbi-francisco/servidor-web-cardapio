package web_cardapio.br.com.bitbyte.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import web_cardapio.br.com.bitbyte.connection.ConnectionFactory;
import web_cardapio.br.com.bitbyte.models.Cliente;
import web_cardapio.br.com.bitbyte.models.Endereco;

@Repository
public class ClienteRepository {
	
	@Autowired
	private ConnectionFactory connectionFactory;
	
	public Cliente getCliente(String comanda) throws SQLException 
	{
		String sql = 
				" SELECT " +
				" cli.endereco, " +
				" cli.cid, " +
				" cli.est, " +
				" cli.cep, " +
				" cli.bairro, " +
				" cli.referencia, " +
				" cli.numend, " +
				" cli.complemento, " +
				" cli.codigo, " +
				" cli.nome, " +
				" cli.cgc, " +
				" cli.fone, " +
				" cli.email " +
				" FROM tbcli cli " +
				" LEFT JOIN tbcomanda com ON cli.codigo = com.cliente " +
				" WHERE comanda = " + comanda;
		
		try(Connection connection = connectionFactory.getConnection();
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery())
		{
			if(rs.next()) {
				Endereco endereco = new Endereco()
						.setEndereco(rs.getString("endereco"))
						.setCid(rs.getString("cid"))
						.setEst(rs.getString("est"))
						.setCep(rs.getString("cep"))
						.setBairro(rs.getString("bairro"))
						.setReferencia(rs.getString("referencia"))
						.setNumEnd(rs.getInt("numend"))
						.setComplemento(rs.getString("complemento"));
				
				Cliente cliente = new Cliente()
						.setCodigo(rs.getString("codigo"))
						.setNome(rs.getString("nome"))
						.setCpf(rs.getString("cgc"))
						.setTelefone(rs.getString("fone"))
						.setEmail(rs.getString("email"))
						.setEndereco(endereco);
				
				return cliente;
			}
		}
		return null;
	}
}
