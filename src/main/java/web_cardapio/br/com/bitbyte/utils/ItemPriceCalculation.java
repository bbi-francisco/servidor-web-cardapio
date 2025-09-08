package web_cardapio.br.com.bitbyte.utils;

import java.math.BigDecimal;
import java.util.List;

import web_cardapio.br.com.bitbyte.models.Adicionais;
import web_cardapio.br.com.bitbyte.models.Ingrediente;
import web_cardapio.br.com.bitbyte.models.Item;
import web_cardapio.br.com.bitbyte.models.bbifood.AdicionaisBBIFood;
import web_cardapio.br.com.bitbyte.models.bbifood.ItemBBIFood;

public class ItemPriceCalculation {
	public BigDecimal getValorAcrescentar(Item item) {
		Adicionais adicionais = item.getAdicionais();
		if (adicionais == null) {
			return BigDecimal.valueOf(0);
		}
		List<Ingrediente> acrescentarList = adicionais.getListAcrescentar();
		BigDecimal valorAcrescentar = new BigDecimal(0);
		for (Ingrediente acrescentar : acrescentarList) {
			double qtd = acrescentar.getQtd();
			BigDecimal qtdAcrescentar = BigDecimal.valueOf(qtd);
			BigDecimal valor = acrescentar.getVrUnit().multiply(qtdAcrescentar);
			valorAcrescentar = valorAcrescentar.add(valor);
		}
		return valorAcrescentar;
	}

	public BigDecimal getValorAcrescentar(ItemBBIFood item) {
		Item itemPedido = item.getItemPedido();
		return getValorAcrescentar(itemPedido);
	}

	public BigDecimal getValorRetirar(ItemBBIFood item) {
		Item itemPedido = item.getItemPedido();
		return getValorRetirar(itemPedido);
	}

	public BigDecimal getValorRetirar(Item item) {
		Adicionais adicionais = item.getAdicionais();
		if (adicionais == null) {
			return BigDecimal.valueOf(0);
		}
		List<Ingrediente> retirarList = adicionais.getListRetirar();
		BigDecimal valorRetirar = new BigDecimal(0);
		for (Ingrediente retirar : retirarList) {
			valorRetirar = valorRetirar.add(retirar.getVrUnit());
		}
		return valorRetirar;
	}

	public BigDecimal getValorIngredientes(Item item) {
		BigDecimal valorAcrescentar = getValorAcrescentar(item);
		BigDecimal valorRetirar = getValorRetirar(item);
		return valorAcrescentar.subtract(valorRetirar);
	}

	public BigDecimal getValorIngredientes(ItemBBIFood item) {
		BigDecimal valorAcrescentar = getValorAcrescentar(item);
		BigDecimal valorRetirar = getValorRetirar(item);
		return valorAcrescentar.subtract(valorRetirar);
	}

	public BigDecimal getValorItensMontagem(Item item) {
		Adicionais adicionais = item.getAdicionais();
		if (adicionais == null) {
			return BigDecimal.valueOf(0);
		}
		List<Item> itensMontagem = adicionais.getItensMontagem();
		BigDecimal totalItens = new BigDecimal(0);
		for (Item itemMontagem : itensMontagem) {
			BigDecimal qtd = BigDecimal.valueOf(itemMontagem.getQtd());
			BigDecimal totalItem = itemMontagem.getVrUnit().multiply(qtd);
			totalItens = totalItens.add(totalItem);
		}
		return totalItens;
	}

	public BigDecimal getValorAdicionaisSabores(ItemBBIFood item) {
		AdicionaisBBIFood adicionais = item.getAdicionais();
		if (adicionais == null) {
			return BigDecimal.valueOf(0);
		}
		List<ItemBBIFood> sabores = adicionais.getSabores();
		BigDecimal valorAdicionaisSabores = new BigDecimal(0);
		for (ItemBBIFood sabor : sabores) {

			BigDecimal valorAdicionais = getValorIngredientes(sabor);

			valorAdicionaisSabores = valorAdicionaisSabores.add(valorAdicionais);
		}
		return valorAdicionaisSabores;
	}
}
