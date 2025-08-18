package web_cardapio.br.com.bitbyte.models;

import web_cardapio.br.com.bitbyte.enums.TipoPagamento;
import web_cardapio.br.com.bitbyte.utils.NumberUtils;
import web_cardapio.br.com.bitbyte.utils.StringUtils;

public class PagamentoObj
{

	private String comanda;
	private Double totalComanda;
	private Double totalReceber;
	private Double totalRecebido;
	private Double troco;
	private Double desconto;
	private Double gorjeta;
	private Double acrescimo;
	private Double dinheiro;
	private Double cartaoCredito;
	private Double cartaoDebito;
	private Double cheque;
	private Double chequePre;
	private Double ticket;
	private Double convenio;
	private Double recebimento;
	private String cpfCnpj;
	private String codFunc;
	private String listComanda;
	private boolean imprimeCupom;

	private boolean imprimeSetor;

	private String mesa;

	private TipoPagamento tipoPagamento;

	public String getComanda()
	{
		return comanda;
	}

	public void setComanda(String comanda)
	{
		this.comanda = comanda;
	}

	public Double getTotalComanda()
	{
		return totalComanda;
	}

	public void setTotalComanda(Double totalComanda)
	{
		this.totalComanda = totalComanda;
	}

	public Double getTotalReceber()
	{
		return NumberUtils.getZeroIfNull(totalReceber);
	}

	public void setTotalReceber(Double totalReceber)
	{
		this.totalReceber = totalReceber;
	}

	public Double getTotalRecebido()
	{
		return NumberUtils.getZeroIfNull(totalRecebido);
	}

	public void setTotalRecebido(Double totalRecebido)
	{
		this.totalRecebido = totalRecebido;
	}

	public Double getTroco()
	{
		return NumberUtils.getZeroIfNull(troco);
	}

	public void setTroco(Double troco)
	{
		this.troco = troco;
	}

	public Double getDesconto()
	{
		return NumberUtils.getZeroIfNull(desconto);
	}

	public void setDesconto(Double desconto)
	{
		this.desconto = desconto;
	}

	public Double getGorjeta()
	{
		return NumberUtils.getZeroIfNull(gorjeta);
	}

	public void setGorjeta(Double gorjeta)
	{
		this.gorjeta = gorjeta;
	}

	public Double getAcrescimo()
	{
		return NumberUtils.getZeroIfNull(acrescimo);
	}

	public void setAcrescimo(Double acrescimo)
	{
		this.acrescimo = acrescimo;
	}

	public Double getDinheiro()
	{
		return NumberUtils.getZeroIfNull(dinheiro);
	}

	public void setDinheiro(Double dinheiro)
	{
		this.dinheiro = dinheiro;
	}

	public Double getCartaoCredito()
	{
		return NumberUtils.getZeroIfNull(cartaoCredito);
	}

	public void setCartaoCredito(Double cartaoCredito)
	{
		this.cartaoCredito = cartaoCredito;
	}

	public Double getCartaoDebito()
	{
		return NumberUtils.getZeroIfNull(cartaoDebito);
	}

	public void setCartaoDebito(Double cartaoDebito)
	{
		this.cartaoDebito = cartaoDebito;
	}

	public Double getCheque()
	{
		return NumberUtils.getZeroIfNull(cheque);
	}

	public void setCheque(Double cheque)
	{
		this.cheque = cheque;
	}

	public Double getChequePre()
	{
		return NumberUtils.getZeroIfNull(chequePre);
	}

	public void setChequePre(Double chequePre)
	{
		this.chequePre = chequePre;
	}

	public Double getTicket()
	{
		return NumberUtils.getZeroIfNull(ticket);
	}

	public void setTicket(Double ticket)
	{
		this.ticket = ticket;
	}

	public Double getConvenio()
	{
		return NumberUtils.getZeroIfNull(convenio);
	}

	public void setConvenio(Double convenio)
	{
		this.convenio = convenio;
	}

	public Double getRecebimento()
	{
		return NumberUtils.getZeroIfNull(recebimento);
	}

	public void setRecebimento(Double recebimento)
	{
		this.recebimento = recebimento;
	}

	public String getCpfCnpj()
	{
		return StringUtils.getEmptyIfNull(cpfCnpj);
	}

	public void setCpfCnpj(String cpfCnpj)
	{
		this.cpfCnpj = cpfCnpj;
	}

	public String getCodFunc()
	{
		return StringUtils.getEmptyIfNull(codFunc);
	}

	public void setCodFunc(String codFunc)
	{
		this.codFunc = codFunc;
	}

	public String getListComanda()
	{
		return StringUtils.getEmptyIfNull(listComanda);
	}

	public void setListComanda(String listComanda)
	{
		this.listComanda = listComanda;
	}

	public boolean isImprimeCupom()
	{
		return imprimeCupom;
	}

	public void setImprimeCupom(boolean imprimeCupom)
	{
		this.imprimeCupom = imprimeCupom;
	}

	public boolean isImprimeSetor() {
		return imprimeSetor;
	}

	public void setImprimeSetor(boolean imprimeSetor) {
		this.imprimeSetor = imprimeSetor;
	}

	public TipoPagamento getTipoPagamento() {
		return tipoPagamento;
	}

	public void setTipoPagamento(TipoPagamento tipoPagamento) {
		this.tipoPagamento = tipoPagamento;
	}

	public String getMesa() {
		return StringUtils.getEmptyIfNull(mesa);
	}

	public void setMesa(String mesa) {
		this.mesa = mesa;
	}
}
