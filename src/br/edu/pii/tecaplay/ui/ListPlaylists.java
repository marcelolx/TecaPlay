package br.edu.pii.tecaplay.ui;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;

import br.edu.pii.tecaplay.util.AddPlaylist;

public class ListPlaylists {
	private ArrayList<String> dados;
	private ArrayList<String> diretorio;
	private String userName = null;
	private String directorie = null;
	private String strDados = null;
	private String catType;

	public ListPlaylists(String usrName, String caminho, String catTypeP) {
		strDados = caminho;
		userName = usrName;
		catType = catTypeP;
		JFrame panel = new JFrame();
		panel.setTitle("Adicionar \u00E0 Playlist");
		panel.setIconImage(
				Toolkit.getDefaultToolkit().getImage(ListPlaylists.class.getResource("/images/newLogo.png")));
		panel.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		panel.setAlwaysOnTop(true);
		panel.setVisible(true);
		panel.setSize(new Dimension(400, 300));
		panel.setLocationRelativeTo(null);
		panel.getContentPane().setLayout(null);

		JButton btnAdicionar = new JButton("Adicionar nova Playlist");
		btnAdicionar.setBounds(28, 227, 148, 23);
		panel.getContentPane().add(btnAdicionar);
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panel.dispose();
				String nome = JOptionPane.showInputDialog("Informe o nome da Playlist a ser Criada");
				@SuppressWarnings("unused")
				AddPlaylist add = new AddPlaylist(usrName, nome, caminho, catTypeP);
			}
		});

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panel.dispose();
				panel.setVisible(false);
			}
		});
		btnCancelar.setBounds(186, 227, 89, 23);
		panel.getContentPane().add(btnCancelar);

		listPlaylist();

		DefaultListModel<String> model = new DefaultListModel<String>();
		JList<String> list = new JList<String>(model);
		for (int i = 0; i < dados.size(); i++) {
			model.add(i, dados.get(i));
		}
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setBounds(10, 11, 364, 205);
		list.setFont(new Font("Microsoft YaHei UI", Font.ITALIC, 14));
		panel.getContentPane().add(list);

		JButton btnAvancar = new JButton("Adicionar");
		btnAvancar.setBounds(285, 227, 89, 23);
		panel.getContentPane().add(btnAvancar);
		btnAvancar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = list.getSelectedIndex();
				directorie = diretorio.get(i);
				if (writeTxt()) {
					JOptionPane.showMessageDialog(panel, "Adicionado com sucesso na playlist " + dados.get(i));
					panel.dispose();
				} else {
					JOptionPane.showMessageDialog(panel, "O arquivo já está na Playlist,\n"
							+ "se não estiver tente novamente.");
				}
			}
		});

	}

	public void listPlaylist() {
		String filePath;
		if(catType.equals("Videos")){
			filePath = "c:\\TecaPlay\\" + userName + "\\" + catType + "\\Favoritos";
		}else{
			filePath = "c:\\TecaPlay\\" + userName + "\\" + catType + "\\Playlist";
		}
		File test = new File(filePath);
		if (!test.exists()) {
			test.mkdir();
		}
		File[] list = test.listFiles();

		System.out.println(list.length);
		dados = new ArrayList<>();
		diretorio = new ArrayList<>();
		for (int i = 0; i < list.length; i++) {
			String name = list[i].getName();
			dados.add(name);
			diretorio.add(list[i].getAbsolutePath());
			System.out.println(dados.get(i) + diretorio.get(i));
		}

	}

	public boolean writeTxt() {

		String criarTxt = directorie;
		boolean isAdded = false;
		try {
			FileReader fr = new FileReader(criarTxt);
			BufferedReader br = new BufferedReader(fr);
			String line = null;
			while ((line = br.readLine()) != null) {
				if(line.equals(strDados)){
					isAdded = true;
					break;
				}
			}
			fr.close();
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		//se não estiver na playlist ainda, então adiciona-a.
		if (!isAdded) {
			// grava as informaões no txt
			try {
				FileWriter buffer = null;
				buffer = new FileWriter(criarTxt, true);
				String text = strDados;
				buffer.write(text + "\r\n");
				buffer.close();
				return true;
			} catch (IOException e21) {
				e21.printStackTrace();
			}
		}

		return false;
	}
}
