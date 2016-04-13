package br.edu.pii.tecaplay.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.ComponentOrientation;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class Sobre extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	
 
	/**
	 * Create the frame.
	 */
	public Sobre() {
		getContentPane().setBackground(Color.GRAY);
		setUndecorated(true);
		JFrame sobre = new JFrame();
		setVisible(true);
		setTitle("Filmes - TecaPlay");
		setIconImage(Toolkit.getDefaultToolkit().getImage("resources\\images\\newLogo.png"));
		setResizable(false);
		setSize(500, 350);
		setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		getContentPane().add(panel, BorderLayout.SOUTH);
		
		JButton btnOk = new JButton("Ok");
		btnOk.setIcon(new ImageIcon("C:\\Users\\jonas\\git\\tecaplayd\\resources\\images\\imgBtnOk.png"));
		btnOk.setMnemonic('O');
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnOk.setFont(new Font("Tekton Pro Ext", Font.PLAIN, 13));
		btnOk.setBackground(Color.LIGHT_GRAY);
		panel.add(btnOk);
		
		
	}

}
