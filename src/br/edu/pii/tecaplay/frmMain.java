package br.edu.pii.tecaplay;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import java.awt.GridLayout;

public class frmMain extends JFrame {

	/**
	 * 
	 */

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmMain frame = new frmMain();
					frame.setSize(new Dimension(980, 560));
					frame.setLocation(200, 100);
					frame.setVisible(true);
					frame.getContentPane().setBackground(new Color(169,169,169));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public frmMain() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 651, 397);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnArquivo = new JMenu("Arquivo");
		menuBar.add(mnArquivo);
		
		JMenuItem mntmSair = new JMenuItem("Sair");
		mnArquivo.add(mntmSair);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		getContentPane().add(panel, BorderLayout.WEST);
		panel.setLayout(new GridLayout(12, 10, 5, 1));
		
		JButton btnNewButton_1 = new JButton("Filmes");
		panel.add(btnNewButton_1);
		btnNewButton_1.setBackground(new Color(105,105,105));
		btnNewButton_1.setForeground(new Color(220,220,220));
		
		JButton btnNewButton_2 = new JButton("Séries");
		panel.add(btnNewButton_2);
		btnNewButton_2.setBackground(new Color(105,105,105));
		btnNewButton_2.setForeground(new Color(220,220,220));
		
		JButton btnNewButton_3 = new JButton("Animes");
		panel.add(btnNewButton_3);
		btnNewButton_3.setBackground(new Color(105,105,105));
		btnNewButton_3.setForeground(new Color(220,220,220));
		
		JButton btnNewButton_4 = new JButton("+ Adicionar");
		panel.add(btnNewButton_4);
		btnNewButton_4.setBackground(new Color(105,105,105));
		btnNewButton_4.setForeground(new Color(220,220,220));
		
		JButton btnNewButton_6 = new JButton("- Deletar");
		panel.add(btnNewButton_6);
		btnNewButton_6.setBackground(new Color(105,105,105));
		btnNewButton_6.setForeground(new Color(220,220,220));
		
		JButton btnNewButton_5 = new JButton("Favoritos");
		panel.add(btnNewButton_5);
		btnNewButton_5.setBackground(new Color(105,105,105));
		btnNewButton_5.setForeground(new Color(220,220,220));
		
		mntmSair.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});
	}

}
