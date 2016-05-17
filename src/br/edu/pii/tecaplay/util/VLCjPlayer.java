package br.edu.pii.tecaplay.util;




import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import com.sun.jna.Native;
import com.sun.jna.NativeLibrary;

import uk.co.caprica.vlcj.binding.LibVlc;
import uk.co.caprica.vlcj.component.EmbeddedMediaPlayerComponent;
import uk.co.caprica.vlcj.discovery.NativeDiscovery;
import uk.co.caprica.vlcj.player.MediaPlayer;
import uk.co.caprica.vlcj.player.MediaPlayerEventAdapter;
import uk.co.caprica.vlcj.runtime.RuntimeUtil;
import uk.co.caprica.vlcj.runtime.x.LibXUtil;

public class VLCjPlayer{

    private final JFrame frame;

    private final EmbeddedMediaPlayerComponent mediaPlayerComponent;

    private final JButton pauseButton;

    private final JButton rewindButton;
    private final JButton  playButton;

    private final JButton skipButton;


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
        frame.setBounds(100, 100, 600, 400);
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

        JPanel controlsPane = new JPanel();
        playButton = new JButton("Pausar");
        controlsPane.add(playButton);
        pauseButton = new JButton("Pausar");
        controlsPane.add(pauseButton); 
        rewindButton = new JButton("Retroceder");
        controlsPane.add(rewindButton);
        skipButton = new JButton("Avançar");
        controlsPane.add(skipButton);
        contentPane.add(controlsPane, BorderLayout.SOUTH);

        pauseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mediaPlayerComponent.getMediaPlayer().pause();
            }
        });

        rewindButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mediaPlayerComponent.getMediaPlayer().skip(-5000);
            }
        });
        
        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               mediaPlayerComponent.getMediaPlayer().setTime(10000);
               System.out.println(mediaPlayerComponent.getMediaPlayer().getLength());
               System.out.println(mediaPlayerComponent.getMediaPlayer().getTime());
            }
        });
        
        

        skipButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mediaPlayerComponent.getMediaPlayer().skip(5000);
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
