package web_cardapio.br.com.bitbyte.models.theme;

import web_cardapio.br.com.bitbyte.utils.StringUtils;

public class BackgroundTheme {
	
	private String color;
	private String textColor;
	private BtnBackgroundTheme btnBackgroundTheme;
	
	public String getColor() {
		return StringUtils.getEmptyIfNull(color);
	}
	public BackgroundTheme setColor(String color) {
		this.color = color;
		return this;
	}
	public String getTextColor() {
		return StringUtils.getEmptyIfNull(textColor);
	}
	public BackgroundTheme setTextColor(String textColor) {
		this.textColor = textColor;
		return this;
	}
	public BtnBackgroundTheme getBtnBackgroundTheme() {
		return btnBackgroundTheme;
	}
	public BackgroundTheme setBtnBackgroundTheme(BtnBackgroundTheme btnBackgroundTheme) {
		this.btnBackgroundTheme = btnBackgroundTheme;
		return this;
	}
	
	public static BackgroundTheme defaultTheme(){
		return new BackgroundTheme()
				.setColor(DefaultTheme.Background.COLOR)
				.setTextColor(DefaultTheme.Background.TEXT)
				.setBtnBackgroundTheme(BtnBackgroundTheme.defaultTheme());
	}
}
