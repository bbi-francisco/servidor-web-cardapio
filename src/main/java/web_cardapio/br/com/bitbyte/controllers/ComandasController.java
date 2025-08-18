package web_cardapio.br.com.bitbyte.controllers;

import java.util.Collections;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import web_cardapio.br.com.bitbyte.dao.ComandaDao;
import web_cardapio.br.com.bitbyte.enums.FormaAtendimento;
import web_cardapio.br.com.bitbyte.enums.ServiceType;
import web_cardapio.br.com.bitbyte.exceptions.BBIException;
import web_cardapio.br.com.bitbyte.factories.GsonFactory;
import web_cardapio.br.com.bitbyte.factories.servicefactories.ValidarComandaFactory;
import web_cardapio.br.com.bitbyte.models.Comanda;
import web_cardapio.br.com.bitbyte.models.Entrada;
import web_cardapio.br.com.bitbyte.models.Retorno;
import web_cardapio.br.com.bitbyte.results.ComandaValidationResult;
import web_cardapio.br.com.bitbyte.results.EntradaResult;
import web_cardapio.br.com.bitbyte.services.interfaces.ValidarComandaService;
import web_cardapio.br.com.bitbyte.services.tablet.AbrirComandasEntrada;

@RestController
@RequestMapping("comandas")
public class ComandasController {
	
	private Gson gson = GsonFactory.getGson();
	private static final Logger log = Logger.getLogger(ComandasController.class);
	
	@Autowired
	private ComandaDao comandaDao;
	
	@Autowired
	private ValidarComandaFactory validarComandaFactory;
	
	@Autowired
	private AbrirComandasEntrada abrirComandasService;
	
	@PostMapping("delete")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String deleteComandasSemPedidos(@RequestBody List<Comanda> comandas)
	{	
		Retorno<List<Comanda>> retorno = new Retorno<>();
		try
		{
			comandaDao.deleteComandasSemPedidos(comandas);
			retorno.setStatus(200);
		}
		catch (Exception e)
		{
			String message = "Não foi possível deletar as comandas. ";
			retorno.setStatus(500);
			retorno.setMsg(e.getMessage());
			log.error(message + e.getMessage());
		}
		return gson.toJson(retorno);
	}
	
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@PostMapping("validar")
	public String validarComanda(@HeaderParam("service") String service, @RequestBody List<Comanda> comandas) 
	{
		ComandaValidationResult result = new ComandaValidationResult();
		try {
			ValidarComandaService validarComandaService  = validarComandaFactory
					.getService(ServiceType.valueOf(service.toUpperCase()));
			result = validarComandaService.validar(comandas);
			
			result
			.setMessage("Comandas validadas!")
			.setStatus(200);
		}
		catch(BBIException e) 
		{
			result
			.setMessage(e.getMessage())
			.setStatus(e.getStatus());
			log.info(e.toString());
		}
		catch (Exception e)
		{
			result
			.setStatus(500)
			.setMessage("Não foi possível validar as comandas. " + e.getMessage());
			log.info(e.toString());
		}
		return gson.toJson(result);
	}
	
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@PostMapping("abrir")
	public String abrirComanda(@HeaderParam("service") String service, @RequestBody Comanda comanda) 
	{
		Retorno<List<Comanda>> retorno = new Retorno<>();
		try {
			ValidarComandaService validarComandaService  = validarComandaFactory
					.getService(ServiceType.valueOf(service));
			validarComandaService.validar(Collections.singletonList(comanda));
			retorno.setStatus(200);
			
		}
		catch(BBIException e) 
		{
			retorno.setMsg(e.getMessage());
			retorno.setStatus(e.getStatus());
		}
		catch (Exception e)
		{
			retorno.setStatus(500);
			retorno.setMsg("Não foi possível validar as comandas. " + e.getMessage());
		}
		retorno.setValue(Collections.singletonList(comanda));
		return gson.toJson(retorno);
	}
	
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@PostMapping("abrir/entrada")
	public String abrirComandasEntrada(@RequestBody Entrada entrada) 
	{
		Retorno<EntradaResult> retorno = new Retorno<>();
		try {
			EntradaResult result = abrirComandasService.abrir(entrada);
			retorno.setStatus(200);
			retorno.setValue(result);
		}
		catch (Exception e)
		{
			retorno.setStatus(500);
			retorno.setMsg("Não foi possível abrir as comandas. " +e.getMessage());
			log.error(e.toString());
		}
		
		return gson.toJson(retorno);
	}
}
