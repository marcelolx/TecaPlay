package br.edu.pii.tecaplay.player;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JSlider;

import uk.co.caprica.vlcj.component.EmbeddedMediaPlayerComponent;
import uk.co.caprica.vlcj.medialist.MediaList;
import uk.co.caprica.vlcj.player.embedded.EmbeddedMediaPlayer;
import uk.co.caprica.vlcj.player.list.MediaListPlayer;
/**
 * @class PlayerButtonEvents 
 * 		Cont�m as a��es de cada componente dos players de v�deo e m�sica.
 * 
 * @author Marcelo
 *
 */
public class PlayerButtonEvents {
	/**
	 * Instancia booleana para trocar de .png's.
	 */
	private static boolean logoPlay = false;
	/**
	 * A��o do componente Pauser/Executar.
	 * 
	 * @param pause
	 * @param mediaPlayerComponent	
	 */
	public static void pauseButton(JButton pause, EmbeddedMediaPlayerComponent mediaPlayerComponent) {
		mediaPlayerComponent.getMediaPlayer().pause();
		if (logoPlay == false) {
			pause.setIcon(new ImageIcon("resources\\images\\playButton.png"));
			logoPlay = true;
		} else {
			pause.setIcon(new ImageIcon("resources\\images\\pauseButton.png"));
			logoPlay = false;
		}
	}
	/**
	 * A��o do componente de volume.
	 * 
	 * @param slider
	 * @param mediaPlayerComponent	
	 */
	public static void volumeSlider(JSlider slider, EmbeddedMediaPlayerComponent mediaPlayerComponent) {
		mediaPlayerComponent.getMediaPlayer().setVolume(slider.getValue());
	}
	/**
	 * A��o do componente de tempo em execu��o.
	 * 
	 * @param slider
	 * @param mediaPlayerComponent
	 * 		Passa o componente media player, necess�rio para recuperar o 
	 * 		MediaPlayer e uma a��o atrelada a ele.
	 */
	public static void timeSlider(JSlider slider, EmbeddedMediaPlayerComponent mediaPlayerComponent) {
		slider.setMaximum((int) mediaPlayerComponent.getMediaPlayer().getLength());
		mediaPlayerComponent.getMediaPlayer().setTime(slider.getValue());
	}
	/**
	 * A��o do componente de voltar no tempo de execu��o.
	 * 
	 * @param mediaPlayerComponent
	 */
	public static void rewindButton(EmbeddedMediaPlayerComponent mediaPlayerComponent) {
		mediaPlayerComponent.getMediaPlayer().skip(-5000);
	}
	
	/**
	 * A��o do componente avan�ar no tempo de execu��o.
	 * 
	 * @param mediaPlayerComponent
	 */
	public static void skipButton(EmbeddedMediaPlayerComponent mediaPlayerComponent) {
		mediaPlayerComponent.getMediaPlayer().skip(5000);
	}

	/**
	 * A��o do componente mutar volume.
	 * 
	 * @param muteButton Bot�o mutar.
	 * @param mediaPlayerComponent
	 */
	public static void muteButton(JButton muteButton, EmbeddedMediaPlayerComponent mediaPlayerComponent) {
		boolean muted = mediaPlayerComponent.getMediaPlayer().mute();
		if (muted) {
			muteButton.setIcon(new ImageIcon("resources\\images\\mute.png"));
		} else {
			muteButton.setIcon(new ImageIcon("resources\\images\\noMute.png"));
		}
	}

	/**
	 * A��o do componente de fullScreen ao ser clicado.
	 * 
	 * @param fullScreenButton	
	 * @param mediaPlayer
	 */
	public static void fullSreen(JButton fullScreenButton,	EmbeddedMediaPlayer mediaPlayer) {
		mediaPlayer.toggleFullScreen();
		boolean realy = mediaPlayer.isFullScreen();
		if (realy) {
			fullScreenButton.setIcon(new ImageIcon("resources\\images\\exitFull.png"));
		} else {
			fullScreenButton.setIcon(new ImageIcon("resources\\images\\togleFull.png"));
		}
	}

	/**
	 * A��o do componente pausar do player de m�sica.
	 * 
	 * @param pause
	 * @param mediaListPlayer	
	 */
	public static void pauseButton(JButton pause, MediaListPlayer mediaListPlayer) {
		if (mediaListPlayer.isPlaying()) {
			mediaListPlayer.pause();
			pause.setIcon(new ImageIcon("resources\\images\\playButton.png"));
		} else {
			mediaListPlayer.play();
			pause.setIcon(new ImageIcon("resources\\images\\pauseButton.png"));
		}
	}
	
	/**
	 * A��o componente pr�ximo do player de m�sica.
	 * @param mediaListPlayer 
	 */
	public static void nextButton(MediaListPlayer mediaListPlayer) {
		mediaListPlayer.playNext();
	}
	
	/**
	 * A��o do componente voltar do player de m�sica.
	 * @param mediaListPlayer
	 */
	public static void previousButton(MediaListPlayer mediaListPlayer) {
		mediaListPlayer.playPrevious();
	}
	
	/**
	 * A��o do componente mutar volume do player de m�sica.
	 * 
	 * @param muteButton
	 * @param mediaPlayer
	 */
	public static void muteButton(JButton muteButton, EmbeddedMediaPlayer mediaPlayer) {
		if (mediaPlayer.isMute()) {
			mediaPlayer.mute(false);
			muteButton.setIcon(new ImageIcon("resources\\images\\noMute.png"));
		} else {
			mediaPlayer.mute(true);
			muteButton.setIcon(new ImageIcon("resources\\images\\mute.png"));
		}
	}
	
	/**
	 * A��o do componente volume do player de m�sica.
	 * 
	 * @param slider
	 * @param mediaPlayer
	 */
	public static void volumeSlider(JSlider slider, EmbeddedMediaPlayer mediaPlayer) {
		mediaPlayer.setVolume(slider.getValue());
	}
	
	/**
	 * M�todo que interrompe a execu��o do player de m�sica, e desativa todos os bot�es do player.
	 * 
	 * @param mediaPlayer 
	 * @param mediaListPlayer 
	 * @param mediaList 
	 * @param pauseButton 
	 * @param nextButton 
	 * @param previousButton 
	 * @param releaseListButton 
	 * @param muteButton 
	 * @param volumeSlider 
	 * @param actualMusicName 
	 */
	public static void releasePlayer(EmbeddedMediaPlayer mediaPlayer, MediaListPlayer mediaListPlayer, 
			MediaList mediaList, JButton pauseButton, JButton nextButton, JButton previousButton, 
			JButton releaseListButton, JButton muteButton, JSlider volumeSlider, JLabel actualMusicName) {
		mediaPlayer.stop();
		mediaListPlayer.release();
		mediaList.clear();
		pauseButton.setEnabled(false);
		nextButton.setEnabled(false);
		previousButton.setEnabled(false);
		releaseListButton.setEnabled(false);
		muteButton.setEnabled(false);
		volumeSlider.setEnabled(false);
		actualMusicName.setText("");
	}
}
