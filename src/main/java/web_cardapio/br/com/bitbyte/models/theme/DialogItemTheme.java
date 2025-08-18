package web_cardapio.br.com.bitbyte.models.theme;

import web_cardapio.br.com.bitbyte.utils.StringUtils;

public class DialogItemTheme {
	
	private String textColor;
	private String highlightColor;
	
	public String getTextColor() {
		return StringUtils.getEmptyIfNull(textColor);
	}
	public DialogItemTheme setTextColor(String textColor) {
		this.textColor = textColor;
		return this;
	}
	
	public String getHighlightColor() {
		return StringUtils.getEmptyIfNull(highlightColor);
	}
	
	public DialogItemTheme setHighlightColor(String highlightColor) {
		this.highlightColor = highlightColor;
		return this;
	}
	
	public static DialogItemTheme defaultTheme(){
        return new DialogItemTheme()
                .setHighlightColor(DefaultTheme.DialogItem.HIGHLIGHT)
                .setTextColor(DefaultTheme.DialogItem.TEXT);
        
    }
}
