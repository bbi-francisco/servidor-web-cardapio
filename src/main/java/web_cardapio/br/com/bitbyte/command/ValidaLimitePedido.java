package web_cardapio.br.com.bitbyte.command;

import java.math.BigDecimal;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import web_cardapio.br.com.bitbyte.dao.ComandaDao;
import web_cardapio.br.com.bitbyte.exceptions.BBIException;
import web_cardapio.br.com.bitbyte.exceptions.LimiteUltrapassadoException;
import web_cardapio.br.com.bitbyte.models.Comanda;
import web_cardapio.br.com.bitbyte.models.ValoresComanda;
import web_cardapio.br.com.bitbyte.models.Pedido;	

@Component
public class ValidaLimitePedido
{
	@Autowired
	private ComandaDao comandaDao;
	
	public Boolean execute(Pedido pedido) throws SQLException, BBIException 
	{
		Comanda comanda = pedido.getComanda();
		int numeroComanda = comanda.getNumero();
		
		Comanda comandaAtual = comandaDao.selectComandaByNumero(numeroComanda);
		if(comandaAtual == null) {
			return false;
		}
		
		ValoresComanda limite = comandaAtual.getValoresComanda();
		BigDecimal valorPedido = pedido.getValorTotal();
		BigDecimal valorComanda = limite.getValorComanda();
		BigDecimal valorTotal = valorPedido.add(valorComanda);
		limite.setValorTotal(valorTotal);
		
		if(limite.isLimiteInvalido()) {
			throw new LimiteUltrapassadoException("O total da comanda irá exceder o valor máximo permitido.");
		}
		return true;
	}
}
