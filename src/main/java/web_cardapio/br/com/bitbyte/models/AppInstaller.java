package web_cardapio.br.com.bitbyte.models;

import java.io.File;
import java.util.List;

import web_cardapio.br.com.bitbyte.utils.StringUtils;

public class AppInstaller {
	
	private String applicationName;
	private String url;
	
	public String getApplicationName() {
		return StringUtils.getEmptyIfNull(applicationName);
	}
	public AppInstaller setApplicationName(String applicationName) {
		this.applicationName = applicationName;
		return this;
	}
	public String getInstallerBase64() {
		return StringUtils.getEmptyIfNull(url);
	}
	public AppInstaller setInstallerBase64(String installerBase64) {
		this.url = installerBase64;
		return this;
	}

}
