package web_cardapio.br.com.bitbyte.interfaces;

import web_cardapio.br.com.bitbyte.models.bbifood.AdicionaisBBIFood;

public interface ItemComandaIngrediente {
	
	AdicionaisBBIFood getAdicionais();
	
	int getSeqItem();
	void setSeqItem(int seqItem);
	
	int getIdIngre();
	void setIdIngre(int idIngre);

}
