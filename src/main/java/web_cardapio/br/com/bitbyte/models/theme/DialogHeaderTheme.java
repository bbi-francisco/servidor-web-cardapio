package web_cardapio.br.com.bitbyte.models.theme;

import web_cardapio.br.com.bitbyte.utils.StringUtils;

public class DialogHeaderTheme {
	
	private String color;
	private String textColor;
	
	public String getColor() {
		return StringUtils.getEmptyIfNull(color);
	}
	public DialogHeaderTheme setColor(String color) {
		this.color = color;
		return this;
	}
	public String getTextColor() {
		return StringUtils.getEmptyIfNull(textColor);
	}
	public DialogHeaderTheme setTextColor(String textColor) {
		this.textColor = textColor;
		return this;
	}
	
	public static DialogHeaderTheme defaultTheme(){
        return new DialogHeaderTheme()
                .setColor(DefaultTheme.DialogHeader.COLOR)
                .setTextColor(DefaultTheme.DialogHeader.TEXT);
    }
}
