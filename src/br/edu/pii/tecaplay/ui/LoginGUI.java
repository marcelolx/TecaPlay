package br.edu.pii.tecaplay.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import br.edu.pii.tecaplay.util.FileUtil;

public class LoginGUI extends JFrame {
	
	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//RegisterUser ru = new RegisterUser();
					JFrame login = new JFrame();
					login.setSize(320, 254);
					login.setVisible(true);
					login.setResizable(false);
					login.setTitle("Login - TecaPlay");
					login.setLocationRelativeTo(null);
					login.setIconImage(Toolkit.getDefaultToolkit().getImage("resources\\images\\newLogo.png"));
					login.getContentPane().setBackground(new Color(169,169,169));
					login.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
					
					/**
					 * Login somente com usuário, sem necessidade de senhas.
					 * teste
					 */
					JPanel logPanel = new JPanel();
					logPanel.setBackground(new Color(169, 169, 169));
					login.getContentPane().add(logPanel, BorderLayout.CENTER);
					
					ImageIcon imag = new ImageIcon("resources\\images\\newLogo4.png");
					JLabel img = new JLabel(imag);
					logPanel.add(img, BorderLayout.NORTH);
					
					JLabel userField = new JLabel("Usuário: ");
					logPanel.add(userField, BorderLayout.CENTER);
					
					JTextField usr = new JTextField();
					usr.setBackground(new Color(192, 192, 192));
					usr.setColumns(18);
					logPanel.add(usr, BorderLayout.CENTER);
					usr.addKeyListener(new KeyListener() {			
						@Override
						public void keyPressed(KeyEvent e) {
							if(e.getKeyCode() == KeyEvent.VK_ENTER){
								FileUtil FileUtil = new FileUtil();
								String userName;
								userName = usr.getText();//pega usuário no textfield
								usr.setText("");
								FileUtil.FileUserVerify(userName);
								if(FileUtil.loged() == true){
									login.dispose();
								}

							}
							
						}
						
						@Override
						public void keyReleased(KeyEvent e) {
							// TODO Auto-generated method stub
							
						}

						@Override
						public void keyTyped(KeyEvent e) {
							// TODO Auto-generated method stub
							
						}
					});
					
					ImageIcon addUsr = new ImageIcon("resources\\images\\logoAddUser.png");
					JButton  addUsrIcon = new JButton(addUsr);
					addUsrIcon.setSize(new Dimension(13, 2));
					addUsrIcon.setBackground(new Color(107, 107, 107));
					logPanel.add(addUsrIcon, BorderLayout.CENTER);
					addUsrIcon.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							RegisterUser RegisterUser = new RegisterUser();
						}
					});
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
		

}
