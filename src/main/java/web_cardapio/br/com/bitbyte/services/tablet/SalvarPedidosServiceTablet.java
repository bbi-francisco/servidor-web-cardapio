package web_cardapio.br.com.bitbyte.services.tablet;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web_cardapio.br.com.bitbyte.command.ValidaCaixaAberto;
import web_cardapio.br.com.bitbyte.command.ValidaComandaBloqueada;
import web_cardapio.br.com.bitbyte.command.ValidaComandaFechada;
import web_cardapio.br.com.bitbyte.command.ValidaIntervaloComanda;
import web_cardapio.br.com.bitbyte.command.ValidaLimitePedido;
import web_cardapio.br.com.bitbyte.dao.PedidosDao;
import web_cardapio.br.com.bitbyte.exceptions.BBIException;
import web_cardapio.br.com.bitbyte.exceptions.ComandaException;
import web_cardapio.br.com.bitbyte.models.Comanda;
import web_cardapio.br.com.bitbyte.models.ComandaInvalida;
import web_cardapio.br.com.bitbyte.models.Pedido;
import web_cardapio.br.com.bitbyte.models.bbifood.PedidoBBIFood;
import web_cardapio.br.com.bitbyte.repositories.ComandaRepository;
import web_cardapio.br.com.bitbyte.results.PedidosResult;
import web_cardapio.br.com.bitbyte.services.interfaces.SalvarPedidosService;

@Service
public class SalvarPedidosServiceTablet implements SalvarPedidosService {
	
	@Autowired
	private ValidaCaixaAberto validaCaixaAberto;
	
	@Autowired
	private ValidaComandaBloqueada validaComandaBloqueada;
	
	@Autowired
	private ValidaComandaFechada validaComandaFechada;
	
	@Autowired
	private ValidaIntervaloComanda validaIntervaloComanda;
	
	@Autowired
	private ValidaLimitePedido validaLimitePedido;
	
	@Autowired
	private ComandaRepository comandaRepository;
	
	@Autowired
	private PedidosDao pedidosDao;
	
	@Override
	public PedidosResult insertPedido(Pedido pedido) throws SQLException, BBIException 
	{
		Comanda comanda = pedido.getComanda();
		PedidosResult pedidosResult = new PedidosResult();
		try {
			validaCaixaAberto.execute();
			validaComandaBloqueada.execute(comanda);
			validaComandaFechada.execute(comanda, true);
			
			validaIntervaloComanda.execute(comanda);
			validaLimitePedido.execute(pedido);
			
			comandaRepository.verificarAbreComanda(comanda);
			
//			if(FormaAtendimento.COMANDA.equals(comanda.getFormaAtendimento())){
//				new ValidaComandaTag(comanda).execute();
//			}
			
			pedidosDao.insertPedido(new PedidoBBIFood(pedido), true);
			
		}catch(ComandaException e) 
		{
			ComandaInvalida comandaInvalida = new ComandaInvalida()
			.setMessage(e.getMessage())
			.setStatus(e.getStatus());
			comanda.setComandaInvalida(comandaInvalida);
		}
		return pedidosResult.setComanda(comanda);
	}

	@Override
	public PedidosResult insertPedidosItem(List<Pedido> pedidos) throws SQLException, BBIException {
		for(Pedido pedido : pedidos) {
			insertPedido(pedido);
		}
		return new PedidosResult()
				.setStatus(200)
				.setMessage("OK")
				.setSuccess(true);
	}

}
