package br.edu.pii.tecaplay.ui;

import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import br.edu.pii.tecaplay.util.ArrayCategorias;
import br.edu.pii.tecaplay.util.GetNameSeries;
import br.edu.pii.tecaplay.util.MoveArquivosPasta;
import br.edu.pii.tecaplay.util.MoveFile;
import br.edu.pii.tecaplay.util.ValidaPasta;

/**
 * 
 * @author matheus
 * @since 04/04/2016
 * @version 0.0.55
 */

public class FilmesAdd {
	/**
	 * janela para verificacao de serie ou filme
	 * 
	 * @param usrName
	 *            nome do usu�rio atualmente logado
	 */
	private String caminho = null;
	ArrayCategorias arrayCat = new ArrayCategorias();

	public FilmesAdd(String usrName) {
		/** Janela principal para Filmes, definido cor, tamanho, posi��o... */
		JFrame JFrameSelecao = new JFrame();
		JFrameSelecao.setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		JFrameSelecao.setAlwaysOnTop(true);
		JFrameSelecao.setResizable(false);
		JFrameSelecao.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		JFrameSelecao.setTitle("Add V�deo - TecaPlay");
		JFrameSelecao.setIconImage(Toolkit.getDefaultToolkit().getImage("resources\\images\\newLogo.png"));
		JFrameSelecao.getContentPane().setBackground(new Color(169, 169, 169));
		JFrameSelecao.getContentPane().setForeground(Color.WHITE);
		JFrameSelecao.getContentPane().setLayout(null);
		JFrameSelecao.setVisible(true);
		JFrameSelecao.setSize(205, 140);
		JFrameSelecao.setLocationRelativeTo(null);
		JFrameSelecao.setAlwaysOnTop(false);

		/** Bot�o S�ries, definido cor, tamanho, posi��o... */
		Button btnSeries = new Button("S�ries");
		btnSeries.setSize(200, 150);
		btnSeries.setBackground(Color.LIGHT_GRAY);
		btnSeries.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnSeries.setForeground(new Color(0, 0, 0));
		btnSeries.setBounds(10, 10, 180, 40);
		JFrameSelecao.getContentPane().add(btnSeries);

		/** Bot�o FIlmes, definido cor, tamanho, posi��o... */
		Button btnFilmes = new Button("Filmes");
		btnFilmes.setSize(200, 150);
		btnFilmes.setBackground(Color.LIGHT_GRAY);
		btnFilmes.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnFilmes.setForeground(new Color(0, 0, 0));
		btnFilmes.setBounds(10, 60, 180, 40);
		JFrameSelecao.getContentPane().add(btnFilmes);

		/**
		 * 
		 * 
		 * Fun��o Bot�es * Fun��o Bot�es * Fun��o Bot�es * Fun��o Bot�es *
		 * Fun��o Bot�es * Fun��o Bot�es
		 */

		/**
		 * A��o do bot�o S�ries, caso acionado o bot�o, ser� aberta a op��o para
		 * adicionar...
		 */
		btnSeries.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btnSeries) {
					JFrameSelecao.dispose();
					try {
						AddSerie(usrName);
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}

				}
			}
		});

		/**
		 * A��o do bot�o Filmes, caso acionado o bot�o, ser� aberta a op��o para
		 * adicionar...
		 */
		btnFilmes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btnFilmes) {
					JFrameSelecao.dispose();
					AddFilme(usrName);

				}
			}
		});
		// Jbutton de procurar endere�o do arquivo no pc
		//
		//

	}

	public void AddFilme(String usrName) {

		/**
		 * 
		 * JFRAME ADD FILMES JFRAME ADD FILMES JFRAME ADD FILMES JFRAME ADD
		 * FILMES JFRAME ADD FILMES JFRAME ADD FILMES JFRAME ADD FILMES
		 */

		/**
		 * Janela principal para Adicionar Filmes, definido cor, tamanho,
		 * posi��o, imagem...
		 */
		JFrame JFrameAddFilme = new JFrame();
		JFrameAddFilme.setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		JFrameAddFilme.setAlwaysOnTop(true);
		JFrameAddFilme.setResizable(false);
		JFrameAddFilme.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		JFrameAddFilme.setTitle("Add Filmes - TecaPlay");
		JFrameAddFilme.setIconImage(Toolkit.getDefaultToolkit().getImage("resources\\images\\newLogo.png"));
		JFrameAddFilme.getContentPane().setBackground(new Color(169, 169, 169));
		JFrameAddFilme.getContentPane().setForeground(Color.WHITE);
		JFrameAddFilme.getContentPane().setLayout(null);
		JFrameAddFilme.setVisible(true);
		JFrameAddFilme.setSize(440, 230);
		JFrameAddFilme.setLocationRelativeTo(null);

		/** T�tulo do filme, definido cor, tamanho, posi��o, imagem... */
		JLabel lblTituloFilme = new JLabel("T\u00EDtulo*:");
		lblTituloFilme.setToolTipText("Informe qual \u00E9 o t\u00EDtulo do filme!");
		lblTituloFilme.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTituloFilme.setBounds(10, 20, 59, 17);
		JFrameAddFilme.getContentPane().add(lblTituloFilme);

		/**
		 * T�tulo do filme, espa�o dedicado para pedir o nome do filme a ser
		 * adicionado, definido cor, tamanho, posi��o, imagem...
		 */
		JTextField textFieldTituloFilme = new JTextField();
		textFieldTituloFilme.setToolTipText("Informe qual \u00E9 o t\u00EDtulo do filme!");
		textFieldTituloFilme.setBackground(new Color(192, 192, 192));
		textFieldTituloFilme.setBounds(85, 20, 337, 20);
		JFrameAddFilme.getContentPane().add(textFieldTituloFilme);
		textFieldTituloFilme.setColumns(10);

		/** G�nero do filme, definido cor, tamanho, posi��o, imagem... */
		JLabel lblGeneroFilme = new JLabel("G\u00EAnero*:");
		lblGeneroFilme.setToolTipText("Informe qual \u00E9 o g\u00EAnero do filme!");
		lblGeneroFilme.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblGeneroFilme.setBounds(10, 50, 83, 20);
		JFrameAddFilme.getContentPane().add(lblGeneroFilme);

		JComboBox<String> panelListGenero = new JComboBox<String>();
		ArrayList<String>  listGeneroFilmes = arrayCat.addFilmes();
		panelListGenero.setBackground(Color.LIGHT_GRAY);
		System.out.println(listGeneroFilmes);
		panelListGenero.setFont(new Font("Tahoma", Font.BOLD, 13));
		panelListGenero.setForeground(Color.BLACK);
		panelListGenero.addItem("Selecione");
		for (int i = 0; i < listGeneroFilmes.size(); i++) {
			panelListGenero.addItem(listGeneroFilmes.get(i));
		}
		panelListGenero.setMaximumRowCount(15);
		panelListGenero.setEditable(false);
		panelListGenero.setBounds(85, 50, 337, 20);
		JFrameAddFilme.getContentPane().add(panelListGenero);
		/**
		 * Pa�s de origem do filme, definido cor, tamanho, posi��o, imagem...
		 */
		JLabel lblPaisFilme = new JLabel("Pa\u00EDs*:");
		lblPaisFilme.setToolTipText("Informe qual \u00E9 o pa\u00EDs do filme!");
		lblPaisFilme.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPaisFilme.setBounds(10, 80, 46, 14);
		JFrameAddFilme.getContentPane().add(lblPaisFilme);

		/** Ano do filme, definido cor, tamanho, posi��o, imagem... */
		JLabel lblAnoFilme = new JLabel("Ano*:");
		lblAnoFilme.setToolTipText("Informe qual \u00E9 o ano do filme!");
		lblAnoFilme.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAnoFilme.setBounds(10, 110, 46, 14);
		JFrameAddFilme.getContentPane().add(lblAnoFilme);

		/**
		 * Origem do filme,espa�o dedicado para mostrar local de origem do
		 * filme, definido cor, tamanho, posi��o, imagem...
		 */
		JTextField textFieldPaisFilme = new JTextField();
		textFieldPaisFilme.setToolTipText("Informe qual \u00E9 o pa\u00EDs de origem(lan\u00E7amento) do filme!");
		textFieldPaisFilme.setBackground(new Color(192, 192, 192));
		textFieldPaisFilme.setBounds(85, 80, 337, 20);
		JFrameAddFilme.getContentPane().add(textFieldPaisFilme);
		textFieldPaisFilme.setColumns(10);

		/**
		 * ComboBox para mostrar anos dos filmes � partir de 1955 at� o ano
		 * atual 2016...
		 */
		JComboBox<String> panelListAno = new JComboBox<String>();
		ArrayList<String> listaAno = new ArrayList<>();
		for (int i = 2016; i > 1955; i--) {
			String s = null;
			s = "" + i;
			listaAno.add(s);
		}
		panelListAno.setBackground(Color.LIGHT_GRAY);
		panelListAno.setFont(new Font("Tahoma", Font.BOLD, 13));
		panelListAno.setForeground(Color.BLACK);
		for (int i = 0; i < listaAno.size(); i++) {
			panelListAno.addItem(listaAno.get(i));
		}
		panelListAno.setMaximumRowCount(15);
		panelListAno.setEditable(false);
		panelListAno.setBounds(85, 110, 130, 20);
		JFrameAddFilme.getContentPane().add(panelListAno);

		/**
		 * Bot�o Procurar Filme, bot�o para procurar filme existente no sistema,
		 * definido cor, tamanho, posi��o, imagem...
		 */
		JButton btnProcurarFilme = new JButton("Procurar*");
		btnProcurarFilme.setToolTipText("Clique sobre para procurar o filme em seu sistema.");
		btnProcurarFilme.setBackground(new Color(107, 107, 107));

		btnProcurarFilme.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnProcurarFilme.setBounds(310, 140, 112, 23);
		JFrameAddFilme.getContentPane().add(btnProcurarFilme);

		/**
		 * Espa�o para o diret�rio do filme, definido cor, tamanho, posi��o,
		 * imagem...
		 */
		JTextField textFieldProcurarFilme = new JTextField();
		textFieldProcurarFilme.setToolTipText("Diret\u00F3rio onde o filme est\u00E1 localizado.");
		textFieldProcurarFilme.setBackground(new Color(192, 192, 192));
		textFieldProcurarFilme.setBounds(10, 140, 289, 20);
		textFieldProcurarFilme.setEditable(false);
		JFrameAddFilme.getContentPane().add(textFieldProcurarFilme);
		textFieldProcurarFilme.setColumns(10);

		/**
		 * Espa�o dedicado para mostrar dura��o do filme, definido cor, tamanho,
		 * posi��o, imagem...
		 */
		JTextField textFieldDuracaoFilme = new JTextField();
		textFieldDuracaoFilme.setToolTipText("Informe qual \u00E9 a dura\u00E7\u00E3o do filme(em minutos)!");
		textFieldDuracaoFilme.setColumns(10);
		textFieldDuracaoFilme.setBackground(Color.LIGHT_GRAY);
		textFieldDuracaoFilme.setBounds(301, 110, 120, 20);
		JFrameAddFilme.getContentPane().add(textFieldDuracaoFilme);

		/** Dura��o do filme, definido cor, tamanho, posi��o, imagem... */
		JLabel lblDuracaoFilme = new JLabel("Dura\u00E7\u00E3o*:");
		lblDuracaoFilme.setToolTipText("");
		lblDuracaoFilme.setFont(new Font("Tahoma", Font.BOLD, 14));

		lblDuracaoFilme.setBounds(227, 110, 72, 14);
		JFrameAddFilme.getContentPane().add(lblDuracaoFilme);

		/**
		 * Bot�o Procurar Filme, caso selecionado, procura-se no sistema onde o
		 * filme est� e seleciona.
		 */
		btnProcurarFilme.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btnProcurarFilme) {
					JFileChooser file = new JFileChooser();
					JFrameAddFilme.setAlwaysOnTop(false);
					file.setFileSelectionMode(JFileChooser.FILES_ONLY);
					int i = file.showSaveDialog(null);
					if (i == 1) {
						textFieldProcurarFilme.setText("");
					} else {
						File arquivo = file.getSelectedFile();
						textFieldProcurarFilme.setText(arquivo.getPath());
					}

				}
			}
		});

		// Fun��o de mover o arquivo para o diretorio do programa.
		// a fun��o esta no br.edu.pii.tecaplay.util.FileUtil
		/**
		 * A��o do Bot�o Cancelar, caso acionado far� com que cancele uma a��o
		 * realizada
		 */

		JButton btnCancelarFilme = new JButton("Cancelar");
		btnCancelarFilme.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btnCancelarFilme) {
					JFrameAddFilme.dispose();

				}
			}
		});

		/** Bot�o Cancelar, definido cor, tamanho, posi��o, imagem... */
		btnCancelarFilme.setBackground(new Color(107, 107, 107));
		btnCancelarFilme.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCancelarFilme.setBounds(10, 170, 200, 23);
		JFrameAddFilme.getContentPane().add(btnCancelarFilme);

		/** Bot�o Adicionar Filme, definido cor, tamanho, posi��o, imagem... */

		JButton btnAdicionarFilme = new JButton("Adicionar");
		btnAdicionarFilme.setToolTipText("Adicionar o filme a biblioteca!");
		btnAdicionarFilme.setBackground(new Color(107, 107, 107));
		btnAdicionarFilme.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAdicionarFilme.setBounds(215, 170, 207, 23);
		JFrameAddFilme.getContentPane().add(btnAdicionarFilme);

		JFrameAddFilme.setFocusTraversalPolicy(
				new FocusTraversalOnArray(new Component[] { textFieldTituloFilme, panelListGenero, textFieldPaisFilme,
						panelListAno, textFieldDuracaoFilme, btnProcurarFilme, btnCancelarFilme, btnAdicionarFilme }));

		btnAdicionarFilme.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MoveFile MoveFile = new MoveFile();
				String genero = (String) panelListGenero.getSelectedItem();
				// faz o texte se a pessoa selecionou algum genero.
				if (!(genero == "Selecione")) {
					String origem = textFieldProcurarFilme.getText();
					String ano = (String) panelListAno.getSelectedItem();
					caminho = textFieldProcurarFilme.getText();
					String nome = textFieldTituloFilme.getText();
					String pais = textFieldPaisFilme.getText();
					String duracao = textFieldDuracaoFilme.getText();
					// testa se existem fildtexts em branco
					if (new File(origem).exists() && ValidationFormat()) {
						if (!(origem.equals("") || (ano.equals("")) || (duracao.equals("")) || (nome.equals(""))
								|| (pais.equals("")))) {
							JFrameAddFilme.setAlwaysOnTop(false);
							// Executa o comando de mover o arquivo e renomealo.
							boolean sucesso = MoveFile.AddFilme(origem, ano, nome, genero, duracao, pais, usrName);
							// Limpa os campos de escrita
							if (sucesso) {
								panelListGenero.setSelectedIndex(0);
								textFieldPaisFilme.setText("");
								panelListAno.setSelectedIndex(0);
								textFieldProcurarFilme.setText("");
								textFieldTituloFilme.setText("");
								textFieldDuracaoFilme.setText("");
								JOptionPane.showMessageDialog(JFrameAddFilme, "Arquivos Movidos com sucesso!",
										"Sucesso", 1);
							} else {
								JOptionPane.showMessageDialog(JFrameAddFilme,
										"N�o foi possivel executar essa opera��o, tente novamente", "Erro", 0);
							}
						} // ELSE DO TERCEIRO IF
						else {
							JOptionPane.showMessageDialog(JFrameAddFilme,
									"Por favor, preenche todos os campos com o Asterisco *", "Preencha todos os campos",
									0);
						}

					} else { // ELSE DO SEGUNDO IF
						JOptionPane.showMessageDialog(JFrameAddFilme, "Informe algum arquivo de v�deo v�lido",
								"Informe diret�rio Correto", 0);
						textFieldProcurarFilme.setText("");
					}
				}
				// ELSE DO PRIMEIRO IF
				else {
					JOptionPane.showMessageDialog(JFrameAddFilme, "Por favor, selecione o componente g�nero",
							"Selecione o Genero", 0);

				}
			}

		});

	}

	/**
	 * 
	 * @param usrName
	 *            Nome do usuario que est� logado
	 * @throws InterruptedException
	 */
	public void AddSerie(String usrName) throws InterruptedException {

		JFrame JFrameAddSerie = new JFrame();
		JFrameAddSerie.setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		JFrameAddSerie.setAlwaysOnTop(true);
		JFrameAddSerie.setResizable(false);
		JFrameAddSerie.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		JFrameAddSerie.setTitle("Add S�ries - TecaPlay");
		JFrameAddSerie.setIconImage(Toolkit.getDefaultToolkit().getImage("resources\\images\\newLogo.png"));
		JFrameAddSerie.getContentPane().setBackground(new Color(169, 169, 169));
		JFrameAddSerie.getContentPane().setForeground(Color.WHITE);
		JFrameAddSerie.getContentPane().setLayout(null);
		JFrameAddSerie.setVisible(true);
		JFrameAddSerie.setSize(440, 300);
		JFrameAddSerie.setLocationRelativeTo(null);

		/** T�tulo da S�rie, definido cor, tamanho, posi��o, imagem... */
		JLabel lblTituloSerie = new JLabel("Seriado*:");
		lblTituloSerie.setToolTipText("Informe qual \u00E9 o t\u00EDtulo da S�rie!");
		lblTituloSerie.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTituloSerie.setBounds(10, 22, 59, 17);
		JFrameAddSerie.getContentPane().add(lblTituloSerie);

		/**
		 * Local para mostrar t�tulo da s�rie, definido cor, tamanho, posi��o,
		 * imagem...
		 */
		/**
		 * JTextField textFieldTituloSerie = new JTextField();
		 * textFieldTituloSerie.setToolTipText(
		 * "Informe qual \u00E9 o t\u00EDtulo da S�rie!");
		 * textFieldTituloSerie.setBackground(new Color(192, 192, 192));
		 * textFieldTituloSerie.setBounds(87, 19, 337, 20);
		 * JFrameAddSerie.getContentPane().add(textFieldTituloSerie);
		 * textFieldTituloSerie.setColumns(10);
		 */

		JComboBox<String> panelListTitulo = new JComboBox<String>();
		ArrayList<String> listaTitulo = new ArrayList<String>();
		int numOfPart0 = 0;
		GetNameSeries getNameSeries = new GetNameSeries(usrName, numOfPart0);
		listaTitulo = getNameSeries.RetornoArray();
		panelListTitulo.setBackground(Color.LIGHT_GRAY);
		panelListTitulo.setFont(new Font("Tahoma", Font.BOLD, 13));
		panelListTitulo.setForeground(Color.BLACK);
		for (int i = 0; i < listaTitulo.size(); i++) {
			panelListTitulo.addItem(listaTitulo.get(i));
		}
		panelListTitulo.setMaximumRowCount(15);
		panelListTitulo.setEditable(true);
		panelListTitulo.setBounds(87, 19, 337, 20);
		JFrameAddSerie.getContentPane().add(panelListTitulo);

		/**
		 * Local para informar t�tulo da s�rie, definido cor, tamanho, posi��o,
		 * imagem...
		 */
		JLabel lblGeneroSerie = new JLabel("G\u00EAnero*:");
		lblGeneroSerie.setToolTipText("Informe qual \u00E9 o g\u00EAnero da S�rie!");
		lblGeneroSerie.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblGeneroSerie.setBounds(10, 50, 83, 20);
		JFrameAddSerie.getContentPane().add(lblGeneroSerie);

		/**
		 * ComboBox para mostrar tipos de filmes que podem ser selecionados...
		 */
		JComboBox<String> panelListGenero = new JComboBox<String>();
		ArrayList<String> listaGenero = arrayCat.addSeries();
		panelListGenero.addItem("Selecione");
		panelListGenero.setBackground(Color.LIGHT_GRAY);
		panelListGenero.setFont(new Font("Tahoma", Font.BOLD, 13));
		panelListGenero.setForeground(Color.BLACK);
		for (int i = 0; i < listaGenero.size(); i++) {
			panelListGenero.addItem(listaGenero.get(i));
		}
		panelListGenero.setMaximumRowCount(15);
		panelListGenero.setEditable(false);
		panelListGenero.setBounds(87, 50, 337, 20);
		JFrameAddSerie.getContentPane().add(panelListGenero);

		panelListTitulo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<String> listaTitulo2 = new ArrayList<String>();
				int numOfPart1 = 1;
				GetNameSeries getNameSeries = new GetNameSeries(usrName, numOfPart1);
				listaTitulo2 = getNameSeries.RetornoArray();
				int acao = panelListTitulo.getSelectedIndex();
				for (int j = 0; j < listaGenero.size(); j++) {
					String teste = listaGenero.get(j);
					teste = teste.toLowerCase();
					if (teste.equals(listaTitulo2.get(acao))) {
						panelListGenero.setSelectedIndex(j+1);
						break;
					}
				}
			}
		});

		/** Nome do epis�dio, definido cor, tamanho, posi��o, imagem... */
		JLabel lblNomeEpisodio = new JLabel("Nome do Epis�dio*:");
		lblNomeEpisodio.setToolTipText("Informe o nome do epis�dio.");
		lblNomeEpisodio.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNomeEpisodio.setBounds(10, 85, 150, 17);
		JFrameAddSerie.getContentPane().add(lblNomeEpisodio);

		/**
		 * Espa�o dedicado para mostrar o nome do epis�dio, definido cor,
		 * tamanho, posi��o, imagem...
		 */
		JTextField txtFieldNomeEp = new JTextField();
		txtFieldNomeEp.setToolTipText("Insira aqui o nome do epis�dio.");
		txtFieldNomeEp.setBackground(new Color(192, 192, 192));
		txtFieldNomeEp.setBounds(143, 85, 280, 20);
		JFrameAddSerie.getContentPane().add(txtFieldNomeEp);
		txtFieldNomeEp.setColumns(10);

		/** N�mero da Temporada, definido cor, tamanho, posi��o, imagem... */
		JLabel lblNumTemporada = new JLabel("Temporada*:");
		lblNumTemporada.setToolTipText("Informe qual \u00E9 o Numero da Temporada:!");
		lblNumTemporada.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNumTemporada.setBounds(10, 151, 96, 14);
		JFrameAddSerie.getContentPane().add(lblNumTemporada);

		/** ComboBox para mostrar n�mero da temporada. */
		JComboBox<String> panelListTemporada = new JComboBox<String>();
		ArrayList<String> listaTemporada = new ArrayList<>();
		for (int i = 1; i < 50; i++) {
			String s = null;
			if (i < 10) {
				s = "0" + i;
			} else {
				s = "" + i;
			}
			listaTemporada.add(s);
		}
		panelListTemporada.setBackground(Color.LIGHT_GRAY);
		panelListTemporada.setFont(new Font("Tahoma", Font.BOLD, 13));
		panelListTemporada.setForeground(Color.BLACK);
		for (int i = 0; i < listaTemporada.size(); i++) {
			panelListTemporada.addItem(listaTemporada.get(i));
		}
		panelListTemporada.setMaximumRowCount(15);
		panelListTemporada.setEditable(false);
		panelListTemporada.setBounds(110, 151, 60, 20);
		JFrameAddSerie.getContentPane().add(panelListTemporada);

		/** N�mero do epis�dio, definido cor, tamanho, posi��o, imagem... */
		JLabel lblEpisodio = new JLabel("Epis�dio*:");
		lblEpisodio.setToolTipText("Informe qual \u00E9 o Epis�dio da S�rie!");
		lblEpisodio.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEpisodio.setBounds(10, 116, 76, 14);
		JFrameAddSerie.getContentPane().add(lblEpisodio);

		/** ComboBox para mostrar lista de epis�dios */
		JComboBox<String> panelListEpisodio = new JComboBox<String>();
		ArrayList<String> listaEpis�dio = new ArrayList<>();
		for (int i = 1; i < 50; i++) {
			String s = null;
			if (i < 10) {
				s = "0" + i;
			} else {
				s = "" + i;
			}
			listaEpis�dio.add(s);
		}
		panelListEpisodio.setBackground(Color.LIGHT_GRAY);
		panelListEpisodio.setFont(new Font("Tahoma", Font.BOLD, 13));
		panelListEpisodio.setForeground(Color.BLACK);
		for (int i = 0; i < listaEpis�dio.size(); i++) {
			panelListEpisodio.addItem(listaEpis�dio.get(i));
		}
		panelListEpisodio.setMaximumRowCount(15);
		panelListEpisodio.setEditable(false);
		panelListEpisodio.setBounds(89, 116, 60, 20);
		JFrameAddSerie.getContentPane().add(panelListEpisodio);

		/** Bot�o Procura de filme, definido cor, tamanho, posi��o, imagem... */
		JButton btnProcurarFilme = new JButton("Procurar");
		btnProcurarFilme.setToolTipText("Clique sobre para procurar a S�rie em seu sistema.");
		btnProcurarFilme.setBackground(new Color(107, 107, 107));
		btnProcurarFilme.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnProcurarFilme.setBounds(309, 205, 115, 23);
		JFrameAddSerie.getContentPane().add(btnProcurarFilme);

		JLabel lblinfoProcurar = new JLabel("Informe algum diret�rio do windows ou um arquivo");
		lblinfoProcurar.setToolTipText("");
		lblinfoProcurar.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblinfoProcurar.setBounds(10, 180, 450, 20);
		JFrameAddSerie.getContentPane().add(lblinfoProcurar);

		/** Espa�o dedicado , definido cor, tamanho, posi��o, imagem... */
		JTextField textFieldProcurarFilme = new JTextField();
		textFieldProcurarFilme.setToolTipText("Diret\u00F3rio onde a s�rie est\u00E1 localizado.");
		textFieldProcurarFilme.setBackground(new Color(192, 192, 192));
		textFieldProcurarFilme.setBounds(10, 205, 289, 20);
		textFieldProcurarFilme.setEditable(false);
		JFrameAddSerie.getContentPane().add(textFieldProcurarFilme);
		textFieldProcurarFilme.setColumns(10);

		/** Dura��o do Filme, definido cor, tamanho, posi��o, imagem... */
		JLabel lblDuracaoFilme = new JLabel("Dura\u00E7\u00E3o*:");
		lblDuracaoFilme.setToolTipText("");
		lblDuracaoFilme.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDuracaoFilme.setBounds(227, 151, 72, 14);
		JFrameAddSerie.getContentPane().add(lblDuracaoFilme);

		/**
		 * Espa�o para mostrar tempo do filme, definido cor, tamanho, posi��o,
		 * imagem...
		 */
		JTextField textFieldDuracaoFilme = new JTextField();
		textFieldDuracaoFilme.setToolTipText("Informe qual \u00E9 a dura\u00E7\u00E3o do filme(em minutos)!");
		textFieldDuracaoFilme.setColumns(10);
		textFieldDuracaoFilme.setBackground(Color.LIGHT_GRAY);
		textFieldDuracaoFilme.setBounds(304, 151, 118, 20);
		JFrameAddSerie.getContentPane().add(textFieldDuracaoFilme);

		/**
		 * A��o do bot�o Cancelar S�rie, caso selecionado acionara o
		 * cancelamento da a��o, definido cor, tamanho, posi��o, imagem...
		 */
		JButton btnCancelarSerie = new JButton("Cancelar");
		btnCancelarSerie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btnCancelarSerie) {
					JFrameAddSerie.dispose();

				}
			}
		});
		btnCancelarSerie.setBackground(new Color(107, 107, 107));
		btnCancelarSerie.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCancelarSerie.setBounds(10, 235, 207, 23);
		JFrameAddSerie.getContentPane().add(btnCancelarSerie);

		/** Bot�o Adicionar S�rie, definido cor, tamanho, posi��o, imagem... */
		JButton btnAdicionarSerie = new JButton("Adicionar");
		btnAdicionarSerie.setToolTipText("Adicionar o filme a biblioteca!");
		btnAdicionarSerie.setBackground(new Color(107, 107, 107));
		btnAdicionarSerie.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAdicionarSerie.setBounds(217, 235, 207, 23);
		JFrameAddSerie.getContentPane().add(btnAdicionarSerie);

		/**
		 * Bot�o de Procura de Filme, acionando-o, pode-se mostar o diret�rio do
		 * filme no sistema.
		 */
		btnProcurarFilme.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btnProcurarFilme) {
					JFileChooser file = new JFileChooser();
					JFrameAddSerie.setAlwaysOnTop(false);
					file.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
					int i = file.showSaveDialog(null);
					if (i == 1) {
						textFieldProcurarFilme.setText("");
					} else {
						File arquivo = file.getSelectedFile();
						textFieldProcurarFilme.setText(arquivo.getPath());
					}

				}
			}
		});

		/** Bot�o Adicionar s�rie. */
		btnAdicionarSerie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String genero = (String) panelListGenero.getSelectedItem();
				// faz o texte se a pessoa selecionou algum genero.
				if (!(genero == "Selecione")) {
					String origem = textFieldProcurarFilme.getText();
					caminho = textFieldProcurarFilme.getText();
					String numTemp = (String) panelListTemporada.getSelectedItem();
					String nomeEp = txtFieldNomeEp.getText();
					String nome = (String) panelListTitulo.getSelectedItem();
					String numEpisodio = (String) panelListEpisodio.getSelectedItem();
					String duracao = textFieldDuracaoFilme.getText();
					boolean ehNumero;
					try {
						int duracaoInt = (Integer.parseInt(textFieldDuracaoFilme.getText()));
						ehNumero = true;
					} catch (NumberFormatException e1) {
						ehNumero = false;
					}
					// if pra fazer o teste se � um diretorio valido
					if (new File(origem).exists()) {
						boolean verificaPasta = false;
						ValidaPasta pasta = new ValidaPasta();
						verificaPasta = pasta.validaPasta(origem);
						// Se for true, significa que � pasta, se n�o � apenas
						// um arquivo
						if (ehNumero) {
							if (!((numTemp.equals("")) || (nomeEp.equals("")) || (nome.equals(""))
									|| (duracao.equals("")) || (numEpisodio.equals("")))) {
								if (verificaPasta) {
									JFrameAddSerie.setAlwaysOnTop(false);
									// Executa o comando de mover o arquivo e
									// renomealo.
									MoveArquivosPasta MoveFile = new MoveArquivosPasta();
									boolean sucesso = MoveFile.MovePasta(origem, numTemp, nome, nomeEp, genero, duracao,
											numEpisodio, usrName);

									if (sucesso) {
										// Limpa os campos de escrita
									
										JOptionPane.showMessageDialog(JFrameAddSerie,
												"Os arquivos foram movidos com Sucesso", "Sucesso", 1);
										JFrameAddSerie.dispose();
									} else {
										JOptionPane.showMessageDialog(JFrameAddSerie,
												"Os arquivos n�o foram movidos com Sucesso\n"
														+ "� possivel que existem pastas ou outros arquivos dentro\n"
														+ "Por favor, selecione uma pasta contendo somente arquivos de v�deo.",
												"Erro na c�pia dos Arquivos", 0);
									}
								} else {
									if (ValidationFormat()) {
										JFrameAddSerie.setAlwaysOnTop(false);
										MoveFile MoveFile = new MoveFile();
										// Executa o comando de mover o arquivo
										// e
										// renomealo.
										boolean sucesso = MoveFile.AddSerie(origem, numTemp, nome, nomeEp, genero,
												duracao, numEpisodio, usrName);
										// Limpa os campos de escrita
										if (sucesso) {
											JOptionPane.showMessageDialog(JFrameAddSerie,
													"Arquivos Movidos com sucesso!", "Sucesso", 1);
											JFrameAddSerie.dispose();
										} else {
											JOptionPane.showMessageDialog(JFrameAddSerie,
													"N�o foi possivel executar essa opera��o, tente novamente\n"
															+ "Verefique se � realmente um filme",
													"Erro", 0);
										}
									} else {
										JOptionPane.showMessageDialog(JFrameAddSerie,
												"Arquivo n�o compativel com o formato de v�deo", "Erro de Formato", 0);
									}
								}

							} else {
								JFrameAddSerie.setAlwaysOnTop(false);
								JOptionPane.showMessageDialog(JFrameAddSerie,
										"Por favor, preenche todos os campos com o Asterisco *",
										"Preencha todos os campos", 0);
							}
						} else {
							JOptionPane.showMessageDialog(JFrameAddSerie,
									"Por favor, Informe um horario aproximado do\n"
											+ "filme ou das s�rie, em Minutos arredondado");
						}
					} else {
						JFrameAddSerie.setAlwaysOnTop(false);
						JOptionPane.showMessageDialog(JFrameAddSerie, "Selecione a pasta certa",
								"Pasta ou arquivo inv�lido", 0);
					}
				} else {
					JOptionPane.showMessageDialog(JFrameAddSerie, "Por favor, selecione o componente g�nero",
							"Selecione o Genero", 0);

				}
			}

		});

	}

	public boolean ValidationFormat() {
		File destino = new File(caminho);
		ArrayList<String> array = new ArrayList<String>();
		array.add(".MKV");
		array.add(".flv");
		array.add(".avi");
		array.add(".mov");
		array.add(".wmv");
		array.add(".rmvb");
		array.add(".vob");
		array.add(".cam");
		array.add(".mp4");
		String extensao = destino.getName().substring(destino.getName().lastIndexOf('.', destino.getName().length()));
		for (int i = 0; i < array.size(); i++) {
			if (extensao.equals(array.get(i))) {
				return true;
			}
		}

		return false;
	}
	

}
