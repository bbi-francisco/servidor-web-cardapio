package web_cardapio.br.com.bitbyte.results;

import java.util.List;

import web_cardapio.br.com.bitbyte.models.Comanda;
import web_cardapio.br.com.bitbyte.utils.ListUtils;
import web_cardapio.br.com.bitbyte.utils.StringUtils;

public class EntradaResult {
	
	private String message;
	private List<Comanda> comandasInvalidas;
	private List<Comanda> comandasEmAberto;
	private List<Comanda> comandasAbertas;
	private boolean ok;

	public List<Comanda> getComandasInvalidas() {
		return ListUtils.getEmptyIfNull(comandasInvalidas);
	}

	public EntradaResult setComandasInvalidas(List<Comanda> comandaInvalida) {
		this.comandasInvalidas = comandaInvalida;
		return this;
	}

	public List<Comanda> getComandasEmAberto() {
		return ListUtils.getEmptyIfNull(comandasEmAberto);
	}

	public EntradaResult setComandasEmAberto(List<Comanda> comandasEmAberto) {
		this.comandasEmAberto = comandasEmAberto;
		return this;
	}

	public String getMessage() {
		return StringUtils.getEmptyIfNull(message);
	}

	public EntradaResult setMessage(String message) {
		this.message = message;
		return this;
	}

	public List<Comanda> getComandasAbertas() {
		return ListUtils.getEmptyIfNull(comandasAbertas);
	}

	public EntradaResult setComandasAbertas(List<Comanda> comandasAbertas) {
		this.comandasAbertas = comandasAbertas;
		return this;
	}

	public boolean isOk() {
		return ok;
	}

	public EntradaResult setOk(boolean ok) {
		this.ok = ok;
		return this;
	}
	
	
}
