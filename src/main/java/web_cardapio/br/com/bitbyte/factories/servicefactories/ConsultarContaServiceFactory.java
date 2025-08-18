package web_cardapio.br.com.bitbyte.factories.servicefactories;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import web_cardapio.br.com.bitbyte.enums.ServiceType;
import web_cardapio.br.com.bitbyte.services.integracao.ConsultarContaServiceIntegracao;
import web_cardapio.br.com.bitbyte.services.interfaces.ConsultarContaService;
import web_cardapio.br.com.bitbyte.services.play.ConsultarContaServicePlay;
import web_cardapio.br.com.bitbyte.services.tablet.ConsultarContaServiceTablet;

@Component
public class ConsultarContaServiceFactory {
	
	@Autowired
	private ConsultarContaServicePlay consultarContaServicePlay;
	
	@Autowired
	private ConsultarContaServiceTablet consultarContaServiceTablet;
	
	public ConsultarContaService getService(ServiceType application) throws IllegalAccessException, SQLException {
		if(ServiceType.CARDAPIO_PLAY.equals(application)) {
			return consultarContaServicePlay;
		}
		else {
			return consultarContaServiceTablet;
		}
	}

}
