package web_cardapio.br.com.bitbyte.controllers;

import java.util.List;
import java.util.Optional;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import web_cardapio.br.com.bitbyte.dao.ProdutoDao;
import web_cardapio.br.com.bitbyte.factories.GsonFactory;
import web_cardapio.br.com.bitbyte.models.ProdInfo;
import web_cardapio.br.com.bitbyte.models.Produto;
import web_cardapio.br.com.bitbyte.models.Retorno;

@RestController
@RequestMapping("produtos")
public class ProdutosController {
	
	private static final Logger log = Logger.getLogger(ProdutosController.class);
	
	@Autowired
	private ProdutoDao produtoDao;
	
	@GetMapping
	@Produces(MediaType.APPLICATION_JSON)
	public String getProdutos()
	{
		Gson gson = GsonFactory.getGson();
		Retorno<List<Produto>> retMsg = new Retorno<>();
		try {
			retMsg.setValue(produtoDao.getProdutos());
			retMsg.setStatus(200);
			
		}catch(Exception e) {
			String message = "Não foi possível obter os produtos. " +e.getMessage();
			log.error(message + e);
			retMsg.setStatus(500);
			retMsg.setMsg(e.getMessage());
		}
		return gson.toJson(retMsg);
		
	}
}