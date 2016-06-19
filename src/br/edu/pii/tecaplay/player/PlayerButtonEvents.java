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
 * 		Contém as ações de cada componente dos players de vídeo e música.
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
	 * Ação do componente Pauser/Executar.
	 * 
	 * @param pause Passa o JButton que foi clicado.
	 * @param mediaPlayerComponent	
	 * 		Passa o componente media player, necessário para recuperar o 
	 * 		MediaPlayer e uma ação atrelada a ele.
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
	 * Ação do componente de volume.
	 * 
	 * @param slider Slider que foi alterado de posição.
	 * @param mediaPlayerComponent	
	 * 		Passa o componente media player, necessário para recuperar o 
	 * 		MediaPlayer e uma ação atrelada a ele.
	 */
	public static void volumeSlider(JSlider slider, EmbeddedMediaPlayerComponent mediaPlayerComponent) {
		mediaPlayerComponent.getMediaPlayer().setVolume(slider.getValue());
	}
	/**
	 * Ação do componente de tempo em execução.
	 * 
	 * @param slider Slider que foi alterado de posição
	 * @param mediaPlayerComponent
	 * 		Passa o componente media player, necessário para recuperar o 
	 * 		MediaPlayer e uma ação atrelada a ele.
	 */
	public static void timeSlider(JSlider slider, EmbeddedMediaPlayerComponent mediaPlayerComponent) {
		slider.setMaximum((int) mediaPlayerComponent.getMediaPlayer().getLength());
		mediaPlayerComponent.getMediaPlayer().setTime(slider.getValue());
	}
	/**
	 * Ação do componente de voltar no tempo de execução.
	 * 
	 * @param mediaPlayerComponent
	 * 		Passa o componente media player, necessário para recuperar o 
	 * 		MediaPlayer e uma ação atrelada a ele.
	 */
	public static void rewindButton(EmbeddedMediaPlayerComponent mediaPlayerComponent) {
		mediaPlayerComponent.getMediaPlayer().skip(-5000);
	}
	
	/**
	 * Ação do componente avançar no tempo de execução.
	 * 
	 * @param mediaPlayerComponent
	 * 		Passa o componente media player, necessário para recuperar o 
	 * 		MediaPlayer e uma ação atrelada a ele.
	 */
	public static void skipButton(EmbeddedMediaPlayerComponent mediaPlayerComponent) {
		mediaPlayerComponent.getMediaPlayer().skip(5000);
	}

	/**
	 * Ação do componente mutar volume.
	 * 
	 * @param muteButton Botão mutar.
	 * @param mediaPlayerComponent
	 * 		Passa o componente media player, necessário para recuperar o 
	 * 		MediaPlayer e uma ação atrelada a ele.
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
	 * Ação do componente de fullScreen ao ser clicado.
	 * 
	 * @param fullScreenButton	Botão fullScreen.
	 * @param mediaPlayer	EmbeddedMediaPlayer para mudar entre fullScreen ou não.
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
	 * Ação do componente pausar do player de música.
	 * 
	 * @param pause	Componente pausar.
	 * @param mediaListPlayer Player de música.	
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
	 * Ação componente próximo do player de música.
	 * @param mediaListPlayer Player de música.
	 */
	public static void nextButton(MediaListPlayer mediaListPlayer) {
		mediaListPlayer.playNext();
	}
	
	/**
	 * Ação do componente voltar do player de música.
	 * @param mediaListPlayer Player de música.
	 */
	public static void previousButton(MediaListPlayer mediaListPlayer) {
		mediaListPlayer.playPrevious();
	}
	
	/**
	 * Ação do componente mutar volume do player de música.
	 * 
	 * @param muteButton Componente mutar do player.
	 * @param mediaPlayer	Player de música.
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
	 * Ação do componente volume do player de música.
	 * 
	 * @param slider Componente volume do player.
	 * @param mediaPlayer Player de música.
	 */
	public static void volumeSlider(JSlider slider, EmbeddedMediaPlayer mediaPlayer) {
		mediaPlayer.setVolume(slider.getValue());
	}
	
	/**
	 * Método que interrompe a execução do player de música, e desativa todos os botões do player.
	 * 
	 * @param mediaPlayer Player de música.
	 * @param mediaListPlayer Player com uma mediaList.
	 * @param mediaList Lista com as música em execução.
	 * @param pauseButton Componente pausar música.
	 * @param nextButton Componente próxima música.
	 * @param previousButton Componente voltar música.
	 * @param releaseListButton Componente "fechar" player.
	 * @param muteButton Componente mutar musica.
	 * @param volumeSlider Componente volume da música. 
	 * @param actualMusicName Componente que exibe o nome da música.
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
