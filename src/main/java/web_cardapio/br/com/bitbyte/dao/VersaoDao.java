package web_cardapio.br.com.bitbyte.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import web_cardapio.br.com.bitbyte.connection.ConnectionFactory;
import web_cardapio.br.com.bitbyte.models.AppVersion;

@Repository
public class VersaoDao {
	
	@Autowired
	private ConnectionFactory connectionFactory;
	
	public AppVersion getAppVersion(String app) throws SQLException 
	{
		String sql = 
		" SELECT " +
		" v.apk, " +
		" v.versao " +
		" FROM tbversoes_apk v " +
		" WHERE apk = ? ";
		
		try(Connection conn = connectionFactory.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql))
		{
			stmt.setString(1, app);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				AppVersion appVersion = new AppVersion()
						.setApplicationName(rs.getString("apk"))
						.setVersion(rs.getString("versao"));
				return appVersion;
				
			}
		}
		return null;
	}
	
	public void updateOrInsertVersion(AppVersion version) throws SQLException {
		String sql = 
				" UPDATE OR INSERT INTO tbversoes_apk ( " +
				" apk, " +
				" versao ) " +
				" VALUES (?, ?) " +
				" MATCHING (apk) ";
				
		try(Connection conn = connectionFactory.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql))
		{
			stmt.setString(1, version.getApplicationName());
			stmt.setString(2, version.getVersion());
			stmt.executeUpdate();
		}
	}

}
