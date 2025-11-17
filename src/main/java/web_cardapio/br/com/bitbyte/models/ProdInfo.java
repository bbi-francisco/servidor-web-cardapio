package web_cardapio.br.com.bitbyte.models;

import web_cardapio.br.com.bitbyte.utils.StringUtils;

public class ProdInfo {
	
	private boolean disponivel;
	private boolean utilizaCardapioDigital;
	private String codigo;

	public boolean isDisponivel() {
		return disponivel;
	}

	public ProdInfo setDisponivel(boolean disponivel) {
		this.disponivel = disponivel;
		return this;
	}

	public boolean isUtilizaCardapioDigital() {
		return utilizaCardapioDigital;
	}

	public ProdInfo setUtilizaCardapioDigital(boolean utilizaCardapioDigital) {
		this.utilizaCardapioDigital = utilizaCardapioDigital;
		return this;
	}

	public String getCodigo() {
		return StringUtils.getEmptyIfNull(codigo);
	}

	public ProdInfo setCodigo(String codigo) {
		this.codigo = codigo;
		return this;
	}
	
	
	
	
}
