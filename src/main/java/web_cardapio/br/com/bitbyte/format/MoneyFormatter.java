package web_cardapio.br.com.bitbyte.format;

import java.math.BigDecimal;
import java.text.NumberFormat;

import web_cardapio.br.com.bitbyte.global.Global;

public class MoneyFormatter {
	
    public String format(BigDecimal value)
    {
    	try {
			NumberFormat currency = NumberFormat.getCurrencyInstance(Global.getLocale());
	        return currency.format(value).replace("R$", "R$ ");
		}catch(IllegalArgumentException e) {
			return "";
		}
    }

    public String format(double value){
        return format(BigDecimal.valueOf(value));
    }

}
