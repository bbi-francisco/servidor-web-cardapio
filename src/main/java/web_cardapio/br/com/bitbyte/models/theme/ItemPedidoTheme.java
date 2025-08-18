package web_cardapio.br.com.bitbyte.models.theme;

import web_cardapio.br.com.bitbyte.utils.StringUtils;

public class ItemPedidoTheme {
	
	private String textColor;
	private String backgroundColor;
	private String subitemTitleColor;
	
	public String getTextColor() {
		return StringUtils.getEmptyIfNull(textColor);
	}
	public ItemPedidoTheme setTextColor(String textColor) {
		this.textColor = textColor;
		return this;
	}
	public String getBackgroundColor() {
		return StringUtils.getEmptyIfNull(backgroundColor);
	}
	public ItemPedidoTheme setBackgroundColor(String backgroundColor) {
		this.backgroundColor = backgroundColor;
		return this;
	}
	public String getSubitemTitleColor() {
		return StringUtils.getEmptyIfNull(subitemTitleColor);
	}
	public ItemPedidoTheme setSubitemTitleColor(String subitemTitleColor) {
		this.subitemTitleColor = subitemTitleColor;
		return this;
	}
	
	public static ItemPedidoTheme defaultTheme(){
        return new ItemPedidoTheme()
                .setBackgroundColor(DefaultTheme.ItemPedido.BACKGROUND)
                .setTextColor(DefaultTheme.ItemPedido.TEXT)
                .setSubitemTitleColor(DefaultTheme.ItemPedido.SUBITEM_TITLE);
    }
}
