package web_cardapio.br.com.bitbyte.scripts;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web_cardapio.br.com.bitbyte.connection.ConnectionFactory;
import web_cardapio.br.com.bitbyte.dao.ParametroDao;
import web_cardapio.br.com.bitbyte.models.Parametro;

@Service
public class ScriptsService {
	
	@Autowired
	private ConnectionFactory connFactory;
	
	@Autowired
	private ParametroDao paramDao;
	
	private static final Logger log = Logger.getLogger(ScriptsService.class);
	
	public void execute() throws SQLException {
		log.info("Executando scripts...");
		List<String> scripts = create();
		
		for(String script : scripts) {
			execute(script);
		}
		
		executeParametros();
	}

	private List<String> create() {
		
		List<String> values = new ArrayList<>();
		values.add(createTbLicencas());
		values.add(createGeneratorLicencas());
		values.add(addPizzaFieldSubgrupo());
		values.add(addProdPergVendaSugestiva());
		values.add(createScriptsAlergia());
		
		return values;
	}
	
	private void executeParametros() throws SQLException{
        
        List<Parametro> parametros = createParametros();
        
        for(Parametro p : parametros){
            paramDao.updateOrInsertParametro(p);
        }
    }
	
    private List<Parametro> createParametros()
    {
        List<Parametro> parametros = new ArrayList<>();
        parametros.add(createParametroCardapioDigitalUtilizaGrupo());
        parametros.add(createParametroCardapioDigitalFechaConta());
        return parametros;
    }
    
    private Parametro createParametroCardapioDigitalUtilizaGrupo() 
    {
    	return new Parametro()
    			.setParametro("CARDAPIO_DIGITAL_UTILIZA_GRUPO")
    			.setDescricao("Parametro que controla se vai exibir os grupos no cardapio digital")
    			.setTipoSn("S")
    			.setDefaultValue("N")
    			.setPalavraChave("CARDAPIO DIGITAL UTILIZA GRUPO")
    			.setGrupo("Cardapio Digital")
    			.setTipo("S");
    }
    
    private Parametro createParametroCardapioDigitalFechaConta() 
    {
    	return new Parametro()
    			.setParametro("CARDAPIO_DIGITAL_FECHA_CONTA")
    			.setDescricao("Parametro que controla se vai fechar conta no cardapio digital")
    			.setTipoSn("S")
    			.setDefaultValue("S")
    			.setPalavraChave("CARDAPIO DIGITAL FECHA CONTA")
    			.setGrupo("Cardapio Digital")
    			.setTipo("S");
    }
	
	private void execute(String sql) throws SQLException {
		try(Connection conn = connFactory.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql))
		{
			stmt.executeUpdate();
		}
	}
	
	private String addProdPergVendaSugestiva() 
	{
		String sql = 
				" ALTER TABLE tbprod " +
				" ADD perg_venda_sugestiva CHAR(1) DEFAULT ''N'' NOT NULL ";
		
		return new FieldScript()
				.setFieldName("PERG_VENDA_SUGESTIVA")
				.setTableName("TBPROD")
				.setSql(sql)			
				.create();
	}
	
	private String addPizzaFieldSubgrupo() 
	{
		String sql = 
				" ALTER TABLE tbsubgru " +
				" ADD pizza CHAR(1) DEFAULT ''N'' NOT NULL ";
		
		return new FieldScript()
				.setFieldName("PIZZA")
				.setTableName("TBSUBGRU")
				.setSql(sql)
				.create();
	}
	
	private String createTbLicencas()
	{
		String sql = 
			" CREATE TABLE tblicencas ( " +
			"    id INTEGER PRIMARY KEY, " +
			"    serial VARCHAR(100), " +
			"    tipo VARCHAR(25), " +
			"    liberado CHAR(1) DEFAULT ''N'' " +
			" )";
		
		return new TableScript()
				.setSql(sql)
				.setTableName("tblicencas")
				.create();
	}
	
	private String createGeneratorLicencas() {
		String sql = " CREATE SEQUENCE gen_licencas ";
		
		return new GeneratorScript()
				.setGeneratorName("gen_licencas")
				.setSql(sql)
				.create();
	}
	
	private String createScriptsAlergia() {
		String sql = 
				" CREATE TABLE tbalergias " +
				" ( " +
				"    cod_prod VARCHAR(6), " +
				"    ovo CHAR(1) DEFAULT ''N'', " +
				"    leite CHAR(1) DEFAULT ''N'', " +
				"    soja CHAR(1) DEFAULT ''N'', " +
				"    gluten CHAR(1) DEFAULT ''N'', " +
				"    amendoim CHAR(1) DEFAULT ''N'', " +
				"    sulfitos CHAR(1) DEFAULT ''N'', " +
				"    peixe CHAR(1) DEFAULT ''N'', " +
				"    moluscos CHAR(1) DEFAULT ''N'', " +
				"    mostarda CHAR(1) DEFAULT ''N'', " +
				"    nozes CHAR(1) DEFAULT ''N'', " +
				"    gergelim CHAR(1) DEFAULT ''N'', " +
				"    aipo CHAR(1) DEFAULT ''N'', " +
				"    tremoco CHAR(1) DEFAULT ''N'', " +
				"    crustaceos CHAR(1) DEFAULT ''N'' " +
				" ) ";
				
		return new TableScript()
				.setSql(sql)
				.setTableName("tbalergias")
				.create();
	}
}
