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

import web_cardapio.br.com.bitbyte.dao.SubGrupoDao;
import web_cardapio.br.com.bitbyte.factories.GsonFactory;
import web_cardapio.br.com.bitbyte.models.Retorno;
import web_cardapio.br.com.bitbyte.models.SubGrupo;

@RestController
@RequestMapping("subgrupos")
public class SubGruposController {
	
	private static final Logger log = Logger.getLogger(SubGruposController.class);
	private Gson gson = GsonFactory.getGson();
	
	@Autowired
	private SubGrupoDao subgrupoDao;
	
	@GetMapping
	@Produces(MediaType.APPLICATION_JSON)
	public String getSubGrupos()
	{
		Retorno<List<SubGrupo>> retMsg = new Retorno<>();
		try {
			List<SubGrupo> subgrupos = subgrupoDao.getSubGrupos();
			System.out.println("Subgrupos: " +subgrupos);
			retMsg.setValue(subgrupos);
			retMsg.setStatus(200);
		}catch(Exception e) {
			String message = "Não foi possível obter os subgrupos. " + e.getMessage();
			log.error(message);
			retMsg.setStatus(500);
			retMsg.setMsg(e.getMessage());
		}
		return gson.toJson(retMsg);
		
	}

}
