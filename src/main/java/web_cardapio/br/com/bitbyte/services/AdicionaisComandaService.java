package web_cardapio.br.com.bitbyte.services;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web_cardapio.br.com.bitbyte.dao.ComboDao;
import web_cardapio.br.com.bitbyte.dao.IngredienteDao;
import web_cardapio.br.com.bitbyte.dao.PizzaDao;
import web_cardapio.br.com.bitbyte.dao.VariacaoDao;
import web_cardapio.br.com.bitbyte.models.AdicionaisComanda;
import web_cardapio.br.com.bitbyte.models.AdicionaisConsulta;
import web_cardapio.br.com.bitbyte.models.Comanda;
import web_cardapio.br.com.bitbyte.models.Ingrediente;
import web_cardapio.br.com.bitbyte.models.Item;
import web_cardapio.br.com.bitbyte.models.Variacao;

@Service
public class AdicionaisComandaService {
	
	@Autowired
	private VariacaoDao variacaoDao;
	
	@Autowired
	private ComboDao comboDao;
	
	@Autowired
	private IngredienteDao ingredienteDao;
	
	@Autowired
	private PizzaDao pizzaDao;
	
	public AdicionaisComanda consultar(Comanda comanda) throws SQLException 
	{
		int numeroComanda = comanda.getNumero();
		Map<Integer, List<Ingrediente>> mapIngredientes = ingredienteDao.getMapIngredientesPorComanda(numeroComanda);
		Map<Integer, List<Variacao>> mapVariacoes = variacaoDao.getMapVariacoesPorComanda(numeroComanda);
		Map<Integer, List<Item>> mapMontagem = comboDao.getItensMontagemPorComanda(numeroComanda, mapVariacoes);
		Map<Integer, List<Item>> mapSabores = pizzaDao.getSabores(mapIngredientes);
		
		AdicionaisConsulta adicionaisConsulta =  new AdicionaisConsulta()
				.setMapIngredientes(mapIngredientes)
				.setMapVariacoes(mapVariacoes)
				.setItensMontagem(mapMontagem)
				.setMapSabores(mapSabores);
		
		return new AdicionaisComanda(adicionaisConsulta);
	}

}
