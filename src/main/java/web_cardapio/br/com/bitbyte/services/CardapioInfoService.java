package web_cardapio.br.com.bitbyte.services;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web_cardapio.br.com.bitbyte.dao.ProdutoDao;
import web_cardapio.br.com.bitbyte.models.CardapioInfo;
import web_cardapio.br.com.bitbyte.models.ProdInfo;

@Service
public class CardapioInfoService {
	
	@Autowired
	private ProdutoDao produtoDao;
	
	public ProdInfo getProdInfo(String codigo) throws SQLException {
		return produtoDao.getProdInfo(codigo);
	}

	public CardapioInfo getCardapioInfo() throws SQLException {
		
		List<ProdInfo> prods = produtoDao.getProdInfos("");
		
		return new CardapioInfo()
				.setProdInfos(prods);
	}

}
