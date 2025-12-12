package web_cardapio;

import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.TrayIcon.MessageType;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.sql.SQLException;
import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.util.ResourceUtils;

import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;

import web_cardapio.br.com.bitbyte.dao.VersaoDao;
import web_cardapio.br.com.bitbyte.models.AppVersion;
import web_cardapio.br.com.bitbyte.scripts.ScriptsService;
import web_cardapio.br.com.bitbyte.services.QrCodeService;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class Startup {
	
	private static final String VERSION = "1.2.0";
	
	private static JFrame frame = new JFrame("Web Cardapio - " + VERSION);
	
	private static final Logger log = Logger.getLogger(Startup.class);
	
	
	public static void main(String[] args) throws Exception {
		SpringApplication.run(Startup.class, args);
		
		createFrame();
	}

	private static JFrame createFrame() 
	{
		frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 150);
        
        frame.setLayout(new FlowLayout());
        
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        
        Image img = getImg();
        frame.setIconImage(img);
        
        JLabel icon = new JLabel(new ImageIcon(img));
        frame.add(icon);
        
        JLabel label = new JLabel("Servidor Cardápio BBIFood executando...");
        frame.add(label);
        
        JButton closeButton = new JButton("Fechar");
        closeButton.addActionListener(e -> 
        {
        	closeEvent();
        });
        
        frame.add(closeButton);
        
        JButton qrButton = new JButton("Link Instalação");
        qrButton.addActionListener(e -> {
       
            try {
            	String ip = InetAddress.getLocalHost().getHostAddress();
            	int porta = 4041;
            	
            	log.info("PORTA: " +porta);
                String texto = "http://" +ip+ ":" +porta + "/web_cardapio/versao/cardapio"; // conteúdo do QR Code
                BitMatrix qrCode = new QrCodeService().gerarQrCode(texto);
                BufferedImage qrImage = MatrixToImageWriter.toBufferedImage(qrCode);
                
                ImageIcon iconQrCode = new ImageIcon(qrImage);
                JOptionPane.showMessageDialog(frame, null, "QR Code", JOptionPane.PLAIN_MESSAGE, iconQrCode);
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(frame, "Erro ao gerar QR Code: " + ex.getMessage());
            }
        });

        frame.add(qrButton);
        frame.setVisible(true);
        return frame;
	}
	
	private static int getServerPort() {
	    try (InputStream input = Startup.class.getClassLoader()
	            .getResourceAsStream("application.properties")) {
	        if (input == null) {
	            System.out.println("application.properties não encontrado");
	            return 4040; // default
	        }

	        Properties prop = new Properties();
	        prop.load(input);
	        String portStr = prop.getProperty("server.port");
	        return portStr != null ? Integer.parseInt(portStr) : 4040;
	    } catch (Exception e) {
	        e.printStackTrace();
	        return 4040;
	    }
	}
	
	private static Image getImg() {
        
        try {
			InputStream file = Startup.class.getResourceAsStream("/img/cardapio.png");
			Image img = ImageIO.read(file);
			
			img = img.getScaledInstance(40, 40,
		            Image.SCALE_SMOOTH);
			
			return img;
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	private static void closeEvent() {
		JPasswordField pf = createPasswordField();
    	int result = JOptionPane.showConfirmDialog(frame, 
    			pf, 
    			"Digite a senha", 
    			JOptionPane.OK_CANCEL_OPTION, 
    			JOptionPane.PLAIN_MESSAGE, 
    			new ImageIcon(getImg()));

    	
    	if(result != JOptionPane.OK_OPTION) {
    		return;
    	}
    	String password = new String(pf.getPassword());
    	if("adm%bbi".equals(password) || "bbifood".equals(password)) {
    		System.exit(0);
    	}else {
    		JOptionPane.showMessageDialog(frame, "Senha incorreta!");
    		closeEvent();
    	}
	}
	
	private static JPasswordField createPasswordField() {
		JPasswordField pf = new JPasswordField();
    	pf.addAncestorListener(new AncestorListener() {

			@Override
			public void ancestorAdded(AncestorEvent event) {
				// TODO Auto-generated method stub
				pf.requestFocus();
				
			}

			@Override
			public void ancestorRemoved(AncestorEvent event) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void ancestorMoved(AncestorEvent event) {
				// TODO Auto-generated method stub
				
			}
    		
    	});
    	return pf;
	}
}
