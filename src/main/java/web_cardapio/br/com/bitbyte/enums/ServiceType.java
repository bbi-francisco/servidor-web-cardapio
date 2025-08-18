package web_cardapio.br.com.bitbyte.enums;

import web_cardapio.br.com.bitbyte.utils.StringUtils;

public enum ServiceType {
	
	CARDAPIO_PLAY("CARDAPIO_PLAY"),
	CARDAPIO_TABLET("CARDAPIO_TABLET"),
	CONTROLE_COMANDAS("CONTROLE_COMANDAS"),
	INTEGRACAO("INTEGRACAO");
	
	private String service;
	
	ServiceType(String application) {
		this.service = application;
	}

	public String getService() 
	{
		return StringUtils.getEmptyIfNull(service);
	}
	
	public static ServiceType getServiceType(String serviceType)
	{
		String service = StringUtils.getEmptyIfNull(serviceType).trim().toUpperCase();
		if(CARDAPIO_PLAY.getService().equals(service)) {
			return CARDAPIO_PLAY;
		}
		if(CARDAPIO_TABLET.getService().equals(service)) {
			return CARDAPIO_TABLET;
		}
		if(CONTROLE_COMANDAS.getService().equals(service)) {
			return CONTROLE_COMANDAS;
		}
		if(INTEGRACAO.getService().equals(service)) {
			return INTEGRACAO;
		}
		return null;
	}
}
