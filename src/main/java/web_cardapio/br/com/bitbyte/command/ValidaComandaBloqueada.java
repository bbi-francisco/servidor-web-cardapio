package web_cardapio.br.com.bitbyte.command;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import web_cardapio.br.com.bitbyte.dao.ComandaDao;
import web_cardapio.br.com.bitbyte.exceptions.ComandaBloqueadaException;
import web_cardapio.br.com.bitbyte.exceptions.ComandaException;
import web_cardapio.br.com.bitbyte.models.BloqueioComanda;
import web_cardapio.br.com.bitbyte.models.Comanda;

@Component
public class ValidaComandaBloqueada{
	
	@Autowired
	private ComandaDao comandaDAO;
	
	public Boolean execute(Comanda comanda) throws SQLException, ComandaException {
		int numeroComanda = comanda.getNumero();
		BloqueioComanda bloqueioComanda = comandaDAO.verificarComandaBloqueada(numeroComanda);
		if(bloqueioComanda.isBloqueada()) {
			throw new ComandaBloqueadaException("A comanda " + numeroComanda + " encontra-se bloqueada. Motivo: " + bloqueioComanda.getMotivo());
		}
		return true;
	}

}
