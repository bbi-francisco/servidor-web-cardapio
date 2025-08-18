package web_cardapio.br.com.bitbyte.models;

import web_cardapio.br.com.bitbyte.utils.StringUtils;

public class ComandaTag {

	private String tagUid;
	private String numeroComanda;
	
	public String getTagUid() {
		return StringUtils.getEmptyIfNull(tagUid);
	}
	
	public ComandaTag setTagUid(String tagUid) {
		this.tagUid = tagUid;
		return this;
	}
	
	public String getNumeroComanda() {
		return numeroComanda;
	}
	
	public ComandaTag setNumeroComanda(String numeroComanda) {
		this.numeroComanda = numeroComanda;
		return this;
	}
	
	
}
