package web_cardapio.br.com.bitbyte.controllers;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import web_cardapio.br.com.bitbyte.command.ValidaCaixaAberto;
import web_cardapio.br.com.bitbyte.dao.CaixaDao;
import web_cardapio.br.com.bitbyte.exceptions.CaixaFechadoException;
import web_cardapio.br.com.bitbyte.factories.GsonFactory;
import web_cardapio.br.com.bitbyte.models.Caixa;
import web_cardapio.br.com.bitbyte.models.Retorno;

@RestController
@RequestMapping("caixas")
public class CaixaController {
	
	private static final Logger log = Logger.getLogger(CaixaController.class);
	
	@Autowired
	private CaixaDao caixaDao;
	
	@Autowired
	private ValidaCaixaAberto validaCaixaAberto;
	
	@GetMapping
	@Produces(MediaType.APPLICATION_JSON)
	public String getCaixas() 
	{
		Retorno<List<Caixa>> retornoCaixa = new Retorno<>();
		Gson gson = GsonFactory.getGson();
		try
		{
			retornoCaixa.setValue(caixaDao.getCaixas());
			retornoCaixa.setStatus(200);
		}
		catch (Exception e)
		{
			String message = "Erro ao consultar caixas: " +e.getMessage();
			retornoCaixa.setStatus(500);
			retornoCaixa.setMsg(message);
			log.error(message);
		}
		return gson.toJson(retornoCaixa);
	}
	
	@GetMapping("has_caixa_aberto")
	@Produces(MediaType.APPLICATION_JSON)
	public String hasCaixaAberto() 
	{
		Retorno<List<Caixa>> retornoCaixa = new Retorno<>();
		Gson gson = GsonFactory.getGson();
		try
		{
			validaCaixaAberto.execute();
			retornoCaixa.setStatus(200);
			retornoCaixa.setMsg("Há caixas abertos");
		}
		catch(CaixaFechadoException e) {
			retornoCaixa.setStatus(e.getStatus());
			retornoCaixa.setMsg(e.getMessage());
		}
		catch (Exception e)
		{
			String message = "Não foi possível verificar se h� caixas abertos. ";
			retornoCaixa.setStatus(500);
			retornoCaixa.setMsg(e.getMessage());
			log.error(message + e.getMessage());
		}
		return gson.toJson(retornoCaixa);
	}
	

}
