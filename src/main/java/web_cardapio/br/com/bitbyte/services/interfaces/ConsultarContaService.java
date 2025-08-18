package web_cardapio.br.com.bitbyte.services.interfaces;

import web_cardapio.br.com.bitbyte.models.Comanda;
import web_cardapio.br.com.bitbyte.models.Conta;

public interface ConsultarContaService {
	
	Conta getConta(Comanda comanda) throws Exception;

}
