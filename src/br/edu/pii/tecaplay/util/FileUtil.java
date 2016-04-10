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
			File file = new File("C:\\TecaPlay");//diretório padrão onde são salvos os conteúdos
			if(!file.exists()){//caso não exista, será criada
				file.mkdir();
				System.out.println("pasta tecaplay criada");
			}else{
				if(file.isDirectory()){//verefica se é um diretório
					String[] conteudo = file.list();
					System.out.println("É um diretório.");
					String usrName =  lgui.getUser();//pega usuário insirido na tela de login
					File file2 = new File("C:\\TecaPlay\\"+usrName);
					System.out.println(file2);
					if(!file2.exists()){//verefica se usuário já existe, se existir abre a homePage do TecaPlay
						if(!file2.isDirectory()){
							homePage HomePage = new homePage();
						}
					}else{//senão deve-se reinserir o usuário
						JOptionPane.showMessageDialog(null, "Usuário inválido.");
					}
				}
			}
		}else{
			System.out.println("For Linux and Mac OSX");
		}
	}
}
