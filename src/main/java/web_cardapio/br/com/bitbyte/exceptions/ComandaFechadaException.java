package web_cardapio.br.com.bitbyte.exceptions;

import web_cardapio.br.com.bitbyte.enums.BBIStatus;

public class ComandaFechadaException extends ComandaException
{
	 public ComandaFechadaException(String msg) {
		 super(msg);
	 }
	 public ComandaFechadaException(String msg, Throwable cause) {
		 super(msg, cause);
	 }
	 
	 public int getStatus() {
		 return BBIStatus.Comanda.COMANDA_FECHADA;
	 }
}