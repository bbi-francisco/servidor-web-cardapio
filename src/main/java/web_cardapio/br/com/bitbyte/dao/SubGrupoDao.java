package web_cardapio.br.com.bitbyte.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import web_cardapio.br.com.bitbyte.connection.ConnectionFactory;
import web_cardapio.br.com.bitbyte.enums.RestricaoType;
import web_cardapio.br.com.bitbyte.models.Restricao;
import web_cardapio.br.com.bitbyte.models.SubGrupo;

@Repository
public class SubGrupoDao
{

	@Autowired
	private ConnectionFactory connectionFactory;
	
	@Autowired
	private RestricaoDao restricaoDao;

	public List<SubGrupo> getSubGrupos() throws SQLException
	{
		String sql = 
				" SELECT DISTINCT " + 
				" sg.codigo, " + 
				" sg.descricao, " + 
				" sg.indice, " + 
				" COALESCE(sg.codfilial, '') AS codfilial, " + 
				" COALESCE(sg.img, '') AS img, " + 
				" COALESCE(sg.tpexibicao, '') AS tpexibicao, " + 
				" sg.grupo, " + 
				" sg.img, " +
				" sg.utiliza_cardapio_digital, " +
				" sg.pizza " +
				" FROM tbsubgru sg " + 
				" WHERE sg.grupo IS NOT NULL " + 
				" ORDER BY sg.descricao ";
		
		List<SubGrupo> subgrupos = new ArrayList<SubGrupo>();
		
		try(Connection conn = connectionFactory.getConnection();
			PreparedStatement pst = conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery())
		{
			Map<String, List<Restricao>> restricoes =
					restricaoDao.getMapRestricoes(RestricaoType.SUBGRUPO);
			
			while(rs.next())
			{
				SubGrupo subgrupo = new SubGrupo();
				String codigoSubGrupo = rs.getString("codigo");

				subgrupo.setCodigo(codigoSubGrupo);
				subgrupo.setDescricao(rs.getString("descricao"));
				subgrupo.setIndice(rs.getInt("indice"));
				subgrupo.setGrupo(rs.getString("grupo"));
				subgrupo.setImg(rs.getString("img"));
				subgrupo.setTipoExibicao(rs.getString("tpexibicao"));
				subgrupo.setRestricoes(restricoes.get(codigoSubGrupo));
				
				String utilizaCardapio = rs.getString("utiliza_cardapio_digital");
				subgrupo.setUtilizaCardapioDigital("S".equals(utilizaCardapio));
				subgrupo.setPizza("S".equals(rs.getString("pizza")));
				subgrupos.add(subgrupo);
			}
			return subgrupos;
		}
	}
}