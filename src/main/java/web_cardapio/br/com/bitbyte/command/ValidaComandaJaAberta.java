package web_cardapio.br.com.bitbyte.command;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import web_cardapio.br.com.bitbyte.dao.ComandaDao;
import web_cardapio.br.com.bitbyte.exceptions.ComandaException;
import web_cardapio.br.com.bitbyte.exceptions.ComandaJaAbertaException;
import web_cardapio.br.com.bitbyte.models.Comanda;

@Component
public class ValidaComandaJaAberta {
	
	@Autowired
	private ComandaDao comandaDAO;

	public Boolean execute(Comanda comanda) throws SQLException, ComandaException {
		System.out.println("Hello World");
		int numeroComanda = comanda.getNumero();
		Comanda comandaAberta = comandaDAO.selectComandaByNumero(numeroComanda);
		if(comandaAberta != null) {
			throw new ComandaJaAbertaException("A comanda " + numeroComanda + " já encontra-se aberta. ");
		}
		return true;
	}

}
