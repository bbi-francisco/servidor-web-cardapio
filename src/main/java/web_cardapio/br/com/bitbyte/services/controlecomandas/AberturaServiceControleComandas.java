package web_cardapio.br.com.bitbyte.services.controlecomandas;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web_cardapio.br.com.bitbyte.command.ValidaComandaBloqueada;
import web_cardapio.br.com.bitbyte.command.ValidaComandaFechada;
import web_cardapio.br.com.bitbyte.command.ValidaComandaNaoAberta;
import web_cardapio.br.com.bitbyte.command.ValidaIntervaloComanda;
import web_cardapio.br.com.bitbyte.command.ValidaLimiteComanda;
import web_cardapio.br.com.bitbyte.command.ValidaCaixaAberto;
import web_cardapio.br.com.bitbyte.dao.ComandaDao;
import web_cardapio.br.com.bitbyte.estatico.Parametros;
import web_cardapio.br.com.bitbyte.exceptions.BBIException;
import web_cardapio.br.com.bitbyte.exceptions.ComandaException;
import web_cardapio.br.com.bitbyte.factories.ComandaFactory;
import web_cardapio.br.com.bitbyte.models.Comanda;
import web_cardapio.br.com.bitbyte.models.ComandaInvalida;
import web_cardapio.br.com.bitbyte.models.ValoresComanda;
import web_cardapio.br.com.bitbyte.models.bbifood.ComandaBBIFood;
import web_cardapio.br.com.bitbyte.repositories.BbiParamService;
import web_cardapio.br.com.bitbyte.repositories.ParametrosService;
import web_cardapio.br.com.bitbyte.results.ComandaValidationResult;
import web_cardapio.br.com.bitbyte.services.interfaces.ValidarComandaService;
import web_cardapio.br.com.bitbyte.utils.CollectionsUtils;

@Service
public class AberturaServiceControleComandas implements ValidarComandaService{
	
	@Autowired
	private BbiParamService bbiParamService;
	
	@Autowired
	private ValidaCaixaAberto validaCaixaAberto;
	
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
	
	@Autowired
	private ComandaDao comandaDao;

	@Override
	public ComandaValidationResult validar(List<Comanda> comandas) throws SQLException, BBIException 
	{
		if(CollectionsUtils.isNullOrEmpty(comandas)) {
			throw new IllegalArgumentException("Nenhuma comanda recebida para validação. ");
		}
		
		validaCaixaAberto.execute();
		ComandaFactory comandaFactory = new ComandaFactory();
		for(Comanda comanda : comandas) 
		{
			try {
				validaComandaBloqueada.execute(comanda);
				validaComandaFechada.execute(comanda, true);
				validaIntervaloComanda.execute(comanda);
				validaLimiteComanda.execute(comanda);
				
				Comanda comandaAtual = comandaDao.selectComandaByNumero(comanda.getNumero());
				if(comandaAtual != null) {
					comanda.setValoresComanda(comandaAtual.getValoresComanda());
				}else {
					comanda.setValoresComanda(comandaFactory.createValoresComandaInicial());
				}
				
				boolean aberturaComanda = bbiParamService.aberturaComanda();
		        if (aberturaComanda) {
		            validaComandaNaoAberta.execute(comanda);
		        }else {
		        	List<ComandaBBIFood> comandasBBIFood = comandas
		        			.stream()
		        			.map(com -> new ComandaBBIFood(com))
		        			.collect(Collectors.toList());
		        			
		        	comandaDao.insertOrUpdateComandas(comandasBBIFood);
		        }
			}catch(ComandaException e) 
			{
				ComandaInvalida comandaInvalida = new ComandaInvalida()
						.setStatus(e.getStatus())
						.setMessage(e.getMessage());
				
				comanda.setComandaInvalida(comandaInvalida);
			}
		}
		return new ComandaValidationResult()
				.setComandas(comandas);
	}
}
