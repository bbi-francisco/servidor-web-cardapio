package web_cardapio.br.com.bitbyte.cupomfiscal;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

@XStreamAlias("det")
public class Detalhamento {
    @XStreamAsAttribute
    @XStreamAlias("nItem")
    private int nItem;
    private Produto prod;
    private Imposto imposto;


    public Detalhamento(int nItem, Produto prod, Imposto imposto) {
        this.nItem = nItem;
        this.prod = prod;
        this.imposto = imposto;
    }

    public int getnItem() {
        return nItem;
    }

    public void setnItem(int nItem) {
        this.nItem = nItem;
    }

    public Produto getProd() {
        return prod;
    }

    public void setProd(Produto prod) {
        this.prod = prod;
    }


    public Imposto getImposto() {
        return imposto;
    }

    public void setImposto(Imposto imposto) {
        this.imposto = imposto;
    }
}
