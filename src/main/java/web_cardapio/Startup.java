package web_cardapio;

import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.util.ResourceUtils;

@SpringBootApplication
public class Startup {
	
	private static final String VERSION = "1.0.7";
	
	static JFrame frame = new JFrame("Web Cardapio - " + VERSION);
	
	public static void main(String[] args) throws Exception {
		SpringApplication.run(Startup.class, args);
		createFrame();
	}

	private static JFrame createFrame() {
		
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
        frame.setVisible(true);
        return frame;
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
