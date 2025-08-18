package web_cardapio.br.com.bitbyte.sql;

import java.util.Date;

/**
 * @version 1.0
 * @author Vitor Bonequini.
 */
public interface Cursor
{
	boolean next();
	
	void reset();
	
	int size();
	
	int getCurrentPosition();
	
	boolean hasField(String field);
	
	String findString(String field);
	
	int findInt(String field);
	
	long findLong(String field);
	
	double findDouble(String field);
	
	Date findDate(String field);
}
