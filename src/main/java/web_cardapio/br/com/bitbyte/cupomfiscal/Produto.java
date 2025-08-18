package web_cardapio.br.com.bitbyte.cupomfiscal;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("prod")
public class Produto {
    private String cProd;
    private String xProd;
    private String NCM;
    private String CFOP;
    private String uCom;
    private String qCom;
    private String vUnCom;
    private String vProd;
    private String indRegra;
    private String vItem;

    private String vRatDesc;

    private String vRatAcr;

    private String vDesc;

    private String vOutro;



    public String getNCM() {
        return NCM;
    }

    public void setNCM(String NCM) {
        this.NCM = NCM;
    }

    public String getCFOP() {
        return CFOP;
    }

    public void setCFOP(String CFOP) {
        this.CFOP = CFOP;
    }

    public String getcProd() {
        return cProd;
    }

    public void setcProd(String cProd) {
        this.cProd = cProd;
    }

    public String getxProd() {
        return xProd;
    }

    public void setxProd(String xProd) {
        this.xProd = xProd;
    }

    public String getuCom() {
        return uCom;
    }

    public void setuCom(String uCom) {
        this.uCom = uCom;
    }

    public String getqCom() {
        return qCom;
    }

    public void setqCom(String qCom) {
        this.qCom = qCom;
    }

    public String getvUnCom() {
        return vUnCom;
    }

    public void setvUnCom(String vUnCom) {
        this.vUnCom = vUnCom;
    }

    public String getvProd() {
        return vProd;
    }

    public void setvProd(String vProd) {
        this.vProd = vProd;
    }

    public String getIndRegra() {
        return indRegra;
    }

    public void setIndRegra(String indRegra) {
        this.indRegra = indRegra;
    }

    public String getvItem() {
        return vItem;
    }

    public void setvItem(String vItem) {
        this.vItem = vItem;
    }

    public String getvRatDesc() {
        return vRatDesc;
    }

    public void setvRatDesc(String vRatDesc) {
        this.vRatDesc = vRatDesc;
    }

    public String getvRatAcr() {
        return vRatAcr;
    }

    public void setvRatAcr(String vRatAcr) {
        this.vRatAcr = vRatAcr;
    }

    public String getvDesc() {
        return vDesc;
    }

    public void setvDesc(String vDesc) {
        this.vDesc = vDesc;
    }

    public String getvOutro() {
        return vOutro;
    }

    public void setvOutro(String vOutro) {
        this.vOutro = vOutro;
    }
}
