package web_cardapio.br.com.bitbyte.factories;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import web_cardapio.br.com.bitbyte.typeadapter.ListAdapter;
import web_cardapio.br.com.bitbyte.typeadapter.StringAdapter;

public class GsonFactory {
	
	private static Gson gson;
	
	public static Gson getGson() {
		if(gson == null) {
			gson = new GsonBuilder()
					.registerTypeHierarchyAdapter(String.class, new StringAdapter())
					.registerTypeHierarchyAdapter(List.class, new ListAdapter())
					.create();
		}
		return gson;
	}

}
