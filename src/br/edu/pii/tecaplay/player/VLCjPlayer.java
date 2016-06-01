package br.edu.pii.tecaplay.player;




import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingUtilities;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.sun.jna.Native;
import com.sun.jna.NativeLibrary;

import uk.co.caprica.vlcj.binding.LibVlc;
import uk.co.caprica.vlcj.component.EmbeddedMediaPlayerComponent;
import uk.co.caprica.vlcj.discovery.NativeDiscovery;
import uk.co.caprica.vlcj.player.MediaPlayer;
import uk.co.caprica.vlcj.player.MediaPlayerEventAdapter;
import uk.co.caprica.vlcj.player.MediaPlayerFactory;
import uk.co.caprica.vlcj.player.embedded.DefaultFullScreenStrategy;
import uk.co.caprica.vlcj.player.embedded.EmbeddedMediaPlayer;
import uk.co.caprica.vlcj.player.embedded.FullScreenStrategy;
import uk.co.caprica.vlcj.runtime.RuntimeUtil;
import uk.co.caprica.vlcj.runtime.x.LibXUtil;

public class VLCjPlayer{
	/**
	 * @author Marcelo
	 */
	
	
    private final JFrame frame;

    private final EmbeddedMediaPlayerComponent mediaPlayerComponent;

    private final JButton pauseButton;

    private final JButton rewindButton;

    private final JButton skipButton;
    
    private int logoPlay = 0;
    
    private final JSlider volumeSlider;
    
    private final JSlider timeSlider;

    private final JButton muteButton;
    
    private final JButton fullscreenButton;

    public void Teste(String caminho) {
        new NativeDiscovery().discover();
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new VLCjPlayer(caminho);
            }
        });
    }

    public VLCjPlayer(String caminho) {
    	registerLibrary();
        frame = new JFrame("TecaPlay Player");
        frame.setBounds(100, 100, 700, 440);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                mediaPlayerComponent.release();
                frame.dispose();
            }
        });

        JPanel contentPane = new JPanel();
        contentPane.setLayout(new BorderLayout());

        mediaPlayerComponent = new EmbeddedMediaPlayerComponent();
        contentPane.add(mediaPlayerComponent, BorderLayout.CENTER);
        MediaPlayerFactory mediaPlayerFactory = new MediaPlayerFactory();
        // Create a full-screen strategy
        FullScreenStrategy fullScreenStrategy = new DefaultFullScreenStrategy(frame);
        // Create a media player instance (in this example an embedded media player)
        EmbeddedMediaPlayer mediaPlayer = mediaPlayerFactory.newEmbeddedMediaPlayer(fullScreenStrategy);

        JPanel controlsPane = new JPanel();
        controlsPane.setBackground(new Color(192, 192, 192));
        rewindButton = new JButton();
        rewindButton.setIcon(new ImageIcon("resources\\images\\rewindButton.png"));
        rewindButton.setBackground(Color.LIGHT_GRAY);
        rewindButton.setPreferredSize(new Dimension(32, 32));
        controlsPane.add(rewindButton, BorderLayout.CENTER);
        pauseButton = new JButton();
        pauseButton.setIcon(new ImageIcon("resources\\images\\pauseButton.png"));
        pauseButton.setBackground(Color.LIGHT_GRAY);
        pauseButton.setPreferredSize(new Dimension(32, 32));
        controlsPane.add(pauseButton, BorderLayout.CENTER); 
        skipButton = new JButton();
        skipButton.setIcon(new ImageIcon("resources\\images\\skipButton.png"));
        skipButton.setBackground(Color.LIGHT_GRAY);
        skipButton.setPreferredSize(new Dimension(32, 32));
        controlsPane.add(skipButton, BorderLayout.CENTER);
        muteButton = new JButton();
        muteButton.setIcon(new ImageIcon("resources\\images\\noMute.png"));
        muteButton.setPreferredSize(new Dimension(32, 32));
        muteButton.setBackground(Color.LIGHT_GRAY);
        controlsPane.add(muteButton, BorderLayout.CENTER);
        volumeSlider = new JSlider();
        volumeSlider.setPreferredSize(new Dimension(60, 32));
        volumeSlider.setBackground(Color.LIGHT_GRAY);
        volumeSlider.setValue(100);
        controlsPane.add(volumeSlider, BorderLayout.CENTER);
        timeSlider = new JSlider();
        timeSlider.setPreferredSize(new Dimension(400, 10));
        timeSlider.setBackground(Color.LIGHT_GRAY);
        timeSlider.setValue(0);
        controlsPane.add(timeSlider, BorderLayout.NORTH);
        fullscreenButton = new JButton();
        fullscreenButton.setIcon(new ImageIcon("resources\\images\\togleFull.png"));
        fullscreenButton.setPreferredSize(new Dimension(32, 32));
        fullscreenButton.setBackground(Color.LIGHT_GRAY);
        controlsPane.add(fullscreenButton, BorderLayout.CENTER);
        contentPane.add(controlsPane, BorderLayout.SOUTH);
        
        pauseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mediaPlayerComponent.getMediaPlayer().pause();
                if(logoPlay==0){
                	pauseButton.setIcon(new ImageIcon("resources\\images\\playButton.png"));
                	logoPlay = 1;
                }else{
                	pauseButton.setIcon(new ImageIcon("resources\\images\\pauseButton.png"));
                	logoPlay = 0;
                }
            }
        });

        rewindButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mediaPlayerComponent.getMediaPlayer().skip(-5000);
            }
        });
        

        skipButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mediaPlayerComponent.getMediaPlayer().skip(5000);
            }
        });
        
        muteButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				boolean mute = mediaPlayerComponent.getMediaPlayer().mute();
				if(mute){
					muteButton.setIcon(new ImageIcon("resources\\images\\mute.png"));
				}else{
					muteButton.setIcon(new ImageIcon("resources\\images\\noMute.png"));
				}
			}
		});
        
        volumeSlider.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				mediaPlayerComponent.getMediaPlayer().setVolume(volumeSlider.getValue());
				
			}
		});
       
        timeSlider.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent arg0) {
				timeSlider.setMaximum((int)mediaPlayerComponent.getMediaPlayer().getLength());
				mediaPlayerComponent.getMediaPlayer().setTime(timeSlider.getValue());
			
				
			}
		});
       
        fullscreenButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				mediaPlayer.toggleFullScreen();
				boolean realy = mediaPlayer.isFullScreen();
				if(realy){
					fullscreenButton.setIcon(new ImageIcon("resources\\images\\exitFull.png"));
				}else{
					fullscreenButton.setIcon(new ImageIcon("resources\\images\\togleFull.png"));
				}
			}
		});
        
        mediaPlayerComponent.getMediaPlayer().addMediaPlayerEventListener(new MediaPlayerEventAdapter() {
            @Override
            public void playing(MediaPlayer mediaPlayer) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                    	frame.setIconImage(Toolkit.getDefaultToolkit().getImage("resources\\images\\newLogo.png"));
                        frame.setTitle(String.format(
                            "TecaPlay Player - %s",
                            mediaPlayerComponent.getMediaPlayer().getMediaMeta().getTitle()
                        ));
                    }
                });
            }

            @Override
            public void finished(MediaPlayer mediaPlayer) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        closeWindow();
                    }
                });
            }

            @Override
            public void error(MediaPlayer mediaPlayer) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        JOptionPane.showMessageDialog(
                            frame,
                            "Falha ao abrir a mídia",
                            "Erro",
                            JOptionPane.ERROR_MESSAGE
                        );
                        closeWindow();
                    }
                });
            }
        });

        		
        
        frame.setContentPane(contentPane);
        frame.setVisible(true);

        mediaPlayerComponent.getMediaPlayer().playMedia(caminho);
    }
    private void registerLibrary() {
    			// setando acesso nativo a biblioteca LibV
    			NativeLibrary.addSearchPath(RuntimeUtil.getLibVlcLibraryName(), "C:/Program Files/VideoLAN/VLC");
    			Native.loadLibrary(RuntimeUtil.getLibVlcLibraryName(), LibVlc.class);
    			LibXUtil.initialise();
    		}
    private void closeWindow() {
        frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
    }
}
