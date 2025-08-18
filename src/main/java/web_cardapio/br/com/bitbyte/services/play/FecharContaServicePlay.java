package web_cardapio.br.com.bitbyte.services.play;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web_cardapio.br.com.bitbyte.command.ValidaCaixaAberto;
import web_cardapio.br.com.bitbyte.command.ValidaComandaBloqueada;
import web_cardapio.br.com.bitbyte.command.ValidaComandaFechada;
import web_cardapio.br.com.bitbyte.command.ValidaComandaNaoAberta;
import web_cardapio.br.com.bitbyte.dao.ComandaQrCodeAuthDao;
import web_cardapio.br.com.bitbyte.dao.ContaDao;
import web_cardapio.br.com.bitbyte.exceptions.BBIException;
import web_cardapio.br.com.bitbyte.models.Comanda;
import web_cardapio.br.com.bitbyte.results.FecharContaResult;
import web_cardapio.br.com.bitbyte.services.interfaces.FecharContaService;

@Service
public class FecharContaServicePlay implements FecharContaService {
	
	@Autowired
	private ContaDao fecharContaDao;
	
	@Autowired
	private ComandaQrCodeAuthDao comandaQrCodeAuthDao;
	
	@Autowired
	private ValidaCaixaAberto validaCaixaAberto;
	
	@Autowired
	private ValidaComandaBloqueada validaComandaBloqueada;
	
	@Autowired
	private ValidaComandaFechada validaComandaFechada;
	
	@Autowired
	private ValidaComandaNaoAberta validaComandaNaoAberta;
	
	@Override
	public FecharContaResult fecharConta(Comanda comanda) throws SQLException, BBIException {
		
		validaCaixaAberto.execute();
		validaComandaBloqueada.execute(comanda);
		validaComandaFechada.execute(comanda, true);
		validaComandaNaoAberta.execute(comanda);
		comandaQrCodeAuthDao.autenticar(comanda);
		fecharContaDao.fecharConta(comanda);
		
		return new FecharContaResult();
	}

}
