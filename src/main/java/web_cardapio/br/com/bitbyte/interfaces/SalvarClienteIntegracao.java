package web_cardapio.br.com.bitbyte.interfaces;

import java.sql.SQLException;

import web_cardapio.br.com.bitbyte.models.Pedido;

public interface SalvarClienteIntegracao {
	
	void putCliente(Pedido pedido) throws SQLException;

}
