package br.edu.pii.tecaplay.player;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JSlider;

import uk.co.caprica.vlcj.component.EmbeddedMediaPlayerComponent;
import uk.co.caprica.vlcj.player.embedded.EmbeddedMediaPlayer;

public class PlayerButtonEvents {
	
	private static int logoPlay = 0;
	
	public static void pauseButton(JButton pause, EmbeddedMediaPlayerComponent mediaPlayerComponent){
		mediaPlayerComponent.getMediaPlayer().pause();
        if(logoPlay==0){
        	pause.setIcon(new ImageIcon("resources\\images\\playButton.png"));
        	logoPlay = 1;
        }else{
        	pause.setIcon(new ImageIcon("resources\\images\\pauseButton.png"));
        	logoPlay = 0;
        }	
	}
	
	public static void volumeSlider(JSlider slider, EmbeddedMediaPlayerComponent mediaPlayerComponent){
		mediaPlayerComponent.getMediaPlayer().setVolume(slider.getValue());
	}
	
	public static void timeSlider(JSlider slider, EmbeddedMediaPlayerComponent mediaPlayerComponent){
		slider.setMaximum((int)mediaPlayerComponent.getMediaPlayer().getLength());
		mediaPlayerComponent.getMediaPlayer().setTime(slider.getValue());
	}
	
	public static void rewindButton(JButton rewind, EmbeddedMediaPlayerComponent mediaPlayerComponent){
		mediaPlayerComponent.getMediaPlayer().skip(-5000);
	}
	
	public static void skipButton(JButton rewind, EmbeddedMediaPlayerComponent mediaPlayerComponent){
		mediaPlayerComponent.getMediaPlayer().skip(5000);
	}	

	public static void muteButton(JButton muteButton, EmbeddedMediaPlayerComponent mediaPlayerComponent){
		boolean muted = mediaPlayerComponent.getMediaPlayer().mute();
		if(muted){
			muteButton.setIcon(new ImageIcon("resources\\images\\mute.png"));
		}else{
			muteButton.setIcon(new ImageIcon("resources\\images\\noMute.png"));
		}
	}
	
	public static void fullSreen(JButton fullScreenButton, EmbeddedMediaPlayerComponent mediaPlayerComponent, EmbeddedMediaPlayer mediaPlayer){
		mediaPlayer.toggleFullScreen();
		boolean realy = mediaPlayer.isFullScreen();
		if(realy){
			fullScreenButton.setIcon(new ImageIcon("resources\\images\\exitFull.png"));
		}else{
			fullScreenButton.setIcon(new ImageIcon("resources\\images\\togleFull.png"));
		}
	}
}
