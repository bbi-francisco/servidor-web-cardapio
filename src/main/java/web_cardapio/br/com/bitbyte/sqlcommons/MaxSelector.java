package web_cardapio.br.com.bitbyte.sqlcommons;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import web_cardapio.br.com.bitbyte.connection.ConnectionFactory;

public class MaxSelector {

	private Connection connection;
	private String fieldName;
	private String tableName;
	private String whereCondition = "";
	
	public MaxSelector() {
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public MaxSelector setFieldName(String fieldName) {
		this.fieldName = fieldName;
		return this;
	}
	
	public MaxSelector setTableName(String tableName) {
		this.tableName = tableName;
		return this;
	}
	
	public MaxSelector setWhereCondition(String whereCondition) {
		this.whereCondition = whereCondition;
		return this;
	}
	
	public int query() throws SQLException {
		String sqlSelectMax = "SELECT MAX("+fieldName+") "
				+ "AS "+fieldName+ " FROM " +tableName + " " + whereCondition;
		
		PreparedStatement stmt = connection.prepareStatement(sqlSelectMax);
		ResultSet rs = stmt.executeQuery();
		if(rs.next()) {
			return rs.getInt(fieldName);
		}
		return 0;
		
	}
}
