package web_cardapio.br.com.bitbyte.models;

import java.math.BigDecimal;
import java.util.List;

import web_cardapio.br.com.bitbyte.interfaces.Quantificavel;
import web_cardapio.br.com.bitbyte.utils.BigDecimalUtils;
import web_cardapio.br.com.bitbyte.utils.ListUtils;
import web_cardapio.br.com.bitbyte.utils.StringUtils;

public class Item implements Quantificavel
{
	transient private int idIngre;
	transient private int seqItem;
	transient private int idPizza;
	
	private String id;
	private String descricao;
	private String codigo;
	private BigDecimal vrUnit;
	private double qtd;
	private String codigoPesquisa;
	private String origem;
	private Adicionais adicionais;
	private List<Item> sabores;
	private String observacao;
	private boolean acessorio;
	
	public Item() {
		adicionais = new Adicionais();
	}
	
	public String getId() {
		return StringUtils.getEmptyIfNull(id);
	}
	
	public Item setId(String id) {
		this.id = id;
		return this;
	}
	
	public String getOrigem() {
		return StringUtils.getEmptyIfNull(origem);
	}
	
	public Item setOrigem(String origem) {
		this.origem = origem;
		return this;
	}

	public String getDescricao() {
		return StringUtils.getEmptyIfNull(descricao);
	}

	public Item setDescricao(String descricao) {
		this.descricao = descricao;
		return this;
	}

	public BigDecimal getVrUnit() {
		return BigDecimalUtils.getZeroIfNull(vrUnit);
	}

	public Item setVrUnit(BigDecimal valorUnitario) {
		this.vrUnit = valorUnitario;
		return this;
	}

	public double getQtd() {
		return qtd;
	}

	public Item setQtd(double quantidade) {
		this.qtd = quantidade;
		return this;
	}

	public String getCodigo() {
		return StringUtils.getEmptyIfNull(codigo);
	}

	public Item setCodigo(String codigo) {
		this.codigo = codigo;
		return this;
	}

	
	public String getCodigoPesquisa() 
	{
		return StringUtils.getEmptyIfNull(codigoPesquisa);
	}
	
	public Item setCodigoPesquisa(String codigoPesquisa) {
		this.codigoPesquisa = codigoPesquisa;
		return this;
	}

	public int getIdIngre()
	{
		return idIngre;
	}

	public Item setIdIngre(int idIngre)
	{
		this.idIngre = idIngre;
		return this;
	}

	public int getSeqItem()
	{
		return seqItem;
	}

	public Item setSeqItem(int idProd)
	{
		this.seqItem = idProd;
		return this;
	}

	public int getIdPizza() {
		return idPizza;
	}

	public Item setIdPizza(int idPizza) {
		this.idPizza = idPizza;
		return this;
	}

	public String getObservacao() {
		return StringUtils.getEmptyIfNull(observacao);
	}

	public Item setObservacao(String observacao) {
		this.observacao = observacao;
		return this;
	}

	public List<Item> getSabores() {
		return ListUtils.getEmptyIfNull(sabores);
	}

	public Item setSabores(List<Item> sabores) 
	{
		this.sabores = sabores;
		return this;
	}

	public Adicionais getAdicionais() {
		return adicionais;
	}

	public Item setAdicionais(Adicionais adicionais) {
		this.adicionais = adicionais;
		return this;
	}

	public boolean isAcessorio() {
		return acessorio;
	}

	public Item setAcessorio(boolean acessorio) {
		this.acessorio = acessorio;
		return this;
	}
	
}