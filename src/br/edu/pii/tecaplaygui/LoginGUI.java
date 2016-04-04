package br.edu.pii.tecaplaygui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LoginGUI {
	public LoginGUI() {
		/**
		 * Tela de login e configurações para sua exibição.
		 */
		JFrame login = new JFrame();
		login.setVisible(true);
		login.setSize(250, 70);
		login.setTitle("Login - TecaPlay");
		login.setLocationRelativeTo(null);
		login.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Marcelo\\git\\tecaplay\\images\\newLogo.png"));
		login.getContentPane().setBackground(new Color(169,169,169));
		
		/**
		 * Login somente com usuário, sem necessidade de senhas.
		 */
		JPanel logPanel = new JPanel();
		logPanel.setBackground(new Color(169, 169, 169));
		login.getContentPane().add(logPanel, BorderLayout.CENTER);
		JLabel userField = new JLabel("Usuário: ");
		JTextField usr = new JTextField();
		usr.setBackground(new Color(192, 192, 192));
		usr.setColumns(15);
		logPanel.add(userField, BorderLayout.CENTER);
		logPanel.add(usr, BorderLayout.CENTER);
	}
}

