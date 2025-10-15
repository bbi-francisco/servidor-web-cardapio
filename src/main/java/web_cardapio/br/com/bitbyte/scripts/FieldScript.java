package web_cardapio.br.com.bitbyte.scripts;

import web_cardapio.br.com.bitbyte.utils.StringUtils;

public class FieldScript {
	
    private String tableName;
    private String fieldName;
    private String sql;
    private boolean alter;

    public boolean isAlter() {
        return alter;
    }

    public FieldScript setAlter(boolean alter) {
        this.alter = alter;
        return this;
    }

    public String getTableName() {
        return StringUtils.getEmptyIfNull(tableName);
    }

    public FieldScript setTableName(String tableName) {
        this.tableName = tableName;
        return this;
    }

    public String getFieldName() {
        return StringUtils.getEmptyIfNull(fieldName);
    }

    public FieldScript setFieldName(String fieldName) {
        this.fieldName = fieldName;
        return this;
    }

    public String getSql() {
        return StringUtils.getEmptyIfNull(sql);
    }

    public FieldScript setSql(String sql) {
        this.sql = sql;
        return this;
    }
    
    public String create(){
        StringBuilder sb = new StringBuilder();
        sb.append(" EXECUTE BLOCK AS BEGIN ");
        sb.append(" IF ( ");
        
        if(alter){
            sb.append(" EXISTS ");
        }else{
            sb.append(" NOT EXISTS ");
        }
        
        sb.append(" ( ");
        sb.append(" SELECT 1 FROM RDB$RELATION_FIELDS rf ");
        sb.append(" WHERE rf.RDB$RELATION_NAME = '"+ getTableName() +"' AND rf.RDB$FIELD_NAME = '" +getFieldName() + "' ");
        sb.append(" ) ");
        sb.append(" ) THEN ");
        sb.append(new ExecuteStatement().create(sql));
        sb.append(" END ");
        return sb.toString();
    }

}
