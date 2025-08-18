package web_cardapio.br.com.bitbyte.models;

public class IntervaloComanda {
	
	public int numeroComanda;
	public int comandaInicial;
	public int comandaFinal;
	
	public int getComandaInicial() {
		return comandaInicial;
	}
	
	public IntervaloComanda setComandaInicial(int valorInicial) {
		this.comandaInicial = valorInicial;
		return this;
	}
	
	public int getComandaFinal() {
		return comandaFinal;
	}
	
	public IntervaloComanda setComandaFinal(int valorFinal) {
		this.comandaFinal = valorFinal;
		return this;
	}

	public int getNumeroComanda() {
		return numeroComanda;
	}

	public IntervaloComanda setNumeroComanda(int numeroComanda) {
		this.numeroComanda = numeroComanda;
		return this;
	}
	
	public boolean isInvalid() {
		return numeroComanda > comandaFinal || numeroComanda < comandaInicial;
	}
}
