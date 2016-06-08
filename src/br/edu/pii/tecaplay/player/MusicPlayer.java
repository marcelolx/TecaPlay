package br.edu.pii.tecaplay.player;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JSlider;

import uk.co.caprica.vlcj.medialist.MediaList;
import uk.co.caprica.vlcj.player.MediaPlayerFactory;
import uk.co.caprica.vlcj.player.embedded.EmbeddedMediaPlayer;
import uk.co.caprica.vlcj.player.list.MediaListPlayer;
import uk.co.caprica.vlcj.player.list.MediaListPlayerMode;

public class MusicPlayer {

	private static JButton pauseButton;
	private static JButton previousButton;
	private static JButton nextButton;
	private static JSlider volumeSlider;
	private static JButton muteButton;

	public static void InterfaceConstructor(JPanel panelPlayer) {
		previousButton = new JButton();
		previousButton.setIcon(new ImageIcon("resources\\images\\rewindButton.png"));
		previousButton.setBackground(Color.GRAY);
		previousButton.setPreferredSize(new Dimension(32, 32));
		panelPlayer.add(previousButton, BorderLayout.CENTER);
		pauseButton = new JButton();
		pauseButton.setIcon(new ImageIcon("resources\\images\\pauseButton.png"));
		pauseButton.setBackground(Color.GRAY);
		pauseButton.setPreferredSize(new Dimension(32, 32));
		panelPlayer.add(pauseButton, BorderLayout.CENTER);
		nextButton = new JButton();
		nextButton.setIcon(new ImageIcon("resources\\images\\skipButton.png"));
		nextButton.setBackground(Color.GRAY);
		nextButton.setPreferredSize(new Dimension(32, 32));
		panelPlayer.add(nextButton, BorderLayout.CENTER);
		muteButton = new JButton();
		muteButton.setIcon(new ImageIcon("resources\\images\\noMute.png"));
		muteButton.setPreferredSize(new Dimension(32, 32));
		muteButton.setBackground(Color.GRAY);
		panelPlayer.add(muteButton, BorderLayout.CENTER);
		volumeSlider = new JSlider();
		volumeSlider.setPreferredSize(new Dimension(60, 32));
		volumeSlider.setBackground(Color.GRAY);
		volumeSlider.setValue(100);
		panelPlayer.add(volumeSlider, BorderLayout.CENTER);
	}

	public static void play() {
		VLCjPlayer.registerLibrary();
        MediaPlayerFactory mediaPlayerFactory = new MediaPlayerFactory();
        EmbeddedMediaPlayer mediaPlayer = mediaPlayerFactory.newEmbeddedMediaPlayer();
        

        MediaListPlayer mediaListPlayer = mediaPlayerFactory.newMediaListPlayer();
        mediaListPlayer.setMediaPlayer(mediaPlayer);
        MediaList mediaList = mediaPlayerFactory.newMediaList();
        String[] mediapath = new String[2];
        mediapath[0] = "C:/Users/Marcelo/Music/YTM For Bus/Hardwell/Hardwell feat. Jake Reese - Mad World (Official Music Video).mp3";
        mediapath[1] = "C:/Users/Marcelo/Music/YTM For Bus/Hardwell/Hardwell feat. Mitch Crown - Call Me A Spaceman (Official Video).mp3";
        int cnt = 0;
        while (cnt != mediapath.length) {
           mediaList.addMedia(mediapath[cnt]);
            cnt++;
        }
       mediaListPlayer.setMediaList(mediaList);
       mediaListPlayer.setMode(MediaListPlayerMode.LOOP);
       mediaListPlayer.play(); 
	}
}
