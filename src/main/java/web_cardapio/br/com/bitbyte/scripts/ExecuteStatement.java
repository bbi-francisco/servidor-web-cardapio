package web_cardapio.br.com.bitbyte.scripts;

public class ExecuteStatement {
	
	public String create(String sql){
        StringBuilder sb = new StringBuilder();
        sb.append(" EXECUTE STATEMENT ' ");
        sb.append(sql);
        sb.append(" '; ");
        return sb.toString();
    }

}
