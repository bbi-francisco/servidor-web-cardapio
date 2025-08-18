package web_cardapio.br.com.bitbyte.format;

import java.util.Iterator;
import java.util.List;

public class SeparatorFormatter {
	
	private String separator = "|";
	private boolean appendLast;
	
	public String format(List<?> values) {
		StringBuilder sb = new StringBuilder();
		Iterator<?> iterator =  values.iterator();
		while(iterator.hasNext())
		{
			Object obj = iterator.next();
			sb.append(obj);
			if(iterator.hasNext())
				sb.append(separator);
		}
		if(appendLast) {
			sb.append(separator);
		}
		return sb.toString();
	}
	
	public SeparatorFormatter appendLast(boolean appendLast) {
		this.appendLast = appendLast;
		return this;
	}
	
	public SeparatorFormatter setSeparator(String separator) {
		this.separator = separator;
		return this;
	}

}
