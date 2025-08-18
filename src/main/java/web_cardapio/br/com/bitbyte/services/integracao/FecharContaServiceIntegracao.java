package web_cardapio.br.com.bitbyte.services.integracao;

import java.sql.SQLException;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web_cardapio.br.com.bitbyte.command.ValidaCaixaAberto;
import web_cardapio.br.com.bitbyte.command.ValidaComandaBloqueada;
import web_cardapio.br.com.bitbyte.command.ValidaComandaFechada;
import web_cardapio.br.com.bitbyte.command.ValidaComandaNaoAberta;
import web_cardapio.br.com.bitbyte.dao.ContaDao;
import web_cardapio.br.com.bitbyte.exceptions.BBIException;
import web_cardapio.br.com.bitbyte.exceptions.ComandaException;
import web_cardapio.br.com.bitbyte.models.Comanda;
import web_cardapio.br.com.bitbyte.models.ComandaInvalida;
import web_cardapio.br.com.bitbyte.results.FecharContaResult;
import web_cardapio.br.com.bitbyte.services.interfaces.FecharContaService;

@Service
public class FecharContaServiceIntegracao implements FecharContaService {
	
	@Autowired
	private ValidaCaixaAberto validaCaixaAberto;
	
	@Autowired
	private ValidaComandaBloqueada validaComandaBloqueada;
	
	@Autowired
	private ValidaComandaFechada validaComandaFechada;
	
	@Autowired
	private ValidaComandaNaoAberta validaComandaNaoAberta;
	
	@Autowired
	private ContaDao contaDao;
	
	@Override
	public FecharContaResult fecharConta(Comanda comanda) throws SQLException, BBIException {
		
		try {
			validaCaixaAberto.execute();
			validaComandaBloqueada.execute(comanda);
			validaComandaFechada.execute(comanda, true);
			validaComandaNaoAberta.execute(comanda);
			contaDao.fecharConta(comanda);
		}
		catch(ComandaException e) 
		{
			ComandaInvalida comandaInvalida = new ComandaInvalida()
					.setStatus(e.getStatus())
					.setMessage(e.getMessage());
			comanda.setComandaInvalida(comandaInvalida);
		}
		return new FecharContaResult()
				.setComandas(Collections.singletonList(comanda));
	}

}
