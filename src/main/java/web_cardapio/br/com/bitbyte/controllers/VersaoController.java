package web_cardapio.br.com.bitbyte.controllers;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import web_cardapio.br.com.bitbyte.factories.GsonFactory;
import web_cardapio.br.com.bitbyte.models.AppInstaller;
import web_cardapio.br.com.bitbyte.models.AppVersion;
import web_cardapio.br.com.bitbyte.models.Retorno;
import web_cardapio.br.com.bitbyte.repositories.VersaoRepository;

@RestController
@RequestMapping("versao")
public class VersaoController {
	
	private static final Logger log = Logger.getLogger(VersaoController.class);
	
	@Autowired
	private VersaoRepository versaoRepository;
	
	@GetMapping("numero/{aplicacao}/{versaoAparelho}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getAppVersion(@PathVariable("aplicacao") String aplicacao, @PathVariable("versaoAparelho") String versaoAparelho)
	{
		Retorno<AppVersion> retMsg = new Retorno<>();
		Gson gson = GsonFactory.getGson();
		
		try
		{
			AppVersion appVersion = versaoRepository.getVersao(aplicacao, versaoAparelho);
			retMsg.setValue(appVersion);
			if(appVersion == null) {
				retMsg.setMsg("Número da versão não encontrada.");
				retMsg.setStatus(404);
			}else {
				retMsg.setStatus(200);
				retMsg.setMsg("Número da versão recuperada com sucesso.");
			}
		}catch(Exception e) {
			retMsg.setMsg(e.getMessage());
			retMsg.setStatus(500);
			log.info(e.getMessage());
		}
		return gson.toJson(retMsg);
	}
	
	@GetMapping("instalador/{aplicacao}")
	@Produces(MediaType.APPLICATION_JSON)
	public Retorno<AppInstaller> getInstaller(@PathVariable("aplicacao") String aplicacao)
	{
		System.out.println("BAIXANDO...");
		Retorno<AppInstaller> retMsg = new Retorno<>();
		
		try
		{
			AppInstaller appVersion = versaoRepository.getInstaller(aplicacao);
			retMsg.setValue(appVersion);
			if(appVersion == null) {
				retMsg.setMsg("Instalador da versão não encontrada.");
				retMsg.setStatus(404);
			}else {
				retMsg.setStatus(200);
				retMsg.setMsg("Instalador da versão recuperada com sucesso.");
			}
		}catch(Exception e) {
			retMsg.setMsg(e.getMessage());
			retMsg.setStatus(500);
			log.info(e.getMessage());
		}
		return retMsg;
	}
}
