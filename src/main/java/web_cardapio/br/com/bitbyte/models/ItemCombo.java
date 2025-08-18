package web_cardapio.br.com.bitbyte.models;

import java.math.BigDecimal;
import java.util.List;

import web_cardapio.br.com.bitbyte.enums.TipoValor;
import web_cardapio.br.com.bitbyte.utils.BigDecimalUtils;
import web_cardapio.br.com.bitbyte.utils.CollectionsUtils;
import web_cardapio.br.com.bitbyte.utils.StringUtils;

public class ItemCombo
{
	private String descricao;
	private String codigo;
	private String codigoPesquisa;
	private BigDecimal vrUnit;
	private int qtd;
	private String codigoPai;
	private String descricaoPai;
	private String descricaoGrupo;
	private String codigoGrupo;
	private String codigoVariacao;
	private List<Variacao> variacoes;
	private String qtdRepete;
	private int tipoValor = TipoValor.GRUPO;
	private int qtdMin;
	private int qtdMax;

	public String getCodigoPai()
	{
		return StringUtils.getEmptyIfNull(codigoPai);
	}

	public ItemCombo setCodigoPai(String codigoPai)
	{
		this.codigoPai = codigoPai;
		return this;
	}

	public String getDescricaoPai()
	{
		return StringUtils.getEmptyIfNull(descricaoPai);
	}

	public ItemCombo setDescricaoPai(String descricaoPai)
	{
		this.descricaoPai = descricaoPai;
		return this;
	}

	public String getDescricaoGrupo()
	{
		return StringUtils.getEmptyIfNull(descricaoGrupo);
	}

	public ItemCombo setDescricaoGrupo(String descricaoGrupo)
	{
		this.descricaoGrupo = descricaoGrupo;
		return this;
	}

	public String getDescricao()
	{
		return StringUtils.getEmptyIfNull(descricao);
	}

	public ItemCombo setDescricao(String descricao)
	{
		this.descricao = descricao;
		return this;
	}

	public String getCodigo()
	{
		return StringUtils.getEmptyIfNull(codigo);
	}

	public ItemCombo setCodigo(String codigo)
	{
		this.codigo = codigo;
		return this;
	}

	public String getCodigoGrupo()
	{
		return StringUtils.getEmptyIfNull(codigoGrupo);
	}

	public ItemCombo setCodigoGrupo(String codigoGrupo)
	{
		this.codigoGrupo = codigoGrupo;
		return this;
	}

	public String getCodigoVariacao()
	{
		return StringUtils.getEmptyIfNull(codigoVariacao);
	}

	public ItemCombo setCodigoVariacao(String codigoVariacao)
	{
		this.codigoVariacao = codigoVariacao;
		return this;
	}

	public List<Variacao> getVariacoes()
	{
		return CollectionsUtils.getEmptyIfNull(variacoes);
	}

	public ItemCombo setVariacoes(List<Variacao> variacoes)
	{
		this.variacoes = variacoes;
		return this;
	}

	public int getQtd()
	{
		return qtd;
	}

	public ItemCombo setQtd(int quantidade)
	{
		this.qtd = quantidade;
		return this;
	}

	public BigDecimal getVrUnit()
	{
		return BigDecimalUtils.getZeroIfNull(vrUnit);
	}

	public ItemCombo setVrUnit(BigDecimal valorUnitario)
	{
		this.vrUnit = valorUnitario;
		return this;
	}

	public String getQtdRepete()
	{
		return StringUtils.getEmptyIfNull(qtdRepete);
	}

	public ItemCombo setQtdRepete(String qtdRepete)
	{
		this.qtdRepete = qtdRepete;
		return this;
	}
	
	public int getTipoValor()
	{
		return tipoValor;
	}

	public ItemCombo setTipoValor(int tipoValor)
	{
		this.tipoValor = tipoValor;
		return this;
	}

	public int getQtdMax()
	{
		return qtdMax;
	}
	
	public ItemCombo setQtdMax(int qtdMax)
	{
		this.qtdMax = qtdMax;
		return this;
	}

	public int getQtdMin()
	{
		return qtdMin;
	}

	public ItemCombo setQtdMin(int qtdMin)
	{
		this.qtdMin = qtdMin;
		return this;
	}
	
	public String getCodigoPesquisa() {
		return StringUtils.getEmptyIfNull(codigoPesquisa);
	}
	
	public ItemCombo setCodigoPesquisa(String codigoPesquisa) {
		this.codigoPesquisa = codigoPesquisa;
		return this;
	}
}