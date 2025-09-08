package web_cardapio.br.com.bitbyte.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import web_cardapio.br.com.bitbyte.connection.ConnectionFactory;
import web_cardapio.br.com.bitbyte.exceptions.BBIException;
import web_cardapio.br.com.bitbyte.exceptions.ComandaSemItensException;
import web_cardapio.br.com.bitbyte.format.Format;
import web_cardapio.br.com.bitbyte.models.Atendente;
import web_cardapio.br.com.bitbyte.models.Comanda;
import web_cardapio.br.com.bitbyte.models.Item;
import web_cardapio.br.com.bitbyte.sqlcommons.Generator;
import web_cardapio.br.com.bitbyte.utils.ListUtils;

@Repository
public class ContaDao {
	
	@Autowired
	private ConnectionFactory connectionFactory;
	
	@Autowired
	private PedidosDao pedidosDao;
	
	@Autowired
	private Generator generator;
	
	public void fecharConta(Comanda comanda) throws BBIException, SQLException 
	{
		List<Item> itensPedidos = pedidosDao.getItensPedido(comanda);
		if(ListUtils.isNullOrEmpty(itensPedidos)) {
			throw new ComandaSemItensException("A conta não foi fechada. A comanda "+comanda.getNumero()+ " não possui itens. ");
		}	
		
		String sqlInsertFechamento = 
				" INSERT INTO tbcomanda_fechamento ( "+
				" comanda, " +
				" seq, " +
				" data, " +
				" hora )" +
				" VALUES ( ?, ?, current_date, current_time )";
				
		try(Connection conn = connectionFactory.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sqlInsertFechamento))
		{
			 stmt.setInt(1, comanda.getNumero());
			 stmt.setInt(2, Integer.parseInt(generator.gerarId(Generator.FECHAMENTO)));
			 stmt.executeUpdate();
			 
			 insertFechamentoImpressao(comanda);
		}
	}
	
	private void insertFechamentoImpressao(Comanda comanda) throws SQLException {
		
		String sqlInsertFechamentoImpressao = 
				" INSERT INTO tbcomanda_imp ( "+
				" comandas_fechamento, " +
				" fechamento, " +
				" codfunc, " +
				" qtd_pessoas) " +
				" VALUES (?,?,?,?) ";
		
		try(Connection conn = connectionFactory.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sqlInsertFechamentoImpressao))
		{
			
			stmt.setInt(1, comanda.getNumero());
			stmt.setString(2, "S");
			
			Atendente atendente = comanda.getAtendente();
			if(atendente != null) {
				stmt.setString(3, Format.casasFormat(atendente.getCodigo(), 5));
				stmt.setInt(4, comanda.getQuantidadePessoas());
			}else {
				stmt.setObject(3, null);
				stmt.setObject(4, null);
			}

			
			stmt.executeUpdate();
		}
		
	}
	

}
