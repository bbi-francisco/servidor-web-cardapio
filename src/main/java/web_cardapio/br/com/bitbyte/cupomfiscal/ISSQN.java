package web_cardapio.br.com.bitbyte.cupomfiscal;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("ISSQN")
public class ISSQN {
    private String vDeducISSQN;
    private String vBC;
    private float vAliq;
    private float vISSQN;
    private int cMunFG;
    private int cListServ;
    private int cServTribMun;
    private int cNatOP;
    private int indIncFisc;


    public String getvDeducISSQN() {
        return vDeducISSQN;
    }

    public void setvDeducISSQN(String vDeducISSQN) {
        this.vDeducISSQN = vDeducISSQN;
    }

    public String getvBC() {
        return vBC;
    }

    public void setvBC(String vBC) {
        this.vBC = vBC;
    }

    public float getvAliq() {
        return vAliq;
    }

    public void setvAliq(float vAliq) {
        this.vAliq = vAliq;
    }

    public float getvISSQN() {
        return vISSQN;
    }

    public void setvISSQN(float vISSQN) {
        this.vISSQN = vISSQN;
    }

    public int getcMunFG() {
        return cMunFG;
    }

    public void setcMunFG(int cMunFG) {
        this.cMunFG = cMunFG;
    }

    public int getcListServ() {
        return cListServ;
    }

    public void setcListServ(int cListServ) {
        this.cListServ = cListServ;
    }

    public int getcServTribMun() {
        return cServTribMun;
    }

    public void setcServTribMun(int cServTribMun) {
        this.cServTribMun = cServTribMun;
    }

    public int getcNatOP() {
        return cNatOP;
    }

    public void setcNatOP(int cNatOP) {
        this.cNatOP = cNatOP;
    }

    public int getIndIncFisc() {
        return indIncFisc;
    }

    public void setIndIncFisc(int indIncFisc) {
        this.indIncFisc = indIncFisc;
    }
}
