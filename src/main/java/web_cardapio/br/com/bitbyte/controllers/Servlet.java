//package web_cardapio.br.com.bitbyte.controllers;
//
//import java.sql.SQLException;
//
//
//import org.apache.log4j.Logger;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import jakarta.servlet.http.HttpServlet;
//import web_cardapio.br.com.bitbyte.dao.ProdutoDao;
//import web_cardapio.br.com.bitbyte.dao.SubGrupoDao;
//import web_cardapio.br.com.bitbyte.models.SubGrupo;
//import java.util.List;
//
//public final class Servlet extends HttpServlet
//{
//	private static final long serialVersionUID = 1L;
//	private static boolean cacheProdutosLoaded = false;
//	private Logger log = Logger.getLogger(Servlet.class);
//	
//	@Autowired
//	private ProdutoDao produtoDao;
//	
//	@Autowired
//	private SubGrupoDao subgrupoDao;
//	
//	public Servlet()
//	{
//		
//		if(!cacheProdutosLoaded)
//		{
//			try {
//				produtoDao.getProdutos();
//				
//				List<SubGrupo> subgrupos = subgrupoDao.getSubGrupos();
//				System.out.println(subgrupos);
//				cacheProdutosLoaded = true;
//				log.info("Product cache initialized successfully.");
//			} catch (SQLException e) {
//				log.error("Product cached failed to initialize. " +e);
//			}
//			
//		}
//	}
//	
//}