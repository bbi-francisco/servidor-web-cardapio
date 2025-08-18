package web_cardapio.br.com.bitbyte.exceptions;

import web_cardapio.br.com.bitbyte.enums.BBIStatus;

public class ComandaSemItensException extends ComandaException {

	public ComandaSemItensException(String msg) {
		 super(msg);
	}
	 
	 public int getStatus() {
		 return BBIStatus.Comanda.COMANDA_SEM_ITENS;
	 }
}
