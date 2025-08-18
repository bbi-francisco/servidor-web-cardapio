package web_cardapio.br.com.bitbyte.controllers;

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

import web_cardapio.br.com.bitbyte.dao.EstabelecimentoDao;
import web_cardapio.br.com.bitbyte.factories.GsonFactory;
import web_cardapio.br.com.bitbyte.models.Estabelecimento;
import web_cardapio.br.com.bitbyte.models.Retorno;

@RestController
@RequestMapping("estabelecimento")
public class EstabelecimentoController {
	
	private static final Logger log = Logger.getLogger(EstabelecimentoController.class);
	
	@Autowired
	private EstabelecimentoDao estabelecimentoDao;

	@GetMapping
	@Produces(MediaType.APPLICATION_JSON)
	public String getEstabelecimento()
	{
		Gson gson = GsonFactory.getGson();
		Retorno<Estabelecimento> retornoMsg = new Retorno<>();
		try {
			retornoMsg.setValue(estabelecimentoDao.getEstabelecimento());
			retornoMsg.setStatus(200);
		}catch(Exception e) {
			String message = "Não foi possível obter os dados do estabelecimento. " + e.getMessage();
			log.error(message);
			retornoMsg.setStatus(500);
			retornoMsg.setMsg(e.toString());
		}
		return gson.toJson(retornoMsg);
		
	}
	
}
