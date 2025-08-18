package web_cardapio.br.com.bitbyte.cupomfiscal;
import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("dest")
public class Destinatario {

    private String CNPJ;
    private String CPF;

    private String xNome;

    public String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getxNome() {
        return xNome;
    }

    public void setxNome(String xNome) {
        this.xNome = xNome;
    }
}
