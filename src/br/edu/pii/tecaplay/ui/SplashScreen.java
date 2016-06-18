package br.edu.pii.tecaplay.ui;

import java.awt.*;
import javax.swing.*;
/**
 * 
 * Splash Screen para carregar o sistema.
 *
 */
public class SplashScreen extends JWindow {
    
  
	private static final long serialVersionUID = 1L;
	private int duration;
    /**
     * 
     * @param d  = informa os milessegundos que � enviado pela classe main
     */
    public SplashScreen(int d) {
        duration = d;
    }
    
// Este � um m�todo simples para mostrar uma tela de apresent��o
// no centro da tela durante a quantidade de tempo passada no construtor
  
    public void showSplash() {        
        JPanel content = (JPanel)getContentPane();
        content.setBackground(Color.white);
        
        // Configura a posi��o e o tamanho da janela
        int width = 400;
        int height =250;
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screen.width-width)/2;
        int y = (screen.height-height)/2;
        setBounds(x,y,width,height);
        // Constr�i o splash screen
        JLabel label = new JLabel(new ImageIcon("resources\\images\\imgSplashScreen.jpg"));
        content.add(label, BorderLayout.CENTER);
        content.setBorder(BorderFactory.createLineBorder(new Color(00, 0, 0), 5));        
        // Torna vis�vel
        setVisible(true);
        
        // Espera ate que os recursos estejam carregados
        try { Thread.sleep(duration); } catch (Exception e) {}        
        setVisible(false);  
    }
 
    public void showSplashAndExit() {        
        showSplash();
        this.dispose();
        LoginGUI iniciar = new LoginGUI();
        iniciar.executa();
    }
 
    public static void main(String[] args) {   
        // Mostra uma imagem com o t�tulo da aplica��o, envia os milessimos SplashScreen
        SplashScreen splash = new SplashScreen(200);
        /**
         * Faz o setamento do look and feel
         */
        try {

        	UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

        } 
        catch (Exception e) {
           // handle exception
        }
        splash.showSplashAndExit();        
    }
   
}