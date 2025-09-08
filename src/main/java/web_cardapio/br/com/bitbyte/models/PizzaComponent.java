package web_cardapio.br.com.bitbyte.models;

import java.util.List;
import java.util.stream.Collectors;

import web_cardapio.br.com.bitbyte.models.bbifood.ItemBBIFood;
import web_cardapio.br.com.bitbyte.utils.ListUtils;

public class PizzaComponent {
	
	private List<ItemBBIFood> sabores;
	
	public PizzaComponent(List<ItemBBIFood> sabores) {
		this.sabores = sabores;
	}
	
	public String getCodigosPizzas() {
		if(ListUtils.isNullOrEmpty(sabores)) {
			return "";
		}
		List<String> codigos = sabores.stream()
				.map(sabor -> sabor.getCodigo())
				.collect(Collectors.toList());
		
		return String.join("|", codigos);
	}
	
	public int getQuantidadePizza() {
		return ListUtils.getEmptyIfNull(sabores).size();
	}

}
