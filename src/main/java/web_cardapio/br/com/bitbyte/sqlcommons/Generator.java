package web_cardapio.br.com.bitbyte.sqlcommons;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import web_cardapio.br.com.bitbyte.connection.ConnectionFactory;

@Repository
public class Generator {
	
	@Autowired
	private ConnectionFactory connectionFactory;
	private static final Logger log = Logger.getLogger(Generator.class);
	
	public static final String FECHAMENTO = "GEN_TBCOMANDA_FECHAMENTO";
	public static final String PIZZA = "GEN_ID_PIZZA";
	
	public String gerarId(String generator) throws SQLException {
		String id = "";
		String genSeqItem = "SELECT gen_id ("+ generator +", 1) AS id_atual FROM RDB$DATABASE";
		
		try(Connection conn = connectionFactory.getConnection();
			PreparedStatement stmt = conn.prepareStatement(genSeqItem);
			ResultSet rs = stmt.executeQuery())
		{
			id = (rs.next()) ? rs.getString("id_atual") : "0";
		}
		catch (Exception e)
		{
			log.error(e);
			throw new SQLException("Erro ao gerar id para o item. " +e);
		}
		return id;
	}
	
	public int gerarIdItem() throws SQLException
	{
		int idProd = 0;
		String genSeqItem = "SELECT gen_id (GEN_TBCOMANDA_ITEM,1) AS id_atual FROM RDB$DATABASE";
		try(Connection conn = connectionFactory.getConnection();
			PreparedStatement stmt = conn.prepareStatement(genSeqItem);
			ResultSet rs = stmt.executeQuery())
		{
			idProd = (rs.next()) ? rs.getInt("id_atual") : 0;
		}
		catch (Exception e)
		{
			log.error(e);
			throw new SQLException("Erro ao gerar id para o item. " +e);
		}
		return idProd;
	}
	
	public int gerarIdIngre() throws SQLException
	{
		int idIngre = 0;
		String genCodIngre = "SELECT gen_id (GEN_TBCOMANDA_INGRE_ID,1) AS id_atual FROM RDB$DATABASE";
		try(Connection conn = connectionFactory.getConnection();
			PreparedStatement stmt = conn.prepareStatement(genCodIngre);
			ResultSet rs = stmt.executeQuery())
		{
			if(rs.next())
			{
				idIngre = rs.getInt("id_atual");
			}
		}
		catch (Exception e)
		{
			log.error(e);
			throw new SQLException("Erro ao gerar id para o ingrediente. " +e);
		}
		return idIngre;
	}
	
	public String getCodigoPesquisa(String codigoProduto) throws SQLException 
	{
		String sql = 
				" SELECT codpesquisa" +
				" FROM tbprod " +
				" WHERE codigo = " + codigoProduto;
		
		try(Connection conn = connectionFactory.getConnection();
			PreparedStatement pst = conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery())
		{
			String codigoPesquisa = "";
			while(rs.next()) 
			{
				codigoPesquisa = rs.getString("codpesquisa");
				codigoPesquisa = codigoPesquisa != null ? codigoPesquisa : "";
				return codigoPesquisa;
			}
			return codigoPesquisa;
		}
	}
	
	public int getSeqItem() throws SQLException 
	{
		String sql = "SELECT id FROM sp_gen_tbcomanda_item";
		try(Connection conn = connectionFactory.getConnection();
			PreparedStatement pst = conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery())
		{
			if(rs.next()) {
				return rs.getInt("id");
			}					
			return 0;
		}
	}

	public int getSeqIngre() throws SQLException 
	{
		String sql = 
				" SELECT id " +
				" FROM sp_gen_tbcomanda_ingre_id ";
		
		try(Connection conn = connectionFactory.getConnection();
			PreparedStatement pst = conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery())
		{
			if(rs.next()) {
				return rs.getInt("id");
			}
			return 0;
		}
	}
	
	public int gerarIdPesquisa() throws SQLException {
		int idPesquisa = 0;
		// Gerando ID de ingrediente para o Item
		String genCodIngre = 
				" SELECT gen_id (GEN_TBCOMANDA_INGRE_ID,1) " +
				" AS id_atual " +
				" FROM RDB$DATABASE ";
		try(Connection conn = connectionFactory.getConnection();
			PreparedStatement stmt = conn.prepareStatement(genCodIngre);
			ResultSet rs = stmt.executeQuery();)
		{
			if(rs.next())
			{
				idPesquisa = rs.getInt("id_atual");
			}
		}
		catch (Exception e)
		{
			log.error(e);
			throw new SQLException("Erro ao gerar id para o pesquisa. " +e);
		}
		return idPesquisa;
	}
	
	public int gerarIdCliente() throws SQLException
    {
        
        String sql = "SELECT gen_id(gen_tbcli, 1) as id FROM rdb$database";
        
        try(Connection connection = connectionFactory.getConnection();
            PreparedStatement pst = connection.prepareStatement(sql);
            ResultSet rs = pst.executeQuery())
        {
            if(rs.next()) return rs.getInt("id");
        }
        return 0;
    }

}
