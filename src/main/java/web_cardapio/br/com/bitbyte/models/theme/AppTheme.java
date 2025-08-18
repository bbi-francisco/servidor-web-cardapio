package web_cardapio.br.com.bitbyte.models.theme;

public class AppTheme {

	private AppBarTheme appBarTheme;
	private MenuOpcionaisTheme opcionaisTheme;
	private BackgroundTheme backgroundTheme;
	private DialogTheme dialogTheme;
	private ItemPedidoTheme itemPedidoTheme;
	private ConsultaTheme consultaTheme;
	private ProdutoItemTheme produtoItemTheme;
	private MenuSubgrupoTheme menuSubgrupoTheme;

	public AppBarTheme getAppBarTheme() {
		return appBarTheme;
	}

	public AppTheme setAppBarTheme(AppBarTheme appBarTheme) {
		this.appBarTheme = appBarTheme;
		return this;
	}

	public BackgroundTheme getBackgroundTheme() {
		return backgroundTheme;
	}

	public AppTheme setBackgroundTheme(BackgroundTheme backgroundTheme) {
		this.backgroundTheme = backgroundTheme;
		return this;
	}

	public DialogTheme getDialogTheme() {
		return dialogTheme;
	}

	public AppTheme setDialogTheme(DialogTheme dialogTheme) {
		this.dialogTheme = dialogTheme;
		return this;
	}

	public ItemPedidoTheme getItemPedidoTheme() {
		return itemPedidoTheme;
	}

	public AppTheme setItemPedidoTheme(ItemPedidoTheme itemPedidoTheme) {
		this.itemPedidoTheme = itemPedidoTheme;
		return this;
	}

	public ConsultaTheme getConsultaTheme() {
		return consultaTheme;
	}

	public AppTheme setConsultaTheme(ConsultaTheme consultaTheme) {
		this.consultaTheme = consultaTheme;
		return this;
	}

	public MenuOpcionaisTheme getOpcionaisTheme() {
		return opcionaisTheme;
	}

	public AppTheme setOpcionaisTheme(MenuOpcionaisTheme opcionaisTheme) {
		this.opcionaisTheme = opcionaisTheme;
		return this;
	}

	public ProdutoItemTheme getProdutoItemTheme() {
		return produtoItemTheme;
	}

	public AppTheme setProdutoItemTheme(ProdutoItemTheme produtoItemTheme) {
		this.produtoItemTheme = produtoItemTheme;
		return this;
	}

	public MenuSubgrupoTheme getMenuSubgrupoTheme() {
		return menuSubgrupoTheme;
	}

	public AppTheme setMenuSubgrupoTheme(MenuSubgrupoTheme menuSubgrupoTheme) {
		this.menuSubgrupoTheme = menuSubgrupoTheme;
		return this;
	}

	public static AppTheme defaultTheme() {
		return new AppTheme().setDialogTheme(DialogTheme.defaultTheme())
				.setOpcionaisTheme(MenuOpcionaisTheme.defaultTheme())
				.setAppBarTheme(AppBarTheme.defaultTheme())
				.setBackgroundTheme(BackgroundTheme.defaultTheme())
				.setProdutoItemTheme(ProdutoItemTheme.defaultTheme())
				.setMenuSubgrupoTheme(MenuSubgrupoTheme.defaultTheme())
				.setItemPedidoTheme(ItemPedidoTheme.defaultTheme())
				.setConsultaTheme(ConsultaTheme.defaultTheme());
	}
}
