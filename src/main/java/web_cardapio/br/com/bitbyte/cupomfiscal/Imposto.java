package web_cardapio.br.com.bitbyte.cupomfiscal;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("imposto")
public class Imposto {
    private String vItem12741;
    private ICMS ICMS;
    private PIS PIS;
    private COFINS COFINS;
   @XStreamAlias("ISSQN")
    private ISSQN issqn;

    public String getvItem12741() {
        return vItem12741;
    }

    public void setvItem12741(String vItem12741) {
        this.vItem12741 = vItem12741;
    }

    public ICMS getICMS() {
        return ICMS;
    }

    public void setICMS(ICMS ICMS) {
        this.ICMS = ICMS;
    }

    public PIS getPIS() {
        return PIS;
    }

    public void setPIS(PIS PIS) {
        this.PIS = PIS;
    }

    public COFINS getCOFINS() {
        return COFINS;
    }

    public void setCOFINS(COFINS COFINS) {
        this.COFINS = COFINS;
    }

    public ISSQN getIssqn() {
        return issqn;
    }

    public void setIssqn(ISSQN issqn) {
        this.issqn = issqn;
    }
}

@XStreamAlias("ICMS")
class ICMS {
    private ICMSSN102 ICMSSN102;

    public ICMSSN102 getICMSSN102() {
        return ICMSSN102;
    }

    public void setICMSSN102(ICMSSN102 ICMSSN102) {
        this.ICMSSN102 = ICMSSN102;
    }
}
@XStreamAlias("ICMSSN102")
class ICMSSN102 {

    private int Orig;

    private int CSOSN;

    public int getOrig() {
        return Orig;
    }

    public void setOrig(int orig) {
        Orig = orig;
    }

    public int getCSOSN() {
        return CSOSN;
    }

    public void setCSOSN(int CSOSN) {
        this.CSOSN = CSOSN;
    }
}
