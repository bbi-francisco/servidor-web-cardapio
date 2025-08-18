package web_cardapio.br.com.bitbyte.typeadapter;

import java.lang.reflect.Type;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class ListAdapter implements JsonSerializer<List<?>>
{

	@Override
	public JsonElement serialize(List<?> src, Type typeOfSrc, JsonSerializationContext context) {
		if(src == null || src.isEmpty()) {
			return null;
		}
		
		JsonArray array = new JsonArray();

	    for (Object child : src) 
	    {
	    	if(child == null || !shouldSerializeString(child))
	    		continue;
	    	
    		JsonElement element = context.serialize(child);
  	      	array.add(element);
	    }

	    return array;
	}
	
	private boolean shouldSerializeString(Object obj) {
		return !(obj instanceof String) || obj instanceof String && !((String) obj).isEmpty();
	}
	
}
