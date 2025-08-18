package web_cardapio.br.com.bitbyte.cupomfiscal;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("obsFisco")
public class ObsFisco {

    private String xCampo;
    private String xTexto;


    public String getxCampo() {
        return xCampo;
    }

    public void setxCampo(String xCampo) {
        this.xCampo = xCampo;
    }

    public String getxTexto() {
        return xTexto;
    }

    public void setxTexto(String xTexto) {
        this.xTexto = xTexto;
    }
}
