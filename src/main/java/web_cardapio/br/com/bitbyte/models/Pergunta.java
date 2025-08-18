package web_cardapio.br.com.bitbyte.models;

import java.util.List;

import web_cardapio.br.com.bitbyte.utils.CollectionsUtils;
import web_cardapio.br.com.bitbyte.utils.StringUtils;

public class Pergunta {
	
	private int id;
	private String pergunta;
	private List<Alternativa> alternativas;
	private int ordem;
	
	public int getId() {
		return id;
	}
	public Pergunta setId(int id) {
		this.id = id;
		return this;
	}
	public String getPergunta() {
		return StringUtils.getEmptyIfNull(pergunta);
	}
	public Pergunta setPergunta(String pergunta) {
		this.pergunta = pergunta;
		return this;
	}
	public List<Alternativa> getAlternativas() {
		return CollectionsUtils.getEmptyIfNull(alternativas);
	}
	public Pergunta setAlternativas(List<Alternativa> alternativas) {
		this.alternativas = alternativas;
		return this;
	}
	public int getOrdem() {
		return ordem;
	}
	public Pergunta setOrdem(int ordem) {
		this.ordem = ordem;
		return this;
	}
	
	
	
	
}
