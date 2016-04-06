package br.edu.pii.tecaplay.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LoginGUI extends JFrame {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginGUI frame = new LoginGUI();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginGUI() {
		JFrame login = new JFrame();
		login.setVisible(true);
		login.setSize(320, 254);
		login.setResizable(false);
		login.setTitle("Login - TecaPlay");
		login.setLocationRelativeTo(null);
		login.setIconImage(Toolkit.getDefaultToolkit().getImage("resources\\images\\newLogo.png"));
		login.getContentPane().setBackground(new Color(169,169,169));
		
		/**
		 * Login somente com usuário, sem necessidade de senhas.
		 * teste
		 */
		JPanel logPanel = new JPanel();
		logPanel.setBackground(new Color(169, 169, 169));
		login.getContentPane().add(logPanel, BorderLayout.CENTER);
		JLabel userField = new JLabel("Usuário: ");
		JTextField usr = new JTextField();
		usr.setBackground(new Color(192, 192, 192));
		usr.setColumns(18);
		ImageIcon imag = new ImageIcon("resources\\images\\newLogo4.png");
		JLabel img = new JLabel(imag);
		ImageIcon addUsr = new ImageIcon("resources\\images\\logoAddUser.png");
		JButton  addUsrIcon = new JButton(addUsr);
		addUsrIcon.setSize(new Dimension(13, 2));
		addUsrIcon.setBackground(new Color(107, 107, 107));
		logPanel.add(img, BorderLayout.NORTH);
		logPanel.add(userField, BorderLayout.CENTER);
		logPanel.add(usr, BorderLayout.CENTER);
		logPanel.add(addUsrIcon, BorderLayout.CENTER);
	}
}
