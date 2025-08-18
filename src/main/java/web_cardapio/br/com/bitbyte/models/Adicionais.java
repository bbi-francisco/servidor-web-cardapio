package web_cardapio.br.com.bitbyte.models;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import web_cardapio.br.com.bitbyte.utils.CollectionsUtils;

public class Adicionais {
	
	private List<Ingrediente> listAcrescentar;
	private List<Ingrediente> listRetirar;
	private List<Item> itensMontagem;
	private List<Variacao> variacoes;
	private List<Item> sabores;
	
	public List<Variacao> getVariacoes() {
		return CollectionsUtils.getEmptyIfNull(variacoes);
	}

	public Adicionais setVariacoes(List<Variacao> variacoes) {
		this.variacoes = variacoes;
		return this;
	}
	
	public List<Ingrediente> getListAcrescentar(){
		return CollectionsUtils.getEmptyIfNull(listAcrescentar);
	}
	
	public Adicionais setListAcrescentar(List<Ingrediente> acrescentar) {
		this.listAcrescentar = acrescentar;
		return this;
	}
	
	public List<Ingrediente> getListRetirar(){
		return CollectionsUtils.getEmptyIfNull(listRetirar);
	}
	
	public Adicionais setListRetirar(List<Ingrediente> retirar) {
		this.listRetirar = retirar;
		return this;
	}
	
	public List<Ingrediente> getIngredientes()
	{
		List<Ingrediente> acrescentar = getListAcrescentar();
		List<Ingrediente> retirar = getListRetirar();
		
		List<Ingrediente> ingredientes = new ArrayList<>();
		ingredientes.addAll(acrescentar);
		ingredientes.addAll(retirar);
		return ingredientes;
	}

	public void setIngredientes(List<Ingrediente> ingredientes)
	{
		if(CollectionsUtils.isNullOrEmpty(ingredientes)) {
			this.listAcrescentar = new ArrayList<>();
			this.listRetirar = new ArrayList<>();
			return;
		}
		this.listAcrescentar = ingredientes.stream()
				.filter(ing -> ing.isAcrescentar())
				.collect(Collectors.toList());
		
		this.listRetirar = ingredientes
					.stream()
					.filter(ing -> ing.isRetirar())
					.collect(Collectors.toList());
	}
	
	public List<Item> getItensMontagem()
	{
		return CollectionsUtils.getEmptyIfNull(itensMontagem);
	}

	public Adicionais setItensMontagem(List<Item> itensMontagem)
	{
		this.itensMontagem = itensMontagem;
		return this;
	}

	public List<Item> getSabores() {
		return CollectionsUtils.getEmptyIfNull(sabores);
	}

	public Adicionais setSabores(List<Item> sabores) {
		this.sabores = sabores;
		return this;
	}
}
