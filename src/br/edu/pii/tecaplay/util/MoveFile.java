package br.edu.pii.tecaplay.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JOptionPane;

public class MoveFile {
	// Aqui jaz o codigo para mover os arquivos do adicionar.
	/**
	 * 
	 * @param origem 
	 * 		Diretório de onde o filme está.
	 * @param ano 
	 * 		Ano do filme.
	 * @param nome 
	 * 		Nome do filme.
	 * @param genero
	 * 		Gênero do filme
	 * @param duracao
	 * 		Duração do filme.
	 * @param pais
	 * 		País onde o filme foi lançado.
	 * @param tipo
	 * 		váriavel que vai armazenar se é filme, anime ou série.
	 * @param usrName
	 * 		Armazena o nome do usuário atual logado no TecaPlay.
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
		
		boolean ok = arquivo.renameTo(new File(destinoPasta, newFileName));
		
		if (ok) {
			JOptionPane.showMessageDialog(null, "Arquivo foi movido com sucesso-"+arquivo.getName(), "Sucesso", 1);

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
		gravarTxt(pasta,nome,temporada,episodio,duracao,genero);
	}
	
	public void gravarTxt(String pasta, String nome, String temporada, String episodio,String duracao,String genero){
		String criarTxt = pasta + "\\"+genero+".txt";
		FileReader diretorio = null;
		try {
			diretorio = new FileReader(criarTxt);
		} catch (FileNotFoundException e2) {
			System.out.println("nao foi possiovel criar o .txt");
		}
		
			try {
				diretorio = new FileReader(pasta);
			} catch (FileNotFoundException e) {
				System.out.println("Erro na filereader do arquivo");
				e.printStackTrace();
			}
			
		BufferedReader br = new BufferedReader(diretorio);
		
		String resul = null;
		try {
			resul = br.readLine();
			System.out.println("teste teste"+resul);
		} catch (IOException e1) {
			System.out.println("Erro na leitura");
		}
		
		if (resul == null){
			resul = "vazio";
		}
		
		if (!resul.equals("vazio")){
			System.out.println(br);
			try {
				br.close();
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, "Erro ao fechar o arquivo","Erro",0);
				e.printStackTrace();
			}
		}
		else{
			System.out.println(br);
			try {
				br.close();
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, "Erro ao fechar o arquivo","Erro",0);
				e.printStackTrace();
			}
		}
		
	}
	public boolean retornoPasta(String usrName, String genero) {
		File raiz = new File("c:\\TecaPlay\\"+usrName+"\\Video\\filme\\"+genero);
		File[] files = raiz.listFiles();
		if (!raiz.mkdir())
				return false;
		for (@SuppressWarnings("unused")
		File file : files) {
			// copia os arquivos / subdiretórios
		}
		for (int i = 0; i < files.length; i++) {
			System.out.println(files[i]);
		}
		return false;

	}
}
