package web_cardapio.br.com.bitbyte.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import web_cardapio.br.com.bitbyte.connection.ConnectionFactory;
import web_cardapio.br.com.bitbyte.models.bbifood.PedidoBBIFood;
import web_cardapio.br.com.bitbyte.utils.CollectionsUtils;
import web_cardapio.br.com.bitbyte.utils.StringUtils;

@Repository
public class ComandaItemDao
{
	@Autowired
	private ConnectionFactory connectionFactory; 
	
	public int getSeqPeso(int comanda) throws SQLException
	{
		// coletando o maior seq_peso da comanda atual
		String selectSeqPeso = 
			" SELECT seq_peso " +
			" FROM tbcomanda_item" + 
			" WHERE seq_item = (SELECT MAX(seq_item) FROM tbcomanda_item) " +
			" AND comanda = '" + comanda+ "'";
		
		try(Connection conn = connectionFactory.getConnection();
			PreparedStatement stmtSeqPeso = conn.prepareStatement(selectSeqPeso))
		{
			ResultSet rs = stmtSeqPeso.executeQuery();
			return rs.next() ? rs.getInt("seq_peso") : 0;
		}
		
	}
	
	public List<String> getIdsExistentes(PedidoBBIFood pedido) throws SQLException
	{
		Set<String> idsList = pedido.getItens()
				.stream()
				.filter(v-> !StringUtils.isNullOrEmpty(v.getId()))
				.map(i-> "'" + i.getId() + "'")
				.collect(Collectors.toSet());
		
		if(CollectionsUtils.isNullOrEmpty(idsList)) {
			return Collections.emptyList();
		}
		
		String idsValue = String.join(",", idsList);
		if(StringUtils.isNullOrEmpty(idsValue)) {
			return Collections.emptyList();
		}
		
		String sql = 
			" SELECT DISTINCT " +
			" id_integracao_cardapio " +
			" FROM tbcomanda_item " +
			" WHERE id_integracao_cardapio IN ( " + idsValue +  " ) ";
		 
		List<String> ids = new ArrayList<>();
		
		try(Connection conn = connectionFactory.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			)
		{
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				ids.add(rs.getString("id_integracao_cardapio"));
			}
		}
		return ids;
		
	}
}
