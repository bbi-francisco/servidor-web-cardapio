package web_cardapio.br.com.bitbyte.models.theme;

import web_cardapio.br.com.bitbyte.utils.StringUtils;

public class MenuSubgrupoTheme {
	
	private String selectedColor;
	private String color;
	
	public String getSelectedColor() {
		return StringUtils.getEmptyIfNull(selectedColor);
	}
	public MenuSubgrupoTheme setSelectedColor(String selectedColor) {
		this.selectedColor = selectedColor;
		return this;
	}
	
	public String getColor() {
		return StringUtils.getEmptyIfNull(color);
	}
	public MenuSubgrupoTheme setColor(String color) {
		this.color = color;
		return this;
	}
	
	public static MenuSubgrupoTheme defaultTheme(){
        return new MenuSubgrupoTheme()
                .setColor(DefaultTheme.MenuSubgrupo.COLOR)
                .setSelectedColor(DefaultTheme.MenuSubgrupo.SELECTED_COLOR);
    }
}
