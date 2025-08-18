package web_cardapio.br.com.bitbyte.services.play;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web_cardapio.br.com.bitbyte.command.ValidaCaixaAberto;
import web_cardapio.br.com.bitbyte.command.ValidaComandaBloqueada;
import web_cardapio.br.com.bitbyte.command.ValidaComandaFechada;
import web_cardapio.br.com.bitbyte.command.ValidaComandaNaoAberta;
import web_cardapio.br.com.bitbyte.command.ValidaIntervaloComanda;
import web_cardapio.br.com.bitbyte.command.ValidaLimitePedido;
import web_cardapio.br.com.bitbyte.dao.ComandaQrCodeAuthDao;
import web_cardapio.br.com.bitbyte.dao.PedidosDao;
import web_cardapio.br.com.bitbyte.exceptions.BBIException;
import web_cardapio.br.com.bitbyte.exceptions.ComandaException;
import web_cardapio.br.com.bitbyte.models.Comanda;
import web_cardapio.br.com.bitbyte.models.ComandaInvalida;
import web_cardapio.br.com.bitbyte.models.Pedido;
import web_cardapio.br.com.bitbyte.models.bbifood.PedidoBBIFood;
import web_cardapio.br.com.bitbyte.results.PedidosResult;
import web_cardapio.br.com.bitbyte.services.interfaces.SalvarPedidosService;

@Service
public class SalvarPedidosServicePlay implements SalvarPedidosService {
	
	@Autowired
	private PedidosDao pedidosDao;
	
	@Autowired
	private ValidaCaixaAberto validaCaixaAberto;
	
	@Autowired
	private ValidaComandaBloqueada validaComandaBloqueada;
	
	@Autowired
	private ValidaComandaFechada validaComandaFechada;
	
	@Autowired
	private ValidaComandaNaoAberta validaComandaNaoAberta;
	
	@Autowired
	private ComandaQrCodeAuthDao comandaQrCodeAuthDao;
	
	@Autowired
	private ValidaIntervaloComanda validaIntervaloComanda;
	
	@Autowired
	private ValidaLimitePedido validaLimitePedido;
	
	@Override
	public PedidosResult insertPedido(Pedido pedido) throws BBIException, SQLException 
	{
		validaCaixaAberto.execute();
		Comanda comanda = pedido.getComanda();
		
		try {
			validaComandaBloqueada.execute(comanda);
			validaComandaFechada.execute(comanda, true);
			validaComandaNaoAberta.execute(comanda);
			comandaQrCodeAuthDao.autenticar(comanda);
			
			validaIntervaloComanda.execute(comanda);
			validaLimitePedido.execute(pedido);
			
			pedidosDao.insertPedido(new PedidoBBIFood(pedido), true);
			
		} catch(ComandaException e) {
			
			ComandaInvalida comandaInvalida = new ComandaInvalida()
					.setStatus(e.getStatus())
					.setMessage(e.getMessage());
			comanda.setComandaInvalida(comandaInvalida);
		}
		
		return new PedidosResult().setComanda(comanda);
		
	}

	@Override
	public PedidosResult insertPedidosItem(List<Pedido> pedidos) throws SQLException, BBIException 
	{
		for(Pedido pedido : pedidos) {
			insertPedido(pedido);
		}
		return new PedidosResult()
				.setStatus(200)
				.setSuccess(true)
				.setMessage("OK");
	}

}
