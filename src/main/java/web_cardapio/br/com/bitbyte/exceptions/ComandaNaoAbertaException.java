package web_cardapio.br.com.bitbyte.exceptions;

import web_cardapio.br.com.bitbyte.enums.BBIStatus;
import web_cardapio.br.com.bitbyte.estatico.StatusComanda;

/**
 * Verifica se a comanda não foi aberta ainda. HTTP STATUS: 472
 * @author User
 *
 */
public class ComandaNaoAbertaException extends ComandaException
{
	public ComandaNaoAbertaException(String msg) {
		 super(msg);
	 }
	 public ComandaNaoAbertaException(String msg, Throwable cause) {
		 super(msg, cause);
	 }
	 
	 public int getStatus() {
		 return BBIStatus.Comanda.COMANDA_NAO_ABERTA;
	 }
}
