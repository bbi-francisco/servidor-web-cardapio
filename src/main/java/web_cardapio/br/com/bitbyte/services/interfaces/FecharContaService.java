package web_cardapio.br.com.bitbyte.services.interfaces;

import java.sql.SQLException;

import web_cardapio.br.com.bitbyte.exceptions.BBIException;
import web_cardapio.br.com.bitbyte.models.Comanda;
import web_cardapio.br.com.bitbyte.results.FecharContaResult;

public interface FecharContaService {
	
	FecharContaResult fecharConta(Comanda comanda) throws 
		SQLException, 
		BBIException;
}
