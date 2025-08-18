package web_cardapio.br.com.bitbyte.models;

import java.util.Collections;
import java.util.List;

public class SubGrupo 
{
	private String codigo;
	private String descricao;
	private int indice;
	private String img;
	private String tipoExibicao;
	private String grupo;
	private List<Restricao> restricoes;
	private boolean utilizaCardapioDigital;
	
	public String getGrupo()
	{
		return grupo != null ? grupo : "";
	}
	public void setGrupo(String grupo)
	{
		this.grupo = grupo;
	}
	public String getCodigo() {
		return codigo != null ? codigo : "";
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getDescricao() {
		return descricao != null ? descricao : "";
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public int getIndice() {
		return indice;
	}
	public void setIndice(int indice) {
		this.indice = indice;
	}
	public String getImg() {
		return img != null ? img : "";
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getTipoExibicao() {
		return tipoExibicao != null ? tipoExibicao : "";
	}
	public void setTipoExibicao(String tipoExibicao) {
		this.tipoExibicao = tipoExibicao;
	}	
	
	public List<Restricao> getRestricoes()
	{
		return restricoes != null ? restricoes : Collections.emptyList();
	}
	public void setRestricoes(List<Restricao> restricoes)
	{
		this.restricoes = restricoes;
	}
	public boolean utilizaCardapioDigital() {
		return utilizaCardapioDigital;
	}
	public void setUtilizaCardapioDigital(boolean utilizaCardapioDigital) {
		this.utilizaCardapioDigital = utilizaCardapioDigital;
	}
	@Override
	public String toString() {
		return "SubGrupo [codigo=" + codigo + ", descricao=" + descricao + ", indice=" + indice + ", img=" + img
				+ ", tipoExibicao=" + tipoExibicao + ", grupo=" + grupo + ", restricoes=" + restricoes
				+ ", utilizaCardapioDigital=" + utilizaCardapioDigital + "]";
	}
	
	
}