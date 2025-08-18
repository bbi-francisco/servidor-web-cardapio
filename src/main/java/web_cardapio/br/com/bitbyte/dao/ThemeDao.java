package web_cardapio.br.com.bitbyte.dao;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;

import web_cardapio.br.com.bitbyte.controllers.ThemeController;
import web_cardapio.br.com.bitbyte.models.theme.AppTheme;
import web_cardapio.br.com.bitbyte.utils.MyResourceUtils;

@Component
public class ThemeDao {
	
	private static final Logger log = Logger.getLogger(ThemeDao.class);
	
	public AppTheme selectAppTheme() throws SQLException, IOException {
		
		ClassLoader classLoader = getClass().getClassLoader();
		
		StringBuilder sb;
		try(InputStream in = classLoader.getResourceAsStream("estilos_cardapio.json")) {
			
			sb = new StringBuilder();
			for (int ch; (ch = in.read()) != -1; ) {
			    sb.append((char) ch);
			}
		}
		log.info("Chegou aqui 6 ");
		return new Gson().fromJson(sb.toString(), AppTheme.class);
	}

}
