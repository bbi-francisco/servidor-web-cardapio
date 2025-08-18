package web_cardapio.br.com.bitbyte.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import web_cardapio.br.com.bitbyte.connection.ConnectionFactory;
import web_cardapio.br.com.bitbyte.enums.RestricaoType;
import web_cardapio.br.com.bitbyte.models.Restricao;
import web_cardapio.br.com.bitbyte.utils.MapAddHelper;

@Repository
public class RestricaoDao
{
	@Autowired
	private ConnectionFactory connectionFactory;
	
	public Map<String, List<Restricao>> getMapRestricoes(RestricaoType restricaoType) throws SQLException
	{
		String campoCodigo = restricaoType.getCampoCodigo();
		String nomeTabela = restricaoType.getNomeTabela();
		
		String sqlSelectRestricoes = 
			" SELECT " + campoCodigo + ", " + 
			" dia, " +
			" hora_ini, " +
			" hora_fin " +
			" FROM " + nomeTabela +
			" WHERE 'N' IN " +
			" ( " + 
			"    SELECT valor " + 
			"    FROM tbparametro tp " + 
 			"    WHERE tp.parametro = 'IGNORAR_RESTRICAO' " + 
			" ) " + 
			" ORDER BY " +campoCodigo;
		
		try(Connection conn = connectionFactory.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sqlSelectRestricoes);
			ResultSet rs = stmt.executeQuery())
		{
			MapAddHelper<String, Restricao> mapAddHelper = new MapAddHelper<>(rs);
			while(rs.next()) 
			{
				String codigoItem = rs.getString(campoCodigo);
				
				Restricao restricao = new Restricao();
				restricao.setCodigoItem(codigoItem);
				restricao.setDia(rs.getInt("dia"));
				restricao.setHorarioInicio(rs.getString("hora_ini"));
				restricao.setHorarioFim(rs.getString("hora_fin"));
				
				mapAddHelper.addToMap(codigoItem, restricao);
			}
			return mapAddHelper.getMap();
		}
	}
	
}