package web_cardapio.br.com.bitbyte.format;

import web_cardapio.br.com.bitbyte.utils.StringUtils;

public class Format {
	
	/**
	 * Formata a string para comportar o numero de casas indicado. Exemplo: ao passr a string '1', retornar 
	 * a String: '00001'
	 * @param codigoAtendente
	 * @return
	 */
	public static String casasFormat(String codigo, int numeroDeCasas) 
	{
		if(StringUtils.isNullOrEmpty(codigo))
			return "";
		return String.format("%0"+numeroDeCasas+"d", Integer.parseInt(codigo));
	}

}