package br.edu.pii.tecaplay.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

import javax.swing.JOptionPane;

public class MoveFile {
	private FileWriter escrita;
	// Aqui jaz o codigo para mover os arquivos do adicionar.
	/**
	 * 
	 * @param origem 
	 * 		Diret�rio de onde o filme est�.
	 * @param ano 
	 * 		Ano do filme.
	 * @param nome 
	 * 		Nome do filme.
	 * @param genero
	 * 		G�nero do filme
	 * @param duracao
	 * 		Dura��o do filme.
	 * @param pais
	 * 		Pa�s onde o filme foi lan�ado.
	 * @param tipo
	 * 		v�riavel que vai armazenar se � filme, anime ou s�rie.
	 * @param usrName
	 * 		Armazena o nome do usu�rio atual logado no TecaPlay.
	 */
	public void AddFilme(String origem, String ano, String nome, String genero, String duracao, String pais, String tipo, String usrName) {
		nome = nome.toLowerCase();
		origem = origem.toLowerCase();
		genero = genero.toLowerCase();
		File destinoPasta = new File("c:\\TecaPlay\\" + usrName + "\\Videos\\" + tipo + "\\" + genero);
		if (!(destinoPasta).exists()) {
			destinoPasta.mkdirs();
		}
		File arquivo = new File(origem);
		//pegando a extensao do arquivo a ser movido e renomeando o arquivo.
		String extensao = arquivo.getName().substring(arquivo.getName().lastIndexOf('.', arquivo.getName().length()));
		String newFileName = nome + "_" + genero + "_" + ano + "_" + duracao+"_"+pais+"_"+extensao;
		System.out.println(destinoPasta.getAbsolutePath());
		boolean ok = arquivo.renameTo(new File(destinoPasta, newFileName));
		
		if (ok) {
			JOptionPane.showMessageDialog(null, "Arquivo foi movido com sucesso-"+destinoPasta.getName(), "Sucesso", 1);

		} else {
			JOptionPane.showMessageDialog(null, "Nao foi possivel mover o arquivo", "Erro", 0);
		}
		
	}

	public void AddSerie(String origem, String temporada, String nome, String genero, String duracao, String episodio, String tipo, String usrName) {
		nome = nome.toLowerCase();
		origem = origem.toLowerCase();
		genero = genero.toLowerCase();
		File destinoPasta = new File("c:\\TecaPlay\\" + usrName + "\\Videos\\" + tipo + "\\" + genero);
		if (!(destinoPasta).exists()) {
			destinoPasta.mkdirs();
		}
		File arquivo = new File(origem);
		//pegando a extensao do arquivo a ser movido e renomeando o arquivo.
		String extensao = arquivo.getName().substring(arquivo.getName().lastIndexOf('.', arquivo.getName().length()));
		String newFileName = nome + "_" + genero + "_" + temporada + "_" + duracao+"_"+episodio+"_"+extensao;
		
		boolean ok = arquivo.renameTo(new File(destinoPasta, newFileName));
		
		if (ok) {
			JOptionPane.showMessageDialog(null, "Arquivo foi movido com sucesso-"+arquivo.getName(), "Sucesso", 1);

		} else {
			JOptionPane.showMessageDialog(null, "Nao foi possivel mover o arquivo", "Erro", 0);
		}
		String pasta ="c:\\TecaPlay\\" + usrName + "\\Videos\\" + tipo ;
		System.out.println(pasta);
		String fileFinal = destinoPasta.getAbsolutePath()+"\\"+newFileName;
		System.out.println(fileFinal);
		gravarTxt(pasta,nome,temporada,episodio,duracao,genero,fileFinal);
	}
	
	public void gravarTxt(String pasta, String nome, String temporada, String episodio,String duracao,String genero,String file){
		//String do diretorio do TXT
		String criarTxt = pasta + "\\"+genero+".txt";
		FileReader diretorio = null;
		try {
			diretorio = new FileReader(criarTxt);
			System.out.println(diretorio);
		} catch (FileNotFoundException e2) {
			try {
				FileWriter arq = new FileWriter(criarTxt);
			} catch (IOException e) {
				System.out.println("Cria��o .txt nao possivel");
			}
		}
		try {
			FileWriter buffer = null;  
			buffer = new FileWriter(criarTxt); 
			String texto = temporada+"#"+episodio+"#"+nome+"#"+duracao+"#"+file;
			buffer.write(texto);  
		//	buffer.newLine();
			buffer.close();
		} catch (IOException e) {
			System.out.println("n�o foi posssivel fazer a conexao ocm o txt)");
		}
		
	}
	public boolean retornoPasta(String usrName, String genero) {
		File raiz = new File("c:\\TecaPlay\\"+usrName+"\\Video\\filme\\"+genero);
		File[] files = raiz.listFiles();
		if (!raiz.mkdir())
				return false;
		for (@SuppressWarnings("unused")
		File file : files) {
			// copia os arquivos / subdiret�rios
		}
		for (int i = 0; i < files.length; i++) {
			System.out.println(files[i]);
		}
		return false;

	}
}
