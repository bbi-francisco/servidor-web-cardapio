package web_cardapio.br.com.bitbyte.models;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import web_cardapio.br.com.bitbyte.utils.ListUtils;

public class Adicionais {
	
	private List<Ingrediente> listAcrescentar;
	private List<Ingrediente> listRetirar;
	private List<Item> itensMontagem;
	private List<Variacao> variacoes;
	private List<Item> sabores;
	
	public List<Variacao> getVariacoes() {
		return ListUtils.getEmptyIfNull(variacoes);
	}

	public Adicionais setVariacoes(List<Variacao> variacoes) {
		this.variacoes = variacoes;
		return this;
	}
	
	public List<Ingrediente> getListAcrescentar(){
		return ListUtils.getEmptyIfNull(listAcrescentar);
	}
	
	public Adicionais setListAcrescentar(List<Ingrediente> acrescentar) {
		this.listAcrescentar = acrescentar;
		return this;
	}
	
	public List<Ingrediente> getListRetirar(){
		return ListUtils.getEmptyIfNull(listRetirar);
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
		if(ListUtils.isNullOrEmpty(ingredientes)) {
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
		return ListUtils.getEmptyIfNull(itensMontagem);
	}

	public Adicionais setItensMontagem(List<Item> itensMontagem)
	{
		this.itensMontagem = itensMontagem;
		return this;
	}

	public List<Item> getSabores() {
		return ListUtils.getEmptyIfNull(sabores);
	}

	public Adicionais setSabores(List<Item> sabores) {
		this.sabores = sabores;
		return this;
	}
}
