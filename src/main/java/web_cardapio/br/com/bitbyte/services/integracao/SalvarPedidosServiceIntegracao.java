package web_cardapio.br.com.bitbyte.services.integracao;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web_cardapio.br.com.bitbyte.command.ValidaComandaNaoAberta;
import web_cardapio.br.com.bitbyte.dao.ComandaDao;
import web_cardapio.br.com.bitbyte.dao.ImpressaoDao;
import web_cardapio.br.com.bitbyte.dao.PedidosDao;
import web_cardapio.br.com.bitbyte.exceptions.BBIException;
import web_cardapio.br.com.bitbyte.log.LogBuilder;
import web_cardapio.br.com.bitbyte.models.Comanda;
import web_cardapio.br.com.bitbyte.models.Pedido;
import web_cardapio.br.com.bitbyte.models.bbifood.ComandaBBIFood;
import web_cardapio.br.com.bitbyte.models.bbifood.PedidoBBIFood;
import web_cardapio.br.com.bitbyte.repositories.BbiParamService;
import web_cardapio.br.com.bitbyte.results.PedidosResult;
import web_cardapio.br.com.bitbyte.services.interfaces.SalvarPedidosService;

@Service
public class SalvarPedidosServiceIntegracao implements SalvarPedidosService{
	
	private static final Logger log = Logger.getLogger(SalvarPedidosServiceIntegracao.class);
	
	@Autowired
	private BbiParamService bbiParamService;
	
	@Autowired
	private ComandaDao comandaDao;
	
	@Autowired
	private PedidosDao pedidosDao;
	
	@Autowired
	private ValidaComandaNaoAberta validaComandaNaoAberta;
	
	@Autowired
	private ImpressaoDao impressaoDao;
	
	public PedidosResult insertPedido(Pedido pedido) throws BBIException, SQLException
	{
		
		try {
			Comanda comandaPedido = pedido.getComanda();
			
			if(bbiParamService.aberturaComanda()) 
			{
				validaComandaNaoAberta.execute(comandaPedido);
			}else {
				comandaDao.insertOrUpdateComandas(Arrays.asList(new ComandaBBIFood(comandaPedido)));
			}
			
			pedidosDao.insertPedido(new PedidoBBIFood(pedido), true);
			
			return new PedidosResult()
					.setStatus(200)
					.setMessage("Pedido inserido com sucesso!")
					.setComanda(pedido.getComanda());
			
		}catch(Exception e) 
		{
			String message = new LogBuilder()
					.setMessage("Não foi possível salvar o pedido. ")
					.setThrowable(e).build();
			log.error(message);
			
			return new PedidosResult()
					.setStatus(500)
					.setMessage(message)
					.setComanda(pedido.getComanda());
		}
	}

	@Override
	public PedidosResult insertPedidosItem(List<Pedido> pedidos) throws SQLException, BBIException 
	{
		try 
		{
			Set<Integer> comandas = new HashSet<>();
			for(Pedido pedido : pedidos)
			{
				Comanda comandaPedido = pedido.getComanda();
				int numeroComanda = pedido.getComanda().getNumero();
				comandas.add(numeroComanda);
				
				if(bbiParamService.aberturaComanda()) 
				{
					validaComandaNaoAberta.execute(comandaPedido);
				}else {
					comandaDao.insertOrUpdateComandas(Arrays.asList(new ComandaBBIFood(comandaPedido)));
				}
				
				pedidosDao.insertPedido(new PedidoBBIFood(pedido), false);
			}
			
			for(Integer numComanda : comandas)
			{
				impressaoDao.atualizarStatusImpressao(numComanda);
			}
			
			return new PedidosResult()
					.setStatus(200)
					.setMessage("Pedidos inseridos com sucesso!");
		}catch(Exception e) 
		{
			String message = new LogBuilder()
					.setMessage("Não foi possível salvar os pedidos. ")
					.setThrowable(e).build();
			
			log.error(message);
			
			return new PedidosResult()
					.setStatus(500)
					.setMessage(message);
		}
	}

}
