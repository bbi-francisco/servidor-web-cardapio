package web_cardapio.br.com.bitbyte.models;

public class QrCodeAuth {
	
	private String cnpj;
	private String uuidComanda;
	
	public String getCnpj() {
		return cnpj != null ? cnpj : "";
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	public String getUuidComanda() {
		return uuidComanda != null ? uuidComanda : "";
	}
	public void setUuidComanda(String uuidComanda) {
		this.uuidComanda = uuidComanda;
	}
	
	
	
	

}
