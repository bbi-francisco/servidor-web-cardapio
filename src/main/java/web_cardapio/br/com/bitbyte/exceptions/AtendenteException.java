package web_cardapio.br.com.bitbyte.exceptions;

public abstract class AtendenteException extends BBIException {

	public AtendenteException(String msg) {
		 super(msg);
	 }
	 public AtendenteException(String msg, Throwable cause) {
		 super(msg, cause);
	 }
}
