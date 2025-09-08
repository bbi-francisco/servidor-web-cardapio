package web_cardapio.br.com.bitbyte.models;

import java.util.List;

import web_cardapio.br.com.bitbyte.utils.ListUtils;

public class Questionario
{
	private List<Pergunta> perguntas;

	public List<Pergunta> getPerguntas() {
		return ListUtils.getEmptyIfNull(perguntas);
	}

	public Questionario setPerguntas(List<Pergunta> pergunta) {
		this.perguntas = pergunta;
		return this;
	}
}