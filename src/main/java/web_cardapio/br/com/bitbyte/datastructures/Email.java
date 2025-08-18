package web_cardapio.br.com.bitbyte.datastructures;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import web_cardapio.br.com.bitbyte.utils.StringUtils;

public final class Email {
    
    private String email;
    
    public Email(String email) throws IllegalArgumentException
    {
        this.email = email != null ? email : "";
        if(!isValid()){
            throw new IllegalArgumentException("O email '" +email+ "' é inválido. ");
        }
    }
    
    private boolean isValid()
    {
        if(email == null || email.isEmpty()) return false;

        String expression = "^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$";
        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
    
    public String toString(){
        return StringUtils.getEmptyIfNull(email);
    }
    
}