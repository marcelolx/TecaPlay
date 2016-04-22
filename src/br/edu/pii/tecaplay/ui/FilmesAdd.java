package br.edu.pii.tecaplay.ui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import br.edu.pii.tecaplay.util.FileUtil;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dialog.ModalExclusionType;

public class FilmesAdd {
	public void Topo(){};
	public FilmesAdd(){ 
	
		JFrame JFrameSelecao = new JFrame();
		JFrameSelecao.setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		JFrameSelecao.setAlwaysOnTop(true);
		JFrameSelecao.setResizable(false);
		JFrameSelecao.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		JFrameSelecao.setTitle("Add Vídeo - TecaPlay");
		JFrameSelecao.setIconImage(Toolkit.getDefaultToolkit().getImage("resources\\images\\newLogo.png"));
		JFrameSelecao.getContentPane().setBackground(new Color(169,169,169));
		JFrameSelecao.getContentPane().setForeground(Color.WHITE);
		JFrameSelecao.getContentPane().setLayout(null);
		JFrameSelecao.setVisible(true);
		JFrameSelecao.setSize(450, 300);
		JFrameSelecao.setLocationRelativeTo(null);
		
		
		Button btnSeries = new Button("Séries");
		btnSeries.setSize(200,150);
		btnSeries.setBackground(Color.LIGHT_GRAY);
		btnSeries.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnSeries.setForeground(new Color(0,0,0));
		btnSeries.setBounds(10, 47, 207, 43);
		JFrameSelecao.getContentPane().add(btnSeries);
		
		
		Button btnAnimes = new Button("Animes");
		btnAnimes.setSize(200,150);
		btnAnimes.setBackground(Color.LIGHT_GRAY);
		btnAnimes.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnAnimes.setForeground(new Color(0,0,0));
		btnAnimes.setBounds(227, 47, 207, 43);
		JFrameSelecao.getContentPane().add(btnAnimes);
		
		Button btnFilmes = new Button("Filmes");
		btnFilmes.setSize(200,150);
		btnFilmes.setBackground(Color.LIGHT_GRAY);
		btnFilmes.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnFilmes.setForeground(new Color(0,0,0));
		btnFilmes.setBounds(120, 107, 207, 43);
		JFrameSelecao.getContentPane().add(btnFilmes);
		
		
		/**
		 * 
		 * JFRAME ADD FILMES
		 * JFRAME ADD FILMES
		 * JFRAME ADD FILMES
		 * JFRAME ADD FILMES
		 * JFRAME ADD FILMES
		 * JFRAME ADD FILMES
		 * JFRAME ADD FILMES
		 * 
		 * 
		 * 
		 */
		
		
		
		
		JFrame JFrameAddFilmes = new JFrame();
		JFrameAddFilmes.setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		JFrameAddFilmes.setAlwaysOnTop(true);
		JFrameAddFilmes.setResizable(false);
		JFrameAddFilmes.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		JFrameAddFilmes.setTitle("Add Filmes - TecaPlay");
		JFrameAddFilmes.setIconImage(Toolkit.getDefaultToolkit().getImage("resources\\images\\newLogo.png"));
		JFrameAddFilmes.getContentPane().setBackground(new Color(169,169,169));
		JFrameAddFilmes.getContentPane().setForeground(Color.WHITE);
		JFrameAddFilmes.getContentPane().setLayout(null);
		JFrameAddFilmes.setVisible(false);
		JFrameAddFilmes.setSize(450, 300);
		JFrameAddFilmes.setLocationRelativeTo(null);
		
		
		JLabel lblTitulo = new JLabel("T\u00EDtulo:");
		lblTitulo.setToolTipText("Informe qual \u00E9 o t\u00EDtulo do filme!");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTitulo.setBounds(10, 22, 59, 17);
		JFrameAddFilmes.getContentPane().add(lblTitulo);
		
		JTextField textFieldTituloFilme = new JTextField();
		textFieldTituloFilme.setToolTipText("Informe qual \u00E9 o t\u00EDtulo do filme!");
		textFieldTituloFilme.setBackground(new Color(192,192,192));
		textFieldTituloFilme.setBounds(87, 19, 337, 20);
		JFrameAddFilmes.getContentPane().add(textFieldTituloFilme);
		textFieldTituloFilme.setColumns(10);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				    if(e.getSource() == btnCancelar) {  
				        JFrameAddFilmes.dispose();
				    
				}
			}
		});
		btnCancelar.setBackground(new Color(107,107,107));
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCancelar.setBounds(10, 227, 207, 23);
		JFrameAddFilmes.getContentPane().add(btnCancelar);
		
		JButton btnAdicionarFilme = new JButton("Adicionar");
		btnAdicionarFilme.setToolTipText("Adicionar o filme a biblioteca!");
		btnAdicionarFilme.setBackground(new Color(107,107,107));
		btnAdicionarFilme.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAdicionarFilme.setBounds(217, 227, 207, 23);
		JFrameAddFilmes.getContentPane().add(btnAdicionarFilme);
		
		JLabel lblGenero = new JLabel("G\u00EAnero:");
		lblGenero.setToolTipText("Informe qual \u00E9 o g\u00EAnero do filme!");
		lblGenero.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblGenero.setBounds(10, 59, 83, 20);
		JFrameAddFilmes.getContentPane().add(lblGenero);
		
		JLabel lblPais = new JLabel("Pa\u00EDs:");
		lblPais.setToolTipText("Informe qual \u00E9 o pa\u00EDs do filme!");
		lblPais.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPais.setBounds(10, 109, 46, 14);
		JFrameAddFilmes.getContentPane().add(lblPais);
		
		JLabel lblAno = new JLabel("Ano:");
		lblAno.setToolTipText("Informe qual \u00E9 o ano do filme!");
		lblAno.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAno.setBounds(10, 157, 46, 14);
		JFrameAddFilmes.getContentPane().add(lblAno);
		
		JTextField	textFieldGeneroFilme = new JTextField();
		textFieldGeneroFilme.setToolTipText("Informe qual \u00E9 o g\u00EAnero do filme!");
		textFieldGeneroFilme.setBackground(new Color(192,192,192));
		textFieldGeneroFilme.setBounds(87, 59, 337, 20);
		JFrameAddFilmes.getContentPane().add(textFieldGeneroFilme);
		textFieldGeneroFilme.setColumns(10);
		
		JTextField textFieldPaisFilme = new JTextField();
		textFieldPaisFilme.setToolTipText("Informe qual \u00E9 o pa\u00EDs de origem(lan\u00E7amento) do filme!");
		textFieldPaisFilme.setBackground(new Color(192,192,192));
		textFieldPaisFilme.setBounds(87, 106, 337, 20);
		JFrameAddFilmes.getContentPane().add(textFieldPaisFilme);
		textFieldPaisFilme.setColumns(10);
		
		JTextField textFieldAnoFilme = new JTextField();
		textFieldAnoFilme.setToolTipText("Informe qual \u00E9 o ano de lan\u00E7amento do filme!");
		textFieldAnoFilme.setBackground(new Color(192,192,192));
		textFieldAnoFilme.setBounds(87, 154, 130, 20);
		JFrameAddFilmes.getContentPane().add(textFieldAnoFilme);
		textFieldAnoFilme.setColumns(10);
		
		JButton btnProcurarFilme = new JButton("Procurar");
		btnProcurarFilme.setToolTipText("Clique sobre para procurar o filme em seu sistema.");
		btnProcurarFilme.setBackground(new Color(107,107,107));
		btnProcurarFilme.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnProcurarFilme.setBounds(309, 185, 115, 23);
		JFrameAddFilmes.getContentPane().add(btnProcurarFilme);
		
		JTextField textFieldProcurarFilme = new JTextField();
		textFieldProcurarFilme.setToolTipText("Diret\u00F3rio onde o filme est\u00E1 localizado.");
		textFieldProcurarFilme.setBackground(new Color(192,192,192));
		textFieldProcurarFilme.setBounds(10, 185, 289, 20);
		JFrameAddFilmes.getContentPane().add(textFieldProcurarFilme);
		textFieldProcurarFilme.setColumns(10);
		
		JTextField textFieldDuracaoFilme = new JTextField();
		textFieldDuracaoFilme.setToolTipText("Informe qual \u00E9 a dura\u00E7\u00E3o do filme(em minutos)!");
		textFieldDuracaoFilme.setColumns(10);
		textFieldDuracaoFilme.setBackground(Color.LIGHT_GRAY);
		textFieldDuracaoFilme.setBounds(304, 151, 130, 20);
		JFrameAddFilmes.getContentPane().add(textFieldDuracaoFilme);
		
		JLabel lblDuracao = new JLabel("Dura\u00E7\u00E3o:");
		lblDuracao.setToolTipText("");
		lblDuracao.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDuracao.setBounds(227, 154, 72, 14);
		JFrameAddFilmes.getContentPane().add(lblDuracao);
		
		
		
		
		/**
		 * 

		 * Label ADD SERIE
		 * Label ADD SERIE
		 * Label ADD SERIE
		 * Label ADD SERIE
		 * Label ADD SERIE
		 * Label ADD SERIE
		 * Label ADD SERIE
		 * 
		 * 
		 * 
		 */
		
		
		
		JFrame JFrameAddSerie = new JFrame();
		JFrameAddSerie.setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		JFrameAddSerie.setAlwaysOnTop(true);
		JFrameAddSerie.setResizable(false);
		JFrameAddSerie.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		JFrameAddSerie.setTitle("Add Séries - TecaPlay");
		JFrameAddSerie.setIconImage(Toolkit.getDefaultToolkit().getImage("resources\\images\\newLogo.png"));
		JFrameAddSerie.getContentPane().setBackground(new Color(169,169,169));
		JFrameAddSerie.getContentPane().setForeground(Color.WHITE);
		JFrameAddSerie.getContentPane().setLayout(null);
		JFrameAddSerie.setVisible(false);
		JFrameAddSerie.setSize(450, 300);
		JFrameAddSerie.setLocationRelativeTo(null);
		
		JLabel lblTituloSerie = new JLabel("T\u00EDtulo:");
		lblTituloSerie.setToolTipText("Informe qual \u00E9 o t\u00EDtulo do filme!");
		lblTituloSerie.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTituloSerie.setBounds(10, 22, 59, 17);
		JFrameAddSerie.getContentPane().add(lblTituloSerie);
		
		JTextField textFieldTitulo = new JTextField();
		textFieldTitulo.setToolTipText("Informe qual \u00E9 o t\u00EDtulo do filme!");
		textFieldTitulo.setBackground(new Color(192,192,192));
		textFieldTitulo.setBounds(87, 19, 337, 20);
		JFrameAddSerie.getContentPane().add(textFieldTitulo);
		textFieldTitulo.setColumns(10);
		
		JButton btnCancelarSerie = new JButton("Cancelar");
		btnCancelarSerie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				    if(e.getSource() == btnCancelarSerie) {  
				    	JFrameAddSerie.dispose();
				    
				}
			}
		});
		btnCancelarSerie.setBackground(new Color(107,107,107));
		btnCancelarSerie.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCancelarSerie.setBounds(10, 227, 207, 23);
		JFrameAddSerie.getContentPane().add(btnCancelarSerie);
		
		JButton btnAdicionarSerie = new JButton("Adicionar");
		btnAdicionarSerie.setToolTipText("Adicionar o filme a biblioteca!");
		btnAdicionarSerie.setBackground(new Color(107,107,107));
		btnAdicionarSerie.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAdicionarSerie.setBounds(217, 227, 207, 23);
		JFrameAddSerie.getContentPane().add(btnAdicionarSerie);
		
		JLabel lblGeneroSerie = new JLabel("G\u00EAnero:");
		lblGeneroSerie.setToolTipText("Informe qual \u00E9 o g\u00EAnero do filme!");
		lblGeneroSerie.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblGeneroSerie.setBounds(10, 59, 83, 20);
		JFrameAddSerie.getContentPane().add(lblGeneroSerie);
		
		JLabel lblPaisSerie = new JLabel("Pa\u00EDs:");
		lblPaisSerie.setToolTipText("Informe qual \u00E9 o pa\u00EDs do filme!");
		lblPaisSerie.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPaisSerie.setBounds(10, 109, 46, 14);
		JFrameAddSerie.getContentPane().add(lblPaisSerie);
		
		JLabel lblAnoSerie = new JLabel("Ano:");
		lblAnoSerie.setToolTipText("Informe qual \u00E9 o ano do filme!");
		lblAnoSerie.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAnoSerie.setBounds(10, 157, 46, 14);
		JFrameAddSerie.getContentPane().add(lblAnoSerie);
		
		JTextField textFieldGenero = new JTextField();
		textFieldGenero.setToolTipText("Informe qual \u00E9 o g\u00EAnero do filme!");
		textFieldGenero.setBackground(new Color(192,192,192));
		textFieldGenero.setBounds(87, 59, 337, 20);
		JFrameAddSerie.getContentPane().add(textFieldGenero);
		textFieldGenero.setColumns(10);
		
		JTextField textFieldPais = new JTextField();
		textFieldPais.setToolTipText("Informe qual \u00E9 o pa\u00EDs de origem(lan\u00E7amento) do filme!");
		textFieldPais.setBackground(new Color(192,192,192));
		textFieldPais.setBounds(87, 106, 337, 20);
		JFrameAddSerie.getContentPane().add(textFieldPais);
		textFieldPais.setColumns(10);
		
		JTextField textFieldAno = new JTextField();
		textFieldAno.setToolTipText("Informe qual \u00E9 o ano de lan\u00E7amento do filme!");
		textFieldAno.setBackground(new Color(192,192,192));
		textFieldAno.setBounds(87, 154, 130, 20);
		JFrameAddSerie.getContentPane().add(textFieldAno);
		textFieldAno.setColumns(10);
		
		JButton btnProcurarSerie = new JButton("Procurar");
		btnProcurarSerie.setToolTipText("Clique sobre para procurar o filme em seu sistema.");
		btnProcurarSerie.setBackground(new Color(107,107,107));
		btnProcurarSerie.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnProcurarSerie.setBounds(309, 185, 115, 23);
		JFrameAddSerie.getContentPane().add(btnProcurarSerie);
		
		JTextField 	textFieldProcurar = new JTextField();
		textFieldProcurar.setToolTipText("Diret\u00F3rio onde o filme est\u00E1 localizado.");
		textFieldProcurar.setBackground(new Color(192,192,192));
		textFieldProcurar.setBounds(10, 185, 289, 20);
		JFrameAddSerie.getContentPane().add(textFieldProcurar);
		textFieldProcurar.setColumns(10);
		
		JTextField	textFieldDuracao = new JTextField();
		textFieldDuracao.setToolTipText("Informe qual \u00E9 a dura\u00E7\u00E3o do filme(em minutos)!");
		textFieldDuracao.setColumns(10);
		textFieldDuracao.setBackground(Color.LIGHT_GRAY);
		textFieldDuracao.setBounds(304, 151, 130, 20);
		JFrameAddSerie.getContentPane().add(textFieldDuracao);
		
		JLabel lblDuracaoSerie = new JLabel("Dura\u00E7\u00E3o:");
		lblDuracaoSerie.setToolTipText("");
		lblDuracaoSerie.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDuracaoSerie.setBounds(227, 154, 72, 14);
		JFrameAddSerie.getContentPane().add(lblDuracaoSerie);
		
		
		
		/**
		 * 
		 * 
		 *JPANEL ANIMES
		 *ANIMES
		 *ANIMES
		 * 
		 * 
		 */

		JFrame JFrameAddAnime = new JFrame();
		JFrameAddAnime.setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		JFrameAddAnime.setAlwaysOnTop(true);
		JFrameAddAnime.setResizable(false);
		JFrameAddAnime.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		JFrameAddAnime.setTitle("Add Animes - TecaPlay");
		JFrameAddAnime.setIconImage(Toolkit.getDefaultToolkit().getImage("resources\\images\\newLogo.png"));
		JFrameAddAnime.getContentPane().setBackground(new Color(169,169,169));
		JFrameAddAnime.getContentPane().setForeground(Color.WHITE);
		JFrameAddAnime.getContentPane().setLayout(null);
		JFrameAddAnime.setVisible(false);
		JFrameAddAnime.setSize(450, 300);
		JFrameAddAnime.setLocationRelativeTo(null);
		
		
		JLabel lblTituloAnime = new JLabel("T\u00EDtulo:");
		lblTituloAnime.setToolTipText("Informe qual \u00E9 o t\u00EDtulo do filme!");
		lblTituloAnime.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTituloAnime.setBounds(10, 22, 59, 17);
		JFrameAddAnime.getContentPane().add(lblTituloAnime);
		
		JTextField textFieldTitulo2 = new JTextField();
		textFieldTitulo2.setToolTipText("Informe qual \u00E9 o t\u00EDtulo do filme!");
		textFieldTitulo2.setBackground(new Color(192,192,192));
		textFieldTitulo2.setBounds(87, 19, 337, 20);
		JFrameAddAnime.getContentPane().add(textFieldTitulo2);
		textFieldTitulo2.setColumns(10);
		
		JButton btnCancelarAnime = new JButton("Cancelar");
		btnCancelarAnime.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				    if(e.getSource() == btnCancelarAnime) {  
				        JFrameAddAnime.dispose();
				    
				}
			}
		});
		btnCancelarAnime.setBackground(new Color(107,107,107));
		btnCancelarAnime.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCancelarAnime.setBounds(10, 227, 207, 23);
		JFrameAddAnime.getContentPane().add(btnCancelarAnime);
		
		JButton btnAdicionarAnime = new JButton("Adicionar");
		btnAdicionarAnime.setToolTipText("Adicionar o filme a biblioteca!");
		btnAdicionarAnime.setBackground(new Color(107,107,107));
		btnAdicionarAnime.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAdicionarAnime.setBounds(217, 227, 207, 23);
		JFrameAddAnime.getContentPane().add(btnAdicionarAnime);
		
		JLabel lblGeneroAnime = new JLabel("G\u00EAnero:");
		lblGeneroAnime.setToolTipText("Informe qual \u00E9 o g\u00EAnero do filme!");
		lblGeneroAnime.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblGeneroAnime.setBounds(10, 59, 83, 20);
		JFrameAddAnime.getContentPane().add(lblGeneroAnime);
		
		JLabel lblPaisAnime = new JLabel("Pa\u00EDs:");
		lblPaisAnime.setToolTipText("Informe qual \u00E9 o pa\u00EDs do filme!");
		lblPaisAnime.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPaisAnime.setBounds(10, 109, 46, 14);
		JFrameAddAnime.getContentPane().add(lblPaisAnime);
		
		JLabel lblAnoAnime = new JLabel("Ano:");
		lblAnoAnime.setToolTipText("Informe qual \u00E9 o ano do filme!");
		lblAnoAnime.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAnoAnime.setBounds(10, 157, 46, 14);
		JFrameAddAnime.getContentPane().add(lblAnoAnime);
		
		JTextField textFieldGenero2 = new JTextField();
		textFieldGenero2.setToolTipText("Informe qual \u00E9 o g\u00EAnero do filme!");
		textFieldGenero2.setBackground(new Color(192,192,192));
		textFieldGenero2.setBounds(87, 59, 337, 20);
		JFrameAddAnime.getContentPane().add(textFieldGenero2);
		textFieldGenero2.setColumns(10);
		
		JTextField textFieldPais2 = new JTextField();
		textFieldPais2.setToolTipText("Informe qual \u00E9 o pa\u00EDs de origem(lan\u00E7amento) do filme!");
		textFieldPais2.setBackground(new Color(192,192,192));
		textFieldPais2.setBounds(87, 106, 337, 20);
		JFrameAddAnime.getContentPane().add(textFieldPais2);
		textFieldPais2.setColumns(10);
		
		JTextField textFieldAno2 = new JTextField();
		textFieldAno2.setToolTipText("Informe qual \u00E9 o ano de lan\u00E7amento do filme!");
		textFieldAno2.setBackground(new Color(192,192,192));
		textFieldAno2.setBounds(87, 154, 130, 20);
		JFrameAddAnime.getContentPane().add(textFieldAno2);
		textFieldAno2.setColumns(10);
		
		JButton btnProcurarAnime = new JButton("Procurar");
		btnProcurarAnime.setToolTipText("Clique sobre para procurar o filme em seu sistema.");
		btnProcurarAnime.setBackground(new Color(107,107,107));
		btnProcurarAnime.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnProcurarAnime.setBounds(309, 185, 115, 23);
		JFrameAddAnime.getContentPane().add(btnProcurarAnime);
		
		JTextField textFieldProcurar2 = new JTextField();
		textFieldProcurar2.setToolTipText("Diret\u00F3rio onde o filme est\u00E1 localizado.");
		textFieldProcurar2.setBackground(new Color(192,192,192));
		textFieldProcurar2.setBounds(10, 185, 289, 20);
		JFrameAddAnime.getContentPane().add(textFieldProcurar2);
		textFieldProcurar2.setColumns(10);
		
		JTextField textFieldDuracao2 = new JTextField();
		textFieldDuracao2.setToolTipText("Informe qual \u00E9 a dura\u00E7\u00E3o do filme(em minutos)!");
		textFieldDuracao2.setColumns(10);
		textFieldDuracao2.setBackground(Color.LIGHT_GRAY);
		textFieldDuracao2.setBounds(304, 151, 130, 20);
		JFrameAddAnime.getContentPane().add(textFieldDuracao2);
		
		JLabel lblDuracaoAnime = new JLabel("Dura\u00E7\u00E3o:");
		lblDuracaoAnime.setToolTipText("");
		lblDuracaoAnime.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDuracaoAnime.setBounds(227, 154, 72, 14);
		JFrameAddAnime.getContentPane().add(lblDuracaoAnime);
		
		
		
		
		
		btnSeries.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    if(e.getSource() == btnSeries) {  
			        JFrameSelecao.dispose();
			        JFrameAddSerie.setVisible(true);
			    
			}
		}
	});
		
		btnFilmes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    if(e.getSource() == btnFilmes) {  
			        JFrameSelecao.dispose();
			        JFrameAddAnime.setVisible(true);
			    
			}
		}
	});
		btnAdicionarSerie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
			    	FileUtil fileUtil = new FileUtil();
			    	String origem = textFieldProcurar.getText();
			    	textFieldProcurar.setText("");
			    	String ano = textFieldAno.getText();
			    	textFieldAno.setText("");
			    	String nome = textFieldTitulo.getText();
			    	textFieldTitulo.setText("");
			    	String genero = textFieldGenero.getText();
			    	textFieldGenero.setText("");
			    	textFieldPais.setText("");
			    	textFieldDuracao.setText("");
			    	String series = "serie";
			    	fileUtil.AddFilme(origem,ano,nome,genero,series);
		}
	});
		btnAdicionarFilme.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
			    	FileUtil fileUtil = new FileUtil();
			    	String origem = textFieldProcurarFilme.getText();
			    	textFieldProcurarFilme.setText("");
			    	String ano = textFieldAnoFilme.getText();
			    	textFieldAnoFilme.setText("");
			    	String nome = textFieldTituloFilme.getText();
			    	textFieldTituloFilme.setText("");
			    	String genero = textFieldGeneroFilme.getText();
			    	textFieldGeneroFilme.setText("");
			    	textFieldPaisFilme.setText("");
			    	textFieldDuracaoFilme.setText("");
			    	String filme = "Filme";
			    	fileUtil.AddFilme(origem,ano,nome,genero,filme);
		}
	});
		btnAdicionarAnime.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
			    	FileUtil fileUtil = new FileUtil();
			    	String origem = textFieldProcurar2.getText();
			    	textFieldProcurar2.setText("");
			    	String ano = textFieldAno2.getText();
			    	textFieldAno2.setText("");
			    	String nome = textFieldTitulo2.getText();
			    	textFieldTitulo2.setText("");
			    	String genero = textFieldGenero2.getText();
			    	textFieldGenero2.setText("");
			    	textFieldPais2.setText("");
			    	textFieldDuracao2.setText("");
			    	String anime = "Anime";
			    	fileUtil.AddFilme(origem,ano,nome,genero,anime);
		}
	});
		
		
	
		
		
		btnAnimes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    if(e.getSource() == btnAnimes) {  
			        JFrameSelecao.dispose();
			        JFrameAddAnime.setVisible(true);
			    
			}
		}
	});
	}
	
}
