package web_cardapio.br.com.bitbyte.models.theme;

import web_cardapio.br.com.bitbyte.utils.StringUtils;

public class BtnOpcionalTheme {
	
	private String color;
	private String textColor;
	
	public String getColor() {
		return StringUtils.getEmptyIfNull(color);
	}
	
	public BtnOpcionalTheme setColor(String color) {
		this.color = color;
		return this;
	}
	
	public String getTextColor() {
		return StringUtils.getEmptyIfNull(textColor);
	}
	
	public BtnOpcionalTheme setTextColor(String textColor) {
		this.textColor = textColor;
		return this;
	}
	
	 public static BtnOpcionalTheme defaultTheme(){
	        return new BtnOpcionalTheme()
	                .setColor(DefaultTheme.BtnOpcional.COLOR)
	                .setTextColor(DefaultTheme.BtnOpcional.TEXT);
	    }
}
