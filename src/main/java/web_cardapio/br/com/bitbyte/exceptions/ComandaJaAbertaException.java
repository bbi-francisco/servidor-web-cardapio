package web_cardapio.br.com.bitbyte.exceptions;

import web_cardapio.br.com.bitbyte.enums.BBIStatus;
import web_cardapio.br.com.bitbyte.estatico.StatusComanda;

public class ComandaJaAbertaException extends ComandaException
{
	 public ComandaJaAbertaException(String msg) {
		 super(msg);
	 }
	 public ComandaJaAbertaException(String msg, Throwable cause) {
		 super(msg, cause);
	 }
	 
	 public int getStatus() {
		 return BBIStatus.Comanda.COMANDA_JA_ABERTA;
	 }
}
