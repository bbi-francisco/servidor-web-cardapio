package web_cardapio.br.com.bitbyte.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import web_cardapio.br.com.bitbyte.connection.ConnectionFactory;
import web_cardapio.br.com.bitbyte.exceptions.ComandaQrCodeInvalidoException;
import web_cardapio.br.com.bitbyte.models.Comanda;
import web_cardapio.br.com.bitbyte.models.PagamentoParcial;

@Repository
public class PagamentoParcialDao {
	
	@Autowired
	private ConnectionFactory connectionFactory;
	
	public List<PagamentoParcial> getPagamentosParciais(Comanda comanda) throws SQLException, ComandaQrCodeInvalidoException
	{
		int numeroComanda = comanda.getNumero();		
		List<PagamentoParcial> pagamentosParciais = new ArrayList<>();
		
		String sqlSelectPagamentosParciais = 
				" SELECT " +
				" comanda, " +
				" historico, " +
				" vr_dinheiro, " +
				" vr_cartao, " +
				" vr_cartao_deb, " +
				" vr_ticket, " +
				" vr_cheque, " +
				" vr_cheque_pre, " +
				" vr_recebimento, " +
				" vr_tot_venda, " +
				" vr_pago, " +
				" vr_troco, " +
				" caixa_num, " +
				" id_caixa, " +
				" nro_pessoas, " +
				" data, " +
				" hora, " +
				" id_venda " +
				" FROM tbpag_parcial " +
				" WHERE comanda = " +numeroComanda;
		
		try(Connection conn = connectionFactory.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sqlSelectPagamentosParciais);
			ResultSet rs = stmt.executeQuery())
		{
			while(rs.next()) {
				PagamentoParcial pagamentoParcial = new PagamentoParcial();
				pagamentoParcial.setNumeroComanda(numeroComanda);
				pagamentoParcial.setHistorico(rs.getString("historico"));
				pagamentoParcial.setDinheiro(rs.getBigDecimal("vr_dinheiro"));
				pagamentoParcial.setValorCredito(rs.getBigDecimal("vr_cartao"));
				pagamentoParcial.setValorDebito(rs.getBigDecimal("vr_cartao_deb"));
				pagamentoParcial.setValorTicket(rs.getBigDecimal("vr_ticket"));
				pagamentoParcial.setValorCheque(rs.getBigDecimal("vr_cheque"));
				pagamentoParcial.setValorChequePre(rs.getBigDecimal("vr_cheque_pre"));
				pagamentoParcial.setValorRecebimento(rs.getBigDecimal("vr_recebimento"));
				pagamentoParcial.setTotalPago(rs.getBigDecimal("vr_pago"));
				pagamentoParcial.setValorTroco(rs.getBigDecimal("vr_troco"));
				pagamentoParcial.setNumeroPessoas(rs.getInt("nro_pessoas"));
				pagamentoParcial.setData(rs.getString("data"));
				pagamentoParcial.setHorario(rs.getString("hora"));
				
				pagamentosParciais.add(pagamentoParcial);
			}
			return pagamentosParciais;
		}
	}

}
