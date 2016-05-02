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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import br.edu.pii.tecaplay.util.FRarquivos;
import br.edu.pii.tecaplay.util.FileUtil;
//import br.edu.pii.tecaplay.util.MoveFile;
import br.edu.pii.tecaplay.util.TimerToLabel;

public class HomePage{
	/**
	* 
	*/
	public HomePage(String usrName) {
		// formatação do JFrame
		JFrame home = new JFrame();
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
		home.setSize(980, 560); // tamanho da janela
		home.setResizable(false); // impossibilidade de altarar tamanho da janela
		home.setLocationRelativeTo(null); // iniciar aplicação centralizada na tela
		home.setIconImage(Toolkit.getDefaultToolkit().getImage("resources\\images\\newLogo.png")); // icone da barra
	//	MoveFile retornoPasta = new MoveFile();
		// criação do menu superior
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(Color.LIGHT_GRAY);// background do menu
		home.setJMenuBar(menuBar);

		// adição de botao de menu
		JMenu menuArquivo = new JMenu("Arquivo");
		menuArquivo.setMnemonic('A');
		menuArquivo.setBackground(Color.DARK_GRAY);
		menuArquivo.setIcon(new ImageIcon("resources\\images\\imgMenuArquivo.png"));// adição
		menuBar.add(menuArquivo); // adicionado ao container do menu do topo

		// submenu do menu arquivo com a função de sair do programa
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
		menuAjuda.setIcon(new ImageIcon("resources\\images\\imgMenuSobre.png")); // adiçã
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

		// criado painel aonde ficarão os botoes para a escolha de musica, video
		// ou imagem
		JPanel panelTopo = new JPanel();
		panelTopo.setAutoscrolls(true);
		panelTopo.setFocusTraversalPolicyProvider(true);
		panelTopo.setFocusCycleRoot(true);
		panelTopo.setIgnoreRepaint(true);
		panelTopo.setBackground(new Color(127, 127, 127));
		home.getContentPane().add(panelTopo, BorderLayout.NORTH);

		/**
		 * criação de botoes video/musica/imagem
		 */

		JButton btnVdeo = new JButton("V\u00EDdeo");

		panelTopo.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		btnVdeo.setToolTipText("Op\u00E7\u00E3o de acesso a aba V\u00EDdeo!");
		btnVdeo.setIcon(new ImageIcon("resources\\images\\imgBtnVideo.png"));// icone do botao
		btnVdeo.setFont(new Font("Tahoma", Font.BOLD, 14)); // tipo de fonte do botao
		btnVdeo.setBackground(Color.LIGHT_GRAY);
		btnVdeo.setPreferredSize(new Dimension(173, 42));
		panelTopo.add(btnVdeo);
		home.isCursorSet();

		JButton btnMusica = new JButton("Música");
		btnMusica.setToolTipText("Op\u00E7\u00E3o de acesso a aba M\u00FAsica!");
		btnMusica.setIcon(new ImageIcon("resources\\images\\imgBtnMusica.png"));// icone do botao
		btnMusica.setFont(new Font("Tahoma", Font.BOLD, 14)); // tipo de fonte do botao
		btnMusica.setPreferredSize(new Dimension(173, 42));
		btnMusica.setBackground(Color.LIGHT_GRAY);
		panelTopo.add(btnMusica);
		home.isCursorSet();

		JButton btnImagem = new JButton("Imagem");
		btnImagem.setToolTipText("Op\u00E7\u00E3o de acesso a aba Imagem!");
		btnImagem.setIcon(new ImageIcon("resources\\images\\imgBtnImagem.png")); // icone do botao
		btnImagem.setFont(new Font("Tahoma", Font.BOLD, 14)); // tipo de fonte do botao
		btnImagem.setPreferredSize(new Dimension(173, 42));
		btnImagem.setBackground(Color.LIGHT_GRAY);
		panelTopo.add(btnImagem);
		
		//BANNER PRINCIPAL
		JLabel labelFundo = new JLabel("");
		labelFundo.setSize(400,400);
		labelFundo.setIcon(new ImageIcon("resources\\images\\bannerPrincipal.jpg"));
		/**
		 * @TimerToLabel Classe que faz o trabalho de mudar a imagem de fundo.
		 */
		final TimerToLabel timer = new TimerToLabel(30000, labelFundo);
		timer.init();
		home.getContentPane().add(labelFundo, BorderLayout.CENTER);

		/**
		 * Adição de Painel Lateral para abrigar os botoes de gerenciar o que
		 * será apresentado
		 */

		/**
		 * Imagem LATERAL imagem LATERAL Imagem LATERAL Imagem LATERAL Imagem
		 * LATERAL
		 */
		
		JPanel panelLateralImagem = new JPanel();
		panelLateralImagem.setLayout(new FlowLayout(FlowLayout.LEFT, 4, 4));
		panelLateralImagem.setPreferredSize(new Dimension(180, 400));
		panelLateralImagem.setBackground(new Color(128, 128, 128));

		JButton btnVoltar = new JButton("");
		btnVoltar.setToolTipText("Voltar");
		btnVoltar.setPreferredSize(new Dimension(86, 34));
		panelLateralImagem.add(btnVoltar);
		btnVoltar.setBackground(Color.LIGHT_GRAY);
		btnVoltar.setIcon(new ImageIcon("resources\\images\\imgVoltar.png"));
		btnVoltar.addActionListener(new ActionListener() {

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
		JButton btnColecaoImagem = new JButton("Listar Coleção");
		btnColecaoImagem.setToolTipText("Op\u00E7\u00E3o de acesso a aba Coleção!");
		btnColecaoImagem.setPreferredSize(new Dimension(172, 34));
		btnColecaoImagem.setIcon(new ImageIcon("resources\\images\\imgBtnCollection.png"));
		btnColecaoImagem.setFont(new Font("Tahoma", Font.BOLD, 14));
		panelLateralImagem.add(btnColecaoImagem);
		btnColecaoImagem.setBackground(Color.LIGHT_GRAY);

		// Ação que será realizada ao apertar o botao de fimes do jpanelTopo
		btnImagem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				home.getContentPane().add(panelLateralImagem, BorderLayout.WEST);
				panelTopo.setVisible(false); // Torna a visibilidade do paineltopo falsa
				home.getContentPane().remove(panelTopo); // Remove esse painel
				panelLateralImagem.setVisible(true); // Ativa o painel lateral referente ao video
				panelLateralImagem.revalidate();// revalida o loyout
			}
		});
		/**
		 * Musica LATERAL Musica LATERAL Musica LATERAL Musica LATERAL Musica
		 * LATERAL
		 */

		JPanel panelLateralMusica = new JPanel();
		panelLateralMusica.setLayout(new FlowLayout(FlowLayout.LEFT, 4, 4));
		panelLateralMusica.setPreferredSize(new Dimension(180, 400));
		panelLateralMusica.setBackground(new Color(128, 128, 128));

		JButton btnVoltar1 = new JButton("");
		btnVoltar1.setToolTipText("Voltar");
		btnVoltar1.setPreferredSize(new Dimension(86, 34));
		panelLateralMusica.add(btnVoltar1);
		btnVoltar1.setBackground(Color.LIGHT_GRAY);
		btnVoltar1.setIcon(new ImageIcon("resources\\images\\imgVoltar.png"));
		btnVoltar1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				home.getContentPane().add(panelTopo, BorderLayout.NORTH);
				panelLateralMusica.setVisible(false);
				home.getContentPane().remove(panelLateralMusica);
				panelTopo.setVisible(true);
				panelTopo.revalidate();
			}
		});

		// jButton Adicionar
		JButton btnAdicionarMusica = new JButton("Adicionar");
		btnAdicionarMusica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				@SuppressWarnings("unused")
				MusicAdd addFilme = new MusicAdd();
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

		// jButton Favoritos
		JButton btnFavoritosMusica = new JButton("Favoritos");
		btnFavoritosMusica.setToolTipText("Op\u00E7\u00E3o de acesso a aba dos Favoritos!");
		btnFavoritosMusica.setIcon(new ImageIcon("resources\\images\\imgBtnFavorito.png"));
		btnFavoritosMusica.setPreferredSize(new Dimension(172, 34));
		btnFavoritosMusica.setFont(new Font("Tahoma", Font.BOLD, 14));
		panelLateralMusica.add(btnFavoritosMusica);
		btnFavoritosMusica.setBackground(Color.LIGHT_GRAY);
		
		
		JButton btnSorteioMusica = new JButton("Random Musica");
		btnSorteioMusica.setToolTipText("Op\u00E7\u00E3o de acesso a aba Sorteio!");
		btnSorteioMusica.setPreferredSize(new Dimension(172, 34));
		btnSorteioMusica.setIcon(new ImageIcon("resources\\images\\imgBtnRandom.png"));
		btnSorteioMusica.setFont(new Font("Tahoma", Font.BOLD, 14));
		panelLateralMusica.add(btnSorteioMusica);
		btnSorteioMusica.setBackground(Color.LIGHT_GRAY);

		// Ação que será realizada ao apertar o botao de fimes do jpanelTopo
		btnMusica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				home.getContentPane().add(panelLateralMusica, BorderLayout.WEST);
				panelTopo.setVisible(false); // Torna a visibilidade do painel topo falsa
				home.getContentPane().remove(panelTopo); // Remove esse painel
				panelLateralMusica.setVisible(true); // Ativa o painel lateral referente ao Musica
				panelLateralMusica.revalidate();// revalida o loyout
			}
		});

		/**
		 * 
		 *
		 * VIDEO LATERAL VIDEO LATERAL VIDEO LATERAL VIDEO LATERAL VIDEO LATERAL
		 * 
		 * 
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
				FilmesAdd addFilme = new FilmesAdd(usrName);
			}
		});
		btnAdicionarVideo.setToolTipText("Op\u00E7\u00E3o de acesso a aba Adicionar!");
		btnAdicionarVideo.setIcon(new ImageIcon("resources\\images\\imgBtnAdd.png"));
		btnAdicionarVideo.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAdicionarVideo.setPreferredSize(new Dimension(173, 34));
		panelLateralVideo.add(btnAdicionarVideo);
		btnAdicionarVideo.setBackground(Color.LIGHT_GRAY);

		// jButton Remover
		JButton btnRemoverVideo = new JButton("Remover");
		btnRemoverVideo.setToolTipText("Op\u00E7\u00E3o de acesso a aba Remover!");
		btnRemoverVideo.setIcon(new ImageIcon("resources\\images\\imgBtnRemover.png"));
		btnRemoverVideo.setPreferredSize(new Dimension(172, 34));
		btnRemoverVideo.setFont(new Font("Tahoma", Font.BOLD, 14));
		panelLateralVideo.add(btnRemoverVideo);
		btnRemoverVideo.setBackground(Color.LIGHT_GRAY);

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

		// Jbuttom para listar os Animes

		JButton btnAnimes = new JButton("Animes");
		btnAnimes.setIcon(new ImageIcon("resources\\images\\imgBtnAnimes.png"));
		btnAnimes.setToolTipText("Op\u00E7\u00E3o de acesso a aba Adicionar!");
		btnAnimes.setPreferredSize(new Dimension(173, 34));
		btnAnimes.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAnimes.setBackground(Color.LIGHT_GRAY);
		panelLateralVideo.add(btnAnimes);
		// Jbuttom para listar as Séries
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
		/*
		 * 
		 * 
		 * FILMES/CAREGORIAS   FILMES/CAREGORIAS   FILMES/CAREGORIAS   FILMES/CAREGORIAS   FILMES/CAREGORIAS   
		 * 
		 * 
		 * TODO
		 */
		
		JPanel panelCategoriasFilmes = new JPanel();
		panelCategoriasFilmes.setLayout(new FlowLayout(FlowLayout.CENTER));
		panelCategoriasFilmes.setPreferredSize(new Dimension(500, 300));
		panelCategoriasFilmes.setBackground(new Color(120, 120, 120));
		
		JButton btnCatAcao = new JButton("Ação");
		btnCatAcao.setToolTipText("Categoria Ação.");
		btnCatAcao.setPreferredSize(new Dimension(127, 135));
		//btnCatAcao.setIcon(new ImageIcon("resources\\images\\acaoIcon.jpg"));
		btnCatAcao.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCatAcao.setBackground(Color.LIGHT_GRAY);
		panelCategoriasFilmes.add(btnCatAcao);
		
		JButton btnCatAnimacao = new JButton("Animação");
		btnCatAnimacao.setToolTipText("Categoria Animação.");
		btnCatAnimacao.setPreferredSize(new Dimension(127, 135));
		//btnCatAcao.setIcon(new ImageIcon("resources\\images\\acaoIcon.jpg"));
		btnCatAnimacao.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCatAnimacao.setBackground(Color.LIGHT_GRAY);
		panelCategoriasFilmes.add(btnCatAnimacao);
		
		JButton btnCatAventura = new JButton("Aventura");
		btnCatAventura.setToolTipText("Categoria Ação.");
		btnCatAventura.setPreferredSize(new Dimension(127, 135));
		//btnCatAcao.setIcon(new ImageIcon("resources\\images\\acaoIcon.jpg"));
		btnCatAventura.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCatAventura.setBackground(Color.LIGHT_GRAY);
		panelCategoriasFilmes.add(btnCatAventura);
		
		JButton btnCatClassico = new JButton("Classico");
		btnCatClassico.setToolTipText("Categoria Classico.");
		btnCatClassico.setPreferredSize(new Dimension(127, 135));
		//btnCatAcao.setIcon(new ImageIcon("resources\\images\\acaoIcon.jpg"));
		btnCatClassico.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCatClassico.setBackground(Color.LIGHT_GRAY);
		panelCategoriasFilmes.add(btnCatClassico);
		
		JButton btnCatComedia = new JButton("Comédia");
		btnCatComedia.setToolTipText("Categoria Comédia.");
		btnCatComedia.setPreferredSize(new Dimension(127, 135));
		//btnCatAcao.setIcon(new ImageIcon("resources\\images\\acaoIcon.jpg"));
		btnCatComedia.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCatComedia.setBackground(Color.LIGHT_GRAY);
		panelCategoriasFilmes.add(btnCatComedia);
		
		JButton btnCatComediaRomantica = new JButton("<html><CENTER>Comédia</br> Romantica</CENTER></html>");
		btnCatComediaRomantica.setToolTipText("Categoria Comédia Romantica.");
		btnCatComediaRomantica.setPreferredSize(new Dimension(127, 135));
		//btnCatAcao.setIcon(new ImageIcon("resources\\images\\acaoIcon.jpg"));
		btnCatComediaRomantica.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCatComediaRomantica.setBackground(Color.LIGHT_GRAY);
		panelCategoriasFilmes.add(btnCatComediaRomantica);
		
		JButton btnCatCrime= new JButton("Crime");
		btnCatCrime.setToolTipText("Categoria Crime.");
		btnCatCrime.setPreferredSize(new Dimension(127, 135));
		//btnCatAcao.setIcon(new ImageIcon("resources\\images\\acaoIcon.jpg"));
		btnCatCrime.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCatCrime.setBackground(Color.LIGHT_GRAY);
		panelCategoriasFilmes.add(btnCatCrime);
		
		JButton btnCatDocumentario = new JButton("<html><p>Documentá-<br>rio</html>");
		btnCatDocumentario.setToolTipText("Categoria Documentário.");
		btnCatDocumentario.setPreferredSize(new Dimension(127, 135));
		//btnCatAcao.setIcon(new ImageIcon("resources\\images\\acaoIcon.jpg"));
		btnCatDocumentario.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCatDocumentario.setBackground(Color.LIGHT_GRAY);
		panelCategoriasFilmes.add(btnCatDocumentario);
		
		JButton btnCatDrama = new JButton("Drama");
		btnCatDrama.setToolTipText("Categoria Drama.");
		btnCatDrama.setPreferredSize(new Dimension(127, 135));
		//btnCatAcao.setIcon(new ImageIcon("resources\\images\\acaoIcon.jpg"));
		btnCatDrama.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCatDrama.setBackground(Color.LIGHT_GRAY);
		panelCategoriasFilmes.add(btnCatDrama);
		
		JButton btnCatFaroeste = new JButton("Faroeste");
		btnCatFaroeste.setToolTipText("Categoria Faroeste.");
		btnCatFaroeste.setPreferredSize(new Dimension(127, 135));
		//btnCatAcao.setIcon(new ImageIcon("resources\\images\\acaoIcon.jpg"));
		btnCatFaroeste.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCatFaroeste.setBackground(Color.LIGHT_GRAY);
		panelCategoriasFilmes.add(btnCatFaroeste);
		
		JButton btnCatFicaoCient = new JButton("<html><center>Ficção</br> Científica</center></html>");
		btnCatFicaoCient.setToolTipText("Categoria Ficção Científica.");
		btnCatFicaoCient.setPreferredSize(new Dimension(127, 135));
		//btnCatAcao.setIcon(new ImageIcon("resources\\images\\acaoIcon.jpg"));
		btnCatFicaoCient.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCatFicaoCient.setBackground(Color.LIGHT_GRAY);
		panelCategoriasFilmes.add(btnCatFicaoCient);
		
		JButton btnCatGuerra = new JButton("Guerra");
		btnCatGuerra.setToolTipText("Categoria Guerra.");
		btnCatGuerra.setPreferredSize(new Dimension(127, 135));
		//btnCatAcao.setIcon(new ImageIcon("resources\\images\\acaoIcon.jpg"));
		btnCatGuerra.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCatGuerra.setBackground(Color.LIGHT_GRAY);
		panelCategoriasFilmes.add(btnCatGuerra);
		
		JButton btnCatMusical = new JButton("Musical");
		btnCatMusical.setToolTipText("Categoria Musical.");
		btnCatMusical.setPreferredSize(new Dimension(127, 135));
		//btnCatAcao.setIcon(new ImageIcon("resources\\images\\acaoIcon.jpg"));
		btnCatMusical.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCatMusical.setBackground(Color.LIGHT_GRAY);
		panelCategoriasFilmes.add(btnCatMusical);
		
		JButton btnCatPolicial = new JButton("Policial");
		btnCatPolicial.setToolTipText("Categoria Policial.");
		btnCatPolicial.setPreferredSize(new Dimension(127, 135));
		//btnCatAcao.setIcon(new ImageIcon("resources\\images\\acaoIcon.jpg"));
		btnCatPolicial.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCatPolicial.setBackground(Color.LIGHT_GRAY);
		panelCategoriasFilmes.add(btnCatPolicial);
		
		JButton btnCatRomance = new JButton("Romance");
		btnCatRomance.setToolTipText("Categoria Romance.");
		btnCatRomance.setPreferredSize(new Dimension(127, 135));
		//btnCatAcao.setIcon(new ImageIcon("resources\\images\\acaoIcon.jpg"));
		btnCatRomance.setFont(new Font("Tahoma", Font.BOLD, 14));

		btnCatRomance.setBackground(Color.LIGHT_GRAY);
		panelCategoriasFilmes.add(btnCatRomance);
		
		JButton btnCatSuspense = new JButton("Suspense");
		btnCatSuspense.setToolTipText("Categoria Suspense.");
		btnCatSuspense.setPreferredSize(new Dimension(127, 135));
		//btnCatAcao.setIcon(new ImageIcon("resources\\images\\acaoIcon.jpg"));
		btnCatSuspense.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCatSuspense.setBackground(Color.LIGHT_GRAY);
		panelCategoriasFilmes.add(btnCatSuspense);
		
		JButton btnCatTerror = new JButton("Terror");
		btnCatTerror.setToolTipText("Categoria Terror.");
		btnCatTerror.setPreferredSize(new Dimension(127, 135));
		//btnCatAcao.setIcon(new ImageIcon("resources\\images\\acaoIcon.jpg"));
		btnCatTerror.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCatTerror.setBackground(Color.LIGHT_GRAY);
		panelCategoriasFilmes.add(btnCatTerror);
		
		JButton btnCatThriller = new JButton("Thriller");
		btnCatThriller.setToolTipText("Categoria Thriller.");
		btnCatThriller.setPreferredSize(new Dimension(127, 135));
		//btnCatAcao.setIcon(new ImageIcon("resources\\images\\acaoIcon.jpg"));
		btnCatThriller.setFont(new Font("Tahoma", Font.BOLD, 14));
		panelCategoriasFilmes.add(btnCatThriller);
		btnCatThriller.setBackground(Color.LIGHT_GRAY);
		
		
		//Jpanels para cada Categoria de Filmes
		JPanel filmesCatAcao = new JPanel();
		filmesCatAcao.setLayout(new FlowLayout(FlowLayout.CENTER));
		filmesCatAcao.setPreferredSize(new Dimension(500, 300));
		filmesCatAcao.setBackground(new Color(120, 120, 120));
		
		JPanel filmesCatAnimacao = new JPanel();
		filmesCatAnimacao.setLayout(new FlowLayout(FlowLayout.CENTER));
		filmesCatAnimacao.setPreferredSize(new Dimension(500, 300));
		filmesCatAnimacao.setBackground(new Color(120, 120, 120));
		
		JPanel filmesCatAventura = new JPanel();
		filmesCatAventura.setLayout(new FlowLayout(FlowLayout.CENTER));
		filmesCatAventura.setPreferredSize(new Dimension(500, 300));
		filmesCatAventura.setBackground(new Color(120, 120, 120));
		
		JPanel filmesCatClassico = new JPanel();
		filmesCatClassico.setLayout(new FlowLayout(FlowLayout.CENTER));
		filmesCatClassico.setPreferredSize(new Dimension(500, 300));
		filmesCatClassico.setBackground(new Color(120, 120, 120));
		
		JPanel filmesCatComedia = new JPanel();
		filmesCatComedia.setLayout(new FlowLayout(FlowLayout.CENTER));
		filmesCatComedia.setPreferredSize(new Dimension(500, 300));
		filmesCatComedia.setBackground(new Color(120, 120, 120));
		
		JPanel filmesCatComediaRomantico = new JPanel();
		filmesCatComediaRomantico.setLayout(new FlowLayout(FlowLayout.CENTER));
		filmesCatComediaRomantico.setPreferredSize(new Dimension(500, 300));
		filmesCatComediaRomantico.setBackground(new Color(120, 120, 120));
		
		JPanel filmesCatCrime = new JPanel();
		filmesCatCrime.setLayout(new FlowLayout(FlowLayout.CENTER));
		filmesCatCrime.setPreferredSize(new Dimension(500, 300));
		filmesCatCrime.setBackground(new Color(120, 120, 120));
		
		JPanel filmesCatDocumentario = new JPanel();
		filmesCatDocumentario.setLayout(new FlowLayout(FlowLayout.CENTER));
		filmesCatDocumentario.setPreferredSize(new Dimension(500, 300));
		filmesCatDocumentario.setBackground(new Color(120, 120, 120));
		
		JPanel filmesCatDrama = new JPanel();
		filmesCatDrama.setLayout(new FlowLayout(FlowLayout.CENTER));
		filmesCatDrama.setPreferredSize(new Dimension(500, 300));
		filmesCatDrama.setBackground(new Color(120, 120, 120));
		
		JPanel filmesCatFaroeste = new JPanel();
		filmesCatFaroeste.setLayout(new FlowLayout(FlowLayout.CENTER));
		filmesCatFaroeste.setPreferredSize(new Dimension(500, 300));
		filmesCatFaroeste.setBackground(new Color(120, 120, 120));
		
		JPanel filmesCatFiccaoCient = new JPanel();
		filmesCatFiccaoCient.setLayout(new FlowLayout(FlowLayout.CENTER));
		filmesCatFiccaoCient.setPreferredSize(new Dimension(500, 300));
		filmesCatFiccaoCient.setBackground(new Color(120, 120, 120));
		
		JPanel filmesCatGuerra = new JPanel();
		filmesCatGuerra.setLayout(new FlowLayout(FlowLayout.CENTER));
		filmesCatGuerra.setPreferredSize(new Dimension(500, 300));
		filmesCatGuerra.setBackground(new Color(120, 120, 120));
		
		JPanel filmesCatMusical = new JPanel();
		filmesCatMusical.setLayout(new FlowLayout(FlowLayout.CENTER));
		filmesCatMusical.setPreferredSize(new Dimension(500, 300));
		filmesCatMusical.setBackground(new Color(120, 120, 120));
		
		JPanel filmesCatPolicial = new JPanel();
		filmesCatPolicial.setLayout(new FlowLayout(FlowLayout.CENTER));
		filmesCatPolicial.setPreferredSize(new Dimension(500, 300));
		filmesCatPolicial.setBackground(new Color(120, 120, 120));
		
		JPanel filmesCatRomance= new JPanel();
		filmesCatRomance.setLayout(new FlowLayout(FlowLayout.CENTER));
		filmesCatRomance.setPreferredSize(new Dimension(500, 300));
		filmesCatRomance.setBackground(new Color(120, 120, 120));
		
		JPanel filmesCatSuspense = new JPanel();
		filmesCatSuspense.setLayout(new FlowLayout(FlowLayout.CENTER));
		filmesCatSuspense.setPreferredSize(new Dimension(500, 300));
		filmesCatSuspense.setBackground(new Color(120, 120, 120));
		
		JPanel filmesCatTerror = new JPanel();
		filmesCatTerror.setLayout(new FlowLayout(FlowLayout.CENTER));
		filmesCatTerror.setPreferredSize(new Dimension(500, 300));
		filmesCatTerror.setBackground(new Color(120, 120, 120));
		
		JPanel filmesCatThriller = new JPanel();
		filmesCatThriller.setLayout(new FlowLayout(FlowLayout.CENTER));
		filmesCatThriller.setPreferredSize(new Dimension(500, 300));
		filmesCatThriller.setBackground(new Color(120, 120, 120));
		
		/*
		 * 
		 * 
		 * SERIES/CAREGORIAS   SERIES/CAREGORIAS   SERIES/CAREGORIAS   SERIES/CAREGORIAS   SERIES/CAREGORIAS   
		 * TODO
		 * 
		 * 
		 */

		
		JPanel panelCategoriasSerie = new JPanel();
		panelCategoriasSerie.setLayout(new FlowLayout(FlowLayout.CENTER));
		panelCategoriasSerie.setPreferredSize(new Dimension(500, 300));
		panelCategoriasSerie.setBackground(new Color(120, 120, 120));
		
		JButton btnCatAcaoSerie = new JButton("Ação");
		btnCatAcaoSerie.setToolTipText("Categoria Ação.");
		btnCatAcaoSerie.setPreferredSize(new Dimension(127, 135));
		//btnCatAcao.setIcon(new ImageIcon("resources\\images\\acaoIcon.jpg"));
		btnCatAcaoSerie.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCatAcaoSerie.setBackground(Color.LIGHT_GRAY);
		panelCategoriasSerie.add(btnCatAcaoSerie);
		
		JButton btnCatAnimacaoSerie = new JButton("Animação");
		btnCatAnimacaoSerie.setToolTipText("Categoria Animação.");
		btnCatAnimacaoSerie.setPreferredSize(new Dimension(127, 135));
		//btnCatAcao.setIcon(new ImageIcon("resources\\images\\acaoIcon.jpg"));
		btnCatAnimacaoSerie.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCatAnimacaoSerie.setBackground(Color.LIGHT_GRAY);
		panelCategoriasSerie.add(btnCatAnimacaoSerie);
		
		JButton btnCatAventuraSerie = new JButton("Aventura");
		btnCatAventuraSerie.setToolTipText("Categoria Ação.");
		btnCatAventuraSerie.setPreferredSize(new Dimension(127, 135));
		//btnCatAcao.setIcon(new ImageIcon("resources\\images\\acaoIcon.jpg"));
		btnCatAventuraSerie.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCatAventuraSerie.setBackground(Color.LIGHT_GRAY);
		panelCategoriasSerie.add(btnCatAventuraSerie);
		
		JButton btnCatClassicoSerie = new JButton("Classico");
		btnCatClassicoSerie.setToolTipText("Categoria Classico.");
		btnCatClassicoSerie.setPreferredSize(new Dimension(127, 135));
		//btnCatAcao.setIcon(new ImageIcon("resources\\images\\acaoIcon.jpg"));
		btnCatClassicoSerie.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCatClassicoSerie.setBackground(Color.LIGHT_GRAY);
		panelCategoriasSerie.add(btnCatClassicoSerie);
		
		JButton btnCatComediaSerie = new JButton("Comédia");
		btnCatComediaSerie.setToolTipText("Categoria Comédia.");
		btnCatComediaSerie.setPreferredSize(new Dimension(127, 135));
		//btnCatAcao.setIcon(new ImageIcon("resources\\images\\acaoIcon.jpg"));
		btnCatComediaSerie.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCatComediaSerie.setBackground(Color.LIGHT_GRAY);
		panelCategoriasSerie.add(btnCatComediaSerie);
		
		JButton btnCatComediaRomanticaSerie = new JButton("<html><CENTER>Comédia</br> Romantica</CENTER></html>");
		btnCatComediaRomanticaSerie.setToolTipText("Categoria Comédia Romantica.");
		btnCatComediaRomanticaSerie.setPreferredSize(new Dimension(127, 135));
		//btnCatAcao.setIcon(new ImageIcon("resources\\images\\acaoIcon.jpg"));
		btnCatComediaRomanticaSerie.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCatComediaRomanticaSerie.setBackground(Color.LIGHT_GRAY);
		panelCategoriasSerie.add(btnCatComediaRomanticaSerie);
		
		JButton btnCatCrimeSerie= new JButton("Crime");
		btnCatCrimeSerie.setToolTipText("Categoria Crime.");
		btnCatCrimeSerie.setPreferredSize(new Dimension(127, 135));
		//btnCatAcao.setIcon(new ImageIcon("resources\\images\\acaoIcon.jpg"));
		btnCatCrimeSerie.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCatCrimeSerie.setBackground(Color.LIGHT_GRAY);
		panelCategoriasSerie.add(btnCatCrimeSerie);
		
		JButton btnCatDocumentarioSerie = new JButton("<html><p>Documentá-<br>rio</html>");
		btnCatDocumentarioSerie.setToolTipText("Categoria Documentário.");
		btnCatDocumentarioSerie.setPreferredSize(new Dimension(127, 135));
		//btnCatAcao.setIcon(new ImageIcon("resources\\images\\acaoIcon.jpg"));
		btnCatDocumentarioSerie.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCatDocumentarioSerie.setBackground(Color.LIGHT_GRAY);
		panelCategoriasSerie.add(btnCatDocumentarioSerie);
		
		JButton btnCatDramaSerie = new JButton("Drama");
		btnCatDramaSerie.setToolTipText("Categoria Drama.");
		btnCatDramaSerie.setPreferredSize(new Dimension(127, 135));
		//btnCatAcao.setIcon(new ImageIcon("resources\\images\\acaoIcon.jpg"));
		btnCatDramaSerie.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCatDramaSerie.setBackground(Color.LIGHT_GRAY);
		panelCategoriasSerie.add(btnCatDramaSerie);
		
		JButton btnCatFaroesteSerie = new JButton("Faroeste");
		btnCatFaroesteSerie.setToolTipText("Categoria Faroeste.");
		btnCatFaroesteSerie.setPreferredSize(new Dimension(127, 135));
		//btnCatAcao.setIcon(new ImageIcon("resources\\images\\acaoIcon.jpg"));
		btnCatFaroesteSerie.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCatFaroesteSerie.setBackground(Color.LIGHT_GRAY);
		panelCategoriasSerie.add(btnCatFaroesteSerie);
		
		JButton btnCatFicaoCientSerie = new JButton("<html><center>Ficção</br> Científica</center></html>");
		btnCatFicaoCientSerie.setToolTipText("Categoria Ficção Científica.");
		btnCatFicaoCientSerie.setPreferredSize(new Dimension(127, 135));
		//btnCatAcao.setIcon(new ImageIcon("resources\\images\\acaoIcon.jpg"));
		btnCatFicaoCientSerie.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCatFicaoCientSerie.setBackground(Color.LIGHT_GRAY);
		panelCategoriasSerie.add(btnCatFicaoCientSerie);
		
		JButton btnCatGuerraSerie = new JButton("Guerra");
		btnCatGuerraSerie.setToolTipText("Categoria Guerra.");
		btnCatGuerraSerie.setPreferredSize(new Dimension(127, 135));
		//btnCatAcao.setIcon(new ImageIcon("resources\\images\\acaoIcon.jpg"));
		btnCatGuerraSerie.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCatGuerraSerie.setBackground(Color.LIGHT_GRAY);
		panelCategoriasSerie.add(btnCatGuerraSerie);
		
		JButton btnCatMedicoSerie = new JButton("Médico");
		btnCatMedicoSerie.setToolTipText("Categoria Thriller.");
		btnCatMedicoSerie.setPreferredSize(new Dimension(127, 135));
		//btnCatAcao.setIcon(new ImageIcon("resources\\images\\acaoIcon.jpg"));
		btnCatMedicoSerie.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCatMedicoSerie.setBackground(Color.LIGHT_GRAY);
		panelCategoriasSerie.add(btnCatMedicoSerie);
		
		JButton btnCatMusicalSerie = new JButton("Musical");
		btnCatMusicalSerie.setToolTipText("Categoria Musical.");
		btnCatMusicalSerie.setPreferredSize(new Dimension(127, 135));
		//btnCatAcao.setIcon(new ImageIcon("resources\\images\\acaoIcon.jpg"));
		btnCatMusicalSerie.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCatMusicalSerie.setBackground(Color.LIGHT_GRAY);
		panelCategoriasSerie.add(btnCatMusicalSerie);
		
		JButton btnCatPolicialSerie = new JButton("Policial");
		btnCatPolicialSerie.setToolTipText("Categoria Policial.");
		btnCatPolicialSerie.setPreferredSize(new Dimension(127, 135));
		//btnCatAcao.setIcon(new ImageIcon("resources\\images\\acaoIcon.jpg"));
		btnCatPolicialSerie.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCatPolicialSerie.setBackground(Color.LIGHT_GRAY);
		panelCategoriasSerie.add(btnCatPolicialSerie);
		
		JButton btnCatRomanceSerie = new JButton("Romance");
		btnCatRomanceSerie.setToolTipText("Categoria Romance.");
		btnCatRomanceSerie.setPreferredSize(new Dimension(127, 135));
		//btnCatAcao.setIcon(new ImageIcon("resources\\images\\acaoIcon.jpg"));
		btnCatRomanceSerie.setFont(new Font("Tahoma", Font.BOLD, 14));

		btnCatRomanceSerie.setBackground(Color.LIGHT_GRAY);
		panelCategoriasSerie.add(btnCatRomanceSerie);
		
		JButton btnCatSuspenseSerie = new JButton("Suspense");
		btnCatSuspenseSerie.setToolTipText("Categoria Suspense.");
		btnCatSuspenseSerie.setPreferredSize(new Dimension(127, 135));
		//btnCatAcao.setIcon(new ImageIcon("resources\\images\\acaoIcon.jpg"));
		btnCatSuspenseSerie.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCatSuspenseSerie.setBackground(Color.LIGHT_GRAY);
		panelCategoriasSerie.add(btnCatSuspenseSerie);
		
		JButton btnCatTerrorSerie = new JButton("Terror");
		btnCatTerrorSerie.setToolTipText("Categoria Terror.");
		btnCatTerrorSerie.setPreferredSize(new Dimension(127, 135));
		//btnCatAcao.setIcon(new ImageIcon("resources\\images\\acaoIcon.jpg"));
		btnCatTerrorSerie.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCatTerrorSerie.setBackground(Color.LIGHT_GRAY);
		panelCategoriasSerie.add(btnCatTerrorSerie);

		
		
		//Jpanels para cada Categoria de Series
		JPanel serieCatAcao = new JPanel();
		serieCatAcao.setLayout(new FlowLayout(FlowLayout.CENTER));
		serieCatAcao.setPreferredSize(new Dimension(500, 300));
		serieCatAcao.setBackground(new Color(120, 120, 120));
		
		JPanel serieCatAnimacao = new JPanel();
		serieCatAnimacao.setLayout(new FlowLayout(FlowLayout.CENTER));
		serieCatAnimacao.setPreferredSize(new Dimension(500, 300));
		serieCatAnimacao.setBackground(new Color(120, 120, 120));
		
		JPanel serieCatAventura = new JPanel();
		serieCatAventura.setLayout(new FlowLayout(FlowLayout.CENTER));
		serieCatAventura.setPreferredSize(new Dimension(500, 300));
		serieCatAventura.setBackground(new Color(120, 120, 120));
		
		JPanel serieCatClassico = new JPanel();
		serieCatClassico.setLayout(new FlowLayout(FlowLayout.CENTER));
		serieCatClassico.setPreferredSize(new Dimension(500, 300));
		serieCatClassico.setBackground(new Color(120, 120, 120));
		
		JPanel serieCatComedia = new JPanel();
		serieCatComedia.setLayout(new FlowLayout(FlowLayout.CENTER));
		serieCatComedia.setPreferredSize(new Dimension(500, 300));
		serieCatComedia.setBackground(new Color(120, 120, 120));
		
		JPanel serieCatComediaRomantico = new JPanel();
		serieCatComediaRomantico.setLayout(new FlowLayout(FlowLayout.CENTER));
		serieCatComediaRomantico.setPreferredSize(new Dimension(500, 300));
		serieCatComediaRomantico.setBackground(new Color(120, 120, 120));
		
		JPanel serieCatCrime = new JPanel();
		serieCatCrime.setLayout(new FlowLayout(FlowLayout.CENTER));
		serieCatCrime.setPreferredSize(new Dimension(500, 300));
		serieCatCrime.setBackground(new Color(120, 120, 120));
		
		JPanel serieCatDocumentario = new JPanel();
		serieCatDocumentario.setLayout(new FlowLayout(FlowLayout.CENTER));
		serieCatDocumentario.setPreferredSize(new Dimension(500, 300));
		serieCatDocumentario.setBackground(new Color(120, 120, 120));
		
		JPanel serieCatDrama = new JPanel();
		serieCatDrama.setLayout(new FlowLayout(FlowLayout.CENTER));
		serieCatDrama.setPreferredSize(new Dimension(500, 300));
		serieCatDrama.setBackground(new Color(120, 120, 120));
		
		JPanel serieCatFaroeste = new JPanel();
		serieCatFaroeste.setLayout(new FlowLayout(FlowLayout.CENTER));
		serieCatFaroeste.setPreferredSize(new Dimension(500, 300));
		serieCatFaroeste.setBackground(new Color(120, 120, 120));
		
		JPanel serieCatFiccaoCient = new JPanel();
		serieCatFiccaoCient.setLayout(new FlowLayout(FlowLayout.CENTER));
		serieCatFiccaoCient.setPreferredSize(new Dimension(500, 300));
		serieCatFiccaoCient.setBackground(new Color(120, 120, 120));
		
		JPanel serieCatGuerra = new JPanel();
		serieCatGuerra.setLayout(new FlowLayout(FlowLayout.CENTER));
		serieCatGuerra.setPreferredSize(new Dimension(500, 300));
		serieCatGuerra.setBackground(new Color(120, 120, 120));
		
		JPanel serieCatMusical = new JPanel();
		serieCatMusical.setLayout(new FlowLayout(FlowLayout.CENTER));
		serieCatMusical.setPreferredSize(new Dimension(500, 300));
		serieCatMusical.setBackground(new Color(120, 120, 120));
		
		JPanel serieCatPolicial = new JPanel();
		serieCatPolicial.setLayout(new FlowLayout(FlowLayout.CENTER));
		serieCatPolicial.setPreferredSize(new Dimension(500, 300));
		serieCatPolicial.setBackground(new Color(120, 120, 120));
		
		JPanel serieCatRomance= new JPanel();
		serieCatRomance.setLayout(new FlowLayout(FlowLayout.CENTER));
		serieCatRomance.setPreferredSize(new Dimension(500, 300));
		serieCatRomance.setBackground(new Color(120, 120, 120));
		
		JPanel serieCatSuspense = new JPanel();
		serieCatSuspense.setLayout(new FlowLayout(FlowLayout.CENTER));
		serieCatSuspense.setPreferredSize(new Dimension(500, 300));
		serieCatSuspense.setBackground(new Color(120, 120, 120));
		
		JPanel serieCatTerror = new JPanel();
		serieCatTerror.setLayout(new FlowLayout(FlowLayout.CENTER));
		serieCatTerror.setPreferredSize(new Dimension(500, 300));
		serieCatTerror.setBackground(new Color(120, 120, 120));
		
		JPanel serieCatMedico = new JPanel();
		serieCatMedico.setLayout(new FlowLayout(FlowLayout.CENTER));
		serieCatMedico.setPreferredSize(new Dimension(500, 300));
		serieCatMedico.setBackground(new Color(120, 120, 120));
		
		
		/*
		 * AÇÃO DE BUTTONS	AÇÃO DE BUTTONS	AÇÃO DE BUTTONS	AÇÃO DE BUTTONS	
		 * TODO
		 */
		
		
				
		// Ação que será realizada ao apertar o botao de VIDEOS do jpanelTopo
		btnVdeo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				home.getContentPane().add(panelLateralVideo, BorderLayout.WEST);
				panelTopo.setVisible(false); // Torna a visibilidade do painel topo falsa
				home.getContentPane().remove(panelTopo); // Remove esse painel
				panelLateralVideo.setVisible(true); // Ativa o painel lateral referente ao video
				panelLateralVideo.revalidate();// revalida o loyout
			}
		});
		
		//Ação ao clicar no button lateral Filmes
		btnFilmes.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent event) {
				home.getContentPane().remove(labelFundo);
				home.getContentPane().remove(panelCategoriasFilmes);
				home.getContentPane().remove(panelCategoriasSerie);
				panelCategoriasSerie.setEnabled(false);
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
				home.getContentPane().remove(labelFundo);
				home.getContentPane().remove(panelCategoriasFilmes);
				home.getContentPane().remove(panelCategoriasSerie);
				panelCategoriasFilmes.setEnabled(false);
				home.getContentPane().add(panelCategoriasSerie, BorderLayout.CENTER);
				panelCategoriasSerie.setVisible(true);
				panelCategoriasSerie.revalidate();
				panelCategoriasSerie.repaint();
				timer.clse();
			}
		});
		//Ação do botão voltar
		btnVoltarVideo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				home.getContentPane().add(panelTopo, BorderLayout.NORTH);
				panelLateralVideo.setVisible(false);
				home.getContentPane().remove(panelLateralVideo);
				home.getContentPane().remove(panelCategoriasFilmes);
				home.getContentPane().remove(panelCategoriasSerie);
				panelCategoriasFilmes.setVisible(false);
				panelCategoriasSerie.setVisible(false);
				panelCategoriasFilmes.revalidate();
				panelCategoriasSerie.revalidate();
				panelCategoriasFilmes.repaint();
				panelCategoriasSerie.repaint();
				panelTopo.setVisible(true);
				home.getContentPane().add(labelFundo, BorderLayout.CENTER);
				//Retira o bug de voltar caso aperte em qualquer butao de seleção do genero
				home.getContentPane().remove(serieCatAcao);
				home.getContentPane().remove(filmesCatAnimacao);
				panelTopo.revalidate();
				panelTopo.repaint();
				home.repaint();
				home.revalidate();
				timer.init();
			}
		});
		//
		/**
		 * TODO
		 * Acao dos botoes de categorias de Filmes
		 */
		
		//
		//Ação do botão filmes categoria Ação
				btnCatAcao.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						String genero = "acão";
						FRarquivos retorno = new FRarquivos();
						Boolean ler = false;
							ler = retorno.VerificaGeneroExistente(usrName,genero);			
						if (ler){
							panelCategoriasFilmes.setVisible(false);
							home.getContentPane().remove(panelCategoriasFilmes);
							home.getContentPane().add(filmesCatAcao, BorderLayout.CENTER);
							filmesCatAcao.setVisible(true);
							filmesCatAcao.revalidate();
						}	else
						{
							JOptionPane.showMessageDialog(null, "Não à nada a ser listado","Inválido",0);
						}
					
					}
				});
				
				//Ação do botão filmes categoria Animação
						btnCatAnimacao.addActionListener(new ActionListener() {
							
							@Override
							public void actionPerformed(ActionEvent e) {
								String genero = "Animação";
								FRarquivos retorno = new FRarquivos();
								Boolean ler = false;
									ler = retorno.VerificaGeneroExistente(usrName,genero);			
								if (ler){
									panelCategoriasFilmes.setVisible(false);
									home.getContentPane().remove(panelCategoriasFilmes);
									home.getContentPane().add(panelCategoriasFilmes, BorderLayout.CENTER);
									filmesCatAnimacao.setVisible(true);
									filmesCatAnimacao.revalidate();
								}	else
								{
									JOptionPane.showMessageDialog(null, "Não à nada a ser listado","Invalido",0);
								}
								
							}
						});
						
				//Ação do botão filmes categoria Aventura
						btnCatAventura.addActionListener(new ActionListener() {
							
							@Override
							public void actionPerformed(ActionEvent e) {
								
								String genero = "aventura";
								FRarquivos retorno = new FRarquivos();
								Boolean ler = false;
									ler = retorno.VerificaGeneroExistente(usrName,genero);			
								if (ler){
									panelCategoriasFilmes.setVisible(false);
									home.getContentPane().remove(panelCategoriasFilmes);
									home.getContentPane().add(panelCategoriasFilmes, BorderLayout.CENTER);
									filmesCatAventura.setVisible(true);
									filmesCatAventura.revalidate();
								}	else
								{
									JOptionPane.showMessageDialog(null, "Não à nada a ser listado","Inválido",0);
								}
							
							}
						});
						
				//Ação do botão filmes categoria Classico
						btnCatClassico.addActionListener(new ActionListener() {
							
							@Override
							public void actionPerformed(ActionEvent e) {
								String genero = "Cl\u00E1ssico";
								FRarquivos retorno = new FRarquivos();
								Boolean ler = false;
									ler = retorno.VerificaGeneroExistente(usrName,genero);			
								if (ler){
									panelCategoriasFilmes.setVisible(false);
									home.getContentPane().remove(panelCategoriasFilmes);
									home.getContentPane().add(panelCategoriasFilmes, BorderLayout.CENTER);
									filmesCatClassico.setVisible(true);
									filmesCatClassico.revalidate();


								}	else
								{
									JOptionPane.showMessageDialog(null, "Não à nada a ser listado","Inválido",0);
								}
							}
						});
						
				//Ação do botão filmes categoria Comedia
						btnCatComedia.addActionListener(new ActionListener() {
							
							@Override
							public void actionPerformed(ActionEvent e) {
								String genero = "Com\u00E9dia";
								FRarquivos retorno = new FRarquivos();
								Boolean ler = false;
									ler = retorno.VerificaGeneroExistente(usrName,genero);			
								if (ler){
									panelCategoriasFilmes.setVisible(false);
									home.getContentPane().remove(panelCategoriasFilmes);
									home.getContentPane().add(panelCategoriasFilmes, BorderLayout.CENTER);
									filmesCatComedia.setVisible(true);
									filmesCatComedia.revalidate();


								}	else
								{
									JOptionPane.showMessageDialog(null, "Não à nada a ser listado","Inválido",0);
								}
							}
						});
						
				//Ação do botão filmes categoria ComediaRomantica
						btnCatComediaRomantica.addActionListener(new ActionListener() {
							
							@Override
							public void actionPerformed(ActionEvent e) {
								String genero = "Com\u00E9dia Rom\u00E2ntica";
								FRarquivos retorno = new FRarquivos();
								Boolean ler = false;
									ler = retorno.VerificaGeneroExistente(usrName,genero);			
								if (ler){
									panelCategoriasFilmes.setVisible(false);
									home.getContentPane().remove(panelCategoriasFilmes);
									home.getContentPane().add(panelCategoriasFilmes, BorderLayout.CENTER);
									filmesCatComediaRomantico.setVisible(true);
									filmesCatComediaRomantico.revalidate();


								}	else
								{
									JOptionPane.showMessageDialog(null, "Não à nada a ser listado","Inválido",0);
								}
							}
						});
						
				//Ação do botão filmes categoria Crime
						btnCatCrime.addActionListener(new ActionListener() {
							
							@Override
							public void actionPerformed(ActionEvent e) {
								String genero = "Crime";
								FRarquivos retorno = new FRarquivos();
								Boolean ler = false;
									ler = retorno.VerificaGeneroExistente(usrName,genero);			
								if (ler){

									panelCategoriasFilmes.setVisible(false);
									home.getContentPane().remove(panelCategoriasFilmes);
									home.getContentPane().add(panelCategoriasFilmes, BorderLayout.CENTER);
									filmesCatCrime.setVisible(true);
									filmesCatCrime.revalidate();

								}	else
								{
									JOptionPane.showMessageDialog(null, "Não à nada a ser listado","Inválido",0);
								}
							}
						});
						
				//Ação do botão filmes categoria Documentario
						btnCatDocumentario.addActionListener(new ActionListener() {
							
							@Override
							public void actionPerformed(ActionEvent e) {
								String genero = "Document\u00E1rio";
								FRarquivos retorno = new FRarquivos();
								Boolean ler = false;
									ler = retorno.VerificaGeneroExistente(usrName,genero);			
								if (ler){

									panelCategoriasFilmes.setVisible(false);
									home.getContentPane().remove(panelCategoriasFilmes);
									home.getContentPane().add(panelCategoriasFilmes, BorderLayout.CENTER);
									filmesCatDocumentario.setVisible(true);
									filmesCatDocumentario.revalidate();

								}	else
								{
									JOptionPane.showMessageDialog(null, "Não à nada a ser listado","Inválido",0);
								}
							}
						});	
						
				//Ação do botão filmes categoria Drama
						btnCatDrama.addActionListener(new ActionListener() {
							
							@Override
							public void actionPerformed(ActionEvent e) {
								String genero = "Drama";
								FRarquivos retorno = new FRarquivos();
								Boolean ler = false;
									ler = retorno.VerificaGeneroExistente(usrName,genero);			
								if (ler){
									panelCategoriasFilmes.setVisible(false);
									home.getContentPane().remove(panelCategoriasFilmes);
									home.getContentPane().add(panelCategoriasFilmes, BorderLayout.CENTER);
									filmesCatDrama.setVisible(true);
									filmesCatDrama.revalidate();


								}	else
								{
									JOptionPane.showMessageDialog(null, "Não à nada a ser listado","Inválido",0);
								}
							}
						});
						
				//Ação do botão filmes categoria Faroeste
						btnCatFaroeste.addActionListener(new ActionListener() {
							
							@Override
							public void actionPerformed(ActionEvent e) {
								String genero = "Faroeste";
								FRarquivos retorno = new FRarquivos();
								Boolean ler = false;
									ler = retorno.VerificaGeneroExistente(usrName,genero);			
								if (ler){
									panelCategoriasFilmes.setVisible(false);
									home.getContentPane().remove(panelCategoriasFilmes);
									home.getContentPane().add(panelCategoriasFilmes, BorderLayout.CENTER);
									filmesCatFaroeste.setVisible(true);
									filmesCatFaroeste.revalidate();


								}	else
								{
									JOptionPane.showMessageDialog(null, "Não à nada a ser listado","Inválido",0);
								}
							}
						});
						
				//Ação do botão filmes categoria FiccaoCientifica
						btnCatFicaoCient.addActionListener(new ActionListener() {
							
							@Override
							public void actionPerformed(ActionEvent e) {
								String genero = "Fic\u00E7\u00E3o Cientifica";
								FRarquivos retorno = new FRarquivos();
								Boolean ler = false;
									ler = retorno.VerificaGeneroExistente(usrName,genero);			
								if (ler){
									panelCategoriasFilmes.setVisible(false);
									home.getContentPane().remove(panelCategoriasFilmes);
									home.getContentPane().add(panelCategoriasFilmes, BorderLayout.CENTER);
									filmesCatFiccaoCient.setVisible(true);
									filmesCatFiccaoCient.revalidate();

								}	else
								{
									JOptionPane.showMessageDialog(null, "Não à nada a ser listado","Inválido",0);
								}
								
							}
						});
						
				//Ação do botão filmes categoria Guerra
						btnCatGuerra.addActionListener(new ActionListener() {
							
							@Override
							public void actionPerformed(ActionEvent e) {
								String genero = "guerra";
								FRarquivos retorno = new FRarquivos();
								Boolean ler = false;
									ler = retorno.VerificaGeneroExistente(usrName,genero);			
								if (ler){
									panelCategoriasFilmes.setVisible(false);
									home.getContentPane().remove(panelCategoriasFilmes);
									home.getContentPane().add(panelCategoriasFilmes, BorderLayout.CENTER);
									filmesCatGuerra.setVisible(true);
									filmesCatGuerra.revalidate();

								}	else
								{
									JOptionPane.showMessageDialog(null, "Não à nada a ser listado","Inválido",0);
								}
							
							}
						});
						
				//Ação do botão filmes categoria Musical
						btnCatMusical.addActionListener(new ActionListener() {
							
							@Override
							public void actionPerformed(ActionEvent e) {
								String genero = "musical";
								FRarquivos retorno = new FRarquivos();
								Boolean ler = false;
									ler = retorno.VerificaGeneroExistente(usrName,genero);			
								if (ler){
									panelCategoriasFilmes.setVisible(false);
									home.getContentPane().remove(panelCategoriasFilmes);
									home.getContentPane().add(panelCategoriasFilmes, BorderLayout.CENTER);
									filmesCatMusical.setVisible(true);
									filmesCatMusical.revalidate();
								}	else
								{
									JOptionPane.showMessageDialog(null, "Não à nada a ser listado","Inválido",0);
								}
								
							}
						});
						
				//Ação do botão filmes categoria Policial
						btnCatPolicial.addActionListener(new ActionListener() {
							
							@Override
							public void actionPerformed(ActionEvent e) {
								String genero = "policial";
								FRarquivos retorno = new FRarquivos();
								Boolean ler = false;
									ler = retorno.VerificaGeneroExistente(usrName,genero);			
								if (ler){
									panelCategoriasFilmes.setVisible(false);
									home.getContentPane().remove(panelCategoriasFilmes);
									home.getContentPane().add(panelCategoriasFilmes, BorderLayout.CENTER);
									filmesCatPolicial.setVisible(true);
									filmesCatPolicial.revalidate();

								}	else
								{
									JOptionPane.showMessageDialog(null, "Não à nada a ser listado","Inválido",0);
								}
								
							}
						});
						
				//Ação do botão filmes categoria Romance
						btnCatRomance.addActionListener(new ActionListener() {
							
							@Override
							public void actionPerformed(ActionEvent e) {
								String genero = "romance";
								FRarquivos retorno = new FRarquivos();
								Boolean ler = false;
									ler = retorno.VerificaGeneroExistente(usrName,genero);			
								if (ler){
									panelCategoriasFilmes.setVisible(false);
									home.getContentPane().remove(panelCategoriasFilmes);
									home.getContentPane().add(panelCategoriasFilmes, BorderLayout.CENTER);
									filmesCatRomance.setVisible(true);
									filmesCatRomance.revalidate();

								}	else
								{
									JOptionPane.showMessageDialog(null, "Não à nada a ser listado","Inválido",0);
								}
							
							}
						});
						
				//Ação do botão filmes categoria Suspense
						btnCatSuspense.addActionListener(new ActionListener() {
							
							@Override
							public void actionPerformed(ActionEvent e) {
								String genero = "suspense";
								FRarquivos retorno = new FRarquivos();
								Boolean ler = false;
									ler = retorno.VerificaGeneroExistente(usrName,genero);			
								if (ler){
									panelCategoriasFilmes.setVisible(false);
									home.getContentPane().remove(panelCategoriasFilmes);
									home.getContentPane().add(panelCategoriasFilmes, BorderLayout.CENTER);
									filmesCatSuspense.setVisible(true);
									filmesCatSuspense.revalidate();

								}	else
								{
									JOptionPane.showMessageDialog(null, "Não à nada a ser listado","Inválido",0);
								}
								
							}
						});
						
				//Ação do botão filmes categoria Terror
						btnCatTerror.addActionListener(new ActionListener() {
							
							@Override
							public void actionPerformed(ActionEvent e) {
								String genero = "terror";
								FRarquivos retorno = new FRarquivos();
								Boolean ler = false;
									ler = retorno.VerificaGeneroExistente(usrName,genero);			
								if (ler){
									panelCategoriasFilmes.setVisible(false);
									home.getContentPane().remove(panelCategoriasFilmes);
									home.getContentPane().add(panelCategoriasFilmes, BorderLayout.CENTER);
									filmesCatTerror.setVisible(true);
									filmesCatTerror.revalidate();
								}	else{
									JOptionPane.showMessageDialog(null, "Não à nada a ser listado","Inválido",0);
								}
								
							}
						});
						
				//Ação do botão filmes categoria Thriller
						btnCatThriller.addActionListener(new ActionListener() {
							
							@Override
							public void actionPerformed(ActionEvent e) {
								String genero = "thriller";
								FRarquivos retorno = new FRarquivos();
								Boolean ler = false;
									ler = retorno.VerificaGeneroExistente(usrName,genero);			
								if (ler){
									panelCategoriasFilmes.setVisible(false);
									home.getContentPane().remove(panelCategoriasFilmes);
									home.getContentPane().add(panelCategoriasFilmes, BorderLayout.CENTER);
									filmesCatThriller.setVisible(true);
									filmesCatThriller.revalidate();
								}	else
								{
									JOptionPane.showMessageDialog(null, "Não à nada a ser listado","Inválido",0);
								}
							}
						});
						
						/**
						 * TODO
						 * Acao de botoes da categoria series
						 */
						
						
						//Ação do botão filmes categoria Ação
								btnCatAcaoSerie.addActionListener(new ActionListener() {
									
									@Override
									public void actionPerformed(ActionEvent e) {
										String genero = "acão";
										FRarquivos retorno = new FRarquivos();
										Boolean ler = false;
											ler = retorno.VerificaGeneroExistenteSerie(usrName,genero);			
										if (ler){
											panelCategoriasSerie.setVisible(false);
											home.getContentPane().remove(panelCategoriasSerie);
											home.getContentPane().add(serieCatAcao, BorderLayout.CENTER);
											serieCatAcao.setVisible(true);
											serieCatAcao.revalidate();
										}	else
										{
											JOptionPane.showMessageDialog(null, "Não à nada a ser listado","Inválido",0);
										}
									
									}
								});
								
								//Ação do botão filmes categoria Animação
										btnCatAnimacaoSerie.addActionListener(new ActionListener() {
											
											@Override
											public void actionPerformed(ActionEvent e) {
												String genero = "Animação";
												FRarquivos retorno = new FRarquivos();
												Boolean ler = false;
													ler = retorno.VerificaGeneroExistenteSerie(usrName,genero);			
												if (ler){
													panelCategoriasSerie.setVisible(false);
													home.getContentPane().remove(panelCategoriasSerie);
													home.getContentPane().add(panelCategoriasSerie, BorderLayout.CENTER);
													serieCatAnimacao.setVisible(true);
													serieCatAnimacao.revalidate();
												}	else
												{
													JOptionPane.showMessageDialog(null, "Não à nada a ser listado","Invalido",0);
												}
												
											}
										});
										
								//Ação do botão filmes categoria Aventura
										btnCatAventuraSerie.addActionListener(new ActionListener() {
											
											@Override
											public void actionPerformed(ActionEvent e) {
												
												String genero = "aventura";
												FRarquivos retorno = new FRarquivos();
												Boolean ler = false;
													ler = retorno.VerificaGeneroExistenteSerie(usrName,genero);			
												if (ler){
													panelCategoriasSerie.setVisible(false);
													home.getContentPane().remove(panelCategoriasSerie);
													home.getContentPane().add(panelCategoriasSerie, BorderLayout.CENTER);
													serieCatAventura.setVisible(true);
													serieCatAventura.revalidate();
												}	else
												{
													JOptionPane.showMessageDialog(null, "Não à nada a ser listado","Inválido",0);
												}
											
											}
										});
										
								//Ação do botão filmes categoria Classico
										btnCatClassicoSerie.addActionListener(new ActionListener() {
											
											@Override
											public void actionPerformed(ActionEvent e) {
												String genero = "Cl\u00E1ssico";
												FRarquivos retorno = new FRarquivos();
												Boolean ler = false;
													ler = retorno.VerificaGeneroExistenteSerie(usrName,genero);			
												if (ler){
													panelCategoriasSerie.setVisible(false);
													home.getContentPane().remove(panelCategoriasSerie);
													home.getContentPane().add(panelCategoriasSerie, BorderLayout.CENTER);
													serieCatClassico.setVisible(true);
													serieCatClassico.revalidate();


												}	else
												{
													JOptionPane.showMessageDialog(null, "Não à nada a ser listado","Inválido",0);
												}
											}
										});
										
								//Ação do botão filmes categoria Comedia
										btnCatComediaSerie.addActionListener(new ActionListener() {
											
											@Override
											public void actionPerformed(ActionEvent e) {
												String genero = "Com\u00E9dia";
												FRarquivos retorno = new FRarquivos();
												Boolean ler = false;
													ler = retorno.VerificaGeneroExistenteSerie(usrName,genero);			
												if (ler){
													panelCategoriasSerie.setVisible(false);
													home.getContentPane().remove(panelCategoriasSerie);
													home.getContentPane().add(panelCategoriasSerie, BorderLayout.CENTER);
													serieCatComedia.setVisible(true);
													serieCatComedia.revalidate();


												}	else
												{
													JOptionPane.showMessageDialog(null, "Não à nada a ser listado","Inválido",0);
												}
											}
										});
										
								//Ação do botão filmes categoria ComediaRomantica
										btnCatComediaRomanticaSerie.addActionListener(new ActionListener() {
											
											@Override
											public void actionPerformed(ActionEvent e) {
												String genero = "Com\u00E9dia Rom\u00E2ntica";
												FRarquivos retorno = new FRarquivos();
												Boolean ler = false;
													ler = retorno.VerificaGeneroExistenteSerie(usrName,genero);			
												if (ler){
													panelCategoriasSerie.setVisible(false);
													home.getContentPane().remove(panelCategoriasSerie);
													home.getContentPane().add(panelCategoriasSerie, BorderLayout.CENTER);
													serieCatComediaRomantico.setVisible(true);
													serieCatComediaRomantico.revalidate();


												}	else
												{
													JOptionPane.showMessageDialog(null, "Não à nada a ser listado","Inválido",0);
												}
											}
										});
										
								//Ação do botão filmes categoria Crime
										btnCatCrimeSerie.addActionListener(new ActionListener() {
											
											@Override
											public void actionPerformed(ActionEvent e) {
												String genero = "Crime";
												FRarquivos retorno = new FRarquivos();
												Boolean ler = false;
													ler = retorno.VerificaGeneroExistenteSerie(usrName,genero);			
												if (ler){

													panelCategoriasSerie.setVisible(false);
													home.getContentPane().remove(panelCategoriasSerie);
													home.getContentPane().add(panelCategoriasSerie, BorderLayout.CENTER);
													serieCatCrime.setVisible(true);
													serieCatCrime.revalidate();

												}	else
												{
													JOptionPane.showMessageDialog(null, "Não à nada a ser listado","Inválido",0);
												}
											}
										});
										
								//Ação do botão filmes categoria Documentario
										btnCatDocumentarioSerie.addActionListener(new ActionListener() {
											
											@Override
											public void actionPerformed(ActionEvent e) {
												String genero = "Document\u00E1rio";
												FRarquivos retorno = new FRarquivos();
												Boolean ler = false;
													ler = retorno.VerificaGeneroExistenteSerie(usrName,genero);			
												if (ler){

													panelCategoriasSerie.setVisible(false);
													home.getContentPane().remove(panelCategoriasSerie);
													home.getContentPane().add(panelCategoriasSerie, BorderLayout.CENTER);
													serieCatDocumentario.setVisible(true);
													serieCatDocumentario.revalidate();

												}	else
												{
													JOptionPane.showMessageDialog(null, "Não à nada a ser listado","Inválido",0);
												}
											}
										});	
										
								//Ação do botão filmes categoria Drama
										btnCatDramaSerie.addActionListener(new ActionListener() {
											
											@Override
											public void actionPerformed(ActionEvent e) {
												String genero = "Drama";
												FRarquivos retorno = new FRarquivos();
												Boolean ler = false;
													ler = retorno.VerificaGeneroExistenteSerie(usrName,genero);			
												if (ler){
													panelCategoriasSerie.setVisible(false);
													home.getContentPane().remove(panelCategoriasSerie);
													home.getContentPane().add(panelCategoriasSerie, BorderLayout.CENTER);
													serieCatDrama.setVisible(true);
													serieCatDrama.revalidate();


												}	else
												{
													JOptionPane.showMessageDialog(null, "Não à nada a ser listado","Inválido",0);
												}
											}
										});
										
								//Ação do botão filmes categoria Faroeste
										btnCatFaroesteSerie.addActionListener(new ActionListener() {
											
											@Override
											public void actionPerformed(ActionEvent e) {
												String genero = "Faroeste";
												FRarquivos retorno = new FRarquivos();
												Boolean ler = false;
													ler = retorno.VerificaGeneroExistenteSerie(usrName,genero);			
												if (ler){
													panelCategoriasSerie.setVisible(false);
													home.getContentPane().remove(panelCategoriasSerie);
													home.getContentPane().add(panelCategoriasSerie, BorderLayout.CENTER);
													serieCatFaroeste.setVisible(true);
													serieCatFaroeste.revalidate();


												}	else
												{
													JOptionPane.showMessageDialog(null, "Não à nada a ser listado","Inválido",0);
												}
											}
										});
										
								//Ação do botão filmes categoria FiccaoCientifica
										btnCatFicaoCientSerie.addActionListener(new ActionListener() {
											
											@Override
											public void actionPerformed(ActionEvent e) {
												String genero = "Fic\u00E7\u00E3o Cientifica";
												FRarquivos retorno = new FRarquivos();
												Boolean ler = false;
													ler = retorno.VerificaGeneroExistenteSerie(usrName,genero);			
												if (ler){
													panelCategoriasSerie.setVisible(false);
													home.getContentPane().remove(panelCategoriasSerie);
													home.getContentPane().add(panelCategoriasSerie, BorderLayout.CENTER);
													serieCatFiccaoCient.setVisible(true);
													serieCatFiccaoCient.revalidate();

												}	else
												{
													JOptionPane.showMessageDialog(null, "Não à nada a ser listado","Inválido",0);
												}
												
											}
										});
										
								//Ação do botão filmes categoria Guerra
										btnCatGuerraSerie.addActionListener(new ActionListener() {
											
											@Override
											public void actionPerformed(ActionEvent e) {
												String genero = "guerra";
												FRarquivos retorno = new FRarquivos();
												Boolean ler = false;
													ler = retorno.VerificaGeneroExistenteSerie(usrName,genero);			
												if (ler){
													panelCategoriasSerie.setVisible(false);
													home.getContentPane().remove(panelCategoriasSerie);
													home.getContentPane().add(panelCategoriasSerie, BorderLayout.CENTER);
													serieCatGuerra.setVisible(true);
													serieCatGuerra.revalidate();

												}	else
												{
													JOptionPane.showMessageDialog(null, "Não à nada a ser listado","Inválido",0);
												}
											
											}
										});
										
								//Ação do botão filmes categoria Musical
										btnCatMusicalSerie.addActionListener(new ActionListener() {
											
											@Override
											public void actionPerformed(ActionEvent e) {
												String genero = "musical";
												FRarquivos retorno = new FRarquivos();
												Boolean ler = false;
													ler = retorno.VerificaGeneroExistenteSerie(usrName,genero);			
												if (ler){
													panelCategoriasSerie.setVisible(false);
													home.getContentPane().remove(panelCategoriasSerie);
													home.getContentPane().add(panelCategoriasSerie, BorderLayout.CENTER);
													serieCatMusical.setVisible(true);
													serieCatMusical.revalidate();
												}	else
												{
													JOptionPane.showMessageDialog(null, "Não à nada a ser listado","Inválido",0);
												}
												
											}
										});
										
								//Ação do botão filmes categoria Policial
										btnCatPolicialSerie.addActionListener(new ActionListener() {
											
											@Override
											public void actionPerformed(ActionEvent e) {
												String genero = "policial";
												FRarquivos retorno = new FRarquivos();
												Boolean ler = false;
													ler = retorno.VerificaGeneroExistenteSerie(usrName,genero);			
												if (ler){
													panelCategoriasSerie.setVisible(false);
													home.getContentPane().remove(panelCategoriasSerie);
													home.getContentPane().add(panelCategoriasSerie, BorderLayout.CENTER);
													serieCatPolicial.setVisible(true);
													serieCatPolicial.revalidate();

												}	else
												{
													JOptionPane.showMessageDialog(null, "Não à nada a ser listado","Inválido",0);
												}
												
											}
										});
										
								//Ação do botão filmes categoria Romance
										btnCatRomanceSerie.addActionListener(new ActionListener() {
											
											@Override
											public void actionPerformed(ActionEvent e) {
												String genero = "romance";
												FRarquivos retorno = new FRarquivos();
												Boolean ler = false;
													ler = retorno.VerificaGeneroExistenteSerie(usrName,genero);			
												if (ler){
													panelCategoriasSerie.setVisible(false);
													home.getContentPane().remove(panelCategoriasSerie);
													home.getContentPane().add(panelCategoriasSerie, BorderLayout.CENTER);
													serieCatRomance.setVisible(true);
													serieCatRomance.revalidate();

												}	else
												{
													JOptionPane.showMessageDialog(null, "Não à nada a ser listado","Inválido",0);
												}
											
											}
										});
										
								//Ação do botão filmes categoria Suspense
										btnCatSuspenseSerie.addActionListener(new ActionListener() {
											
											@Override
											public void actionPerformed(ActionEvent e) {
												String genero = "suspense";
												FRarquivos retorno = new FRarquivos();
												Boolean ler = false;
													ler = retorno.VerificaGeneroExistenteSerie(usrName,genero);			
												if (ler){
													panelCategoriasSerie.setVisible(false);
													home.getContentPane().remove(panelCategoriasSerie);
													home.getContentPane().add(panelCategoriasSerie, BorderLayout.CENTER);
													serieCatSuspense.setVisible(true);
													serieCatSuspense.revalidate();

												}	else
												{
													JOptionPane.showMessageDialog(null, "Não à nada a ser listado","Inválido",0);
												}
												
											}
										});
										
								//Ação do botão filmes categoria Terror
										btnCatTerrorSerie.addActionListener(new ActionListener() {
											
											@Override
											public void actionPerformed(ActionEvent e) {
												String genero = "terror";
												FRarquivos retorno = new FRarquivos();
												Boolean ler = false;
													ler = retorno.VerificaGeneroExistenteSerie(usrName,genero);			
												if (ler){
													panelCategoriasSerie.setVisible(false);
													home.getContentPane().remove(panelCategoriasSerie);
													home.getContentPane().add(panelCategoriasSerie, BorderLayout.CENTER);
													serieCatTerror.setVisible(true);
													serieCatTerror.revalidate();
												}	else{
													JOptionPane.showMessageDialog(null, "Não à nada a ser listado","Inválido",0);
												}
												
											}
										});
										
								//Ação do botão filmes categoria Thriller
										btnCatMedicoSerie.addActionListener(new ActionListener() {
											
											@Override
											public void actionPerformed(ActionEvent e) {
												String genero = "thriller";
												FRarquivos retorno = new FRarquivos();
												Boolean ler = false;
													ler = retorno.VerificaGeneroExistenteSerie(usrName,genero);			
												if (ler){
													panelCategoriasSerie.setVisible(false);
													home.getContentPane().remove(panelCategoriasSerie);
													home.getContentPane().add(panelCategoriasSerie, BorderLayout.CENTER);
													serieCatMedico.setVisible(true);
													serieCatMedico.revalidate();
												}	else
												{
												}
											}
										});
										
										
													
						
			
	}

	
}