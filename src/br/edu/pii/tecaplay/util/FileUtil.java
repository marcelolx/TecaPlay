package br.edu.pii.tecaplay.util;

import java.io.File;

import javax.swing.JOptionPane;

import br.edu.pii.tecaplay.ui.HomePage;

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
			File file = new File("C:\\TecaPlay");//diret�rio padr�o onde s�o salvos os conte�dos
			if(!file.exists()){//caso n�o exista, ser� criada
				file.mkdir();
				System.out.println("pasta tecaplay criada");
			}else{
				if(file.isDirectory()){//verefica se � um diret�rio
					@SuppressWarnings("unused")
					String[] conteudo = file.list();
					System.out.println("� um diret�rio.");
					File file2 = new File("C:\\TecaPlay\\"+usrName);
					System.out.println(file2);
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
	
	public boolean loged(){
		return logou;
	}
	
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
	
	//Aqui jaz o codigo para mover os arquivos do adicionar.
	public void AddFilme(String origem,String ano, String nome, String genero,String tipo,String usrName){
		nome = nome.toLowerCase();
		origem = origem.toLowerCase();
		File criar = new File("c:\\TecaPlay\\"+usrName+"\\Videos\\"+tipo+"\\"+genero);
		if(!(criar).exists()){
			criar.mkdirs();
		}
        File arquivo = new File(origem);
 
        boolean ok = arquivo.renameTo(new File(criar, arquivo.getName()));
        if(ok){
           JOptionPane.showMessageDialog(null,"Arquivo foi movido com sucesso","Sucesso",1);
           
        }
        else{
            JOptionPane.showMessageDialog(null,"Nao foi possivel mover o arquivo","Erro",0);
        }
		}
	
	
	
	public void retornoPasta() {
		File raiz = new File("c:\\TecaPlay");
		File[] files = raiz.listFiles();
		 
		for (@SuppressWarnings("unused") File file : files) {
		  // copia os arquivos / subdiret�rios
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
