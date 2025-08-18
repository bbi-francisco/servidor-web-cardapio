package web_cardapio.br.com.bitbyte.models;

import web_cardapio.br.com.bitbyte.enums.FormaAtendimento;
import web_cardapio.br.com.bitbyte.utils.StringUtils;

public class Comanda
{
	private int numero;
	private Cliente cliente;
	private boolean maioridade;
	private Atendente atendente;
	private int idTablet;
	private int mesa;
	private String tag;
	private QrCodeAuth qrCodeAuth;
	private int quantidadePessoas;
	private FormaAtendimento formaAtendimento;
	private ValoresComanda valoresComanda;
	private ComandaInvalida comandaInvalida;
	private String idTag;

	public int getNumero() {
		return numero;
	}

	public Comanda setNumero(int numero) {
		this.numero = numero;
		return this;
	}

	public boolean isMaioridade() {
		return maioridade;
	}

	public Comanda setMaioridade(boolean maioridade) {
		this.maioridade = maioridade;
		return this;
	}

	public int getIdTablet()
	{ 
		return idTablet;
	}

	public Comanda setIdTablet(int idTablet)
	{
		this.idTablet = idTablet;
		return this;
	}

	public int getMesa()
	{
		return mesa;
	}

	public Comanda setMesa(int mesa)
	{
		this.mesa = mesa;
		return this;
	}
	
	public String getTag() {
		return StringUtils.getEmptyIfNull(tag);
	}

	public Comanda setTag(String tag) {
		this.tag = tag;
		return this;
	}

	public Cliente getCliente() {
		return cliente != null ? cliente : Cliente.CLIENTE_VAZIO;
	}

	public Comanda setCliente(Cliente cliente) {
		this.cliente = cliente;
		return this;
	}

	public QrCodeAuth getQrCodeAuth() {
		return qrCodeAuth;
	}

	public Comanda setQrCodeAuth(QrCodeAuth qrCodeAuth) {
		this.qrCodeAuth = qrCodeAuth;
		return this;
	}

	public int getQuantidadePessoas() {
		return quantidadePessoas != 0 ? quantidadePessoas : 1;
	}

	public Comanda setQuantidadePessoas(int quantidadePessoas) {
		this.quantidadePessoas = quantidadePessoas;
		return this;
	}

	public FormaAtendimento getFormaAtendimento() {
		return formaAtendimento != null ? formaAtendimento : FormaAtendimento.NAO_SELECIONADO;
	}

	public Comanda setFormaAtendimento(FormaAtendimento formaAtendimento) {
		this.formaAtendimento = formaAtendimento;
		return this;
	}

	public ValoresComanda getValoresComanda() {
		return valoresComanda;
	}

	public Comanda setValoresComanda(ValoresComanda limiteComanda) {
		this.valoresComanda = limiteComanda;
		return this;
	}

	public ComandaInvalida getComandaInvalida() {
		return comandaInvalida;
	}

	public Comanda setComandaInvalida(ComandaInvalida comandaInvalida) {
		this.comandaInvalida = comandaInvalida;
		return this;
	}

	public Atendente getAtendente() {
		return atendente;
	}

	public Comanda setAtendente(Atendente atendente) {
		this.atendente = atendente;
		return this;
	}

	public String getIdTag() {
		return StringUtils.getEmptyIfNull(idTag);
	}

	public Comanda setIdTag(String idTag) {
		this.idTag = idTag;
		return this;
	}
}