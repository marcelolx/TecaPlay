package br.edu.pii.tecaplay.util;

import java.io.File;

import javax.swing.JOptionPane;

import br.edu.pii.tecaplay.ui.HomePage;
/**
 * Classe que trabalha na vereficação de login e criação de novos usuários.
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
	 * Verefica se existe o usuário, se existir entra no sistema.
	 * 
	 * @param usrName nome que a pessoa digita para o usuário
	 */
	public void fileUserVerify(String usrName){
		main();
		if(vo == 'W'){//se for windows executa
			File file = new File("C:\\TecaPlay");//diretório padrão onde são salvos os conteúdos
			if(!file.exists()){//caso não exista, será criada
				file.mkdir();
			}else{
				if(file.isDirectory()){//verefica se é um diretório
					@SuppressWarnings("unused")
					String[] conteudo = file.list();
					File file2 = new File("C:\\TecaPlay\\"+usrName);
					if(file2.exists()){//verefica se usuário já existe, se existir abre a homePage do TecaPlay
						if(file2.isDirectory()){
							@SuppressWarnings("unused")
							HomePage HomePage = new HomePage(usrName);
							logou = true;
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
	
	/**
	 * @return retorna se logou ou não.
	 */
	public boolean loged(){
		return logou;
	}
	
	/**
	 * Registra um novo usuário.
	 * @param newUsrName Nome do novo usuário.
	 */
	public void RegisterNewUser(String newUsrName){
		//String newUsrName = reUser.getNewUser();//pega do JTextField o nome do usuário
		newUsrName = newUsrName.toLowerCase();
		if(!newUsrName.isEmpty()){
			File newUserFile = new File("C:\\TecaPlay\\"+newUsrName+"\\Videos");//diretórios que vão ser criados
			File newUserFile2 = new File("C:\\TecaPlay\\"+newUsrName+"\\Musicas");
			File newUserFile3 = new File("C:\\TecaPlay\\"+newUsrName+"\\Imagens");
			if(!(newUserFile).exists() && !(newUserFile2).exists() && !(newUserFile3).exists()){
				newUserFile.mkdirs();//criando diretórios e usuário
				newUserFile2.mkdirs();
				newUserFile3.mkdirs();
				JOptionPane.showMessageDialog(null, "Usuário criado com sucesso.");
			}else{
				JOptionPane.showMessageDialog(null, "Esse usuário já existe.\nCrie outro, ou logue com o mesmo.");
			}
		}else{
			JOptionPane.showMessageDialog(null, "Insira um nome de usuário.");
		}
	}
	
	/**
	 * Fecha a aplicação.
	 */
	public static void sair() {
		int op = JOptionPane.showConfirmDialog(null, "Deseja realmente sair?", "Sair", JOptionPane.YES_NO_OPTION);
		if(op == JOptionPane.YES_OPTION){
			System.exit(0);
		}
	}

}
