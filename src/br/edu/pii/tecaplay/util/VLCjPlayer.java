package br.edu.pii.tecaplay.util;




import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import com.sun.jna.Native;
import com.sun.jna.NativeLibrary;

import uk.co.caprica.vlcj.binding.LibVlc;
import uk.co.caprica.vlcj.component.EmbeddedMediaPlayerComponent;
import uk.co.caprica.vlcj.discovery.NativeDiscovery;
import uk.co.caprica.vlcj.runtime.RuntimeUtil;
import uk.co.caprica.vlcj.runtime.x.LibXUtil;

public class VLCjPlayer{

    private final JFrame frame;

    private final EmbeddedMediaPlayerComponent mediaPlayerComponent;

    private final JButton pauseButton;

    private final JButton rewindButton;

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
        frame = new JFrame("My First Media Player");
        frame.setBounds(100, 100, 600, 400);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
        pauseButton = new JButton("Pause");
        controlsPane.add(pauseButton);
        rewindButton = new JButton("Rewind");
        controlsPane.add(rewindButton);
        skipButton = new JButton("Skip");
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
                mediaPlayerComponent.getMediaPlayer().skip(-10000);
            }
        });

        skipButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mediaPlayerComponent.getMediaPlayer().skip(10000);
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
}
