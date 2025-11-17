package web_cardapio.br.com.bitbyte.repositories;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import web_cardapio.br.com.bitbyte.dao.VersaoDao;
import web_cardapio.br.com.bitbyte.estatico.Parametros;
import web_cardapio.br.com.bitbyte.models.AppInstaller;
import web_cardapio.br.com.bitbyte.models.AppVersion;
import web_cardapio.br.com.bitbyte.utils.MyFileUtils;
import web_cardapio.br.com.bitbyte.utils.StringUtils;
import org.apache.log4j.Logger;

@Repository
public class VersaoRepository {

	@Autowired
	private VersaoDao versaoDao;

	@Autowired
	private ParametrosService parametrosService;
	
	private static final Logger log = Logger.getLogger(VersaoRepository.class);
	
	public AppVersion getVersao(String applicationName, String versaoAparelho) throws SQLException, IOException {
		AppVersion version = versaoDao.getAppVersion(applicationName);
		if (version == null || StringUtils.isNullOrEmpty(version.getVersion())) {
			version = new AppVersion().setApplicationName(applicationName).setVersion(versaoAparelho);

			versaoDao.updateOrInsertVersion(version);
		}

		return version;
	}

	public AppInstaller getInstaller(String applicationName) throws IOException {
		String diretorioInstalacao = System.getProperty("user.dir");
		String path = diretorioInstalacao + "\\" + applicationName + ".apk";
		
//		String path = "C:\\bbifood\\web_cardapio\\" +applicationName + ".apk";
		
		log.info("Diretorio instalacao = " +path);
		File file = new File(path);
		if (!file.exists()) {
			throw new RuntimeException("Arquivo de instalação: " + path + " não existente. ");
		}
		
		String base64 = MyFileUtils.encodeFileToBase64(file);

		AppInstaller installer = new AppInstaller().setApplicationName(applicationName)
				.setInstallerBase64(base64);

		return installer;
	}
	
	public File getInstallerFile(String applicationName) throws IOException {
		String diretorioInstalacao = System.getProperty("user.dir");
		String path = diretorioInstalacao + "\\" + applicationName + ".apk";
		
//		String path = "C:\\bbifood\\web_cardapio\\" +applicationName + ".apk";
		
		log.info("Diretorio instalacao = " +path);
		File file = new File(path);
		if (!file.exists()) {
			throw new RuntimeException("Arquivo de instalação: " + path + " não existente. ");
		}
		
		return file;
	}

}
