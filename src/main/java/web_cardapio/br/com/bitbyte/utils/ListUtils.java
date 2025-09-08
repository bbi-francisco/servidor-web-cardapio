package web_cardapio.br.com.bitbyte.utils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import web_cardapio.br.com.bitbyte.models.bbifood.ItemBBIFood;

public class ListUtils {
	
	public static <T> List<T> getEmptyIfNull(List<T> list){
		return list != null ? list : new ArrayList<>();
	}
	
	public static boolean hasItens(Collection<?> collection) {
		return !isNullOrEmpty(collection);
	}
	
	public static boolean isNullOrEmpty(Collection<?> collection) {
		return collection == null || collection.isEmpty();
	}

	public static int size(List<?> sabores) {
		return getEmptyIfNull(sabores).size();
	}

}
