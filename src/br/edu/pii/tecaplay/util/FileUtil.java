package br.edu.pii.tecaplay.util;

import java.io.File;

import javax.swing.JOptionPane;

import br.edu.pii.tecaplay.ui.HomePage;
/**
 * Classe que trabalha na verefica��o de login e cria��o de novos usu�rios.
 * 
 * @author Marcelo
 *
 */
public class FileUtil {

	private static char vo;
	private boolean logou=false;

	public static void main() {
		String vos;
		vos = System.getProperty("os.name");//pega nome o S.O.
		vo = vos.charAt(0);
	}
	/**
	 * Verefica se existe o usu�rio, se existir entra no sistema.
	 * 
	 * @param usrName nome que a pessoa digita para o usu�rio
	 */
	public void fileUserVerify(String usrName){
		main();
		if(vo == 'W'){//se for windows executa
			File file = new File("C:\\TecaPlay");//diret�rio padr�o onde s�o salvos os conte�dos
			if(!file.exists()){//caso n�o exista, ser� criada
				file.mkdir();
			}else{
				if(file.isDirectory()){//verefica se � um diret�rio
					@SuppressWarnings("unused")
					String[] conteudo = file.list();
					File file2 = new File("C:\\TecaPlay\\"+usrName);
					if(file2.exists()){//verefica se usu�rio j� existe, se existir abre a homePage do TecaPlay
						if(file2.isDirectory()){
							@SuppressWarnings("unused")
							HomePage HomePage = new HomePage(usrName);
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
	
	/**
	 * @return retorna se logou ou n�o.
	 */
	public boolean loged(){
		return logou;
	}
	
	/**
	 * Registra um novo usu�rio.
	 * @param newUsrName Nome do novo usu�rio.
	 */
	public void RegisterNewUser(String newUsrName){
		//String newUsrName = reUser.getNewUser();//pega do JTextField o nome do usu�rio
		newUsrName = newUsrName.toLowerCase();
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
	
	/**
	 * Fecha a aplica��o.
	 */
	public static void sair() {
		int op = JOptionPane.showConfirmDialog(null, "Deseja realmente sair?", "Sair", JOptionPane.YES_NO_OPTION);
		if(op == JOptionPane.YES_OPTION){
			System.exit(0);
		}
	}

}
