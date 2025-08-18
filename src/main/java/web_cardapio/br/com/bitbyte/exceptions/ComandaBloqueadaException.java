package web_cardapio.br.com.bitbyte.exceptions;

import web_cardapio.br.com.bitbyte.enums.BBIStatus;

public class ComandaBloqueadaException extends ComandaException
{
	 public ComandaBloqueadaException(String msg) {
		 super(msg);
	 }
	 public ComandaBloqueadaException(String msg, Throwable cause) {
		 super(msg, cause);
	 }
	 
	 public int getStatus() {
		 return BBIStatus.Comanda.COMANDA_BLOQUEADA;
	 }
}