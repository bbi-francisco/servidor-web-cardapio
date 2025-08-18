package web_cardapio.br.com.bitbyte.global;

import java.util.Locale;

public class Global 
{
	private static Locale locale = new Locale("pt", "BR");
	
    public static Locale getLocale()
    {
        return locale;
    }
}