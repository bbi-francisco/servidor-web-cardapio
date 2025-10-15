package web_cardapio.br.com.bitbyte.models;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import web_cardapio.br.com.bitbyte.interfaces.Identificavel;
import web_cardapio.br.com.bitbyte.interfaces.Quantificavel;
import web_cardapio.br.com.bitbyte.utils.ListUtils;
import web_cardapio.br.com.bitbyte.utils.StringUtils;

public class Produto implements Quantificavel, Identificavel<String>{
	private String codigo;
	private String codigoPesquisa;
	private String descricao;
	private String descritivoCardapioDigital;
	private String codigoGrupo;
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
	private boolean ingredienteObrigatorio;
	private boolean pergVendaSugestiva;

	public boolean isAlcoolico() {
		return alcoolico;
	}

	public Produto setAlcoolico(boolean alcoolico) {
		this.alcoolico = alcoolico;
		return this;
	}

	public String getCodigo() {
		return StringUtils.getEmptyIfNull(codigo);
	}

	public Produto setCodigo(String codigo) {
		this.codigo = codigo;
		return this;
	}

	public String getDescricao() {
		return StringUtils.getEmptyIfNull(descricao);
	}

	public Produto setDescricao(String descricao) {
		this.descricao = descricao;
		return this;
	}

	public String getCodigoGrupo() {
		return StringUtils.getEmptyIfNull(codigoGrupo);
	}

	public Produto setCodigoGrupo(String codigoGrupo) {
		this.codigoGrupo = codigoGrupo;
		return this;
	}

	public String getCodigoSubgrupo() {
		return StringUtils.getEmptyIfNull(codigoSubgrupo);
	}

	public Produto setCodigoSubgrupo(String codigoSubgrupo) {
		this.codigoSubgrupo = codigoSubgrupo;
		return this;
	}

	public BigDecimal getVrUnit() {
		return vrUnit != null ? vrUnit : BigDecimal.valueOf(0);
	}

	public Produto setVrUnit(BigDecimal valorUnitario) {
		this.vrUnit = valorUnitario;
		return this;
	}

	public String getDescricaoDetalhes() {
		return StringUtils.getEmptyIfNull(descricaoDetalhes);
	}

	public Produto setDescricaoDetalhes(String descricaoDetalhes) {
		this.descricaoDetalhes = descricaoDetalhes;
		return this;
	}

	public boolean isPermiteMesclar() {
		return permiteMesclar;
	}

	public Produto setPermiteMesclar(boolean permiteMesclar) {
		this.permiteMesclar = permiteMesclar;
		return this;
	}

	public List<Ingrediente> getIngredientes() {
		return ListUtils.getEmptyIfNull(ingredientes);
	}

	public Produto setIngredientes(List<Ingrediente> ingredientes) {
		this.ingredientes = ingredientes;
		return this;
	}

	public List<ItemCombo> getItensCombo() {
		return ListUtils.getEmptyIfNull(itensCombo);
	}

	public Produto setItensCombo(List<ItemCombo> itensCombo) {
		this.itensCombo = itensCombo;
		return this;
	}

	public List<Variacao> getVariacoes() {
		return ListUtils.getEmptyIfNull(variacoes);
	}

	public Produto setVariacoes(List<Variacao> lstVariacoes) {
		this.variacoes = lstVariacoes;
		return this;
	}

	public boolean isMontagem() {
		return montagem;
	}

	public Produto setMontagem(boolean montagem) {
		this.montagem = montagem;
		return this;
	}

	public double getQtd() {
		return qtd;
	}

	public Produto setQtd(double qtd) {
		this.qtd = qtd;
		return this;
	}

	public List<Promocao> getPromocoes() {
		return ListUtils.getEmptyIfNull(promocoes);
	}

	public Produto setPromocoes(List<Promocao> promocoes) {
		this.promocoes = promocoes;
		return this;
	}

	public List<Restricao> getRestricoes() {
		return ListUtils.getEmptyIfNull(restricoes);
	}

	public Produto setRestricoes(List<Restricao> restricoes) {
		this.restricoes = restricoes;
		return this;
	}

	public boolean utilizaCardapioDigital() {
		return utilizaCardapioDigital;
	}

	public Produto setUtilizaCardapioDigital(boolean utilizaCardapioDigital) {
		this.utilizaCardapioDigital = utilizaCardapioDigital;
		return this;
	}

	public int getLimiteVenda() {
		return limiteVenda;
	}

	public Produto setLimiteVenda(int limiteVenda) {
		this.limiteVenda = limiteVenda;
		return this;
	}

	public String getCodigoPesquisa() {
		return StringUtils.getEmptyIfNull(codigoPesquisa);
	}

	public Produto setCodigoPesquisa(String codigoPesquisa) {
		this.codigoPesquisa = codigoPesquisa;
		return this;
	}

	public int getTipoProduto() {
		return tipoProduto;
	}

	public Produto setTipoProduto(int tipoProduto) {
		this.tipoProduto = tipoProduto;
		return this;
	}

	public boolean isDisponivel() {
		return disponivel;
	}

	public Produto setDisponivel(boolean disponivel) {
		this.disponivel = disponivel;
		return this;
	}

	public Produto setTamanhoPizza(TamanhoPizza tamanhoPizza) {
		this.tamanhoPizza = tamanhoPizza;
		return this;
	}

	public TamanhoPizza getTamanhoPizza() {
		return tamanhoPizza;
	}

	public List<String> getImages() {
		return ListUtils.getEmptyIfNull(images);
	}

	public Produto setImages(List<String> images) {
		this.images = images;
		return this;
	}

	public int getCodigoPizza() {
		return codigoPizza;
	}

	public Produto setCodigoPizza(int codigoPizza) {
		this.codigoPizza = codigoPizza;
		return this;
	}

	public String getDescritivoCardapioDigital() {
		return StringUtils.getEmptyIfNull(descritivoCardapioDigital);
	}

	public Produto setDescritivoCardapioDigital(String descritivoCardapioDigital) {
		this.descritivoCardapioDigital = descritivoCardapioDigital;
		return this;
	}

	public int getIndice() {
		return indice;
	}

	public Produto setIndice(int indice) {
		this.indice = indice;
		return this;
	}

	public boolean isIngredienteObrigatorio() {
		return ingredienteObrigatorio;
	}

	public Produto setIngredienteObrigatorio(boolean ingredienteObrigatorio) {
		this.ingredienteObrigatorio = ingredienteObrigatorio;
		return this;
	}

	public boolean isPergVendaSugestiva() {
		return pergVendaSugestiva;
	}

	public Produto setPergVendaSugestiva(boolean pergVendaSugestiva) {
		this.pergVendaSugestiva = pergVendaSugestiva;
		return this;
	}
}
