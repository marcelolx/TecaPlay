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

import br.edu.pii.tecaplay.util.MoveArquivosPasta;
import br.edu.pii.tecaplay.util.MoveFile;
import br.edu.pii.tecaplay.util.optimizationgui.ArrayCategorias;
import br.edu.pii.tecaplay.util.validators.GetNameSeries;
import br.edu.pii.tecaplay.util.validators.ValidaPasta;

/**
 * 
 * @author Matheus
 * @since 04/04/2016
 */

public class FilmesAdd {
	/**
	 * 
	 * @param usrName
	 *            Name of user logged.
	 */
	private String caminho = null;

	public FilmesAdd(String usrName) {
		JFrame JFrameSelecao = new JFrame();
		JFrameSelecao.setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		JFrameSelecao.setAlwaysOnTop(true);
		JFrameSelecao.setResizable(false);
		JFrameSelecao.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		JFrameSelecao.setTitle("Add Vídeo - TecaPlay");
		JFrameSelecao.setIconImage(Toolkit.getDefaultToolkit().getImage("resources\\images\\newLogo.png"));
		JFrameSelecao.getContentPane().setBackground(new Color(169, 169, 169));
		JFrameSelecao.getContentPane().setForeground(Color.WHITE);
		JFrameSelecao.getContentPane().setLayout(null);
		JFrameSelecao.setVisible(true);
		JFrameSelecao.setSize(205, 140);
		JFrameSelecao.setLocationRelativeTo(null);
		JFrameSelecao.setAlwaysOnTop(false);

		Button btnSeries = new Button("Séries");
		btnSeries.setSize(200, 150);
		btnSeries.setBackground(Color.LIGHT_GRAY);
		btnSeries.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnSeries.setForeground(new Color(0, 0, 0));
		btnSeries.setBounds(10, 10, 180, 40);
		JFrameSelecao.getContentPane().add(btnSeries);

		Button btnFilmes = new Button("Filmes");
		btnFilmes.setSize(200, 150);
		btnFilmes.setBackground(Color.LIGHT_GRAY);
		btnFilmes.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnFilmes.setForeground(new Color(0, 0, 0));
		btnFilmes.setBounds(10, 60, 180, 40);
		JFrameSelecao.getContentPane().add(btnFilmes);

		btnSeries.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btnSeries) {
					JFrameSelecao.dispose();
					try {
						addSerie(usrName);
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}

				}
			}
		});

		btnFilmes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btnFilmes) {
					JFrameSelecao.dispose();
					addFilme(usrName);

				}
			}
		});
	}

	public void addFilme(String usrName) {

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

		JLabel lblTituloFilme = new JLabel("T\u00EDtulo*:");
		lblTituloFilme.setToolTipText("Informe qual \u00E9 o t\u00EDtulo do filme!");
		lblTituloFilme.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTituloFilme.setBounds(10, 20, 59, 17);
		JFrameAddFilme.getContentPane().add(lblTituloFilme);

		JTextField textFieldTituloFilme = new JTextField();
		textFieldTituloFilme.setToolTipText("Informe qual \u00E9 o t\u00EDtulo do filme!");
		textFieldTituloFilme.setBackground(new Color(192, 192, 192));
		textFieldTituloFilme.setBounds(85, 20, 337, 20);
		JFrameAddFilme.getContentPane().add(textFieldTituloFilme);
		textFieldTituloFilme.setColumns(10);

		JLabel lblGeneroFilme = new JLabel("G\u00EAnero*:");
		lblGeneroFilme.setToolTipText("Informe qual \u00E9 o g\u00EAnero do filme!");
		lblGeneroFilme.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblGeneroFilme.setBounds(10, 50, 83, 20);
		JFrameAddFilme.getContentPane().add(lblGeneroFilme);

		JComboBox<String> panelListGenero = new JComboBox<String>();
		ArrayList<String> listGeneroFilmes = ArrayCategorias.addFilmes();
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
		JLabel lblPaisFilme = new JLabel("Pa\u00EDs*:");
		lblPaisFilme.setToolTipText("Informe qual \u00E9 o pa\u00EDs do filme!");
		lblPaisFilme.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPaisFilme.setBounds(10, 80, 46, 14);
		JFrameAddFilme.getContentPane().add(lblPaisFilme);

		JLabel lblAnoFilme = new JLabel("Ano*:");
		lblAnoFilme.setToolTipText("Informe qual \u00E9 o ano do filme!");
		lblAnoFilme.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAnoFilme.setBounds(10, 110, 46, 14);
		JFrameAddFilme.getContentPane().add(lblAnoFilme);

		JTextField textFieldPaisFilme = new JTextField();
		textFieldPaisFilme.setToolTipText("Informe qual \u00E9 o pa\u00EDs de origem(lan\u00E7amento) do filme!");
		textFieldPaisFilme.setBackground(new Color(192, 192, 192));
		textFieldPaisFilme.setBounds(85, 80, 337, 20);
		JFrameAddFilme.getContentPane().add(textFieldPaisFilme);
		textFieldPaisFilme.setColumns(10);

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

		JButton btnProcurarFilme = new JButton("Procurar*");
		btnProcurarFilme.setToolTipText("Clique sobre para procurar o filme em seu sistema.");
		btnProcurarFilme.setBackground(new Color(107, 107, 107));

		btnProcurarFilme.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnProcurarFilme.setBounds(310, 140, 112, 23);
		JFrameAddFilme.getContentPane().add(btnProcurarFilme);

		JTextField textFieldProcurarFilme = new JTextField();
		textFieldProcurarFilme.setToolTipText("Diret\u00F3rio onde o filme est\u00E1 localizado.");
		textFieldProcurarFilme.setBackground(new Color(192, 192, 192));
		textFieldProcurarFilme.setBounds(10, 140, 289, 20);
		textFieldProcurarFilme.setEditable(false);
		JFrameAddFilme.getContentPane().add(textFieldProcurarFilme);
		textFieldProcurarFilme.setColumns(10);

		JTextField textFieldDuracaoFilme = new JTextField();
		textFieldDuracaoFilme.setToolTipText("Informe qual \u00E9 a dura\u00E7\u00E3o do filme(em minutos)!");
		textFieldDuracaoFilme.setColumns(10);
		textFieldDuracaoFilme.setBackground(Color.LIGHT_GRAY);
		textFieldDuracaoFilme.setBounds(301, 110, 120, 20);
		JFrameAddFilme.getContentPane().add(textFieldDuracaoFilme);

		JLabel lblDuracaoFilme = new JLabel("Dura\u00E7\u00E3o*:");
		lblDuracaoFilme.setToolTipText("");
		lblDuracaoFilme.setFont(new Font("Tahoma", Font.BOLD, 14));

		lblDuracaoFilme.setBounds(227, 110, 72, 14);
		JFrameAddFilme.getContentPane().add(lblDuracaoFilme);

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

		JButton btnCancelarFilme = new JButton("Cancelar");
		btnCancelarFilme.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btnCancelarFilme) {
					JFrameAddFilme.dispose();

				}
			}
		});
		btnCancelarFilme.setBackground(new Color(107, 107, 107));
		btnCancelarFilme.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCancelarFilme.setBounds(10, 170, 200, 23);
		JFrameAddFilme.getContentPane().add(btnCancelarFilme);

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
					if (new File(origem).exists() && validationFormat()) {
						if (!(origem.equals("") || (ano.equals("")) || (duracao.equals("")) || (nome.equals(""))
								|| (pais.equals("")))) {
							JFrameAddFilme.setAlwaysOnTop(false);
							// remove and rename file.
							boolean sucesso = MoveFile.addFilme(origem, ano, nome, genero, duracao, pais, usrName);
							// clear textfield if sucess to move and rename
							// file.
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
										"Não foi possivel executar essa operação, tente novamente", "Erro", 0);
							}
						} else {
							JOptionPane.showMessageDialog(JFrameAddFilme,
									"Por favor, preenche todos os campos com o Asterisco *", "Preencha todos os campos",
									0);
						}
					} else {
						JOptionPane.showMessageDialog(JFrameAddFilme, "Informe algum arquivo de vídeo válido",
								"Informe diretório Correto", 0);
						textFieldProcurarFilme.setText("");
					}
				} else {
					JOptionPane.showMessageDialog(JFrameAddFilme, "Por favor, selecione o componente gênero",
							"Selecione o Genero", 0);
				}
			}

		});

	}

	/**
	 * Usado para adicinar séries na aplicação.
	 * 
	 * @param usrName
	 *            User logged.
	 * @throws InterruptedException
	 */
	public void addSerie(String usrName) throws InterruptedException {

		JFrame JFrameAddSerie = new JFrame();
		JFrameAddSerie.setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		JFrameAddSerie.setAlwaysOnTop(true);
		JFrameAddSerie.setResizable(false);
		JFrameAddSerie.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		JFrameAddSerie.setTitle("Add Séries - TecaPlay");
		JFrameAddSerie.setIconImage(Toolkit.getDefaultToolkit().getImage("resources\\images\\newLogo.png"));
		JFrameAddSerie.getContentPane().setBackground(new Color(169, 169, 169));
		JFrameAddSerie.getContentPane().setForeground(Color.WHITE);
		JFrameAddSerie.getContentPane().setLayout(null);
		JFrameAddSerie.setVisible(true);
		JFrameAddSerie.setSize(440, 300);
		JFrameAddSerie.setLocationRelativeTo(null);

		JLabel lblTituloSerie = new JLabel("Seriado*:");
		lblTituloSerie.setToolTipText("Informe qual \u00E9 o t\u00EDtulo da Série!");
		lblTituloSerie.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTituloSerie.setBounds(10, 22, 59, 17);
		JFrameAddSerie.getContentPane().add(lblTituloSerie);

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

		JLabel lblGeneroSerie = new JLabel("G\u00EAnero*:");
		lblGeneroSerie.setToolTipText("Informe qual \u00E9 o g\u00EAnero da Série!");
		lblGeneroSerie.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblGeneroSerie.setBounds(10, 50, 83, 20);
		JFrameAddSerie.getContentPane().add(lblGeneroSerie);

		JComboBox<String> panelListGenero = new JComboBox<String>();
		ArrayList<String> listaGenero = ArrayCategorias.addSeries();
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
						panelListGenero.setSelectedIndex(j + 1);
						break;
					}
				}
			}
		});

		JLabel lblNomeEpisodio = new JLabel("Nome do Episódio*:");
		lblNomeEpisodio.setToolTipText("Informe o nome do episódio.");
		lblNomeEpisodio.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNomeEpisodio.setBounds(10, 85, 150, 17);
		JFrameAddSerie.getContentPane().add(lblNomeEpisodio);

		JTextField txtFieldNomeEp = new JTextField();
		txtFieldNomeEp.setToolTipText("Insira aqui o nome do episódio.");
		txtFieldNomeEp.setBackground(new Color(192, 192, 192));
		txtFieldNomeEp.setBounds(143, 85, 280, 20);
		JFrameAddSerie.getContentPane().add(txtFieldNomeEp);
		txtFieldNomeEp.setColumns(10);

		JLabel lblNumTemporada = new JLabel("Temporada*:");
		lblNumTemporada.setToolTipText("Informe qual \u00E9 o Numero da Temporada:!");
		lblNumTemporada.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNumTemporada.setBounds(10, 151, 96, 14);
		JFrameAddSerie.getContentPane().add(lblNumTemporada);

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

		JLabel lblEpisodio = new JLabel("Episódio*:");
		lblEpisodio.setToolTipText("Informe qual \u00E9 o Episódio da Série!");
		lblEpisodio.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEpisodio.setBounds(10, 116, 76, 14);
		JFrameAddSerie.getContentPane().add(lblEpisodio);

		JComboBox<String> panelListaEpisodio = new JComboBox<String>();
		ArrayList<String> listaEpisódio = new ArrayList<>();
		for (int i = 1; i < 50; i++) {
			String s = null;
			if (i < 10) {
				s = "0" + i;
			} else {
				s = "" + i;
			}
			listaEpisódio.add(s);
		}
		panelListaEpisodio.setBackground(Color.LIGHT_GRAY);
		panelListaEpisodio.setFont(new Font("Tahoma", Font.BOLD, 13));
		panelListaEpisodio.setForeground(Color.BLACK);
		for (int i = 0; i < listaEpisódio.size(); i++) {
			panelListaEpisodio.addItem(listaEpisódio.get(i));
		}
		panelListaEpisodio.setMaximumRowCount(15);
		panelListaEpisodio.setEditable(false);
		panelListaEpisodio.setBounds(89, 116, 60, 20);
		JFrameAddSerie.getContentPane().add(panelListaEpisodio);

		JButton btnProcurarFilme = new JButton("Procurar");
		btnProcurarFilme.setToolTipText("Clique sobre para procurar a Série em seu sistema.");
		btnProcurarFilme.setBackground(new Color(107, 107, 107));
		btnProcurarFilme.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnProcurarFilme.setBounds(309, 205, 115, 23);
		JFrameAddSerie.getContentPane().add(btnProcurarFilme);

		JLabel lblinfoProcurar = new JLabel("Informe algum diretório do windows ou um arquivo");
		lblinfoProcurar.setToolTipText("");
		lblinfoProcurar.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblinfoProcurar.setBounds(10, 180, 450, 20);
		JFrameAddSerie.getContentPane().add(lblinfoProcurar);

		JTextField textFieldProcurarFilme = new JTextField();
		textFieldProcurarFilme.setToolTipText("Diret\u00F3rio onde a série est\u00E1 localizado.");
		textFieldProcurarFilme.setBackground(new Color(192, 192, 192));
		textFieldProcurarFilme.setBounds(10, 205, 289, 20);
		textFieldProcurarFilme.setEditable(false);
		JFrameAddSerie.getContentPane().add(textFieldProcurarFilme);
		textFieldProcurarFilme.setColumns(10);

		JLabel lblDuracaoFilme = new JLabel("Dura\u00E7\u00E3o*:");
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
				if (e.getSource() == btnCancelarSerie) {
					JFrameAddSerie.dispose();

				}
			}
		});
		btnCancelarSerie.setBackground(new Color(107, 107, 107));
		btnCancelarSerie.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCancelarSerie.setBounds(10, 235, 207, 23);
		JFrameAddSerie.getContentPane().add(btnCancelarSerie);

		JButton btnAdicionarSerie = new JButton("Adicionar");
		btnAdicionarSerie.setToolTipText("Adicionar o filme a biblioteca!");
		btnAdicionarSerie.setBackground(new Color(107, 107, 107));
		btnAdicionarSerie.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAdicionarSerie.setBounds(217, 235, 207, 23);
		JFrameAddSerie.getContentPane().add(btnAdicionarSerie);

		/**
		 * Button for search movie file.
		 */
		btnProcurarFilme.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btnProcurarFilme) {
					JFileChooser file = new JFileChooser();
					JFrameAddSerie.setAlwaysOnTop(false);
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

		btnAdicionarSerie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String genero = (String) panelListGenero.getSelectedItem();
				if (!(genero == "Selecione")) {
					String origem = textFieldProcurarFilme.getText();
					caminho = textFieldProcurarFilme.getText();
					String numTemp = (String) panelListTemporada.getSelectedItem();
					String nomeEp = txtFieldNomeEp.getText();
					String nome = (String) panelListTitulo.getSelectedItem();
					String numEpisodio = (String) panelListaEpisodio.getSelectedItem();
					String duracao = textFieldDuracaoFilme.getText();
					boolean ehNumero;
					try {
						@SuppressWarnings("unused")
						int duracaoInt = (Integer.parseInt(textFieldDuracaoFilme.getText()));
						ehNumero = true;
					} catch (NumberFormatException e1) {
						ehNumero = false;
					}
					// if directorie is valid
					if (new File(origem).exists()) {
						boolean verificaPasta = false;
						ValidaPasta pasta = new ValidaPasta();
						verificaPasta = pasta.validaPasta(origem);
						// If true, is directorie, else any file
						if (ehNumero) {
							if (!((numTemp.equals("")) || (nomeEp.equals("")) || (nome.equals(""))
									|| (duracao.equals("")) || (numEpisodio.equals("")))) {
								if (verificaPasta) {
									JFrameAddSerie.setAlwaysOnTop(false);
									// Move and rename file
									MoveArquivosPasta MoveFile = new MoveArquivosPasta();
									boolean sucesso = MoveFile.movePasta(origem, numTemp, nome, nomeEp, genero, duracao,
											numEpisodio, usrName);

									if (sucesso) {
										JOptionPane.showMessageDialog(JFrameAddSerie,
												"Os arquivos foram movidos com Sucesso", "Sucesso", 1);
										JFrameAddSerie.dispose();
									} else {
										JOptionPane.showMessageDialog(JFrameAddSerie,
												"Os arquivos não foram movidos com Sucesso\n"
														+ "É possivel que existem pastas ou outros arquivos dentro\n"
														+ "Por favor, selecione uma pasta contendo somente arquivos de vídeo.",
												"Erro na cópia dos Arquivos", 0);
									}
								} else {
									if (validationFormat()) {
										JFrameAddSerie.setAlwaysOnTop(false);
										MoveFile MoveFile = new MoveFile();
										// Move and rename file
										boolean sucesso = MoveFile.addSerie(origem, numTemp, nome, nomeEp, genero,
												duracao, numEpisodio, usrName);
										if (sucesso) {
											JOptionPane.showMessageDialog(JFrameAddSerie,
													"Arquivos Movidos com sucesso!", "Sucesso", 1);
											JFrameAddSerie.dispose();
										} else {
											JOptionPane.showMessageDialog(JFrameAddSerie,
													"Não foi possivel executar essa operação, tente novamente\n"
															+ "Verefique se é realmente um filme",
													"Erro", 0);
										}
									} else {
										JOptionPane.showMessageDialog(JFrameAddSerie,
												"Arquivo não compativel com o formato de vídeo", "Erro de Formato", 0);
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
											+ "filme ou das série, em Minutos arredondado");
						}
					} else {
						JFrameAddSerie.setAlwaysOnTop(false);
						JOptionPane.showMessageDialog(JFrameAddSerie, "Selecione a pasta certa",
								"Pasta ou arquivo inválido", 0);
					}
				} else {
					JOptionPane.showMessageDialog(JFrameAddSerie, "Por favor, selecione o componente gênero",
							"Selecione o Genero", 0);

				}
			}

		});

	}

	/**
	 * Validate files
	 * 
	 * @return true or false
	 */
	public boolean validationFormat() {
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
