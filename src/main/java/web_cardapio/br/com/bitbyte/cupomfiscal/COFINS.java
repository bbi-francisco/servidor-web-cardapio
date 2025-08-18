package web_cardapio.br.com.bitbyte.cupomfiscal;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("COFINS")
public class COFINS {
    private int CONFISaliq;
    private int CST;
    private float vBC;
    private float pCONFINS;
    private float vCONFINS;
    private CONFINSQTDE CofinsQtde;
    private CONFINSNT ConfinsNT;
    @XStreamAlias("COFINSSN")
    private CONFINSSN COFINSSN;
    private CONFINSOUTR CONFINSOutr;
    private CONFINSST CONFINSst;

    public int getCONFISaliq() {
        return CONFISaliq;
    }

    public void setCONFISaliq(int CONFISaliq) {
        this.CONFISaliq = CONFISaliq;
    }

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

    public float getpCONFINS() {
        return pCONFINS;
    }

    public void setpCONFINS(float pCONFINS) {
        this.pCONFINS = pCONFINS;
    }

    public float getvCONFINS() {
        return vCONFINS;
    }

    public void setvCONFINS(float vCONFINS) {
        this.vCONFINS = vCONFINS;
    }

    public CONFINSQTDE getCofinsQtde() {
        return CofinsQtde;
    }

    public void setCofinsQtde(CONFINSQTDE cofinsQtde) {
        CofinsQtde = cofinsQtde;
    }

    public CONFINSNT getConfinsNT() {
        return ConfinsNT;
    }

    public void setConfinsNT(CONFINSNT confinsNT) {
        ConfinsNT = confinsNT;
    }

    public CONFINSSN getCOFINSSN() {
        return COFINSSN;
    }

    public void setCOFINSSN(CONFINSSN COFINSSN) {
        this.COFINSSN = COFINSSN;
    }

    public CONFINSOUTR getCONFINSOutr() {
        return CONFINSOutr;
    }

    public void setCONFINSOutr(CONFINSOUTR CONFINSOutr) {
        this.CONFINSOutr = CONFINSOutr;
    }

    public CONFINSST getCONFINSst() {
        return CONFINSst;
    }

    public void setCONFINSst(CONFINSST CONFINSst) {
        this.CONFINSst = CONFINSst;
    }
}

class CONFINSQTDE {
    private int CST;
    private float qBCPROD;
    private float vAliqProd;
    private float vCONFINS;

    public int getCST() {
        return CST;
    }

    public void setCST(int CST) {
        this.CST = CST;
    }

    public float getqBCPROD() {
        return qBCPROD;
    }

    public void setqBCPROD(float qBCPROD) {
        this.qBCPROD = qBCPROD;
    }

    public float getvAliqProd() {
        return vAliqProd;
    }

    public void setvAliqProd(float vAliqProd) {
        this.vAliqProd = vAliqProd;
    }

    public float getvCONFINS() {
        return vCONFINS;
    }

    public void setvCONFINS(float vCONFINS) {
        this.vCONFINS = vCONFINS;
    }
}

class CONFINSNT {
    private int CST;

    public int getCST() {
        return CST;
    }

    public void setCST(int CST) {
        this.CST = CST;
    }
}

class CONFINSSN {
    @XStreamAlias("CST")
    private int CST;

    public int getCST() {
        return CST;
    }

    public void setCST(int CST) {
        this.CST = CST;
    }
}

class CONFINSOUTR {
    private int CST;
    private float vBC;
    private float pCONFINS;
    private float qBCProd;
    private float vAliqProd;
    private float vCONFINS;

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

    public float getpCONFINS() {
        return pCONFINS;
    }

    public void setpCONFINS(float pCONFINS) {
        this.pCONFINS = pCONFINS;
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

    public float getvCONFINS() {
        return vCONFINS;
    }

    public void setvCONFINS(float vCONFINS) {
        this.vCONFINS = vCONFINS;
    }
}

class CONFINSST {
    private float vBC;
    private float pCONFINS;
    private float qBCPROD;
    private float vAliqProd;
    private float VCONFINS;

    public float getvBC() {
        return vBC;
    }

    public void setvBC(float vBC) {
        this.vBC = vBC;
    }

    public float getpCONFINS() {
        return pCONFINS;
    }

    public void setpCONFINS(float pCONFINS) {
        this.pCONFINS = pCONFINS;
    }

    public float getqBCPROD() {
        return qBCPROD;
    }

    public void setqBCPROD(float qBCPROD) {
        this.qBCPROD = qBCPROD;
    }

    public float getvAliqProd() {
        return vAliqProd;
    }

    public void setvAliqProd(float vAliqProd) {
        this.vAliqProd = vAliqProd;
    }

    public float getVCONFINS() {
        return VCONFINS;
    }

    public void setVCONFINS(float VCONFINS) {
        this.VCONFINS = VCONFINS;
    }
}
