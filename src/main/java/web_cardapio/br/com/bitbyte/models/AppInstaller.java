package web_cardapio.br.com.bitbyte.models;

import java.io.File;
import java.util.List;

import web_cardapio.br.com.bitbyte.utils.StringUtils;

public class AppInstaller {
	
	private String applicationName;
	private String installerBase64;
	
	public String getApplicationName() {
		return StringUtils.getEmptyIfNull(applicationName);
	}
	public AppInstaller setApplicationName(String applicationName) {
		this.applicationName = applicationName;
		return this;
	}
	public String getInstallerBase64() {
		return StringUtils.getEmptyIfNull(installerBase64);
	}
	public AppInstaller setInstallerBase64(String installerBase64) {
		this.installerBase64 = installerBase64;
		return this;
	}

}
