package web_cardapio.br.com.bitbyte.models.theme;


public class MenuOpcionaisTheme {
	
	private BtnOpcionalSelecionadoTheme btnOpcionalSelecionadoTheme;
	private BtnOpcionalTheme btnOpcionalTheme;
	
	public BtnOpcionalSelecionadoTheme getBtnOpcionalSelecionadoTheme() {
		return btnOpcionalSelecionadoTheme;
	}
	
	public MenuOpcionaisTheme setBtnOpcionalSelecionadoTheme(BtnOpcionalSelecionadoTheme btnOpcionalSelecionadoTheme) {
		this.btnOpcionalSelecionadoTheme = btnOpcionalSelecionadoTheme;
		return this;
	}
	
	public BtnOpcionalTheme getBtnOpcionalTheme() {
		return btnOpcionalTheme;
	}
	
	public MenuOpcionaisTheme setBtnOpcionalTheme(BtnOpcionalTheme btnOpcionalTheme) {
		this.btnOpcionalTheme = btnOpcionalTheme;
		return this;
	}
	
	 public static MenuOpcionaisTheme defaultTheme(){
	        return new MenuOpcionaisTheme()
	                .setBtnOpcionalSelecionadoTheme(BtnOpcionalSelecionadoTheme.defaultTheme())
	                .setBtnOpcionalTheme(BtnOpcionalTheme.defaultTheme());
	    }
}
