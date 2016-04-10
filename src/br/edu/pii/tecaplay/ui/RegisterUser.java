package br.edu.pii.tecaplay.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.FlowLayout;

public class RegisterUser {
	public RegisterUser(){
		JFrame reUser = new JFrame();
		reUser.setSize(300, 100);
		reUser.setVisible(true);
		reUser.setResizable(false);
		reUser.setTitle("Cadastro - TecaPlay");
		reUser.setLocationRelativeTo(null);
		reUser.setIconImage(Toolkit.getDefaultToolkit().getImage("resources\\images\\newLogo.png"));
		reUser.getContentPane().setBackground(new Color(169,169,169));
		reUser.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel ruPanel = new JPanel();
		ruPanel.setBounds(0, 0, 0, 0);
		ruPanel.setBackground(new Color(169, 169, 169));
		reUser.getContentPane().add(ruPanel);
		
		JLabel usrNameLabel = new JLabel("Novo Usuário: ");
		ruPanel.add(usrNameLabel);
		
		JTextField usrNameField = new JTextField();
		ruPanel.add(usrNameField);
		usrNameField.setBounds(0, 0, 294, 29);
		usrNameField.setBackground(new Color(192, 192, 192));
		usrNameField.setColumns(18);
		
		JButton usrCancelButton = new JButton("Cancelar");
		usrCancelButton.setLocation(0, 25);
		usrCancelButton.setSize(new Dimension(150, 44));
		usrCancelButton.setBackground(new Color(107, 107, 107));
		reUser.getContentPane().add(usrCancelButton);
		
		JButton usrNameButton = new JButton("Registrar");
		usrNameButton.setLocation(150, 25);
		usrNameButton.setSize(new Dimension(150, 150));
		usrNameButton.setBackground(new Color(107, 107, 107));
		reUser.getContentPane().add(usrNameButton);
		
	}
}
