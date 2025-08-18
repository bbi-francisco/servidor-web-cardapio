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
import web_cardapio.br.com.bitbyte.models.Promocao;
import web_cardapio.br.com.bitbyte.utils.MapAddHelper;

@Repository
public class PromocaoDao
{
	@Autowired
	private ConnectionFactory connectionFactory;
	
	public Map<String, List<Promocao>> getMapProdutoPromocoes() throws SQLException
	{
		String sqlSelectPromocoes = 
			" SELECT " + 
			" codprod, " + 
			" dia, " + 
			" hora_ini, " + 
			" hora_fin, " + 
			" percentual " + 
			" FROM tbprod_promo " + 
			" WHERE 'N' IN " + 
			" ( " + 
			"    SELECT valor " + 
			"    FROM tbparametro tp " + 
			"    WHERE tp.parametro = 'IGNORAR_PROMOCAO' " + 
			" ) " + 
			" ORDER BY codprod ";
		
		try(Connection conn = connectionFactory.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sqlSelectPromocoes);
			ResultSet rs = stmt.executeQuery();)
		{
			MapAddHelper<String, Promocao> mapAddHelper =  new MapAddHelper<>(rs);
			while(rs.next()) 
			{
				Promocao promocao = new Promocao();
				String codigoItem = rs.getString("codprod");
				
				promocao.setCodigoItem(codigoItem);
				promocao.setDia(rs.getInt("dia"));
				promocao.setHorarioInicio(rs.getTime("hora_ini").toString());
				promocao.setHorarioFim(rs.getTime("hora_fin").toString());
				promocao.setPercentual(rs.getDouble("percentual"));
				
				mapAddHelper.addToMap(codigoItem, promocao);
			}
			return mapAddHelper.getMap();
		}
	}
}
