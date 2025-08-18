package web_cardapio.br.com.bitbyte.models.theme;

import web_cardapio.br.com.bitbyte.utils.StringUtils;

public class DialogTheme {
	
	private String color;
	private String textColor;
	private DialogItemTheme dialogItemTheme;
	private BtnDialogTheme btnDialogTheme;
	private DialogHeaderTheme dialogHeaderTheme;
	
	public String getColor() {
		return StringUtils.getEmptyIfNull(color);
	}
	
	public DialogTheme setColor(String color) {
		this.color = color;
		return this;
	}
	
	public String getTextColor() {
		return StringUtils.getEmptyIfNull(textColor);
	}
	
	public DialogTheme setTextColor(String textColor) {
		this.textColor = textColor;
		return this;
	}

	public DialogItemTheme getDialogItemTheme() {
		return dialogItemTheme;
	}

	public DialogTheme setDialogItemTheme(DialogItemTheme dialogItemTheme) {
		this.dialogItemTheme = dialogItemTheme;
		return this;
	}
	
	public static DialogTheme defaultTheme(){
		return new DialogTheme()
				.setBtnDialogTheme(BtnDialogTheme.defaultTheme())
				.setDialogHeaderTheme(DialogHeaderTheme.defaultTheme())
				.setDialogItemTheme(DialogItemTheme.defaultTheme())
				.setColor(DefaultTheme.Dialog.COLOR)
				.setTextColor(DefaultTheme.Dialog.TEXT);
	}

	public BtnDialogTheme getBtnDialogTheme() {
		return btnDialogTheme;
	}

	public DialogTheme setBtnDialogTheme(BtnDialogTheme btnDialogTheme) {
		this.btnDialogTheme = btnDialogTheme;
		return this;
	}

	public DialogHeaderTheme getDialogHeaderTheme() {
		return dialogHeaderTheme;
	}

	public DialogTheme setDialogHeaderTheme(DialogHeaderTheme dialogHeaderTheme) {
		this.dialogHeaderTheme = dialogHeaderTheme;
		return this;
	}
}
