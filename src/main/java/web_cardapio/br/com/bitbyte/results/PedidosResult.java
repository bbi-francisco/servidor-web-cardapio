package web_cardapio.br.com.bitbyte.results;

import web_cardapio.br.com.bitbyte.models.Comanda;
import web_cardapio.br.com.bitbyte.models.ComandaInvalida;
import web_cardapio.br.com.bitbyte.utils.StringUtils;

public class PedidosResult {
	
	private String message;
	private Comanda comanda;
	private int status;
	private boolean success;

	public String getMessage() {
		return StringUtils.getEmptyIfNull(message);
	}

	public PedidosResult setMessage(String message) {
		this.message = message;
		return this;
	}

	public Comanda getComanda() {
		return comanda;
	}

	public PedidosResult setComanda(Comanda comanda) {
		this.comanda = comanda;
		return this;
	}

	public int getStatus() {
		return status;
	}

	public PedidosResult setStatus(int status) {
		this.status = status;
		return this;
	}

	public boolean isSuccess() {
		return success;
	}

	public PedidosResult setSuccess(boolean success) {
		this.success = success;
		return this;
	}
}
