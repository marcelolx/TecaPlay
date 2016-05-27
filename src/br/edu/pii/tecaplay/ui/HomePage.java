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

import br.edu.pii.tecaplay.util.AtualizeSeries;
import br.edu.pii.tecaplay.util.FRarquivos;
import br.edu.pii.tecaplay.util.FileUtil;
import br.edu.pii.tecaplay.util.ListFiles;
import br.edu.pii.tecaplay.util.TimerToLabel;

public class HomePage {

	private ArrayList<JPanel> voltarPaineis = new ArrayList<>();
	private JTable table = new JTable();
	private ListFiles listFiles = new ListFiles();
	private JButton[] arrayBtnSeries;
	private JScrollPane tableContainer = new JScrollPane(table);
	private String currentGenero = null;
	private String userName;
	private String music  = "";
	private JFrame home;
	private JPanel labelGeral;
	private JPanel panelSerie;
	

	/**
	* 
	*/
	public HomePage(String usrName) {
		userName = usrName;
		// formatcao do JFrame
		home = new JFrame();
		home.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent args) {
				home.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
				FileUtil.sair();
			}
		});
		home.setVisible(true);// Deixar visivel
		home.setBackground(new Color(25, 25, 25));// cor de Background
		home.setTitle("Home - TecaPlay"); // titulo na barra do windows
 
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (screen.width) - 386;
		int height = (screen.height) - 208;
		int x = (screen.width - width) / 2;
		int y = (screen.height - height) / 2;
		home.setBounds(x, y, width, height);// seta o tamanho da janela e sua
											// posição na tela.
		home.setResizable(false); // impossibilidade de altarar tamanho da
									// janela
		home.setIconImage(Toolkit.getDefaultToolkit().getImage("resources\\images\\newLogo.png")); // icone
																									// da
																									// barra
		// cri do menu superior
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(Color.LIGHT_GRAY);// background do menu
		home.setJMenuBar(menuBar);

		// adiÐ·Ð³o de botao de menu
		JMenu menuArquivo = new JMenu("Arquivo");
		menuArquivo.setMnemonic('A');
		menuArquivo.setBackground(Color.DARK_GRAY);
		menuArquivo.setIcon(new ImageIcon("resources\\images\\imgMenuArquivo.png"));// adiÐ·Ð³o
		menuBar.add(menuArquivo); // adicionado ao container do menu do topo

		// submenu do menu arquivo com a funÐ·Ð³o de sair do programa
		JMenuItem subMenuSair = new JMenuItem("Sair");
		// evento de fechar o programa
		subMenuSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FileUtil.sair();
			}
		});
		subMenuSair.setIcon(new ImageIcon("resources\\images\\imgMenuSair.png"));
		subMenuSair.setSelected(true);
		menuArquivo.add(subMenuSair);

		// menu sobre adicionado do lado do menu arquivo
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

		// criado painel aonde ficarÐ³o os botoes para a escolha de musica,
		// video
		// ou imagem
		JPanel panelTopo = new JPanel();
		panelTopo.setAutoscrolls(true);
		panelTopo.setFocusTraversalPolicyProvider(true);
		panelTopo.setFocusCycleRoot(true);
		panelTopo.setIgnoreRepaint(true);
		panelTopo.setBackground(new Color(127, 127, 127));
		home.getContentPane().add(panelTopo, BorderLayout.NORTH);

		/**
		 * cri de botoes video/musica/imagem
		 */

		JButton btnVideo = new JButton("V\u00EDdeo");

		panelTopo.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		btnVideo.setToolTipText("Op\u00E7\u00E3o de acesso a aba V\u00EDdeo!");
		btnVideo.setIcon(new ImageIcon("resources\\images\\imgBtnVideo.png"));// icone
																				// do
																				// botao
		btnVideo.setFont(new Font("Tahoma", Font.BOLD, 14)); // tipo de fonte do
																// botao
		btnVideo.setBackground(Color.LIGHT_GRAY);
		btnVideo.setPreferredSize(new Dimension(173, 42));
		panelTopo.add(btnVideo);
		home.isCursorSet();

		JButton btnMusica = new JButton("Música");
		btnMusica.setToolTipText("Op\u00E7\u00E3o de acesso a aba M\u00FAsica!");
		btnMusica.setIcon(new ImageIcon("resources\\images\\imgBtnMusica.png"));// icone
																				// do
																			// botao
		btnMusica.setFont(new Font("Tahoma", Font.BOLD, 14)); // tipo de fonte
																// do botao
		btnMusica.setPreferredSize(new Dimension(173, 42));
		btnMusica.setBackground(Color.LIGHT_GRAY);
		panelTopo.add(btnMusica);
		home.isCursorSet();

		JButton btnImagem = new JButton("Imagem");
		btnImagem.setToolTipText("Op\u00E7\u00E3o de acesso a aba Imagem!");
		btnImagem.setIcon(new ImageIcon("resources\\images\\imgBtnImagem.png")); // icone
																					// do
																					// botao
		btnImagem.setFont(new Font("Tahoma", Font.BOLD, 14)); // tipo de fonte
																// do botao
		btnImagem.setPreferredSize(new Dimension(173, 42));
		btnImagem.setBackground(Color.LIGHT_GRAY);
		panelTopo.add(btnImagem);

		// BANNER PRINCIPAL
		JLabel labelFundo = new JLabel("");
		labelFundo.setSize(400, 400);
		labelFundo.setIcon(new ImageIcon("resources\\images\\bannerPrincipal.jpg"));
		/**
		 * @TimerToLabel Classe que faz o trabalho de mudar a imagem de fundo.
		 */
		final TimerToLabel timer = new TimerToLabel(30000, labelFundo);
		timer.init();
		home.getContentPane().add(labelFundo, BorderLayout.CENTER);

		/**
		 * 
		 * AdiÐ·Ð³o de Painel Lateral para abrigar os botoes de gerenciar o que
		 * serÐ± apresentado
		 * 
		 * 
		 * Imagem LATERAL
		 * 
		 */
		
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

		// jButton Adicionar
		JButton btnAdicionarImagem = new JButton("Adicionar");
		btnAdicionarImagem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				@SuppressWarnings("unused")
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

		// jButton Remover
		JButton btnRemoveImagem = new JButton("Remover");
		btnRemoveImagem.setToolTipText("Op\u00E7\u00E3o de acesso a aba Remover!");
		btnRemoveImagem.setIcon(new ImageIcon("resources\\images\\imgBtnRemover.png"));
		btnRemoveImagem.setPreferredSize(new Dimension(172, 34));
		btnRemoveImagem.setFont(new Font("Tahoma", Font.BOLD, 14));
		panelLateralImagem.add(btnRemoveImagem);
		btnRemoveImagem.setBackground(Color.LIGHT_GRAY);

		// jButton Favoritos
		JButton btnFavoritosImagem = new JButton("Favoritos");
		btnFavoritosImagem.setToolTipText("Op\u00E7\u00E3o de acesso a aba dos Favoritos!");
		btnFavoritosImagem.setIcon(new ImageIcon("resources\\images\\imgBtnFavorito.png"));
		btnFavoritosImagem.setPreferredSize(new Dimension(172, 34));
		btnFavoritosImagem.setFont(new Font("Tahoma", Font.BOLD, 14));
		panelLateralImagem.add(btnFavoritosImagem);
		btnFavoritosImagem.setBackground(Color.LIGHT_GRAY);

		// jButton Sorteio de algum
		JButton btnColecaoImagem = new JButton("Listar ColeÐ·Ð³o");
		btnColecaoImagem.setToolTipText("Op\u00E7\u00E3o de acesso a aba ColeÐ·Ð³o!");
		btnColecaoImagem.setPreferredSize(new Dimension(172, 34));
		btnColecaoImagem.setIcon(new ImageIcon("resources\\images\\imgBtnCollection.png"));
		btnColecaoImagem.setFont(new Font("Tahoma", Font.BOLD, 14));
		panelLateralImagem.add(btnColecaoImagem);
		btnColecaoImagem.setBackground(Color.LIGHT_GRAY);

		//  que serÐ± realizada ao apertar o botao de Imagem do jpanelTopo
		btnImagem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				home.getContentPane().add(panelLateralImagem, BorderLayout.WEST);
				panelTopo.setVisible(false); // Torna a visibilidade do
												// paineltopo falsa
				home.getContentPane().remove(panelTopo); // Remove esse painel
				panelLateralImagem.setVisible(true); // Ativa o painel lateral
														// referente ao video
				panelLateralImagem.revalidate();// revalida o loyout
			}
		});

		/**
		 * JPanel Lateral para a mostrar o panel Musica LATERAL
		 */

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

		// jButton Adicionar
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

		// jButton Remover
		JButton btnRemoverMusica = new JButton("Remover");
		btnRemoverMusica.setToolTipText("Op\u00E7\u00E3o de acesso a aba Remover!");
		btnRemoverMusica.setIcon(new ImageIcon("resources\\images\\imgBtnRemover.png"));
		btnRemoverMusica.setPreferredSize(new Dimension(172, 34));
		btnRemoverMusica.setFont(new Font("Tahoma", Font.BOLD, 14));
		panelLateralMusica.add(btnRemoverMusica);
		btnRemoverMusica.setBackground(Color.LIGHT_GRAY);

		// jButton Playlists
		JButton btnPlaylistMusica = new JButton("PlayList's");
		btnPlaylistMusica.setToolTipText("Op\u00E7\u00E3o de acesso a aba dos playList!");
		btnPlaylistMusica.setIcon(new ImageIcon("resources\\images\\playlist.png"));
		btnPlaylistMusica.setPreferredSize(new Dimension(172, 34));
		btnPlaylistMusica.setFont(new Font("Tahoma", Font.BOLD, 14));
		panelLateralMusica.add(btnPlaylistMusica);
		btnPlaylistMusica.setBackground(Color.LIGHT_GRAY);
		
		//JPanel para playlist
		JPanel panelPlaylist = new JPanel();
		panelPlaylist.setLayout(new FlowLayout(FlowLayout.LEFT, 4, 4));
		panelPlaylist.setPreferredSize(new Dimension(180, 400));
		panelPlaylist.setBackground(new Color(128, 128, 128));


		// jButton Estilos Musicais
		JButton btnEstilosMusica = new JButton("Estilos Musicais");
		btnEstilosMusica.setToolTipText("Opção de acesso a aba dos Favoritos!");
		btnEstilosMusica.setIcon(new ImageIcon("resources\\images\\btnEstilosMusicais.png"));
		btnEstilosMusica.setPreferredSize(new Dimension(172, 34));
		btnEstilosMusica.setFont(new Font("Tahoma", Font.BOLD, 14));
		panelLateralMusica.add(btnEstilosMusica);
		btnEstilosMusica.setBackground(Color.LIGHT_GRAY);

		// jButton Sorteio filmes
		JButton btnSorteioMusica = new JButton("Random Musica");
		btnSorteioMusica.setToolTipText("Op\u00E7\u00E3o de acesso a aba Sorteio!");
		btnSorteioMusica.setPreferredSize(new Dimension(172, 34));
		btnSorteioMusica.setIcon(new ImageIcon("resources\\images\\imgBtnRandom.png"));
		btnSorteioMusica.setFont(new Font("Tahoma", Font.BOLD, 14));
		panelLateralMusica.add(btnSorteioMusica);
		btnSorteioMusica.setBackground(Color.LIGHT_GRAY);


		/**
		 * Jpanel Lateral para a chamada do panel de Videos
		 */

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

		// jButton Adicionar
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


		// jButton Favoritos
		JButton btnFavoritosVideo = new JButton("Favoritos");
		btnFavoritosVideo.setToolTipText("Op\u00E7\u00E3o de acesso a aba dos Favoritos!");
		btnFavoritosVideo.setIcon(new ImageIcon("resources\\images\\imgBtnFavorito.png"));
		btnFavoritosVideo.setPreferredSize(new Dimension(172, 34));
		btnFavoritosVideo.setFont(new Font("Tahoma", Font.BOLD, 14));
		panelLateralVideo.add(btnFavoritosVideo);
		btnFavoritosVideo.setBackground(Color.LIGHT_GRAY);

		// Jbuttom para listar os Filmes

		JButton btnFilmes = new JButton("Filmes");
		btnFilmes.setIcon(new ImageIcon("resources\\images\\imgBtnFilme.png"));
		btnFilmes.setToolTipText("Op\u00E7\u00E3o de acesso a aba Adicionar!");
		btnFilmes.setPreferredSize(new Dimension(173, 34));
		btnFilmes.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnFilmes.setBackground(Color.LIGHT_GRAY);
		panelLateralVideo.add(btnFilmes);

		// Jbuttom para listar as SÐ¹ries
		JButton btnSeries = new JButton("S\u00E9ries");
		btnSeries.setIcon(new ImageIcon("resources\\images\\imgBtnSeries.png"));
		btnSeries.setToolTipText("Op\u00E7\u00E3o de acesso a aba Adicionar!");
		btnSeries.setPreferredSize(new Dimension(173, 34));
		btnSeries.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSeries.setBackground(Color.LIGHT_GRAY);
		panelLateralVideo.add(btnSeries);

		// jButton Sorteio de algum filme
		JButton btnSorteioVideo = new JButton("Sorteio de Filme");
		btnSorteioVideo.setToolTipText("Op\u00E7\u00E3o de acesso a aba Sorteio!");
		btnSorteioVideo.setPreferredSize(new Dimension(172, 34));
		btnSorteioVideo.setIcon(new ImageIcon("resources\\images\\imgBtnRandom.png"));
		btnSorteioVideo.setFont(new Font("Tahoma", Font.BOLD, 14));
		panelLateralVideo.add(btnSorteioVideo);
		btnSorteioVideo.setBackground(Color.LIGHT_GRAY);
		
		
		panelSerie = new JPanel();
		panelSerie.setLayout(new FlowLayout(FlowLayout.CENTER));
		panelSerie.setPreferredSize(new Dimension(500, 300));
		panelSerie.setBackground(new Color(120, 252, 120));
		/*
		 * 
		 * 
		 * FILMES/CAREGORIAS Painel de categorias que serÐ± chamado ao apertar
		 * no jbutton btnFilmes
		 * 
		 * 
		 * 
		 */

		JPanel panelCategoriasFilmes = new JPanel();
		panelCategoriasFilmes.setLayout(new FlowLayout(FlowLayout.CENTER));
		panelCategoriasFilmes.setPreferredSize(new Dimension(500, 300));
		panelCategoriasFilmes.setBackground(new Color(120, 120, 120));

		JButton btnCatAcao = new JButton("A\u00E7\u00E3o");
		btnCatAcao.setToolTipText("Categoria A\u00E7\u00E3o.");
		btnCatAcao.setPreferredSize(new Dimension(127, 135));
		btnCatAcao.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCatAcao.setBackground(Color.LIGHT_GRAY);
		panelCategoriasFilmes.add(btnCatAcao);

		JButton btnCatAnimacao = new JButton("Anima\u00E7\u00E3o");
		btnCatAnimacao.setToolTipText("Categoria Anima\u00E7\u00E3o.");
		btnCatAnimacao.setPreferredSize(new Dimension(127, 135));
		btnCatAnimacao.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCatAnimacao.setBackground(Color.LIGHT_GRAY);
		panelCategoriasFilmes.add(btnCatAnimacao);

		JButton btnCatAventura = new JButton("Aventura");
		btnCatAventura.setToolTipText("Categoria Aventura.");
		btnCatAventura.setPreferredSize(new Dimension(127, 135));
		btnCatAventura.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCatAventura.setBackground(Color.LIGHT_GRAY);
		panelCategoriasFilmes.add(btnCatAventura);

		JButton btnCatClassico = new JButton("Cl\u00E1ssico");
		btnCatClassico.setToolTipText("Categoria Classico.");
		btnCatClassico.setPreferredSize(new Dimension(127, 135));
		btnCatClassico.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCatClassico.setBackground(Color.LIGHT_GRAY);
		panelCategoriasFilmes.add(btnCatClassico);

		JButton btnCatComedia = new JButton("Com\u00E9dia");
		btnCatComedia.setToolTipText("Categoria ComÐ¹dia.");
		btnCatComedia.setPreferredSize(new Dimension(127, 135));
		btnCatComedia.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCatComedia.setBackground(Color.LIGHT_GRAY);
		panelCategoriasFilmes.add(btnCatComedia);

		JButton btnCatComediaRomantica = new JButton("<html><CENTER>Com\u00E9dia<br>Rom\u00E2ntica</CENTER></html>");
		btnCatComediaRomantica.setToolTipText("Categoria Com\u00E9dia Rom\u00E2ntica.");
		btnCatComediaRomantica.setPreferredSize(new Dimension(127, 135));
		btnCatComediaRomantica.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCatComediaRomantica.setBackground(Color.LIGHT_GRAY);
		panelCategoriasFilmes.add(btnCatComediaRomantica);

		JButton btnCatCrime = new JButton("Crime");
		btnCatCrime.setToolTipText("Categoria Crime.");
		btnCatCrime.setPreferredSize(new Dimension(127, 135));
		btnCatCrime.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCatCrime.setBackground(Color.LIGHT_GRAY);
		panelCategoriasFilmes.add(btnCatCrime);

		JButton btnCatDocumentario = new JButton("<html><CENTER><p>Document\u00E1<br>rio</CENTER></html>");
		btnCatDocumentario.setToolTipText("Categoria Document\u00E1rio.");
		btnCatDocumentario.setPreferredSize(new Dimension(127, 135));
		btnCatDocumentario.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCatDocumentario.setBackground(Color.LIGHT_GRAY);
		panelCategoriasFilmes.add(btnCatDocumentario);

		JButton btnCatDrama = new JButton("Drama");
		btnCatDrama.setToolTipText("Categoria Drama.");
		btnCatDrama.setPreferredSize(new Dimension(127, 135));
		btnCatDrama.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCatDrama.setBackground(Color.LIGHT_GRAY);
		panelCategoriasFilmes.add(btnCatDrama);

		JButton btnCatFaroeste = new JButton("Faroeste");
		btnCatFaroeste.setToolTipText("Categoria Faroeste.");
		btnCatFaroeste.setPreferredSize(new Dimension(127, 135));
		btnCatFaroeste.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCatFaroeste.setBackground(Color.LIGHT_GRAY);
		panelCategoriasFilmes.add(btnCatFaroeste);

		JButton btnCatFicaoCient = new JButton("<html><center>Fic\u00E7\u00E3o</br> Cientifica</center></html>");
		btnCatFicaoCient.setToolTipText("Categoria Fic\u00E7\u00E3o Científica.");
		btnCatFicaoCient.setPreferredSize(new Dimension(127, 135));
		btnCatFicaoCient.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCatFicaoCient.setBackground(Color.LIGHT_GRAY);
		panelCategoriasFilmes.add(btnCatFicaoCient);

		JButton btnCatGuerra = new JButton("Guerra");
		btnCatGuerra.setToolTipText("Categoria Guerra.");
		btnCatGuerra.setPreferredSize(new Dimension(127, 135));
		btnCatGuerra.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCatGuerra.setBackground(Color.LIGHT_GRAY);
		panelCategoriasFilmes.add(btnCatGuerra);

		JButton btnCatMusical = new JButton("Musical");
		btnCatMusical.setToolTipText("Categoria Musical.");
		btnCatMusical.setPreferredSize(new Dimension(127, 135));
		btnCatMusical.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCatMusical.setBackground(Color.LIGHT_GRAY);
		panelCategoriasFilmes.add(btnCatMusical);

		JButton btnCatPolicial = new JButton("Policial");
		btnCatPolicial.setToolTipText("Categoria Policial.");
		btnCatPolicial.setPreferredSize(new Dimension(127, 135));
		btnCatPolicial.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCatPolicial.setBackground(Color.LIGHT_GRAY);
		panelCategoriasFilmes.add(btnCatPolicial);

		JButton btnCatRomance = new JButton("Romance");
		btnCatRomance.setToolTipText("Categoria Romance.");
		btnCatRomance.setPreferredSize(new Dimension(127, 135));
		btnCatRomance.setFont(new Font("Tahoma", Font.BOLD, 14));

		btnCatRomance.setBackground(Color.LIGHT_GRAY);
		panelCategoriasFilmes.add(btnCatRomance);

		JButton btnCatSuspense = new JButton("Suspense");
		btnCatSuspense.setToolTipText("Categoria Suspense.");
		btnCatSuspense.setPreferredSize(new Dimension(127, 135));
		btnCatSuspense.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCatSuspense.setBackground(Color.LIGHT_GRAY);
		panelCategoriasFilmes.add(btnCatSuspense);

		JButton btnCatTerror = new JButton("Terror");
		btnCatTerror.setToolTipText("Categoria Terror.");
		btnCatTerror.setPreferredSize(new Dimension(127, 135));
		btnCatTerror.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCatTerror.setBackground(Color.LIGHT_GRAY);
		panelCategoriasFilmes.add(btnCatTerror);

		JButton btnCatThriller = new JButton("Thriller");
		btnCatThriller.setToolTipText("Categoria Thriller.");
		btnCatThriller.setPreferredSize(new Dimension(127, 135));
		btnCatThriller.setFont(new Font("Tahoma", Font.BOLD, 14));
		panelCategoriasFilmes.add(btnCatThriller);
		btnCatThriller.setBackground(Color.LIGHT_GRAY);

		// Jpanel para cada Categoria necessaria
		labelGeral = new JPanel();
		labelGeral.setLayout(new FlowLayout(FlowLayout.CENTER));
		labelGeral.setPreferredSize(new Dimension(500, 300));
		labelGeral.setBackground(new Color(120, 120, 120));

		/*
		 * 
		 * 
		 * SERIES/CAREGORIAS SERIES/CAREGORIAS SERIES/CAREGORIAS
		 * SERIES/CAREGORIAS SERIES/CAREGORIAS 
		 * 
		 * 
		 */

		JPanel panelCategoriasSerie = new JPanel();
		panelCategoriasSerie.setLayout(new FlowLayout(FlowLayout.CENTER));
		panelCategoriasSerie.setPreferredSize(new Dimension(500, 300));
		panelCategoriasSerie.setBackground(new Color(120, 120, 120));

		JButton btnCatAcaoSerie = new JButton("Ação");
		btnCatAcaoSerie.setToolTipText("Categoria ação.");
		btnCatAcaoSerie.setPreferredSize(new Dimension(127, 135));
		btnCatAcaoSerie.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCatAcaoSerie.setBackground(Color.LIGHT_GRAY);
		panelCategoriasSerie.add(btnCatAcaoSerie);

		JButton btnCatAnimacaoSerie = new JButton("Animação");
		btnCatAnimacaoSerie.setToolTipText("Categoria Animação.");
		btnCatAnimacaoSerie.setPreferredSize(new Dimension(127, 135));
		btnCatAnimacaoSerie.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCatAnimacaoSerie.setBackground(Color.LIGHT_GRAY);
		panelCategoriasSerie.add(btnCatAnimacaoSerie);

		JButton btnCatAnimeSerie = new JButton("Anime");
		btnCatAnimeSerie.setToolTipText("Categoria Faroeste.");
		btnCatAnimeSerie.setPreferredSize(new Dimension(127, 135));
		btnCatAnimeSerie.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCatAnimeSerie.setBackground(Color.LIGHT_GRAY);
		panelCategoriasSerie.add(btnCatAnimeSerie);

		JButton btnCatAventuraSerie = new JButton("Aventura");
		btnCatAventuraSerie.setToolTipText("Categoria .");
		btnCatAventuraSerie.setPreferredSize(new Dimension(127, 135));
		btnCatAventuraSerie.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCatAventuraSerie.setBackground(Color.LIGHT_GRAY);
		panelCategoriasSerie.add(btnCatAventuraSerie);

		JButton btnCatClassicoSerie = new JButton("Clássico");
		btnCatClassicoSerie.setToolTipText("Categoria Classico.");
		btnCatClassicoSerie.setPreferredSize(new Dimension(127, 135));
		btnCatClassicoSerie.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCatClassicoSerie.setBackground(Color.LIGHT_GRAY);
		panelCategoriasSerie.add(btnCatClassicoSerie);

		JButton btnCatComediaSerie = new JButton("Comédia");
		btnCatComediaSerie.setToolTipText("Categoria Comédia.");
		btnCatComediaSerie.setPreferredSize(new Dimension(127, 135));
		btnCatComediaSerie.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCatComediaSerie.setBackground(Color.LIGHT_GRAY);
		panelCategoriasSerie.add(btnCatComediaSerie);

		JButton btnCatComediaRomanticaSerie = new JButton("<html><CENTER>Comédia</br> Romântica</CENTER></html>");
		btnCatComediaRomanticaSerie.setToolTipText("Categoria Comédia Romântica.");
		btnCatComediaRomanticaSerie.setPreferredSize(new Dimension(127, 135));
		btnCatComediaRomanticaSerie.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCatComediaRomanticaSerie.setBackground(Color.LIGHT_GRAY);
		panelCategoriasSerie.add(btnCatComediaRomanticaSerie);

		JButton btnCatCrimeSerie = new JButton("Crime");
		btnCatCrimeSerie.setToolTipText("Categoria Crime.");
		btnCatCrimeSerie.setPreferredSize(new Dimension(127, 135));
		btnCatCrimeSerie.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCatCrimeSerie.setBackground(Color.LIGHT_GRAY);
		panelCategoriasSerie.add(btnCatCrimeSerie);

		JButton btnCatDocumentarioSerie = new JButton("<html><p>Documentá<br>rio</html>");
		btnCatDocumentarioSerie.setToolTipText("Categoria Documentário.");
		btnCatDocumentarioSerie.setPreferredSize(new Dimension(127, 135));
		btnCatDocumentarioSerie.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCatDocumentarioSerie.setBackground(Color.LIGHT_GRAY);
		panelCategoriasSerie.add(btnCatDocumentarioSerie);

		JButton btnCatDramaSerie = new JButton("Drama");
		btnCatDramaSerie.setToolTipText("Categoria Drama.");
		btnCatDramaSerie.setPreferredSize(new Dimension(127, 135));
		btnCatDramaSerie.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCatDramaSerie.setBackground(Color.LIGHT_GRAY);
		panelCategoriasSerie.add(btnCatDramaSerie);

		JButton btnCatFicaoCientSerie = new JButton("<html><center>Ficção</br> Científica</center></html>");
		btnCatFicaoCientSerie.setToolTipText("Categoria FicÐ·Ð³o CientÐ½fica.");
		btnCatFicaoCientSerie.setPreferredSize(new Dimension(127, 135));
		// btnCatAcao.setIcon(new ImageIcon("resources\\images\\acaoIcon.jpg"));
		btnCatFicaoCientSerie.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCatFicaoCientSerie.setBackground(Color.LIGHT_GRAY);
		panelCategoriasSerie.add(btnCatFicaoCientSerie);

		JButton btnCatGuerraSerie = new JButton("Guerra");
		btnCatGuerraSerie.setToolTipText("Categoria Guerra.");
		btnCatGuerraSerie.setPreferredSize(new Dimension(127, 135));
		// btnCatAcao.setIcon(new ImageIcon("resources\\images\\acaoIcon.jpg"));
		btnCatGuerraSerie.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCatGuerraSerie.setBackground(Color.LIGHT_GRAY);
		panelCategoriasSerie.add(btnCatGuerraSerie);

		JButton btnCatMedicoSerie = new JButton("Médico");
		btnCatMedicoSerie.setToolTipText("Categoria Thriller.");
		btnCatMedicoSerie.setPreferredSize(new Dimension(127, 135));
		// btnCatAcao.setIcon(new ImageIcon("resources\\images\\acaoIcon.jpg"));
		btnCatMedicoSerie.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCatMedicoSerie.setBackground(Color.LIGHT_GRAY);
		panelCategoriasSerie.add(btnCatMedicoSerie);

		JButton btnCatMusicalSerie = new JButton("Musical");
		btnCatMusicalSerie.setToolTipText("Categoria Musical.");
		btnCatMusicalSerie.setPreferredSize(new Dimension(127, 135));
		// btnCatAcao.setIcon(new ImageIcon("resources\\images\\acaoIcon.jpg"));
		btnCatMusicalSerie.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCatMusicalSerie.setBackground(Color.LIGHT_GRAY);
		panelCategoriasSerie.add(btnCatMusicalSerie);

		JButton btnCatPolicialSerie = new JButton("Policial");
		btnCatPolicialSerie.setToolTipText("Categoria Policial.");
		btnCatPolicialSerie.setPreferredSize(new Dimension(127, 135));
		// btnCatAcao.setIcon(new ImageIcon("resources\\images\\acaoIcon.jpg"));
		btnCatPolicialSerie.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCatPolicialSerie.setBackground(Color.LIGHT_GRAY);
		panelCategoriasSerie.add(btnCatPolicialSerie);

		JButton btnCatRomanceSerie = new JButton("Romance");
		btnCatRomanceSerie.setToolTipText("Categoria Romance.");
		btnCatRomanceSerie.setPreferredSize(new Dimension(127, 135));
		// btnCatAcao.setIcon(new ImageIcon("resources\\images\\acaoIcon.jpg"));
		btnCatRomanceSerie.setFont(new Font("Tahoma", Font.BOLD, 14));

		btnCatRomanceSerie.setBackground(Color.LIGHT_GRAY);
		panelCategoriasSerie.add(btnCatRomanceSerie);

		JButton btnCatSuspenseSerie = new JButton("Suspense");
		btnCatSuspenseSerie.setToolTipText("Categoria Suspense.");
		btnCatSuspenseSerie.setPreferredSize(new Dimension(127, 135));
		// btnCatAcao.setIcon(new ImageIcon("resources\\images\\acaoIcon.jpg"));
		btnCatSuspenseSerie.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCatSuspenseSerie.setBackground(Color.LIGHT_GRAY);
		panelCategoriasSerie.add(btnCatSuspenseSerie);

		JButton btnCatTerrorSerie = new JButton("Terror");
		btnCatTerrorSerie.setToolTipText("Categoria Terror.");
		btnCatTerrorSerie.setPreferredSize(new Dimension(127, 135));
		// btnCatAcao.setIcon(new ImageIcon("resources\\images\\acaoIcon.jpg"));
		btnCatTerrorSerie.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCatTerrorSerie.setBackground(Color.LIGHT_GRAY);
		panelCategoriasSerie.add(btnCatTerrorSerie);

		/**
		 *
		 * Categoria Musicais
		 */
		// jpanel categorias musicais
		JPanel panelCategoriasMusica = new JPanel();
		panelCategoriasMusica.setLayout(new FlowLayout(FlowLayout.CENTER));
		panelCategoriasMusica.setPreferredSize(new Dimension(500, 300));
		panelCategoriasMusica.setBackground(new Color(120, 120, 120));

		// Jbutoons do Estilos musicais
		JButton btnMusicAntigas = new JButton("Antigas");
		btnMusicAntigas.setToolTipText("Categoria Antigas.");
		btnMusicAntigas.setPreferredSize(new Dimension(127, 135));
		btnMusicAntigas.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnMusicAntigas.setBackground(Color.LIGHT_GRAY);
		panelCategoriasMusica.add(btnMusicAntigas);

		JButton btnMusicAxe = new JButton("Axé");
		btnMusicAxe.setToolTipText("Categoria Axé.");
		btnMusicAxe.setPreferredSize(new Dimension(127, 135));
		btnMusicAxe.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnMusicAxe.setBackground(Color.LIGHT_GRAY);
		panelCategoriasMusica.add(btnMusicAxe);

		JButton btnMusicBlack = new JButton("Black");
		btnMusicBlack.setToolTipText("Categoria Black.");
		btnMusicBlack.setPreferredSize(new Dimension(127, 135));
		btnMusicBlack.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnMusicBlack.setBackground(Color.LIGHT_GRAY);
		panelCategoriasMusica.add(btnMusicBlack);

		JButton btnMusicBrega = new JButton("Brega");
		btnMusicBrega.setToolTipText("Categoria Brega.");
		btnMusicBrega.setPreferredSize(new Dimension(127, 135));
		btnMusicBrega.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnMusicBrega.setBackground(Color.LIGHT_GRAY);
		panelCategoriasMusica.add(btnMusicBrega);

		JButton btnMusicDance = new JButton("Dance");
		btnMusicDance.setToolTipText("Categoria Dance.");
		btnMusicDance.setPreferredSize(new Dimension(127, 135));
		btnMusicDance.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnMusicDance.setBackground(Color.LIGHT_GRAY);
		panelCategoriasMusica.add(btnMusicDance);

		JButton btnMusicEletronica = new JButton("Eletrônica");
		btnMusicEletronica.setToolTipText("Categoria Com\u00E9dia Eletrônica.");
		btnMusicEletronica.setPreferredSize(new Dimension(127, 135));
		btnMusicEletronica.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnMusicEletronica.setBackground(Color.LIGHT_GRAY);
		panelCategoriasMusica.add(btnMusicEletronica);

		JButton btnMusicFunk = new JButton("Funk");
		btnMusicFunk.setToolTipText("Categoria Funk.");
		btnMusicFunk.setPreferredSize(new Dimension(127, 135));
		btnMusicFunk.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnMusicFunk.setBackground(Color.LIGHT_GRAY);
		panelCategoriasMusica.add(btnMusicFunk);

		JButton btnMusicForro = new JButton("Forró");
		btnMusicForro.setToolTipText("Categoria Forró.");
		btnMusicForro.setPreferredSize(new Dimension(127, 135));
		btnMusicForro.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnMusicForro.setBackground(Color.LIGHT_GRAY);
		panelCategoriasMusica.add(btnMusicForro);

		JButton btnMusicFolcloricas = new JButton("Folclóricas");
		btnMusicFolcloricas.setToolTipText("Categoria Folclóricas.");
		btnMusicFolcloricas.setPreferredSize(new Dimension(127, 135));
		btnMusicFolcloricas.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnMusicFolcloricas.setBackground(Color.LIGHT_GRAY);
		panelCategoriasMusica.add(btnMusicFolcloricas);

		JButton btnMusicGospel = new JButton("Gospel");
		btnMusicGospel.setToolTipText("Categoria Gospel.");
		btnMusicGospel.setPreferredSize(new Dimension(127, 135));
		btnMusicGospel.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnMusicGospel.setBackground(Color.LIGHT_GRAY);
		panelCategoriasMusica.add(btnMusicGospel);

		JButton btnMusicInternacional = new JButton("<html><center>Internacio-</br> nais</center></html>");
		btnMusicInternacional.setToolTipText("Categoria Internacionais.");
		btnMusicInternacional.setPreferredSize(new Dimension(127, 135));
		btnMusicInternacional.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnMusicInternacional.setBackground(Color.LIGHT_GRAY);
		panelCategoriasMusica.add(btnMusicInternacional);

		JButton btnMusicModaViola = new JButton("<html><center>Moda de</br> Viola</center></html>");
		btnMusicModaViola.setToolTipText("Categoria Moda de Viola.");
		btnMusicModaViola.setPreferredSize(new Dimension(127, 135));
		btnMusicModaViola.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnMusicModaViola.setBackground(Color.LIGHT_GRAY);
		panelCategoriasMusica.add(btnMusicModaViola);

		JButton btnMusicNovas = new JButton("Novas");
		btnMusicNovas.setToolTipText("Categoria Musicas Novas.");
		btnMusicNovas.setPreferredSize(new Dimension(127, 135));
		btnMusicNovas.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnMusicNovas.setBackground(Color.LIGHT_GRAY);
		panelCategoriasMusica.add(btnMusicNovas);

		JButton btnMusicPagode = new JButton("Pagode");
		btnMusicPagode.setToolTipText("Categoria Pagode.");
		btnMusicPagode.setPreferredSize(new Dimension(127, 135));
		btnMusicPagode.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnMusicPagode.setBackground(Color.LIGHT_GRAY);
		panelCategoriasMusica.add(btnMusicPagode);

		JButton btnMusicRomantica = new JButton("Romântica");
		btnMusicRomantica.setToolTipText("Categoria Romântica.");
		btnMusicRomantica.setPreferredSize(new Dimension(127, 135));
		btnMusicRomantica.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnMusicRomantica.setBackground(Color.LIGHT_GRAY);
		panelCategoriasMusica.add(btnMusicRomantica);

		JButton btnMusicReagge = new JButton("Reagge");
		btnMusicReagge.setToolTipText("Categoria Reagge.");
		btnMusicReagge.setPreferredSize(new Dimension(127, 135));
		btnMusicReagge.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnMusicReagge.setBackground(Color.LIGHT_GRAY);
		panelCategoriasMusica.add(btnMusicReagge);

		JButton btnMusicSamba = new JButton("Samba");
		btnMusicSamba.setToolTipText("Categoria Samba.");
		btnMusicSamba.setPreferredSize(new Dimension(127, 135));
		btnMusicSamba.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnMusicSamba.setBackground(Color.LIGHT_GRAY);
		panelCategoriasMusica.add(btnMusicSamba);

		JButton btnMusicSertaneja = new JButton("Sertaneja");
		btnMusicSertaneja.setToolTipText("Categoria Sertaneja.");
		btnMusicSertaneja.setPreferredSize(new Dimension(127, 135));
		btnMusicSertaneja.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnMusicSertaneja.setBackground(Color.LIGHT_GRAY);
		panelCategoriasMusica.add(btnMusicSertaneja);
	
		
		//  que será realizada ao apertar o botao de Musica do jpanelTopo
		btnMusica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				home.getContentPane().add(panelLateralMusica, BorderLayout.WEST);
				panelTopo.setVisible(false); // Torna a visibilidade do painel
												// topo falsa
				home.getContentPane().remove(panelTopo); // Remove esse painel
				panelLateralMusica.setVisible(true); // Ativa o painel lateral
														// referente ao Musica
				panelLateralMusica.revalidate();// revalida o loyout
			}
		});
		//  que será realizada ao apertar o botao de Video do jpanelTopo
		btnVideo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				home.getContentPane().add(panelLateralVideo, BorderLayout.WEST);
				panelTopo.setVisible(false); // Torna a visibilidade do painel
												// topo falsa
				home.getContentPane().remove(panelTopo); // Remove esse painel
				panelLateralVideo.setVisible(true); // Ativa o painel lateral
													// referente ao video
				panelLateralVideo.revalidate();// revalida o loyout
			}
		});

		btnVoltarMusica.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (voltarPaineis.isEmpty()) {
					home.getContentPane().add(panelTopo, BorderLayout.NORTH);
					panelLateralVideo.setVisible(false);
					home.getContentPane().remove(panelLateralMusica);
					panelTopo.setVisible(true);
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
					labelFundo.revalidate();
					labelFundo.repaint();
					voltarPaineis.remove(voltarPaineis.size() - 1);
				} else if (voltarPaineis.size() == 2) {
					home.getContentPane().remove(voltarPaineis.get(1));
					voltarPaineis.get(1).revalidate();
					voltarPaineis.get(1).repaint();
					// home.getContentPane().add(panelCategoria);
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
				if (voltarPaineis.size() == 2) {
					home.getContentPane().remove(voltarPaineis.get(1));
				}
				voltarPaineis = new ArrayList<JPanel>();
				voltarPaineis.removeAll(voltarPaineis);
				voltarPaineis.add(panelCategoriasMusica);
				home.getContentPane().remove(panelPlaylist);
				home.getContentPane().remove(labelFundo);
				home.getContentPane().remove(panelCategoriasMusica);
				home.getContentPane().add(panelCategoriasMusica, BorderLayout.CENTER);
				panelCategoriasMusica.setVisible(true); // ativa o panel lateral
				panelCategoriasMusica.revalidate();// revalida o layout
				panelCategoriasMusica.repaint();
				timer.clse();
			}
		});
		
		btnPlaylistMusica.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
		
					if (voltarPaineis.size() == 2) {
						home.getContentPane().remove(voltarPaineis.get(1));
					}
					voltarPaineis = new ArrayList<JPanel>();
					voltarPaineis.removeAll(voltarPaineis);
					voltarPaineis.add(panelPlaylist);
					home.getContentPane().remove(panelPlaylist);
					home.getContentPane().remove(labelFundo);
					home.getContentPane().remove(panelCategoriasMusica);
					home.getContentPane().add(panelPlaylist, BorderLayout.CENTER);
					panelPlaylist.setVisible(true);
					//home.revalidate();
					panelPlaylist.revalidate();
					panelPlaylist.repaint();
					timer.clse();
			}
		});

		
		// ação ao clicar no button lateral Filmes
		btnFilmes.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {
				if (voltarPaineis.size() == 2) {
					home.getContentPane().remove(voltarPaineis.get(1));
				}
				labelGeral = new JPanel();
				AtualizaPanelGeral();
				voltarPaineis = new ArrayList<JPanel>();
				voltarPaineis.removeAll(voltarPaineis);
				voltarPaineis.add(panelCategoriasFilmes);
				home.getContentPane().remove(labelFundo);
				home.getContentPane().remove(panelCategoriasFilmes);
				home.getContentPane().remove(panelCategoriasSerie);
				home.getContentPane().add(panelCategoriasFilmes, BorderLayout.CENTER);
				panelCategoriasFilmes.setVisible(true);
				panelCategoriasFilmes.revalidate();
				panelCategoriasFilmes.repaint();
				timer.clse();
			}
		});

		btnSeries.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {
				if (voltarPaineis.size() == 2) {
					home.getContentPane().remove(voltarPaineis.get(1));
				}
				labelGeral = new JPanel();
				AtualizaPanelGeral();
				voltarPaineis = new ArrayList<JPanel>();
				voltarPaineis.removeAll(voltarPaineis);
				voltarPaineis.add(panelCategoriasSerie);
				home.getContentPane().remove(labelFundo);
				home.getContentPane().remove(panelCategoriasFilmes);
				home.getContentPane().remove(panelCategoriasSerie);
				home.getContentPane().add(panelCategoriasSerie, BorderLayout.CENTER);
				panelCategoriasSerie.setVisible(true);
				panelCategoriasSerie.revalidate();
				panelCategoriasSerie.repaint();
				timer.clse();
			}
		});
		// ação do botão voltar
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
					home.revalidate();
					timer.init();
					AtualizaPanelGeral();
				} else if (voltarPaineis.size() == 1) {
					home.getContentPane().remove(voltarPaineis.get(0));
					home.getContentPane().add(labelFundo, BorderLayout.CENTER);
					voltarPaineis.get(0).setVisible(false);
					voltarPaineis.get(0).revalidate();
					voltarPaineis.get(0).repaint();
					labelFundo.revalidate();
					labelFundo.repaint();
					voltarPaineis.remove(voltarPaineis.size() - 1);
					AtualizaPanelGeral();
				} else if (voltarPaineis.size() == 2) {
					home.getContentPane().remove(voltarPaineis.get(1));
					voltarPaineis.get(1).revalidate();
					voltarPaineis.get(1).repaint();
					// home.getContentPane().add(panelCategoria);
					home.getContentPane().add(voltarPaineis.get(0), BorderLayout.CENTER);
					voltarPaineis.get(0).setVisible(true);
					voltarPaineis.get(0).revalidate();
					voltarPaineis.get(0).repaint();
					voltarPaineis.remove(voltarPaineis.size() - 1);
					AtualizaPanelGeral();
				}
				try {
					listFiles.reUpdateTable(table, userName, currentGenero, music);
				} catch (NullPointerException ne) {
					ne.getStackTrace();
				}
			}
		});
		//
		/**
		 * Acao dos botoes de categorias de Filmes
		 */

		//
		// ação do botão filmes categoria ação
		btnCatAcao.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String genero = "ação";
				currentGenero = genero;
				AcaoButtons(panelCategoriasFilmes);
			}
		});

		// ação do botão filmes categoria Animação
		btnCatAnimacao.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String genero = "Anima\u00E7\u00E3o";
				currentGenero = genero;
				AcaoButtons(panelCategoriasFilmes);
			}
		});

		// ação do botão filmes categoria Aventura
		btnCatAventura.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String genero = "aventura";
				currentGenero = genero;
				AcaoButtons(panelCategoriasFilmes);
			}
		});

		// ação do botão filmes categoria Classico
		btnCatClassico.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String genero = "Cl\u00E1ssico";
				currentGenero = genero;
				AcaoButtons(panelCategoriasFilmes);
			}
		});

		// ação do botão filmes categoria Comedia
		btnCatComedia.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String genero = "Com\u00E9dia";
				currentGenero = genero;
				AcaoButtons(panelCategoriasFilmes);
			}
		});

		// ação do botão filmes categoria ComediaRomantica
		btnCatComediaRomantica.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String genero = "Com\u00E9dia Rom\u00E2ntica";
				currentGenero = genero;
				AcaoButtons(panelCategoriasFilmes);
			}
		});

		// ação do botão filmes categoria Crime
		btnCatCrime.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String genero = "Crime";
				currentGenero = genero;
				AcaoButtons(panelCategoriasFilmes);
			}
		});

		// ação do botão filmes categoria Documentario
		btnCatDocumentario.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String genero = "Document\u00E1rio";
				currentGenero = genero;
				AcaoButtons(panelCategoriasFilmes);
			}
		});

		// ação do botão filmes categoria Drama
		btnCatDrama.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String genero = "Drama";
				currentGenero = genero;
				AcaoButtons(panelCategoriasFilmes);
			}
		});

		// ação do botão filmes categoria Faroeste
		btnCatFaroeste.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String genero = "Faroeste";
				currentGenero = genero;
				AcaoButtons(panelCategoriasFilmes);
			}
		});

		// ação do botão filmes categoria FiccaoCientifica
		btnCatFicaoCient.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String genero = "Fic\u00E7\u00E3o Cientifica";
				currentGenero = genero;
				AcaoButtons(panelCategoriasFilmes);
			}
		});

		// ação do botão filmes categoria Guerra
		btnCatGuerra.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String genero = "guerra";
				currentGenero = genero;
				AcaoButtons(panelCategoriasFilmes);
			}
		});

		// ação do botão filmes categoria Musical
		btnCatMusical.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String genero = "musical";
				currentGenero = genero;
				AcaoButtons(panelCategoriasFilmes);
			}
		});

		// ação do botão filmes categoria Policial
		btnCatPolicial.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String genero = "policial";
				currentGenero = genero;
				AcaoButtons(panelCategoriasFilmes);
			}
		});

		// ação do botão filmes categoria Romance
		btnCatRomance.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String genero = "romance";
				currentGenero = genero;
				AcaoButtons(panelCategoriasFilmes);
			}
		});

		// ação do botão filmes categoria Suspense
		btnCatSuspense.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String genero = "suspense";
				currentGenero = genero;
				AcaoButtons(panelCategoriasFilmes);
				}
		});

		// ação do botão filmes categoria Terror
		btnCatTerror.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String genero = "terror";
				currentGenero = genero;
				AcaoButtons(panelCategoriasFilmes);
			}
		});

		// ação do botão filmes categoria Thriller
		btnCatThriller.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String genero = "thriller";
				currentGenero = genero;
				AcaoButtons(panelCategoriasFilmes);
			}
		});

		/**
		 *  Acao de botoes da categoria series
		 */

		// ação do botão filmes categoria 
		btnCatAcaoSerie.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String genero = "ação";
				currentGenero = genero;
				AcaoButtonsSerie(panelCategoriasSerie);
			}
		});

		// ação do botão filmes categoria Anim
		btnCatAnimacaoSerie.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String genero = "Animação";
				currentGenero = genero;
				AcaoButtonsSerie(panelCategoriasSerie);

			}
		});

		// ação do botão filmes categoria Aventura
		btnCatAventuraSerie.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String genero = "aventura";
				currentGenero = genero;
				AcaoButtonsSerie(panelCategoriasSerie);
			}
		});

		// ação do botão filmes categoria Classico
		btnCatClassicoSerie.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String genero = "Cl\u00E1ssico";
				currentGenero = genero;
				AcaoButtonsSerie(panelCategoriasSerie);
			}
		});

		// ação do botão filmes categoria Comedia
		btnCatComediaSerie.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String genero = "Com\u00E9dia";
				currentGenero = genero;
				AcaoButtonsSerie(panelCategoriasSerie);
			}
		});

		// ação do botão filmes categoria ComediaRomantica
		btnCatComediaRomanticaSerie.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String genero = "Com\u00E9dia Rom\u00E2ntica";
				currentGenero = genero;
				AcaoButtonsSerie(panelCategoriasSerie);
			}
		});

		// ação do botão filmes categoria Crime
		btnCatCrimeSerie.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String genero = "Crime";
				currentGenero = genero;
				AcaoButtonsSerie(panelCategoriasSerie);
			}
		});

		// ação do botão filmes categoria Documentario
		btnCatDocumentarioSerie.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String genero = "Document\u00E1rio";
				currentGenero = genero;
				AcaoButtonsSerie(panelCategoriasSerie);
			}
		});

		// ação do botão filmes categoria Drama
		btnCatDramaSerie.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String genero = "Drama";
				currentGenero = genero;
				AcaoButtonsSerie(panelCategoriasSerie);
			}
		});

		//  ação do botão filmes categoria Anime
		btnCatAnimeSerie.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String genero = "Anime";
				currentGenero = genero;
				AcaoButtonsSerie(panelCategoriasSerie);
			}
		});

		//ação  do botão filmes categoria FiccaoCientifica
		btnCatFicaoCientSerie.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String genero = "Fic\u00E7\u00E3o Cientifica";
				currentGenero = genero;
				AcaoButtonsSerie(panelCategoriasSerie);

			}
		});

		// ação do botão filmes categoria Guerra
		btnCatGuerraSerie.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String genero = "guerra";
				currentGenero = genero;
				AcaoButtonsSerie(panelCategoriasSerie);

			}
		});

		// ação do botão filmes categoria Musical
		btnCatMusicalSerie.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String genero = "musical";
				currentGenero = genero;
				AcaoButtonsSerie(panelCategoriasSerie);
			}
		});

		// ação do botão filmes categoria Policial
		btnCatPolicialSerie.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String genero = "policial";
				currentGenero = genero;
				AcaoButtonsSerie(panelCategoriasSerie);
			}
		});

		// ação do botão filmes categoria Romance
		btnCatRomanceSerie.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String genero = "romance";
				currentGenero = genero;
				AcaoButtonsSerie(panelCategoriasSerie);
			}
		});

		// ação do botão filmes categoria Suspense
		btnCatSuspenseSerie.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String genero = "suspense";
				currentGenero = genero;
				AcaoButtonsSerie(panelCategoriasSerie);

			}
		});

		//  ação do botão filmes categoria Terror
		btnCatTerrorSerie.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String genero = "terror";
				currentGenero = genero;
				AcaoButtonsSerie(panelCategoriasSerie);
			}
		});

		// ação do botão filmes categoria Thriller
		btnCatMedicoSerie.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String genero = "Médico";
				currentGenero = genero;
				AcaoButtonsSerie(panelCategoriasSerie);
			}
		});
		
		/**
		 * Ação dos butons Estilos musicais
		 */
		
		btnMusicAntigas.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String genero = "Antigas";
				currentGenero = genero;
				AcaoButtonsMusic(panelCategoriasMusica);
			}
		});
		
		btnMusicAxe.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String genero = "Axé";
				currentGenero = genero;
				AcaoButtonsMusic(panelCategoriasMusica);
			}
		});
		
		btnMusicBlack.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String genero = "Black";
				currentGenero = genero;
				AcaoButtonsMusic(panelCategoriasMusica);
			}
		});
		
		btnMusicBrega.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String genero = "Brega";
				currentGenero = genero;
				AcaoButtonsMusic(panelCategoriasMusica);
			}
		});
		
		btnMusicDance.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String genero = "Dance";
				currentGenero = genero;
				AcaoButtonsMusic(panelCategoriasMusica);
			}
		});
		
		btnMusicEletronica.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String genero = "Eletrônica";
				currentGenero = genero;
				AcaoButtonsMusic(panelCategoriasMusica);
			}
		});
		
		btnMusicFunk.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String genero = "Funk";
				currentGenero = genero;
				AcaoButtonsMusic(panelCategoriasMusica);
			}
		});
		
		btnMusicForro.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String genero = "Forró";
				currentGenero = genero;
				AcaoButtonsMusic(panelCategoriasMusica);
			}
		});
		
		btnMusicFolcloricas.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String genero = "Folclóricas";
				currentGenero = genero;
				AcaoButtonsMusic(panelCategoriasMusica);
			}
		});
		
		btnMusicGospel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String genero = "Gospel";
				currentGenero = genero;
				AcaoButtonsMusic(panelCategoriasMusica);
			}
		});
		
		btnMusicInternacional.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String genero = "Internacionais";
				currentGenero = genero;
				AcaoButtonsMusic(panelCategoriasMusica);
			}
		});
		
		btnMusicModaViola.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String genero = "Moda de Viola";
				currentGenero = genero;
				AcaoButtonsMusic(panelCategoriasMusica);
			}
		});
		
		btnMusicNovas.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String genero = "Novas";
				currentGenero = genero;
				AcaoButtonsMusic(panelCategoriasMusica);
			}
		});
		
		btnMusicPagode.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String genero = "Pagode";
				currentGenero = genero;
				AcaoButtonsMusic(panelCategoriasMusica);
			}
		});
		
		btnMusicRomantica.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String genero = "Romântica";
				currentGenero = genero;
				AcaoButtonsMusic(panelCategoriasMusica);
			}
		});
		
		btnMusicReagge.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String genero = "Reagge";
				currentGenero = genero;
				AcaoButtonsMusic(panelCategoriasMusica);
			}
		});
		
		btnMusicSamba.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String genero = "Samba";
				currentGenero = genero;
				AcaoButtonsMusic(panelCategoriasMusica);
			}
		});
		
		btnMusicSertaneja.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String genero = "Sertaneja";
				currentGenero = genero;
				AcaoButtonsMusic(panelCategoriasMusica);
			}
		});

		// Botão PlayList
		
	}
	/**
	 * Acão que será executada quando aperta alguma opção de genero na categoria Filmes
	 * @param panelCategorias Recebe o panel para serem feitas as ações
	 * @return null
	 */
	public ActionListener AcaoButtons(JPanel panelCategorias) {
		music = "";
		FRarquivos retorno = new FRarquivos();
		Boolean ler = false;
		ler = retorno.VerificaGeneroExistente(userName, currentGenero);
		if (ler) {
			voltarPaineis.add(labelGeral);
			home.add(voltarPaineis.get(1), BorderLayout.CENTER);
			listFiles.reUpdateTable(table, userName, currentGenero, music);
			tableContainer.setPreferredSize(new Dimension(790, 500));
			labelGeral.add(tableContainer, BorderLayout.CENTER);
			panelCategorias.setVisible(false);
			home.getContentPane().remove(panelCategorias);
			labelGeral.setVisible(true);
			labelGeral.revalidate();

		} else {
			JOptionPane.showMessageDialog(null, "Não à nada a ser listado", "Inválido", 0);
		}
		return null;
		
	}
	/**
	 * Acão que será executada quando aperta alguma opção de genero na categoria Musica
	 * @param panelCategorias Recebe o panel para serem feitas as ações
	 * @return null
	 */
	public ActionListener AcaoButtonsMusic(JPanel panelCategorias) {
		music  = "Musicas";
		FRarquivos retorno = new FRarquivos();
		Boolean ler = false;
		ler = retorno.VerificaGeneroExistenteMusica(userName, currentGenero);
		if (ler) {
			voltarPaineis.add(labelGeral);
			home.add(voltarPaineis.get(1), BorderLayout.CENTER);
			listFiles.reUpdateTable(table, userName, currentGenero, music);
			tableContainer.setPreferredSize(new Dimension(790, 500));
			labelGeral.add(tableContainer, BorderLayout.CENTER);
			panelCategorias.setVisible(false);
			home.getContentPane().remove(panelCategorias);
			labelGeral.setVisible(true);
			labelGeral.revalidate();
		} else {
			JOptionPane.showMessageDialog(null, "Não à nada a ser listado", "Inválido", 0);
		}
		return null;
		
	}
	/**
	 * Acão que será executada quando aperta alguma opção de genero na categoria Serie
	 * @param panelCategorias Recebe o panel para serem feitas as ações
	 * @return null
	 */
	public ActionListener AcaoButtonsSerie(JPanel panelCategorias) {
	FRarquivos retorno = new FRarquivos();
	Boolean ler = false;
	ler = retorno.VerificaGeneroExistenteSerie(userName, currentGenero);
	if (ler) {
		voltarPaineis.add(labelGeral);
		home.add(voltarPaineis.get(1), BorderLayout.CENTER);
		panelCategorias.setVisible(false);
		home.getContentPane().remove(panelCategorias);
		labelGeral.setVisible(true);
		labelGeral.revalidate();
		AddButtonSerieNoLabel();
	} else {
		JOptionPane.showMessageDialog(null, "Não à nada a ser listado", "Inválido", 0);
	}
		return null;
		
	}
	/**
	 * Atualiza o Label que será usado como label principal
	 */
	public void AtualizaPanelGeral() {
		labelGeral = new JPanel();
		labelGeral.setLayout(new FlowLayout(FlowLayout.CENTER));
		labelGeral.setPreferredSize(new Dimension(500, 300));
		labelGeral.setBackground(new Color(120, 254, 120));
	}
	/**
	 * Função que será usada para atualizar os botões das séries
	 * Cada genero que será enviado para cá, é resposavel por verifica e fazer a 
	 * adição automatica dos buttons série,
	 * e consequentemente atualiza o label.
	 */
	public void AddButtonSerieNoLabel(){
		AtualizeSeries atualize = new AtualizeSeries(userName, currentGenero);
		int size = atualize.Size();
		arrayBtnSeries = new JButton[size];
		for (int i = 0; i < size; i++) {
			String nameSerie = atualize.NameSeries(i);
			if (!nameSerie.equals("nomeSerie")) {
				arrayBtnSeries[i] = new JButton(nameSerie);
				arrayBtnSeries[i].setPreferredSize(new Dimension(127, 135));
				arrayBtnSeries[i].setFont(new Font("Tahoma", Font.BOLD, 14));
				labelGeral.add(arrayBtnSeries[i]);
				arrayBtnSeries[i].addActionListener(new ActionListener() {
		                public void actionPerformed(ActionEvent evt){
		                	addTempSerie(evt);
		                }
		            });
			}
		}
	
	}
	/**
	 * Começa a listagem da ação do JTable da série requerida
	 * @param evt, botão que foi realizado o evento
	 * @return null
	 */
	public ActionListener addTempSerie(ActionEvent evt) {
        JButton botao = (JButton)evt.getSource();
		String name = botao.getText();
		System.out.println(botao + "\n\n"+name);
		//TODO
		return null;
		
	}
}