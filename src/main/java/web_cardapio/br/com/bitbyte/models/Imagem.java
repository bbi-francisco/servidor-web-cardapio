package web_cardapio.br.com.bitbyte.models;

public class Imagem {
	
	private String imagem;
	private String codigo;
	
	public Imagem() {
		
	}
	
	public Imagem(String imagem, String codigo) {
		this.imagem = imagem;
		this.codigo = codigo;
	}
	
	
	
	public String getImagem() {
		return imagem;
	}
	public void setImagem(String imagem) {
		this.imagem = imagem;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	

}