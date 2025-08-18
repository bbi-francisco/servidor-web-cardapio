package web_cardapio.br.com.bitbyte.utils;

public class StringUtils {
	
	public static String getEmptyIfNull(String value) {
		return value != null ? value : "";
	}
	
	public static boolean isNullOrEmpty(String value) {
		return value == null || value.isEmpty();
	}
	
	public static String concat(Object...values) {
		if(values == null || values.length == 0) {
			return "";
		}
		ImprovedStringBuilder sb = new ImprovedStringBuilder();
		sb.appendAll(values);
		return sb.toString();
	}
	
	public static String getNullIfEmpty(String value){
        return isNullOrEmpty(value) ? null : value;
    }

}
