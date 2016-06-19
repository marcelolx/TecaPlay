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
	private static int logoPlay = 0;
	/**
	 * A��o do componente Pauser/Executar.
	 * 
	 * @param pause Passa o JButton que foi clicado.
	 * @param mediaPlayerComponent	
	 * 		Passa o componente media player, necess�rio para recuperar o 
	 * 		MediaPlayer e uma a��o atrelada a ele.
	 */
	public static void pauseButton(JButton pause, EmbeddedMediaPlayerComponent mediaPlayerComponent) {
		mediaPlayerComponent.getMediaPlayer().pause();
		if (logoPlay == 0) {
			pause.setIcon(new ImageIcon("resources\\images\\playButton.png"));
			logoPlay = 1;
		} else {
			pause.setIcon(new ImageIcon("resources\\images\\pauseButton.png"));
			logoPlay = 0;
		}
	}
	/**
	 * A��o do componente de volume.
	 * 
	 * @param slider Slider que foi alterado de posi��o.
	 * @param mediaPlayerComponent	
	 * 		Passa o componente media player, necess�rio para recuperar o 
	 * 		MediaPlayer e uma a��o atrelada a ele.
	 */
	public static void volumeSlider(JSlider slider, EmbeddedMediaPlayerComponent mediaPlayerComponent) {
		mediaPlayerComponent.getMediaPlayer().setVolume(slider.getValue());
	}
	/**
	 * A��o do componente de tempo em execu��o.
	 * 
	 * @param slider Slider que foi alterado de posi��o
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
	 * 		Passa o componente media player, necess�rio para recuperar o 
	 * 		MediaPlayer e uma a��o atrelada a ele.
	 */
	public static void rewindButton(EmbeddedMediaPlayerComponent mediaPlayerComponent) {
		mediaPlayerComponent.getMediaPlayer().skip(-5000);
	}
	
	/**
	 * A��o do componente avan�ar no tempo de execu��o.
	 * 
	 * @param mediaPlayerComponent
	 * 		Passa o componente media player, necess�rio para recuperar o 
	 * 		MediaPlayer e uma a��o atrelada a ele.
	 */
	public static void skipButton(EmbeddedMediaPlayerComponent mediaPlayerComponent) {
		mediaPlayerComponent.getMediaPlayer().skip(5000);
	}

	/**
	 * A��o do componente mutar volume.
	 * 
	 * @param muteButton Bot�o mutar.
	 * @param mediaPlayerComponent
	 * 		Passa o componente media player, necess�rio para recuperar o 
	 * 		MediaPlayer e uma a��o atrelada a ele.
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
	 * @param fullScreenButton	Bot�o fullScreen.
	 * @param mediaPlayer	EmbeddedMediaPlayer para mudar entre fullScreen ou n�o.
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
	 * @param pause	Componente pausar.
	 * @param mediaListPlayer Player de m�sica.	
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
	 * @param mediaListPlayer Player de m�sica.
	 */
	public static void nextButton(MediaListPlayer mediaListPlayer) {
		mediaListPlayer.playNext();
	}
	
	/**
	 * A��o do componente voltar do player de m�sica.
	 * @param mediaListPlayer Player de m�sica.
	 */
	public static void previousButton(MediaListPlayer mediaListPlayer) {
		mediaListPlayer.playPrevious();
	}
	
	/**
	 * A��o do componente mutar volume do player de m�sica.
	 * 
	 * @param muteButton Componente mutar do player.
	 * @param mediaPlayer	Player de m�sica.
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
	 * @param slider Componente volume do player.
	 * @param mediaPlayer Player de m�sica.
	 */
	public static void volumeSlider(JSlider slider, EmbeddedMediaPlayer mediaPlayer) {
		mediaPlayer.setVolume(slider.getValue());
	}
	
	/**
	 * M�todo que interrompe a execu��o do player de m�sica, e desativa todos os bot�es do player.
	 * 
	 * @param mediaPlayer Player de m�sica.
	 * @param mediaListPlayer Player com uma mediaList.
	 * @param mediaList Lista com as m�sica em execu��o.
	 * @param pauseButton Componente pausar m�sica.
	 * @param nextButton Componente pr�xima m�sica.
	 * @param previousButton Componente voltar m�sica.
	 * @param releaseListButton Componente "fechar" player.
	 * @param muteButton Componente mutar musica.
	 * @param volumeSlider Componente volume da m�sica. 
	 * @param actualMusicName Componente que exibe o nome da m�sica.
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
