package web_cardapio.br.com.bitbyte.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import web_cardapio.br.com.bitbyte.connection.ConnectionFactory;
import web_cardapio.br.com.bitbyte.format.CodigosFormatter;
import web_cardapio.br.com.bitbyte.models.bbifood.AdicionaisBBIFood;
import web_cardapio.br.com.bitbyte.models.bbifood.AtendenteBBIFood;
import web_cardapio.br.com.bitbyte.models.bbifood.ComandaBBIFood;
import web_cardapio.br.com.bitbyte.models.bbifood.ItemBBIFood;

@Repository
public class ImpressaoDao
{
	@Autowired
	private ConnectionFactory connectionFactory;
	
	public void atualizarStatusImpressao(int comanda) throws SQLException 
	{
		String sqlAtualizaStatusImp = 
			" UPDATE tbcomanda_imp " +
			" SET status_imp = 'S' " +
			" WHERE comanda = '" +comanda + "'";
		
		try(Connection conn = connectionFactory.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sqlAtualizaStatusImp)){
			stmt.executeUpdate();
		}
	}
	
	public void salvarImpressao(ItemBBIFood itemPedido, ComandaBBIFood comanda) throws SQLException
	{
		String imp = "INSERT INTO tbcomanda_imp ("
			+ " comanda, " // 1
			+ " codprod, " // 2
			+ " qtd, " // 3
			+ " status_imp, " // 4
			+ " descricao, " // 5
			+ " mesa, " // 6
			+ " cod_varia, " // 7
			+ " codfunc, " // 8
			+ " observacao, " // 9
			+ " id_ingre, " // 10
			+ " qtd_pessoas, " // 11
			+ " tipo_pedido, " //12
			+ " item, " // 13
			+ " obs_cozinha, " // 14
			+ " origem, " // 15
			+ " data_lanc, " // 16
			+ " hora_lanc)" // 17
			+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, current_date, current_time)";
		
		
		try(Connection conn = connectionFactory.getConnection();
			PreparedStatement stmt = conn.prepareStatement(imp))
		{
			CodigosFormatter<String> codigoFormatter = new CodigosFormatter<>();
			codigoFormatter.setSeparator("|");
			
			// salvando comanda
			stmt.setInt(1, comanda.getNumero());
			// salvando codProd
			stmt.setString(2, itemPedido.getCodigo());
			// salvando quantidade
			stmt.setDouble(3, itemPedido.getQtd());
			// salvando status de impressao
			stmt.setString(4, "N");
			// salvando descricao do produto
			stmt.setString(5, itemPedido.getDescricao());
			// salvando mesa
			stmt.setInt(6, comanda.getMesa());
			// salvando codigo das variacoes
			AdicionaisBBIFood adicionais = itemPedido.getAdicionais();
			stmt.setString(7, codigoFormatter.format(adicionais.getVariacoes()));
			// salvando codigo do atendente
			
			String codigoAtendente = getCodigoAtendente(comanda.getAtendente());
			
			stmt.setString(8, codigoAtendente);
			//salvando observacao
			stmt.setString(9, itemPedido.getObservacao());
			// salvando id_ingre
			stmt.setInt(10, itemPedido.getIdIngre());
			// salvando quantidade de pessoas
			stmt.setInt(11, 1);
			//salvando tipo_pedido
			stmt.setString(12, "");
			// salvando id do produto
			stmt.setInt(13, itemPedido.getSeqItem());
			
			String origem = itemPedido.getOrigem();
			//salvando observacao cozinha
			stmt.setString(14, "");
			// salvando origem do pedido
			stmt.setString(15, origem);
			stmt.executeUpdate();
		}
	}
	
	public String getCodigoAtendente(AtendenteBBIFood atendente) {
		if(atendente == null) {
			return "";
		}
		String codigoAtendente = atendente.getCodigo();
		return codigoAtendente;
		
	}
}

