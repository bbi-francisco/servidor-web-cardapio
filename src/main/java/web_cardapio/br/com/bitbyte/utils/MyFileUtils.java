package web_cardapio.br.com.bitbyte.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Base64;



public class MyFileUtils {
	
	public static String encodeFileToBase64(String path) throws IOException {
		try {
	        byte[] fileContent = Files.readAllBytes(new File(path).toPath());
	        return Base64.getEncoder().encodeToString(fileContent);
	    } catch (IOException e) {
	        throw new IllegalStateException("could not read file " + path);
	    }
	}
	
	public static String encodeFileToBase64(File file) throws IOException {
		return encodeFileToBase64(file.getPath());
	}

}
