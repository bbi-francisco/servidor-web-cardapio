package web_cardapio.br.com.bitbyte.models;

import web_cardapio.br.com.bitbyte.utils.StringUtils;

public class Endereco {
	
	private String endereco;
	private String cid;
	private String est;
	private String cep;
	private String bairro;
	private String complemento;
	private int numero;
	private int numEnd;
	private String pais;
	private String referencia;
	
	public String getEndereco() {
		return StringUtils.getEmptyIfNull(endereco);
	}
	public Endereco setEndereco(String endereco) {
		this.endereco = endereco;
		return this;
	}
	
	public String getCid() {
		return StringUtils.getEmptyIfNull(cid);
	}
	
	public Endereco setCid(String cid) {
		this.cid = cid;
		return this;
	}
	public String getEst() {
		return StringUtils.getEmptyIfNull(est);
	}
	public Endereco setEst(String est) {
		this.est = est;
		return this;
	}
	
	public int getNumero() {
		return numero;
	}
	public Endereco setNumero(int numero) {
		this.numero = numero;
		return this;
	}
	public int getNumEnd() {
		return numEnd;
	}
	public Endereco setNumEnd(int numEnd) {
		this.numEnd = numEnd;
		return this;
	}
	public String getPais() {
		return StringUtils.getEmptyIfNull(pais);
	}
	public Endereco setPais(String pais) {
		this.pais = pais;
		return this;
	}
	
	public String getCep() {
		return StringUtils.getEmptyIfNull(cep);
	}
	public Endereco setCep(String cep) {
		this.cep = cep;
		return this;
	}
	public String getBairro() {
		return StringUtils.getEmptyIfNull(bairro);
	}
	public Endereco setBairro(String bairro) {
		this.bairro = bairro;
		return this;
	}
	
	public String getComplemento() {
		return StringUtils.getEmptyIfNull(complemento);
	}
	
	public Endereco setComplemento(String complemento) {
		this.complemento = complemento;
		return this;
	}
	public String getReferencia() {
		return StringUtils.getEmptyIfNull(referencia);
	}
	public Endereco setReferencia(String referencia) {
		this.referencia = referencia;
		return this;
	}
	
	
}
