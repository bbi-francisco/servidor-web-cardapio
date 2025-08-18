package web_cardapio.br.com.bitbyte.factories;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;

import web_cardapio.br.com.bitbyte.models.ValoresComanda;
import web_cardapio.br.com.bitbyte.repositories.BbiParamService;
import web_cardapio.br.com.bitbyte.utils.BigDecimalUtils;
import web_cardapio.br.com.bitbyte.utils.NumberUtils;

public class ComandaFactory {
	
	@Autowired
	private BbiParamService bbiParamService;
	
	public ValoresComanda createValoresComandaInicial() 
	{
		boolean validaLimiteCaixaAbertura = bbiParamService.validaLimiteCaixaAbertura();
		BigDecimal valorTravaComanda = bbiParamService.valorTravaComanda();
		
		ValoresComanda valores = new ValoresComanda();
		BigDecimal limite = new BigDecimal(0);
		if(NumberUtils.biggerThan(valorTravaComanda, 0)) 
		{
			if(validaLimiteCaixaAbertura) {
				limite = new BigDecimal(0);
			}else {
				limite = valorTravaComanda;
			}
		}
		
		BigDecimal totalComanda = BigDecimalUtils.getZeroIfNull(0);
		BigDecimal saldo = limite.subtract(totalComanda);
		
		return valores
		.setLimite(limite)
		.setValorTotal(totalComanda)
		.setValorComanda(totalComanda)
		.setSaldo(saldo);
	}

}
