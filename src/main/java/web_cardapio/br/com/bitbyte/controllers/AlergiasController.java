package web_cardapio.br.com.bitbyte.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import web_cardapio.br.com.bitbyte.dao.AlergiasDao;
import web_cardapio.br.com.bitbyte.models.Alergias;
import web_cardapio.br.com.bitbyte.models.Retorno;

@RestController
@RequestMapping("/alergias")
public class AlergiasController {
	
	@Autowired
	private AlergiasDao alergiasDao;
	
	@GetMapping
	public Retorno<?> getAlergias()
	{
		try 
		{
			List<Alergias> alergias = alergiasDao.selectAlergias();
			
			return new Retorno<>()
					.setMsg("ok")
					.setStatus(HttpStatus.OK.value())
					.setValue(alergias);
		}catch(Exception e) 
		{
			return new Retorno<>()
					.setMsg("Erro ao obter alergias. " +e.toString())
					.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
		}

	}

}
