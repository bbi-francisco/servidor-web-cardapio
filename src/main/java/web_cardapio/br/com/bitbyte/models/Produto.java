package web_cardapio.br.com.bitbyte.models;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import web_cardapio.br.com.bitbyte.interfaces.Identificavel;
import web_cardapio.br.com.bitbyte.interfaces.Quantificavel;
import web_cardapio.br.com.bitbyte.utils.CollectionsUtils;
import web_cardapio.br.com.bitbyte.utils.StringUtils;

public class Produto implements Quantificavel, Identificavel<String>{
	private String codigo;
	private String codigoPesquisa;
	private String descricao;
	private String descritivoCardapioDigital;
	private String grupo;
	private String codigoSubgrupo;
	private BigDecimal vrUnit;
	private String descricaoDetalhes;
	private boolean permiteMesclar;
	private boolean utilizaCardapioDigital;
	private int limiteVenda;
	private int tipoProduto;
	private boolean disponivel;

	private List<Ingrediente> ingredientes;
	private List<ItemCombo> itensCombo;
	private List<Variacao> variacoes;
	private List<Promocao> promocoes;
	private List<Restricao> restricoes;
	private boolean montagem;
	private double qtd;

	private List<String> images;
	private boolean alcoolico;

	private TamanhoPizza tamanhoPizza;
	private int codigoPizza;
	private int indice;

	public boolean isAlcoolico() {
		return alcoolico;
	}

	public void setAlcoolico(boolean alcoolico) {
		this.alcoolico = alcoolico;
	}

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

	public String getGrupo() {
		return StringUtils.getEmptyIfNull(grupo);
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	public String getCodigoSubgrupo() {
		return StringUtils.getEmptyIfNull(codigoSubgrupo);
	}

	public void setCodigoSubgrupo(String codigoSubgrupo) {
		this.codigoSubgrupo = codigoSubgrupo;
	}

	public BigDecimal getVrUnit() {
		return vrUnit != null ? vrUnit : BigDecimal.valueOf(0);
	}

	public void setVrUnit(BigDecimal valorUnitario) {
		this.vrUnit = valorUnitario;
	}

	public String getDescricaoDetalhes() {
		return StringUtils.getEmptyIfNull(descricaoDetalhes);
	}

	public void setDescricaoDetalhes(String descricaoDetalhes) {
		this.descricaoDetalhes = descricaoDetalhes;
	}

	public boolean isPermiteMesclar() {
		return permiteMesclar;
	}

	public void setPermiteMesclar(boolean permiteMesclar) {
		this.permiteMesclar = permiteMesclar;
	}

	public List<Ingrediente> getIngredientes() {
		return CollectionsUtils.getEmptyIfNull(ingredientes);
	}

	public void setIngredientes(List<Ingrediente> ingredientes) {
		this.ingredientes = ingredientes;
	}

	public List<ItemCombo> getItensCombo() {
		return CollectionsUtils.getEmptyIfNull(itensCombo);
	}

	public void setItensCombo(List<ItemCombo> itensCombo) {
		this.itensCombo = itensCombo;
	}

	public List<Variacao> getVariacoes() {
		return CollectionsUtils.getEmptyIfNull(variacoes);
	}

	public void setVariacoes(List<Variacao> lstVariacoes) {
		this.variacoes = lstVariacoes;
	}

	public boolean isMontagem() {
		return montagem;
	}

	public void setMontagem(boolean montagem) {
		this.montagem = montagem;
	}

	public double getQtd() {
		return qtd;
	}

	public Produto setQtd(double qtd) {
		this.qtd = qtd;
		return this;
	}

	public List<Promocao> getPromocoes() {
		return CollectionsUtils.getEmptyIfNull(promocoes);
	}

	public void setPromocoes(List<Promocao> promocoes) {
		this.promocoes = promocoes;
	}

	public List<Restricao> getRestricoes() {
		return CollectionsUtils.getEmptyIfNull(restricoes);
	}

	public void setRestricoes(List<Restricao> restricoes) {
		this.restricoes = restricoes;
	}

	public boolean utilizaCardapioDigital() {
		return utilizaCardapioDigital;
	}

	public void setUtilizaCardapioDigital(boolean utilizaCardapioDigital) {
		this.utilizaCardapioDigital = utilizaCardapioDigital;
	}

	public int getLimiteVenda() {
		return limiteVenda;
	}

	public void setLimiteVenda(int limiteVenda) {
		this.limiteVenda = limiteVenda;
	}

	public String getCodigoPesquisa() {
		return StringUtils.getEmptyIfNull(codigoPesquisa);
	}

	public void setCodigoPesquisa(String codigoPesquisa) {
		this.codigoPesquisa = codigoPesquisa;
	}

	public int getTipoProduto() {
		return tipoProduto;
	}

	public void setTipoProduto(int tipoProduto) {
		this.tipoProduto = tipoProduto;
	}

	public boolean isDisponivel() {
		return disponivel;
	}

	public void setDisponivel(boolean disponivel) {
		this.disponivel = disponivel;
	}

	public void setTamanhoPizza(TamanhoPizza tamanhoPizza) {
		this.tamanhoPizza = tamanhoPizza;
	}

	public TamanhoPizza getTamanhoPizza() {
		return tamanhoPizza;
	}

	public List<String> getImages() {
		return CollectionsUtils.getEmptyIfNull(images);
	}

	public void setImages(List<String> images) {
		this.images = images;
	}

	public int getCodigoPizza() {
		return codigoPizza;
	}

	public void setCodigoPizza(int codigoPizza) {
		this.codigoPizza = codigoPizza;
	}

	public String getDescritivoCardapioDigital() {
		return StringUtils.getEmptyIfNull(descritivoCardapioDigital);
	}

	public void setDescritivoCardapioDigital(String descritivoCardapioDigital) {
		this.descritivoCardapioDigital = descritivoCardapioDigital;
	}

	public int getIndice() {
		return indice;
	}

	public void setIndice(int indice) {
		this.indice = indice;
	}
}
