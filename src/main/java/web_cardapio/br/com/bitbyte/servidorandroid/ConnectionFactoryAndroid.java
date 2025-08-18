package web_cardapio.br.com.bitbyte.servidorandroid;

import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import web_cardapio.br.com.bitbyte.configuration.PropertiesConfig;
import web_cardapio.com.embarcadero.javaandroid.DSRESTConnection;

/**
 * Fornece objetos de conexao para todas outras classes que precisam de acesso
 * ao webservice.
 * 
 * @author Vitor Bonequini
 */
@Component
public final class ConnectionFactoryAndroid {
	private static final String TAG = ConnectionFactoryAndroid.class.getName();
	private static final int TIMEOUT = 10_000;
	private static final Logger log = Logger.getLogger(ConnectionFactoryAndroid.class);

	/** Conexao armazenada para nao ser necessario instanciar varias vezes. */
	private DSRESTConnection cachedConnection;

	@Autowired
	private PropertiesConfig propertiesConfig;

	/**
	 * @return Uma variavel de conexao com o <strong>webservice</strong>.
	 * @exception NullPointerException Caso os atributos necessarios do <strong>
	 *                                 MenuPrincipal </strong> sejam nulos.
	 */
	public DSRESTConnection getConnection() {
		try {
			String databaseIP = propertiesConfig.getDatabaseIp();
			return getConnection(databaseIP, 3080);
		} catch (Exception e) {
			log.error(e);
			throw new RuntimeException(e);

		}
	}

	/**
	 * @return Uma variavel de conexao com o <strong>webservice</strong>.
	 * @exception NullPointerException Caso um dos argumentos seja nulo.
	 */
	public DSRESTConnection getConnection(String ip, int port) {
		// Log.i(TAG, "getConnection called -> ip: "+ ip + " -> port: " + port);

		if (!isConnectionEqual(ip, port)) {
			cachedConnection = new DSRESTConnection();
			cachedConnection.setHost(ip);
			cachedConnection.setPort(port);
//			cachedConnection.setCommunicationTimeout(TIMEOUT);
			cachedConnection.setCommunicationTimeout(30000);
			log.info(TAG + " Connection created -> ip: " + ip + " -> port: " + port);
		}

		return cachedConnection;
	}

	private boolean isConnectionEqual(String ip, int port) {
		if (cachedConnection == null)
			return false;
		if (cachedConnection.getHost().equals(ip) && cachedConnection.getPort() == port)
			return true;
		else
			return false;
	}

	public void closeConnection() {
		cachedConnection = null;
	}

}
