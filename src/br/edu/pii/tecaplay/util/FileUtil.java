package br.edu.pii.tecaplay.util;

import java.io.File;

import javax.swing.JOptionPane;

import br.edu.pii.tecaplay.ui.HomePage;
import br.edu.pii.tecaplay.ui.FilmesAdd;

public class FileUtil {

	static char vo;
	boolean logou=false;

	public static void main() {
		String vos;
		vos = System.getProperty("os.name");//pega nome o S.O.
		vo = vos.charAt(0);
	}
	
	public void FileUserVerify(String usrName){
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
					File file2 = new File("C:\\TecaPlay\\"+usrName);
					System.out.println(file2);
					if(file2.exists()){//verefica se usuário já existe, se existir abre a homePage do TecaPlay
						if(file2.isDirectory()){
							HomePage HomePage = new HomePage();
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
	
	public boolean loged(){
		return logou;
	}
	
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
	
	public void AddFilme(String origem,String ano, String nome, String genero,String tipo){
		nome = nome.toLowerCase();
		origem = origem.toLowerCase();
		File criar = new File("c:\\TecaPlay\\"+vo+"\\Videos\\"+tipo+"\\"+genero);
		if(!(criar).exists()){
			criar.mkdirs();
		}
        File arquivo = new File(origem);
 
        boolean ok = arquivo.renameTo(new File(criar, arquivo.getName()));
        if(ok){
            System.out.println("Arquivo foi movido com sucesso");
        }
        else{
            System.out.println("Nao foi possivel mover o arquivo");
        }
		}
	
	
	
	public void retornoPasta() {
		File raiz = new File("c:\\TecaPlay");
		File[] files = raiz.listFiles();
		 
		for (File file : files) {
		  // copia os arquivos / subdiretórios
		}
		for (int i = 0; i < files.length; i++) {
			System.out.println(files[i]);
		}
		
		
	}
	
	
	
	public static void sair() {
		int op = JOptionPane.showConfirmDialog(null, "Deseja realmente sair?", "Sair", JOptionPane.YES_NO_OPTION);
		if(op == JOptionPane.YES_OPTION){
			System.exit(0);
		}
	}

}
