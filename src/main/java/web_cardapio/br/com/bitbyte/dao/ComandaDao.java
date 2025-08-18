package web_cardapio.br.com.bitbyte.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import web_cardapio.br.com.bitbyte.connection.ConnectionFactory;
import web_cardapio.br.com.bitbyte.format.Format;
import web_cardapio.br.com.bitbyte.models.Atendente;
import web_cardapio.br.com.bitbyte.models.BloqueioComanda;
import web_cardapio.br.com.bitbyte.models.Cliente;
import web_cardapio.br.com.bitbyte.models.Comanda;
import web_cardapio.br.com.bitbyte.models.Endereco;
import web_cardapio.br.com.bitbyte.models.FechamentoComanda;
import web_cardapio.br.com.bitbyte.models.IntervaloComanda;
import web_cardapio.br.com.bitbyte.models.ValoresComanda;
import web_cardapio.br.com.bitbyte.models.bbifood.AtendenteBBIFood;
import web_cardapio.br.com.bitbyte.models.bbifood.ClienteBBIFood;
import web_cardapio.br.com.bitbyte.models.bbifood.ComandaBBIFood;
import web_cardapio.br.com.bitbyte.repositories.BbiParamService;
import web_cardapio.br.com.bitbyte.utils.BigDecimalUtils;
import web_cardapio.br.com.bitbyte.utils.NumberUtils;
import web_cardapio.br.com.bitbyte.utils.StringUtils;

@Repository
public class ComandaDao {
	
	@Autowired
	private ConnectionFactory connectionFactory;
	
	@Autowired
	private AtendenteDao atendenteDao;
	
	@Autowired
	private BbiParamService bbiParamService;
	
	public IntervaloComanda verificarIntervaloComanda(int numeroComanda) throws SQLException 
	{
		int comandaInicial = bbiParamService.comandaInicial();
		int comandaFinal = bbiParamService.comandaFinal();
		
		return new IntervaloComanda()
				.setComandaFinal(comandaFinal)
				.setComandaInicial(comandaInicial)
				.setNumeroComanda(numeroComanda);
	}
	
	public BloqueioComanda verificarComandaBloqueada(int numeroComanda) throws SQLException
	{
		String selectComandaBloqueada = 
			" SELECT comanda, " +
			" COALESCE (motivo, '') AS motivo " +
			" FROM tbcomanda_bloqueada " +
			" WHERE comanda = '" + numeroComanda + "'";
		
		try(Connection conn = connectionFactory.getConnection();
				PreparedStatement stmt = conn.prepareStatement(selectComandaBloqueada);
				ResultSet rs = stmt.executeQuery())
		{
			if(rs.next()) 
			{
				return new BloqueioComanda()
						.setMotivo(rs.getString("motivo"))
						.setNumeroComanda(numeroComanda)
						.setBloqueada(true);
			}
			return new BloqueioComanda()
					.setNumeroComanda(numeroComanda);
		}
	}
	
	public FechamentoComanda verificarComandaFechada(int numeroComanda) throws SQLException 
	{
		String sqlSelectComandaFechamento =
			" SELECT " +
			" comanda " +
			" FROM tbcomanda_fechamento " +
			" WHERE comanda = '" +numeroComanda + "'";
			
		try(Connection conn = connectionFactory.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sqlSelectComandaFechamento);
			ResultSet rs = stmt.executeQuery())
		{
			if(rs.next()) {
				return new FechamentoComanda()
						.setFechada(true)
						.setNumeroComanda(numeroComanda);
			}	
			return new FechamentoComanda().setNumeroComanda(numeroComanda);
		}
	}
	
	public void insertOrUpdateComandas(List<ComandaBBIFood> comandas) throws SQLException 
	{
		String sqlInsertComanda = 
			" UPDATE OR INSERT INTO tbcomanda (" +
			" comanda, " +
			" seq, " +
			" mesa, " +
			" qtd_pessoas, " +
			" maioridade, " + 
			" limite, " +
			" tablet_numero, " +
			" tablet_atendente, " +
			" fone, " +
			" cliente, " +
			" nome, " +
			" rg, " +
			" cpf, " +
			" data_abertura, " + 
			" hora_abertura) " +
			" VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, current_date, current_time)";
		
		try(
				Connection conn = connectionFactory.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sqlInsertComanda)) 
		{
			for(ComandaBBIFood comanda : comandas) 
			{
				int numeroComanda = comanda.getNumero();
				//comanda
				stmt.setInt(1, numeroComanda);
				//seq
				stmt.setInt(2, 0);
				//mesa
				stmt.setInt(3, comanda.getMesa());
				//qtd_pessoas
				stmt.setInt(4, 1);
				//maioridade
				stmt.setString(5, "S");
				//limite
				ValoresComanda valoresComanda = comanda.getValoresComanda();
				if(valoresComanda == null) {
					stmt.setDouble(6, 0);
				}else 
				{
					BigDecimal limite = comanda.getValoresComanda().getLimite();
					stmt.setDouble(6, limite.doubleValue());
				}
				
				//tablet_numero
				stmt.setInt(7, comanda.getIdTablet());
				//tablet_atendente
				
				String codigoAtendente = getCodigoAtendente(comanda);
			
				stmt.setString(8, Format.casasFormat(codigoAtendente, 5));
				
				ClienteBBIFood cliente = comanda.getCliente();
				if(cliente != null) {
					//fone
					stmt.setString(9, cliente.getTelefone());
					//codigo do cliente
					stmt.setObject(10, cliente.getCodigo());
					//nome do cliente
					stmt.setString(11, cliente.getNome());
					//rg do cliente
					stmt.setString(12, cliente.getRg());
					//cpf do cliente
					stmt.setString(13, cliente.getCpf());
				}else {
					//fone
					stmt.setString(9, "");
					//codigo do cliente
					stmt.setObject(10, "");
					//nome do cliente
					stmt.setString(11, "");
					//rg do cliente
					stmt.setString(12, "");
					//cpf do cliente
					stmt.setString(13, "");
				}
				
				stmt.executeUpdate();
			}
		}	
	}
	
	private String getCodigoAtendente(ComandaBBIFood comanda) throws SQLException 
	{
		AtendenteBBIFood atendente = comanda.getAtendente();
		if(atendente == null ) {
			return "";
		}
		
		String codigoAtendente = atendente.getCodigo();
		if(!StringUtils.isNullOrEmpty(codigoAtendente)) 
		{
			return codigoAtendente;
		}
		
		String usuario = atendente.getUsuario();
		String senha = atendente.getSenha();
		
		Atendente atendenteBusca = atendenteDao.getAtendenteByUsuarioAndSenha(usuario, senha);
		if(atendenteBusca == null) {
			return "";
		}
		return atendenteBusca.getCodigo();
	}
	
	public void deleteComandasSemPedidos(List<Comanda> comandas) throws SQLException 
	{
		String comandasFormatado = getComandasFormatado(comandas);
		String sqlDeleteComandas = 
			" DELETE FROM tbcomanda " +
			" WHERE comanda IN (" +comandasFormatado + ") AND " +
			" comanda NOT IN ( " +
			" SELECT comanda FROM tbcomanda_item)";
		
		try(Connection conn = connectionFactory.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sqlDeleteComandas)){
			stmt.executeUpdate();
		}
	}
	
	/**
	 * Obtem os numeros das comandas da lista e formata uma string com a sequencia, 
	 * separada por virgula
	 * @param comandas
	 * @return numeros das comandas separados por virgula
	 */
	private String getComandasFormatado(List<Comanda> comandas) 
	{
		StringBuilder sb = new StringBuilder();
		Iterator<Comanda> i = comandas.iterator();
		while(i.hasNext()) {
			Comanda comanda = i.next();
			sb.append(comanda.getNumero());
			if(i.hasNext())
				sb.append(",");
		}
		return sb.toString();
	}
	
	public Comanda selectComandaByNumero(int numeroComanda) throws SQLException {
		String sqlPesqComanda = 
				" SELECT  " + 
				" c.comanda,  " + 
				" cli.codigo AS codigo_cliente,  " + 
				" cli.nome AS nome_cliente,  " +
				" cli.endereco AS endereco_cliente, " +
				" cli.bairro As bairro_cliente, " +
				" cli.cep AS cep_cliente, " +
				" cli.cid AS cid_cliente, " +
				" cli.est AS est_cliente, " +
				" cli.complemento AS complemento_cliente, " +
				" cli.numend AS numend_cliente, " +
				" cli.referencia AS referencia_cliente, " +
				" cli.email AS email_cliente, " +
				" c.cpf AS cpf_cliente, " +
				" c.rg AS rg_cliente, " +
				" c.fone AS fone_cliente, " +
				" c.limite,  " + 
				" c.maioridade,  " + 
				" c.tablet_numero,  " + 
				" c.tablet_atendente,  " + 
				" c.idtag, " +
				" f.usuario AS usuario_atendente, " +
				" f.senha AS senha_atendente, " +
				" SUM(ci.qtd * ci.vr_unit) AS valor_total  " + 
				" FROM tbcomanda c  " + 
				" LEFT JOIN tbcomanda_item ci ON ci.comanda = c.comanda  " + 
				" LEFT JOIN tbcli cli ON cli.codigo = c.cliente " +
				" LEFT JOIN tbfunc f ON f.codigo = c.tablet_atendente " + 
				" WHERE c.comanda =  " + numeroComanda+
				" GROUP BY  " + 
				" cli.codigo,  " + 
				" cli.nome,  " +
				" cli.endereco, " +
				" cli.bairro, " +
				" cli.cep, " +
				" cli.cid, " +
				" cli.est, " +
				" cli.complemento, " +
				" cli.numend, " +
				" cli.referencia, " +
				" cli.email, " +
				" c.cpf, " +
				" c.rg, " +
				" c.fone, " +
				" c.comanda,  " + 
				" c.cliente,  " + 
				" c.nome,  " + 
				" c.limite,  " + 
				" c.maioridade,  " + 
				" c.tablet_numero,  " + 
				" c.tablet_atendente, " +
				" c.idtag, " +
				" f.usuario, " +
				" f.senha ";
		
		try(Connection conn = connectionFactory.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sqlPesqComanda);
			ResultSet rs = stmt.executeQuery())
		{
			boolean validaLimiteCaixaAbertura = bbiParamService.validaLimiteCaixaAbertura();
			BigDecimal valorTravaComanda = bbiParamService.valorTravaComanda();
			
			if(rs.next())
			{
				Endereco endereco = new Endereco()
						.setEndereco(rs.getString("endereco_cliente"))
						.setBairro(rs.getString("bairro_cliente"))
						.setCep(rs.getString("cep_cliente"))
						.setCid(rs.getString("cid_cliente"))
						.setEst(rs.getString("est_cliente"))
						.setComplemento(rs.getString("complemento_cliente"))
						.setNumEnd(rs.getInt("numend_cliente"))
						.setPais("BR")
						.setReferencia(rs.getString("referencia_cliente"));
				
				Cliente cliente = new Cliente()
						.setCodigo(rs.getString("codigo_cliente"))
						.setNome(rs.getString("nome_cliente"))
						.setCpf(rs.getString("cpf_cliente"))
						.setEmail(rs.getString("email_cliente"))
						.setRg(rs.getString("rg_cliente"))
						.setTelefone(rs.getString("fone_cliente"))
						.setEndereco(endereco);
				
				Atendente atendente = new Atendente()
						.setCodigo(rs.getString("tablet_atendente"))
						.setUsuario(rs.getString("usuario_atendente"))
						.setSenha(rs.getString("senha_atendente"));
				
				Comanda comanda = new Comanda()
				.setCliente(cliente)
				.setAtendente(atendente)
				.setNumero(rs.getInt("comanda"))
				.setMaioridade("S".equals(rs.getString("maioridade")))
				.setIdTablet(rs.getInt("tablet_numero"))
				.setIdTag(rs.getString("idtag"));
				
				ValoresComanda valores = new ValoresComanda();
				BigDecimal limite = new BigDecimal(0);
				if(NumberUtils.biggerThan(valorTravaComanda, 0)) 
				{
					if(validaLimiteCaixaAbertura) {
						limite = new BigDecimal(rs.getDouble("limite"));
					}else {
						limite = valorTravaComanda;
					}
				}
				
				BigDecimal totalComanda = BigDecimalUtils.getZeroIfNull(rs.getBigDecimal("valor_total"));
				BigDecimal saldo = limite.subtract(totalComanda);
				
				valores
				.setLimite(limite)
				.setValorTotal(totalComanda)
				.setValorComanda(totalComanda)
				.setSaldo(saldo);
				
				comanda.setValoresComanda(valores);
				return comanda;
			}
			return null;
		}
	}
		
		public Comanda selectComandaByTag(String idTag) throws SQLException {
			String sqlPesqComanda = 
					" SELECT  " + 
					" c.comanda,  " + 
					" cli.codigo AS codigo_cliente,  " + 
					" cli.nome AS nome_cliente,  " +
					" cli.endereco AS endereco_cliente, " +
					" cli.bairro As bairro_cliente, " +
					" cli.cep AS cep_cliente, " +
					" cli.cid AS cid_cliente, " +
					" cli.est AS est_cliente, " +
					" cli.complemento AS complemento_cliente, " +
					" cli.numend AS numend_cliente, " +
					" cli.referencia AS referencia_cliente, " +
					" cli.email AS email_cliente, " +
					" c.cpf AS cpf_cliente, " +
					" c.rg AS rg_cliente, " +
					" c.fone AS fone_cliente, " +
					" c.limite,  " + 
					" c.maioridade,  " + 
					" c.tablet_numero,  " + 
					" c.tablet_atendente,  " + 
					" c.idtag, " +
					" f.usuario AS usuario_atendente, " +
					" f.senha AS senha_atendente, " +
					" SUM(ci.qtd * ci.vr_unit) AS valor_total  " + 
					" FROM tbcomanda c  " + 
					" LEFT JOIN tbcomanda_item ci ON ci.comanda = c.comanda  " + 
					" LEFT JOIN tbcli cli ON cli.codigo = c.cliente " +
					" LEFT JOIN tbfunc f ON f.codigo = c.tablet_atendente " + 
					" WHERE c.idtag =  '" + idTag+ "' " +
					" GROUP BY  " + 
					" cli.codigo,  " + 
					" cli.nome,  " +
					" cli.endereco, " +
					" cli.bairro, " +
					" cli.cep, " +
					" cli.cid, " +
					" cli.est, " +
					" cli.complemento, " +
					" cli.numend, " +
					" cli.referencia, " +
					" cli.email, " +
					" c.cpf, " +
					" c.rg, " +
					" c.fone, " +
					" c.comanda,  " + 
					" c.cliente,  " + 
					" c.nome,  " + 
					" c.limite,  " + 
					" c.maioridade,  " + 
					" c.tablet_numero,  " + 
					" c.tablet_atendente, " +
					" c.idtag, " +
					" f.usuario, " +
					" f.senha ";
			
			try(Connection conn = connectionFactory.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sqlPesqComanda);
				ResultSet rs = stmt.executeQuery())
			{
				boolean validaLimiteCaixaAbertura = bbiParamService.validaLimiteCaixaAbertura();
				BigDecimal valorTravaComanda = bbiParamService.valorTravaComanda();
				
				if(rs.next())
				{
					Endereco endereco = new Endereco()
							.setEndereco(rs.getString("endereco_cliente"))
							.setBairro(rs.getString("bairro_cliente"))
							.setCep(rs.getString("cep_cliente"))
							.setCid(rs.getString("cid_cliente"))
							.setEst(rs.getString("est_cliente"))
							.setComplemento(rs.getString("complemento_cliente"))
							.setNumEnd(rs.getInt("numend_cliente"))
							.setPais("BR")
							.setReferencia(rs.getString("referencia_cliente"));
					
					Cliente cliente = new Cliente()
							.setCodigo(rs.getString("codigo_cliente"))
							.setNome(rs.getString("nome_cliente"))
							.setCpf(rs.getString("cpf_cliente"))
							.setEmail(rs.getString("email_cliente"))
							.setRg(rs.getString("rg_cliente"))
							.setTelefone(rs.getString("fone_cliente"))
							.setEndereco(endereco);
					
					Atendente atendente = new Atendente()
							.setCodigo(rs.getString("tablet_atendente"))
							.setUsuario(rs.getString("usuario_atendente"))
							.setSenha(rs.getString("senha_atendente"));
					
					Comanda comanda = new Comanda()
					.setCliente(cliente)
					.setAtendente(atendente)
					.setNumero(rs.getInt("comanda"))
					.setMaioridade("S".equals(rs.getString("maioridade")))
					.setIdTablet(rs.getInt("tablet_numero"))
					.setIdTag(rs.getString("idtag"));
					
					ValoresComanda valores = new ValoresComanda();
					BigDecimal limite = new BigDecimal(0);
					if(NumberUtils.biggerThan(valorTravaComanda, 0)) 
					{
						if(validaLimiteCaixaAbertura) {
							limite = new BigDecimal(rs.getDouble("limite"));
						}else {
							limite = valorTravaComanda;
						}
					}
					
					BigDecimal totalComanda = BigDecimalUtils.getZeroIfNull(rs.getBigDecimal("valor_total"));
					BigDecimal saldo = limite.subtract(totalComanda);
					
					valores
					.setLimite(limite)
					.setValorTotal(totalComanda)
					.setValorComanda(totalComanda)
					.setSaldo(saldo);
					
					comanda.setValoresComanda(valores);
					return comanda;
				}
				return null;
			}
	}
}
