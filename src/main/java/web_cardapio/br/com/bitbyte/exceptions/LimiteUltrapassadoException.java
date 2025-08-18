package web_cardapio.br.com.bitbyte.exceptions;

import web_cardapio.br.com.bitbyte.enums.BBIStatus;
import web_cardapio.br.com.bitbyte.estatico.StatusComanda;

public class LimiteUltrapassadoException extends ComandaException
{
	public LimiteUltrapassadoException(String msg) {
		 super(msg);
	 }
	 public LimiteUltrapassadoException(String msg, Throwable cause) {
		 super(msg, cause);
	 }
	 
	 public int getStatus() {
		 return BBIStatus.Comanda.LIMITE_ULTRAPASSADO;
	 }
}