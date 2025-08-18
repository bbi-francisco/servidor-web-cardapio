package web_cardapio.br.com.bitbyte.command;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import web_cardapio.br.com.bitbyte.dao.ComandaDao;
import web_cardapio.br.com.bitbyte.exceptions.ComandaException;
import web_cardapio.br.com.bitbyte.models.Comanda;
import web_cardapio.br.com.bitbyte.models.IntervaloComanda;

@Component
public class ValidaIntervaloComanda {
	
	@Autowired
	private ComandaDao comandaDao;

	public boolean execute(Comanda comanda) throws SQLException, ComandaException {
		int numeroComanda = comanda.getNumero();
		IntervaloComanda intervaloComanda = comandaDao.verificarIntervaloComanda(numeroComanda);
		if(intervaloComanda.isInvalid()) 
		{
			int comandaInicial = intervaloComanda.getComandaInicial();
			int comandaFinal = intervaloComanda.getComandaFinal();
			String message = String.format("O número da comanda deve estar entre %d e %d. ", comandaInicial, comandaFinal);
			throw new ComandaException(message);
		}
		return true;
	}

}
