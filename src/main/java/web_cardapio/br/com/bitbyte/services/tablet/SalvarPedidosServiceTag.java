package web_cardapio.br.com.bitbyte.services.tablet;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web_cardapio.br.com.bitbyte.command.ValidaCaixaAberto;
import web_cardapio.br.com.bitbyte.command.ValidaComandaBloqueada;
import web_cardapio.br.com.bitbyte.command.ValidaComandaFechada;
import web_cardapio.br.com.bitbyte.command.ValidaIntervaloComanda;
import web_cardapio.br.com.bitbyte.command.ValidaLimitePedido;
import web_cardapio.br.com.bitbyte.connection.ConnectionFactory;
import web_cardapio.br.com.bitbyte.dao.ClienteDao;
import web_cardapio.br.com.bitbyte.dao.PedidosDao;
import web_cardapio.br.com.bitbyte.estatico.Parametros;
import web_cardapio.br.com.bitbyte.exceptions.BBIException;
import web_cardapio.br.com.bitbyte.format.MoneyFormatter;
import web_cardapio.br.com.bitbyte.models.Atendente;
import web_cardapio.br.com.bitbyte.models.Cliente;
import web_cardapio.br.com.bitbyte.models.Comanda;
import web_cardapio.br.com.bitbyte.models.Pedido;
import web_cardapio.br.com.bitbyte.models.bbifood.PedidoBBIFood;
import web_cardapio.br.com.bitbyte.repositories.ParametrosService;
import web_cardapio.br.com.bitbyte.results.PedidosResult;
import web_cardapio.br.com.bitbyte.services.interfaces.SalvarPedidosService;
import web_cardapio.br.com.bitbyte.servidorandroid.ConnectionFactoryAndroid;
import web_cardapio.br.com.bitbyte.utils.NumberUtils;
import web_cardapio.com.embarcadero.javaandroid.DBXException;
import web_cardapio.com.embarcadero.javaandroid.DSProxy;

@Service
public class SalvarPedidosServiceTag implements SalvarPedidosService {
	
	@Autowired
	private ValidaCaixaAberto validaCaixaAberto;
	
	@Autowired
	private ValidaComandaBloqueada validaComandaBloqueada;
	
	@Autowired
	private ValidaComandaFechada validaComandaFechada;
	
	@Autowired
	private ValidaLimitePedido validaLimitePedido;
	
	@Autowired
	private ConnectionFactory connectionFactory;
	
	@Autowired
	private ParametrosService parametrosService;
	
	@Autowired
	private ClienteDao clienteDao;
	
	@Autowired
	private PedidosDao pedidosDao;
	
	@Autowired
	private ConnectionFactoryAndroid connectionFactoryAndroid;

	@Override
	public PedidosResult insertPedido(Pedido pedido) throws SQLException, BBIException 
	{
		
		try {
			Comanda comanda = pedido.getComanda();
			validaCaixaAberto.execute();
			validaComandaBloqueada.execute(comanda);
			validaComandaFechada.execute(comanda, true);
			validaLimitePedido.execute(pedido);
			
			
			boolean comandaPrePaga = parametrosService.getBoolean(Parametros.COMANDA_PRE_PAGA);
			if(comandaPrePaga) {
				return handleComandaPrePaga(pedido);
			}else {
				return handleComandaPosPaga(pedido);
			}
		} catch (DBXException e) 
		{
			throw new RuntimeException(e.getMessage());
		}
	}
	
	private PedidosResult handleComandaPosPaga(Pedido pedido) throws SQLException, DBXException {
		Comanda comanda = pedido.getComanda();
		String idTag = comanda.getIdTag();
		
		if(!verificaTagVinculada(idTag)) {
			return new PedidosResult()
					.setSuccess(false)
					.setMessage("Tag não vinculada");
		}
		
		if(!isTagAberta(idTag)) {
			Cliente cliente = clienteDao.selectClienteFromIdTag(idTag);
			
			int comandaMesa = Integer.parseInt(cliente.getCodigo());
			comanda.setNumero(comandaMesa);
			abrirComandaFromCliente(pedido);
		}
		
		pedidosDao.insertPedido(new PedidoBBIFood(pedido), true);
		return new PedidosResult()
				.setSuccess(true)
				.setMessage("OK");
	}
	
	private PedidosResult handleComandaPrePaga(Pedido pedido) throws SQLException, DBXException {
		Comanda comanda = pedido.getComanda();
		String idTag = comanda.getIdTag();
		
		if(!verificaTagVinculada(idTag)) {
			return new PedidosResult()
					.setSuccess(false)
					.setMessage("Tag não vinculada");
		}
		
		
		
		DSProxy.TSvrMethod svr = new DSProxy.TSvrMethod(connectionFactoryAndroid.getConnection());
		BigDecimal saldo = new BigDecimal(svr.GetCreditoEasyChopp(idTag));
		
		BigDecimal valorPedido = pedido.getValorTotal();
		if(NumberUtils.biggerThan(valorPedido, saldo)) 
		{
			return new PedidosResult()
					.setSuccess(false)
					.setMessage("Saldo insuficiente. (" + new MoneyFormatter().format(saldo) + ")");
		}else {
			
			if(!isTagAberta(idTag)) {
				Cliente cliente = clienteDao.selectClienteFromIdTag(idTag);
				
				int comandaMesa = Integer.parseInt(cliente.getCodigo());
				comanda.setNumero(comandaMesa);
				abrirComandaFromCliente(pedido);
			}
			
			
			DSProxy.TSvrMethod svr2 = new DSProxy.TSvrMethod(connectionFactoryAndroid.getConnection());
			int result = svr2.AddDebitoEasyChopp2(idTag, valorPedido.doubleValue(), "");
			if(result == -1) {
				return new PedidosResult()
						.setSuccess(false)
						.setMessage("Não foi realizado o débito EasyChopp!");
			}
			pedidosDao.insertPedido(new PedidoBBIFood(pedido), true);
			return new PedidosResult()
					.setSuccess(true)
					.setMessage("OK");
		}
	}
	
	private boolean verificaTagVinculada(String idTag) throws SQLException {
		
		String sql = 
				" SELECT " +
				" idtag " +
				" FROM tbcli " +
				" WHERE idtag = ? ";
		
		try(Connection conn = connectionFactory.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql))
		{
			stmt.setString(1, idTag);
			ResultSet rs = stmt.executeQuery();
			return rs.next();
		}
	}
	
	private void abrirComandaFromCliente(Pedido pedido) throws SQLException 
	{
		Comanda comanda = pedido.getComanda();
		String idTag = comanda.getIdTag();
		Cliente cliente = clienteDao.selectClienteFromIdTag(idTag);
		
		String sql = 
				" INSERT INTO tbcomanda (" +
				" comanda, " +
				" mesa, " +
				" qtd_pessoas, " +
				" fone, " +
				" cliente, " +
				" maioridade, " +
				" nome, " +
				" cpf, " +
				" data_nascimento, " +
				" tablet_numero, " +
				" tablet_atendente, " +
				" idtag, " +
				" data_abertura, " +
				" hora_Abertura " +
				" ) " +
				" VALUES (?,?,?,?,?,?,?,?,?,?,?,?, current_date, current_time)";
		
		try(Connection conn = connectionFactory.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql))
		{
			int comandaMesa = Integer.parseInt(cliente.getCodigo());
			stmt.setInt(1, comandaMesa);
			stmt.setInt(2, comanda.getMesa());
			stmt.setInt(3, 1);
			stmt.setString(4, cliente.getTelefone());
			stmt.setString(5, cliente.getCodigo());
			stmt.setString(6, "S");
			stmt.setString(7, cliente.getNome());
			stmt.setString(8, cliente.getCpf());
			stmt.setString(9, cliente.getDataNascimento());
			stmt.setInt(10, comanda.getIdTablet());
			
			Atendente atendente = comanda.getAtendente();
			stmt.setString(11, atendente.getCodigo());
			stmt.setString(12, idTag);
			stmt.executeUpdate();
		}
	}
	
	private boolean isTagAberta(String idTag) throws SQLException {
		String sql = 
				" SELECT " +
				" idtag " +
				" FROM tbcomanda " +
				" WHERE idtag = '" +idTag + "'";
		
		try(Connection conn = connectionFactory.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery())
		{
			return rs.next();
		}
	}

	@Override
	public PedidosResult insertPedidosItem(List<Pedido> pedidos) throws SQLException, BBIException {
		for(Pedido pedido : pedidos) {
			insertPedido(pedido);
		}
		return new PedidosResult()
				.setSuccess(true)
				.setMessage("OK")
				.setStatus(200);
	}
}
