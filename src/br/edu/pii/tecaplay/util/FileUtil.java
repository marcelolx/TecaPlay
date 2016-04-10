package br.edu.pii.tecaplay.util;

import java.io.File;

import javax.swing.JOptionPane;

import br.edu.pii.tecaplay.ui.LoginGUI;
import br.edu.pii.tecaplay.ui.homePage;

public class FileUtil {
	
	private static LoginGUI lgui = new LoginGUI();
	static char vo;
	
	public static void main() {
		String vos;
		vos = System.getProperty("os.name");//pega nome o S.O.
		vo = vos.charAt(0);
	}
	
	public void FileUserVerify(){
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
					if(!file2.exists()){//verefica se usu�rio j� existe, se existir abre a homePage do TecaPlay
						if(!file2.isDirectory()){
							homePage HomePage = new homePage();
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
}
