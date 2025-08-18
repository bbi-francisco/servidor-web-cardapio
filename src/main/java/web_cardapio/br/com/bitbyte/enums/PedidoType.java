package web_cardapio.br.com.bitbyte.enums;

public enum PedidoType{

    PRODUTO("produto"),
    PRODUTO_MESCLADO("produto_mesclado"),
    PIZZA("pizza"),
	PRODUTO_MONTAGEM("produto_montagem"),
	ITEM_MESCLAVEL("item_mesclavel");
    
    private String valor;

    PedidoType (String valor){
        this.valor= valor;
    }
}