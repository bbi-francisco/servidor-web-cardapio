package web_cardapio.br.com.bitbyte.cupomfiscal;


import com.thoughtworks.xstream.annotations.XStreamAlias;
@XStreamAlias("total")
public class Total {
    private ICMSTOT ICMSTot;

    @XStreamAlias("DescAcrEntr")
    private DescAcrEntr descAcrEntr;

    private String vCFe;
    private String vCFeLei12741;

    private ISSQNTOT ISSQNTot;

    public ICMSTOT getICMSTot() {
        return ICMSTot;
    }

    public void setICMSTot(ICMSTOT ICMSTot) {
        this.ICMSTot = ICMSTot;
    }




    public ISSQNTOT getISSQNTot() {
        return ISSQNTot;
    }

    public void setISSQNTot(ISSQNTOT ISSQNTot) {
        this.ISSQNTot = ISSQNTot;
    }

    public String getvCFe() {
        return vCFe;
    }

    public void setvCFe(String vCFe) {
        this.vCFe = vCFe;
    }

    public String getvCFeLei12741() {
        return vCFeLei12741;
    }

    public void setvCFeLei12741(String vCFeLei12741) {
        this.vCFeLei12741 = vCFeLei12741;
    }

    public DescAcrEntr getDescAcrEntr() {
        return descAcrEntr;
    }

    public void setDescAcrEntr(DescAcrEntr descAcrEntr) {
        this.descAcrEntr = descAcrEntr;
    }
}

class ISSQNTOT {
    private float vBC;
    private float vISS;
    private float vPIS;
    private float vCONFINS;
    private float vPISST;
    private float vCONFINSST;

    public float getvBC() {
        return vBC;
    }

    public void setvBC(float vBC) {
        this.vBC = vBC;
    }

    public float getvISS() {
        return vISS;
    }

    public void setvISS(float vISS) {
        this.vISS = vISS;
    }

    public float getvPIS() {
        return vPIS;
    }

    public void setvPIS(float vPIS) {
        this.vPIS = vPIS;
    }

    public float getvCONFINS() {
        return vCONFINS;
    }

    public void setvCONFINS(float vCONFINS) {
        this.vCONFINS = vCONFINS;
    }

    public float getvPISST() {
        return vPISST;
    }

    public void setvPISST(float vPISST) {
        this.vPISST = vPISST;
    }

    public float getvCONFINSST() {
        return vCONFINSST;
    }

    public void setvCONFINSST(float vCONFINSST) {
        this.vCONFINSST = vCONFINSST;
    }
}
