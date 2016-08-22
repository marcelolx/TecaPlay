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

/**
 * @deprecated Add and list images, but not functional
 * @author matheus
 *
 */
public class ImagemAdd {
	private JTextField textFieldCategoria;
	private JTextField textFieldNome;
	private JTextField textFieldAno;
	private JTextField textFieldProcurar;

	public ImagemAdd() {
		JFrame imgAdd = new JFrame();
		imgAdd.setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		imgAdd.setAlwaysOnTop(true);
		imgAdd.setResizable(false);
		imgAdd.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		imgAdd.setTitle("Adicionar Imagens- TecaPlay");
		imgAdd.setIconImage(Toolkit.getDefaultToolkit().getImage("resources\\images\\newLogo.png"));
		imgAdd.getContentPane().setBackground(new Color(169, 169, 169));
		imgAdd.getContentPane().setForeground(Color.WHITE);
		imgAdd.getContentPane().setLayout(null);
		imgAdd.setVisible(true);
		imgAdd.setSize(450, 250);
		imgAdd.setLocationRelativeTo(null);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btnCancelar) {
					imgAdd.dispose();

				}
			}
		});
		btnCancelar.setBackground(new Color(107, 107, 107));
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCancelar.setBounds(10, 187, 180, 23);
		imgAdd.getContentPane().add(btnCancelar);

		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setBackground(new Color(107, 107, 107));
		btnAdicionar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAdicionar.setBounds(244, 187, 180, 23);
		imgAdd.getContentPane().add(btnAdicionar);

		JLabel lblColecao = new JLabel("Cole\u00E7\u00E3o:");
		lblColecao.setToolTipText("Informe qual \u00E9 a Cole\u00E7\u00E3o da Imagem!");
		lblColecao.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblColecao.setBounds(10, 11, 83, 20);
		imgAdd.getContentPane().add(lblColecao);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setToolTipText("Informe qual \u00E9 o nome da imagem!");
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNome.setBounds(10, 59, 46, 14);
		imgAdd.getContentPane().add(lblNome);

		JLabel lblAno = new JLabel("Ano:");
		lblAno.setToolTipText("Informe qual \u00E9 o ano do filme!");
		lblAno.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAno.setBounds(10, 100, 46, 14);
		imgAdd.getContentPane().add(lblAno);

		textFieldCategoria = new JTextField();
		textFieldCategoria.setToolTipText("Informe qual \u00E9 a categoria do filme!");
		textFieldCategoria.setBackground(new Color(192, 192, 192));
		textFieldCategoria.setBounds(87, 13, 337, 20);
		imgAdd.getContentPane().add(textFieldCategoria);
		textFieldCategoria.setColumns(10);

		textFieldNome = new JTextField();
		textFieldNome.setToolTipText("Informe qual \u00E9 o nome do filme!");
		textFieldNome.setBackground(new Color(192, 192, 192));
		textFieldNome.setBounds(87, 58, 337, 20);
		imgAdd.getContentPane().add(textFieldNome);
		textFieldNome.setColumns(10);

		textFieldAno = new JTextField();
		textFieldAno.setToolTipText("Informe qual \u00E9 o ano do filme!");
		textFieldAno.setBackground(new Color(192, 192, 192));
		textFieldAno.setBounds(87, 99, 337, 20);
		imgAdd.getContentPane().add(textFieldAno);
		textFieldAno.setColumns(10);

		JButton btnProcurar = new JButton("Procurar");
		btnProcurar.setBackground(new Color(107, 107, 107));
		btnProcurar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnProcurar.setBounds(309, 136, 115, 23);
		imgAdd.getContentPane().add(btnProcurar);

		textFieldProcurar = new JTextField();
		textFieldProcurar.setToolTipText("Informe o nome da imagem a ser procurada!");
		textFieldProcurar.setBackground(new Color(192, 192, 192));
		textFieldProcurar.setBounds(10, 139, 289, 20);
		imgAdd.getContentPane().add(textFieldProcurar);
		textFieldProcurar.setColumns(10);
	}
}
