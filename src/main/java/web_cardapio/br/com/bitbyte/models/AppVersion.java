package web_cardapio.br.com.bitbyte.models;

import web_cardapio.br.com.bitbyte.utils.StringUtils;

public class AppVersion {
	
	private String applicationName;
	private String version;
	
	public String getVersion() {
		return StringUtils.getEmptyIfNull(version);
	}
	public AppVersion setVersion(String version) {
		this.version = version;
		return this;
	}
	
	public String getApplicationName() {
		return StringUtils.getEmptyIfNull(applicationName);
	}
	public AppVersion setApplicationName(String applicationName) {
		this.applicationName = applicationName;
		return this;
	}
	
	
	
	

}
