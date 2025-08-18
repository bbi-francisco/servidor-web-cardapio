package web_cardapio.br.com.bitbyte.frames;

import javax.swing.JOptionPane;

public class Dialog {
  
    // main class 
    public void show()
    { 
    	Object[] options = { "OK", "CANCELAR" };
        int escolha = JOptionPane.showOptionDialog(null, "Deseja atualizar?", "Nova atualização",
            JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
                null, options, options[0]);
        
        System.out.println("escolha: "+ escolha);
    } 

}
