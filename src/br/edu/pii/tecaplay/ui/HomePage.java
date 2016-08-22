package br.edu.pii.tecaplay.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import br.edu.pii.tecaplay.player.MusicPlayer;
import br.edu.pii.tecaplay.util.FRarquivos;
import br.edu.pii.tecaplay.util.FileUtil;
import br.edu.pii.tecaplay.util.optimizationgui.ArrayCategorias;
import br.edu.pii.tecaplay.util.optimizationgui.AtualizePlaylistsOrFavorites;
import br.edu.pii.tecaplay.util.optimizationgui.AtualizeSeries;
import br.edu.pii.tecaplay.util.optimizationgui.TimerToLabel;
import br.edu.pii.tecaplay.util.table.ListFiles;
import br.edu.pii.tecaplay.util.table.ListFilesPlaylistOrFavorites;
import br.edu.pii.tecaplay.util.table.ListFilesSeries;

/**
 * Antes de mais nada, não uso do WindowBuilder aqui, foi feito tudo a mão, pelo fato das transições de
 * JPanels.
 * 
 * Nesta classe jaz todo o código da interface principal do TecaPlay.
 * Além de conter alguns métodos que auxiliam na adição de alguns componentes 
 * a interface do TecaPlay quando hà mudança de telas.
 * 
 * @author Marcelo, Jonas
 *
 */
public class HomePage {

	private ArrayList<JPanel> voltarPaineis = new ArrayList<>();
	private JTable table = new JTable();
	private JTable tableSeries = new JTable();
	private JTable tablePlaylist = new JTable();
	private ListFiles listFiles = new ListFiles();
	private ListFilesSeries listFilesSeries = new ListFilesSeries();
	private ListFilesPlaylistOrFavorites listFilePlayList = new ListFilesPlaylistOrFavorites();
	private JButton[] arrayBtns;
	private JScrollPane tableContainer = new JScrollPane(table);
	private JScrollPane tableContainerSeries = new JScrollPane(tableSeries);
	private JScrollPane tableContainerPlaylist = new JScrollPane(tablePlaylist);
	private String currentGenero = null;
	private String userName;
	private String music = "";
	private JFrame home;
	private JPanel panelGeral;
	private JLabel labelFundo;
	private final TimerToLabel timer;
	private JPanel playlistPanel;
	private JPanel panelPlayer;
	private JButton playAllButton;
	private boolean flag = false;
	private JButton[] buttonCatFilmes;
	private JButton[] buttonCatSeries;
	private JButton[] buttonCatMusica;
	private JPanel panelCategoriasFilmes;
	private JPanel panelCategoriasSerie;
	private JPanel panelCategoriasMusica;
	private boolean firstPlay = false;
	
	/**
	 *
	 * @param usrName User logged
	 */
	public HomePage(String usrName) {
		userName = usrName;
		home = new JFrame();
		home.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent args) {
				home.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
				FileUtil.exit();
			}
		});
		home.setVisible(true);
		home.setBackground(new Color(25, 25, 25));
		home.setTitle("Home - TecaPlay"); 

		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		System.out.println(screen);
		int width = 1366 - 386;
		int height = 798 - 208;
		int x = (screen.width - width) / 2;
		int y = (screen.height - height) / 2;
		home.setBounds(x, y, width, height);
		home.setResizable(false); 
		home.setIconImage(Toolkit.getDefaultToolkit().getImage("resources\\images\\newLogo.png")); 

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(Color.LIGHT_GRAY);
		home.setJMenuBar(menuBar);

		JMenu menuArquivo = new JMenu("Arquivo");
		menuArquivo.setMnemonic('A');
		menuArquivo.setBackground(Color.DARK_GRAY);
		menuArquivo.setIcon(new ImageIcon("resources\\images\\imgMenuArquivo.png"));
		menuBar.add(menuArquivo); 

		JMenuItem subMenuSair = new JMenuItem("Sair");
		subMenuSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FileUtil.exit();
			}
		});
		subMenuSair.setIcon(new ImageIcon("resources\\images\\imgMenuSair.png"));
		subMenuSair.setSelected(true);
		menuArquivo.add(subMenuSair);

		JMenu menuAjuda = new JMenu("Ajuda");
		menuAjuda.setMnemonic('J');
		menuAjuda.setHorizontalAlignment(SwingConstants.LEFT);
		menuAjuda.setIcon(new ImageIcon("resources\\images\\imgMenuSobre.png")); // adiÐ·Ð³
		menuBar.add(menuAjuda);

		JMenuItem mntmSobre = new JMenuItem("Sobre");
		mntmSobre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				@SuppressWarnings("unused")
				Sobre info = new Sobre();
			}
		});
		mntmSobre.setIcon(new ImageIcon("resources\\images\\imgBtnSobre.png"));
		menuAjuda.add(mntmSobre);
		
		JPanel panelTopo = new JPanel();
		panelTopo.setAutoscrolls(true);
		panelTopo.setFocusTraversalPolicyProvider(true);
		panelTopo.setFocusCycleRoot(true);
		panelTopo.setIgnoreRepaint(true);
		panelTopo.setBackground(new Color(127, 127, 127));
		home.getContentPane().add(panelTopo, BorderLayout.NORTH);

		/**
		 * @panelPlayer panel containing music player buttons
		 */
		panelPlayer = new JPanel();
		panelPlayer.setAutoscrolls(true);
		panelPlayer.setFocusTraversalPolicyProvider(true);
		panelPlayer.setFocusCycleRoot(true);
		panelPlayer.setIgnoreRepaint(true);
		panelPlayer.setBackground(new Color(122, 122, 122));

		MusicPlayer.InterfaceConstructor(panelPlayer);

		home.getContentPane().add(panelPlayer, BorderLayout.SOUTH);

		JButton btnVideo = new JButton("V\u00EDdeo");

		panelTopo.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		btnVideo.setToolTipText("Op\u00E7\u00E3o de acesso a aba V\u00EDdeo!");
		btnVideo.setIcon(new ImageIcon("resources\\images\\imgBtnVideo.png"));
		btnVideo.setFont(new Font("Tahoma", Font.BOLD, 14)); 
		btnVideo.setBackground(Color.LIGHT_GRAY);
		btnVideo.setPreferredSize(new Dimension(173, 42));
		panelTopo.add(btnVideo);
		home.isCursorSet();

		JButton btnMusica = new JButton("Música");
		btnMusica.setToolTipText("Op\u00E7\u00E3o de acesso a aba M\u00FAsica!");
		btnMusica.setIcon(new ImageIcon("resources\\images\\imgBtnMusica.png"));
		btnMusica.setFont(new Font("Tahoma", Font.BOLD, 14)); 
		btnMusica.setPreferredSize(new Dimension(173, 42));
		btnMusica.setBackground(Color.LIGHT_GRAY);
		panelTopo.add(btnMusica);
		home.isCursorSet();

		JButton btnImagem = new JButton("Imagem");
		btnImagem.setToolTipText("Op\u00E7\u00E3o de acesso a aba Imagem!");
		btnImagem.setIcon(new ImageIcon("resources\\images\\imgBtnImagem.png")); 
		btnImagem.setFont(new Font("Tahoma", Font.BOLD, 14)); 
		btnImagem.setPreferredSize(new Dimension(173, 42));
		btnImagem.setBackground(Color.LIGHT_GRAY);
		panelTopo.add(btnImagem);

		// BANNER PRINCIPAL
		labelFundo = new JLabel("");
		labelFundo.setSize(400, 400);
		labelFundo.setIcon(new ImageIcon("resources\\images\\bannerPrincipal.jpg"));
		/**
		 * @TimerToLabel switch background wallpapers
		 */
		timer = new TimerToLabel(30000, labelFundo);
		timer.init();
		home.getContentPane().add(labelFundo, BorderLayout.CENTER);
		
		JPanel panelLateralImagem = new JPanel();
		panelLateralImagem.setLayout(new FlowLayout(FlowLayout.LEFT, 4, 4));
		panelLateralImagem.setPreferredSize(new Dimension(180, 400));
		panelLateralImagem.setBackground(new Color(128, 128, 128));

		JButton btnVoltarImagem = new JButton("");
		btnVoltarImagem.setToolTipText("Voltar");
		btnVoltarImagem.setPreferredSize(new Dimension(86, 34));
		panelLateralImagem.add(btnVoltarImagem);
		btnVoltarImagem.setBackground(Color.LIGHT_GRAY);
		btnVoltarImagem.setIcon(new ImageIcon("resources\\images\\imgVoltar.png"));
		btnVoltarImagem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				home.getContentPane().add(panelTopo, BorderLayout.NORTH);
				panelLateralImagem.setVisible(false);
				home.getContentPane().remove(panelLateralImagem);
				panelTopo.setVisible(true);
				panelTopo.revalidate();
			}
		});
		JButton btnHomePageImagem = new JButton();
		btnHomePageImagem.setToolTipText("Home Page");
		btnHomePageImagem.setPreferredSize(new Dimension(82, 34));
		btnHomePageImagem.setBackground(Color.LIGHT_GRAY);
		btnHomePageImagem.setIcon(new ImageIcon("resources\\images\\btnHomePage.png"));
		panelLateralImagem.add(btnHomePageImagem);

		JButton btnAdicionarImagem = new JButton("Adicionar");
		btnAdicionarImagem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				@SuppressWarnings({ "unused", "deprecation" })
				ImagemAdd addFilme = new ImagemAdd();
			}
		});

		btnAdicionarImagem.setToolTipText("Op\u00E7\u00E3o de acesso a aba Adicionar!");
		btnAdicionarImagem.setIcon(new ImageIcon("resources\\images\\imgBtnAdd.png"));
		btnAdicionarImagem.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAdicionarImagem.setPreferredSize(new Dimension(173, 34));
		panelLateralImagem.add(btnAdicionarImagem);
		btnAdicionarImagem.setBackground(Color.LIGHT_GRAY);
		home.isCursorSet();

		JButton btnFavoritosImagem = new JButton("Favoritos");
		btnFavoritosImagem.setToolTipText("Op\u00E7\u00E3o de acesso a aba dos Favoritos!");
		btnFavoritosImagem.setIcon(new ImageIcon("resources\\images\\imgBtnFavorito.png"));
		btnFavoritosImagem.setPreferredSize(new Dimension(172, 34));
		btnFavoritosImagem.setFont(new Font("Tahoma", Font.BOLD, 14));
		panelLateralImagem.add(btnFavoritosImagem);
		btnFavoritosImagem.setBackground(Color.LIGHT_GRAY);

		JButton btnColecaoImagem = new JButton("Listar ColeÐ·Ð³o");
		btnColecaoImagem.setToolTipText("Op\u00E7\u00E3o de acesso a aba ColeÐ·Ð³o!");
		btnColecaoImagem.setPreferredSize(new Dimension(172, 34));
		btnColecaoImagem.setIcon(new ImageIcon("resources\\images\\imgBtnCollection.png"));
		btnColecaoImagem.setFont(new Font("Tahoma", Font.BOLD, 14));
		panelLateralImagem.add(btnColecaoImagem);
		btnColecaoImagem.setBackground(Color.LIGHT_GRAY);

		btnImagem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				home.getContentPane().add(panelLateralImagem, BorderLayout.WEST);
				panelTopo.setVisible(false); 
				home.getContentPane().remove(panelTopo); 
				panelLateralImagem.setVisible(true); 
				panelLateralImagem.revalidate();
			}
		});
		
		JPanel panelLateralMusica = new JPanel();
		panelLateralMusica.setLayout(new FlowLayout(FlowLayout.LEFT, 4, 4));
		panelLateralMusica.setPreferredSize(new Dimension(180, 400));
		panelLateralMusica.setBackground(new Color(128, 128, 128));

		JButton btnVoltarMusica = new JButton("");
		btnVoltarMusica.setToolTipText("Voltar");
		btnVoltarMusica.setPreferredSize(new Dimension(86, 34));
		panelLateralMusica.add(btnVoltarMusica);
		btnVoltarMusica.setBackground(Color.LIGHT_GRAY);
		btnVoltarMusica.setIcon(new ImageIcon("resources\\images\\imgVoltar.png"));

		JButton btnHomePageMusica = new JButton();
		btnHomePageMusica.setToolTipText("Home Page");
		btnHomePageMusica.setPreferredSize(new Dimension(82, 34));
		btnHomePageMusica.setBackground(Color.LIGHT_GRAY);
		btnHomePageMusica.setIcon(new ImageIcon("resources\\images\\btnHomePage.png"));
		panelLateralMusica.add(btnHomePageMusica);

		JButton btnAdicionarMusica = new JButton("Adicionar");
		btnAdicionarMusica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				@SuppressWarnings("unused")
				MusicAdd addFilme = new MusicAdd(usrName);
			}
		});
		btnAdicionarMusica.setToolTipText("Op\u00E7\u00E3o de acesso a aba Adicionar!");
		btnAdicionarMusica.setIcon(new ImageIcon("resources\\images\\imgBtnAdd.png"));
		btnAdicionarMusica.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAdicionarMusica.setPreferredSize(new Dimension(173, 34));
		panelLateralMusica.add(btnAdicionarMusica);
		btnAdicionarMusica.setBackground(Color.LIGHT_GRAY);
		home.isCursorSet();

		JButton btnPlaylistMusica = new JButton("PlayList's");
		btnPlaylistMusica.setToolTipText("Op\u00E7\u00E3o de acesso a aba dos playList!");
		btnPlaylistMusica.setIcon(new ImageIcon("resources\\images\\playlist.png"));
		btnPlaylistMusica.setPreferredSize(new Dimension(172, 34));
		btnPlaylistMusica.setFont(new Font("Tahoma", Font.BOLD, 14));
		panelLateralMusica.add(btnPlaylistMusica);
		btnPlaylistMusica.setBackground(Color.LIGHT_GRAY);

		JButton btnEstilosMusica = new JButton("Estilos Musicais");
		btnEstilosMusica.setToolTipText("Opção de acesso a aba dos Favoritos!");
		btnEstilosMusica.setIcon(new ImageIcon("resources\\images\\btnEstilosMusicais.png"));
		btnEstilosMusica.setPreferredSize(new Dimension(172, 34));
		btnEstilosMusica.setFont(new Font("Tahoma", Font.BOLD, 14));
		panelLateralMusica.add(btnEstilosMusica);
		btnEstilosMusica.setBackground(Color.LIGHT_GRAY);

		playAllButton = new JButton("Reproduzir Tudo");
		playAllButton.setPreferredSize(new Dimension(172, 34));
		playAllButton.setBackground(Color.LIGHT_GRAY);
		playAllButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		playAllButton.setVisible(flag);
		panelLateralMusica.add(playAllButton, BorderLayout.SOUTH);

		JPanel panelLateralVideo = new JPanel();
		panelLateralVideo.setLayout(new FlowLayout(FlowLayout.LEFT, 4, 4));
		panelLateralVideo.setPreferredSize(new Dimension(180, 400));
		panelLateralVideo.setBackground(new Color(128, 128, 128));

		JButton btnVoltarVideo = new JButton("");
		btnVoltarVideo.setToolTipText("Voltar");
		btnVoltarVideo.setPreferredSize(new Dimension(86, 34));
		panelLateralVideo.add(btnVoltarVideo);
		btnVoltarVideo.setBackground(Color.LIGHT_GRAY);
		btnVoltarVideo.setIcon(new ImageIcon("resources\\images\\imgVoltar.png"));

		JButton btnHomePageVideo = new JButton();
		btnHomePageVideo.setToolTipText("Home Page");
		btnHomePageVideo.setPreferredSize(new Dimension(82, 34));
		btnHomePageVideo.setBackground(Color.LIGHT_GRAY);
		btnHomePageVideo.setIcon(new ImageIcon("resources\\images\\btnHomePage.png"));
		panelLateralVideo.add(btnHomePageVideo);

		JButton btnAdicionarVideo = new JButton("Adicionar");
		btnAdicionarVideo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				@SuppressWarnings("unused")
				FilmesAdd addFilme = new FilmesAdd(userName);
			}
		});
		btnAdicionarVideo.setToolTipText("Op\u00E7\u00E3o de acesso a aba Adicionar!");
		btnAdicionarVideo.setIcon(new ImageIcon("resources\\images\\imgBtnAdd.png"));
		btnAdicionarVideo.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAdicionarVideo.setPreferredSize(new Dimension(173, 34));
		panelLateralVideo.add(btnAdicionarVideo);
		btnAdicionarVideo.setBackground(Color.LIGHT_GRAY);

		JButton btnFavoritosVideo = new JButton("Favoritos");
		btnFavoritosVideo.setToolTipText("Op\u00E7\u00E3o de acesso a aba dos Favoritos!");
		btnFavoritosVideo.setIcon(new ImageIcon("resources\\images\\imgBtnFavorito.png"));
		btnFavoritosVideo.setPreferredSize(new Dimension(172, 34));
		btnFavoritosVideo.setFont(new Font("Tahoma", Font.BOLD, 14));
		panelLateralVideo.add(btnFavoritosVideo);
		btnFavoritosVideo.setBackground(Color.LIGHT_GRAY);

		JButton btnFilmes = new JButton("Filmes");
		btnFilmes.setIcon(new ImageIcon("resources\\images\\imgBtnFilme.png"));
		btnFilmes.setToolTipText("Op\u00E7\u00E3o de acesso a aba Adicionar!");
		btnFilmes.setPreferredSize(new Dimension(173, 34));
		btnFilmes.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnFilmes.setBackground(Color.LIGHT_GRAY);
		panelLateralVideo.add(btnFilmes);

		JButton btnSeries = new JButton("S\u00E9ries");
		btnSeries.setIcon(new ImageIcon("resources\\images\\imgBtnSeries.png"));
		btnSeries.setToolTipText("Op\u00E7\u00E3o de acesso a aba Adicionar!");
		btnSeries.setPreferredSize(new Dimension(173, 34));
		btnSeries.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSeries.setBackground(Color.LIGHT_GRAY);
		panelLateralVideo.add(btnSeries);

		panelCategoriasFilmes = new JPanel();
		panelCategoriasFilmes.setLayout(new FlowLayout(FlowLayout.CENTER));
		panelCategoriasFilmes.setPreferredSize(new Dimension(500, 300));
		panelCategoriasFilmes.setBackground(new Color(120, 120, 120));

		panelGeral = new JPanel();
		panelGeral.setLayout(new FlowLayout(FlowLayout.CENTER));
		panelGeral.setPreferredSize(new Dimension(500, 300));
		panelGeral.setBackground(new Color(120, 120, 120));

		panelCategoriasSerie = new JPanel();
		panelCategoriasSerie.setLayout(new FlowLayout(FlowLayout.CENTER));
		panelCategoriasSerie.setPreferredSize(new Dimension(500, 300));
		panelCategoriasSerie.setBackground(new Color(120, 120, 120));

		panelCategoriasMusica = new JPanel();
		panelCategoriasMusica.setLayout(new FlowLayout(FlowLayout.CENTER));
		panelCategoriasMusica.setPreferredSize(new Dimension(500, 300));
		panelCategoriasMusica.setBackground(new Color(120, 120, 120));

		btnMusica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				home.getContentPane().add(panelLateralMusica, BorderLayout.WEST);
				panelTopo.setVisible(false); 
				home.getContentPane().remove(panelTopo); 
				panelLateralMusica.setVisible(true); 
				panelLateralMusica.revalidate();
				home.setTitle("Música - TecaPlay");
			}
		});
		btnVideo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				home.getContentPane().add(panelLateralVideo, BorderLayout.WEST);
				panelTopo.setVisible(false); 
				home.getContentPane().remove(panelTopo); 
				panelLateralVideo.setVisible(true); 
				panelLateralVideo.revalidate();
				home.setTitle("Vídeo - TecaPlay");
			}
		});

		btnHomePageVideo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				home.getContentPane().removeAll();
				voltarPaineis.removeAll(voltarPaineis);
				home.getContentPane().add(panelTopo, BorderLayout.NORTH);
				home.getContentPane().add(labelFundo, BorderLayout.CENTER);
				home.getContentPane().add(panelPlayer, BorderLayout.SOUTH);
				labelFundo.setVisible(true);
				labelFundo.revalidate();
				timer.init();
				home.setTitle("Home - TecaPlay");
				panelTopo.setVisible(true);
				panelTopo.revalidate();
			}
		});
		btnHomePageMusica.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				playAllButton.setVisible(false);
				home.getContentPane().removeAll();
				voltarPaineis.removeAll(voltarPaineis);
				home.getContentPane().add(panelTopo, BorderLayout.NORTH);
				home.getContentPane().add(labelFundo, BorderLayout.CENTER);
				home.getContentPane().add(panelPlayer, BorderLayout.SOUTH);
				labelFundo.setVisible(true);
				labelFundo.revalidate();
				timer.init();
				home.setTitle("Home - TecaPlay");
				panelTopo.setVisible(true);
				panelTopo.revalidate();
			}
		});

		btnHomePageImagem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				home.getContentPane().removeAll();
				voltarPaineis.removeAll(voltarPaineis);
				home.getContentPane().add(panelTopo, BorderLayout.NORTH);
				home.getContentPane().add(labelFundo, BorderLayout.CENTER);
				home.getContentPane().add(panelPlayer, BorderLayout.SOUTH);
				labelFundo.setVisible(true);
				labelFundo.revalidate();
				timer.init();
				home.setTitle("Home - TecaPlay");
				panelTopo.setVisible(true);
				panelTopo.revalidate();
			}
		});

		btnVoltarMusica.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				playAllButton.setVisible(false);
				if (voltarPaineis.isEmpty()) {
					home.getContentPane().add(panelTopo, BorderLayout.NORTH);
					panelLateralVideo.setVisible(false);
					home.getContentPane().remove(panelLateralMusica);
					home.getContentPane().remove(panelGeral);
					panelTopo.setVisible(true);
					home.setTitle("Home - TecaPlay");
					home.getContentPane().add(labelFundo, BorderLayout.CENTER);
					panelTopo.revalidate();
					home.revalidate();
					timer.init();
				} else if (voltarPaineis.size() == 1) {
					home.getContentPane().remove(voltarPaineis.get(0));
					home.getContentPane().add(labelFundo, BorderLayout.CENTER);
					voltarPaineis.get(0).setVisible(false);
					voltarPaineis.get(0).revalidate();
					voltarPaineis.get(0).repaint();
					home.setTitle("Música - TecaPlay");
					labelFundo.revalidate();
					labelFundo.repaint();
					voltarPaineis.remove(voltarPaineis.size() - 1);
				} else if (voltarPaineis.size() == 2) {
					home.getContentPane().remove(voltarPaineis.get(1));
					voltarPaineis.get(1).revalidate();
					voltarPaineis.get(1).repaint();
					voltarPaineis.get(1).setVisible(false);
					home.getContentPane().add(voltarPaineis.get(0), BorderLayout.CENTER);
					voltarPaineis.get(0).setVisible(true);
					voltarPaineis.get(0).revalidate();
					voltarPaineis.get(0).repaint();
					voltarPaineis.remove(voltarPaineis.size() - 1);
				}
				try {
					listFiles.reUpdateTable(table, userName, currentGenero, music);
				} catch (NullPointerException ne) {
					ne.getStackTrace();
				}
			}
		});

		btnEstilosMusica.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				playAllButton.setVisible(false);
				if (voltarPaineis.size() == 2) {
					home.getContentPane().remove(voltarPaineis.get(1));
				}
				voltarPaineis = new ArrayList<JPanel>();
				voltarPaineis.removeAll(voltarPaineis);
				voltarPaineis.add(panelCategoriasMusica);
				panelGeral.removeAll();
				home.setTitle("Estilos Musicais - TecaPlay");
				home.getContentPane().remove(labelFundo);
				home.getContentPane().remove(panelGeral);
				home.getContentPane().remove(panelCategoriasMusica);
				home.getContentPane().add(panelCategoriasMusica, BorderLayout.CENTER);
				panelCategoriasMusica.setVisible(true); // ativa o panel lateral
				panelCategoriasMusica.revalidate();// revalida o layout
				panelCategoriasMusica.repaint();
				timer.clse();
				addButtonsMusica();
			}
		});
		
		btnPlaylistMusica.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				playAllButton.setVisible(false);
				currentGenero = "Playlist";
				panelGeral.removeAll();
				home.setTitle("Playlists - TecaPlay");
				atualizaPanelGeral();
				acaoButtonPlayListOrFavorites();

			}
		});

		btnFavoritosVideo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				currentGenero = "Favoritos";
				panelGeral.removeAll();
				home.getContentPane().remove(labelFundo);
				home.getContentPane().remove(panelCategoriasFilmes);
				home.getContentPane().remove(panelCategoriasSerie);
				home.setTitle("Favoritos - TecaPlay");
				atualizaPanelGeral();
				acaoButtonPlayListOrFavorites();
			}
		});

		btnFilmes.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {
				if (voltarPaineis.size() == 2) {
					home.getContentPane().remove(voltarPaineis.get(1));
				}
				panelGeral.removeAll();
				home.setTitle("Filmes - TecaPlay");
				panelGeral = new JPanel();
				atualizaPanelGeral();
				voltarPaineis = new ArrayList<JPanel>();
				voltarPaineis.removeAll(voltarPaineis);
				voltarPaineis.add(panelCategoriasFilmes);
				panelCategoriasSerie.removeAll();
				panelCategoriasFilmes.removeAll();
				home.getContentPane().remove(labelFundo);
				home.getContentPane().remove(panelCategoriasFilmes);
				home.getContentPane().remove(panelCategoriasSerie);
				home.getContentPane().add(panelCategoriasFilmes, BorderLayout.CENTER);
				panelCategoriasFilmes.setVisible(true);
				panelCategoriasFilmes.revalidate();
				panelCategoriasFilmes.repaint();
				timer.clse();
				addButtonsFilmes();
			}
		});

		btnSeries.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {
				if (voltarPaineis.size() == 2) {
					home.getContentPane().remove(voltarPaineis.get(1));
				}
				panelGeral.removeAll();
				panelGeral = new JPanel();
				atualizaPanelGeral();
				home.setTitle("Séries - TecaPlay");
				voltarPaineis = new ArrayList<JPanel>();
				voltarPaineis.removeAll(voltarPaineis);
				voltarPaineis.add(panelCategoriasSerie);
				home.getContentPane().remove(labelFundo);
				panelCategoriasSerie.removeAll();
				panelCategoriasFilmes.removeAll();
				home.getContentPane().remove(panelCategoriasFilmes);
				home.getContentPane().remove(panelCategoriasSerie);
				home.getContentPane().add(panelCategoriasSerie, BorderLayout.CENTER);
				panelCategoriasSerie.setVisible(true);
				panelCategoriasSerie.revalidate();
				panelCategoriasSerie.repaint();
				timer.clse();
				addButtonsSeries();
			}
		});

		btnVoltarVideo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (voltarPaineis.isEmpty()) {
					home.getContentPane().add(panelTopo, BorderLayout.NORTH);
					panelLateralVideo.setVisible(false);
					home.getContentPane().remove(panelLateralVideo);
					panelTopo.setVisible(true);
					home.getContentPane().add(labelFundo, BorderLayout.CENTER);
					panelTopo.revalidate();
					home.setTitle("Home - TecaPlay");
					home.revalidate();
					timer.init();
				} else if (voltarPaineis.size() == 1) {
					home.getContentPane().remove(voltarPaineis.get(0));
					home.getContentPane().add(labelFundo, BorderLayout.CENTER);
					voltarPaineis.get(0).setVisible(false);
					voltarPaineis.get(0).revalidate();
					voltarPaineis.get(0).repaint();
					home.setTitle("Vídeo - TecaPlay");
					labelFundo.revalidate();
					labelFundo.repaint();
					voltarPaineis.remove(voltarPaineis.size() - 1);
				} else if (voltarPaineis.size() == 2) {
					home.getContentPane().remove(voltarPaineis.get(1));
					voltarPaineis.get(1).revalidate();
					voltarPaineis.get(1).repaint();
					home.getContentPane().add(voltarPaineis.get(0), BorderLayout.CENTER);
					voltarPaineis.get(0).setVisible(true);
					voltarPaineis.get(0).revalidate();
					voltarPaineis.get(0).repaint();
					voltarPaineis.remove(voltarPaineis.size() - 1);
				}
				try {
					listFiles.reUpdateTable(table, userName, currentGenero, music);
				} catch (NullPointerException ne) {
					ne.getStackTrace();
				}
			}
		});

		playAllButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (firstPlay) {
					MusicPlayer.stop();
					MusicPlayer.play();
				} else {
					MusicPlayer.play();
					firstPlay = true;
				}
			}
		});
	}

	/**
	 * Action if button clicked at movie.
	 * 
	 * @return null
	 */
	public ActionListener acaoButtons(String genero) {
		playAllButton.setVisible(false);
		music = "";
		Boolean ler = false;
		ler = FRarquivos.verificaGeneroExistenteFilmes(userName, genero);
		if (ler) {
			voltarPaineis.add(panelGeral);
			home.add(voltarPaineis.get(1), BorderLayout.CENTER);
			listFiles.reUpdateTable(table, userName, genero, music);
			tableContainer.setPreferredSize(new Dimension(790, 500));
			panelGeral.add(tableContainer, BorderLayout.CENTER);
			panelCategoriasFilmes.setVisible(false);
			home.getContentPane().remove(panelCategoriasFilmes);
			panelGeral.setVisible(true);
			panelGeral.revalidate();

		} else {
			JOptionPane.showMessageDialog(null, "Não à nada a ser listado", "Inválido", 0);
		}
		return null;

	}

	/**
	 * Action if button clicked at music.
	 * 
	 * @return null
	 */
	public ActionListener acaoButtonsMusic(String genero) {
		currentGenero = genero;
		playAllButton.setVisible(false);
		music = "Musicas";
		Boolean ler = false;
		ler = FRarquivos.verificaGeneroExistenteMusica(userName, currentGenero);
		if (ler) {
			playAllButton.setVisible(true);
			voltarPaineis.add(panelGeral);
			home.add(voltarPaineis.get(1), BorderLayout.CENTER);
			listFiles.reUpdateTable(table, userName, currentGenero, music);
			tableContainer.setPreferredSize(new Dimension(790, 500));
			panelGeral.add(tableContainer, BorderLayout.CENTER);
			panelCategoriasMusica.setVisible(false);
			home.getContentPane().remove(panelCategoriasMusica);
			panelGeral.setVisible(true);
			panelGeral.revalidate();
		} else {
			JOptionPane.showMessageDialog(null, "Não à nada a ser listado", "Inválido", 0);
		}
		return null;

	}

	/**
	 * Action if button clicked at series.
	 * 
	 * @return null
	 */
	public ActionListener acaoButtonsSerie(String genero) {
		Boolean ler = false;  
		currentGenero = genero;
		ler = FRarquivos.verificaGeneroExistenteSerie(userName, currentGenero);
		if (ler) {
			voltarPaineis.add(panelGeral);
			home.add(voltarPaineis.get(1), BorderLayout.CENTER);
			panelCategoriasSerie.setVisible(false);
			home.getContentPane().remove(panelCategoriasSerie);
			panelGeral.setVisible(true);
			panelGeral.revalidate();
			addButtonSerieNoLabel();
		} else {
			JOptionPane.showMessageDialog(null, "Não à nada a ser listado", "Inválido", 0);
		}
		return null;

	}

	/**
	 * Action of playlist buttons
	 */
	public void acaoButtonPlayListOrFavorites() {
		playAllButton.setVisible(false);
		Boolean ler = false;
		ler = FRarquivos.verifyPlaylistOrFavoriteExist(userName, currentGenero);
		if (ler) {
			if (voltarPaineis.size() == 2) {
				home.getContentPane().remove(voltarPaineis.get(1));
			}
			voltarPaineis = new ArrayList<JPanel>();
			voltarPaineis.removeAll(voltarPaineis);
			voltarPaineis.add(panelGeral);
			home.getContentPane().remove(panelGeral);
			home.getContentPane().remove(labelFundo);
			home.getContentPane().remove(panelCategoriasMusica);
			home.getContentPane().add(panelGeral, BorderLayout.CENTER);
			panelGeral.setVisible(true);
			panelGeral.revalidate();
			timer.clse();
			addButtonsPlaylistOrFavorites();
		} else {
			JOptionPane.showMessageDialog(null, "Não à nada a ser listado", "Inválido", 0);
		}
	}

	/**
	 * Update panel to use as a main panel
	 */
	public void atualizaPanelGeral() {
		playAllButton.setVisible(false);
		panelGeral.removeAll();
		panelGeral = new JPanel();
		panelGeral.setLayout(new FlowLayout(FlowLayout.CENTER));
		panelGeral.setPreferredSize(new Dimension(500, 300));
		panelGeral.setBackground(new Color(120, 254, 120));
	}

	/**
	 * Function to update and populate panel with buttons gives series of genre x
	 */
	public void addButtonSerieNoLabel() {
		AtualizeSeries atualize = new AtualizeSeries(userName, currentGenero);
		int size = atualize.Size();
		arrayBtns = new JButton[size];
		for (int i = 0; i < size; i++) {
			String nameSerie = atualize.NameSeries(i);
			if (!nameSerie.equals("nomeSerie")) {
				arrayBtns[i] = new JButton(nameSerie);
				arrayBtns[i].setPreferredSize(new Dimension(127, 135));
				arrayBtns[i].setFont(new Font("Tahoma", Font.BOLD, 14));
				panelGeral.add(arrayBtns[i]);
				arrayBtns[i].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						addTempSerie(evt);
					}
				});
			}
		}

	}

	/**
	 * List files at Table
	 * 
	 * @param evt
	 * @return null
	 */
	public ActionListener addTempSerie(ActionEvent evt) {
		playAllButton.setVisible(true);
		panelGeral.removeAll();
		JButton botao = (JButton) evt.getSource();
		String name = botao.getText();
		home.getContentPane().remove(voltarPaineis.get(1));
		home.getContentPane().add(voltarPaineis.get(1), BorderLayout.CENTER);
		listFilesSeries.reUpdateTable(tableSeries, userName, currentGenero, name);
		tableContainerSeries.setPreferredSize(new Dimension(790, 500));
		panelGeral.add(tableContainerSeries, BorderLayout.CENTER);
		panelGeral.setVisible(true);
		panelGeral.revalidate();
		return null;

	}


	public void addButtonsPlaylistOrFavorites() {
		AtualizePlaylistsOrFavorites atualize = new AtualizePlaylistsOrFavorites(userName, currentGenero);
		int size = atualize.Size();
		arrayBtns = new JButton[size];
		for (int i = 0; i < size; i++) {
			String PlaylistName = atualize.PlaylistNames(i);
			arrayBtns[i] = new JButton(PlaylistName);
			arrayBtns[i].setPreferredSize(new Dimension(127, 135));
			arrayBtns[i].setFont(new Font("Tahoma", Font.BOLD, 14));
			panelGeral.add(arrayBtns[i]);
			arrayBtns[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					listPlaylistOrFavorites(evt);
				}
			});

		}
	}

	/**
	 * List playlists
	 * 
	 * @param evt
	 */

	public void listPlaylistOrFavorites(ActionEvent evt) {
		playAllButton.setVisible(true);
		JButton botao = (JButton) evt.getSource();
		String name = botao.getText();
		name = name + ".txt";
		listFilePlayList.reUpdateTable(tablePlaylist, userName, name, currentGenero);
		tableContainerPlaylist.setPreferredSize(new Dimension(790, 500));
		playlistPanel = new JPanel();
		playlistPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		playlistPanel.setPreferredSize(new Dimension(500, 300));
		playlistPanel.setBackground(new Color(250, 254, 120));
		playlistPanel.add(tableContainerPlaylist, BorderLayout.CENTER);
		playlistPanel.setVisible(true);
		playlistPanel.revalidate();
		playlistPanel.repaint();
		voltarPaineis.add(playlistPanel);
		panelGeral.setVisible(false);
		home.getContentPane().remove(voltarPaineis.get(1));
		home.getContentPane().add(voltarPaineis.get(1), BorderLayout.CENTER);
	}

	/**
	 * Add buttons at filmes panel
	 * 
	 */

	public void addButtonsFilmes() {
		ArrayList<String> list = ArrayCategorias.addFilmes();
		int size = list.size();
		buttonCatFilmes = new JButton[size];
		for (int i = 0; i < size; i++) {
			String PlaylistName = list.get(i);
			buttonCatFilmes[i] = new JButton(PlaylistName);
			buttonCatFilmes[i].setPreferredSize(new Dimension(127, 135));
			buttonCatFilmes[i].setFont(new Font("Tahoma", Font.BOLD, 14));
			panelCategoriasFilmes.add(buttonCatFilmes[i]);
			buttonCatFilmes[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					acaoButtons(PlaylistName);
				}
			});

		}
	}

	/**
	 * Add buttons at series panel
	 * 
	 */

	public void addButtonsSeries() {
		ArrayList<String> list = ArrayCategorias.addSeries();
		int size = list.size();
		buttonCatSeries = new JButton[size];
		for (int i = 0; i < size; i++) {
			String PlaylistName = list.get(i);
			buttonCatSeries[i] = new JButton(PlaylistName);
			buttonCatSeries[i].setPreferredSize(new Dimension(127, 135));
			buttonCatSeries[i].setFont(new Font("Tahoma", Font.BOLD, 14));
			panelCategoriasSerie.add(buttonCatSeries[i]);
			buttonCatSeries[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					acaoButtonsSerie(PlaylistName);
				}
			});

		}
	}

	/**
	 * Add buttons at music panel
	 * 
	 */

	public void addButtonsMusica() {
		ArrayList<String> list = ArrayCategorias.addMusicas();
		int size = list.size();
		panelCategoriasMusica.removeAll();
		buttonCatMusica = new JButton[size];
		for (int i = 0; i < size; i++) {
			String PlaylistName = list.get(i);
			buttonCatMusica[i] = new JButton(PlaylistName);
			buttonCatMusica[i].setPreferredSize(new Dimension(127, 135));
			buttonCatMusica[i].setFont(new Font("Tahoma", Font.BOLD, 14));
			panelCategoriasMusica.add(buttonCatMusica[i]);
			buttonCatMusica[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					acaoButtonsMusic(PlaylistName);
				}
			});

		}
	}

}