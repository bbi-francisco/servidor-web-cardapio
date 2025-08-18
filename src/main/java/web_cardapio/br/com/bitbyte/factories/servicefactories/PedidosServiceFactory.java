package web_cardapio.br.com.bitbyte.factories.servicefactories;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import web_cardapio.br.com.bitbyte.enums.ServiceType;
import web_cardapio.br.com.bitbyte.services.integracao.SalvarPedidosServiceIntegracao;
import web_cardapio.br.com.bitbyte.services.interfaces.SalvarPedidosService;
import web_cardapio.br.com.bitbyte.services.play.SalvarPedidosServicePlay;
import web_cardapio.br.com.bitbyte.services.tablet.SalvarPedidosServiceTablet;

@Component
public class PedidosServiceFactory {
	
	@Autowired
	private SalvarPedidosServicePlay salvarPedidosServicePlay;
	
	@Autowired
	private SalvarPedidosServiceIntegracao salvarPedidosServiceIntegracao;
	
	@Autowired
	private SalvarPedidosServiceTablet salvarPedidosServiceTablet;
	
	public SalvarPedidosService getService(ServiceType application) throws SQLException {
		if(ServiceType.CARDAPIO_PLAY.equals(application)) {
			return salvarPedidosServicePlay;
		}
		if(ServiceType.INTEGRACAO.equals(application)) {
			return salvarPedidosServiceIntegracao;
		}
		else {
			return salvarPedidosServiceTablet;
		}
	}
}
