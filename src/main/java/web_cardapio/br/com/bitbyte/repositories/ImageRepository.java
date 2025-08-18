package web_cardapio.br.com.bitbyte.repositories;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import web_cardapio.br.com.bitbyte.io.ImageManager2;
import web_cardapio.br.com.bitbyte.utils.ImprovedStringBuilder;

@Component
public class ImageRepository 
{
	public String diretorioImagens;
	private ImageManager2 imageManager;
	private Map<String, File> mapImages;
	
	public ImageRepository() {
		imageManager = new ImageManager2();
		mapImages = new HashMap<>();
	}
	
	public ImageRepository setDiretorioImages(String diretorioImagens) {
		this.diretorioImagens = diretorioImagens;
		return this;
	}
	
	
	public File getImage(String diretorio, String id) {
		String path = new ImprovedStringBuilder()
		.append(diretorioImagens)
		.append("\\")
		.append(diretorio)
		.append("\\")
		.append(id)
		.build();
		
		File cachedImg = mapImages.get(path);
		if(cachedImg == null) {
			cachedImg = imageManager.getImageFromPath(path);
			mapImages.put(path, cachedImg);
		}
		return cachedImg;
	}
	
	public List<File> getAllImages(String diretorio) {
		String path = new ImprovedStringBuilder()
				.append(diretorioImagens)
				.append("\\")
				.append(diretorio)
				.build();
		
		return imageManager.getAllImages(path);
	}
	
	public File getImage(String id) 
	{
		String path = new ImprovedStringBuilder()
				.append(diretorioImagens)
				.append("\\")
				.append(id)
				.build();
		
		return imageManager.getImageFromPath(path);
	}
	
	public String getImageBase64(String id) 
	{
		try {
			File file = getImage(id);
			return imageManager.getImageBase64(file.getPath());
		}catch(Exception e) {
			return "";
		}
		
	}
	
	public byte[] getImageByteArray(String id) throws IOException {
		File file = getImage(id);
		return imageManager.fileToByteArray(file);
	}
	
	public byte[] getImageByteArray(String diretorio, String id) throws IOException {
		File file = getImage(diretorio, id);
		return imageManager.fileToByteArray(file);
	}
}
