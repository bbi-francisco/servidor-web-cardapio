package web_cardapio.br.com.bitbyte.factories.servicefactories;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import web_cardapio.br.com.bitbyte.enums.ServiceType;
import web_cardapio.br.com.bitbyte.services.controlecomandas.AberturaServiceControleComandas;
import web_cardapio.br.com.bitbyte.services.interfaces.ValidarComandaService;
import web_cardapio.br.com.bitbyte.services.play.ValidarComandaServicePlay;
import web_cardapio.br.com.bitbyte.services.tablet.ValidarComandaServiceTablet;

@Component
public class ValidarComandaFactory {
	
	@Autowired
	private ValidarComandaServicePlay validarComandaServicePlay;
	
	@Autowired
	private AberturaServiceControleComandas aberturaServiceControleComandas;
	
	@Autowired
	private ValidarComandaServiceTablet validarComandaServiceTablet;
	
	public ValidarComandaService getService(ServiceType serviceType) throws SQLException 
	{
		String service = serviceType.getService().toUpperCase();
		if(ServiceType.CARDAPIO_PLAY.getService().equals(service)) {
			return validarComandaServicePlay;
		}
		else if(ServiceType.CONTROLE_COMANDAS.getService().equals(service)) {
			return aberturaServiceControleComandas;
		}
		else {
			return validarComandaServiceTablet;
		}
	}

}
