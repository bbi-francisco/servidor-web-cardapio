package web_cardapio.br.com.bitbyte.controllers;

import java.sql.SQLException;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import web_cardapio.br.com.bitbyte.models.Retorno;
import web_cardapio.br.com.bitbyte.scripts.ScriptsService;

@RestController
public class MainController {
	
	@Autowired
	private ScriptsService scripts;
	
	@GetMapping("ok")
	public Retorno<String> getOk(){
		Retorno<String> retorno = new Retorno<String>()
				.setMsg("ok")
				.setValue("ok")
				.setStatus(200);
		
		return retorno;
	}
	
	@PostConstruct
	public void scripts() throws SQLException {
		scripts.execute();
	}
	
}
