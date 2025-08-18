package web_cardapio.br.com.bitbyte.cupomfiscal;

import com.thoughtworks.xstream.annotations.XStreamAlias;
@XStreamAlias("ide")
public class Identificacao {

    private int cUF;

    private int cNF;

    private int mod;

    private String nserieSAT;

    private String nCFe;

    private String dEmi;

    private String hEmi;

    private int cDV;

    private int tpAmb;

    private String CNPJ;

    private String signAC;

    private String assinaturaQRCODE;
    @XStreamAlias("numeroCaixa")
    private String numeroCaixa;

    public int getcUF() {
        return cUF;
    }

    public String getcUFFormatado() {
        return " - " + cUF;
    }

    public void setcUF(int cUF) {
        this.cUF = cUF;
    }

    public int getcNF() {
        return cNF;
    }

    public void setcNF(int cNF) {
        this.cNF = cNF;
    }

    public int getMod() {
        return mod;
    }

    public void setMod(int mod) {
        this.mod = mod;
    }

    public String getNserieSAT() {
        return nserieSAT;
    }

    public void setNserieSAT(String nserieSAT) {
        this.nserieSAT = nserieSAT;
    }

    public String getnCFe() {
        return nCFe;
    }

    public void setnCFe(String nCFe) {
        this.nCFe = nCFe;
    }

    public String getdEmi() {
        return dEmi;
    }

    public void setdEmi(String dEmi) {
        this.dEmi = dEmi;
    }

    public String gethEmi() {
        return hEmi;
    }

    public void sethEmi(String hEmi) {
        this.hEmi = hEmi;
    }

    public int getcDV() {
        return cDV;
    }

    public void setcDV(int cDV) {
        this.cDV = cDV;
    }

    public int getTpAmb() {
        return tpAmb;
    }

    public void setTpAmb(int tpAmb) {
        this.tpAmb = tpAmb;
    }

    public String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }

    public String getSignAC() {
        return signAC;
    }

    public void setSignAC(String signAC) {
        this.signAC = signAC;
    }

    public String getAssinaturaQRCODE() {
        return assinaturaQRCODE;
    }

    public void setAssinaturaQRCODE(String assinaturaQRCODE) {
        this.assinaturaQRCODE = assinaturaQRCODE;
    }

    public String getNumeroCaixa() {
        return numeroCaixa;
    }

    public void setNumeroCaixa(String numeroCaixa) {
        this.numeroCaixa = numeroCaixa;
    }
}
