package web_cardapio.br.com.bitbyte.models.bbifood;

import web_cardapio.br.com.bitbyte.models.Atendente;
import web_cardapio.br.com.bitbyte.utils.StringFormatterBuilder;

public class AtendenteBBIFood {
	
	private final Atendente atendente;
	private StringFormatterBuilder builder;
	
	public AtendenteBBIFood(Atendente atendente) {
		this.atendente = atendente;
		this.builder = new StringFormatterBuilder();
	}
	
	
	public String getCodigo() {
		return builder
				.limitarCaracteres(6)
				.trim()
				.removerLetras()
				.removerAcentos()
				.build(atendente.getCodigo());
	}
	
	public String getUsuario() {
		return builder
				.limitarCaracteres(20)
				.trim()
				.build(atendente.getUsuario());
	}
	
	public String getSenha() {
		return builder
				.limitarCaracteres(20)
				.trim()
				.build(atendente.getSenha());
	}
	

}
