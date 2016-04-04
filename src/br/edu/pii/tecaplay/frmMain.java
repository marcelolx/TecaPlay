package br.edu.pii.tecaplay;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.Font;
import javax.swing.JTextPane;

import br.edu.pii.tecaplaygui.LoginGUI;

public class frmMain extends JFrame {

	/**
	 * @version 1.0
	 * @author Jonas, Marcelo, Matheus
	 */

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				LoginGUI lg = new LoginGUI();
				try {
					frmMain frame = new frmMain();
					frame.setSize(new Dimension(980, 560));
					frame.setLocationRelativeTo(null);
					frame.setVisible(false);
					frame.getContentPane().setBackground(new Color(169,169,169));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public frmMain() {
		setFont(new Font("Book Antiqua", Font.PLAIN, 14));
		setTitle("TecaPlay");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 651, 397);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnArquivo = new JMenu("Arquivo");
		menuBar.add(mnArquivo);
		
		JMenuItem mntmInicio = new JMenuItem("Inicio");
		mnArquivo.add(mntmInicio);
		
		JMenuItem mntmSair = new JMenuItem("Sair");
		mnArquivo.add(mntmSair);
		
		JMenu mnSobre = new JMenu("Sobre");
		menuBar.add(mnSobre);
		
		JPanel pnlMenu = new JPanel();
		pnlMenu.setBackground(Color.GRAY);
		getContentPane().add(pnlMenu, BorderLayout.WEST);
		pnlMenu.setLayout(new GridLayout(12, 10, 5, 1));
		
		JButton btn1Filme = new JButton("Filmes");
		btn1Filme.setFont(new Font("Source Sans Pro Light", Font.PLAIN, 14));
		pnlMenu.add(btn1Filme);
		btn1Filme.setBackground(new Color(105,105,105));
		btn1Filme.setForeground(new Color(220,220,220));
		
		JButton btn1Serie = new JButton("Séries");
		btn1Serie.setFont(new Font("Source Sans Pro Light", Font.PLAIN, 14));
		pnlMenu.add(btn1Serie);
		btn1Serie.setBackground(new Color(105,105,105));
		btn1Serie.setForeground(new Color(220,220,220));
		
		JButton btn1Musica = new JButton("Musica");
		btn1Musica.setFont(new Font("Source Sans Pro Light", Font.PLAIN, 14));
		pnlMenu.add(btn1Musica);
		btn1Musica.setBackground(new Color(105,105,105));
		btn1Musica.setForeground(new Color(220,220,220));
		
		JButton btn1Anime = new JButton("Animes");
		btn1Anime.setFont(new Font("Source Sans Pro Light", Font.PLAIN, 14));
		pnlMenu.add(btn1Anime);
		btn1Anime.setBackground(new Color(105,105,105));
		btn1Anime.setForeground(new Color(220,220,220));
		
		JButton btn1Adc = new JButton("+ Adicionar");
		btn1Adc.setFont(new Font("Source Sans Pro Light", Font.PLAIN, 14));
		pnlMenu.add(btn1Adc);
		btn1Adc.setBackground(new Color(105,105,105));
		btn1Adc.setForeground(new Color(220,220,220));
		
		JButton btn1Del = new JButton("- Deletar");
		btn1Del.setFont(new Font("Source Sans Pro Light", Font.PLAIN, 14));
		pnlMenu.add(btn1Del);
		btn1Del.setBackground(new Color(105,105,105));
		btn1Del.setForeground(new Color(220,220,220));
		
		JButton btn1Favorito = new JButton("Favoritos");
		btn1Favorito.setFont(new Font("Source Sans Pro Light", Font.PLAIN, 14));
		pnlMenu.add(btn1Favorito);
		btn1Favorito.setBackground(new Color(105,105,105));
		btn1Favorito.setForeground(new Color(220,220,220));
		
		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		
		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3, BorderLayout.NORTH);
		
		JTextPane txtpnSelecioneOTipo = new JTextPane();
		panel_3.add(txtpnSelecioneOTipo);
		txtpnSelecioneOTipo.setText("Selecione o Tipo de arquivo \u00E0 ser mostrado");
		
		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2);
		
		JButton btnFilmes = new JButton("Filmes");
		btnFilmes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn1Musica.setVisible(false);
				btn1Anime.setVisible(false);
				btn1Filme.setVisible(true);
				panel_1.setVisible(false);
				btn1Serie.setVisible(false);
				
			}
		});
		panel_2.add(btnFilmes);
		btnFilmes.setBackground(new Color(105,105,105));
		btnFilmes.setForeground(new Color(220,220,220));
		
		JButton btnMusicas = new JButton("Músicas");
		btnMusicas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn1Musica.setVisible(true);
				btn1Anime.setVisible(false);
				panel_1.setVisible(false);
				btn1Filme.setVisible(false);
				btn1Serie.setVisible(false);
			}
		});
		panel_2.add(btnMusicas);
		btnMusicas.setBackground(new Color(105,105,105));
		btnMusicas.setForeground(new Color(220,220,220));
		
		JButton btnSeries = new JButton("Séries");
		panel_2.add(btnSeries);
		btnSeries.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn1Musica.setVisible(false);
				btn1Anime.setVisible(false);
				btn1Filme.setVisible(false);
				panel_1.setVisible(false);
				btn1Serie.setVisible(true);
			}
		});
		btnSeries.setBackground(new Color(105,105,105));
		btnSeries.setForeground(new Color(220,220,220));
		
		JButton btnAnimes = new JButton("Animes");
		panel_2.add(btnAnimes);
		btnAnimes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn1Musica.setVisible(false);
				btn1Anime.setVisible(true);
				btn1Filme.setVisible(false);
				btn1Serie.setVisible(false);
				panel_1.setVisible(false);
			}
		});
		btnAnimes.setBackground(new Color(105,105,105));
		btnAnimes.setForeground(new Color(220,220,220));
		
		mntmSair.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});
		
		mntmInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_1.setVisible(true);
				btn1Musica.setVisible(true);
				btn1Anime.setVisible(true);
				btn1Filme.setVisible(true);
				btn1Serie.setVisible(true);
			}
		});
		

	}
}

