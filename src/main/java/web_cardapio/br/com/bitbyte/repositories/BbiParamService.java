package web_cardapio.br.com.bitbyte.repositories;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web_cardapio.br.com.bitbyte.estatico.Parametros;

@Service
public class BbiParamService {
	
	@Autowired
	private ParametrosService paramRepository;
	
	public int comandaInicial() {
		return paramRepository.getInt(Parametros.COMANDA_INICIAL);
	}
	
	public int comandaFinal() {
		return paramRepository.getInt(Parametros.COMANDA_FINAL);
	}
	
	public boolean validaLimiteCaixaAbertura() {
		return paramRepository.getBoolean(Parametros.VALIDA_LIMITE_CAIXA_ABERTURA);
	}
	
	public BigDecimal valorTravaComanda() {
		return paramRepository.getBigDecimal(Parametros.VALOR_TRAVA_COMANDA);
	}
	
	public boolean aberturaComanda() {
		return paramRepository.getBoolean(Parametros.ABERTURA_COMANDA);
	}
	
	public boolean comandaPrePaga() {
		return paramRepository.getBoolean(Parametros.COMANDA_PRE_PAGA);
	}
}
