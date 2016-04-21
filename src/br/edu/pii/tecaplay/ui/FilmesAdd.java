package br.edu.pii.tecaplay.ui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dialog.ModalExclusionType;

public class FilmesAdd {
	private JTextField textFieldTitulo;
	private JTextField textFieldGenero;
	private JTextField textFieldPais;
	private JTextField textFieldAno;
	private JTextField textFieldProcurar;
	private JTextField textFieldDuracao;
	public void Topo(){};
	public FilmesAdd(){ 
		JFrame fadd = new JFrame();
		fadd.setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		fadd.setAlwaysOnTop(true);
		fadd.setResizable(false);
		fadd.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		fadd.setTitle("Add Filmes - TecaPlay");
		fadd.setIconImage(Toolkit.getDefaultToolkit().getImage("resources\\images\\newLogo.png"));
		fadd.getContentPane().setBackground(new Color(169,169,169));
		fadd.getContentPane().setForeground(Color.WHITE);
		fadd.getContentPane().setLayout(null);
		fadd.setVisible(true);
		fadd.setSize(450, 300);
		fadd.setLocationRelativeTo(null);
		
		
		JLabel lblTitulo = new JLabel("T\u00EDtulo:");
		lblTitulo.setToolTipText("Informe qual \u00E9 o t\u00EDtulo do filme!");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTitulo.setBounds(10, 22, 59, 17);
		fadd.getContentPane().add(lblTitulo);
		
		textFieldTitulo = new JTextField();
		textFieldTitulo.setToolTipText("Informe qual \u00E9 o t\u00EDtulo do filme!");
		textFieldTitulo.setBackground(new Color(192,192,192));
		textFieldTitulo.setBounds(87, 19, 337, 20);
		fadd.getContentPane().add(textFieldTitulo);
		textFieldTitulo.setColumns(10);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				    if(e.getSource() == btnCancelar) {  
				        fadd.dispose();
				    
				}
			}
		});
		btnCancelar.setBackground(new Color(107,107,107));
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCancelar.setBounds(10, 227, 207, 23);
		fadd.getContentPane().add(btnCancelar);
		
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setToolTipText("Adicionar o filme a biblioteca!");
		btnAdicionar.setBackground(new Color(107,107,107));
		btnAdicionar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAdicionar.setBounds(217, 227, 207, 23);
		fadd.getContentPane().add(btnAdicionar);
		
		JLabel lblGenero = new JLabel("G\u00EAnero:");
		lblGenero.setToolTipText("Informe qual \u00E9 o g\u00EAnero do filme!");
		lblGenero.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblGenero.setBounds(10, 59, 83, 20);
		fadd.getContentPane().add(lblGenero);
		
		JLabel lblPais = new JLabel("Pa\u00EDs:");
		lblPais.setToolTipText("Informe qual \u00E9 o pa\u00EDs do filme!");
		lblPais.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPais.setBounds(10, 109, 46, 14);
		fadd.getContentPane().add(lblPais);
		
		JLabel lblAno = new JLabel("Ano:");
		lblAno.setToolTipText("Informe qual \u00E9 o ano do filme!");
		lblAno.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAno.setBounds(10, 157, 46, 14);
		fadd.getContentPane().add(lblAno);
		
		textFieldGenero = new JTextField();
		textFieldGenero.setToolTipText("Informe qual \u00E9 o g\u00EAnero do filme!");
		textFieldGenero.setBackground(new Color(192,192,192));
		textFieldGenero.setBounds(87, 59, 337, 20);
		fadd.getContentPane().add(textFieldGenero);
		textFieldGenero.setColumns(10);
		
		textFieldPais = new JTextField();
		textFieldPais.setToolTipText("Informe qual \u00E9 o pa\u00EDs de origem(lan\u00E7amento) do filme!");
		textFieldPais.setBackground(new Color(192,192,192));
		textFieldPais.setBounds(87, 106, 337, 20);
		fadd.getContentPane().add(textFieldPais);
		textFieldPais.setColumns(10);
		
		textFieldAno = new JTextField();
		textFieldAno.setToolTipText("Informe qual \u00E9 o ano de lan\u00E7amento do filme!");
		textFieldAno.setBackground(new Color(192,192,192));
		textFieldAno.setBounds(87, 154, 130, 20);
		fadd.getContentPane().add(textFieldAno);
		textFieldAno.setColumns(10);
		
		JButton btnProcurar = new JButton("Procurar");
		btnProcurar.setToolTipText("Clique sobre para procurar o filme em seu sistema.");
		btnProcurar.setBackground(new Color(107,107,107));
		btnProcurar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnProcurar.setBounds(309, 185, 115, 23);
		fadd.getContentPane().add(btnProcurar);
		
		textFieldProcurar = new JTextField();
		textFieldProcurar.setToolTipText("Diret\u00F3rio onde o filme est\u00E1 localizado.");
		textFieldProcurar.setBackground(new Color(192,192,192));
		textFieldProcurar.setBounds(10, 185, 289, 20);
		fadd.getContentPane().add(textFieldProcurar);
		textFieldProcurar.setColumns(10);
		
		textFieldDuracao = new JTextField();
		textFieldDuracao.setToolTipText("Informe qual \u00E9 a dura\u00E7\u00E3o do filme(em minutos)!");
		textFieldDuracao.setColumns(10);
		textFieldDuracao.setBackground(Color.LIGHT_GRAY);
		textFieldDuracao.setBounds(304, 151, 130, 20);
		fadd.getContentPane().add(textFieldDuracao);
		
		JLabel lblDuracao = new JLabel("Dura\u00E7\u00E3o:");
		lblDuracao.setToolTipText("");
		lblDuracao.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDuracao.setBounds(227, 154, 72, 14);
		fadd.getContentPane().add(lblDuracao);
	}
}
