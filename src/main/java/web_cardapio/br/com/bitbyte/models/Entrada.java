package web_cardapio.br.com.bitbyte.models;

import java.util.Collections;
import java.util.List;

import web_cardapio.br.com.bitbyte.enums.FormaAtendimento;

public class Entrada {
	
	private Atendente atendente;
    private Integer mesa;
    private FormaAtendimento formaAtendimento;
    private List<Comanda> comandas;

	public Integer getMesa() {
		return mesa;
	}

	public Entrada setMesa(Integer mesa) {
		this.mesa = mesa;
		return this;
	}

	public FormaAtendimento getFormaAtendimento() {
		return formaAtendimento;
	}

	public Entrada setFormaAtendimento(FormaAtendimento formaAtendimento) {
		this.formaAtendimento = formaAtendimento;
		return this;
	}

	public List<Comanda> getComandas() {
		return comandas != null ? comandas : Collections.emptyList();
	}

	public Entrada setComandas(List<Comanda> comandas) {
		this.comandas = comandas;
		return this;
	}

	public Atendente getAtendente() {
		return atendente;
	}

	public Entrada setAtendente(Atendente atendente) {
		this.atendente = atendente;
		return this;
	}
}
