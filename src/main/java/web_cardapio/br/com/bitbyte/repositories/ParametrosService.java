package web_cardapio.br.com.bitbyte.repositories;

import java.math.BigDecimal;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web_cardapio.br.com.bitbyte.dao.ParametroDao;
import web_cardapio.br.com.bitbyte.models.Parametro;
import web_cardapio.br.com.bitbyte.utils.ImprovedStringBuilder;

@Service
public class ParametrosService {
	
	@Autowired
	private ParametroDao parametroDao;
	
	public String getString(String paramName) {
		try {
			Parametro parametro = parametroDao.getMapParametros().get(paramName);
			return parametro == null ? "" : parametro.getValor();
		}catch(Exception e) {
			String message = new ImprovedStringBuilder()
					.append("Erro ao buscar parâmetro ")
					.append(paramName)
					.append(e.getMessage())
					.build();
			
			throw new RuntimeException(message);
		}
	}
	
	public BigDecimal getBigDecimal(String paramName) {
		try {
			Parametro parametro = parametroDao.getMapParametros().get(paramName);
			return parametro == null ? 
					new BigDecimal("0") : 
					new BigDecimal(parametro.getValor());
		}catch(Exception e) {
			String message = new ImprovedStringBuilder()
					.append("Erro ao buscar parâmetro ")
					.append(paramName)
					.append(e.getMessage())
					.build();
			
			throw new RuntimeException(message);
		}
	}
	
	public boolean getBoolean(String paramName) {
		try {
			Parametro parametro = parametroDao.getMapParametros().get(paramName);
			if(parametro == null) {
				return false;
			}
			return "S".equals(parametro.getValor());
		}catch(Exception e) {
			String message = new ImprovedStringBuilder()
					.append("Erro ao buscar parâmetro ")
					.append(paramName)
					.append(". ")
					.append(e.getMessage())
					.build();
			
			throw new RuntimeException(message);
		}
	}
	
	public int getInt(String paramName) {
		try {
			Parametro parametro = parametroDao.getMapParametros().get(paramName);
			if(parametro == null) {
				return -1;
			}
			return Integer.parseInt(parametro.getValor());
		}catch(Exception e) 
		{
			String message = new ImprovedStringBuilder()
					.append("Erro ao buscar parâmetro ")
					.append(paramName)
					.append(". ")
					.append(e.getMessage())
					.build();
			
			throw new RuntimeException(message);
		}
	}
}
