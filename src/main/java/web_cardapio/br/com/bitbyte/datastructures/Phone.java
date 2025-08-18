package web_cardapio.br.com.bitbyte.datastructures;

import java.text.ParseException;

import javax.swing.text.MaskFormatter;

import web_cardapio.br.com.bitbyte.utils.NumberFormatter;
import web_cardapio.br.com.bitbyte.utils.StringUtils;

public class Phone {
    
    private MaskFormatter maskFormatter;
    private NumberFormatter numberFormatter;
    
    private String maskTelefone = "(##)  ####-####";
    private String maskCelular = "(##) #####-####";
    
    private String ddd;
    private String numero;
    
    public Phone(String numero) throws IllegalArgumentException 
    {
        setupNumber(numero);
    }
    
    public Phone(){}
    
    private void setupNumber(String numero) throws IllegalArgumentException 
    { 
        try
        {
            String formattedNumber = StringUtils.getEmptyIfNull(numero);
            if(formattedNumber.trim().startsWith("+55"))
            {
                formattedNumber = formattedNumber.substring(3, formattedNumber.length());
            }
            
            numberFormatter = new NumberFormatter();
            formattedNumber = numberFormatter.getRawNumber(formattedNumber);
            
            this.ddd = formattedNumber.substring(0, 2);
            this.numero = formattedNumber.substring(2, formattedNumber.length());
        }
        catch(NullPointerException | StringIndexOutOfBoundsException e)
        {
            cleanPhone();
            throw new IllegalArgumentException("O telefone '" + numero+ "' é inválido. ", e);
        } 
    }
    
    public String getFormatted() throws ParseException
    {
        String completeNumber = getDdd() + getNumero();
        PhoneType phoneType = getPhoneType(completeNumber);
        
        switch (phoneType) {
            case CELULAR:
                maskFormatter = new MaskFormatter(maskCelular);
                break;
            case TELEFONE:
                maskFormatter = new MaskFormatter(maskTelefone);
                break;
            default:
                throw new IllegalArgumentException(String.format("O telefone (%s) %s é inválido.", getDdd(), getNumero()));
        }
        maskFormatter.setValueContainsLiteralCharacters(false);
        return maskFormatter.valueToString(completeNumber);
    }
    
    private PhoneType getPhoneType(String numero){
        if(numero.length() == 11 || numero.trim().startsWith("+55")){
            return PhoneType.CELULAR;
        }
        if(numero.length() == 10){
            return PhoneType.TELEFONE;
        }
        return PhoneType.INVALID_PHONE;
    }

    public String getDdd() {
        return StringUtils.getEmptyIfNull(ddd);
    }
    
    public Phone setDdd(String ddd){
        this.ddd = ddd;
        return this;
    }

    public String getNumero() {
        return StringUtils.getEmptyIfNull(numero);
    }
    
    public Phone setNumero(String numero){
        this.numero = numero;
        return this;
    }
    
    private enum PhoneType
    {
        CELULAR(0),
        TELEFONE(1),
        INVALID_PHONE(2);
        
        int phoneType;
        
        PhoneType(int phoneType){
            this.phoneType = phoneType;
        }
    }
    
    private void cleanPhone(){
        setDdd("");
        setNumero("");
    }
}
