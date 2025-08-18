package web_cardapio.br.com.bitbyte.services.tablet;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web_cardapio.br.com.bitbyte.dao.PedidosDao;
import web_cardapio.br.com.bitbyte.dao.ProdutoDao;
import web_cardapio.br.com.bitbyte.exceptions.BBIException;
import web_cardapio.br.com.bitbyte.models.ChamarGarcom;
import web_cardapio.br.com.bitbyte.models.Comanda;
import web_cardapio.br.com.bitbyte.models.Pedido;
import web_cardapio.br.com.bitbyte.models.Produto;
import web_cardapio.br.com.bitbyte.models.bbifood.PedidoBBIFood;
import web_cardapio.br.com.bitbyte.results.PedidosResult;
import web_cardapio.br.com.bitbyte.sqlcommons.Generator;
import web_cardapio.br.com.bitbyte.models.Item;
import web_cardapio.br.com.bitbyte.models.Adicionais;

@Service
public class ChamarGarcomService {
	
	public static final String COD_PESQUISA_CHAMAR_GARCOM = "1000";
	
	@Autowired
	private PedidosDao pedidosDao;
	
	@Autowired
	private ProdutoDao produtoDao;
	
	public PedidosResult chamarGarcom(ChamarGarcom chamarGarcom) throws SQLException, BBIException 
	{
		Comanda comanda = chamarGarcom.getComanda();
		
		Item item = getItemChamarGarcom(chamarGarcom);
		
		Pedido pedido = new Pedido()
				.setComanda(comanda)
				.setItens(Collections.singletonList(item))
				.setValorTotal(BigDecimal.valueOf(0));
				
		PedidosResult pedidosResult = new PedidosResult();
		pedidosDao.insertPedido(new PedidoBBIFood(pedido), true);
		return pedidosResult.setComanda(comanda);
	}
	
	private Item getItemChamarGarcom(ChamarGarcom chamarGarcom) throws SQLException 
	{
		Produto produto = produtoDao.getProdutoByCodigoPesquisa(COD_PESQUISA_CHAMAR_GARCOM);
		if(produto == null) {
			throw new IllegalStateException("Item Chamar Garçom não encontrado! ");
		}
		
		Item item = produtoToItem(chamarGarcom, produto);
		
		return item;
	}
	
	private Item produtoToItem(ChamarGarcom chamarGarcom, Produto produto) throws SQLException {
		
		Item item = new Item()
				.setCodigo(produto.getCodigo())
				.setCodigo(produto.getCodigo())
				.setAdicionais(new Adicionais())
				.setDescricao(produto.getDescricao())
				.setQtd(1)
				.setVrUnit(produto.getVrUnit())
				.setAcessorio(true)
				.setObservacao(chamarGarcom.getObs());
		
		return item;
	}
}
