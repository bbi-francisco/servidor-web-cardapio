package web_cardapio.br.com.bitbyte.cupomfiscal;

import java.util.List;

public class CupomFiscal {
    private float versao;
    private float versaoDados;
    private int versaoSF;
    private int id;
    /** Grupo de informações de identificação do CF-e */
    private Identificacao ident;
    /** Identificação do emitente do CF-e */
    private Emitente emitente;
    /** Identificação do destinatario do CF-e */
    private Destinatario dest;
    /** Informar apenas em caso de entrega a domicilio */
    private Entrega entrega;
    /** Detalhamento dos produtos e serviços do CF-e */
    private Detalhamento det;
    /** Grupo de valores totais do CF-e */
    private Total total;
    /** Informações sobre pagamento do CF-e */
    private Pagamento pagamento;
    /** Informações adicionais do CF-e */
    private InfAdc InformacaoAdicional;

    public float getVersao() {
        return versao;
    }

    public void setVersao(float versao) {
        this.versao = versao;
    }

    public float getVersaoDados() {
        return versaoDados;
    }

    public void setVersaoDados(float versaoDados) {
        this.versaoDados = versaoDados;
    }

    public int getVersaoSF() {
        return versaoSF;
    }

    public void setVersaoSF(int versaoSF) {
        this.versaoSF = versaoSF;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Destinatario getDest() {
        return dest;
    }

    public void setDest(Destinatario dest) {
        this.dest = dest;
    }

    public Identificacao getIdent() {
        return ident;
    }

    public void setIdent(Identificacao ident) {
        this.ident = ident;
    }

    public Emitente getEmitente() {
        return emitente;
    }

    public void setEmitente(Emitente emitente) {
        this.emitente = emitente;
    }

    public Entrega getEntrega() {
        return entrega;
    }

    public void setEntrega(Entrega entrega) {
        this.entrega = entrega;
    }

    public Detalhamento getDet() {
        return det;
    }

    public void setDet(Detalhamento det) {
        this.det = det;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

    public Total getTotal() {
        return total;
    }

    public void setTotal(Total total) {
        this.total = total;
    }

    public InfAdc getInformacaoAdicional() {
        return InformacaoAdicional;
    }

    public void setInformacaoAdicional(InfAdc informacaoAdicional) {
        this.InformacaoAdicional = informacaoAdicional;
    }
}
