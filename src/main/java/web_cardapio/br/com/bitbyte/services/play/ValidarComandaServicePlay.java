package web_cardapio.br.com.bitbyte.services.play;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web_cardapio.br.com.bitbyte.command.ValidaCaixaAberto;
import web_cardapio.br.com.bitbyte.command.ValidaComandaBloqueada;
import web_cardapio.br.com.bitbyte.command.ValidaComandaFechada;
import web_cardapio.br.com.bitbyte.command.ValidaComandaNaoAberta;
import web_cardapio.br.com.bitbyte.command.ValidaIntervaloComanda;
import web_cardapio.br.com.bitbyte.command.ValidaLimiteComanda;
import web_cardapio.br.com.bitbyte.dao.AtendenteDao;
import web_cardapio.br.com.bitbyte.dao.ComandaQrCodeAuthDao;
import web_cardapio.br.com.bitbyte.exceptions.AtendenteNaoEncontradoException;
import web_cardapio.br.com.bitbyte.exceptions.BBIException;
import web_cardapio.br.com.bitbyte.exceptions.ComandaException;
import web_cardapio.br.com.bitbyte.models.Atendente;
import web_cardapio.br.com.bitbyte.models.Comanda;
import web_cardapio.br.com.bitbyte.models.ComandaInvalida;
import web_cardapio.br.com.bitbyte.results.ComandaValidationResult;
import web_cardapio.br.com.bitbyte.services.interfaces.ValidarComandaService;

@Service
public class ValidarComandaServicePlay implements ValidarComandaService {
	
	@Autowired
	private ComandaQrCodeAuthDao comandaQrCodeAuthDAO;
	
	@Autowired
	private AtendenteDao atendenteDao;
	
	@Autowired
	private ValidaCaixaAberto validaCaixaAberto;
	
	@Autowired
	private ValidaIntervaloComanda validaIntervaloComanda;
	
	@Autowired
	private ValidaComandaBloqueada validaComandaBloqueada;
	
	@Autowired
	private ValidaComandaFechada validaComandaFechada;
	
	@Autowired
	private ValidaComandaNaoAberta validaComandaNaoAberta;
	
	@Autowired
	private ValidaLimiteComanda validaLimiteComanda;

	public ComandaValidationResult validar(Comanda comanda) throws NumberFormatException,  SQLException, BBIException 
	{
		return validar(Collections.singletonList(comanda));
	}
	
	public ComandaValidationResult validar(List<Comanda> comandas) throws SQLException, BBIException   {
		if(comandas == null || comandas.isEmpty()) {
			throw new IllegalArgumentException("Nenhuma comanda recebida para validação");
		}
		
		validaCaixaAberto.execute();
		
		Comanda comanda = comandas.get(0);
		Atendente atendente = comanda.getAtendente();
		
		validarAtendente(atendente.getCodigo());
		try {
			validaIntervaloComanda.execute(comanda);
			validaComandaBloqueada.execute(comanda);
			validaComandaFechada.execute(comanda, true);
			validaComandaNaoAberta.execute(comanda);
			comandaQrCodeAuthDAO.autenticar(comanda);
			
			validaLimiteComanda.execute(comanda);
		}catch(ComandaException e) {
			
			ComandaInvalida comandaInvalida = new ComandaInvalida()
					.setMessage(e.getMessage())
					.setStatus(e.getStatus());
			
			comanda.setComandaInvalida(comandaInvalida);
		}
		return new ComandaValidationResult();
	}
	
	
	private void validarAtendente(String codigoAtendente) throws AtendenteNaoEncontradoException, SQLException 
	{
		Atendente atendenteBusca = atendenteDao.getAtendente(codigoAtendente);
		if(atendenteBusca == null) {
			throw new AtendenteNaoEncontradoException("O atendente " + codigoAtendente+ " não foi encontrado. ");
		}
	}

}
