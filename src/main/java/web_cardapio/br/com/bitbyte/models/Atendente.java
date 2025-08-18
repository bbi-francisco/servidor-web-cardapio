package web_cardapio.br.com.bitbyte.models;

import web_cardapio.br.com.bitbyte.utils.StringUtils;

public class Atendente
{
	private String codigo;
	private String senha;
	private String usuario;
	
	public String getSenha() {
		return StringUtils.getEmptyIfNull(senha);
	}
	public Atendente setSenha(String senha) {
		this.senha = senha;
		return this;
	}
	
	public String getCodigo() {
		return StringUtils.getEmptyIfNull(codigo);
	}
	public Atendente setCodigo(String codigo) {
		this.codigo = codigo;
		return this;
	}
	public String getUsuario() {
		return StringUtils.getEmptyIfNull(usuario);
	}
	public Atendente setUsuario(String usuario) {
		this.usuario = usuario;
		return this;
	}
}