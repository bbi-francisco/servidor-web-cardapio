package web_cardapio.br.com.bitbyte.models;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdicionaisConsulta {
	
	private Map<Integer, List<Ingrediente>> mapIngredientes;
	private Map<Integer, List<Variacao>> mapVariacoes;
	private Map<Integer, List<Item>> itensMontagem;
	private Map<Integer, List<Item>> mapSabores;
	
	public Map<Integer, List<Ingrediente>> getMapIngredientes() {
		return mapIngredientes != null ? mapIngredientes : new HashMap<>();
	}
	public AdicionaisConsulta setMapIngredientes(Map<Integer, List<Ingrediente>> mapIngredientes) {
		this.mapIngredientes = mapIngredientes;
		return this;
	}
	
	public Map<Integer, List<Variacao>> getMapVariacoes() {
		return mapVariacoes != null ? mapVariacoes : new HashMap<>();
	}
	public AdicionaisConsulta setMapVariacoes(Map<Integer, List<Variacao>> mapVariacoes) {
		this.mapVariacoes = mapVariacoes;
		return this;
	}
	public Map<Integer, List<Item>> getItensMontagem() {
		return itensMontagem != null ? itensMontagem : new HashMap<>();
	}
	public AdicionaisConsulta setItensMontagem(Map<Integer, List<Item>> itensCombo) {
		this.itensMontagem = itensCombo;
		return this;
	}
	public Map<Integer, List<Item>> getMapSabores() {
		return mapSabores != null ? mapSabores : new HashMap<>();
	}
	public AdicionaisConsulta setMapSabores(Map<Integer, List<Item>> mapSabores) {
		this.mapSabores = mapSabores;
		return this;
	}
	
	

}
