package web_cardapio.br.com.bitbyte.models.bbifood;

import java.util.List;
import java.util.stream.Collectors;

import web_cardapio.br.com.bitbyte.models.Pedido;

public class PedidoBBIFood {
    
    private final Pedido pedidoComanda;
    
    public PedidoBBIFood(Pedido pedidoComanda){
        this.pedidoComanda = pedidoComanda;
    }
    
    public ComandaBBIFood getComanda(){
        return new ComandaBBIFood(pedidoComanda.getComanda());
    }
    
    public List<ItemBBIFood> getItens(){
        return pedidoComanda.getItens()
                .stream()
                .map(item -> new ItemBBIFood(item))
                .collect(Collectors.toList());
    }
}

