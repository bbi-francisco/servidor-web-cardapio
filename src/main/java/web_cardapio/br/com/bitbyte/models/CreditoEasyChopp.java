package web_cardapio.br.com.bitbyte.models;

public class CreditoEasyChopp {
	
	private Comanda comanda;
	private PagamentoObj pagamento;
	
	public Comanda getComanda() {
		return comanda;
	}
	
	public CreditoEasyChopp setComanda(Comanda comanda) {
		this.comanda = comanda;
		return this;
	}

	public PagamentoObj getPagamento() {
		return pagamento;
	}

	public void setPagamento(PagamentoObj pagamento) {
		this.pagamento = pagamento;
	}
}
