package web_cardapio.br.com.bitbyte.utils;

public class NumberFormatter {
    
    public String getRawNumber(String value){
        return value.replaceAll("[^0-9]", "");
    }
    
    public String getNumberWithLength(int number, int length){
        return String.format("%0" + length + "d", number);
    }
    
}
