package web_cardapio.br.com.bitbyte.enums;

public enum FormaAtendimento {
	
	NAO_SELECIONADO(""),
	MESA("mesa"),
	COMANDA("comanda"),
	TAG("tag");
	
	private String formaAtendimento;
	
	FormaAtendimento(String formaAtendimento){
		this.formaAtendimento = formaAtendimento;
	}
	
	public String getValue() {
		return formaAtendimento;
	}

}
