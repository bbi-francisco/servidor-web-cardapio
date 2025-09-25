package web_cardapio.br.com.bitbyte.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import web_cardapio.br.com.bitbyte.utils.StringUtils;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Dispositivo {
	
	private long id;
	private String serial;
	private boolean liberado;
	private String tipo;

	public String getSerial() {
		return StringUtils.getEmptyIfNull(serial);
	}

	public Dispositivo setSerial(String serial) {
		this.serial = serial;
		return this;
	}

	public long getId() {
		return id;
	}

	public Dispositivo setId(long id) {
		this.id = id;
		return this;
	}

	public boolean isLiberado() {
		return liberado;
	}

	public Dispositivo setLiberado(boolean liberado) {
		this.liberado = liberado;
		return this;
	}

	public String getTipo() {
		return StringUtils.getEmptyIfNull(tipo);
	}

	public Dispositivo setTipo(String tipo) {
		this.tipo = tipo;
		return this;
	}
}
