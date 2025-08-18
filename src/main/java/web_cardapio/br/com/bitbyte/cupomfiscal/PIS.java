package web_cardapio.br.com.bitbyte.cupomfiscal;

import com.thoughtworks.xstream.annotations.XStreamAlias;
@XStreamAlias("PIS")
public class PIS {
    private PISALIQ PISAliq;
    private PISQtde PISqtde;
    private PISNT PISnt;

    private PISSN PISSN;
    private PISOutr PISoutr;
    private PISST PISst;

    public PISALIQ getPISAliq() {
        return PISAliq;
    }

    public void setPISAliq(PISALIQ PISAliq) {
        this.PISAliq = PISAliq;
    }

    public PISQtde getPISqtde() {
        return PISqtde;
    }

    public void setPISqtde(PISQtde PISqtde) {
        this.PISqtde = PISqtde;
    }

    public PISNT getPISnt() {
        return PISnt;
    }

    public void setPISnt(PISNT PISnt) {
        this.PISnt = PISnt;
    }

    public PISSN getPISSN() {
        return PISSN;
    }

    public void setPISSN(PISSN PISSN) {
        this.PISSN = PISSN;
    }

    public PISOutr getPISoutr() {
        return PISoutr;
    }

    public void setPISoutr(PISOutr PISoutr) {
        this.PISoutr = PISoutr;
    }

    public PISST getPISst() {
        return PISst;
    }

    public void setPISst(PISST PISst) {
        this.PISst = PISst;
    }
}

class PISALIQ {
    private int CST;
    private float vBC;
    private float pPIS;
    private float vPIS;

    public int getCST() {
        return CST;
    }

    public void setCST(int CST) {
        this.CST = CST;
    }

    public float getvBC() {
        return vBC;
    }

    public void setvBC(float vBC) {
        this.vBC = vBC;
    }

    public float getpPIS() {
        return pPIS;
    }

    public void setpPIS(float pPIS) {
        this.pPIS = pPIS;
    }

    public float getvPIS() {
        return vPIS;
    }

    public void setvPIS(float vPIS) {
        this.vPIS = vPIS;
    }
}

class PISQtde {
    private int CST;
    private float qBCProd;
    private float vAliqProd;
    private float vPIS;

    public int getCST() {
        return CST;
    }

    public void setCST(int CST) {
        this.CST = CST;
    }

    public float getqBCProd() {
        return qBCProd;
    }

    public void setqBCProd(float qBCProd) {
        this.qBCProd = qBCProd;
    }

    public float getvAliqProd() {
        return vAliqProd;
    }

    public void setvAliqProd(float vAliqProd) {
        this.vAliqProd = vAliqProd;
    }

    public float getvPIS() {
        return vPIS;
    }

    public void setvPIS(float vPIS) {
        this.vPIS = vPIS;
    }
}

class PISNT {
    private int CST;

    public int getCST() {
        return CST;
    }

    public void setCST(int CST) {
        this.CST = CST;
    }
}
@XStreamAlias("PISSN")
class PISSN {
    @XStreamAlias("CST")
    private int CST;

    public int getCST() {
        return CST;
    }

    public void setCST(int CST) {
        this.CST = CST;
    }
}

class PISOutr {
    private int CST;
    private float vBC;
    private float pPIS;
    private float qBCProd;
    private float vAliqProd;
    private float vPIS;

    public int getCST() {
        return CST;
    }

    public void setCST(int CST) {
        this.CST = CST;
    }

    public float getvBC() {
        return vBC;
    }

    public void setvBC(float vBC) {
        this.vBC = vBC;
    }

    public float getpPIS() {
        return pPIS;
    }

    public void setpPIS(float pPIS) {
        this.pPIS = pPIS;
    }

    public float getqBCProd() {
        return qBCProd;
    }

    public void setqBCProd(float qBCProd) {
        this.qBCProd = qBCProd;
    }

    public float getvAliqProd() {
        return vAliqProd;
    }

    public void setvAliqProd(float vAliqProd) {
        this.vAliqProd = vAliqProd;
    }

    public float getvPIS() {
        return vPIS;
    }

    public void setvPIS(float vPIS) {
        this.vPIS = vPIS;
    }
}

class PISST {
    private float vBC;
    private float pPIS;
    private float qBCProd;
    private float vAliqProd;
    private float vPIS;

    public float getvBC() {
        return vBC;
    }

    public void setvBC(float vBC) {
        this.vBC = vBC;
    }

    public float getpPIS() {
        return pPIS;
    }

    public void setpPIS(float pPIS) {
        this.pPIS = pPIS;
    }

    public float getqBCProd() {
        return qBCProd;
    }

    public void setqBCProd(float qBCProd) {
        this.qBCProd = qBCProd;
    }

    public float getvAliqProd() {
        return vAliqProd;
    }

    public void setvAliqProd(float vAliqProd) {
        this.vAliqProd = vAliqProd;
    }

    public float getvPIS() {
        return vPIS;
    }

    public void setvPIS(float vPIS) {
        this.vPIS = vPIS;
    }
}