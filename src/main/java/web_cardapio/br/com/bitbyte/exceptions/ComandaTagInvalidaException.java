package web_cardapio.br.com.bitbyte.exceptions;

import web_cardapio.br.com.bitbyte.enums.BBIStatus;

public class ComandaTagInvalidaException extends ComandaException{
	public ComandaTagInvalidaException(String msg) {
		 super(msg);
	 }
	 public ComandaTagInvalidaException(String msg, Throwable cause) {
		 super(msg, cause);
	 }
	 
	 public int getStatus() {
		 return BBIStatus.Comanda.TAG_INVALIDA;
	 }
}
