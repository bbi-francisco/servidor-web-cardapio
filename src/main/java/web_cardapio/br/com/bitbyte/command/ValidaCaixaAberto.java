package web_cardapio.br.com.bitbyte.command;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import web_cardapio.br.com.bitbyte.dao.CaixaDao;
import web_cardapio.br.com.bitbyte.exceptions.BBIException;
import web_cardapio.br.com.bitbyte.exceptions.CaixaFechadoException;
import web_cardapio.br.com.bitbyte.exceptions.ComandaException;

@Component
public class ValidaCaixaAberto {
	
	@Autowired
	private CaixaDao caixaDao;

	public Boolean execute() throws SQLException, BBIException {
		
		boolean caixaAberto = caixaDao.verificarCaixaAberto();
		if(!caixaAberto) {
			throw new CaixaFechadoException("Não existem caixas abertos. ");
		}
		return true;
	}

}
