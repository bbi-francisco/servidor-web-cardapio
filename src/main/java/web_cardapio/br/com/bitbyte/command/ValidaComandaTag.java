package web_cardapio.br.com.bitbyte.command;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import web_cardapio.br.com.bitbyte.dao.ComandaTagDao;
import web_cardapio.br.com.bitbyte.exceptions.ComandaException;
import web_cardapio.br.com.bitbyte.exceptions.ComandaTagInvalidaException;
import web_cardapio.br.com.bitbyte.models.Comanda;
import web_cardapio.br.com.bitbyte.models.ComandaTag;
import web_cardapio.br.com.bitbyte.utils.StringUtils;

@Component
public class ValidaComandaTag {
	
	@Autowired
	private ComandaTagDao comandaDAO;
	
	public boolean execute(Comanda comanda) throws SQLException, ComandaException {
		int numeroComanda = comanda.getNumero();
		String tag = comanda.getTag();
		if(StringUtils.isNullOrEmpty(tag)) 
		{
			ComandaTag comandaTag = comandaDAO.selectComandaTag(comanda);
			if(comandaTag == null) {
				throw new ComandaTagInvalidaException("A comanda " + numeroComanda + " não apresenta autenticação válida.");
			}else {
				comanda.setTag(comandaTag.getNumeroComanda());
			}
		}
		return true;
	}
}
