package web_cardapio.br.com.bitbyte.exceptions;

public abstract class BBIException extends Exception {
	
	public BBIException(String msg) {
		 super(msg);
	 }
	 public BBIException(String msg, Throwable cause) {
		 super(msg, cause);
	 }
	 
	 public abstract int getStatus();
}
