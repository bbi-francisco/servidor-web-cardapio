package web_cardapio.br.com.bitbyte.controllers;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import web_cardapio.br.com.bitbyte.dao.PerguntaDao;
import web_cardapio.br.com.bitbyte.models.Questionario;
import web_cardapio.br.com.bitbyte.models.RespostasPesquisa;
import web_cardapio.br.com.bitbyte.models.Retorno;
import web_cardapio.br.com.bitbyte.services.PesquisaService;

@RestController
@RequestMapping("pesquisa_satisfacao")
public class PesquisaSatisfacaoController {
	
	private static final Logger log = Logger.getLogger(PesquisaSatisfacaoController.class);
	
	@Autowired
	private PerguntaDao perguntaDao;
	
	@Autowired
	private PesquisaService pesquisaService;
	
	@GetMapping
	@Produces(MediaType.APPLICATION_JSON)
	public Retorno<Questionario> getQuestionario() 
	{
		try {
			Questionario questionario = perguntaDao.selectQuestionario();
			return new Retorno<Questionario>()
						.setMsg("OK")
						.setStatus(200)
						.setValue(questionario);
		}catch(Exception e) {
			String message = "Erro ao buscar Pesquisa de Satisfação";
			log.info(message + " " + e.getMessage());
			return new Retorno<Questionario>()
					.setMsg(message)
					.setStatus(500);
		}
		
	}
	
	@PostMapping("respostas")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Retorno<Void> enviarRespostas(@RequestBody RespostasPesquisa respostas)
	{
		try {
			pesquisaService.insertResultados(respostas);
			
			return new Retorno<Void>()
					.setStatus(200)
					.setMsg("Respostas salvas com sucesso!");
		}catch(Exception e) {
			String message = "Erro ao salvar respostas da pesquisa. ";
			Retorno<Void> retorno = new Retorno<Void>()
					.setMsg(message)
					.setStatus(500);
			log.info(message + " " + e.toString());
			return retorno;
		}
	}
}
