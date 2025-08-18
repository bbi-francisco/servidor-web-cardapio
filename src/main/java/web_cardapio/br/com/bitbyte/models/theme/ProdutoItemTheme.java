package web_cardapio.br.com.bitbyte.models.theme;

import web_cardapio.br.com.bitbyte.utils.StringUtils;

public class ProdutoItemTheme {
	
	private BtnProdutoTheme btnProdutoTheme;
	private String color;
	private String textColor;
	
	public BtnProdutoTheme getBtnProdutoTheme() {
		return btnProdutoTheme;
	}
	public ProdutoItemTheme setBtnProdutoTheme(BtnProdutoTheme btnProdutoTheme) {
		this.btnProdutoTheme = btnProdutoTheme;
		return this;
	}
	
	public String getColor() {
		return StringUtils.getEmptyIfNull(color);
	}
	
	public ProdutoItemTheme setColor(String color) {
		this.color = color;
		return this;
	}
	
	public String getTextColor() {
		return StringUtils.getEmptyIfNull(textColor);
	}
	
	public ProdutoItemTheme setTextColor(String textColor) {
		this.textColor = textColor;
		return this;
	}
	
	public static ProdutoItemTheme defaultTheme(){
        return new ProdutoItemTheme()
                .setBtnProdutoTheme(BtnProdutoTheme.defaultTheme())
                .setColor(DefaultTheme.ProdutoTheme.COLOR)
                .setTextColor(DefaultTheme.ProdutoTheme.TEXT);
    }
}
