package web_cardapio.br.com.bitbyte.services.tablet;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import web_cardapio.br.com.bitbyte.command.ValidaAtendenteEntrada;
import web_cardapio.br.com.bitbyte.command.ValidaCaixaAberto;
import web_cardapio.br.com.bitbyte.command.ValidaComandaBloqueada;
import web_cardapio.br.com.bitbyte.command.ValidaComandaFechada;
import web_cardapio.br.com.bitbyte.command.ValidaComandaNaoAberta;
import web_cardapio.br.com.bitbyte.command.ValidaIntervaloComanda;
import web_cardapio.br.com.bitbyte.command.ValidaLimiteComanda;
import web_cardapio.br.com.bitbyte.dao.ComandaDao;
import web_cardapio.br.com.bitbyte.enums.FormaAtendimento;
import web_cardapio.br.com.bitbyte.exceptions.BBIException;
import web_cardapio.br.com.bitbyte.exceptions.ComandaException;
import web_cardapio.br.com.bitbyte.models.Comanda;
import web_cardapio.br.com.bitbyte.models.ComandaInvalida;
import web_cardapio.br.com.bitbyte.models.Entrada;
import web_cardapio.br.com.bitbyte.models.bbifood.ComandaBBIFood;
import web_cardapio.br.com.bitbyte.repositories.BbiParamService;
import web_cardapio.br.com.bitbyte.results.EntradaResult;
import web_cardapio.br.com.bitbyte.utils.CollectionsUtils;

@Service
public class AbrirComandasEntrada {

	@Autowired
	private ComandaDao comandaDao;

	@Autowired
	private BbiParamService bbiParamService;

	@Autowired
	private ValidaCaixaAberto validaCaixaAberto;

	@Autowired
	private ValidaAtendenteEntrada validaAtendenteEntrada;

	@Autowired
	private ValidaComandaBloqueada validaComandaBloqueada;

	@Autowired
	private ValidaComandaFechada validaComandaFechada;

	@Autowired
	private ValidaIntervaloComanda validaIntervaloComanda;

	@Autowired
	private ValidaLimiteComanda validaLimiteComanda;

	@Autowired
	private ValidaComandaNaoAberta validaComandaNaoAberta;

	public EntradaResult abrir(Entrada entrada) throws SQLException, BBIException {
		try {
			boolean aberturaComanda = bbiParamService.aberturaComanda();
			List<Comanda> comandas = entrada.getComandas();

			validaCaixaAberto.execute();
			validaAtendenteEntrada.execute(entrada);

			List<Comanda> comandasEmAberto = new ArrayList<>();
			List<Comanda> comandasInvalidas = new ArrayList<>();
			List<Comanda> comandasAbertas = new ArrayList<>();

			for (Comanda comanda : comandas) 
			{
				try {
					validaComandaBloqueada.execute(comanda);
					validaComandaFechada.execute(comanda, true);
					validaIntervaloComanda.execute(comanda);
					validaLimiteComanda.execute(comanda);

					if (aberturaComanda) {
						validaComandaNaoAberta.execute(comanda);
					}

					Comanda comandaAberta = comandaDao.selectComandaByNumero(comanda.getNumero());
					if (comandaAberta != null) {
						comandasEmAberto.add(comanda);
						comanda.setCliente(comandaAberta.getCliente());
					}
				} catch (ComandaException e) {
					ComandaInvalida comandaInvalida = new ComandaInvalida().setStatus(e.getStatus())
							.setMessage(e.getMessage());

					comanda.setComandaInvalida(comandaInvalida);
					comandasInvalidas.add(comanda);
				}
			}

			if (CollectionsUtils.isNullOrEmpty(comandasInvalidas) && !CollectionsUtils.isNullOrEmpty(comandas)) {

				List<ComandaBBIFood> comandasBBIFood = comandas.stream().map(com -> new ComandaBBIFood(com))
						.collect(Collectors.toList());

				comandaDao.insertOrUpdateComandas(comandasBBIFood);
				comandasAbertas.addAll(comandas);
			}

			return new EntradaResult().setComandasEmAberto(comandasEmAberto).setComandasInvalidas(comandasInvalidas)
					.setComandasAbertas(comandasAbertas).setOk(true).setMessage("OK");

		} catch (BBIException e) {
			return new EntradaResult().setOk(false).setMessage(e.getMessage());
		}
	}
}
