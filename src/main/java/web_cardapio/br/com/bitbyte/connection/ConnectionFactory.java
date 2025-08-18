package web_cardapio.br.com.bitbyte.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.log4j.Logger;
import org.firebirdsql.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import web_cardapio.br.com.bitbyte.configuration.PropertiesConfig;

@Configuration
public class ConnectionFactory {
	
	private static final Logger log = Logger.getLogger(ConnectionFactory.class);

	private static final String driver = "org.firebirdsql.jdbc.FBDriver";
	private static final String usuario = "SYSDBA";
	private static final String senha = "masterkey";
	
	@Autowired
	private PropertiesConfig propertiesConfig;

	public Connection getConnection() {
		try {
			
			String databaseWay = propertiesConfig.getDatabaseWay();
			String databaseName = propertiesConfig.getDatabaseName();
			String databaseIp = propertiesConfig.getDatabaseIp();
			String databasePort = propertiesConfig.getDatabasePort();
			
			String banco = new StringBuilder()
					.append("jdbc:firebirdsql:")
					.append(databaseIp)
					.append("/")
					.append(databasePort)
					.append(":")
					.append(databaseWay)
					.append(databaseName)
					.append("?useUnicode=true&amp;characterEncoding=UTF-8&CHARSET=UTF-8")
					.toString();

			Class.forName(driver);
			Connection conn = DriverManager.getConnection(banco, usuario, senha);
			
			return conn;

		} catch (Exception e) {
			log.error(e);
			throw new RuntimeException(e);

		}
	}
}

