package web_cardapio.br.com.bitbyte.models.theme;

import web_cardapio.br.com.bitbyte.utils.StringUtils;

public class SearchBarTheme {
	
	private String color;
	private String textColor;
	
	public String getColor() {
		return StringUtils.getEmptyIfNull(color);
	}
	
	public SearchBarTheme setColor(String color) {
		this.color = color;
		return this;
	}
	
	public String getTextColor() {
		return StringUtils.getEmptyIfNull(textColor);
	}
	
	public SearchBarTheme setTextColor(String textColor) {
		this.textColor = textColor;
		return this;
	}
	
	public static SearchBarTheme defaultTheme(){
        return new SearchBarTheme()
                .setColor(DefaultTheme.SearchBar.COLOR)
                .setTextColor(DefaultTheme.SearchBar.TEXT);
    }
}
