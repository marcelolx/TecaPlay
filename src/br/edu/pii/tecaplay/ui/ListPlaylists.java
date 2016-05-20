package br.edu.pii.tecaplay.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;

import br.edu.pii.tecaplay.util.AddPlaylist;

import javax.swing.AbstractListModel;
import java.awt.Font;

public class ListPlaylists {
	private ArrayList<String> dados ;
	private ArrayList<String> diretorio ;
	private String userName = null;
	private String directorie = null;
	private String strDados = null;
	
	
	public ListPlaylists(String usrName, String caminho){
	strDados = caminho;
	userName = usrName;
	JFrame panel = new JFrame();
	panel.setTitle("Adicionar \u00E0 Playlist");
	panel.setIconImage(Toolkit.getDefaultToolkit().getImage(ListPlaylists.class.getResource("/images/newLogo.png")));
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
			AddPlaylist add = new AddPlaylist(usrName, nome, caminho);
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

	
	DefaultListModel model = new DefaultListModel();
	JList list = new JList(model);
	for (int i = 0; i < dados.size(); i++) {
		model.add(i, dados.get(i));
	}
	list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	list.setBounds(10, 11, 364, 205);
	list.setFont(new Font("Microsoft YaHei UI", Font.ITALIC, 14));
	panel.getContentPane().add(list);
	
	JButton btnAvancar = new JButton("Avan\u00E7ar");
	btnAvancar.setBounds(285, 227, 89, 23);
	panel.getContentPane().add(btnAvancar);
	btnAvancar.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			int i = list.getSelectedIndex();
			directorie = diretorio.get(i);
			if(writeTxt()){
				JOptionPane.showMessageDialog(panel, "Adicionado com sucesso na playlist " + dados.get(i));
				panel.dispose();
			}else{
				JOptionPane.showMessageDialog(panel, "Erro ao salvar na playlist. Tente novamente");
			}
		}
	});
	
	}
	
	public void listPlaylist(){
		File test = new File("c:\\TecaPlay\\" + userName + "\\Musicas\\Playlist");
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
		
		//grava as informaões no txt
		try{
			FileWriter buffer = null;
			buffer = new FileWriter(criarTxt, true);
			String text = strDados;
			buffer.write(text+"\r\n");
			buffer.close();
			return true;
		}catch(IOException e21){
		}
		
		return false;
		
	}
}
