package web_cardapio.br.com.bitbyte.models;

import web_cardapio.br.com.bitbyte.utils.StringUtils;

public class Parametro
{
	private String valor;
	private String descricao;
	private String tipo;
	
	public String getValor()
	{
		return StringUtils.getEmptyIfNull(valor);
	}
	public void setValor(String valor)
	{
		this.valor = valor;
	}
	public String getDescricao()
	{
		return StringUtils.getEmptyIfNull(descricao);
	}
	public void setDescricao(String descricao)
	{
		this.descricao = descricao;
	}
}