package web_cardapio.br.com.bitbyte.controllers;

import java.util.List;

import javax.ws.rs.Consumes;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import web_cardapio.br.com.bitbyte.dao.ComandaDao;
import web_cardapio.br.com.bitbyte.dao.ComandaRandomDao;
import web_cardapio.br.com.bitbyte.enums.ServiceType;
import web_cardapio.br.com.bitbyte.exceptions.BBIException;
import web_cardapio.br.com.bitbyte.factories.GsonFactory;
import web_cardapio.br.com.bitbyte.factories.servicefactories.PedidosServiceFactory;
import web_cardapio.br.com.bitbyte.log.LogBuilder;
import web_cardapio.br.com.bitbyte.models.ChamarGarcom;
import web_cardapio.br.com.bitbyte.models.Comanda;
import web_cardapio.br.com.bitbyte.models.Pedido;
import web_cardapio.br.com.bitbyte.models.Retorno;
import web_cardapio.br.com.bitbyte.models.bbifood.ComandaBBIFood;
import web_cardapio.br.com.bitbyte.results.PedidosResult;
import web_cardapio.br.com.bitbyte.services.controlecomandas.SalvarPedidosServiceControleComandas;
import web_cardapio.br.com.bitbyte.services.interfaces.SalvarPedidosService;
import web_cardapio.br.com.bitbyte.services.play.SalvarPedidosServicePlay;
import web_cardapio.br.com.bitbyte.services.tablet.ChamarGarcomService;
import web_cardapio.br.com.bitbyte.services.tablet.SalvarPedidosServiceTablet;
import web_cardapio.br.com.bitbyte.services.tablet.SalvarPedidosServiceTag;

@RestController
@RequestMapping("pedidos")
public class PedidosController {

	private static final Logger log = Logger.getLogger(PedidosController.class);
	private Gson gson = GsonFactory.getGson();
	
	@Autowired
	private SalvarPedidosServicePlay salvarPedidoServicePlay;
	
	@Autowired
	private ChamarGarcomService chamarGarcomService;
	
	@Autowired
	private SalvarPedidosServiceTablet salvarPedidosServiceTablet;
	
	@Autowired
	private ComandaDao comandaDao;
	
	@Autowired
	private SalvarPedidosServiceTag salvarPedidosServiceTag;
	
	@Autowired
	private SalvarPedidosServiceControleComandas salvarPedidosServiceControleComandas;
	
	@Autowired
	private PedidosServiceFactory pedidosServiceFactory;

	@PostMapping("set/play")
	@Produces(MediaType.APPLICATION_JSON)
	public String setPedidoPlay(@RequestBody Pedido pedido) {
		Retorno<Comanda> retornoPedido = new Retorno<>();
		try {
			salvarPedidoServicePlay.insertPedido(pedido);
			retornoPedido.setMsg("Pedido enviado com sucesso");
			retornoPedido.setStatus(200);
		} catch (BBIException e) {
			log.info(e.getMessage());
			retornoPedido.setStatus(e.getStatus());
			retornoPedido.setMsg(e.getMessage());
		} catch (Exception e) {
			String message = "Não foi possível enviar o pedido. ";
			log.error(message + e.getMessage());
			retornoPedido.setStatus(500);
			retornoPedido.setMsg(e.getMessage());
		}
		retornoPedido.setValue(pedido.getComanda());
		return gson.toJson(retornoPedido);
	}
	
	@PostMapping("chamar_garcom")
	@Produces(MediaType.APPLICATION_JSON)
	public String chamarGarcom(@RequestBody ChamarGarcom chamarGarcom) {
		Retorno<PedidosResult> retornoPedido = new Retorno<>();
		try {
			PedidosResult pedidosResult = chamarGarcomService.chamarGarcom(chamarGarcom);

			retornoPedido.setMsg("O garçom foi chamado!").setStatus(200).setValue(pedidosResult);
		} catch (BBIException e) {

			retornoPedido.setStatus(e.getStatus());
			retornoPedido.setMsg(e.getMessage());
		} catch (Exception e) {
			String message = "Não foi possível chamar o garçom. " + e.getMessage();
			log.error(message);
			retornoPedido.setStatus(500);
			retornoPedido.setMsg(e.getMessage());
		}
		return gson.toJson(retornoPedido);
	}

	@PostMapping("set/tablet")
	@Produces(MediaType.APPLICATION_JSON)
	public String setPedidoTablet(@RequestBody Pedido pedido) {
		Retorno<PedidosResult> retornoPedido = new Retorno<>();
		try {
			PedidosResult pedidosResult = salvarPedidosServiceTablet.insertPedido(pedido);

			retornoPedido.setMsg("Pedido enviado com sucesso").setStatus(200).setValue(pedidosResult);
		} catch (BBIException e) {

			retornoPedido.setStatus(e.getStatus());
			retornoPedido.setMsg(e.getMessage());
		} catch (Exception e) {
			String message = "Não foi possível enviar o pedido. " + e.getMessage();
			log.error(message);
			retornoPedido.setStatus(500);
			retornoPedido.setMsg(e.getMessage());
		}
		return gson.toJson(retornoPedido);
	}

	@PostMapping("set/tag")
	@Produces(MediaType.APPLICATION_JSON)
	public String setPedidoTag(@RequestBody Pedido pedido) {
		Retorno<PedidosResult> retornoPedido = new Retorno<>();
		try {

			String idTag = pedido.getComanda().getIdTag();
			Comanda comanda = comandaDao.selectComandaByTag(idTag);

			if (comanda == null) {
				throw new RuntimeException("Tag não vinculada a uma comanda.");
			}
			pedido.getComanda().setIdTag(comanda.getIdTag()).setNumero(comanda.getNumero());

			PedidosResult pedidosResult = salvarPedidosServiceTag.insertPedido(pedido);

			retornoPedido.setMsg("Pedido enviado com sucesso").setStatus(200).setValue(pedidosResult);
		} catch (BBIException e) {

			retornoPedido.setStatus(e.getStatus());
			retornoPedido.setMsg(e.getMessage());
		} catch (Exception e) {
			String message = "Não foi possível enviar o pedido. " + e.getMessage();
			log.error(message);
			retornoPedido.setStatus(500);
			retornoPedido.setMsg(e.getMessage());
		}
		return gson.toJson(retornoPedido);
	}

	@PostMapping("set/controle_comandas")
	@Produces(MediaType.APPLICATION_JSON)
	public String setPedidoControleComandas(@RequestBody Pedido pedido) {
		PedidosResult pedidosResult = new PedidosResult();
		try {
			pedidosResult = salvarPedidosServiceControleComandas.insertPedido(pedido);

			pedidosResult.setMessage("Pedido enviado com sucesso").setStatus(200);
		} catch (BBIException e) {
			pedidosResult.setStatus(e.getStatus()).setMessage(e.getMessage());
		} catch (Exception e) {
			String message = "Não foi possível enviar o pedido. " + e.getMessage();
			log.error(message);
			pedidosResult.setStatus(500).setMessage(e.getMessage());
		}
		return gson.toJson(pedidosResult);
	}

	@PostMapping("random/set")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String setPedidoComandaRandom(@RequestBody Pedido pedidoFinal) {
		Retorno<Integer> infoResposta = new Retorno<>();
		try {
			ComandaRandomDao comandaRandomDAO = new ComandaRandomDao();
			comandaRandomDAO.validaComanda(new ComandaBBIFood(pedidoFinal.getComanda()));
			salvarPedidoServicePlay.insertPedido(pedidoFinal);

			infoResposta.setStatus(200);
			infoResposta.setMsg("Sucesso ao salvar o pedido.");
			infoResposta.setValue(pedidoFinal.getComanda().getNumero());
		} catch (Exception e) {
			String message = "Não foi possível enviar o pedido. " + e.getMessage();
			log.error(message);
			infoResposta.setStatus(500);
			infoResposta.setMsg(e.getMessage());
		}
		return gson.toJson(infoResposta);
	}

	@PostMapping("insert/{service}")
	@Produces(MediaType.APPLICATION_JSON)
	public String insertPedido(@RequestBody Pedido pedido, @PathVariable("service") String service) {
		PedidosResult retornoPedido = new PedidosResult();
		try {
			SalvarPedidosService pedidosService = pedidosServiceFactory
					.getService(ServiceType.getServiceType(service));
			retornoPedido = pedidosService.insertPedido(pedido);
		} catch (Exception e) {
			String message = new LogBuilder().setMessage("Não foi possível salvar o pedido. ").setThrowable(e).build();
			log.error(message);

			retornoPedido.setStatus(500);
			retornoPedido.setMessage(e.getMessage());
		}
		return gson.toJson(retornoPedido);
	}
	
	@PostMapping("insert_pedidos_item/{service}")
	@Produces(MediaType.APPLICATION_JSON)
	public String insertPedidosItem(@RequestBody List<Pedido> pedidos, @PathVariable("service") String service) 
	{
		PedidosResult retornoPedido = new PedidosResult();
		try 
		{
			SalvarPedidosService pedidosService = pedidosServiceFactory
					.getService(ServiceType.getServiceType(service));
			
			retornoPedido = pedidosService.insertPedidosItem(pedidos);
			
		} catch (Exception e) 
		{
			String message = new LogBuilder().setMessage("Não foi possível salvar o pedido. ").setThrowable(e).build();
			log.error(message);

			retornoPedido.setStatus(500);
			retornoPedido.setMessage(e.getMessage());
		}
		return gson.toJson(retornoPedido);
	}
}
