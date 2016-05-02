package br.edu.pii.tecaplay.ui;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import br.edu.pii.tecaplay.util.MoveFile;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;

public class FilmesAdd {
	public void Topo(){};
	String tipo = "";
	public FilmesAdd(String usrName){ 
	
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
		JFrameSelecao.setSize(205, 190);
		JFrameSelecao.setLocationRelativeTo(null);
		
		
		Button btnSeries = new Button("Séries");
		btnSeries.setSize(200,150);
		btnSeries.setBackground(Color.LIGHT_GRAY);
		btnSeries.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnSeries.setForeground(new Color(0,0,0));
		btnSeries.setBounds(10, 10, 180, 40);
		JFrameSelecao.getContentPane().add(btnSeries);
		
		
		Button btnAnimes = new Button("Animes");
		btnAnimes.setSize(200,150);
		btnAnimes.setBackground(Color.LIGHT_GRAY);
		btnAnimes.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnAnimes.setForeground(new Color(0,0,0));
		btnAnimes.setBounds(10, 60, 180, 40);
		JFrameSelecao.getContentPane().add(btnAnimes);
		
		Button btnFilmes = new Button("Filmes");
		btnFilmes.setSize(200,150);
		btnFilmes.setBackground(Color.LIGHT_GRAY);
		btnFilmes.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnFilmes.setForeground(new Color(0,0,0));
		btnFilmes.setBounds(10, 110, 180, 40);
		JFrameSelecao.getContentPane().add(btnFilmes);
		
		
		
	
		
		
		
		
		/**
		 * 
		 * 
		 * Função Botoes
		 * * Função Botoes
		 * * Função Botoes
		 * * Função Botoes
		 * * Função Botoes
		 * * Função Botoes
		 */
		
		btnAnimes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    if(e.getSource() == btnAnimes) {  
			        JFrameSelecao.dispose();
			        tipo = "Anime";
			        AddAnime(usrName);
			    
			}
		}
	});
		
		
		btnSeries.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    if(e.getSource() == btnSeries) {  
			        JFrameSelecao.dispose();
			        tipo = "serie";
			       AddSerie(usrName);
			    
			}
		}
	});
		
		btnFilmes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    if(e.getSource() == btnFilmes) {  
			        JFrameSelecao.dispose();
			        tipo = "filme";
			        AddFilme(usrName);
			    
			}
		}
	});
		//Jbutton de procurar endereço do arquivo no pc
		//
		//
	
	}
	
	
	public void AddFilme(String usrName) {
		
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
		
		
		
		
		JFrame JFrameAddFilme = new JFrame();
		JFrameAddFilme.setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		JFrameAddFilme.setAlwaysOnTop(true);
		JFrameAddFilme.setResizable(false);
		JFrameAddFilme.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		JFrameAddFilme.setTitle("Add Filmes - TecaPlay");
		JFrameAddFilme.setIconImage(Toolkit.getDefaultToolkit().getImage("resources\\images\\newLogo.png"));
		JFrameAddFilme.getContentPane().setBackground(new Color(169,169,169));
		JFrameAddFilme.getContentPane().setForeground(Color.WHITE);
		JFrameAddFilme.getContentPane().setLayout(null);
		JFrameAddFilme.setVisible(true);
		JFrameAddFilme.setSize(450, 300);
		JFrameAddFilme.setLocationRelativeTo(null);
		
		
		JLabel lblTituloFilme = new JLabel("T\u00EDtulo:");
		lblTituloFilme.setToolTipText("Informe qual \u00E9 o t\u00EDtulo do filme!");
		lblTituloFilme.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTituloFilme.setBounds(10, 22, 59, 17);
		JFrameAddFilme.getContentPane().add(lblTituloFilme);
		
		JTextField textFieldTituloFilme = new JTextField();
		textFieldTituloFilme.setToolTipText("Informe qual \u00E9 o t\u00EDtulo do filme!");
		textFieldTituloFilme.setBackground(new Color(192,192,192));
		textFieldTituloFilme.setBounds(87, 19, 337, 20);
		JFrameAddFilme.getContentPane().add(textFieldTituloFilme);
		textFieldTituloFilme.setColumns(10);
		
		JButton btnCancelarFilme = new JButton("Cancelar");
		btnCancelarFilme.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				    if(e.getSource() == btnCancelarFilme) {  
				        JFrameAddFilme.dispose();
				    
				}
			}
		});
		btnCancelarFilme.setBackground(new Color(107,107,107));
		btnCancelarFilme.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCancelarFilme.setBounds(10, 227, 207, 23);
		JFrameAddFilme.getContentPane().add(btnCancelarFilme);
		
		JButton btnAdicionarFilme = new JButton("Adicionar");
		btnAdicionarFilme.setToolTipText("Adicionar o filme a biblioteca!");
		btnAdicionarFilme.setBackground(new Color(107,107,107));
		btnAdicionarFilme.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAdicionarFilme.setBounds(217, 227, 207, 23);
		JFrameAddFilme.getContentPane().add(btnAdicionarFilme);
		
		JLabel lblGeneroFilme = new JLabel("G\u00EAnero:");
		lblGeneroFilme.setToolTipText("Informe qual \u00E9 o g\u00EAnero do filme!");
		lblGeneroFilme.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblGeneroFilme.setBounds(10, 59, 83, 20);
		JFrameAddFilme.getContentPane().add(lblGeneroFilme);
		
		JLabel lblPaisFilme = new JLabel("Pa\u00EDs:");
		lblPaisFilme.setToolTipText("Informe qual \u00E9 o pa\u00EDs do filme!");
		lblPaisFilme.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPaisFilme.setBounds(10, 109, 46, 14);
		JFrameAddFilme.getContentPane().add(lblPaisFilme);
		
		JLabel lblAnoFilme = new JLabel("Ano:");
		lblAnoFilme.setToolTipText("Informe qual \u00E9 o ano do filme!");
		lblAnoFilme.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAnoFilme.setBounds(10, 157, 46, 14);
		JFrameAddFilme.getContentPane().add(lblAnoFilme);
		
		JComboBox<String> panelListGenero = new JComboBox<String>();
		ArrayList<String> listaGenero = new ArrayList<>();
		listaGenero.add("Selecione");
		listaGenero.add("Ac\u00E3o");
		listaGenero.add("Anima\u00E7\u00E3o");
		listaGenero.add("Aventura");
		listaGenero.add("Cl\u00E1ssico");
		listaGenero.add("Com\u00E9dia");
		listaGenero.add("Com\u00E9dia Rom\u00E2ntica");
		listaGenero.add("Crime");
		listaGenero.add("Document\u00E1rio");
		listaGenero.add("Drama");
		listaGenero.add("Faroeste");
		listaGenero.add("Fic\u00E7\u00E3o Cientifica");
		listaGenero.add("Guerra");
		listaGenero.add("Musical");
		listaGenero.add("Policial");
		listaGenero.add("Romance");
		listaGenero.add("Suspense");
		listaGenero.add("Terror");
		listaGenero.add("Thriller");
		panelListGenero.setBackground(Color.LIGHT_GRAY);
		panelListGenero.setFont(new Font("Tahoma", Font.BOLD, 13));
		panelListGenero.setForeground(Color.BLACK);
		for (int i = 0; i < listaGenero.size(); i++) {
			panelListGenero.addItem(listaGenero.get(i));
		}
		panelListGenero.setMaximumRowCount(15);
		panelListGenero.setEditable(false);
		panelListGenero.setBounds(87, 59, 337, 20);
		JFrameAddFilme.getContentPane().add(panelListGenero);
		
		JTextField textFieldPaisFilme = new JTextField();
		textFieldPaisFilme.setToolTipText("Informe qual \u00E9 o pa\u00EDs de origem(lan\u00E7amento) do filme!");
		textFieldPaisFilme.setBackground(new Color(192,192,192));
		textFieldPaisFilme.setBounds(87, 106, 337, 20);
		JFrameAddFilme.getContentPane().add(textFieldPaisFilme);
		textFieldPaisFilme.setColumns(10);
		
		JTextField textFieldAnoFilme = new JTextField();
		textFieldAnoFilme.setToolTipText("Informe qual \u00E9 o ano de lan\u00E7amento do filme!");
		textFieldAnoFilme.setBackground(new Color(192,192,192));
		textFieldAnoFilme.setBounds(87, 154, 130, 20);
		JFrameAddFilme.getContentPane().add(textFieldAnoFilme);
		textFieldAnoFilme.setColumns(10);
		
		JButton btnProcurarFilme = new JButton("Procurar");
		btnProcurarFilme.setToolTipText("Clique sobre para procurar o filme em seu sistema.");
		btnProcurarFilme.setBackground(new Color(107,107,107));
		btnProcurarFilme.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnProcurarFilme.setBounds(309, 185, 115, 23);
		JFrameAddFilme.getContentPane().add(btnProcurarFilme);
		
		JTextField textFieldProcurarFilme = new JTextField();
		textFieldProcurarFilme.setToolTipText("Diret\u00F3rio onde o filme est\u00E1 localizado.");
		textFieldProcurarFilme.setBackground(new Color(192,192,192));
		textFieldProcurarFilme.setBounds(10, 185, 289, 20);
		JFrameAddFilme.getContentPane().add(textFieldProcurarFilme);
		textFieldProcurarFilme.setColumns(10);
		
		JTextField textFieldDuracaoFilme = new JTextField();
		textFieldDuracaoFilme.setToolTipText("Informe qual \u00E9 a dura\u00E7\u00E3o do filme(em minutos)!");
		textFieldDuracaoFilme.setColumns(10);
		textFieldDuracaoFilme.setBackground(Color.LIGHT_GRAY);
		textFieldDuracaoFilme.setBounds(304, 151, 130, 20);
		JFrameAddFilme.getContentPane().add(textFieldDuracaoFilme);
		
		JLabel lblDuracaoFilme = new JLabel("Dura\u00E7\u00E3o:");
		lblDuracaoFilme.setToolTipText("");
		lblDuracaoFilme.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDuracaoFilme.setBounds(227, 154, 72, 14);
		JFrameAddFilme.getContentPane().add(lblDuracaoFilme);
		
		
		btnProcurarFilme.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				    if(e.getSource() == btnProcurarFilme) {  
				    	JFileChooser file = new JFileChooser(); 
				    	JFrameAddFilme.setAlwaysOnTop(false);
				        file.setFileSelectionMode(JFileChooser.FILES_ONLY);
				        int i= file.showSaveDialog(null);
				      if (i==1){
				          textFieldProcurarFilme.setText("");
				      } else {
				          File arquivo = file.getSelectedFile();
				          textFieldProcurarFilme.setText(arquivo.getPath());
				      }
				    
				}
			}
		});

		
		//Jbuttons para fazer a escolha do tipo de arquivo.
		//se for serie, filme ou anime

		
		//Função de mover o arquivo para o diretorio do programa.
		//a função esta no br.edu.pii.tecaplay.util.FileUtil
		

		btnAdicionarFilme.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
			    	MoveFile MoveFile = new MoveFile();
			    	String genero = (String) panelListGenero.getSelectedItem();
			    	//faz o texte se a pessoa selecionou algum genero.
			    	if (!(genero == "Selecione")){
					    String origem = textFieldProcurarFilme.getText();
				    	String ano = textFieldAnoFilme.getText();
				    	String nome = textFieldTituloFilme.getText();
				    	String pais = textFieldPaisFilme.getText();
				    	String duracao = textFieldDuracaoFilme.getText();
				  //testa se existem fildtexts em branco  	
			    	if(!(origem.equals("")||(ano.equals(""))|| (nome.equals(""))|| (pais.equals("")))){
			    	JFrameAddFilme.setAlwaysOnTop(false); 
			    	//Executa o comando de mover o arquivo e renomealo.
		    		MoveFile.AddFilme(origem, ano, nome, genero, duracao, pais, tipo, usrName);
			 //Limpa os campos de escrita
		    			panelListGenero.setSelectedIndex(0);
				    	textFieldPaisFilme.setText("");
				    	textFieldAnoFilme.setText("");
				    	textFieldProcurarFilme.setText("");
				    	textFieldTituloFilme.setText("");
				    	textFieldDuracaoFilme.setText("");
			} //ELSE DO PRIMEIRO IF
			    	else{
			    		JFrameAddFilme.setAlwaysOnTop(false); 
		    		JOptionPane.showMessageDialog(null, "Por favor, preenche todos os campos com o Asterisco *", "Preencha todos os campos", 0);	
			    	}
			    	
			    	}
			  //ELSE DO SEGUNDO IF  	
				else{
		    		JFrameAddFilme.setAlwaysOnTop(false); 
		    		JOptionPane.showMessageDialog(null, "Por favor, selecione o componente gênero", "Selecione o Genero", 0);
		
		    	}
		}

	});
		
		
		
	}
	public void AddSerie(String usrName) {

		
		
		
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
		JFrameAddSerie.setVisible(true);
		JFrameAddSerie.setSize(450, 300);
		JFrameAddSerie.setLocationRelativeTo(null);
		
		
		JLabel lblTituloSerie = new JLabel("T\u00EDtulo*:");
		lblTituloSerie.setToolTipText("Informe qual \u00E9 o t\u00EDtulo da Série!");
		lblTituloSerie.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTituloSerie.setBounds(10, 22, 59, 17);
		JFrameAddSerie.getContentPane().add(lblTituloSerie);
		
		JTextField textFieldTituloSerie = new JTextField();
		textFieldTituloSerie.setToolTipText("Informe qual \u00E9 o t\u00EDtulo da Série!");
		textFieldTituloSerie.setBackground(new Color(192,192,192));
		textFieldTituloSerie.setBounds(87, 19, 337, 20);
		JFrameAddSerie.getContentPane().add(textFieldTituloSerie);
		textFieldTituloSerie.setColumns(10);
		
		
		
		JLabel lblGeneroSerie = new JLabel("G\u00EAnero*:");
		lblGeneroSerie.setToolTipText("Informe qual \u00E9 o g\u00EAnero da Série!");
		lblGeneroSerie.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblGeneroSerie.setBounds(10, 59, 83, 20);
		JFrameAddSerie.getContentPane().add(lblGeneroSerie);


		JComboBox<String> panelListGenero = new JComboBox<String>();
		ArrayList<String> listaGenero = new ArrayList<>();
		listaGenero.add("Selecione");
		listaGenero.add("Ac\u00E3o");
		listaGenero.add("Anima\u00E7\u00E3o");
		listaGenero.add("Aventura");
		listaGenero.add("Cl\u00E1ssico");
		listaGenero.add("Com\u00E9dia");
		listaGenero.add("Com\u00E9dia Rom\u00E2ntica");
		listaGenero.add("Crime");
		listaGenero.add("Document\u00E1rio");
		listaGenero.add("Drama");
		listaGenero.add("Faroeste");
		listaGenero.add("Fic\u00E7\u00E3o Cientifica");
		listaGenero.add("Guerra");
		listaGenero.add("Médico");
		listaGenero.add("Musical");
		listaGenero.add("Policial");
		listaGenero.add("Romance");
		listaGenero.add("Suspense");
		listaGenero.add("Terror");
		panelListGenero.setBackground(Color.LIGHT_GRAY);
		panelListGenero.setFont(new Font("Tahoma", Font.BOLD, 13));
		panelListGenero.setForeground(Color.BLACK);
		for (int i = 0; i < listaGenero.size(); i++) {
			panelListGenero.addItem(listaGenero.get(i));
		}
		panelListGenero.setMaximumRowCount(15);
		panelListGenero.setEditable(false);
		panelListGenero.setBounds(87, 59, 337, 20);
		JFrameAddSerie.getContentPane().add(panelListGenero);
		
		
		
		
		JLabel lblNumTemporada = new JLabel("Temporada*:");
		lblNumTemporada.setToolTipText("Informe qual \u00E9 o Numero da Temporada:!");
		lblNumTemporada.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNumTemporada.setBounds(10, 151, 96, 14);
		JFrameAddSerie.getContentPane().add(lblNumTemporada);
		
	
		JTextField textFieldNumTemporada = new JTextField();
		textFieldNumTemporada.setToolTipText("Informe qual \u00E9 o Numero da Temporada:!");
		textFieldNumTemporada.setBackground(new Color(192,192,192));
		textFieldNumTemporada.setBounds(110, 151, 40, 20);
		JFrameAddSerie.getContentPane().add(textFieldNumTemporada);
		textFieldNumTemporada.setColumns(10);
		
		JLabel lblEpisodio = new JLabel("Episódio*:");
		lblEpisodio.setToolTipText("Informe qual \u00E9 o Episódio da Série!");
		lblEpisodio.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEpisodio.setBounds(10, 106, 76, 14);
		JFrameAddSerie.getContentPane().add(lblEpisodio);
		
		JTextField textFieldEpisodio = new JTextField();
		textFieldEpisodio.setToolTipText("Informe qual \u00E9 número de episódio da série!");
		textFieldEpisodio.setBackground(new Color(192,192,192));
		textFieldEpisodio.setBounds(89, 106, 37, 20);
		JFrameAddSerie.getContentPane().add(textFieldEpisodio);
		textFieldEpisodio.setColumns(10);
		
		JButton btnProcurarFilme = new JButton("Procurar");
		btnProcurarFilme.setToolTipText("Clique sobre para procurar a Série em seu sistema.");
		btnProcurarFilme.setBackground(new Color(107,107,107));
		btnProcurarFilme.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnProcurarFilme.setBounds(309, 185, 115, 23);
		JFrameAddSerie.getContentPane().add(btnProcurarFilme);
		
		JTextField textFieldProcurarFilme = new JTextField();
		textFieldProcurarFilme.setToolTipText("Diret\u00F3rio onde a série est\u00E1 localizado.");
		textFieldProcurarFilme.setBackground(new Color(192,192,192));
		textFieldProcurarFilme.setBounds(10, 185, 289, 20);
		JFrameAddSerie.getContentPane().add(textFieldProcurarFilme);
		textFieldProcurarFilme.setColumns(10);
		
		JLabel lblDuracaoFilme = new JLabel("Dura\u00E7\u00E3o:");
		lblDuracaoFilme.setToolTipText("");
		lblDuracaoFilme.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDuracaoFilme.setBounds(227, 151, 72, 14);
		JFrameAddSerie.getContentPane().add(lblDuracaoFilme);
		
		
		JTextField textFieldDuracaoFilme = new JTextField();
		textFieldDuracaoFilme.setToolTipText("Informe qual \u00E9 a dura\u00E7\u00E3o do filme(em minutos)!");
		textFieldDuracaoFilme.setColumns(10);
		textFieldDuracaoFilme.setBackground(Color.LIGHT_GRAY);
		textFieldDuracaoFilme.setBounds(304, 151, 118, 20);
		JFrameAddSerie.getContentPane().add(textFieldDuracaoFilme);
		
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
		
	
		
		btnProcurarFilme.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				    if(e.getSource() == btnProcurarFilme) {  
				    	JFileChooser file = new JFileChooser(); 
				    	JFrameAddSerie.setAlwaysOnTop(false);
				        file.setFileSelectionMode(JFileChooser.FILES_ONLY);
				        int i= file.showSaveDialog(null);
				      if (i==1){
				          textFieldProcurarFilme.setText("");
				      } else {
				          File arquivo = file.getSelectedFile();
				          textFieldProcurarFilme.setText(arquivo.getPath());
				      }
				    
				}
			}
		});

		btnAdicionarSerie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
			    	MoveFile MoveFile = new MoveFile();
			    	String genero = (String) panelListGenero.getSelectedItem();
			    	//faz o texte se a pessoa selecionou algum genero.
			    	if (!(genero == "Selecione")){
					    String origem = textFieldProcurarFilme.getText();
				    	String numTemp = textFieldNumTemporada.getText();
				    	String nome = textFieldTituloSerie.getText();
				    	String numEpisodio = textFieldEpisodio.getText();
				    	String duracao = textFieldDuracaoFilme.getText();
				  //testa se existem fildtexts em branco  	
			    	if(!(origem.equals("")||(numTemp.equals(""))|| (nome.equals(""))|| (numEpisodio.equals("")))){
			    	JFrameAddSerie.setAlwaysOnTop(false); 
			    	//Executa o comando de mover o arquivo e renomealo.
		    		MoveFile.AddSerie(origem, numTemp, nome, genero, duracao, numEpisodio, tipo, usrName);
			 //Limpa os campos de escrita
		    			panelListGenero.setSelectedIndex(0);
				    	textFieldEpisodio.setText("");
				    	textFieldNumTemporada.setText("");
				    	textFieldProcurarFilme.setText("");
				    	textFieldTituloSerie.setText("");
				    	textFieldDuracaoFilme.setText("");
			} //ELSE DO PRIMEIRO IF
			    	else{
			    		JFrameAddSerie.setAlwaysOnTop(false); 
		    		JOptionPane.showMessageDialog(null, "Por favor, preenche todos os campos com o Asterisco *", "Preencha todos os campos", 0);	
			    	}
			    	
			    	}
			  //ELSE DO SEGUNDO IF  	
				else{
		    		JFrameAddSerie.setAlwaysOnTop(false); 
		    		JOptionPane.showMessageDialog(null, "Por favor, selecione o componente gênero", "Selecione o Genero", 0);
		
		    	}
		}

	});
		
		

	}
	public void AddAnime(String usrName){


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
		JFrameAddAnime.setVisible(true);
		JFrameAddAnime.setSize(450, 300);
		JFrameAddAnime.setLocationRelativeTo(null);
		
		
		JLabel lblTituloAnime = new JLabel("T\u00EDtulo*:");
		lblTituloAnime.setToolTipText("Informe qual \u00E9 o t\u00EDtulo do Anime!");
		lblTituloAnime.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTituloAnime.setBounds(10, 22, 59, 17);
		JFrameAddAnime.getContentPane().add(lblTituloAnime);
		
		JTextField textFieldTituloAnime = new JTextField();
		textFieldTituloAnime.setToolTipText("Informe qual \u00E9 o t\u00EDtulo do Anime!");
		textFieldTituloAnime.setBackground(new Color(192,192,192));
		textFieldTituloAnime.setBounds(87, 19, 337, 20);
		JFrameAddAnime.getContentPane().add(textFieldTituloAnime);
		textFieldTituloAnime.setColumns(10);
		
		
		
		JLabel lblGeneroAnime = new JLabel("G\u00EAnero*:");
		lblGeneroAnime.setToolTipText("Informe qual \u00E9 o g\u00EAnero do Anime!");
		lblGeneroAnime.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblGeneroAnime.setBounds(10, 59, 83, 20);
		JFrameAddAnime.getContentPane().add(lblGeneroAnime);


		JComboBox<String> panelListGeneroAnime = new JComboBox<String>();
		ArrayList<String> listaGeneroAnime = new ArrayList<>();
		listaGeneroAnime.add("Selecione");
		listaGeneroAnime.add("Ac\u00E3o");
		listaGeneroAnime.add("Anima\u00E7\u00E3o");
		listaGeneroAnime.add("Aventura");
		listaGeneroAnime.add("Cl\u00E1ssico");
		listaGeneroAnime.add("Com\u00E9dia");
		listaGeneroAnime.add("Com\u00E9dia Rom\u00E2ntica");
		listaGeneroAnime.add("Crime");
		listaGeneroAnime.add("Document\u00E1rio");
		listaGeneroAnime.add("Drama");
		listaGeneroAnime.add("Faroeste");
		listaGeneroAnime.add("Fic\u00E7\u00E3o Cientifica");
		listaGeneroAnime.add("Guerra");
		listaGeneroAnime.add("Médico");
		listaGeneroAnime.add("Musical");
		listaGeneroAnime.add("Policial");
		listaGeneroAnime.add("Romance");
		listaGeneroAnime.add("Suspense");
		listaGeneroAnime.add("Terror");
		panelListGeneroAnime.setBackground(Color.LIGHT_GRAY);
		panelListGeneroAnime.setFont(new Font("Tahoma", Font.BOLD, 13));
		panelListGeneroAnime.setForeground(Color.BLACK);
		for (int i = 0; i < listaGeneroAnime.size(); i++) {
			panelListGeneroAnime.addItem(listaGeneroAnime.get(i));
		}
		panelListGeneroAnime.setMaximumRowCount(15);
		panelListGeneroAnime.setEditable(false);
		panelListGeneroAnime.setBounds(87, 59, 337, 20);
		JFrameAddAnime.getContentPane().add(panelListGeneroAnime);
		
		
		
		
		JLabel lblNumTemporadaAnime = new JLabel("Temporada*:");
		lblNumTemporadaAnime.setToolTipText("Informe qual \u00E9 o Numero da Temporada:!");
		lblNumTemporadaAnime.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNumTemporadaAnime.setBounds(10, 151, 96, 14);
		JFrameAddAnime.getContentPane().add(lblNumTemporadaAnime);
		
	
		JTextField textFieldNumTemporadaAnime = new JTextField();
		textFieldNumTemporadaAnime.setToolTipText("Informe qual \u00E9 o Numero da Temporada:!");
		textFieldNumTemporadaAnime.setBackground(new Color(192,192,192));
		textFieldNumTemporadaAnime.setBounds(110, 151, 40, 20);
		JFrameAddAnime.getContentPane().add(textFieldNumTemporadaAnime);
		textFieldNumTemporadaAnime.setColumns(10);
		
		JLabel lblEpisodioAnime = new JLabel("Episódio*:");
		lblEpisodioAnime.setToolTipText("Informe qual \u00E9 o Episódio da Série!");
		lblEpisodioAnime.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEpisodioAnime.setBounds(10, 106, 76, 14);
		JFrameAddAnime.getContentPane().add(lblEpisodioAnime);
		
		JTextField textFieldEpisodioAnime = new JTextField();
		textFieldEpisodioAnime.setToolTipText("Informe qual \u00E9 número de episódio da série!");
		textFieldEpisodioAnime.setBackground(new Color(192,192,192));
		textFieldEpisodioAnime.setBounds(89, 106, 37, 20);
		JFrameAddAnime.getContentPane().add(textFieldEpisodioAnime);
		textFieldEpisodioAnime.setColumns(10);
		
		JButton btnProcurarAnime = new JButton("Procurar");
		btnProcurarAnime.setToolTipText("Clique sobre para procurar a Série em seu sistema.");
		btnProcurarAnime.setBackground(new Color(107,107,107));
		btnProcurarAnime.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnProcurarAnime.setBounds(309, 185, 115, 23);
		JFrameAddAnime.getContentPane().add(btnProcurarAnime);
		
		JTextField textFieldProcurarAnime = new JTextField();
		textFieldProcurarAnime.setToolTipText("Diret\u00F3rio onde a série est\u00E1 localizado.");
		textFieldProcurarAnime.setBackground(new Color(192,192,192));
		textFieldProcurarAnime.setBounds(10, 185, 289, 20);
		JFrameAddAnime.getContentPane().add(textFieldProcurarAnime);
		textFieldProcurarAnime.setColumns(10);
		
		JLabel lblDuracaoAnime = new JLabel("Dura\u00E7\u00E3o:");
		lblDuracaoAnime.setToolTipText("");
		lblDuracaoAnime.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDuracaoAnime.setBounds(227, 151, 72, 14);
		JFrameAddAnime.getContentPane().add(lblDuracaoAnime);
		
		
		JTextField textFieldDuracaoAnime = new JTextField();
		textFieldDuracaoAnime.setToolTipText("Informe qual \u00E9 a dura\u00E7\u00E3o do filme(em minutos)!");
		textFieldDuracaoAnime.setColumns(10);
		textFieldDuracaoAnime.setBackground(Color.LIGHT_GRAY);
		textFieldDuracaoAnime.setBounds(304, 151, 118, 20);
		JFrameAddAnime.getContentPane().add(textFieldDuracaoAnime);
		
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
		
	
		
		btnProcurarAnime.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				    if(e.getSource() == btnProcurarAnime) {  
				    	JFileChooser file = new JFileChooser(); 
				    	JFrameAddAnime.setAlwaysOnTop(false);
				        file.setFileSelectionMode(JFileChooser.FILES_ONLY);
				        int i= file.showSaveDialog(null);
				      if (i==1){
				          textFieldProcurarAnime.setText("");
				      } else {
				          File arquivo = file.getSelectedFile();
				          textFieldProcurarAnime.setText(arquivo.getPath());
				      }
				    
				}
			}
		});

		btnAdicionarAnime.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
			    	MoveFile MoveFile = new MoveFile();
			    	String genero = (String) panelListGeneroAnime.getSelectedItem();
			    	//faz o texte se a pessoa selecionou algum genero.
			    	if (!(genero == "Selecione")){
					    String origem = textFieldProcurarAnime.getText();
				    	String numTemp = textFieldNumTemporadaAnime.getText();
				    	String nome = textFieldTituloAnime.getText();			    
				    	String numEpisodio = textFieldEpisodioAnime.getText();
				    	String duracao = textFieldDuracaoAnime.getText();
				  //testa se existem fildtexts em branco  	
					    	if(!(origem.equals("")||(numTemp.equals(""))|| (nome.equals(""))|| (numEpisodio.equals("")))){
					    	JFrameAddAnime.setAlwaysOnTop(false); 
					    	//Executa o comando de mover o arquivo e renomealo.
				    		MoveFile.AddFilme(origem, numTemp, nome, genero, duracao, numEpisodio, tipo, usrName);
					 //Limpa os campos de escrita
				    			panelListGeneroAnime.setSelectedIndex(0);
						    	textFieldEpisodioAnime.setText("");
						    	textFieldNumTemporadaAnime.setText("");
						    	textFieldProcurarAnime.setText("");
						    	textFieldTituloAnime.setText("");
						    	textFieldDuracaoAnime.setText("");
					} //ELSE DO Segundo IF
			    	else{
			    		JFrameAddAnime.setAlwaysOnTop(false); 
		    		JOptionPane.showMessageDialog(null, "Por favor, preenche todos os campos com o Asterisco *", "Preencha todos os campos", 0);	
			    	}
			    	
			    	}
			  //ELSE DO primeiro IF  	
				else{
		    		JFrameAddAnime.setAlwaysOnTop(false); 
		    		JOptionPane.showMessageDialog(null, "Por favor, selecione o componente gênero", "Selecione o Genero", 0);
		
		    	}
		}

	});
	} 

}
