package web_cardapio.br.com.bitbyte.enums;

import web_cardapio.br.com.bitbyte.utils.StringFormatterBuilder;

public class Integracoes {
	
	public static final String GOOMER = "GOOMER";
	private StringFormatterBuilder formatter;
	
	public Integracoes() {
		formatter = new StringFormatterBuilder();
	}
	public boolean isGoomer(String canal) {
		return formatter
				.trim()
				.toUpperCase()
				.removerAcentos()
				.build(canal)
				.equals(GOOMER);
	}
}
