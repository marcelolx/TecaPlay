package br.edu.pii.tecaplay.ui;

import java.awt.Color;
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
public class homePage {

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
		home.getContentPane().add(panelTopo, BorderLayout.NORTH);
		
		//criação de botoes video/musica/imagem
		JButton btnVdeo = new JButton("V\u00EDdeo");
		btnVdeo.setIcon(new ImageIcon("resources\\images\\imgBtnVideo.png"));//icone do botao
		btnVdeo.setFont(new Font("Tahoma", Font.BOLD, 14)); //tipo de fonte do botao
		btnVdeo.setBackground(Color.GRAY);
		panelTopo.add(btnVdeo);
		home.isCursorSet();
		
		JButton btnMusica = new JButton("Música");
		btnMusica.setIcon(new ImageIcon("resources\\images\\imgBtnMusica.png"));//icone do botao
		btnMusica.setFont(new Font("Tahoma", Font.BOLD, 14)); //tipo de fonte do botao
		btnMusica.setBackground(Color.GRAY);
		panelTopo.add(btnMusica);
		home.isCursorSet();
		
		JButton btnImagem = new JButton("Imagem");
		btnImagem.setIcon(new ImageIcon("resources\\images\\imgBtnImagem.png")); //icone do botao
		btnImagem.setFont(new Font("Tahoma", Font.BOLD, 14)); //tipo de fonte do botao
		btnImagem.setBackground(Color.GRAY);
		panelTopo.add(btnImagem);
		home.isCursorSet();
	}
}