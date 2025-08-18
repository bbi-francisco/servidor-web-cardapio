package web_cardapio.br.com.bitbyte.models;

import web_cardapio.br.com.bitbyte.utils.StringUtils;

public class ComandaInvalida {
	
	private String message;
	private int status;
	
	public String getMessage() {
		return StringUtils.getEmptyIfNull(message);
	}
	public ComandaInvalida setMessage(String message) {
		this.message = message;
		return this;
	}
	
	public int getStatus() {
		return status;
	}
	public ComandaInvalida setStatus(int status) {
		this.status = status;
		return this;
	}
	
}
