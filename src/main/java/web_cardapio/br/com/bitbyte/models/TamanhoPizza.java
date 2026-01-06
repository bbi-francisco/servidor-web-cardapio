package web_cardapio.br.com.bitbyte.models;
public class TamanhoPizza {
	
	protected int qtdMinPizza;
    protected int qtdMaxPizza;
    protected int codigoTamanhoPizza;
    protected String descricaoTamanhoPizza;
    protected String abreviacao;

    public int getCodigoTamanhoPizza() {
        return codigoTamanhoPizza;
    }

    public void setCodigoTamanhoPizza(int codigoTamanhoPizza) {
        this.codigoTamanhoPizza = codigoTamanhoPizza;
    }

    public String getDescricaoTamanhoPizza() {
        return descricaoTamanhoPizza != null ? descricaoTamanhoPizza : "";
    }
    public void setDescricaoTamanhoPizza(String descricaoTamanhoPizza) {
        this.descricaoTamanhoPizza = descricaoTamanhoPizza;
    }


    public String getAbreviacao() {
        return abreviacao != null ? abreviacao : "";
    }

    public void setAbreviacao(String abreviacao) {
        this.abreviacao = abreviacao;
    }


    public int getQtdMinPizza() {
        return qtdMinPizza;
    }

    public void setQtdMinPizza(int qtdMinPizza) {
        this.qtdMinPizza = qtdMinPizza;
    }

    public int getQtdMaxPizza() {
        return qtdMaxPizza;
    }

    public void setQtdMaxPizza(int qtdMaxPizza) {
        this.qtdMaxPizza = qtdMaxPizza;
    }

}