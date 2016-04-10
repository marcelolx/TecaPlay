package br.edu.pii.tecaplay.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.ImageIcon;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;


public class homePage {
   /**
    * 
    */
	public homePage() {
		//formatação do JFrame
		JFrame home = new JFrame();
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
		menuArquivo.setBackground(Color.DARK_GRAY);
		menuArquivo.setIcon(new ImageIcon("resources\\images\\imgMenuArquivo.png"));//adição de icone na frente do botão
		menuBar.add(menuArquivo); // adicionado ao container do menu do topo

		//submenu do menu arquivo com a função de sair do programa
		JMenuItem subMenuSair = new JMenuItem("Sair");
		//evento de fechar o programa
		subMenuSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		subMenuSair.setIcon(new ImageIcon("resources\\images\\imgMenuSair.png"));
		subMenuSair.setSelected(true);
		menuArquivo.add(subMenuSair);
		 
		//menu sobre adicionado do lado do menu arquivo
		JMenu menuSobre = new JMenu("Sobre");
		menuSobre.setIcon(new ImageIcon("resources\\images\\imgMenuSobre.png")); // adiçção do icone sobre
		menuBar.add(menuSobre);
		
		//criado painel aonde ficarão os botoes para a escolha de musica, video ou imagem
		JPanel panelTopo = new JPanel();
		panelTopo.setBackground(new Color(127, 127, 127));
		home.getContentPane().add(panelTopo, BorderLayout.NORTH);
		
		/**
		*			criação de botoes video/musica/imagem
		*/
		
		JButton btnVdeo = new JButton("V\u00EDdeo");
		btnVdeo.setIcon(new ImageIcon("resources\\images\\imgBtnVideo.png"));//icone do botao
		btnVdeo.setFont(new Font("Tahoma", Font.BOLD, 14)); //tipo de fonte do botao
		btnVdeo.setBackground(Color.LIGHT_GRAY);
		btnVdeo.setPreferredSize(new Dimension(173,42));
		panelTopo.add(btnVdeo);
		home.isCursorSet();
		
		JButton btnMusica = new JButton("Música");
		btnMusica.setIcon(new ImageIcon("resources\\images\\imgBtnMusica.png"));//icone do botao
		btnMusica.setFont(new Font("Tahoma", Font.BOLD, 14)); //tipo de fonte do botao
		btnMusica.setPreferredSize(new Dimension(173,42));
		btnMusica.setBackground(Color.LIGHT_GRAY);
		panelTopo.add(btnMusica);
		home.isCursorSet();
		
		JButton btnImagem = new JButton("Imagem");
		btnImagem.setIcon(new ImageIcon("resources\\images\\imgBtnImagem.png")); //icone do botao
		btnImagem.setFont(new Font("Tahoma", Font.BOLD, 14)); //tipo de fonte do botao
		btnImagem.setPreferredSize(new Dimension(173,42));
		btnImagem.setBackground(Color.LIGHT_GRAY);
		panelTopo.add(btnImagem);
		/**
		 * Adição de Painel Lateral para abrigar os botoes de
		 * gerenciar o que será apresentado
		 */
		
		JPanel panelLateral = new JPanel();
		panelLateral.setLayout(new FlowLayout(FlowLayout.LEFT, 4, 4));
		panelLateral.setPreferredSize(new Dimension(180,400));
		panelLateral.setBackground(new Color(128,128,128));
		home.getContentPane().add(panelLateral, BorderLayout.WEST);
		
		//jButton Adicionar
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setVerticalAlignment(SwingConstants.BOTTOM);
		btnAdicionar.setIcon(new ImageIcon("resources\\images\\imgBtnAdd.png"));
		btnAdicionar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAdicionar.setPreferredSize(new Dimension(173,34));
		panelLateral.add(btnAdicionar);
		btnAdicionar.setBackground(Color.LIGHT_GRAY);
		home.isCursorSet();
		
		//jButton Remover
		JButton btnRemover = new JButton("Remover");
		btnRemover.setVerticalAlignment(SwingConstants.BOTTOM);
		btnRemover.setIcon(new ImageIcon("resources\\images\\imgBtnRemover.png"));
		btnRemover.setPreferredSize(new Dimension(172,34));
		btnRemover.setFont(new Font("Tahoma", Font.BOLD, 14));
		panelLateral.add(btnRemover);
		btnRemover.setBackground(Color.LIGHT_GRAY);
	
		
		//jButton Favoritos
		JButton btnFavoritos = new JButton("Favoritos");
		btnFavoritos.setVerticalAlignment(SwingConstants.BOTTOM);
		btnFavoritos.setIcon(new ImageIcon("resources\\images\\imgBtnFavorito.png"));
		btnFavoritos.setPreferredSize(new Dimension(172,34));
		btnFavoritos.setFont(new Font("Tahoma", Font.BOLD, 14));
		panelLateral.add(btnFavoritos);
		btnFavoritos.setBackground(Color.LIGHT_GRAY);
		
		
		//jButton Sorteio de algum filme
		JButton btnSorteio = new JButton("Sorteio de Filme");
		btnSorteio.setVerticalAlignment(SwingConstants.TOP);
		btnSorteio.setPreferredSize(new Dimension(172,34));
		btnSorteio.setIcon(new ImageIcon("resources\\images\\imgBtnRandom.png"));
		btnSorteio.setFont(new Font("Tahoma", Font.BOLD, 14));
		panelLateral.add(btnSorteio);
		btnSorteio.setBackground(Color.LIGHT_GRAY);
		
	}
}