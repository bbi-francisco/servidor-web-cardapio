package web_cardapio.br.com.bitbyte.models;

import java.math.BigDecimal;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import web_cardapio.br.com.bitbyte.format.MoneyFormatter;
import web_cardapio.br.com.bitbyte.utils.StringUtils;

@JsonIgnoreProperties({"acrescentar", "retirar"})
public class Ingrediente
{
	private String codigo;
	private String descricao;
	private String codigoPai;
	private BigDecimal vrUnit;
	private String tipo;
	private int qtd;
	
	public String getCodigo() {
		return StringUtils.getEmptyIfNull(codigo);
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getDescricao() {
		return StringUtils.getEmptyIfNull(descricao);
	}
	public void setDescricao(String descricao) {
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
	public BigDecimal getVrUnit()
	{
		return vrUnit != null ? vrUnit : BigDecimal.valueOf(0);
	}
	public void setVrUnit(BigDecimal valorUnitario)
	{
		this.vrUnit = valorUnitario;
	}
	public String getTipo()
	{
		return StringUtils.getEmptyIfNull(tipo);
	}
	public void setTipo(String tipo)
	{
		this.tipo = tipo;
	}
	public int getQtd()
	{
		return qtd;
	}
	public void setQtd(int quantidade)
	{
		this.qtd = quantidade;
	}	
	
	public boolean isAcrescentar() {
		return getTipo().equals("A");
	}
	public boolean isRetirar() {
		return getTipo().equals("D");
	}
	
	public boolean equals(Ingrediente ingrediente) {
		return getCodigo().equals(ingrediente.getCodigo());
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		if(isRetirar()) {
			sb.append("(-)");
		}
		else if(isAcrescentar()) {
			sb.append("(+)");
		}
		sb.append(getQtd());
		sb.append("\t");
		sb.append(getDescricao());
		sb.append("\t");
		sb.append(new MoneyFormatter().format(getVrUnit()));
		sb.append("\n");
		return sb.toString();
	}
}