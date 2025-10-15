package web_cardapio.br.com.bitbyte.dao;

import java.math.BigDecimal;
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
import web_cardapio.br.com.bitbyte.estatico.Parametros;
import web_cardapio.br.com.bitbyte.models.Parametro;
import web_cardapio.br.com.bitbyte.utils.Control;

@Repository
public class ParametroDao
{
	private static final Logger log = Logger.getLogger(ParametroDao.class);
	
	@Autowired
	private ConnectionFactory connectionFactory;
	
	public List<Parametro> getParametros() throws SQLException, IllegalAccessException 
	{
		List<Parametro> parametros = new ArrayList<>();
		for(Parametro parametro : getMapParametros().values()) {
			parametros.add(parametro);
		}
		return parametros;
	}
	
	public Map<String, Parametro> getMapParametros() throws SQLException
	{
		Map<String, Parametro> mapParametros = new HashMap<>();
		Parametros parametros = new Parametros();
		
		String sqlSelectParametros = 
		" SELECT " +
		" valor, " +
		" parametro, " +
		" tipo " +
		" FROM tbparametro " + 
		" WHERE parametro IN ( " +
			parametros.getParametros() +
		") ORDER BY parametro";
		
		try(Connection conn = connectionFactory.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sqlSelectParametros);
			ResultSet rs = stmt.executeQuery();)
		{
			while(rs.next()) 
			{
				Parametro param = new Parametro();
				param.setValor(rs.getString("valor"));
				String descricao = rs.getString("parametro");
				param.setParametro(descricao);
				
				mapParametros.put(descricao, param);
			}
			return mapParametros;
		}
	}
	
	public BigDecimal taxa(int numeroComanda) throws SQLException 
	{
		Map<String, Parametro> parametros = getMapParametros();
		String calculaTaxa = parametros.get(Parametros.COM).getValor();
		String comissao = parametros.get(Parametros.COMISSAO).getValor();
		String liberarTaxaPorProduto = parametros.get(Parametros.LIBERAR_TAXA_POR_PRODUTO).getValor();
		String truncarArredondar = parametros.get(Parametros.TRUNCAR_ARREDONDAR).getValor();
		
		String pComissao = getComissao(calculaTaxa, comissao);
		String sTaxaAtendimento = getTaxaValor(liberarTaxaPorProduto);
		String pVrFuncao = getFuncao(truncarArredondar);
		BigDecimal taxa = BigDecimal.valueOf(0);
		
		String sqlSelectTaxa = 
		  " SELECT " + pVrFuncao + " (SUM(c.qtd * c.vr_unit) " + " * ( " + pComissao + " / 100), 2) AS taxa " +
          " FROM tbcomanda_item c " +
          " INNER JOIN tbprod pd ON c.codprod = pd.codigo " +
          " AND pd.taxa_atendimento = 'S' " +
          " WHERE c.comanda = '" +numeroComanda + "' " + sTaxaAtendimento +
          " HAVING SUM(c.qtd) > 0 ";
		
		try(Connection conn = connectionFactory.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sqlSelectTaxa);
			ResultSet rs = stmt.executeQuery())
		{
			if(rs.next()) {
				taxa = rs.getBigDecimal("taxa");
				log.info("TAXA DE ATENDIMENTO: " +Control.formatarMonetario(taxa));
			}
			return taxa;
		}
	}
	
	private String getComissao(String calculaTaxa, String comissao) 
	{
		if("S".equals(calculaTaxa))
			return "CAST(" + trocaVirgula(comissao) + "AS DOUBLE PRECISION)";
		else
			return "CAST(0 AS DOUBLE PRECISION)";
	}
	
	private String getTaxaValor(String liberarTaxaPorProduto) {
		if("S".equals(liberarTaxaPorProduto))
			return  "AND COALESCE(c.taxaatendimento, 'S') = 'S'";
		else
			return "";
	}
	
	private String getFuncao(String truncarArredondar) {
		if("T".equals(truncarArredondar))
			return "F_TRUNCAR";
		else
			return "F_ARREDONDAR";
	}
	
	public String trocaVirgula(String valor) {
		return valor.replace(",", ".");
	}
	
	public void updateOrInsertParametro(Parametro p) throws SQLException
    {
        String sqlValor = 
                " COALESCE (" +
                " ( " +
                "   SELECT valor " +
                "   FROM tbparametro p " +
                "   WHERE p.parametro = '" +p.getParametro() + "'" +
                " ), '" + p.getDefaultValue() + "') ";
        
        String sql = 
            " UPDATE OR INSERT INTO tbparametro ( " +
            " parametro, " +
            " tipo, " +
            " tipo_sn, " +
            " grupo, " +
            " descricao, " +
            " palavra_chave, " +
            " valor " +
            " ) VALUES (?,?,?,?,?,?, " + sqlValor + ") " +
            " MATCHING (parametro)";
        
        try(Connection conn = connectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql))
        {
 
            stmt.setString(1, p.getParametro());
            stmt.setString(2, p.getTipo());
            stmt.setString(3, p.getTipoSn());
            stmt.setString(4, p.getGrupo());
            stmt.setString(5, p.getDescricao());
            stmt.setString(6, p.getPalavraChave());
            stmt.execute();
        }
    }
	
}
