package web_cardapio.br.com.bitbyte.services.controlecomandas;

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
import web_cardapio.br.com.bitbyte.dao.ComandaDao;
import web_cardapio.br.com.bitbyte.dao.PedidosDao;
import web_cardapio.br.com.bitbyte.exceptions.BBIException;
import web_cardapio.br.com.bitbyte.exceptions.ComandaException;
import web_cardapio.br.com.bitbyte.models.Comanda;
import web_cardapio.br.com.bitbyte.models.ComandaInvalida;
import web_cardapio.br.com.bitbyte.models.Pedido;
import web_cardapio.br.com.bitbyte.models.ValoresComanda;
import web_cardapio.br.com.bitbyte.models.bbifood.PedidoBBIFood;
import web_cardapio.br.com.bitbyte.results.PedidosResult;
import web_cardapio.br.com.bitbyte.services.interfaces.SalvarPedidosService;

@Service
public class SalvarPedidosServiceControleComandas implements SalvarPedidosService 
{
	@Autowired
	private ValidaCaixaAberto validaCaixaAberto;
	
	@Autowired
	private ValidaComandaBloqueada validaComandaBloqueada;
	
	@Autowired
	private ValidaComandaFechada validaComandaFechada;
	
	@Autowired
	private ValidaComandaNaoAberta validaComandaNaoAberta;
	
	@Autowired
	private ValidaIntervaloComanda validaIntervaloComanda;
	
	@Autowired
	private ValidaLimitePedido validaLimitePedido;
	
	@Autowired
	private PedidosDao pedidosDao;
	
	@Autowired
	private ComandaDao comandaDao;
	
	@Override
	public PedidosResult insertPedido(Pedido pedido) throws SQLException, BBIException 
	{
		Comanda comanda = pedido.getComanda();
		PedidosResult pedidosResult = new PedidosResult();
		try {
			validaCaixaAberto.execute();
			validaComandaBloqueada.execute(comanda);
			validaComandaFechada.execute(comanda, true);
			validaComandaNaoAberta.execute(comanda);
			validaIntervaloComanda.execute(comanda);
			validaLimitePedido.execute(pedido);
			pedidosDao.insertPedido(new PedidoBBIFood(pedido), true);
			
			Comanda comandaAtual = comandaDao.selectComandaByNumero(comanda.getNumero());
			ValoresComanda valores = comandaAtual.getValoresComanda();
			comanda.setValoresComanda(valores);
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

		for(Pedido pedido: pedidos) {
			insertPedido(pedido);
		}
		return new PedidosResult()
				.setStatus(200)
				.setMessage("OK")
				.setSuccess(true);
	}

}
