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

import web_cardapio.br.com.bitbyte.dao.ComboDao;
import web_cardapio.br.com.bitbyte.factories.GsonFactory;
import web_cardapio.br.com.bitbyte.models.ItemCombo;
import web_cardapio.br.com.bitbyte.models.Retorno;

@RestController
@RequestMapping("combos")
public class CombosController {
	
	
	private static final Logger log = Logger.getLogger(CombosController.class);
	
	@Autowired
	private ComboDao comboDao;
	
	@GetMapping
	@Produces(MediaType.APPLICATION_JSON)
	public String getItensCombo()
	{
		Gson gson = GsonFactory.getGson();
		Retorno<List<ItemCombo>> retMsg = new Retorno<>();
		try {
			retMsg.setValue(comboDao.getItensCombo());
			retMsg.setStatus(200);
		}catch(Exception e) {
			String message = "Não foi possível obter os itens combo. ";
			log.error(message + e);
			retMsg.setStatus(500);
			retMsg.setMsg(e.getMessage());
		}
		return gson.toJson(retMsg);
		
	}

}
