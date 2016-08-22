package br.edu.pii.tecaplay.ui;

import java.awt.*;
import javax.swing.*;
/**
 * 
 * Splash Screen when starting TecaPlay
 *
 * @author Jonas
 */
public class SplashScreen extends JWindow {
    
  
	private static final long serialVersionUID = 1L;
	private int duration;
    /**
     * 
     * @param d  miliseconds how to run splash.
     */
    public SplashScreen(int d) {
        duration = d;
    }
  
    public void showSplash() {        
        JPanel content = (JPanel)getContentPane();
        content.setBackground(Color.white);
        int width = 400;
        int height =250;
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screen.width-width)/2;
        int y = (screen.height-height)/2;
        setBounds(x,y,width,height);
        JLabel label = new JLabel(new ImageIcon("resources\\images\\imgSplashScreen.jpg"));
        content.add(label, BorderLayout.CENTER);
        content.setBorder(BorderFactory.createLineBorder(new Color(00, 0, 0), 5));        
        setVisible(true);
        try { Thread.sleep(duration); } catch (Exception e) {}        
        setVisible(false);  
    }
 
    public void showSplashAndExit() {        
        showSplash();
        this.dispose();
        LoginGUI iniciar = new LoginGUI();
        iniciar.executa();
    }
 
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {   
        SplashScreen splash = new SplashScreen(200);
        /**
         * Set LookAndFeel.
         */
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        splash.showSplashAndExit();        
    }
   
}