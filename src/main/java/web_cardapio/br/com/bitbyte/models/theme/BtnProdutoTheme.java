package web_cardapio.br.com.bitbyte.models.theme;

import web_cardapio.br.com.bitbyte.utils.StringUtils;

public class BtnProdutoTheme {
	
	private String color;
	private String textColor;
	
	public String getColor() {
		return StringUtils.getEmptyIfNull(color);
	}
	
	public BtnProdutoTheme setColor(String color) {
		this.color = color;
		return this;
	}
	
	public String getTextColor() {
		return StringUtils.getEmptyIfNull(textColor);
	}
	
	public BtnProdutoTheme setTextColor(String textColor) {
		this.textColor = textColor;
		return this;
	}
	
	public static BtnProdutoTheme defaultTheme(){
        return new BtnProdutoTheme()
                .setColor(DefaultTheme.BtnProdutoTheme.COLOR)
                .setTextColor(DefaultTheme.BtnProdutoTheme.TEXT);
    }
}
