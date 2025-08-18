package web_cardapio.br.com.bitbyte.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.Collections;
import java.util.List;

public class ImageManager2 
{
	private List<String> allowedFormats = Arrays.asList("jpg", "png", "jpeg", "gif");
	
	public File getImageFromPath(String path) 
	{
		return new FileCreator()
				.setAllowedFormats(allowedFormats)
				.create(path);
	}
	
	public List<File> getAllImages(String path) {
		File directory = new File(path);
		if(!directory.exists()) {
			return Collections.emptyList();
		}
		List<File> files = new ArrayList<>();
		
		FileCreator fileCreator = new FileCreator()
				.setAllowedFormats(allowedFormats);
		
		File[] directoryFiles = directory.listFiles();
		for(File file : directoryFiles) 
		{
			files.add(fileCreator.create(file.getPath()));
		}
		return files;
	}
	
	public String getImageBase64(String path) {
		File file = getImageFromPath(path);
		try {
			return file != null ? fileToBase64(file) : "";
		} catch (IOException e) {
			return "";
		}
	}
	
	public String fileToBase64(File file) throws IOException {
        byte[] fileContent = Files.readAllBytes(file.toPath());
        return Base64.getEncoder().encodeToString(fileContent);
	}
	
	public byte[] fileToByteArray(File file) throws IOException {
		byte[] byteArray = new byte[(int) file.length()];
        try (FileInputStream inputStream = new FileInputStream(file)) {
            inputStream.read(byteArray);
        }
        return byteArray;
	}
	
//	public String fileToBase64(File file) throws IOException
//	{
//		BASE64Encoder encoder = new BASE64Encoder();
//		FileImageInputStream in = new FileImageInputStream(file);
//		int size = (int) in.length();
//		byte[] b = new byte[size];
//		in.read(b);
//		in.close();
//		ByteBuffer bb = ByteBuffer.wrap(b);
//		return encoder.encodeBuffer(bb);
//	}

}
