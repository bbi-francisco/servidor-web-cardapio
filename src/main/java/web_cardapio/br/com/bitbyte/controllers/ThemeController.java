package web_cardapio.br.com.bitbyte.controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import web_cardapio.br.com.bitbyte.dao.ThemeDao;
import web_cardapio.br.com.bitbyte.models.Retorno;
import web_cardapio.br.com.bitbyte.models.theme.AppTheme;

@RestController
@RequestMapping("themes")
public class ThemeController 
{
	private static final Logger log = Logger.getLogger(ThemeController.class);
	
	@Autowired
	private ThemeDao themeDao;
	
	@GetMapping
	@Produces(MediaType.APPLICATION_JSON)
	public Retorno<AppTheme> getTheme() 
	{
		try 
		{
		
			AppTheme appTheme = themeDao.selectAppTheme();
			
			return new Retorno<AppTheme>()
					.setStatus(200)
					.setMsg("OK")
					.setValue(appTheme);
		} catch (Exception e) 
		{
			String message = "Erro ao baixar estilos. " +e.toString();
			log.info(message);
			
			return new Retorno<AppTheme>()
					.setStatus(500)
					.setMsg(message)
					.setValue(null);
		}
	}
}
