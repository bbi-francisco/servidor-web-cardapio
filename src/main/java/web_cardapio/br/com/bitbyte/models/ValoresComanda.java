package web_cardapio.br.com.bitbyte.models;

import java.math.BigDecimal;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import web_cardapio.br.com.bitbyte.utils.BigDecimalUtils;

@JsonIgnoreProperties("limiteInvalido")
public class ValoresComanda 
{
	private BigDecimal valorComanda;
	private BigDecimal saldo;
	private BigDecimal limite;
	private BigDecimal valorTotal;
	
	public BigDecimal getValorComanda() {
		return BigDecimalUtils.getZeroIfNull(valorComanda);
	}
	
	public ValoresComanda setValorComanda(BigDecimal valorComanda) {
		this.valorComanda = valorComanda;
		return this;
	}
	
	public BigDecimal getSaldo() {
		return BigDecimalUtils.getZeroIfNull(saldo);
	}
	
	public ValoresComanda setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
		return this;
	}
	
	public BigDecimal getLimite() {
		return BigDecimalUtils.getZeroIfNull(limite);
	}
	
	public ValoresComanda setLimite(BigDecimal limite) {
		this.limite = limite;
		return this;
	}
	
	public BigDecimal getValorTotal() {
		return BigDecimalUtils.getZeroIfNull(valorTotal);
	}
	
	public ValoresComanda setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
		return this;
	}
	
	public boolean isLimiteInvalido() {
		return getValorTotal().compareTo(getLimite()) == 1 && getLimite().compareTo(BigDecimal.valueOf(0)) != 0;
	}
}
