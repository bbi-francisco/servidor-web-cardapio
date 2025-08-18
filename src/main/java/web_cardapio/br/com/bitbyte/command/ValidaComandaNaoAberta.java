package web_cardapio.br.com.bitbyte.command;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import web_cardapio.br.com.bitbyte.dao.ComandaDao;
import web_cardapio.br.com.bitbyte.exceptions.ComandaException;
import web_cardapio.br.com.bitbyte.exceptions.ComandaNaoAbertaException;
import web_cardapio.br.com.bitbyte.models.Comanda;

@Component
public class ValidaComandaNaoAberta{
	
	@Autowired
	private ComandaDao comandaDao;

	public Boolean execute(Comanda comanda) throws SQLException, ComandaException 
	{
		int numeroComanda = comanda.getNumero();
		Comanda comandaAberta = comandaDao.selectComandaByNumero(numeroComanda);
		if(comandaAberta == null) {
			throw new ComandaNaoAbertaException("A comanda " + numeroComanda + " não foi aberta. ");
		}
		return true;
	}

}
