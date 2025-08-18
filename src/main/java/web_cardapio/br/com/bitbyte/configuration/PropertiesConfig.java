package web_cardapio.br.com.bitbyte.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

@Component
@PropertySource(value = "classpath:config.properties")
public class PropertiesConfig {
	
	@Value("${databaseWay}")
	private String databaseWay;
	
	@Value("${databaseName}")
	private String databaseName;
	
	@Value("${databasePort}")
	private String databasePort;
	
	@Value("${databaseIp}")
	private String databaseIp;

	public String getDatabaseWay() {
		return databaseWay;
	}

	public String getDatabaseName() {
		return databaseName;
	}

	public String getDatabasePort() {
		return databasePort;
	}

	public String getDatabaseIp() {
		return databaseIp;
	}
	
	
}