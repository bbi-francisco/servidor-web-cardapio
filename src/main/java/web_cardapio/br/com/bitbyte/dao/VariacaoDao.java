package web_cardapio.br.com.bitbyte.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import web_cardapio.br.com.bitbyte.connection.ConnectionFactory;
import web_cardapio.br.com.bitbyte.format.Splitter;
import web_cardapio.br.com.bitbyte.models.Variacao;

@Repository
public class VariacaoDao {
	
	@Autowired
	private ConnectionFactory connectionFactory;
	
	public List<Variacao> getVariacoes() throws SQLException 
	{
		List<Variacao> variacoes = new ArrayList<Variacao>();		
		
		String sql =
			" SELECT " + 
			" v.codigo AS cod_varia, " + 
			" v.descricao AS desc_varia, " + 
			" p.codigo AS cod_prod " + 
			" FROM tbvariacao v " + 
			" INNER JOIN tbprod_variacao pv ON pv.cod_varia = v.codigo " + 
			" INNER JOIN tbprod p ON p.codigo = pv.cod_prod " + 
			" ORDER BY v.descricao";
		
		try(Connection conn = connectionFactory.getConnection();
			PreparedStatement pst = conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery())
		{
			while(rs.next()) 
			{
				Variacao variacao = new Variacao();
				variacao.setCodigo(rs.getString("cod_varia"));
				variacao.setDescricao(rs.getString("desc_varia"));
				variacao.setCodigoPai(rs.getString("cod_prod"));
				variacoes.add(variacao);
			}				
			return variacoes;
		}
	}
	
	@SuppressWarnings("unchecked")
	public Map<Integer, List<Variacao>> getMapVariacoesPorComanda(int comanda) throws SQLException{
		Map<Integer, List<Variacao>> mapVariacoes = new HashMap<>();
		
		Splitter variacaoUtils = new Splitter();
		String selectVariacoes = 
			" SELECT " + 
			" com_item.seq_item, " +
			" com_item.variacao, " + 
			" var.descricao " + 
			" FROM tbcomanda_item com_item " + 
			" INNER JOIN tbvariacao var " + 
			" ON com_item.variacao CONTAINING (var.codigo) " + 
			" WHERE comanda = " +comanda +
			" AND variacao IS NOT NULL" +
			" ORDER BY com_item.seq_item";
		
		try(Connection conn = connectionFactory.getConnection();
			PreparedStatement stmt = conn.prepareStatement(selectVariacoes);
			ResultSet rs = stmt.executeQuery())
		{
			if(!rs.next()) return mapVariacoes;
			
			while(!rs.isClosed()) 
			{
				String [] codigosVariacoes = variacaoUtils.splitVariacoes(rs.getString("variacao"));
				List<Variacao> variacoes = new ArrayList<>();
				int seqItem = rs.getInt("seq_item");
				
				for(String codigoVariacao : codigosVariacoes) 
				{
					Variacao variacao = new Variacao();
					variacao.setCodigo(codigoVariacao);
					variacao.setDescricao(rs.getString("descricao"));
					variacoes.add(variacao);
					rs.next();
				}
				
				mapVariacoes.put(seqItem, variacoes);
			}
			return mapVariacoes;
		}
	}
}