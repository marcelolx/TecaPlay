package br.edu.pii.tecaplay.ui;

import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;
import java.awt.GridLayout;
import java.awt.Cursor;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
/**
 * Info do programa.
 * @author Jonas
 */
public class Sobre extends JFrame {

	private static final long serialVersionUID = 1L;

	public Sobre() {
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		@SuppressWarnings("unused")
		JFrame sobre = new JFrame();
		getContentPane().setBackground(Color.GRAY);
		setUndecorated(true);
		setVisible(true);
		setTitle("Filmes - TecaPlay");
		setIconImage(Toolkit.getDefaultToolkit().getImage("resources\\images\\newLogo.png"));
		setResizable(false);
		setSize(500, 270);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panelRodape = new JPanel();
		panelRodape.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		panelRodape.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelRodape.setBackground(Color.GRAY);
		getContentPane().add(panelRodape);
		
		JButton btnOk = new JButton("Ok");
		btnOk.setHorizontalAlignment(SwingConstants.LEFT);
		btnOk.setBounds(394, 224, 75, 29);
		btnOk.setIcon(new ImageIcon("resources\\images\\imgBtnOk.png"));
		btnOk.setMnemonic('O');
		btnOk.setSize(80,35);
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		panelRodape.setLayout(null);
		btnOk.setFont(new Font("Tekton Pro Ext", Font.PLAIN, 13));
		btnOk.setBackground(Color.LIGHT_GRAY);
		panelRodape.add(btnOk);
		
		JLabel lblVersao = new JLabel("Vers\u00E3o: 0.1.110");
		lblVersao.setFont(new Font("Sylfaen", Font.BOLD, 14));
		lblVersao.setLabelFor(panelRodape);
		lblVersao.setIcon(new ImageIcon("resources\\images\\imgVersion.png"));
		lblVersao.setDisplayedMnemonic('N');
		lblVersao.setBounds(246, 116, 160, 35);
		panelRodape.add(lblVersao);
		
		JLabel lblGerenciadorDeArquivos = new JLabel("<html><p align=”Justify”>Gerenciador de Arquivos de Imagens,M\u00FAsica e de V\u00EDdeo para o Windows</p></html>");
		lblGerenciadorDeArquivos.setFont(new Font("Sylfaen", Font.BOLD, 14));
		lblGerenciadorDeArquivos.setDisplayedMnemonic('N');
		lblGerenciadorDeArquivos.setBounds(246, 48, 237, 57);
		panelRodape.add(lblGerenciadorDeArquivos);
		
		JLabel lblTecaplay = new JLabel("TecaPlay - Sobre");
		lblTecaplay.setForeground(Color.BLACK);
		lblTecaplay.setFont(new Font("Sylfaen", Font.BOLD, 16));
		lblTecaplay.setBounds(296, 11, 141, 46);
		panelRodape.add(lblTecaplay);
		
		JLabel lblCriaoJonasHalmenschlager = new JLabel("<html>Cria\u00E7\u00E3o: Jonas Halmenschlager, Matheus Endler Haas e Marcelo Lauxen.<html>");
		lblCriaoJonasHalmenschlager.setHorizontalAlignment(SwingConstants.CENTER);
		lblCriaoJonasHalmenschlager.setFont(new Font("Sylfaen", Font.BOLD, 14));
		lblCriaoJonasHalmenschlager.setBounds(38, 169, 430, 44);
		panelRodape.add(lblCriaoJonasHalmenschlager);
		
		JLabel lblTodos = new JLabel("Todos os Direitos Reservados ");
		lblTodos.setFont(new Font("Sylfaen", Font.BOLD, 14));
		lblTodos.setBounds(148, 219, 203, 42);
		panelRodape.add(lblTodos);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("resources\\images\\imgLogoSobre.png"));
		lblNewLabel.setBounds(28, 26, 195, 140);
		panelRodape.add(lblNewLabel);
		
		
	}
}
