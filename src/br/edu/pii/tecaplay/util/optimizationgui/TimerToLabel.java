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
    private String[] imagens = new String[22];//Vetor para carregar o diretório de cada imagem de fundo. 
    
   
    /**
     * 
     * @param delay inteiro que recebe o tempo de espera para alterar a imagem de fundo.
     * @param label	armazenará em qual label serão feitas as alterações.
     */
    public TimerToLabel(final int delay, final JLabel label) {
    	//variaveis locais recebendo as informações passadas por parâmetros
        this.delay = delay;
        this.label = label;
        //carregando o vetor.
        for(int i=1; i<= 21; i++){
        	imagens[i] = "resources\\images\\bdf\\"+i+".jpg";
        }
    }
    //método chamado na HomePage para iniciar o Timer
    public void init() {
        timer = new Timer(delay, this);
        timer.start();
    }
    //método que para o timer quando não for mais necessário a sua execução
    public void clse(){
    	timer.stop();
    }
    //método que carrega uma nova imagem de forma randomica a cada 10 seg. (depende de quanto foi definido o valor do delay)
    public void actionPerformed(final ActionEvent e) {
        label.setIcon(new ImageIcon(imagens[(int) ((int) 1 + Math.random()*21)]));
        //label.updateUI();
    }

}
