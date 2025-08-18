package web_cardapio.br.com.bitbyte.enums;

public enum RestricaoType {
	
	PRODUTO("tbprod_restri", "codprod"),
	SUBGRUPO("tbsubgru_restri", "codsubgru");
	
	private String nomeTabela;
	private String campoCodigo;

	RestricaoType(String nomeTabela, String campoCodigo){
		this.nomeTabela = nomeTabela;
		this.campoCodigo = campoCodigo;
	}

	public String getNomeTabela() {
		return nomeTabela;
	}

	public String getCampoCodigo() {
		return campoCodigo;
	}
}
