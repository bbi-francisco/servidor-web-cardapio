package web_cardapio.br.com.bitbyte.models;

import web_cardapio.br.com.bitbyte.utils.StringUtils;

public class ChamarGarcom {
	
    private Comanda comanda;
    private String obs;
    	
	public Comanda getComanda() {
		return comanda;
	}
	public ChamarGarcom setComanda(Comanda comanda) {
		this.comanda = comanda;
		return this;
	}
	public String getObs() {
		return StringUtils.getEmptyIfNull(obs);
	}
	public ChamarGarcom setObs(String obs) {
		this.obs = obs;
		return this;
	}
	
	
}
