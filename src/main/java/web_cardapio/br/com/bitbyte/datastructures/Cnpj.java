package web_cardapio.br.com.bitbyte.datastructures;

import java.text.ParseException;

import javax.swing.text.MaskFormatter;

import org.apache.log4j.Logger;

import web_cardapio.br.com.bitbyte.utils.NumberFormatter;

public class Cnpj {
    
    private static final String maskCnpj = "##.###.###/####-##";
    
    private NumberFormatter numberFormatter;
    private MaskFormatter maskFormatter;
    private Logger logger = Logger.getLogger(Cnpj.class);
    
    private String cnpj;
    
    public Cnpj(String cnpj) throws IllegalArgumentException{
        this.cnpj = cnpj;
        numberFormatter = new NumberFormatter();
    }
    
    public String getFormatted() throws ParseException
    {
        String rawCnpj = numberFormatter.getRawNumber(cnpj);
        maskFormatter = new MaskFormatter(maskCnpj);
        maskFormatter.setValueContainsLiteralCharacters(false);
        return maskFormatter.valueToString(rawCnpj);
    }
}