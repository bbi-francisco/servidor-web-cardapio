package web_cardapio.br.com.bitbyte.controllers;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import web_cardapio.br.com.bitbyte.dao.ProdutoDao;
import web_cardapio.br.com.bitbyte.models.CardapioInfo;
import web_cardapio.br.com.bitbyte.models.ProdInfo;
import web_cardapio.br.com.bitbyte.models.Retorno;
import web_cardapio.br.com.bitbyte.services.CardapioInfoService;

@RestController
@RequestMapping("/cardapio-info")
public class CardapioInfoController {
	
	@Autowired
	private CardapioInfoService cardapioService;
	
	private static final Logger log = Logger.getLogger(CardapioInfoController.class);
	
	@GetMapping("{codProd}")
	public Retorno<ProdInfo> getProdInfo(@PathVariable("codProd") String codigo)
	{
		try {
			ProdInfo prodInfo = cardapioService.getProdInfo(codigo);
			return new Retorno<ProdInfo>()
					.setValue(prodInfo)
					.setStatus(HttpStatus.OK.value());
			
		}catch(Exception e) {
			
			log.info("ERRO:" +e.toString());
			
			return new Retorno<ProdInfo>()
					.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value())
					.setMsg(e.toString());
		}
		
	}
	
	@GetMapping
	public Retorno<CardapioInfo> getCardapioStateInfo()
	{
		try {
			System.out.println("TESTE 2");
			CardapioInfo cardapioInfo = cardapioService.getCardapioInfo();
			return new Retorno<CardapioInfo>()
					.setValue(cardapioInfo)
					.setStatus(HttpStatus.OK.value());
			
		}catch(Exception e) {
			
			log.info("ERRO:" + e.toString());
			
			return new Retorno<CardapioInfo>()
					.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
		}
		
	}

}
