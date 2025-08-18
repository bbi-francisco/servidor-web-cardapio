package web_cardapio.br.com.bitbyte.models;

public class Grupo {
	private String codigo;
	private String descricao;
	private String img;
	private boolean utilizaCardapioDigital;
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	
	public boolean utilizaCardapioDigital() {
		return utilizaCardapioDigital;
	}
	public void setUtilizaCardapioDigital(boolean utilizaCardapioDigital) {
		this.utilizaCardapioDigital = utilizaCardapioDigital;
	}
}
