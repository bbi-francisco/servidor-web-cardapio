package web_cardapio.br.com.bitbyte.models;

import web_cardapio.br.com.bitbyte.utils.StringUtils;

public class Parametro
{
	private String valor;
	private String descricao;
	private String tipo;
	private String tipoSn;
	private String grupo;
	private String palavraChave;
	private String parametro;
	private String defaultValue;
	
	public String getValor()
	{
		return StringUtils.getEmptyIfNull(valor);
	}
	public Parametro setValor(String valor)
	{
		this.valor = valor;
		return this;
	}
	public String getDescricao()
	{
		return StringUtils.getEmptyIfNull(descricao);
	}
	public Parametro setDescricao(String descricao)
	{
		this.descricao = descricao;
		return this;
	}
	public String getTipo() {
		return StringUtils.getEmptyIfNull(tipo);
	}
	public Parametro setTipo(String tipo) {
		this.tipo = tipo;
		return this;
	}
	public String getTipoSn() {
		return StringUtils.getEmptyIfNull(tipoSn);
	}
	public Parametro setTipoSn(String tipoSn) {
		this.tipoSn = tipoSn;
		return this;
	}
	public String getGrupo() {
		return StringUtils.getEmptyIfNull(grupo);
	}
	public Parametro setGrupo(String grupo) {
		this.grupo = grupo;
		return this;
	}
	public String getPalavraChave() {
		return StringUtils.getEmptyIfNull(palavraChave);
	}
	public Parametro setPalavraChave(String palavraChave) {
		this.palavraChave = palavraChave;
		return this;
	}
	public String getParametro() {
		return StringUtils.getEmptyIfNull(parametro);
	}
	public Parametro setParametro(String parametro) {
		this.parametro = parametro;
		return this;
	}
	
	public String getDefaultValue() {
		return StringUtils.getEmptyIfNull(defaultValue);
	}
	public Parametro setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
		return this;
	}
}