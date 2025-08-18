package web_cardapio.br.com.bitbyte.models;

public class Resposta {
	
	private int idPergunta;
	private int alternativa;
	
	public int getIdPergunta() {
		return idPergunta;
	}
	
	public Resposta setIdPergunta(int idPergunta) {
		this.idPergunta = idPergunta;
		return this;
	}
	
	public int getAlternativa() {
		return alternativa;
	}
	
	public Resposta setAlternativa(int alternativa) {
		this.alternativa = alternativa;
		return this;
	}
}
