package web_cardapio.br.com.bitbyte.models;

public class FechamentoComanda {
	
	private int numeroComanda;
	private boolean fechada;
	
	public int getNumeroComanda() {
		return numeroComanda;
	}
	
	public FechamentoComanda setNumeroComanda(int numeroComanda) {
		this.numeroComanda = numeroComanda;
		return this;
	}
	
	public boolean isFechada() {
		return fechada;
	}
	
	public FechamentoComanda setFechada(boolean fechada) {
		this.fechada = fechada;
		return this;
	}
}
