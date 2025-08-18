//package br.com.bitbyte.io;
//
//import java.io.File;
//import java.io.IOException;
//import java.nio.file.Files;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.util.ArrayList;
//import java.util.Base64;
//import java.util.List;
//
//import org.apache.log4j.Logger;
//
//import br.com.bitbyte.connection.ConnectionFactory;
//import br.com.bitbyte.models.Imagem;
//
//public class ImageManager {
//	
//	private Connection connection;
//	private String diretorioImagens;
//	private Logger log;
//	
//	public static final String IMAGE_FILE = "image";
//	public static final File EMPTY_FILE = new File("");
//	
//	public static final String DIRETORIO_PRODUTOS = "produtos";
//	public static final String DIRETORIO_SUBGRUPOS = "subgrupos";
//	public static final String DIRETORIO_GRUPOS = "grupos";
//	public static final String DIRETORIO_ESTABELECIMENTO = "estabelecimento";
//	
//	public ImageManager() {
//		this.connection = new ConnectionFactory().getConnection();
//		this.diretorioImagens = selectImagePath();
//		this.log = Logger.getLogger(ImageManager.class);
//	}
//	
//	public String selectImagePath() {
//		try {
//			
//			String sql = 
//					" SELECT valor "+ 
//					" FROM tbparametro "+ 
//					" WHERE parametro = 'DIRETORIO_IMAGENS'"; 
//			
//			PreparedStatement pst = connection.prepareStatement(sql);
//			ResultSet rs = pst.executeQuery();
//			
//			if(rs.next()) {
//				return rs.getString("valor");
//			}					
//		
//		} catch (Exception e) {
//			e.printStackTrace();
//			return "";
//		}
//		return "";
//	}
//	
//	/**
//	 * Busca imagem com base em um subdiretorio no diretorio principal de imagens e o nome da imagem
//	 * @param subDiretorio - diretorio dentro do diretorio principal
//	 * @param nomeImagem - nome da imagem a ser buscada 
//	 * @return o aquivo de imagem em formato texto
//	 * @throws Exception
//	 */
//	public String getImgBase64(String subDiretorio, Object nomeImagem) throws Exception {
//		String filePath = diretorioImagens + "\\" +subDiretorio+ "\\" + nomeImagem;
//		try 
//		{
//			return createFileBase64(filePath);
//		}catch(Exception e) 
//		{
//			log.error(e);
//			throw new Exception("Erro ao carregar imagens do caminho: " +filePath + ". Erro: " +e);
//		}
//	}
//	
//	public List<Imagem> getAllImages(String subDiretorio) {
//		File directory;
//		String arquivo = diretorioImagens + "\\" + subDiretorio;
//		List<Imagem> lstImages = new ArrayList<>();
//		try {
//			directory = new File(arquivo);
//			for(File file : directory.listFiles()) {
//				if(file.getAbsolutePath().endsWith(".jpg") || 
//						file.getAbsolutePath().endsWith(".png")
//						|| file.getAbsolutePath().endsWith(".jpeg")) {
//					Imagem imagem = new Imagem(fileToBase64(file), file.getName());
//					lstImages.add(imagem);
//				}
//			}
//		}catch(Exception e) {
//			String message = "Erro ao carregar imagens do caminho: " +arquivo + " ";
//			log.error(message + e);
//		}
//		return lstImages;
//	}
//	
//	/**
//	 * Busca imagem pelo nome no diretorio principal de imagens
//	 * @param nomeImagem - sera utilizado para encontrar o arquivo
//	 * @return o aquivo de imagem em formato texto
//	 * @throws Exception-
//	 */
//	public String getImgBase64(String nomeImagem) throws Exception {
//		String filePath = diretorioImagens + "\\" +nomeImagem;
//		try {
//			return createFileBase64(filePath);
//		}catch(Exception e) {
//			log.error(e);
//			throw new Exception("Erro ao carregar imagens do caminho: " +filePath + ". Erro: " +e);
//		}
//		
//	}
//	
//	private String createFileBase64(String filePath) throws Exception {
//		File i = createImage(filePath);
//		if(i != null) {
//			return fileToBase64(i);
//		}else {
//			return "";
//		}
//	}
//	
//	private File createImage(String filePath) {
//		File file;
//		if(endsWithImageFormat(filePath))
//		{
//			file = new File(filePath);
//		}
//		else {
//			file = createImageCheckingIfExists(filePath);
//		}
//		return file;
//	}
//	
//	private File createImageCheckingIfExists(String filePath) {
//		String [] imageFormats = {".jpg", ".jpeg", ".png" };
//		for(String format : imageFormats) 
//		{
//			File file = new File(filePath + format);
//			if(file.exists()) {
//				log.info("IMAGEM CARREGADA. PATH: " +file.getPath());
//				return file;
//			}
//				
//		}
//		return null;
//	}
//	
//	private boolean endsWithImageFormat(String filePath) {
//		return filePath.endsWith(".png") || filePath.endsWith(".jpg") || filePath.endsWith(".jpeg");
//	}
//	
//	public File getImage(String subDiretorio, String nomeImagem) {
//		String filePath = diretorioImagens + "\\" +subDiretorio+ "\\" + nomeImagem;
//		return createImage(filePath);
//	}
//	
//	public File getImage(String nomeImagem) {
//		String filePath = diretorioImagens + "\\" + nomeImagem;
//		return createImage(filePath);
//	}
//	
//	public String fileToBase64(File file) throws IOException {
//        byte[] fileContent = Files.readAllBytes(file.toPath());
//        return Base64.getEncoder().encodeToString(fileContent);
//	}
//	
////	public String fileToBase64(File file) throws Exception
////	{
////		BASE64Encoder encoder = new BASE64Encoder();
////		FileImageInputStream in = new FileImageInputStream(file);
////		int size = (int) in.length();
////		byte[] b = new byte[size];
////		in.read(b);
////		in.close();
////		ByteBuffer bb = ByteBuffer.wrap(b);
////
////		return encoder.encodeBuffer(bb);
////	}
//
//	
//	public boolean isImage(File file) {
//		return true;
////		String mimetype= new MimetypesFileTypeMap().getContentType(file);
////		String type = mimetype.split("/")[0];
////		return type.equals(IMAGE_FILE);
//	}
//
//}
