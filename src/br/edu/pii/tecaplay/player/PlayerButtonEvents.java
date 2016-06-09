package br.edu.pii.tecaplay.player;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JSlider;

import uk.co.caprica.vlcj.component.EmbeddedMediaPlayerComponent;
import uk.co.caprica.vlcj.medialist.MediaList;
import uk.co.caprica.vlcj.player.embedded.EmbeddedMediaPlayer;
import uk.co.caprica.vlcj.player.list.MediaListPlayer;

public class PlayerButtonEvents {

	private static int logoPlay = 0;

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

	public static void volumeSlider(JSlider slider, EmbeddedMediaPlayerComponent mediaPlayerComponent) {
		mediaPlayerComponent.getMediaPlayer().setVolume(slider.getValue());
	}

	public static void timeSlider(JSlider slider, EmbeddedMediaPlayerComponent mediaPlayerComponent) {
		slider.setMaximum((int) mediaPlayerComponent.getMediaPlayer().getLength());
		mediaPlayerComponent.getMediaPlayer().setTime(slider.getValue());
	}

	public static void rewindButton(JButton rewind, EmbeddedMediaPlayerComponent mediaPlayerComponent) {
		mediaPlayerComponent.getMediaPlayer().skip(-5000);
	}

	public static void skipButton(JButton rewind, EmbeddedMediaPlayerComponent mediaPlayerComponent) {
		mediaPlayerComponent.getMediaPlayer().skip(5000);
	}

	public static void muteButton(JButton muteButton, EmbeddedMediaPlayerComponent mediaPlayerComponent) {
		boolean muted = mediaPlayerComponent.getMediaPlayer().mute();
		if (muted) {
			muteButton.setIcon(new ImageIcon("resources\\images\\mute.png"));
		} else {
			muteButton.setIcon(new ImageIcon("resources\\images\\noMute.png"));
		}
	}

	public static void fullSreen(JButton fullScreenButton, EmbeddedMediaPlayerComponent mediaPlayerComponent,
			EmbeddedMediaPlayer mediaPlayer) {
		mediaPlayer.toggleFullScreen();
		boolean realy = mediaPlayer.isFullScreen();
		if (realy) {
			fullScreenButton.setIcon(new ImageIcon("resources\\images\\exitFull.png"));
		} else {
			fullScreenButton.setIcon(new ImageIcon("resources\\images\\togleFull.png"));
		}
	}

	// player musica
	public static void pauseButton(JButton pause, MediaListPlayer mediaListPlayer) {
		if (mediaListPlayer.isPlaying()) {
			mediaListPlayer.pause();
			pause.setIcon(new ImageIcon("resources\\images\\playButton.png"));
		} else {
			mediaListPlayer.play();
			pause.setIcon(new ImageIcon("resources\\images\\pauseButton.png"));
		}
	}
	
	public static void nextButton(MediaListPlayer mediaListPlayer) {
		mediaListPlayer.playNext();
	}
	
	public static void previousButton(MediaListPlayer mediaListPlayer) {
		mediaListPlayer.playPrevious();
	}
	
	public static void muteButton(JButton muteButton, EmbeddedMediaPlayer mediaPlayer) {
		if (mediaPlayer.isMute()) {
			mediaPlayer.mute(false);
			muteButton.setIcon(new ImageIcon("resources\\images\\noMute.png"));
		} else {
			mediaPlayer.mute(true);
			muteButton.setIcon(new ImageIcon("resources\\images\\mute.png"));
		}
	}
	
	public static void volumeSlider(JSlider slider, EmbeddedMediaPlayer mediaPlayer) {
		mediaPlayer.setVolume(slider.getValue());
	}
	
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
