package web_cardapio.br.com.bitbyte.interfaces;

import java.math.BigDecimal;

public interface IIngrediente {
	
	String getCodigo();
	void setCodigo(String codigo);
	
	String getDescricao();
	void setDescricao(String descricao);
	
	String getCodigoPai();
	void setCodigoPai(String codigoPai);
	
	BigDecimal getValorUnitario();
	void setValorUnitario(BigDecimal valorUnitario);
	
	String getTipo();
	void setTipo(String tipo);
	
	int getQuantidade();
	void setQuantidade(int quantidade);

}
