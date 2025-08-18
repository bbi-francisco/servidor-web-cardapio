package web_cardapio.br.com.bitbyte.models.theme;

import web_cardapio.br.com.bitbyte.utils.StringUtils;

public class BtnAppBarTheme {
	
	private String color;
	private String textColor;
	private String destaqueColor;
	
	public String getColor() {
		return StringUtils.getEmptyIfNull(color);
	}
	public BtnAppBarTheme setColor(String color) {
		this.color = color;
		return this;
	}
	public String getTextColor() {
		return StringUtils.getEmptyIfNull(textColor);
	}
	public BtnAppBarTheme setTextColor(String textColor) {
		this.textColor = textColor;
		return this;
	}
	
	public String getDestaqueColor() {
		return StringUtils.getEmptyIfNull(destaqueColor);
	}
	public BtnAppBarTheme setDestaqueColor(String destaqueColor) {
		this.destaqueColor = destaqueColor;
		return this;
	}
	
	public static BtnAppBarTheme defaultTheme(){
		return new BtnAppBarTheme()
				.setColor(DefaultTheme.BtnAppBar.COLOR)
				.setTextColor(DefaultTheme.BtnAppBar.TEXT)
				.setDestaqueColor(DefaultTheme.BtnAppBar.DESTAQUE_COLOR);
	}
}
