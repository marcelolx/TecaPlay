package br.edu.pii.tecaplay.player;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import uk.co.caprica.vlcj.component.EmbeddedMediaPlayerComponent;
import uk.co.caprica.vlcj.player.embedded.EmbeddedMediaPlayer;

public class PlayerButtonEvents {
	
	private static int logoPlay = 0;
	
	public static void pauseButton(JButton pause, EmbeddedMediaPlayerComponent mediaPlayerComponent){
		pause.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				mediaPlayerComponent.getMediaPlayer().pause();
                if(logoPlay==0){
                	pause.setIcon(new ImageIcon("resources\\images\\playButton.png"));
                	logoPlay = 1;
                }else{
                	pause.setIcon(new ImageIcon("resources\\images\\pauseButton.png"));
                	logoPlay = 0;
                }	
			}
		});
	}
	
	public static void volumeSlider(JSlider slider, EmbeddedMediaPlayerComponent mediaPlayerComponent){
		slider.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				mediaPlayerComponent.getMediaPlayer().setVolume(slider.getValue());
				
			}
		});
	}
	
	public static void timeSlider(JSlider slider, EmbeddedMediaPlayerComponent mediaPlayerComponent){
		slider.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				slider.setMaximum((int)mediaPlayerComponent.getMediaPlayer().getLength());
				mediaPlayerComponent.getMediaPlayer().setTime(slider.getValue());
			
				
			}
		});
	}
	
	public static void rewindButton(JButton rewind, EmbeddedMediaPlayerComponent mediaPlayerComponent){
		rewind.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				mediaPlayerComponent.getMediaPlayer().skip(-5000);
			}
		});
	}
	
	public static void skipButton(JButton rewind, EmbeddedMediaPlayerComponent mediaPlayerComponent){
		rewind.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				 mediaPlayerComponent.getMediaPlayer().skip(5000);
			}
		});
	}	

	public static void muteButton(JButton muteButton, EmbeddedMediaPlayerComponent mediaPlayerComponent){
		muteButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				boolean muted = mediaPlayerComponent.getMediaPlayer().mute();
				if(muted){
					muteButton.setIcon(new ImageIcon("resources\\images\\mute.png"));
				}else{
					muteButton.setIcon(new ImageIcon("resources\\images\\noMute.png"));
				}
			}
		});
	}
	
	public static void fullSreen(JButton fullScreenButton, EmbeddedMediaPlayerComponent mediaPlayerComponent, EmbeddedMediaPlayer mediaPlayer){
		fullScreenButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				mediaPlayer.toggleFullScreen();
				boolean realy = mediaPlayer.isFullScreen();
				if(realy){
					fullScreenButton.setIcon(new ImageIcon("resources\\images\\exitFull.png"));
				}else{
					fullScreenButton.setIcon(new ImageIcon("resources\\images\\togleFull.png"));
				}
			}
		});
	}
}
