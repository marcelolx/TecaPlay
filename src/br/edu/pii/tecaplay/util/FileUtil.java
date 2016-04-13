package br.edu.pii.tecaplay.util;

import java.io.File;

import javax.swing.JOptionPane;

import br.edu.pii.tecaplay.ui.LoginGUI;
import br.edu.pii.tecaplay.ui.RegisterUser;
import br.edu.pii.tecaplay.ui.HomePage;

public class FileUtil {

	static char vo;
	boolean logou=false;

	public static void main() {
		String vos;
		vos = System.getProperty("os.name");//pega nome o S.O.
		vo = vos.charAt(0);
	}
	
	public void FileUserVerify(){
		LoginGUI lgui = new LoginGUI();
		main();
		//System.out.println(vo);
		if(vo == 'W'){//se for windows executa
			File file = new File("C:\\TecaPlay");//diret�rio padr�o onde s�o salvos os conte�dos
			if(!file.exists()){//caso n�o exista, ser� criada
				file.mkdir();
				System.out.println("pasta tecaplay criada");
			}else{
				if(file.isDirectory()){//verefica se � um diret�rio
					String[] conteudo = file.list();
					System.out.println("� um diret�rio.");
					String usrName =  lgui.getUser();//pega usu�rio insirido na tela de login
					File file2 = new File("C:\\TecaPlay\\"+usrName);
					System.out.println(file2);
					if(file2.exists()){//verefica se usu�rio j� existe, se existir abre a homePage do TecaPlay
						if(file2.isDirectory()){
							HomePage HomePage = new HomePage();
							logou = true;
						}
					}else{//sen�o deve-se reinserir o usu�rio
						JOptionPane.showMessageDialog(null, "Usu�rio inv�lido.");
					}
				}
			}
		}else{
			System.out.println("For Linux and Mac OSX");
		}
	}
	
	public boolean loged(){
		return logou;
	}
	
	public void RegisterNewUser(){
		RegisterUser reUser = new RegisterUser();
		
		String newUsrName = reUser.getNewUser();//pega do JTextField o nome do usu�rio
		if(!newUsrName.isEmpty()){
			File newUserFile = new File("C:\\TecaPlay\\"+newUsrName+"\\Videos");//diret�rios que v�o ser criados
			File newUserFile2 = new File("C:\\TecaPlay\\"+newUsrName+"\\Musicas");
			File newUserFile3 = new File("C:\\TecaPlay\\"+newUsrName+"\\Imagens");
			if(!(newUserFile).exists() && !(newUserFile2).exists() && !(newUserFile3).exists()){
				newUserFile.mkdirs();//criando diret�rios e usu�rio
				newUserFile2.mkdirs();
				newUserFile3.mkdirs();
				JOptionPane.showMessageDialog(null, "Usu�rio criado com sucesso.");
			}else{
				JOptionPane.showMessageDialog(null, "Esse usu�rio j� existe.\nCrie outro, ou logue com o mesmo.");
			}
		}else{
			JOptionPane.showMessageDialog(null, "Insira um nome de usu�rio.");
		}
	}
	
	public static void sair() {
		int op = JOptionPane.showConfirmDialog(null, "Deseja realmente sair?", "Sair", JOptionPane.YES_NO_OPTION);
		if(op == JOptionPane.YES_OPTION){
			System.exit(0);
		}
	}

}
