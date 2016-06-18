package br.edu.pii.tecaplay.player;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingUtilities;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import uk.co.caprica.vlcj.medialist.MediaList;
import uk.co.caprica.vlcj.player.MediaPlayer;
import uk.co.caprica.vlcj.player.MediaPlayerEventAdapter;
import uk.co.caprica.vlcj.player.MediaPlayerFactory;
import uk.co.caprica.vlcj.player.embedded.EmbeddedMediaPlayer;
import uk.co.caprica.vlcj.player.list.MediaListPlayer;
import uk.co.caprica.vlcj.player.list.MediaListPlayerMode;
/**
 * Musica player que foi integrado na HomePage
 *
 */
public class MusicPlayer {
	private static String[] mediapath;
	private static JButton pauseButton;
	private static JButton previousButton;
	private static JButton nextButton;
	private static JSlider volumeSlider;
	private static JButton muteButton;
	private static JButton releaseListButton;
	private static JLabel actualMusicName;
	private static EmbeddedMediaPlayer mediaPlayer;
	private static MediaListPlayer mediaListPlayer;
	private static MediaList mediaList;
/**
 * @param panelPlayer panel da homePage que serão adicionados os botões entre outros.
 */
	public static void InterfaceConstructor(JPanel panelPlayer) {
		JLabel posic = new JLabel();
		posic.setPreferredSize(new Dimension(368, 32));
		posic.setBackground(Color.GRAY);
		panelPlayer.add(posic, BorderLayout.CENTER);
		releaseListButton = new JButton();
		releaseListButton.setIcon(new ImageIcon("resources\\images\\imgBtnRemover.png"));
		releaseListButton.setBackground(Color.GRAY);
		releaseListButton.setPreferredSize(new Dimension(32, 32));
		releaseListButton.setEnabled(false);
		panelPlayer.add(releaseListButton, BorderLayout.CENTER);
		previousButton = new JButton();
		previousButton.setIcon(new ImageIcon("resources\\images\\previousButton.png"));
		previousButton.setBackground(Color.GRAY);
		previousButton.setPreferredSize(new Dimension(32, 32));
		previousButton.setEnabled(false);
		panelPlayer.add(previousButton, BorderLayout.CENTER);
		pauseButton = new JButton();
		pauseButton.setIcon(new ImageIcon("resources\\images\\pauseButton.png"));
		pauseButton.setBackground(Color.GRAY);
		pauseButton.setPreferredSize(new Dimension(32, 32));
		pauseButton.setEnabled(false);
		panelPlayer.add(pauseButton, BorderLayout.CENTER);
		nextButton = new JButton();
		nextButton.setIcon(new ImageIcon("resources\\images\\nextButton.png"));
		nextButton.setBackground(Color.GRAY);
		nextButton.setPreferredSize(new Dimension(32, 32));
		nextButton.setEnabled(false);
		panelPlayer.add(nextButton, BorderLayout.CENTER);
		muteButton = new JButton();
		muteButton.setIcon(new ImageIcon("resources\\images\\noMute.png"));
		muteButton.setPreferredSize(new Dimension(32, 32));
		muteButton.setBackground(Color.GRAY);
		muteButton.setEnabled(false);
		panelPlayer.add(muteButton, BorderLayout.CENTER);
		volumeSlider = new JSlider();
		volumeSlider.setPreferredSize(new Dimension(60, 32));
		volumeSlider.setBackground(Color.GRAY);
		volumeSlider.setValue(100);
		volumeSlider.setEnabled(false);
		panelPlayer.add(volumeSlider, BorderLayout.CENTER);
		actualMusicName = new JLabel();
		actualMusicName.setPreferredSize(new Dimension(320, 32));
		actualMusicName.setBackground(Color.GRAY);
		actualMusicName.setForeground(Color.WHITE);
		panelPlayer.add(actualMusicName, BorderLayout.CENTER);
	}
	
	public static void play(String user, String currentGenero) {
		if(currentGenero.equals("Playlist")){//preciso de mais um vereficador, que é o que sabe o nome da playlist, farei sabado
			//c:\\TecaPlay\\" + usrName + "\\Musicas\\" + genero + "\\" + genero + ".txt
		}
		VLCjPlayer.registerLibrary();
		MediaPlayerFactory mediaPlayerFactory = new MediaPlayerFactory();
		mediaPlayer = mediaPlayerFactory.newEmbeddedMediaPlayer();
		
		mediaListPlayer = mediaPlayerFactory.newMediaListPlayer();
		mediaListPlayer.setMediaPlayer(mediaPlayer);
		mediaList = mediaPlayerFactory.newMediaList();
		int cnt = 0;
		while (cnt != mediapath.length) {
			mediaList.addMedia(mediapath[cnt]);
			cnt++;
		}
		mediaListPlayer.setMediaList(mediaList);
		mediaListPlayer.setMode(MediaListPlayerMode.LOOP);
		mediaListPlayer.play();
		pauseButton.setEnabled(true);
		nextButton.setEnabled(true);
		previousButton.setEnabled(true);
		releaseListButton.setEnabled(true);
		muteButton.setEnabled(true);
		volumeSlider.setEnabled(true);
		
		pauseButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				PlayerButtonEvents.pauseButton(pauseButton, mediaListPlayer);
			}
		});
		
		nextButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				PlayerButtonEvents.nextButton(mediaListPlayer);
			}
		});
		
		previousButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				PlayerButtonEvents.previousButton(mediaListPlayer);
			}
		});
		
		muteButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				PlayerButtonEvents.muteButton(muteButton, mediaPlayer);
			}
		});
		
		volumeSlider.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				PlayerButtonEvents.volumeSlider(volumeSlider, mediaPlayer);
			}
		});
		
		releaseListButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				PlayerButtonEvents.releasePlayer(mediaPlayer, mediaListPlayer, mediaList, pauseButton, nextButton, previousButton, releaseListButton, muteButton, volumeSlider, actualMusicName);
			}
		});
		
		mediaPlayer.addMediaPlayerEventListener(new MediaPlayerEventAdapter(){
			public void playing(MediaPlayer mediaPlayer){
				SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                    	int val = mediaListPlayer.currentMrl().lastIndexOf('/');
                    	String tt = mediaListPlayer.currentMrl().substring(val+1);
                    	try {
							tt = URLDecoder.decode(tt, "UTF-8");
						} catch (UnsupportedEncodingException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
                        actualMusicName.setText(tt);
                    }
                });
			}
		});

	}
	public static void playAll(String[] media) {
        
		mediapath = new String[media.length];
		mediapath = media;
	}
	
	public static void stop(){
		PlayerButtonEvents.releasePlayer(mediaPlayer, mediaListPlayer, mediaList, pauseButton, nextButton, previousButton, releaseListButton, muteButton, volumeSlider, actualMusicName);
	}
}
