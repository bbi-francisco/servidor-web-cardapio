package web_cardapio.br.com.bitbyte.enums;

public enum TipoIngrediente {
	ACRESCENTAR("A"), RETIRAR("D");

	private String tipo;

	private TipoIngrediente(String valor) {
		this.tipo = valor;
	}

	public String getValor() {
		return tipo;
	}
}
