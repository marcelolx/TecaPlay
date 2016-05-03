package br.edu.pii.tecaplay.ui;

import java.awt.*;
import javax.swing.*;

public class SplashScreen extends JWindow {
    
    /**
     * @author jonas
     * @since 03/05/2016
	 * @version 0.0.54
	 */
	private static final long serialVersionUID = 1L;
	private int duration;
    /**
     * 
     * @param d  = informa os milessegundos que é enviado pela classe main
     */
    public SplashScreen(int d) {
        duration = d;
    }
    
// Este é um método simples para mostrar uma tela de apresentção
// no centro da tela durante a quantidade de tempo passada no construtor
    /**
     * content = define o Jpanel a ser apresentado
     * widht, height, x, y = pega a largura, altura, posição x, y respectivamente e acresenta no set bounds
     */
    public void showSplash() {        
        JPanel content = (JPanel)getContentPane();
        content.setBackground(Color.white);
        
        // Configura a posição e o tamanho da janela
        int width = 400;
        int height =250;
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screen.width-width)/2;
        int y = (screen.height-height)/2;
        setBounds(x,y,width,height);
        // Constrói o splash screen
        JLabel label = new JLabel(new ImageIcon("resources\\images\\imgSplashScreen.jpg"));
        content.add(label, BorderLayout.CENTER);
        content.setBorder(BorderFactory.createLineBorder(new Color(00, 0, 0), 5));        
        // Torna visível
        setVisible(true);
        
        // Espera ate que os recursos estejam carregados
        try { Thread.sleep(duration); } catch (Exception e) {}        
        setVisible(false);  
    }
    /**
     * @param iniciar = informa o chamamento da classe LoginGUI para apresentar a tela de login
     */
    public void showSplashAndExit() {        
        showSplash();
        this.dispose();
        LoginGUI iniciar = new LoginGUI();
        iniciar.executa();
    }
    /**
     * @param args =
     */
    public static void main(String[] args) {        
        // Mostra uma imagem com o título da aplicação, envia os milessimos SplashScreen
        SplashScreen splash = new SplashScreen(2700);
        splash.showSplashAndExit();        
    }
   
}