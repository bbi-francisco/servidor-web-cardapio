package web_cardapio.br.com.bitbyte.utils;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

import org.apache.log4j.Logger;

public class Control
{
	private static Logger log = Logger.getLogger(Control.class);

	public static String formatarMonetario(String valorMonetario)
	{
		return formatarMonetario(new BigDecimal(valorMonetario));
	}

	public static String formatarDuasCasas(String valor)
	{
		DecimalFormat decimalFormat = new DecimalFormat("#,###.00");
		return decimalFormat.format(new BigDecimal(valor));
	}
	
	public static String formatarDuasCasas(BigDecimal valor)
	{
		DecimalFormat decimalFormat = new DecimalFormat("#,###.00");
		return decimalFormat.format(valor);
	}

	public static String formatarMonetario(BigDecimal valorMonetario)
	{
		NumberFormat currency = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
		String valorFormatado = "";
		valorFormatado = currency.format(valorMonetario);
		return valorFormatado;
	}
}
