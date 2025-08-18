package web_cardapio.br.com.bitbyte.exceptions;

import web_cardapio.br.com.bitbyte.enums.BBIStatus;

public class ComandaQrCodeInvalidoException extends ComandaException
{
	 public ComandaQrCodeInvalidoException(String msg) {
		 super(msg);
	 }
	 public ComandaQrCodeInvalidoException(String msg, Throwable cause) {
		 super(msg, cause);
	 }
	 
	 public int getStatus() {
		 return BBIStatus.Comanda.QR_CODE_INVALIDO;
	 }
}
