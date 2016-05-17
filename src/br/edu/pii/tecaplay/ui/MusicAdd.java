package br.edu.pii.tecaplay.ui;

import java.awt.Color;
import java.awt.Component;
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

import br.edu.pii.tecaplay.util.MoveMusic;

/**
 * 
 * @author jonas
 * @since 17/05/2016
 */
/**
 * 
 * Contrutor para a criação da janela de adicionar Musicas
 *
 */
public class MusicAdd {
	private JTextField fieldNameMusic;
	private JTextField fieldArtista;
	private JTextField textFieldAno;
	private JTextField textFieldProcurar;
	private String caminho;

	public MusicAdd(String usrName) {
		JFrame frame = new JFrame();
		frame.setResizable(false);
		frame.setAlwaysOnTop(true);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setTitle("Adicionar Músicas - TecaPlay");
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("resources\\images\\newLogo.png"));
		frame.getContentPane().setBackground(new Color(169, 169, 169));
		frame.getContentPane().setForeground(Color.WHITE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		frame.setSize(436, 287);
		frame.setLocationRelativeTo(null);

		JLabel lblNameMusic = new JLabel("Nome:");
		lblNameMusic.setToolTipText("Informe qual \u00E9 o nome da M\u00FAsica!");
		lblNameMusic.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNameMusic.setBounds(10, 22, 59, 17);
		frame.getContentPane().add(lblNameMusic);

		fieldNameMusic = new JTextField();
		fieldNameMusic.setToolTipText("Informe qual \u00E9 o nome da Música!");
		fieldNameMusic.setBackground(new Color(192, 192, 192));
		fieldNameMusic.setBounds(87, 19, 337, 20);
		frame.getContentPane().add(fieldNameMusic);
		fieldNameMusic.setColumns(10);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBackground(new Color(107, 107, 107));
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCancelar.setBounds(10, 227, 191, 23);
		frame.getContentPane().add(btnCancelar);

		JButton btnAdicionar = new JButton("Adicionar");

		btnAdicionar.setBackground(new Color(107, 107, 107));
		btnAdicionar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAdicionar.setBounds(233, 227, 191, 23);
		frame.getContentPane().add(btnAdicionar);

		JLabel lblGenero = new JLabel("Gen\u00EAro:");
		lblGenero.setToolTipText("Informe qual \u00E9 o Gen\u00EAro da M\u00FAsica!");
		lblGenero.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblGenero.setBounds(10, 59, 83, 20);
		frame.getContentPane().add(lblGenero);

		JLabel lblArtist = new JLabel("Artista:");
		lblArtist.setToolTipText("Informe qual \u00E9 o nome do Artisa/Banda M\u00FAsica!");
		lblArtist.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblArtist.setBounds(10, 104, 59, 14);
		frame.getContentPane().add(lblArtist);

		JLabel lblAno = new JLabel("Ano:");
		lblAno.setToolTipText("Informe qual \u00E9 o ano da M\u00FAsica!");
		lblAno.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAno.setBounds(10, 145, 59, 14);
		frame.getContentPane().add(lblAno);

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
		panelListAno.setBounds(87, 144, 337, 20);
		frame.getContentPane().add(panelListAno);

		JComboBox<String> panelListGenero = new JComboBox<String>();
		ArrayList<String> listaGenero = new ArrayList<>();
		listaGenero.add("Selecione");
		listaGenero.add("Antigas");
		listaGenero.add("Axé");
		listaGenero.add("Black");
		listaGenero.add("Brega");
		listaGenero.add("Dance");
		listaGenero.add("Eletrônica");
		listaGenero.add("Funk");
		listaGenero.add("Forró");
		listaGenero.add("Folclóricas");
		listaGenero.add("Gospel");
		listaGenero.add("Internacionais");
		listaGenero.add("Modas de Viola");
		listaGenero.add("Novas");
		listaGenero.add("Pagode");
		listaGenero.add("Romantica");
		listaGenero.add("Reagge");
		listaGenero.add("Samba");
		listaGenero.add("Sertaneja");
		panelListGenero.setBackground(Color.LIGHT_GRAY);
		panelListGenero.setFont(new Font("Tahoma", Font.BOLD, 13));
		panelListGenero.setForeground(Color.BLACK);
		for (int i = 0; i < listaGenero.size(); i++) {
			panelListGenero.addItem(listaGenero.get(i));
		}
		panelListGenero.setMaximumRowCount(15);
		panelListGenero.setEditable(false);
		panelListGenero.setBounds(87, 59, 337, 20);
		frame.getContentPane().add(panelListGenero);

		fieldArtista = new JTextField();
		fieldArtista.setToolTipText("Informe qual \u00E9 o artista/banda da Música!");
		fieldArtista.setBackground(new Color(192, 192, 192));
		fieldArtista.setBounds(87, 103, 337, 20);
		frame.getContentPane().add(fieldArtista);
		fieldArtista.setColumns(10);

		JButton btnProcurar = new JButton("Procurar");
		btnProcurar.setBackground(new Color(107, 107, 107));
		btnProcurar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnProcurar.setBounds(309, 185, 115, 23);
		frame.getContentPane().add(btnProcurar);

		textFieldProcurar = new JTextField();
		textFieldProcurar.setToolTipText("Informe do diretório da música a ser procurada!");
		textFieldProcurar.setBackground(new Color(192, 192, 192));
		textFieldProcurar.setEditable(false);
		textFieldProcurar.setBounds(10, 188, 289, 20);
		frame.getContentPane().add(textFieldProcurar);
		textFieldProcurar.setColumns(10);
		frame.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[] { fieldNameMusic, panelListGenero,
				fieldArtista, textFieldAno, btnProcurar, btnCancelar, btnAdicionar }));

		// Ação do botão procurar que abrirar um FileChooser
		btnProcurar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btnProcurar) {
					JFileChooser file = new JFileChooser();
					frame.setAlwaysOnTop(false);
					file.setFileSelectionMode(JFileChooser.FILES_ONLY);
					int i = file.showSaveDialog(null);
					if (i == 1) {
						textFieldProcurar.setText("");
					} else {
						File arquivo = file.getSelectedFile();
						textFieldProcurar.setText(arquivo.getPath());
					}

				}
			}
		});

		// Ação do botão Adicionar
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = fieldNameMusic.getText();
				String genero = (String) panelListGenero.getSelectedItem();
				String artista = fieldArtista.getText();
				String ano = (String) panelListAno.getSelectedItem();
				caminho = textFieldProcurar.getText();
				if (new File(caminho).exists()) {
					if (!(nome.equals("") || artista.equals("") || genero.equals("Selecione") || ano.equals("")
							|| ano.equals(""))) {
						if (ValidationFormat()) {
							MoveMusic moveMusic = new MoveMusic();
							boolean sucess = moveMusic.AddMusica(caminho, ano, nome, genero, usrName, artista);
							if (sucess) {
								JOptionPane.showMessageDialog(frame,"Arquivo Movido com sucesso para sua biblioteca","Sucesso",1);
							}else{
								JOptionPane.showMessageDialog(frame, "Arquivo não foi movido com sucesso para sua biblioteca \n"
										+ "Tente Novamente", "Erro", 0);
							}
						} else {
							JOptionPane.showMessageDialog(frame, "Arquivo não compativel com Música", "Erro", 0);
						}
					} else {
						JOptionPane.showMessageDialog(frame, "Existem espaços não preenchidos", "Erro", 0);
					}

				} else {
					JOptionPane.showMessageDialog(frame, "Arquivo não Existente", "Erro", 0);
				}
			}
		});

		// Ação do botão Cancelar
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btnCancelar) {
					frame.dispose();

				}
			}
		});

	}

	public boolean ValidationFormat() {
		File destino = new File(caminho);
		ArrayList<String> array = new ArrayList<String>();
		array.add(".mp3");
		array.add(".wav");
		array.add(".aac");
		array.add(".m4a");
		array.add(".wma");
		String extensao = destino.getName().substring(destino.getName().lastIndexOf('.', destino.getName().length()));
		for (int i = 0; i < array.size(); i++) {
			if (extensao.equals(array.get(i))) {
				return true;
			}
		}

		return false;
	}
}
