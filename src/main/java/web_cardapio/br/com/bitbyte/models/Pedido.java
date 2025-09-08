package web_cardapio.br.com.bitbyte.models;

import java.math.BigDecimal;
import java.util.List;

import web_cardapio.br.com.bitbyte.utils.BigDecimalUtils;
import web_cardapio.br.com.bitbyte.utils.ListUtils;

public class Pedido{
		
    private BigDecimal valorTotal;
    private List<Item> itens;
    private Comanda comanda;
    	
	public BigDecimal getValorTotal() {
		return BigDecimalUtils.getZeroIfNull(valorTotal);
	}
	public Pedido setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
		return this;
	}
	public List<Item> getItens() {
		return ListUtils.getEmptyIfNull(itens);
	}
	public Pedido setItens(List<Item> lstItens) {
		this.itens = lstItens;
		return this;
	}
	public Comanda getComanda() {
		return comanda;
	}
	public Pedido setComanda(Comanda comanda) {
		this.comanda = comanda;
		return this;
	}
}