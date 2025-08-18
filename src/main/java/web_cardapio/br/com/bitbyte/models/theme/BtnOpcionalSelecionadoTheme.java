package web_cardapio.br.com.bitbyte.models.theme;

import web_cardapio.br.com.bitbyte.utils.StringUtils;

public class BtnOpcionalSelecionadoTheme 
{
	private String color;
	private String textColor;
	
	public String getColor() {
		return StringUtils.getEmptyIfNull(color);
	}
	
	public BtnOpcionalSelecionadoTheme setColor(String color) {
		this.color = color;
		return this;
	}
	
	public String getTextColor() {
		return StringUtils.getEmptyIfNull(textColor);
	}
	
	public BtnOpcionalSelecionadoTheme setTextColor(String textColor) {
		this.textColor = textColor;
		return this;
	}
	
	public static BtnOpcionalSelecionadoTheme defaultTheme(){
		return new BtnOpcionalSelecionadoTheme()
				.setColor(DefaultTheme.BtnOpcionalSelecionado.COLOR)
				.setTextColor(DefaultTheme.BtnOpcionalSelecionado.TEXT);
	}
}
