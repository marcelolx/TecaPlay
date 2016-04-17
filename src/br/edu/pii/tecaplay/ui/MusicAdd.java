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

public class MusicAdd {
	private JTextField textFieldArtista;
	private JTextField textFieldGenero;
	private JTextField textFieldNome;
	private JTextField textFieldAno;
	private JTextField textFieldProcurar;
	public MusicAdd(){ 
		JFrame fadd = new JFrame();
		fadd.setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		fadd.setAlwaysOnTop(true);
		fadd.setResizable(false);
		fadd.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		fadd.setTitle("Adicionar Músicas - TecaPlay");
		fadd.setIconImage(Toolkit.getDefaultToolkit().getImage("resources\\images\\newLogo.png"));
		fadd.getContentPane().setBackground(new Color(169,169,169));
		fadd.getContentPane().setForeground(Color.WHITE);
		fadd.getContentPane().setLayout(null);
		fadd.setVisible(true);
		fadd.setSize(450, 300);
		fadd.setLocationRelativeTo(null);
		
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setToolTipText("Informe qual \u00E9 o Cantor/Banda da M\u00FAsica!");
		lblTipo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTipo.setBounds(10, 22, 59, 17);
		fadd.getContentPane().add(lblTipo);
		
		textFieldArtista = new JTextField();
		textFieldArtista.setToolTipText("Informe qual \u00E9 o nome do Cantor/Banda!");
		textFieldArtista.setBackground(new Color(192,192,192));
		textFieldArtista.setBounds(87, 19, 337, 20);
		fadd.getContentPane().add(textFieldArtista);
		textFieldArtista.setColumns(10);
		
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
		btnCancelar.setBounds(10, 227, 191, 23);
		fadd.getContentPane().add(btnCancelar);
		
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setBackground(new Color(107,107,107));
		btnAdicionar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAdicionar.setBounds(233, 227, 191, 23);
		fadd.getContentPane().add(btnAdicionar);
		
		JLabel lblCategoria = new JLabel("Gen\u00EAro");
		lblCategoria.setToolTipText("Informe qual \u00E9 o Gen\u00EAro da M\u00FAsica!");
		lblCategoria.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCategoria.setBounds(10, 59, 83, 20);
		fadd.getContentPane().add(lblCategoria);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setToolTipText("Informe qual \u00E9 o nome da M\u00FAsica!");
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNome.setBounds(10, 109, 46, 14);
		fadd.getContentPane().add(lblNome);
		
		JLabel lblAno = new JLabel("Ano:");
		lblAno.setToolTipText("Informe qual \u00E9 o ano da M\u00FAsica!");
		lblAno.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAno.setBounds(10, 157, 46, 14);
		fadd.getContentPane().add(lblAno);
		
		textFieldGenero = new JTextField();
		textFieldGenero.setToolTipText("Informe qual \u00E9 o Genêro da Música!");
		textFieldGenero.setBackground(new Color(192,192,192));
		textFieldGenero.setBounds(87, 59, 337, 20);
		fadd.getContentPane().add(textFieldGenero);
		textFieldGenero.setColumns(10);
		
		textFieldNome = new JTextField();
		textFieldNome.setToolTipText("Informe qual \u00E9 o nome da Música!");
		textFieldNome.setBackground(new Color(192,192,192));
		textFieldNome.setBounds(87, 106, 337, 20);
		fadd.getContentPane().add(textFieldNome);
		textFieldNome.setColumns(10);
		
		textFieldAno = new JTextField();
		textFieldAno.setToolTipText("Informe qual \u00E9 o ano da Música!");
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
		textFieldProcurar.setToolTipText("Informe do diretório da música a ser procurada!");
		textFieldProcurar.setBackground(new Color(192,192,192));
		textFieldProcurar.setBounds(10, 185, 289, 20);
		fadd.getContentPane().add(textFieldProcurar);
		textFieldProcurar.setColumns(10);
	}
}
