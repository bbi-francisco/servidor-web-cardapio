package web_cardapio.br.com.bitbyte.exceptions;

import web_cardapio.br.com.bitbyte.enums.BBIStatus;
import web_cardapio.br.com.bitbyte.estatico.StatusComanda;

public class DispositivoSemLicencaException extends ComandaException
{
	public DispositivoSemLicencaException(String msg) {
		 super(msg);
	 }
	 public DispositivoSemLicencaException(String msg, Throwable cause) {
		 super(msg, cause);
	 }
	 
	 public int getStatus() {
		 return BBIStatus.Comanda.SEM_LICENCA;
	 }
}