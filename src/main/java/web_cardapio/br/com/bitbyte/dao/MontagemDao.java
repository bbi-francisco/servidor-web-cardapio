package web_cardapio.br.com.bitbyte.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import web_cardapio.br.com.bitbyte.connection.ConnectionFactory;
import web_cardapio.br.com.bitbyte.format.Format;
import web_cardapio.br.com.bitbyte.models.bbifood.AdicionaisBBIFood;
import web_cardapio.br.com.bitbyte.models.bbifood.AtendenteBBIFood;
import web_cardapio.br.com.bitbyte.models.bbifood.ComandaBBIFood;
import web_cardapio.br.com.bitbyte.models.bbifood.ItemBBIFood;
import web_cardapio.br.com.bitbyte.models.bbifood.PedidoBBIFood;
import web_cardapio.br.com.bitbyte.sqlcommons.Generator;
import web_cardapio.br.com.bitbyte.utils.ListUtils;

@Repository
public class MontagemDao {
	
	@Autowired
	private ConnectionFactory connectionFactory;
	
	@Autowired
	private Generator generator;
	
	@Autowired
	private ComandaItemDao comandaItemDao;
	
	@Autowired
	private ImpressaoDao impressaoDao;
	
	@Autowired
	private ComboDao comboDao;
	
	public void insertMontagem(PedidoBBIFood pedido, ItemBBIFood itemPedido) throws SQLException 
	{
		ComandaBBIFood comanda = pedido.getComanda();
		double quantidade = itemPedido.getQtd();
		
		for(double i = quantidade; i > 0; i--) 
		{
			int seqPeso = comandaItemDao.getSeqPeso(comanda.getNumero());
			AdicionaisBBIFood adicionais = itemPedido.getAdicionais();
			List<ItemBBIFood> itensCombo = adicionais.getItensMontagem();
			
			itemPedido.setQtd(1);
			itemPedido.setSeqItem(generator.gerarIdItem());
			
			// Inserindo pedido na tabela de itens relacionada a comanda
			String sqlItens = 
				" INSERT INTO tbcomanda_item ("
				+ "comanda, " // 1
				+ "seq_item, " // 2
				+ "codprod, " // 3
				+ "codprod_2, " // 4
				+ "descricao, " // 5
				+ "qtd, " // 6
				+ "vr_unit, " // 7
				+ "funcionario, " // 8
				+ "mesa, " // 9
				+ "seq_peso, " // 10
				+ "id_ingre, " // 11
				+ "variacao, " // 12
				+ "id_pizza, " //13
				+ "cod_pizza, " //14
				+ "qtd_pizza, " //15
				+ "id_integracao_cardapio, " //16
				+ "data, " // 17
				+ "hora) " // 18
				+ "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?, current_date, current_time)";

			try(Connection conn = connectionFactory.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sqlItens);)
			{
				stmt.setInt(1, comanda.getNumero());
				// Salvando id do produto
				stmt.setInt(2, itemPedido.getSeqItem());
				// Salvando codigo do produto
				stmt.setString(3, itemPedido.getCodigo());
				// Salvando codigo de pesquisa
				stmt.setString(4, itemPedido.getCodigoPesquisa());
				// Salvando descricao do produto
				stmt.setString(5, itemPedido.getDescricao());
				// Salvando quantidade do produto
				stmt.setDouble(6, itemPedido.getQtd());
				// salvando preco do produto
				stmt.setBigDecimal(7, itemPedido.getVrUnit());
				// salvando atendente
				
				AtendenteBBIFood atendente = comanda.getAtendente();
				stmt.setString(8, Format.casasFormat(atendente.getCodigo(), 5));
				// salvando mesa
				stmt.setInt(9, comanda.getMesa());
				// salvando seq_peso
				stmt.setObject(10, ++seqPeso);
				
				stmt.setInt(11, 0);
				stmt.setString(12, "");
				
				stmt.setInt(13, 0);
				stmt.setString(14, "");
				stmt.setInt(15, 0);
				stmt.setString(16, itemPedido.getId());
				stmt.executeUpdate();
				
				if(!ListUtils.isNullOrEmpty(itensCombo)) 
				{
					comboDao.setSeqPeso(seqPeso);
					comboDao.insertItensCombo(itemPedido, pedido);
				}
				
				impressaoDao.salvarImpressao(itemPedido, comanda);
			}
		}
	}
}
