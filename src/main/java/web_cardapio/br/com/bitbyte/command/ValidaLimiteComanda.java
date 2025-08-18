package web_cardapio.br.com.bitbyte.command;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import web_cardapio.br.com.bitbyte.dao.ComandaDao;
import web_cardapio.br.com.bitbyte.exceptions.ComandaException;
import web_cardapio.br.com.bitbyte.format.MoneyFormatter;
import web_cardapio.br.com.bitbyte.models.Comanda;
import web_cardapio.br.com.bitbyte.models.ValoresComanda;

@Component
public class ValidaLimiteComanda {
	
	@Autowired
	private ComandaDao comandaDao;
	
	public boolean execute(Comanda comanda) throws SQLException, ComandaException 
	{
		int numeroComanda = comanda.getNumero();
		Comanda comandaAtual = comandaDao.selectComandaByNumero(numeroComanda);
		if(comandaAtual == null) {
			return false;
		}
		ValoresComanda limiteComanda = comandaAtual.getValoresComanda();
		if(limiteComanda.isLimiteInvalido()) {
			String valor = new MoneyFormatter().format(limiteComanda.getLimite());
			throw new ComandaException("O valor da comanda " + numeroComanda + " excede o limite (" + valor + "). ");
		}
		return true;
	}
}
