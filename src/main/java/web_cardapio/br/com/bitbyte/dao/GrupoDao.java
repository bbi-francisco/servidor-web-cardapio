package web_cardapio.br.com.bitbyte.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import web_cardapio.br.com.bitbyte.connection.ConnectionFactory;
import web_cardapio.br.com.bitbyte.models.Grupo;

@Repository
public class GrupoDao {

	private static final Logger log = Logger.getLogger(GrupoDao.class);
	
	@Autowired
	private ConnectionFactory connectionFactory;
	
	public List<Grupo> getGrupos() throws SQLException 
	{
		String sql = 
			" SELECT " +
			" g.codigo, " +
			" g.descricao, " +
			" g.img, " +
			" g.utiliza_cardapio_digital " +
			" FROM tbgrupo g " +
			" ORDER BY descricao "; 
		
		List<Grupo> grupos = new ArrayList<>(); 
		
		try(Connection conn = connectionFactory.getConnection();
			PreparedStatement pst = conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery())
		{
			while(rs.next()) {
				Grupo grupo = new Grupo();
				
				String codigoGrupo = rs.getString("codigo");
				grupo.setCodigo(codigoGrupo);
				grupo.setDescricao(rs.getString("descricao"));
				grupo.setImg(rs.getString("img"));
				
				String utilizaCardapioDigital =  rs.getString("utiliza_cardapio_digital");
				grupo.setUtilizaCardapioDigital("S".equals(utilizaCardapioDigital));
				
				grupos.add(grupo);
			}
			return grupos;
		}
	}
}

