package web_cardapio.br.com.bitbyte.services.integracao;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web_cardapio.br.com.bitbyte.command.ValidaComandaBloqueada;
import web_cardapio.br.com.bitbyte.command.ValidaComandaFechada;
import web_cardapio.br.com.bitbyte.command.ValidaComandaNaoAberta;
import web_cardapio.br.com.bitbyte.dao.PagamentoParcialDao;
import web_cardapio.br.com.bitbyte.dao.ParametroDao;
import web_cardapio.br.com.bitbyte.dao.PedidosDao;
import web_cardapio.br.com.bitbyte.exceptions.BBIException;
import web_cardapio.br.com.bitbyte.models.Comanda;
import web_cardapio.br.com.bitbyte.models.Conta;
import web_cardapio.br.com.bitbyte.models.Item;
import web_cardapio.br.com.bitbyte.models.PagamentoParcial;
import web_cardapio.br.com.bitbyte.services.interfaces.ConsultarContaService;

@Service
public class ConsultarContaServiceIntegracao implements ConsultarContaService {
	
	@Autowired
	private ParametroDao parametroDao;
	
	@Autowired
	private PedidosDao pedidosDao;
	
	@Autowired
	private PagamentoParcialDao pagamentoParcialDao;
	
	@Autowired
	private ValidaComandaBloqueada validaComandaBloqueada;
	
	@Autowired
	private ValidaComandaFechada validaComandaFechada;
	
	@Autowired
	private ValidaComandaNaoAberta validaComandaNaoAberta;

	@Override
	public Conta getConta(Comanda comanda) throws BBIException, SQLException, IllegalAccessException 
	{
		validarComanda(comanda);
		
		List<Item> itensPedidos = pedidosDao.getItensPedido(comanda);
		List<PagamentoParcial> pagamentosParciais = pagamentoParcialDao.getPagamentosParciais(comanda);
		
		BigDecimal taxa = parametroDao.taxa(comanda.getNumero());
		
		return new Conta()
				.setTaxa(taxa)
				.setPagamentosParciais(pagamentosParciais)
				.setItensPedidos(itensPedidos)
				.setComanda(comanda);
	}
	
	private void validarComanda(Comanda comanda) throws SQLException, BBIException {
		validaComandaBloqueada.execute(comanda);
		validaComandaFechada.execute(comanda, true);
		validaComandaNaoAberta.execute(comanda);
	}

}