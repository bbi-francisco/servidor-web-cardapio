package web_cardapio.br.com.bitbyte.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Files;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
	
	@GetMapping("arquivo/{aplicacao}")
	public ResponseEntity<Resource> getInstallerFile(@PathVariable("aplicacao") String aplicacao) {
	    System.out.println("BAIXANDO...");

	    try {
	        File file = versaoRepository.getInstallerFile(aplicacao);

	        if (file == null || !file.exists()) {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND)
	                    .body(null);
	        }

	        // Cria o recurso para o arquivo
	        Resource resource = new InputStreamResource(new FileInputStream(file));

	        // Define o tipo de conteúdo (pode ser ajustado conforme o tipo real do instalador)
	        String contentType = Files.probeContentType(file.toPath());
	        if (contentType == null) {
	            contentType = "application/octet-stream"; // tipo genérico
	        }

	        // Retorna o arquivo para download
	        return ResponseEntity.ok()
	                .contentType(MediaType.parseMediaType(contentType))
	                .header(HttpHeaders.CONTENT_DISPOSITION,
	                        "attachment; filename=\"" + file.getName() + "\"")
	                .body(resource);

	    } catch (Exception e) {
	        e.printStackTrace();
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	                .build();
	    }
	}
	

}
