package web_cardapio.br.com.bitbyte.exceptions;

import org.springframework.http.HttpStatus;

public class AtendenteNaoEncontradoException extends AtendenteException {
	
	public AtendenteNaoEncontradoException(String msg) {
		 super(msg);
	 }
	 public AtendenteNaoEncontradoException(String msg, Throwable cause) {
		 super(msg, cause);
	 }
	@Override
	public int getStatus() {
		return HttpStatus.NOT_FOUND.value();
	}
}
