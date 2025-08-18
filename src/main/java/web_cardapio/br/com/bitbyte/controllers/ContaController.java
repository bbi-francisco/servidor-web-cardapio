package web_cardapio.br.com.bitbyte.controllers;

import java.sql.SQLException;

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
import web_cardapio.br.com.bitbyte.enums.ServiceType;
import web_cardapio.br.com.bitbyte.exceptions.BBIException;
import web_cardapio.br.com.bitbyte.factories.GsonFactory;
import web_cardapio.br.com.bitbyte.factories.servicefactories.ConsultarContaServiceFactory;
import web_cardapio.br.com.bitbyte.models.Comanda;
import web_cardapio.br.com.bitbyte.models.Conta;
import web_cardapio.br.com.bitbyte.models.Retorno;
import web_cardapio.br.com.bitbyte.results.FecharContaResult;
import web_cardapio.br.com.bitbyte.services.integracao.FecharContaServiceIntegracao;
import web_cardapio.br.com.bitbyte.services.interfaces.ConsultarContaService;
import web_cardapio.br.com.bitbyte.services.interfaces.FecharContaService;
import web_cardapio.br.com.bitbyte.services.play.FecharContaServicePlay;
import web_cardapio.br.com.bitbyte.services.tablet.FecharContaServiceTablet;
import web_cardapio.br.com.bitbyte.utils.StringUtils;

@RestController
@RequestMapping("conta")
public class ContaController {
	
	private static final Logger log = Logger.getLogger(ContaController.class);
	private Gson gson = GsonFactory.getGson();
	
	@Autowired
	private ComandaDao comandaDao;
	
	@Autowired
	private ConsultarContaServiceFactory consultarContaServiceFactory;
	
	@Autowired
	private FecharContaServicePlay fecharContaServicePlay;
	
	@Autowired
	private FecharContaServiceTablet fecharContaServiceTablet;
	
	@Autowired
	private FecharContaServiceIntegracao fecharContaServiceIntegracao;
	
	
	
	@PostMapping("consultar")
	@Produces(MediaType.APPLICATION_JSON)
	public String getConta(@HeaderParam(value = "service") ServiceType serviceType, @RequestBody Comanda comanda) throws SQLException, IllegalAccessException
	{
		Retorno<Conta> retMsg = new Retorno<>();
		try
		{
			String idTag = comanda.getIdTag();
			if(!StringUtils.isNullOrEmpty(idTag)) {
				
				Comanda comandaTag = comandaDao.selectComandaByTag(idTag);
				
				if(comandaTag == null) {
					throw new RuntimeException("Tag não vinculada a uma comanda.");
				}
				comanda
				.setIdTag(idTag)
				.setNumero(comandaTag.getNumero());
				
			}
			ConsultarContaService contaService = consultarContaServiceFactory
					.getService(serviceType);
			
			retMsg.setValue(contaService.getConta(comanda));
			retMsg.setStatus(200);
			retMsg.setMsg("Consulta aos pedidos bem-sucedida. ");
		}
		catch(BBIException e) {
			retMsg.setMsg(e.getMessage());
			retMsg.setStatus(e.getStatus());
		}
		catch (Exception e)
		{
			String message = "Não foi possível consultar a conta. " +e.getMessage();
			retMsg.setMsg(message);
			retMsg.setStatus(500);
			log.error(message);
		}
		return gson.toJson(retMsg);
	}
	

	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@PostMapping("fechar/play")
	public String fecharContaPlay(@RequestBody Comanda comanda)
	{
		Retorno<Comanda> retorno = new Retorno<>();
		try {

			fecharContaServicePlay.fecharConta(comanda);
			String mensagem = "Conta da comanda " +comanda.getNumero() + " fechada com sucesso!";
			retorno.setStatus(200);
			retorno.setMsg(mensagem);
		}catch(BBIException e) {
			retorno.setMsg(e.getMessage());
			retorno.setStatus(e.getStatus());
		}
		catch (Exception e) {
			String mensagem = "Erro ao fechar a conta da comanda: " +comanda.getNumero() + ". "+e.getMessage();
			retorno.setStatus(500);
			retorno.setMsg(mensagem);
			log.error(mensagem);
		}
		retorno.setValue(comanda);
		return gson.toJson(retorno);
	}
	
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@PostMapping("fechar/tablet")
	public String fecharContaTablet(@RequestBody Comanda comanda)
	{
		Retorno<FecharContaResult> retorno = new Retorno<>();
		try {
			
			String idTag = comanda.getIdTag();
			if(!StringUtils.isNullOrEmpty(idTag)) {
				
				Comanda comandaTag = comandaDao.selectComandaByTag(idTag);
				
				if(comandaTag == null) {
					throw new RuntimeException("Tag não vinculada a uma comanda.");
				}
				
				comanda
				.setIdTag(idTag)
				.setNumero(comandaTag.getNumero());
				
			}
			FecharContaResult result = fecharContaServiceTablet.fecharConta(comanda);
			
			String mensagem = "Conta fechada com sucesso!";
			retorno.setStatus(200);
			retorno.setMsg(mensagem);
			retorno.setValue(result);
		}catch(BBIException e) {
			retorno.setMsg(e.getMessage());
			retorno.setStatus(e.getStatus());
		}
		catch (Exception e) {
			String mensagem = "Erro ao fechar a conta. "+e.getMessage();
			retorno.setStatus(500);
			retorno.setMsg(mensagem);
			log.error(mensagem);
		}
		
		return gson.toJson(retorno);
	}
	
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@PostMapping("fechar/integracao")
	public String fecharContaIntegracao(@RequestBody Comanda comanda)
	{
		Retorno<FecharContaResult> retorno = new Retorno<>();
		try {
			FecharContaResult result = fecharContaServiceIntegracao.fecharConta(comanda);
			
			String mensagem = "Conta da comanda " +comanda.getNumero() + " fechada com sucesso!";
			retorno.setStatus(200);
			retorno.setMsg(mensagem);
			retorno.setValue(result);
		}catch(BBIException e) {
			retorno.setMsg(e.getMessage());
			retorno.setStatus(e.getStatus());
		}
		catch (Exception e) {
			String mensagem = "Erro ao fechar a conta da comanda: " +comanda.getNumero() + ". "+e.getMessage();
			retorno.setStatus(500);
			retorno.setMsg(mensagem);
			log.error(mensagem);
		}
		
		return gson.toJson(retorno);
	}
	
	

}
