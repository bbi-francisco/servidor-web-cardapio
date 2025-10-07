package web_cardapio.br.com.bitbyte.scripts;

import web_cardapio.br.com.bitbyte.utils.StringUtils;

/**
 *
 * @author Francisco Oliveira
 */
public class GeneratorScript {
    
    private String generatorName;
    private String sql;

    public String getGeneratorName() {
        return StringUtils.getEmptyIfNull(generatorName);
    }

    public GeneratorScript setGeneratorName(String generatorName) {
        this.generatorName = generatorName;
        return this;
    }

    public String getSql() {
        return StringUtils.getEmptyIfNull(sql);
    }

    public GeneratorScript setSql(String sql) {
        this.sql = sql;
        return this;
    }
    
    public String create(){
        StringBuilder sb = new StringBuilder();
        sb.append(" EXECUTE BLOCK AS BEGIN ");
        sb.append(" IF (NOT EXISTS(SELECT 1 FROM rdb$generators WHERE rdb$generator_name = '" + getGeneratorName().toUpperCase() +"'))");
        sb.append(" THEN ");
        sb.append(new ExecuteStatement().create(getSql()));
        sb.append(" END ");
        return sb.toString();
    }
    
}
