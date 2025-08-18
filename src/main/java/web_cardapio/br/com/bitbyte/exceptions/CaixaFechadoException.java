package web_cardapio.br.com.bitbyte.exceptions;

import web_cardapio.br.com.bitbyte.enums.BBIStatus;

public class CaixaFechadoException extends BBIException
{
	 public CaixaFechadoException(String msg) {
		 super(msg);
	 }
	 public CaixaFechadoException(String msg, Throwable cause) {
		 super(msg, cause);
	 }
	 
	 public int getStatus() {
		 return BBIStatus.CAIXA_FECHADO;
	 }
}
