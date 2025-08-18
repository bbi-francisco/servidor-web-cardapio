package web_cardapio.br.com.bitbyte.cupomfiscal;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

import java.util.List;

@XStreamAlias("pgto")
public class Pagamento {
    @XStreamImplicit(itemFieldName="MP")
    private List<MP> MP;

    private String vTroco;

    public List<MP> getMP() {
        return MP;
    }

    public void setMP(List<MP> MP) {
        this.MP = MP;
    }

    public String getvTroco() {
        return vTroco;
    }

    public void setvTroco(String vTroco) {
        this.vTroco = vTroco;
    }
}

