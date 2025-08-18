package web_cardapio.br.com.bitbyte.services.interfaces;

import java.sql.SQLException;
import java.util.List;

import web_cardapio.br.com.bitbyte.exceptions.BBIException;
import web_cardapio.br.com.bitbyte.models.Pedido;
import web_cardapio.br.com.bitbyte.results.PedidosResult;

public interface SalvarPedidosService {
	
	PedidosResult insertPedido(Pedido pedido) throws SQLException, BBIException;
	PedidosResult insertPedidosItem(List<Pedido> pedidos) throws SQLException, BBIException;

}
