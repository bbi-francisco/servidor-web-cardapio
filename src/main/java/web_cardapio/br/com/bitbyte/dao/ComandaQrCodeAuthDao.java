package web_cardapio.br.com.bitbyte.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import web_cardapio.br.com.bitbyte.connection.ConnectionFactory;
import web_cardapio.br.com.bitbyte.exceptions.ComandaQrCodeInvalidoException;
import web_cardapio.br.com.bitbyte.models.Comanda;
import web_cardapio.br.com.bitbyte.models.QrCodeAuth;

@Repository
public class ComandaQrCodeAuthDao {
	
	@Autowired
	private ConnectionFactory connectionFactory;
	
	public void autenticar(Comanda comanda) throws SQLException, ComandaQrCodeInvalidoException {
		
		QrCodeAuth qrCodeAuth = comanda.getQrCodeAuth();
		if(qrCodeAuth == null) {
			throw new ComandaQrCodeInvalidoException("O qrCode da comanda " + comanda.getNumero() + " não possui autenticação válida");
		}
		String cnpj = qrCodeAuth.getCnpj();
		String uuidComanda = qrCodeAuth.getUuidComanda();
		int numeroComanda = comanda.getNumero();
		
		String sqlComandaUuid = 
				" SELECT comanda FROM tbcomanda " + 
				" WHERE senha = '" +uuidComanda+ "' " +
				" AND "+
			 	" ( " + 
				"    SELECT tbparametro.valor " + 
				"    FROM tbparametro " + 
				"    WHERE tbparametro.parametro LIKE 'CNPJ' " + 
				" ) = '" + cnpj + "' AND comanda = '" +comanda.getNumero()+ "'" ;
		
		try(Connection conn = connectionFactory.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sqlComandaUuid);
			ResultSet rs = stmt.executeQuery();)
		{
			if(!rs.next()) {
				throw new ComandaQrCodeInvalidoException("O QrCode da comanda "+ numeroComanda + 
						" não possui autenticação válida.");
			}
		}
		
	}

}
