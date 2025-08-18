package web_cardapio.br.com.bitbyte.format;

import java.util.ArrayList;
import java.util.List;

import web_cardapio.br.com.bitbyte.interfaces.Identificavel;

public class CodigosFormatter<T> {
	
	private SeparatorFormatter separatorFormatter = new SeparatorFormatter();
	
	public String format(List<? extends Identificavel<T>> objects) {
		List<T> codigos = new ArrayList<>();
		
		for(Identificavel<T> object : objects) {
			codigos.add(object.getCodigo());
		}
		return separatorFormatter.format(codigos);
	}
	
	public CodigosFormatter<T> appendLast(boolean appendLast){
		this.separatorFormatter.appendLast(appendLast);
		return this;
	}
	
	public CodigosFormatter<T> setSeparator(String separator){
		this.separatorFormatter.setSeparator(separator);
		return this;
	}

}
