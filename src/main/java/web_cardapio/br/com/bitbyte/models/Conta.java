package web_cardapio.br.com.bitbyte.models;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import web_cardapio.br.com.bitbyte.utils.BigDecimalUtils;

public class Conta
{
	private List<Item> itensPedidos;
	private BigDecimal taxa;
	private List<PagamentoParcial> pagamentosParciais;
	private List<Comanda> comandas = new ArrayList<>();
	private BigDecimal creditoEasyChopp;
	private boolean aberta;
	
	public List<Item> getItensPedidos()
	{
		return itensPedidos != null ? itensPedidos : Collections.emptyList();
	}
	public Conta setItensPedidos(List<Item> itensPedidos)
	{
		this.itensPedidos = itensPedidos;
		return this;
	}
	public BigDecimal getTaxa()
	{
		return taxa != null ? taxa : BigDecimal.valueOf(0);
	}
	public Conta setTaxa(BigDecimal taxa)
	{
		this.taxa = taxa;
		return this;
	}
	
	public List<PagamentoParcial> getPagamentosParciais() {
		return pagamentosParciais != null ? pagamentosParciais : Collections.emptyList();
	}
	public Conta setPagamentosParciais(List<PagamentoParcial> pagamentosParciais) {
		this.pagamentosParciais = pagamentosParciais;
		return this;
	}
	
	public List<Comanda> getComandas() {
		return comandas != null ? comandas : Collections.emptyList();
	}
	public Conta setComandas(List<Comanda> comandas) {
		this.comandas = comandas;
		return this;
	}
	
	public Comanda getComanda() {
		List<Comanda> comandas = getComandas();
		return !comandas.isEmpty() ? comandas.get(0) : null;
	}
	
	public Conta setComanda(Comanda comanda) {
		this.comandas = new ArrayList<>();
		this.comandas.add(comanda);
		return this;
	}
	public BigDecimal getCreditoEasyChopp() {
		return BigDecimalUtils.getZeroIfNull(creditoEasyChopp);
	}
	public Conta setCreditoEasyChopp(BigDecimal creditoEasyChopp) {
		this.creditoEasyChopp = creditoEasyChopp;
		return this;
	}
	
	public boolean isAberta() {
		return aberta;
	}
	public void setAberta(boolean aberta) {
		this.aberta = aberta;
	}
	
	
}
