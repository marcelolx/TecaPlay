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
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import br.edu.pii.tecaplay.util.FileUtil;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.JLabel;

public class HomePage {
	/**
	* 
	*/
	public HomePage() {
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
		
		JLabel label = new JLabel("");
		label.setSize(400,400);
		label.setIcon(new ImageIcon("resources\\images\\bannerPrincipal.jpg"));
		home.getContentPane().add(label, BorderLayout.CENTER);

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
		btnVoltarVideo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				home.getContentPane().add(panelTopo, BorderLayout.NORTH);
				panelLateralVideo.setVisible(false);
				home.getContentPane().remove(panelLateralVideo);
				panelTopo.setVisible(true);
				panelTopo.revalidate();
			}
		});

		// jButton Adicionar
		JButton btnAdicionarVideo = new JButton("Adicionar");
		btnAdicionarVideo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				@SuppressWarnings("unused")
				FilmesAdd addFilme = new FilmesAdd();
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
		btnAnimes.setIcon(new ImageIcon("\resources\\images\\imgBtnAnimes.png"));
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

		// Ação que será realizada ao apertar o botao de fimes do jpanelTopo
		btnVdeo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				home.getContentPane().add(panelLateralVideo, BorderLayout.WEST);
				panelTopo.setVisible(false); // Torna a visibilidade do painel topo falsa
				home.getContentPane().remove(panelTopo); // Remove esse painel
				panelLateralVideo.setVisible(true); // Ativa o painel lateral referente ao video
				panelLateralVideo.revalidate();// revalida o loyout
			}
		});

	}

}