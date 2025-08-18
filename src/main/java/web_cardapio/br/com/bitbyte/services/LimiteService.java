package web_cardapio.br.com.bitbyte.services;

import java.math.BigDecimal;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import web_cardapio.br.com.bitbyte.dao.ComandaDao;
import web_cardapio.br.com.bitbyte.exceptions.LimiteUltrapassadoException;
import web_cardapio.br.com.bitbyte.utils.Control;

public abstract class LimiteService<T> {
	
	protected ComandaDao comandaDAO;
	protected Logger log = Logger.getLogger(getClass());
	
	protected BigDecimal valorComanda = BigDecimal.valueOf(0);
	protected BigDecimal limite = BigDecimal.valueOf(0);
	protected BigDecimal saldo = BigDecimal.valueOf(0);
	protected BigDecimal valorTotal = BigDecimal.valueOf(0);
	
	public LimiteService(ComandaDao comandaDAO) {
		this.comandaDAO = comandaDAO;
	}
	
	protected void validate(int numeroComanda) throws LimiteUltrapassadoException, SQLException 
	{
		StringBuilder sb = new StringBuilder();
		
		//importante obedecer esta ordem devido a dependencia dos valores
		this.valorComanda = getValorComanda(numeroComanda);
		this.limite = getLimite(numeroComanda);
		this.valorTotal = getValorTotal(numeroComanda);
		this.saldo = getSaldo();
		
		//verifica se o valor total é maior que o limite e o limite é diferente de 0
		if(valorTotal.compareTo(limite) == 1 && limite.compareTo(BigDecimal.valueOf(0)) != 0)
		{
			sb.append(getMessage());
			sb.append("\n\n");
			sb.append("Saldo: " +Control.formatarMonetario(saldo));
			sb.append("\n");
			sb.append("Limite: " +Control.formatarMonetario(limite));
			sb.append("\n");
			
			String completeMessage = sb.toString();
			log.info(completeMessage.toUpperCase());
			throw new LimiteUltrapassadoException(completeMessage);
		}
	}
	
	public abstract void verificarLimiteUltrapassado(T t) throws SQLException, LimiteUltrapassadoException;
	
	public abstract BigDecimal getValorComanda(int numeroComanda) throws SQLException;
	
	public abstract BigDecimal getLimite(int numeroComanda) throws SQLException;
	
	public abstract BigDecimal getSaldo();
	
	public abstract BigDecimal getValorTotal(int numeroComanda) throws SQLException;
	
	public abstract String getMessage();

}
