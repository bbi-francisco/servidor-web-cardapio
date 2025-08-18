package web_cardapio.br.com.bitbyte.repositories;

import java.sql.SQLException;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import web_cardapio.br.com.bitbyte.command.ValidaComandaNaoAberta;
import web_cardapio.br.com.bitbyte.dao.ComandaDao;
import web_cardapio.br.com.bitbyte.estatico.Parametros;
import web_cardapio.br.com.bitbyte.exceptions.ComandaException;
import web_cardapio.br.com.bitbyte.models.bbifood.ComandaBBIFood;
import web_cardapio.br.com.bitbyte.models.Comanda;

@Repository
public class ComandaRepository {
	
	@Autowired
	private ComandaDao comandaDao;
	
	@Autowired
	private ValidaComandaNaoAberta validaComandaNaoAberta;
	
	@Autowired
	private BbiParamService bbiParamService;
	
	public void verificarAbreComanda(Comanda comanda) throws SQLException, ComandaException {
		
		int numeroComanda = comanda.getNumero();
		boolean aberturaComanda = bbiParamService.aberturaComanda();
		if(aberturaComanda) 
		{
			validaComandaNaoAberta.execute(comanda);
		}else 
		{
			Comanda comandaBuscada = comandaDao.selectComandaByNumero(numeroComanda);
			if(comandaBuscada == null) {
				comandaDao.insertOrUpdateComandas(Arrays.asList(new ComandaBBIFood(comanda)));
			}	
		}
	}

}
