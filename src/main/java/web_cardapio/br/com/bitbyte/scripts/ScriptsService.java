package web_cardapio.br.com.bitbyte.scripts;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web_cardapio.br.com.bitbyte.connection.ConnectionFactory;

@Service
public class ScriptsService {
	
	@Autowired
	private ConnectionFactory connFactory;
	
	private static final Logger log = Logger.getLogger(ScriptsService.class);

	private List<String> create() {
		
		List<String> values = new ArrayList<>();
		values.add(createTbLicencas());
		values.add(createGeneratorLicencas());
		
		return values;
	}
	
	public void execute() throws SQLException {
		log.info("Executando scripts...");
		List<String> scripts = create();
		
		for(String script : scripts) {
			execute(script);
		}
	}
	
	private void execute(String sql) throws SQLException {
		try(Connection conn = connFactory.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql))
		{
			stmt.executeUpdate();
		}
	}
	
	private String createTbLicencas()
	{
		String sql = 
			" CREATE TABLE tblicencas ( " +
			"    id INTEGER PRIMARY KEY, " +
			"    serial VARCHAR(100), " +
			"    tipo VARCHAR(25), " +
			"    liberado CHAR(1) DEFAULT ''N'' " +
			" )";
		
		return new TableScript()
				.setSql(sql)
				.setTableName("tblicencas")
				.create();
	}
	
	private String createGeneratorLicencas() {
		String sql = " CREATE SEQUENCE gen_licencas ";
		
		return new GeneratorScript()
				.setGeneratorName("gen_licencas")
				.setSql(sql)
				.create();
	}
}
