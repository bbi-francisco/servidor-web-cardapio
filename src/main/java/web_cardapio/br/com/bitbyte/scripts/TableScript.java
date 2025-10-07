package web_cardapio.br.com.bitbyte.scripts;

import web_cardapio.br.com.bitbyte.utils.StringUtils;

/**
 *
 * @author Francisco Oliveira
 */
public class TableScript {
    
    private String tableName;
    private String sql;

    public String getTableName() {
        return StringUtils.getEmptyIfNull(tableName);
    }

    public TableScript setTableName(String tableName) {
        this.tableName = tableName;
        return this;
    }

    public String getSql() {
        return StringUtils.getEmptyIfNull(sql);
    }

    public TableScript setSql(String sql) {
        this.sql = sql;
        return this;
    }
    
    public String create()
    {
        StringBuilder sb = new StringBuilder();
        sb.append(" EXECUTE BLOCK AS BEGIN ");
        sb.append(" IF (NOT EXISTS(SELECT 1 FROM rdb$relations WHERE rdb$relation_name = '" + getTableName().toUpperCase() +"'))");
        sb.append(" THEN ");
        sb.append(new ExecuteStatement().create(getSql()));
        sb.append(" END ");
        return sb.toString();
    }
}
