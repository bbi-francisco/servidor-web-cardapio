package web_cardapio.br.com.bitbyte.cupomfiscal;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("infAdic")
public class InfAdc {

    private String infCpl;

    private ObsFisco obsFisco;

    public String getInfCpl() {
        return infCpl;
    }

    public void setInfCpl(String infCpl) {
        this.infCpl = infCpl;
    }

    public ObsFisco getObsFisco() {
        return obsFisco;
    }

    public void setObsFisco(ObsFisco obsFisco) {
        this.obsFisco = obsFisco;
    }
}
