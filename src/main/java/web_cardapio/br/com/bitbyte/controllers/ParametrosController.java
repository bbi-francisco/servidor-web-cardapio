package web_cardapio.br.com.bitbyte.controllers;

import java.sql.SQLException;
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

import web_cardapio.br.com.bitbyte.dao.ParametroDao;
import web_cardapio.br.com.bitbyte.factories.GsonFactory;
import web_cardapio.br.com.bitbyte.models.Parametro;
import web_cardapio.br.com.bitbyte.models.Retorno;

@RestController
@RequestMapping("parametros")
public class ParametrosController 
{
	private static final Logger log = Logger.getLogger(ParametrosController.class);
	
	@Autowired
	private ParametroDao parametroDao;
	
	@GetMapping
	@Produces(MediaType.APPLICATION_JSON)
	public String getParametros() throws IllegalAccessException 
	{
		Gson gson = GsonFactory.getGson();
		Retorno<List<Parametro>> retornoParametros = new Retorno<>();
		try
		{
			retornoParametros.setValue(parametroDao.getParametros());
			retornoParametros.setStatus(200);
			retornoParametros.setMsg("Parâmetros obtidos com sucesso");
		}
		catch (SQLException e)
		{
			String message = "Não foi possível obter os parâmetros. ";
			log.info(message + e.getMessage());
			retornoParametros.setMsg(e.getMessage());
			retornoParametros.setStatus(500);
		}
		return gson.toJson(retornoParametros);
	}

}
