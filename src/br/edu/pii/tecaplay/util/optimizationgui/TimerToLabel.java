package br.edu.pii.tecaplay.util.optimizationgui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.Timer;
/**
 * 
 * @author Marcelo
 *
 */
public class TimerToLabel implements ActionListener {
	private Timer timer;
    private final JLabel label;
    private final int delay;
    private String[] imagens = new String[22];//Vetor para carregar o diret�rio de cada imagem de fundo. 
    
   
    /**
     * 
     * @param delay inteiro que recebe o tempo de espera para alterar a imagem de fundo.
     * @param label	armazenar� em qual label ser�o feitas as altera��es.
     */
    public TimerToLabel(final int delay, final JLabel label) {
    	//variaveis locais recebendo as informa��es passadas por par�metros
        this.delay = delay;
        this.label = label;
        //carregando o vetor.
        for(int i=1; i<= 21; i++){
        	imagens[i] = "resources\\images\\bdf\\"+i+".jpg";
        }
    }
    //m�todo chamado na HomePage para iniciar o Timer
    public void init() {
        timer = new Timer(delay, this);
        timer.start();
    }
    //m�todo que para o timer quando n�o for mais necess�rio a sua execu��o
    public void clse(){
    	timer.stop();
    }
    //m�todo que carrega uma nova imagem de forma randomica a cada 10 seg. (depende de quanto foi definido o valor do delay)
    public void actionPerformed(final ActionEvent e) {
        label.setIcon(new ImageIcon(imagens[(int) ((int) 1 + Math.random()*21)]));
        //label.updateUI();
    }

}
