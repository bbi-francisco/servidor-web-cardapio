package web_cardapio.br.com.bitbyte.interfaces;

import java.util.List;

import web_cardapio.br.com.bitbyte.models.Ingrediente;
import web_cardapio.br.com.bitbyte.models.ItemCombo;
import web_cardapio.br.com.bitbyte.models.Variacao;

public interface IPedidoItem {
	
    String getDescricao();

    String getCodigo();

    String getCodigoPesquisa();

    String getImg1();
    CharSequence getSubItensFormatados();
    int getLimiteVenda();

    List<Variacao> getVariacoes();

    List<ItemCombo> getItensCombo();

    List<Ingrediente> getIngredientes();

    String getCodigosPizzas();

    int getQuantidadePizza();

    List<? extends IPedidoItem> getItensMeioAMeio();

}
