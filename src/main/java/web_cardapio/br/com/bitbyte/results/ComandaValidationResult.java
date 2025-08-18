package web_cardapio.br.com.bitbyte.results;

import java.util.List;

import web_cardapio.br.com.bitbyte.models.Comanda;
import web_cardapio.br.com.bitbyte.utils.CollectionsUtils;

public class ComandaValidationResult {
	
	private List<Comanda> comandas;
	private String message;
	private int status;

	public List<Comanda> getComandas() {
		return CollectionsUtils.getEmptyIfNull(comandas);
	}

	public ComandaValidationResult setComandas(List<Comanda> comandas) {
		this.comandas = comandas;
		return this;
	}

	public String getMessage() {
		return message;
	}

	public ComandaValidationResult setMessage(String message) {
		this.message = message;
		return this;
	}

	public int getStatus() {
		return status;
	}

	public ComandaValidationResult setStatus(int status) {
		this.status = status;
		return this;
	}
	
	
}
