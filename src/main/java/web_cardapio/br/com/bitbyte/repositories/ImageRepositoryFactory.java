package web_cardapio.br.com.bitbyte.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import web_cardapio.br.com.bitbyte.estatico.Parametros;

@Component
public class ImageRepositoryFactory {
	
	@Autowired
	private ParametrosService parametrosService;
	
	@Autowired
	private ImageRepository imageRepository;
	
	public ImageRepository createFromDiretorioImagens() {
		String diretorioImagens = parametrosService
				.getString(Parametros.DIRETORIO_IMAGENS);
		
		return imageRepository.setDiretorioImages(diretorioImagens);
	}

}
