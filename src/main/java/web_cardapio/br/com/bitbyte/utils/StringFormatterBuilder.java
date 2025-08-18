package web_cardapio.br.com.bitbyte.utils;

import java.text.Normalizer;

import org.apache.log4j.Logger;

public class StringFormatterBuilder {
    
    private boolean upperCase;
    private int limiteCaracteres = -1;
    private boolean removerAcentos;
    private boolean removerLetras;
    private boolean trim;
    private int charLength = -1;
    private NumberFormatter numberFormatter;
    private static final Logger logger = Logger.getLogger(StringFormatterBuilder.class);
    private boolean removerCaracteresEspeciais;
    
    private String removeAllCharsBeforeChar = "";
    
    public StringFormatterBuilder(){
        numberFormatter = new NumberFormatter();
    }
    
    public String build(String valueParam)
    {   
        String value = valueParam != null ? valueParam : ""; 
        
        if(removerCaracteresEspeciais){
            value = Normalizer.normalize(value, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
            value = value.replace("\"", "");
            value = value.replace("'", "");
            value = value.replace("`", "");
        }
        
        if(removerAcentos){
            value = Normalizer.normalize(value, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
            value = value.replace("\"", "");
        }
        
        if(removerLetras){
            try{
                value = value.replaceAll("\\D", "");
                int intValue = Integer.parseInt(value);
                value = String.valueOf(intValue);
            }catch(NumberFormatException e){
                logger.trace("Remover números falhou: " +e);
            }
        }
        
        if(upperCase){
            value = value.toUpperCase();
        }
        
        if(charLength != -1){
            try{
                value = numberFormatter.getNumberWithLength(Integer.parseInt(value), charLength);
            }catch(NumberFormatException e){
                logger.trace("Formatar numero com padrão de zeros falhou: " + e);
            }
            
        }
        
        if(trim){
            value = value.trim();
        }
        
        if(limiteCaracteres != -1 && value.length() > limiteCaracteres){
            value = value.substring(0, limiteCaracteres);
        }
        
        if(!removeAllCharsBeforeChar.isEmpty())
        {
            try{
                int index = value.indexOf(removeAllCharsBeforeChar);
                int length = value.length();
                value = value.substring(index, length).replace(removeAllCharsBeforeChar, "").trim();
            }catch(StringIndexOutOfBoundsException e){
                logger.trace("Remover caracteres antes de '" +removeAllCharsBeforeChar +"' falhou: " +e);
            }
        }
        
        resetValues();
        return value;
    }
    
    public StringFormatterBuilder removeAllCharsBeforeChar(String character){
        removeAllCharsBeforeChar = character;
        return this;
    }

    public StringFormatterBuilder toUpperCase() {
        this.upperCase = true;
         return this;
    }

    public StringFormatterBuilder limitarCaracteres(int limite) {
        this.limiteCaracteres = limite;
         return this;
    }
    
    public StringFormatterBuilder trim() {
        this.trim = true;
        return this;
    }
    
    public StringFormatterBuilder removerAcentos() {
        this.removerAcentos = true;
         return this;
    }

    public StringFormatterBuilder removerLetras() {
        this.removerLetras = true;
         return this;
    }

    public StringFormatterBuilder defineCharLength(int charLenth) {
        this.charLength = charLenth;
        this.limiteCaracteres = charLength;
        return this;
    }
    
    public StringFormatterBuilder removerCaracteresEspeciais() {
        this.removerCaracteresEspeciais = true;
         return this;
    }
    
    private void resetValues(){
        upperCase = false;
        limiteCaracteres = -1;
        removerAcentos = false;
        removerLetras = false;
        charLength = -1;
        removeAllCharsBeforeChar = "";
        trim = false;
    }
}