package web_cardapio.br.com.bitbyte.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import web_cardapio.br.com.bitbyte.models.Alergias;

@Repository
public class AlergiasDao {
	
	@Autowired
	private JdbcTemplate jdbc;
	
	public List<Alergias> selectAlergias(){
		
		String sql =
			    " SELECT " +
			    " COALESCE(al.cod_prod, '') AS cod_prod, " +
			    " COALESCE(al.ovo, 'N') AS ovo, " +
			    " COALESCE(al.leite, 'N') AS leite, " +
			    " COALESCE(al.soja, 'N') AS soja, " +
			    " COALESCE(al.gluten, 'N') AS gluten, " +
			    " COALESCE(al.amendoim, 'N') AS amendoim, " +
			    " COALESCE(al.sulfitos, 'N') AS sulfitos, " +
			    " COALESCE(al.peixe, 'N') AS peixe, " +
			    " COALESCE(al.moluscos, 'N') AS moluscos, " +
			    " COALESCE(al.mostarda, 'N') AS mostarda, " +
			    " COALESCE(al.nozes, 'N') AS nozes, " +
			    " COALESCE(al.gergelim, 'N') AS gergelim, " +
			    " COALESCE(al.aipo, 'N') AS aipo, " +
			    " COALESCE(al.tremoco, 'N') AS tremoco, " +
			    " COALESCE(al.crustaceos, 'N') AS crustaceos " +
			    " FROM tbalergias al";
		
		return jdbc.query(sql, (rs, i)->{
			return new Alergias()
					.setCodProd(rs.getString("cod_prod"))
					.setOvo("S".equals(rs.getString("ovo")))
					.setLeite("S".equals(rs.getString("leite")))
					.setSoja("S".equals(rs.getString("soja")))
					.setGluten("S".equals(rs.getString("gluten")))
					.setAmendoim("S".equals(rs.getString("amendoim")))
					.setSulfitos("S".equals(rs.getString("sulfitos")))
					.setPeixe("S".equals(rs.getString("peixe")))
					.setMoluscos("S".equals(rs.getString("moluscos")))
					.setMostarda("S".equals(rs.getString("mostarda")))
					.setNozes("S".equals(rs.getString("nozes")))
					.setGergelim("S".equals(rs.getString("gergelim")))
					.setAipo("S".equals(rs.getString("aipo")))
					.setTremoco("S".equals(rs.getString("tremoco")))
					.setCrustaceos("S".equals(rs.getString("crustaceos")));
		});
		
	}

}
