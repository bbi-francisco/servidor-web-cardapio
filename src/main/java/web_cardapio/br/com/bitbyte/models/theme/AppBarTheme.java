package web_cardapio.br.com.bitbyte.models.theme;

import web_cardapio.br.com.bitbyte.utils.StringUtils;

public class AppBarTheme {
	
	private String color;
	private String textColor;
	private BtnAppBarTheme btnAppBarTheme;
	private SearchBarTheme searchBarTheme;
	
	public String getColor() {
		return StringUtils.getEmptyIfNull(color);
	}
	public AppBarTheme setColor(String color) {
		this.color = color;
		return this;
	}
	public String getTextColor() {
		return StringUtils.getEmptyIfNull(textColor);
	}
	public AppBarTheme setTextColor(String textColor) {
		this.textColor = textColor;
		return this;
	}
	
	public BtnAppBarTheme getBtnAppBarTheme() {
		return btnAppBarTheme;
	}
	
	public AppBarTheme setBtnAppBarTheme(BtnAppBarTheme btnSuperiorTheme) {
		this.btnAppBarTheme = btnSuperiorTheme;
		return this;
	}
	public SearchBarTheme getSearchBarTheme() {
		return searchBarTheme;
	}
	public AppBarTheme setSearchBarTheme(SearchBarTheme searchBarTheme) {
		this.searchBarTheme = searchBarTheme;
		return this;
	}
	
	public static AppBarTheme defaultTheme(){
		return new AppBarTheme()
				.setColor(DefaultTheme.AppBar.COLOR)
				.setTextColor(DefaultTheme.AppBar.TEXT)
				.setBtnAppBarTheme(BtnAppBarTheme.defaultTheme())
				.setSearchBarTheme(SearchBarTheme.defaultTheme());
	}
}
