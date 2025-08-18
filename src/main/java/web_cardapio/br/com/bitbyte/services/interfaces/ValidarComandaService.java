package web_cardapio.br.com.bitbyte.services.interfaces;

import java.sql.SQLException;
import java.util.List;
import web_cardapio.br.com.bitbyte.exceptions.BBIException;
import web_cardapio.br.com.bitbyte.models.Comanda;
import web_cardapio.br.com.bitbyte.results.ComandaValidationResult;

public interface ValidarComandaService 
{
	ComandaValidationResult validar(List<Comanda> comandas) throws 
	SQLException, 
	BBIException;
	
	
}
