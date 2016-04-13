package br.edu.pii.tecaplay.ui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;

public class FilmesAdd {
	private JTextField textFieldTipo;
	private JTextField textFieldCategoria;
	private JTextField textFieldNome;
	private JTextField textFieldAno;
	private JTextField textFieldProcurar;
	public FilmesAdd(){
		JFrame fadd = new JFrame();
		fadd.setTitle("Filmes - TecaPlay");
		fadd.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Matheus\\git\\tecaplay\\resources\\images\\newLogo.png"));
		fadd.getContentPane().setBackground(new Color(169,169,169));
		fadd.getContentPane().setForeground(Color.WHITE);
		fadd.getContentPane().setLayout(null);
		fadd.setVisible(true);
		fadd.setSize(450, 300);
		fadd.setLocationRelativeTo(null);
		
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setToolTipText("Informe qual \u00E9 o tipo do filme!");
		lblTipo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTipo.setBounds(10, 22, 59, 17);
		fadd.getContentPane().add(lblTipo);
		
		textFieldTipo = new JTextField();
		textFieldTipo.setToolTipText("Informe qual \u00E9 o tipo do filme!");
		textFieldTipo.setBackground(new Color(192,192,192));
		textFieldTipo.setBounds(87, 19, 337, 20);
		fadd.getContentPane().add(textFieldTipo);
		textFieldTipo.setColumns(10);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBackground(new Color(107,107,107));
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCancelar.setBounds(10, 227, 207, 23);
		fadd.getContentPane().add(btnCancelar);
		
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setBackground(new Color(107,107,107));
		btnAdicionar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAdicionar.setBounds(217, 227, 207, 23);
		fadd.getContentPane().add(btnAdicionar);
		
		JLabel lblCategoria = new JLabel("Categoria:");
		lblCategoria.setToolTipText("Informe qual \u00E9 a categoria do filme!");
		lblCategoria.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCategoria.setBounds(10, 59, 83, 20);
		fadd.getContentPane().add(lblCategoria);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setToolTipText("Informe qual \u00E9 o nome do filme!");
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNome.setBounds(10, 109, 46, 14);
		fadd.getContentPane().add(lblNome);
		
		JLabel lblAno = new JLabel("Ano:");
		lblAno.setToolTipText("Informe qual \u00E9 o ano do filme!");
		lblAno.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAno.setBounds(10, 157, 46, 14);
		fadd.getContentPane().add(lblAno);
		
		textFieldCategoria = new JTextField();
		textFieldCategoria.setToolTipText("Informe qual \u00E9 a categoria do filme!");
		textFieldCategoria.setBackground(new Color(192,192,192));
		textFieldCategoria.setBounds(87, 59, 337, 20);
		fadd.getContentPane().add(textFieldCategoria);
		textFieldCategoria.setColumns(10);
		
		textFieldNome = new JTextField();
		textFieldNome.setToolTipText("Informe qual \u00E9 o nome do filme!");
		textFieldNome.setBackground(new Color(192,192,192));
		textFieldNome.setBounds(87, 106, 337, 20);
		fadd.getContentPane().add(textFieldNome);
		textFieldNome.setColumns(10);
		
		textFieldAno = new JTextField();
		textFieldAno.setToolTipText("Informe qual \u00E9 o ano do filme!");
		textFieldAno.setBackground(new Color(192,192,192));
		textFieldAno.setBounds(87, 154, 337, 20);
		fadd.getContentPane().add(textFieldAno);
		textFieldAno.setColumns(10);
		
		JButton btnProcurar = new JButton("Procurar");
		btnProcurar.setBackground(new Color(107,107,107));
		btnProcurar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnProcurar.setBounds(309, 185, 115, 23);
		fadd.getContentPane().add(btnProcurar);
		
		textFieldProcurar = new JTextField();
		textFieldProcurar.setToolTipText("Informe o nome do filme a ser procurado!");
		textFieldProcurar.setBackground(new Color(192,192,192));
		textFieldProcurar.setBounds(10, 185, 289, 20);
		fadd.getContentPane().add(textFieldProcurar);
		textFieldProcurar.setColumns(10);
	}
}
