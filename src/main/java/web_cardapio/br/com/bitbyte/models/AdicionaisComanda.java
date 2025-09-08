package web_cardapio.br.com.bitbyte.models;

import java.util.List;

import web_cardapio.br.com.bitbyte.utils.ListUtils;

public class AdicionaisComanda {
	
	private AdicionaisConsulta adicionaisConsulta;
	
	public AdicionaisComanda(AdicionaisConsulta adicionaisConsulta) {
		this.adicionaisConsulta = adicionaisConsulta;
	}
	
	public List<Item> getItensMontagem(int seqItem)
	{
		List<Item> itensMontagem = adicionaisConsulta.getItensMontagem().get(seqItem);
		return ListUtils.getEmptyIfNull(itensMontagem);
	}
	
	public List<Item> getSabores(int idPizza){
		List<Item> sabores = adicionaisConsulta.getMapSabores().get(idPizza);
		return ListUtils.getEmptyIfNull(sabores);
	}
	
	public List<Variacao> getVariacoes(int seqItem){
		List<Variacao> variacoes = adicionaisConsulta.getMapVariacoes().get(seqItem);
		return ListUtils.getEmptyIfNull(variacoes);
	}
	
	public List<Ingrediente> getIngredientes(int idIngre){
		List<Ingrediente> ingredientes = adicionaisConsulta.getMapIngredientes().get(idIngre);
		return ListUtils.getEmptyIfNull(ingredientes);
	}

}
