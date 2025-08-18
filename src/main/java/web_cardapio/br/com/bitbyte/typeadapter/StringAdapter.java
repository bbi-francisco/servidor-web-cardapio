package web_cardapio.br.com.bitbyte.typeadapter;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class StringAdapter implements JsonSerializer<String>
{

	@Override
	public JsonElement serialize(String src, java.lang.reflect.Type typeOfSrc, JsonSerializationContext context) {
		if(src == null || src.isEmpty()) {
			return null;
		}
		return new JsonPrimitive(src);
	} 
	
}