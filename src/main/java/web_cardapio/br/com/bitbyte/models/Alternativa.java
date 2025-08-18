package web_cardapio.br.com.bitbyte.models;

import web_cardapio.br.com.bitbyte.utils.StringUtils;

public class Alternativa {
	
	private String descricao;
	private int codigo;

	public String getDescricao() {
		return StringUtils.getEmptyIfNull(descricao);
	}

	public Alternativa setDescricao(String descricao) {
		this.descricao = descricao;
		return this;
	}

	public int getCodigo() {
		return codigo;
	}

	public Alternativa setCodigo(int codigo) {
		this.codigo = codigo;
		return this;
	}
}
