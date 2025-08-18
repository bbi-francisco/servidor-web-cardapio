package web_cardapio.br.com.bitbyte.cupomfiscal;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("emit")
public class Emitente {

    private String CNPJ;

    private String xNome;

    private String xFant;

    private Endereco enderEmit;

    private String IE;

    private int cRegTrib;

    private String IM;

    private String indRatISSQN;


    public String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }

    public String getIM() {
        return IM;
    }

    public void setIM(String IM) {
        this.IM = IM;
    }

    public String getxNome() {
        return xNome;
    }

    public void setxNome(String xNome) {
        this.xNome = xNome;
    }

    public String getxFant() {
        return xFant;
    }

    public void setxFant(String xFant) {
        this.xFant = xFant;
    }

    public Endereco getEnderEmit() {
        return enderEmit;
    }

    public void setEnderEmit(Endereco enderEmit) {
        this.enderEmit = enderEmit;
    }

    public String getIE() {
        return IE;
    }

    public void setIE(String IE) {
        this.IE = IE;
    }

    public int getcRegTrib() {
        return cRegTrib;
    }

    public void setcRegTrib(int cRegTrib) {
        this.cRegTrib = cRegTrib;
    }

    public String getIndRatISSQN() {
        return indRatISSQN;
    }

    public void setIndRatISSQN(String indRatISSQN) {
        this.indRatISSQN = indRatISSQN;
    }
}
