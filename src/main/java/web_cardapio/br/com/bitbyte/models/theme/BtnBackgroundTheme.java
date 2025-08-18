package web_cardapio.br.com.bitbyte.models.theme;

import web_cardapio.br.com.bitbyte.utils.StringUtils;

public class BtnBackgroundTheme {
	
	private String color;
	private String textColor;
	
	public String getColor() {
		return StringUtils.getEmptyIfNull(color);
	}
	
	public BtnBackgroundTheme setColor(String color) {
		this.color = color;
		return this;
	}
	
	public String getTextColor() {
		return StringUtils.getEmptyIfNull(textColor);
	}
	
	public BtnBackgroundTheme setTextColor(String textColor) {
		this.textColor = textColor;
		return this;
	}
	
	public static BtnBackgroundTheme defaultTheme(){
		return new BtnBackgroundTheme()
				.setColor(DefaultTheme.BtnBackground.COLOR)
				.setTextColor(DefaultTheme.BtnBackground.TEXT);
	}
}
