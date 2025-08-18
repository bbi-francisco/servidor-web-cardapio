package web_cardapio.br.com.bitbyte.cupomfiscal;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("entrega")
public class Entrega {
    private String xLgr;
    private String nro;
    private String xCpl;
    private String xBairro;
    private String xMun;
    private String UF;

    public String getxLgr() {
        if (xLgr == null) {
            return "";
        }
        return xLgr;
    }

    public void setxLgr(String xLgr) {
        this.xLgr = xLgr;
    }

    public String getNro() {
        return nro;
    }

    public String getNroFormatado() {
        if (nro == null) {
            return "";
        }
        return ", " + nro;
    }

    public void setNro(String nro) {
        this.nro = nro;
    }

    public String getxCpl() {
        return xCpl;
    }

    public String getxCplFormatado() {
        if (xCpl == null) {
            return "";
        }
        return " - " + xCpl;
    }

    public void setxCpl(String xCpl) {
        this.xCpl = xCpl;
    }

    public String getxBairro() {
        return xBairro;
    }
    public String getxBairroFormatado() {
        if (xBairro == null) {
            return "";
        }
        return " - " + xBairro;
    }


    public void setxBairro(String xBairro) {
        this.xBairro = xBairro;
    }

    public String getxMun() {
        return xMun;
    }
    public String getxMunFormatado() {
        if (xMun == null) {
            return "";
        }
        return " - " + xMun;
    }


    public void setxMun(String xMun) {
        this.xMun = xMun;
    }

    public String getUF() {
        return UF;
    }

    public String getUFFormatado() {
        if (UF == null) {
            return "";
        }
        return " - " + UF;
    }

    public void setUF(String UF) {
        this.UF = UF;
    }
}
