package web_cardapio.br.com.bitbyte.models;
import web_cardapio.br.com.bitbyte.utils.StringUtils;

public class Cliente {
	
	private String codigo;
	private String nome;
	private String telefone;
	private String rg;
	private String cpf;
	private String idCanal;
	private String email;
	private Endereco endereco;
	private String dataUltimaCompra;
	private String dataNascimento;
	
	public static final Cliente CLIENTE_VAZIO = new Cliente();
	
	public String getCodigo() {
		return StringUtils.getEmptyIfNull(codigo);
	}
	public Cliente setCodigo(String codigo) {
		this.codigo = codigo;
		return this;
	}
	
	public String getNome() {
		return StringUtils.getEmptyIfNull(nome);
	}
	public Cliente setNome(String nome) {
		this.nome = nome;
		return this;
	}
	
	public String getTelefone() {
		return StringUtils.getEmptyIfNull(telefone);
	}
	public Cliente setTelefone(String telefone) {
		this.telefone = telefone;
		return this;
	}
	public String getRg() {
		return StringUtils.getEmptyIfNull(rg);
	}
	public Cliente setRg(String rg) {
		this.rg = rg;
		return this;
	}
	public String getCpf() {
		return StringUtils.getEmptyIfNull(cpf);
	}
	public Cliente setCpf(String cpf) {
		this.cpf = cpf;
		return this;
	}
	
	public String getEmail() {
		return StringUtils.getEmptyIfNull(email);
	}
	public Cliente setEmail(String email) {
		this.email = email;
		return this;
	}

	public String getIdCanal() {
		return StringUtils.getEmptyIfNull(idCanal);
	}
	public Cliente setIdCanal(String idCanal) {
		this.idCanal = idCanal;
		return this;
	}
	
	public Endereco getEndereco() {
		return endereco;
	}
	public Cliente setEndereco(Endereco endereco) {
		this.endereco = endereco;
		return this;
	}
	public String getDataUltimaCompra() {
		return StringUtils.getEmptyIfNull(dataUltimaCompra);
	}
	public Cliente setDataUltimaCompra(String dataUltimaCompra) {
		this.dataUltimaCompra = dataUltimaCompra;
		return this;
	}
	public String getDataNascimento() {
		return StringUtils.getEmptyIfNull(dataNascimento);
	}
	public Cliente setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
		return this;
	}
}