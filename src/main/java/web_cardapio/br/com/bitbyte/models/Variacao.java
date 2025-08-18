package web_cardapio.br.com.bitbyte.models;

import web_cardapio.br.com.bitbyte.interfaces.Identificavel;
import web_cardapio.br.com.bitbyte.utils.StringUtils;

public class Variacao implements Identificavel<String>{
	
	private String codigo;
	private String descricao;
	private String codigoPai;
	
	public String getCodigo()
	{
		return StringUtils.getEmptyIfNull(codigo);
	}
	public void setCodigo(String codigo)
	{
		this.codigo = codigo;
	}
	public String getDescricao()
	{
		return StringUtils.getEmptyIfNull(descricao);
	}
	public void setDescricao(String descricao)
	{
		this.descricao = descricao;
	}
	public String getCodigoPai()
	{
		return StringUtils.getEmptyIfNull(codigoPai);
	}
	public void setCodigoPai(String codigoPai)
	{
		this.codigoPai = codigoPai;
	}
	
	public boolean equals(Variacao variacao) {
		return getCodigo().equals(variacao.getCodigo());
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(" *** ");
		sb.append(getDescricao());
		sb.append("\n");
		return sb.toString();
	}
}