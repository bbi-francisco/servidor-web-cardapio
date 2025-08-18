package web_cardapio.br.com.bitbyte.models;

import java.math.BigDecimal;

public class PagamentoParcial {
    private int numeroComanda;
    private String historico;
    private BigDecimal dinheiro;
    private BigDecimal valorCredito;
    private BigDecimal valorDebito;
    private BigDecimal valorTicket;
    private BigDecimal valorCheque;
    private BigDecimal valorChequePre;
    private BigDecimal valorRecebimento;
    private BigDecimal totalVenda;
    private BigDecimal totalPago;
    private BigDecimal valorTroco;
    private String numeroCaixa;
    private int idCaixa;
    private int numeroPessoas;
    private String data;
    private String horario;
    private int idVenda;

    public PagamentoParcial(){

    }

    public int getNumeroComanda() {
        return numeroComanda;
    }

    public void setNumeroComanda(int numeroComanda) {
        this.numeroComanda = numeroComanda;
    }

    public String getHistorico() {
        return historico != null ? historico : "";
    }

    public void setHistorico(String historico) {
        this.historico = historico;
    }

    public BigDecimal getDinheiro() {
        return dinheiro != null ? dinheiro : new BigDecimal(0);
    }

    public void setDinheiro(BigDecimal dinheiro) {
        this.dinheiro = dinheiro;
    }

    public BigDecimal getValorCartaoCredito() {
        return valorCredito != null ? valorCredito : new BigDecimal(0);
    }

    public void setValorCredito(BigDecimal valorCredito) {
        this.valorCredito = valorCredito;
    }

    public BigDecimal getValorCartaoDebito() {
        return valorDebito != null ? valorDebito : new BigDecimal(0);
    }

    public void setValorDebito(BigDecimal valorDebito) {
        this.valorDebito = valorDebito;
    }

    public BigDecimal getValorTicket() {
        return valorTicket != null ? valorTicket : new BigDecimal(0);
    }

    public void setValorTicket(BigDecimal valorTicket) {
        this.valorTicket = valorTicket;
    }

    public BigDecimal getValorCheque() {
        return valorCheque != null ? valorCheque : new BigDecimal(0);
    }

    public void setValorCheque(BigDecimal valorCheque) {
        this.valorCheque = valorCheque;
    }

    public BigDecimal getValorChequePre() {
        return valorChequePre != null ? valorChequePre : new BigDecimal(0);
    }

    public void setValorChequePre(BigDecimal valorChequePre) {
        this.valorChequePre = valorChequePre;
    }

    public BigDecimal getValorRecebimento() {
        return valorRecebimento != null ? valorRecebimento : new BigDecimal(0);
    }

    public void setValorRecebimento(BigDecimal valorRecebimento) {
        this.valorRecebimento = valorRecebimento;
    }

    public BigDecimal getTotalVenda() {
        return totalVenda != null ? totalVenda : new BigDecimal(0);
    }

    public void setTotalVenda(BigDecimal totalVenda) {
        this.totalVenda = totalVenda;
    }

    public BigDecimal getTotalPago() {
        return totalPago != null ? totalPago : new BigDecimal(0);
    }

    public void setTotalPago(BigDecimal totalPago) {
        this.totalPago = totalPago;
    }

    public BigDecimal getValorTroco() {
        return valorTroco != null ? valorTroco : new BigDecimal(0);
    }

    public void setValorTroco(BigDecimal valorTroco) {
        this.valorTroco = valorTroco;
    }

    public String getNumeroCaixa() {
        return numeroCaixa != null ? numeroCaixa : "";
    }

    public void setNumeroCaixa(String numeroCaixa) {
        this.numeroCaixa = numeroCaixa;
    }

    public int getIdCaixa() {
        return idCaixa;
    }

    public void setIdCaixa(int idCaixa) {
        this.idCaixa = idCaixa;
    }

    public int getNumeroPessoas() {
        return numeroPessoas;
    }

    public void setNumeroPessoas(int numeroPessoas) {
        this.numeroPessoas = numeroPessoas;
    }

    public String getData() {
        return data != null ? data : "";
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHorario() {
        return horario != null ? horario : "";
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public int getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }
}