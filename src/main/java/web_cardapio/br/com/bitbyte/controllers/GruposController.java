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

import web_cardapio.br.com.bitbyte.dao.GrupoDao;
import web_cardapio.br.com.bitbyte.factories.GsonFactory;
import web_cardapio.br.com.bitbyte.models.Grupo;
import web_cardapio.br.com.bitbyte.models.Retorno;

@RestController
@RequestMapping("grupos")
public class GruposController {
	
	private static final Logger log = Logger.getLogger(GrupoDao.class);
	
	@Autowired
	private GrupoDao grupoDao;
	
	@GetMapping
	@Produces(MediaType.APPLICATION_JSON)
	public String getGrupos() {
		
		Gson gson = GsonFactory.getGson();
		Retorno<List<Grupo>> retMsg = new Retorno<>();
		
		try {
			List<Grupo> grupos = grupoDao.getGrupos();
			retMsg.setValue(grupos);
			retMsg.setStatus(200);
		}catch (Exception e) 
		{
			String mensagem = "Erro ao consultar grupos. " + e;
			log.error(mensagem);
			retMsg.setStatus(500);
			retMsg.setMsg(mensagem);
		}
		
		return gson.toJson(retMsg);
	}
}
