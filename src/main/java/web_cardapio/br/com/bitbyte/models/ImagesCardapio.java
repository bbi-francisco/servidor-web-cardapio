package web_cardapio.br.com.bitbyte.models;

import java.util.List;

import web_cardapio.br.com.bitbyte.utils.ListUtils;
import web_cardapio.br.com.bitbyte.utils.StringUtils;
import java.util.Map;
import java.util.HashMap;

public class ImagesCardapio {
	
	private String cardapioPlaceholder;
	private List<String> imagesEstabelecimento;
	
	
	public String getCardapioPlaceholder() {
		return StringUtils.getEmptyIfNull(cardapioPlaceholder);
	}
	
	public ImagesCardapio setCardapioPlaceholder(String cardapioPlaceholder) {
		this.cardapioPlaceholder = cardapioPlaceholder;
		return this;
	}
	
	public List<String> getImagesEstabelecimento() {
		return ListUtils.getEmptyIfNull(imagesEstabelecimento);
	}
	
	public ImagesCardapio setImagesEstabelecimento(List<String> imagesEstabelecimento) {
		this.imagesEstabelecimento = imagesEstabelecimento;
		return this;
	}
}
