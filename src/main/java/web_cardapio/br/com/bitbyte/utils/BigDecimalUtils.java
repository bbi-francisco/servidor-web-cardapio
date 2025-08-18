package web_cardapio.br.com.bitbyte.utils;

import java.math.BigDecimal;

public class BigDecimalUtils {
	
	public static BigDecimal getZeroIfNull(Number number) {
		return number != null ? BigDecimal.valueOf(number.doubleValue()) : new BigDecimal(0);
	}

}
