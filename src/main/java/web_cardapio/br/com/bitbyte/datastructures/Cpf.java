package web_cardapio.br.com.bitbyte.datastructures;

import java.text.ParseException;

import javax.swing.text.MaskFormatter;

import web_cardapio.br.com.bitbyte.utils.NumberFormatter;

public final class Cpf {
    
    private static final String maskCpf = "###.###.###-##";
    private NumberFormatter numberFormatter;
    private MaskFormatter maskFormatter;
    
    private String cpf;
    
    public Cpf(String cpf) throws IllegalArgumentException {
        numberFormatter = new NumberFormatter();
        setCpf(cpf);
    }
    
    public String getFormatted() throws ParseException
    {
        String rawCpf = numberFormatter.getRawNumber(cpf);
        maskFormatter = new MaskFormatter(maskCpf);
        maskFormatter.setValueContainsLiteralCharacters(false);
        return maskFormatter.valueToString(rawCpf);
    }
    
    public void setCpf(String cpf){
        this.cpf = cpf;
    }
    
}
