package web_cardapio.br.com.bitbyte.models;

import web_cardapio.br.com.bitbyte.utils.StringUtils;

public class BloqueioComanda {
	
	private String motivo;
	private int numeroComanda;
	private boolean bloqueada;
	
	public String getMotivo() {
		return StringUtils.getEmptyIfNull(motivo);
	}
	
	public BloqueioComanda setMotivo(String motivo) {
		this.motivo = motivo;
		return this;
	}
	
	public int getNumeroComanda() {
		return numeroComanda;
	}
	
	public BloqueioComanda setNumeroComanda(int numeroComanda) {
		this.numeroComanda = numeroComanda;
		return this;
	}

	public boolean isBloqueada() {
		return bloqueada;
	}

	public BloqueioComanda setBloqueada(boolean bloqueada) {
		this.bloqueada = bloqueada;
		return this;
	}
}
