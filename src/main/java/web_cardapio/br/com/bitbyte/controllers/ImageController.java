package web_cardapio.br.com.bitbyte.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import web_cardapio.br.com.bitbyte.dao.ProdutoDao;
import web_cardapio.br.com.bitbyte.io.ImageManager2;
import web_cardapio.br.com.bitbyte.models.ImageBase64;
import web_cardapio.br.com.bitbyte.models.ImagesCardapio;
import web_cardapio.br.com.bitbyte.models.Retorno;
import web_cardapio.br.com.bitbyte.repositories.ImageRepository;
import web_cardapio.br.com.bitbyte.repositories.ImageRepositoryFactory;
import web_cardapio.br.com.bitbyte.utils.MyFileUtils;
import web_cardapio.br.com.bitbyte.utils.StringUtils;

import java.util.Map;
import java.util.Map.Entry;

@RestController
@RequestMapping("images")
public class ImageController {
	
	@Autowired
	private ImageRepositoryFactory imageRepositoryFactory;
	
	@Autowired
	private ProdutoDao produtoDao;
	
	private ImageRepository imageRepository;
	
	public ImageRepository getImageRepository() {
		if(imageRepository == null) {
			imageRepository = imageRepositoryFactory.createFromDiretorioImagens();
		}
		return imageRepository;
	}
	
	@GetMapping("file/{subdiretorio}/{id}")
	public byte[] getImage(@PathVariable("subdiretorio") String subdiretorio, @PathVariable("id") String imageId) {
		try {
			return getImageRepository().getImageByteArray(subdiretorio, imageId);
		} catch (Exception e) {
			return null;
		}
	}

	@GetMapping("file/{id}")
	public byte[] getImage(@PathVariable("id") String imageId) {
		try {
			return getImageRepository().getImageByteArray(imageId);
		} catch (Exception e) {
			return null;
		}
	}
	
	@GetMapping("produtos/{id}")
	public byte[] getImageProduto(@PathVariable("id") String imageId) 
	{
		try {
			return getImageRepository().getImageByteArray(imageId);
			
			
		} catch (Exception e) {
			System.out.println("ERROOOO " +e.getMessage());
			return null;
		}
	}


//	@GetMapping("produtos/{id}")
//	public ImageBase64 getImageProduto(@PathVariable("id") String imageId) {
//		try {
//			ImageRepository imageRepository = imageRepositoryFactory.createFromDiretorioImagens();
//			
//			File file = imageRepository.getImage(imageId);
//			
//			System.out.println("FILE: " +file.toString());
//			String base64 =  MyFileUtils.encodeFileToBase64(file);
//			
//			return new ImageBase64().setContent(base64);
//		} catch (Exception e) {
//			System.out.println("ERROOOO " +e.getMessage());
//			return null;
//		}
//	}

	@Produces(MediaType.APPLICATION_JSON)
	@GetMapping("cardapio")
	public Retorno<ImagesCardapio> getImagesCardapio() {
		try {
			String placeholder = getPlaceholderImg();
			

			
			
			Map<String, String> imagesProd = produtoDao.getImages();
			for(Entry<String, String> entry : imagesProd.entrySet()) 
			{
				String base64 = getImageRepository().getImageBase64(entry.getValue());
				entry.setValue(base64);
			}
			
			List<String> imagesEstabelecimento = getImages("estabelecimento");
			List<String> imagesBanners = getImages("banners");

			ImagesCardapio imagesCardapio = new ImagesCardapio()
					.setCardapioPlaceholder(placeholder)
					.setImagesEstabelecimento(imagesEstabelecimento)
					.setImagesBanners(imagesBanners);

			return new Retorno<ImagesCardapio>()
					.setValue(imagesCardapio)
					.setStatus(200)
					.setMsg("OK");

		} catch (Exception e) {
			return new Retorno<ImagesCardapio>().setStatus(500)
					.setMsg("Erro ao baixar imagens do cardapio. " + e.getMessage());
		}
	}
	
	private List<String> getImages(String folder){
		return getImageRepository()
				.getAllImages(folder)
				.stream().map((i)-> i.getName())
				.toList();
	}
	
	private String getPlaceholderImg() {
		String placeholder = getImageRepository().getImageBase64("cardapio_placeholder");
		
		if (StringUtils.isNullOrEmpty(placeholder)) {
			placeholder = getImageRepository().getImageBase64("logo");
		}
		
		return placeholder;
	}
}
