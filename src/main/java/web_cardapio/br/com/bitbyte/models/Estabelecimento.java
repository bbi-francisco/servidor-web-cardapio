package web_cardapio.br.com.bitbyte.models;

import java.util.Collections;
import java.util.List;

import web_cardapio.br.com.bitbyte.utils.StringUtils;

public class Estabelecimento {
	private String historia;
	private String urlVideo;
	private String cnpj;
	private String tituloLogo;

	public String getHistoria() {
		return StringUtils.getEmptyIfNull(historia);	
	}

	public void setHistoria(String historia) {
		this.historia = historia;
	}

	public String getUrlVideo() {
		return StringUtils.getEmptyIfNull(urlVideo);
	}

	public void setUrlVideo(String urlVideo) {
		this.urlVideo = urlVideo;
	}

	public String getCnpj() {
		return StringUtils.getEmptyIfNull(cnpj);
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getTituloLogo() {
		return StringUtils.getEmptyIfNull(tituloLogo);
	}

	public void setTituloLogo(String tituloLogo) {
		this.tituloLogo = tituloLogo;
	}

}
