package web_cardapio.br.com.bitbyte.models.bbifood;

import web_cardapio.br.com.bitbyte.datastructures.Email;
import web_cardapio.br.com.bitbyte.datastructures.Phone;
import web_cardapio.br.com.bitbyte.format.CpfCnpjFormatter;
import web_cardapio.br.com.bitbyte.models.Cliente;
import web_cardapio.br.com.bitbyte.utils.StringFormatterBuilder;
import web_cardapio.br.com.bitbyte.utils.StringUtils;

public class ClienteBBIFood {

	private final Cliente cliente;
	private final StringFormatterBuilder formatter;

	public ClienteBBIFood(Cliente cliente) {
		this.cliente = cliente;
		formatter = new StringFormatterBuilder();
	}

	public String getCodigo() {
		try {
			return formatter.removerCaracteresEspeciais().defineCharLength(5).removerLetras()
					.build(cliente.getCodigo());

		} catch (NumberFormatException e1) {
			try {
				String codigo = formatter.removerCaracteresEspeciais().removerLetras().build(cliente.getCodigo());

				return String.valueOf(Integer.parseInt(codigo));
			} catch (Exception e2) {
				return "0";
			}
		}
	}

	public String getNome() {
		return formatter.removerAcentos().limitarCaracteres(120).toUpperCase().trim().build(cliente.getNome());
	}

	public String getTelefone() {
		String number = StringUtils.getEmptyIfNull(cliente.getTelefone()).trim();
		try {
			number = cliente.getTelefone();
			Phone phoneObj = new Phone(number);
			number = phoneObj.getFormatted();
		} catch (Exception e) {
		}
		return formatter.limitarCaracteres(15).build(number);
	}

	public String getRg() {
		return formatter.limitarCaracteres(20).removerAcentos().toUpperCase().build(cliente.getRg());
	}

	public String getCpf() {
		String cgc = StringUtils.getEmptyIfNull(cliente.getCpf()).trim();
		try {
			cgc = new CpfCnpjFormatter().format(cgc);
		} catch (Exception e) {
		}
		return formatter.limitarCaracteres(18).build(cgc);
	}

	public String getEmail() {
		String email = StringUtils.getEmptyIfNull(cliente.getEmail()).trim();
		try {
			Email emailObj = new Email(email);
			email = emailObj.toString();
		} catch (IllegalArgumentException e) {
		}
		return formatter.limitarCaracteres(80).toUpperCase().build(email);
	}

	public String getIdCanal() {
		String idCanal = cliente.getIdCanal();
		return formatter.removerAcentos().limitarCaracteres(20).build(idCanal);
	}

	public EnderecoBBIFood getEndereco() {
		return new EnderecoBBIFood(cliente.getEndereco());
	}

	public String getDataUltimaCompra() {
		return cliente.getDataUltimaCompra();
	}

}