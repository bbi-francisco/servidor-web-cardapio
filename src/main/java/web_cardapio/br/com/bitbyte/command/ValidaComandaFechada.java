package web_cardapio.br.com.bitbyte.command;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import web_cardapio.br.com.bitbyte.dao.ComandaDao;
import web_cardapio.br.com.bitbyte.estatico.Parametros;
import web_cardapio.br.com.bitbyte.exceptions.ComandaException;
import web_cardapio.br.com.bitbyte.exceptions.ComandaFechadaException;
import web_cardapio.br.com.bitbyte.models.Comanda;
import web_cardapio.br.com.bitbyte.models.FechamentoComanda;
import web_cardapio.br.com.bitbyte.repositories.ParametrosService;

@Component
public class ValidaComandaFechada{
	
	@Autowired
	private ComandaDao comandaDao;
	
	@Autowired
	private ParametrosService parametrosService;
	
	public Boolean execute(Comanda comanda, boolean validaBloqComandaAposFx) throws SQLException, ComandaException 
	{
		boolean bloqComandaAposFx = parametrosService.getBoolean(Parametros.BLOQ_COMANDA_APOS_FX);
		
		int numeroComanda = comanda.getNumero();
		FechamentoComanda fechamentoComanda = comandaDao.verificarComandaFechada(numeroComanda);
		if(!fechamentoComanda.isFechada()) 
		{
			return true;
		}
		
		if(bloqComandaAposFx && validaBloqComandaAposFx) 
		{
			throw new ComandaFechadaException("A comanda " + numeroComanda + " encontra-se fechada. ");
		}
		return true;
	}
}
