package web_cardapio.br.com.bitbyte.models;

import java.util.List;

public class RespostasPesquisa {
	
	private int idPesquisa;
	private List<Resposta> respostas;
	private int numeroComanda;
	
	public int getIdPesquisa() {
		return idPesquisa;
	}
	public RespostasPesquisa setIdPesquisa(int idPesquisa) {
		this.idPesquisa = idPesquisa;
		return this;
	}
	public List<Resposta> getRespostas() {
		return respostas;
	}
	public RespostasPesquisa setRespostas(List<Resposta> respostas) {
		this.respostas = respostas;
		return this;
	}
	public int getNumeroComanda() {
		return numeroComanda;
	}
	public RespostasPesquisa setNumeroComanda(int numeroComanda) {
		this.numeroComanda = numeroComanda;
		return this;
	}
	
	
}
