package web_cardapio.br.com.bitbyte.models.theme;

import web_cardapio.br.com.bitbyte.utils.StringUtils;

public class ConsultaTheme {
	
	private String textColor;
	private String backgroundColor;
	private String subitemTitleColor;
	
	public String getTextColor() {
		return StringUtils.getEmptyIfNull(textColor);
	}
	public ConsultaTheme setTextColor(String textColor) {
		this.textColor = textColor;
		return this;
	}
	public String getBackgroundColor() {
		return StringUtils.getEmptyIfNull(backgroundColor);
	}
	public ConsultaTheme setBackgroundColor(String backgroundColor) {
		this.backgroundColor = backgroundColor;
		return this;
	}
	public String getSubitemTitleColor() {
		return StringUtils.getEmptyIfNull(subitemTitleColor);
	}
	public ConsultaTheme setSubitemTitleColor(String subitemTitleColor) {
		this.subitemTitleColor = subitemTitleColor;
		return this;
	}
	
	public static ConsultaTheme defaultTheme(){
        return new ConsultaTheme()
                .setBackgroundColor(DefaultTheme.ConsultaTheme.BACKGROUND)
                .setTextColor(DefaultTheme.ConsultaTheme.TEXT)
                .setSubitemTitleColor(DefaultTheme.ConsultaTheme.SUBITEM_TITLE);
    }
}
