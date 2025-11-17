package web_cardapio.br.com.bitbyte.models;

import java.util.List;

import web_cardapio.br.com.bitbyte.utils.ListUtils;

public class CardapioInfo {
	
	private List<ProdInfo> prodInfos;

	public List<ProdInfo> getProdInfos() {
		return ListUtils.getEmptyIfNull(prodInfos);
	}

	public CardapioInfo setProdInfos(List<ProdInfo> prodInfos) {
		this.prodInfos = prodInfos;
		return this;
	}
	
	

}
