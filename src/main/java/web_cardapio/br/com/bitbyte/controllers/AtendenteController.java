package web_cardapio.br.com.bitbyte.controllers;

import javax.ws.rs.GET;

import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import web_cardapio.br.com.bitbyte.dao.AtendenteDao;
import web_cardapio.br.com.bitbyte.factories.GsonFactory;
import web_cardapio.br.com.bitbyte.models.Atendente;
import web_cardapio.br.com.bitbyte.models.Retorno;

@RestController
@RequestMapping("atendentes")
public class AtendenteController {
	
	private static final Logger log = Logger.getLogger(AtendenteController.class);
	
	@Autowired
	private AtendenteDao atendenteDao;
	
	@GetMapping("{codigo}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getAtendente(@PathVariable("codigo") String codigo)
	{
		Retorno<Atendente> retMsg = new Retorno<>();
		Gson gson = GsonFactory.getGson();
		
		try 
		{
			Atendente atendente = atendenteDao.getAtendente(codigo);
			retMsg.setValue(atendente);
			if(atendente == null) {
				retMsg.setMsg("Atendente não encontrado");
				retMsg.setStatus(404);
			}else {
				retMsg.setStatus(200);
				retMsg.setMsg("Atendente recuperado com sucesso");
			}
		}catch(Exception e) {
			String message = "Erro ao buscar atendente: ";
			retMsg.setMsg(message.toUpperCase()+ e);
			retMsg.setStatus(500);
			log.error(message.toUpperCase() + e);
		}
		return gson.toJson(retMsg);
	}
	
	@GetMapping("autenticar")
	@Produces(MediaType.APPLICATION_JSON)
	public String getAtendente(@PathVariable("usuario") String usuario, @PathVariable("senha") String senha) 
	{
		Retorno<Atendente> retMsg = new Retorno<>();
		Gson gson = GsonFactory.getGson();
		
		try 
		{
			Atendente atendente = atendenteDao.getAtendenteByUsuarioAndSenha(usuario, senha);
			retMsg.setValue(atendente);
			if(atendente == null) {
				retMsg.setMsg("Atendente não encontrado");
				retMsg.setStatus(404);
			}else {
				retMsg.setStatus(200);
				retMsg.setMsg("Atendente recuperado com sucesso");
			}
		}catch(Exception e) {
			String message = "Erro ao buscar atendente: ";
			retMsg.setMsg(message.toUpperCase()+ e);
			retMsg.setStatus(500);
			log.error(message.toUpperCase() + e);
		}
		return gson.toJson(retMsg);
	}

}