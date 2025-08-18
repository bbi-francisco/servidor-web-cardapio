package web_cardapio.br.com.bitbyte.services.tablet;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web_cardapio.br.com.bitbyte.command.ValidaComandaBloqueada;
import web_cardapio.br.com.bitbyte.command.ValidaComandaNaoAberta;
import web_cardapio.br.com.bitbyte.dao.ComandaDao;
import web_cardapio.br.com.bitbyte.dao.PagamentoParcialDao;
import web_cardapio.br.com.bitbyte.dao.ParametroDao;
import web_cardapio.br.com.bitbyte.dao.PedidosDao;
import web_cardapio.br.com.bitbyte.enums.FormaAtendimento;
import web_cardapio.br.com.bitbyte.exceptions.BBIException;
import web_cardapio.br.com.bitbyte.models.Cliente;
import web_cardapio.br.com.bitbyte.models.Comanda;
import web_cardapio.br.com.bitbyte.models.Conta;
import web_cardapio.br.com.bitbyte.models.FechamentoComanda;
import web_cardapio.br.com.bitbyte.models.Item;
import web_cardapio.br.com.bitbyte.models.PagamentoParcial;
import web_cardapio.br.com.bitbyte.repositories.ClienteRepository;
import web_cardapio.br.com.bitbyte.services.interfaces.ConsultarContaService;
import web_cardapio.br.com.bitbyte.servidorandroid.ConnectionFactoryAndroid;
import web_cardapio.com.embarcadero.javaandroid.DBXException;
import web_cardapio.com.embarcadero.javaandroid.DSProxy;

@Service
public class ConsultarContaServiceTablet implements ConsultarContaService {
	
	@Autowired
	private ParametroDao parametroDao;
	
	@Autowired
	private PedidosDao pedidosDao;
	
	@Autowired
	private PagamentoParcialDao pagamentoParcialDao;
	
	@Autowired
	private ComandaDao comandaDao;
	
	@Autowired
	private ValidaComandaBloqueada validaComandaBloqueada;
	
	@Autowired
	private ValidaComandaNaoAberta validaComandaNaoAberta;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private ConnectionFactoryAndroid connectionFactoryAndroid;

	@Override
	public Conta getConta(Comanda comanda) throws Exception 
	{
		try {
			validarComanda(comanda);
			
			List<Item> itensPedidos = pedidosDao.getItensPedido(comanda);
			List<PagamentoParcial> pagamentosParciais = pagamentoParcialDao.getPagamentosParciais(comanda);
			
			BigDecimal taxa = parametroDao.taxa(comanda.getNumero());
			
			Cliente cliente = clienteRepository.getCliente(String.valueOf(comanda.getNumero()));
			comanda.setCliente(cliente);
			
			
			Comanda comandaBuscada = comandaDao.selectComandaByNumero(comanda.getNumero());
			String idTag = comandaBuscada.getIdTag();
			comanda.setIdTag(idTag);
			
			Conta conta = new Conta()
					.setTaxa(taxa)
					.setPagamentosParciais(pagamentosParciais)
					.setItensPedidos(itensPedidos)
					.setComanda(comanda);
			
			if(FormaAtendimento.TAG.equals(comanda.getFormaAtendimento())) {
				DSProxy.TSvrMethod svr = new DSProxy.TSvrMethod(connectionFactoryAndroid.getConnection());
				BigDecimal credito = new BigDecimal(svr.GetCreditoEasyChopp(idTag));
				conta.setCreditoEasyChopp(credito);
			}
			
			
			int numeroComanda = comanda.getNumero();
			FechamentoComanda fechamentoComanda = comandaDao.verificarComandaFechada(numeroComanda);
			conta.setAberta(!fechamentoComanda.isFechada());
			
			return conta;
		}
		catch (DBXException e) {
			throw new Exception(e);
		}
	}
	
	private void validarComanda(Comanda comanda) throws SQLException, BBIException {
		validaComandaBloqueada.execute(comanda);
		validaComandaNaoAberta.execute(comanda);
	}
	
}
