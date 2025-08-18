package web_cardapio.br.com.bitbyte.results;

import java.util.List;

import web_cardapio.br.com.bitbyte.models.Comanda;
import web_cardapio.br.com.bitbyte.utils.CollectionsUtils;

public class FecharContaResult {
	
	private List<Comanda> comandas;

	public List<Comanda> getComandas() {
		return CollectionsUtils.getEmptyIfNull(comandas);
	}

	public FecharContaResult setComandas(List<Comanda> comandas) {
		this.comandas = comandas;
		return this;
	}
	
	
	
}
