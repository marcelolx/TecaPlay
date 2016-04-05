package br.edu.pii.tecaplay;

import java.awt.EventQueue;
import javax.swing.JFrame;


import br.edu.pii.tecaplaygui.LoginGUI;

public class frmMain extends JFrame {

	/**
	 * @version 1.0
	 * @author Jonas, Marcelo, Matheus
	 */

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
				LoginGUI lg = new LoginGUI();
			}
		});
	}
}

