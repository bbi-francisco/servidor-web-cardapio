package web_cardapio.br.com.bitbyte.io;

import java.io.File;
import java.util.List;
import web_cardapio.br.com.bitbyte.utils.ListUtils;
import web_cardapio.br.com.bitbyte.utils.StringFormatterBuilder;
import web_cardapio.br.com.bitbyte.utils.StringUtils;

public class FileCreator
{
	private List<String> allowedFormats;
	private StringFormatterBuilder formatter;
	
	public FileCreator() {
		formatter = new StringFormatterBuilder();
	}
	
	public List<String> getAllowedFormats(){
		return ListUtils.getEmptyIfNull(allowedFormats);
	}
	
	public FileCreator setAllowedFormats(List<String> allowedFormats) {
		this.allowedFormats = allowedFormats;
		return this;
	}
	
	public File create(String path) 
	{
		File file = null;
		if(StringUtils.isNullOrEmpty(path)) {
			return file;
		}
		
		String formattedPath = formatter.toUpperCase()
				.trim()
				.build(path);
		
		for(String format : getAllowedFormats()) 
		{
			String formattedFormat = formatter
					.toUpperCase()
					.trim()
					.build(format);
			
			if(formattedPath.endsWith(formattedFormat)) {
				file = new File(path);
			}else {
				file = new File(path + "." +format);
			}
			
			if(file.exists()) {
				return file;
			}
		}
		return null;
	}
}