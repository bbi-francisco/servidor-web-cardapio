package web_cardapio.br.com.bitbyte.utils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapAddHelper<T, O> {
	
	private ResultSet rs;
	private Map<T, List<O>> map = new HashMap<>();
	private T lastCodigoItem;
	private List<O> list = new ArrayList<>();
	
	public MapAddHelper(ResultSet rs) {
		this.rs = rs;
	}
	
	public MapAddHelper<T, O> addToMap(T codigoItem, O object) throws SQLException {
		
		if(rs.isFirst()) {
			lastCodigoItem = codigoItem;
		}
		
		if(lastCodigoItem.equals(codigoItem)) {
			list.add(object);
		}else{
			map.put(lastCodigoItem, list);
			list = new ArrayList<>();
			list.add(object);
			lastCodigoItem = codigoItem;
		}
		
		if(rs.isLast()){
			map.put(codigoItem, list);
		}
		
		return this;
	}
	
	public Map<T, List<O>> getMap(){
		return map != null ? map : new HashMap<>();
	}
}