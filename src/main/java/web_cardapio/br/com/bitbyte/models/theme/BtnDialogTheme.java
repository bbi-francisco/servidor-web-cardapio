package web_cardapio.br.com.bitbyte.models.theme;

import web_cardapio.br.com.bitbyte.utils.StringUtils;

public class BtnDialogTheme {
	
	private String color;
	private String textColor;
	
	public String getColor() {
		return StringUtils.getEmptyIfNull(color);
	}
	
	public BtnDialogTheme setColor(String color) {
		this.color = color;
		return this;
	}
	
	public String getTextColor() {
		return StringUtils.getEmptyIfNull(textColor);
	}
	
	public BtnDialogTheme setTextColor(String textColor) {
		this.textColor = textColor;
		return this;
	}
	
	public static BtnDialogTheme defaultTheme(){
        return new BtnDialogTheme()
                .setColor(DefaultTheme.BtnDialog.COLOR)
                .setTextColor(DefaultTheme.BtnDialog.TEXT);
    }
}
