package br.edu.pii.tecaplay.ui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import br.edu.pii.tecaplay.util.FileUtil;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import java.awt.Dialog.ModalExclusionType;

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
		
		
		
		
		JFrame JFrameAdd = new JFrame();
		JFrameAdd.setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		JFrameAdd.setAlwaysOnTop(true);
		JFrameAdd.setResizable(false);
		JFrameAdd.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		JFrameAdd.setTitle("Add Filmes - TecaPlay");
		JFrameAdd.setIconImage(Toolkit.getDefaultToolkit().getImage("resources\\images\\newLogo.png"));
		JFrameAdd.getContentPane().setBackground(new Color(169,169,169));
		JFrameAdd.getContentPane().setForeground(Color.WHITE);
		JFrameAdd.getContentPane().setLayout(null);
		JFrameAdd.setVisible(false);
		JFrameAdd.setSize(450, 300);
		JFrameAdd.setLocationRelativeTo(null);
		
		
		JLabel lblTitulo = new JLabel("T\u00EDtulo:");
		lblTitulo.setToolTipText("Informe qual \u00E9 o t\u00EDtulo do filme!");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTitulo.setBounds(10, 22, 59, 17);
		JFrameAdd.getContentPane().add(lblTitulo);
		
		JTextField textFieldTitulo = new JTextField();
		textFieldTitulo.setToolTipText("Informe qual \u00E9 o t\u00EDtulo do filme!");
		textFieldTitulo.setBackground(new Color(192,192,192));
		textFieldTitulo.setBounds(87, 19, 337, 20);
		JFrameAdd.getContentPane().add(textFieldTitulo);
		textFieldTitulo.setColumns(10);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				    if(e.getSource() == btnCancelar) {  
				        JFrameAdd.dispose();
				    
				}
			}
		});
		btnCancelar.setBackground(new Color(107,107,107));
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCancelar.setBounds(10, 227, 207, 23);
		JFrameAdd.getContentPane().add(btnCancelar);
		
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setToolTipText("Adicionar o filme a biblioteca!");
		btnAdicionar.setBackground(new Color(107,107,107));
		btnAdicionar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAdicionar.setBounds(217, 227, 207, 23);
		JFrameAdd.getContentPane().add(btnAdicionar);
		
		JLabel lblGenero = new JLabel("G\u00EAnero:");
		lblGenero.setToolTipText("Informe qual \u00E9 o g\u00EAnero do filme!");
		lblGenero.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblGenero.setBounds(10, 59, 83, 20);
		JFrameAdd.getContentPane().add(lblGenero);
		
		JLabel lblPais = new JLabel("Pa\u00EDs:");
		lblPais.setToolTipText("Informe qual \u00E9 o pa\u00EDs do filme!");
		lblPais.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPais.setBounds(10, 109, 46, 14);
		JFrameAdd.getContentPane().add(lblPais);
		
		JLabel lblAno = new JLabel("Ano:");
		lblAno.setToolTipText("Informe qual \u00E9 o ano do filme!");
		lblAno.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAno.setBounds(10, 157, 46, 14);
		JFrameAdd.getContentPane().add(lblAno);
		
		JTextField	textFieldGenero = new JTextField();
		textFieldGenero.setToolTipText("Informe qual \u00E9 o g\u00EAnero do filme!");
		textFieldGenero.setBackground(new Color(192,192,192));
		textFieldGenero.setBounds(87, 59, 337, 20);
		JFrameAdd.getContentPane().add(textFieldGenero);
		textFieldGenero.setColumns(10);
		
		JTextField textFieldPais = new JTextField();
		textFieldPais.setToolTipText("Informe qual \u00E9 o pa\u00EDs de origem(lan\u00E7amento) do filme!");
		textFieldPais.setBackground(new Color(192,192,192));
		textFieldPais.setBounds(87, 106, 337, 20);
		JFrameAdd.getContentPane().add(textFieldPais);
		textFieldPais.setColumns(10);
		
		JTextField textFieldAno = new JTextField();
		textFieldAno.setToolTipText("Informe qual \u00E9 o ano de lan\u00E7amento do filme!");
		textFieldAno.setBackground(new Color(192,192,192));
		textFieldAno.setBounds(87, 154, 130, 20);
		JFrameAdd.getContentPane().add(textFieldAno);
		textFieldAno.setColumns(10);
		
		JButton btnProcurar = new JButton("Procurar");
		btnProcurar.setToolTipText("Clique sobre para procurar o filme em seu sistema.");
		btnProcurar.setBackground(new Color(107,107,107));
		btnProcurar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnProcurar.setBounds(309, 185, 115, 23);
		JFrameAdd.getContentPane().add(btnProcurar);
		
		JTextField textFieldProcurar = new JTextField();
		textFieldProcurar.setToolTipText("Diret\u00F3rio onde o filme est\u00E1 localizado.");
		textFieldProcurar.setBackground(new Color(192,192,192));
		textFieldProcurar.setBounds(10, 185, 289, 20);
		JFrameAdd.getContentPane().add(textFieldProcurar);
		textFieldProcurar.setColumns(10);
		
		JTextField textFieldDuracao = new JTextField();
		textFieldDuracao.setToolTipText("Informe qual \u00E9 a dura\u00E7\u00E3o do filme(em minutos)!");
		textFieldDuracao.setColumns(10);
		textFieldDuracao.setBackground(Color.LIGHT_GRAY);
		textFieldDuracao.setBounds(304, 151, 130, 20);
		JFrameAdd.getContentPane().add(textFieldDuracao);
		
		JLabel lblDuracao = new JLabel("Dura\u00E7\u00E3o:");
		lblDuracao.setToolTipText("");
		lblDuracao.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDuracao.setBounds(227, 154, 72, 14);
		JFrameAdd.getContentPane().add(lblDuracao);
		
		
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
		
		//Jbutton de procurar endereço do arquivo no pc
		//
		//
		btnProcurar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				    if(e.getSource() == btnProcurar) {  
				    	JFileChooser file = new JFileChooser(); 
				    	JFrameAdd.setAlwaysOnTop(false);
				        file.setFileSelectionMode(JFileChooser.FILES_ONLY);
				        int i= file.showSaveDialog(null);
				      if (i==1){
				          textFieldProcurar.setText("");
				      } else {
				          File arquivo = file.getSelectedFile();
				          textFieldProcurar.setText(arquivo.getPath());
				      }
				    
				}
			}
		});

		
		//Jbuttons para fazer a escolha do tipo de arquivo.
		//se for serie, filme ou anime

		btnAnimes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    if(e.getSource() == btnAnimes) {  
			        JFrameSelecao.dispose();
			        tipo = "Anime";
			        JFrameAdd.setVisible(true);
			    
			}
		}
	});
		
		
		btnSeries.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    if(e.getSource() == btnSeries) {  
			        JFrameSelecao.dispose();
			        tipo = "serie";
			        JFrameAdd.setVisible(true);
			    
			}
		}
	});
		
		btnFilmes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    if(e.getSource() == btnFilmes) {  
			        JFrameSelecao.dispose();
			        tipo = "filme";
			        JFrameAdd.setVisible(true);
			    
			}
		}
	});
		//Função de mover o arquivo para o diretorio do programa.
		//a função esta no br.edu.pii.tecaplay.util.FileUtil
		

		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
			    	FileUtil fileUtil = new FileUtil();
			    	String origem = textFieldProcurar.getText();
			    	String ano = textFieldAno.getText();
			    	String nome = textFieldTitulo.getText();
			    	String genero = textFieldGenero.getText();
			    	String pais = textFieldPais.getText();
			    	String duracao = textFieldDuracao.getText();
			    	
			   
			    	JFrameAdd.setAlwaysOnTop(false); 

		    		fileUtil.AddFilme(origem,ano,nome,genero,tipo,usrName);
			 //Limpa os campos de escrita
		    		
			    		textFieldGenero.setText("");
				    	textFieldPais.setText("");
				    	textFieldAno.setText("");
				    	textFieldProcurar.setText("");
				    	textFieldTitulo.setText("");
				    	textFieldDuracao.setText("");
			}

	});
		
	}
	
}
