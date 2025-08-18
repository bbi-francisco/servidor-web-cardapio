package web_cardapio.br.com.bitbyte.models.bbifood;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import web_cardapio.br.com.bitbyte.models.Adicionais;

public class AdicionaisBBIFood {
	
	private Adicionais adicionais;
	
	public AdicionaisBBIFood(Adicionais adicionais) {
		this.adicionais = adicionais;
	}
	
    public List<ItemBBIFood> getItensMontagem()
    {
    	if(adicionais == null) {
    		return Collections.emptyList();
    	}
    	return adicionais.getItensMontagem()
    			.stream()
    			.map(item -> new ItemBBIFood(item))
    			.collect(Collectors.toList());
    }
    
    public List<IngredienteBBIFood> getIngredientes()
    {
    	if(adicionais == null) {
    		return Collections.emptyList();
    	}
    	return adicionais.getIngredientes()
    			.stream()
    			.map(ingrediente -> new IngredienteBBIFood(ingrediente))
    			.collect(Collectors.toList());
    }
    

    public List<IngredienteBBIFood> getListAcrescentar() 
    {
    	if(adicionais == null) {
    		return Collections.emptyList();
    	}
        return adicionais.getListAcrescentar()
        		.stream()
	            .map(subItem -> new IngredienteBBIFood(subItem))
	            .collect(Collectors.toList());
    }

    public List<IngredienteBBIFood> getListRetirar() {
    	if(adicionais == null) {
    		return Collections.emptyList();
    	}
        return adicionais.getListRetirar()
        		.stream()
	            .map(subItem -> new IngredienteBBIFood(subItem))
	            .collect(Collectors.toList());
    }
    
    public List<VariacaoBBIFood> getVariacoes() 
    {
    	if(adicionais == null) {
    		return Collections.emptyList();
    	}
        return adicionais.getVariacoes()
        		.stream()
	            .map(variacao -> new VariacaoBBIFood(variacao))
	            .collect(Collectors.toList());
    }
    
    public List<ItemBBIFood> getSabores()
    {
    	if(adicionais == null) {
    		return Collections.emptyList();
    	}
        return adicionais.getSabores()
        		.stream()
	            .map(subItem -> new ItemBBIFood(subItem))
	            .collect(Collectors.toList());
    }
}
