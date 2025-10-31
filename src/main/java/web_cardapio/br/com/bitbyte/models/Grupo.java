package web_cardapio.br.com.bitbyte.models;

import web_cardapio.br.com.bitbyte.utils.StringUtils;

public class Grupo {
	private String codigo;
	private String descricao;
	private String img;
	private boolean utilizaCardapioDigital;
	private int indice;
	
	public String getCodigo() {
		return StringUtils.getEmptyIfNull(codigo);
	}
	public Grupo setCodigo(String codigo) {
		this.codigo = codigo;
		return this;
	}
	public String getDescricao() {
		return StringUtils.getEmptyIfNull(descricao);
	}
	public Grupo setDescricao(String descricao) {
		this.descricao = descricao;
		return this;
	}
	public String getImg() {
		return StringUtils.getEmptyIfNull(img);
	}
	public Grupo setImg(String img) {
		this.img = img;
		return this;
	}
	
	public boolean utilizaCardapioDigital() {
		return utilizaCardapioDigital;
	}
	public Grupo setUtilizaCardapioDigital(boolean utilizaCardapioDigital) {
		this.utilizaCardapioDigital = utilizaCardapioDigital;
		return this;
	}
	public int getIndice() {
		return indice;
	}
	public Grupo setIndice(int indice) {
		this.indice = indice;
		return this;
	}
	
	
}
