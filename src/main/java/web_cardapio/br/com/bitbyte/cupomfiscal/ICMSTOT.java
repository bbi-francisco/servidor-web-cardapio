package web_cardapio.br.com.bitbyte.cupomfiscal;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("ICMSTot")
public class ICMSTOT {
    @XStreamAlias("vICMS")
    private String vICMS;
    @XStreamAlias("vPro")
    private String vProd;
    @XStreamAlias("vDesc")
    private String vDesc;
    @XStreamAlias("vPISST")
    private String vPISST;
    @XStreamAlias("vPIS")
    private String vPis;
    @XStreamAlias("vCOFINS")
    private String vCONFINS;
    @XStreamAlias("vCOFINSST")
    private String vCONFINSST;
    @XStreamAlias("vOutro")
    private String vOutro;

    public String getvICMS() {
        return vICMS;
    }

    public void setvICMS(String vICMS) {
        this.vICMS = vICMS;
    }

    public String getvProd() {
        return vProd;
    }

    public void setvProd(String vProd) {
        this.vProd = vProd;
    }

    public String getvDesc() {
        return vDesc;
    }

    public void setvDesc(String vDesc) {
        this.vDesc = vDesc;
    }

    public String getvPISST() {
        return vPISST;
    }

    public void setvPISST(String vPISST) {
        this.vPISST = vPISST;
    }

    public String getvPis() {
        return vPis;
    }

    public void setvPis(String vPis) {
        this.vPis = vPis;
    }

    public String getvCONFINS() {
        return vCONFINS;
    }

    public void setvCONFINS(String vCONFINS) {
        this.vCONFINS = vCONFINS;
    }

    public String getvCONFINSST() {
        return vCONFINSST;
    }

    public void setvCONFINSST(String vCONFINSST) {
        this.vCONFINSST = vCONFINSST;
    }

    public String getvOutro() {
        return vOutro;
    }

    public void setvOutro(String vOutro) {
        this.vOutro = vOutro;
    }
}
