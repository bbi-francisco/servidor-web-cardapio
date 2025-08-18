package web_cardapio.br.com.bitbyte.exceptions;

import web_cardapio.br.com.bitbyte.enums.BBIStatus;

public class ComandaException extends BBIException
{
	public ComandaException(String msg) {
		 super(msg);
	 }
	 public ComandaException(String msg, Throwable cause) {
		 super(msg, cause);
	 }
	 
	 public int getStatus() {
		 return BBIStatus.Comanda.COMANDA_INVALIDA;
	 }
}
