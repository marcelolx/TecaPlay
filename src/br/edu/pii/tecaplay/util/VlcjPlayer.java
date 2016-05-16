package br.edu.pii.tecaplay.util;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import com.sun.jna.Native;
import com.sun.jna.NativeLibrary;

import uk.co.caprica.vlcj.binding.LibVlc;
import uk.co.caprica.vlcj.component.EmbeddedMediaPlayerComponent;
import uk.co.caprica.vlcj.player.MediaPlayerFactory;
import uk.co.caprica.vlcj.player.embedded.EmbeddedMediaPlayer;
import uk.co.caprica.vlcj.runtime.RuntimeUtil;
import uk.co.caprica.vlcj.runtime.x.LibXUtil;

public class VlcjPlayer {
	public VlcjPlayer() {
		registerLibrary();
	}

	/*
	 * Executar arquivo vídeo/música
	 */
	public void play(final String filename) {
		final Canvas videoSurface = new Canvas();
		final JFrame frame = buildFrame(videoSurface);
		final List<String> vlcArgs = new ArrayList<String>();

		configureParameters(vlcArgs);

		final EmbeddedMediaPlayer mediaPlayer = createPlayer(vlcArgs,videoSurface);
		mediaPlayer.playMedia(filename);
	}

	/**
	 * Important: Notice where is the libvlc, which contains all native
	 * functions to manipulate the player *
	 * 
	 * Windows: libvlc.dll Linux: libvlc.so
	 */
	private void registerLibrary() {
		// setando acesso nativo a biblioteca LibV
		NativeLibrary.addSearchPath(RuntimeUtil.getLibVlcLibraryName(), "C:/Program Files/VideoLAN/VLC");
		Native.loadLibrary(RuntimeUtil.getLibVlcLibraryName(), LibVlc.class);
		LibXUtil.initialise();
	}
	
	/*
	 * Criando o frame onde o filme/musica será executado
	 */
	private JFrame buildFrame(final Canvas videoSurface){
		final JFrame f = new JFrame("TecaPlay Player");
		f.setDefaultCloseOperation(f.DISPOSE_ON_CLOSE);
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e){
				Thread.currentThread().interrupt();
				f.setVisible(false);
				f.dispose();
			}
		});
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		//f.setPreferredSize(new Dimension(screen.width, screen.height));
		f.setSize(screen.width, screen.height-48);
		f.setLayout(new BorderLayout());
		f.setResizable(false);
		f.setLocationRelativeTo(null);
		f.setIconImage(Toolkit.getDefaultToolkit().getImage("resources\\images\\newLogo.png"));
		f.add(videoSurface, BorderLayout.CENTER);
		f.setVisible(true);
		return f;
	}
	
	/*
	 * Configurando os parâmetros do VLC
	 */
	
	private void configureParameters(final List<String> vlcArgs){
		vlcArgs.add("--no-plugins-cache");
		//vlcArgs.add("--fullscreen");
		vlcArgs.add("--video-title-show");
		vlcArgs.add("--video-title-timeout=<60000>");
		vlcArgs.add("--video-title-position={5 (Top-Left)}");
		vlcArgs.add("--no-snapshot-preview");
		vlcArgs.add("upside-down-o-vision");
		vlcArgs.add("--video-filter=transform");
		vlcArgs.add("--transform-type=vflip");
		
		// Importante, se esse parametro nao for configurado no Windows, a aplicacao nao funcionara
        if (RuntimeUtil.isWindows()) {
            vlcArgs.add("--plugin-path=C:/Program Files/VideoLAN/VLC/plugins");
        }
	}
	
    /**
     * Constroi o player
     */
    private EmbeddedMediaPlayer createPlayer(final List <String> vlcArgs, final Canvas videoSurface){
    	EmbeddedMediaPlayerComponent mediaPlayerComponent = new EmbeddedMediaPlayerComponent();
    	EmbeddedMediaPlayer embeddedMediaPlayer = mediaPlayerComponent.getMediaPlayer();
    	
    	MediaPlayerFactory mediaPlayerFactory = new MediaPlayerFactory(vlcArgs.toArray(new String[vlcArgs.size()]));
    	mediaPlayerFactory.setUserAgent("TecaPlay Player");
    	embeddedMediaPlayer.setVideoSurface(mediaPlayerFactory.newVideoSurface(videoSurface));
    	embeddedMediaPlayer.setPlaySubItems(true);
    	
    	return embeddedMediaPlayer;
    }
}
