package web_cardapio.br.com.bitbyte.services.tablet;

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
import web_cardapio.br.com.bitbyte.exceptions.BBIException;
import web_cardapio.br.com.bitbyte.exceptions.ComandaException;
import web_cardapio.br.com.bitbyte.models.Comanda;
import web_cardapio.br.com.bitbyte.models.ComandaInvalida;
import web_cardapio.br.com.bitbyte.results.ComandaValidationResult;
import web_cardapio.br.com.bitbyte.services.interfaces.ValidarComandaService;
import web_cardapio.br.com.bitbyte.utils.CollectionsUtils;

@Service
public class ValidarComandaServiceTablet implements ValidarComandaService {
	
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

	public ComandaValidationResult validar(Comanda comanda) throws BBIException, SQLException {
		return validar(Collections.singletonList(comanda));
	}

	@Override
	public ComandaValidationResult validar(List<Comanda> comandas) throws SQLException, BBIException {
		if (CollectionsUtils.isNullOrEmpty(comandas)) {
			throw new IllegalArgumentException("Nenhuma comanda recebida para validação. ");
		}

		validaCaixaAberto.execute();
		for (Comanda comanda : comandas) {
			try {
				validaIntervaloComanda.execute(comanda);
				validaComandaBloqueada.execute(comanda);
				validaComandaFechada.execute(comanda, true);
				validaComandaNaoAberta.execute(comanda);
//
//				if (FormaAtendimento.COMANDA.equals(comanda.getFormaAtendimento())) {
//					new ValidaComandaTag(comanda).execute();
//				}

				validaLimiteComanda.execute(comanda);

			} catch (ComandaException e) {
				ComandaInvalida comandaInvalida = new ComandaInvalida().setStatus(e.getStatus())
						.setMessage(e.getMessage());

				comanda.setComandaInvalida(comandaInvalida);
			}
		}

		return new ComandaValidationResult().setComandas(comandas);
	}
}
