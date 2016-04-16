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


public class HomePage {
   /**
    * 
    */
	public HomePage() {
		//formatação do JFrame
		JFrame home = new JFrame();
		home.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent args){
				home.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
				FileUtil.sair(); 
			}
		});

		home.setVisible(true);//Deixar visivel
		home.setBackground(new Color(25, 25, 25));// cor de Background
		home.setTitle("Home - TecaPlay"); // titulo na barra do windows
		home.setSize(980, 560); // tamanho da janela
		home.setResizable(false); // impossibilidade de altarar tamanho da janela
		home.setLocationRelativeTo(null); // iniciar aplicação centralizada na tela
		home.setIconImage(Toolkit.getDefaultToolkit().getImage("resources\\images\\newLogo.png")); //icone da barra
		
		//criação do menu superior
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(Color.LIGHT_GRAY);//background do menu
		home.setJMenuBar(menuBar);

		//adição de botao de menu
		JMenu menuArquivo = new JMenu("Arquivo");
		menuArquivo.setMnemonic('A');
		menuArquivo.setBackground(Color.DARK_GRAY);
		menuArquivo.setIcon(new ImageIcon("resources\\images\\imgMenuArquivo.png"));//adição de icone na frente do botão
		menuBar.add(menuArquivo); // adicionado ao container do menu do topo

		//submenu do menu arquivo com a função de sair do programa
		JMenuItem subMenuSair = new JMenuItem("Sair");
		//evento de fechar o programa
		subMenuSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FileUtil.sair();
			}
		});
		subMenuSair.setIcon(new ImageIcon("resources\\images\\imgMenuSair.png"));
		subMenuSair.setSelected(true);
		menuArquivo.add(subMenuSair);
		 
		//menu sobre adicionado do lado do menu arquivo
		JMenu menuAjuda = new JMenu("Ajuda");
		menuAjuda.setMnemonic('J');
		menuAjuda.setHorizontalAlignment(SwingConstants.LEFT);
		menuAjuda.setIcon(new ImageIcon("resources\\images\\imgMenuSobre.png")); // adiçção do icone sobre
		menuBar.add(menuAjuda);
		
		JMenuItem mntmSobre = new JMenuItem("Sobre");
		mntmSobre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				@SuppressWarnings("unused")
				Sobre info = new Sobre();
			}
		});
		mntmSobre.setIcon(new ImageIcon("C:\\Users\\jonas\\git\\tecaplayd\\resources\\images\\imgBtnSobre.png"));
		menuAjuda.add(mntmSobre);
		
		//criado painel aonde ficarão os botoes para a escolha de musica, video ou imagem
		JPanel panelTopo = new JPanel();
		panelTopo.setAutoscrolls(true);
		panelTopo.setFocusTraversalPolicyProvider(true);
		panelTopo.setFocusCycleRoot(true);
		panelTopo.setIgnoreRepaint(true);
		panelTopo.setBackground(new Color(127, 127, 127));
		home.getContentPane().add(panelTopo, BorderLayout.NORTH);
		
		/**
		*			criação de botoes video/musica/imagem
		*/
		
		JButton btnVdeo = new JButton("V\u00EDdeo");
		
		panelTopo.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		btnVdeo.setToolTipText("Op\u00E7\u00E3o de acesso a aba V\u00EDdeo!");
		btnVdeo.setIcon(new ImageIcon("resources\\images\\imgBtnVideo.png"));//icone do botao
		btnVdeo.setFont(new Font("Tahoma", Font.BOLD, 14)); //tipo de fonte do botao
		btnVdeo.setBackground(Color.LIGHT_GRAY);
		btnVdeo.setPreferredSize(new Dimension(173,42));
		panelTopo.add(btnVdeo);
		home.isCursorSet();
		
		JButton btnMusica = new JButton("Música");
		btnMusica.setToolTipText("Op\u00E7\u00E3o de acesso a aba M\u00FAsica!");
		btnMusica.setIcon(new ImageIcon("resources\\images\\imgBtnMusica.png"));//icone do botao
		btnMusica.setFont(new Font("Tahoma", Font.BOLD, 14)); //tipo de fonte do botao
		btnMusica.setPreferredSize(new Dimension(173,42));
		btnMusica.setBackground(Color.LIGHT_GRAY);
		panelTopo.add(btnMusica);
		home.isCursorSet();
		
		JButton btnImagem = new JButton("Imagem");
		btnImagem.setToolTipText("Op\u00E7\u00E3o de acesso a aba Imagem!");
		btnImagem.setIcon(new ImageIcon("resources\\images\\imgBtnImagem.png")); //icone do botao
		btnImagem.setFont(new Font("Tahoma", Font.BOLD, 14)); //tipo de fonte do botao
		btnImagem.setPreferredSize(new Dimension(173,42));
		btnImagem.setBackground(Color.LIGHT_GRAY);
		panelTopo.add(btnImagem);
		/**
		 * Adição de Painel Lateral para abrigar os botoes de
		 * gerenciar o que será apresentado
		 */
		
		JPanel panelLateralVideo = new JPanel();
		panelLateralVideo.setLayout(new FlowLayout(FlowLayout.LEFT, 4, 4));
		panelLateralVideo.setPreferredSize(new Dimension(180,400));
		panelLateralVideo.setBackground(new Color(128,128,128));
		
		JButton btnVoltar = new JButton("<--");
		btnVoltar.setToolTipText("Voltar");
		btnVoltar.setPreferredSize(new Dimension(86, 34));
		panelLateralVideo.add(btnVoltar);
		btnVoltar.setBackground(Color.LIGHT_GRAY);
		btnVoltar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				home.getContentPane().add(panelTopo, BorderLayout.NORTH);
				panelLateralVideo.setVisible(false);
				home.getContentPane().remove(panelLateralVideo);
				panelTopo.setVisible(true);
				panelTopo.revalidate();
			}
		});	
		
		//jButton Adicionar
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				@SuppressWarnings("unused")
				FilmesAdd addFilme = new FilmesAdd();
			}
		});
		btnAdicionar.setToolTipText("Op\u00E7\u00E3o de acesso a aba Adicionar!");
		btnAdicionar.setIcon(new ImageIcon("resources\\images\\imgBtnAdd.png"));
		btnAdicionar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAdicionar.setPreferredSize(new Dimension(173,34));
		panelLateralVideo.add(btnAdicionar);
		btnAdicionar.setBackground(Color.LIGHT_GRAY);
		home.isCursorSet();
		
		//jButton Remover
		JButton btnRemover = new JButton("Remover");
		btnRemover.setToolTipText("Op\u00E7\u00E3o de acesso a aba Remover!");
		btnRemover.setIcon(new ImageIcon("resources\\images\\imgBtnRemover.png"));
		btnRemover.setPreferredSize(new Dimension(172,34));
		btnRemover.setFont(new Font("Tahoma", Font.BOLD, 14));
		panelLateralVideo.add(btnRemover);
		btnRemover.setBackground(Color.LIGHT_GRAY);
		
			
			//jButton Favoritos
			JButton btnFavoritos = new JButton("Favoritos");
			btnFavoritos.setToolTipText("Op\u00E7\u00E3o de acesso a aba dos Favoritos!");
			btnFavoritos.setIcon(new ImageIcon("resources\\images\\imgBtnFavorito.png"));
			btnFavoritos.setPreferredSize(new Dimension(172,34));
			btnFavoritos.setFont(new Font("Tahoma", Font.BOLD, 14));
			panelLateralVideo.add(btnFavoritos);
			btnFavoritos.setBackground(Color.LIGHT_GRAY);
		
			//Jbuttom para listar os Filmes
		JButton btnFilmes = new JButton("Filmes");
		btnFilmes.setIcon(new ImageIcon("resources\\images\\imgBtnFilme.png"));
		btnFilmes.setToolTipText("Op\u00E7\u00E3o de acesso a aba Adicionar!");
		btnFilmes.setPreferredSize(new Dimension(173, 34));
		btnFilmes.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnFilmes.setBackground(Color.LIGHT_GRAY);
		panelLateralVideo.add(btnFilmes);
		
		//Jbuttom para listar os Animes
		JButton btnAnimes = new JButton("Animes");
		btnAnimes.setIcon(new ImageIcon("\resources\\images\\imgBtnAnimes.png"));
		btnAnimes.setToolTipText("Op\u00E7\u00E3o de acesso a aba Adicionar!");
		btnAnimes.setPreferredSize(new Dimension(173, 34));
		btnAnimes.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAnimes.setBackground(Color.LIGHT_GRAY);
		panelLateralVideo.add(btnAnimes);
		//Jbuttom para listar as Séries
		JButton btnSeries = new JButton("S\u00E9ries");
		btnSeries.setIcon(new ImageIcon("resources\\images\\imgBtnSeries.png"));
		btnSeries.setToolTipText("Op\u00E7\u00E3o de acesso a aba Adicionar!");
		btnSeries.setPreferredSize(new Dimension(173, 34));
		btnSeries.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSeries.setBackground(Color.LIGHT_GRAY);
		panelLateralVideo.add(btnSeries);
		
		
		//jButton Sorteio de algum filme
		JButton btnSorteio = new JButton("Sorteio de Filme");
		btnSorteio.setToolTipText("Op\u00E7\u00E3o de acesso a aba Sorteio!");
		btnSorteio.setPreferredSize(new Dimension(172,34));
		btnSorteio.setIcon(new ImageIcon("resources\\images\\imgBtnRandom.png"));
		btnSorteio.setFont(new Font("Tahoma", Font.BOLD, 14));
		panelLateralVideo.add(btnSorteio);
		btnSorteio.setBackground(Color.LIGHT_GRAY);
		
		//Ação que será realizada ao apertar o botao de fimes do jpanelTopo
		btnVdeo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				home.getContentPane().add(panelLateralVideo, BorderLayout.WEST);//Adiciona o panel Lateral relacionada a Filmes
				panelTopo.setVisible(false); //Torna a visibilidade do painel topo falsa
				home.getContentPane().remove(panelTopo); //Remove esse painel	
				panelLateralVideo.setVisible(true); //Ativa o painel lateral referente ao video
				panelLateralVideo.revalidate();//revalida o loyout			
				}
		});
		
	}
}