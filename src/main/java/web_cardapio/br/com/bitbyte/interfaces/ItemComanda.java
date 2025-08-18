package web_cardapio.br.com.bitbyte.interfaces;

import java.math.BigDecimal;
import java.util.List;

import web_cardapio.br.com.bitbyte.enums.PedidoType;
import web_cardapio.br.com.bitbyte.models.Ingrediente;
import web_cardapio.br.com.bitbyte.models.ItemCombo;
import web_cardapio.br.com.bitbyte.models.Produto;
import web_cardapio.br.com.bitbyte.models.Variacao;

public interface ItemComanda {
	
	public PedidoType getPedidoType();

	public void setPedidoType(PedidoType pedidoType);
	
	public List<Variacao> getVariacoes();

	public void setVariacoes(List<Variacao> variacoes);

	public String getDescricao();

	public void setDescricao(String descricao);

	public BigDecimal getValorUnitario();

	public void setValorUnitario(BigDecimal valorUnitario);

	public int getQuantidade();
	
	public void setQuantidade(int quantidade);

	public String getCodigo();

	public void setCodigo(String codigo);
	
	public List<ItemCombo> getItensCombo();

	public void setItensCombo(List<ItemCombo> lstCombos);
	
	public String getCodigoPesquisa();
	public void setCodigoPesquisa(String codigoPesquisa);

	public String getIdIngre();

	public void setIdIngre(String idIngre);

	public List<Ingrediente> getIngredientes();

	public void setIngredientes(List<Ingrediente> ingredientes);
	
	public String getOrigem();

	public String getCodigosPizzas();

	public int getIdPizza();

	public void setIdPizza(int idPizza);

	public List<Produto> getMesclaveis();

	public void setMesclaveis(List<Produto> mesclaveis);

	public BigDecimal getValorOpcionais();

	public void setValorOpcionais(BigDecimal valorOpcionais);

	public int getQuantidadePizza();
	
	public boolean hasIngredientesInMesclaveis();

	public boolean isMontagem();

	public void setMontagem(String montagem);
	
	public String getCodigoPai();
	public void setCodigoPai(String codigoPai);
	
	public void setTipoValor(int tipoValor);
	
	
	
	

}
