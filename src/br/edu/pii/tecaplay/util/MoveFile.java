package br.edu.pii.tecaplay.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class MoveFile {
	@SuppressWarnings("unused")
	private FileWriter escrita;
	// Aqui jaz o codigo para mover os arquivos do adicionar.
	/**
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
		origem = origem.toLowerCase();
		genero = genero.toLowerCase();
		File destinoPasta = new File("c:\\TecaPlay\\" + usrName + "\\Videos\\" + tipo + "\\" + genero);
		if (!(destinoPasta).exists()) {
			destinoPasta.mkdirs();
		}
		File arquivo = new File(origem);
		//pegando a extensao do arquivo a ser movido e renomeando o arquivo.
		String extensao = arquivo.getName().substring(arquivo.getName().lastIndexOf('.', arquivo.getName().length()));
		String newFileName = nome + extensao;
		System.out.println(destinoPasta.getAbsolutePath());
		boolean ok = arquivo.renameTo(new File(destinoPasta, newFileName));
		
		if (ok) {
			JOptionPane.showMessageDialog(null, "Arquivo foi movido com sucesso-"+destinoPasta.getName(), "Sucesso", 1);

		} else {
			JOptionPane.showMessageDialog(null, "Nao foi possivel mover o arquivo", "Erro", 0);
		}
		String pasta ="c:\\TecaPlay\\" + usrName + "\\Videos\\" + tipo ;
		System.out.println(pasta);
		String fileFinal = destinoPasta.getAbsolutePath()+"\\"+newFileName;
		System.out.println(fileFinal);
		gravarTxtFilmes(pasta, nome, ano, genero, pais, fileFinal);
	}
	

	public void AddSerie(String origem, String temporada, String nome, String nomeEp, String genero, String duracao, String episodio, String tipo, String usrName) {
		nome = nome.toLowerCase();
		origem = origem.toLowerCase();
		String nomeEptoFile = episodio + " - "+ nomeEp;
		nomeEp = nomeEp.toLowerCase();
		genero = genero.toLowerCase();
		File destinoPasta = new File("c:\\TecaPlay\\" + usrName + "\\Videos\\" + tipo + "\\" + genero+ "\\" + nome + "\\" + temporada);
		if (!(destinoPasta).exists()) {
			destinoPasta.mkdirs();
		}
		File arquivo = new File(origem);
		//pegando a extensao do arquivo a ser movido e renomeando o arquivo.
		String extensao = arquivo.getName().substring(arquivo.getName().lastIndexOf('.', arquivo.getName().length()));
		String newFileName = nomeEptoFile + extensao;
		
		boolean ok = arquivo.renameTo(new File(destinoPasta, newFileName));
		
		if (ok) {
			JOptionPane.showMessageDialog(null, "Arquivo foi movido com sucesso-"+arquivo.getName(), "Sucesso", 1);

		} else {
			JOptionPane.showMessageDialog(null, "Nao foi possivel mover o arquivo", "Erro", 0);
		}
		String pasta ="c:\\TecaPlay\\" + usrName + "\\Videos\\" + tipo ;
		String fileFinal = destinoPasta.getAbsolutePath()+"\\"+newFileName;//pega o caminho final do arquivo e acrescenta
																			//o nome final do arquivo a ser copiado 
		gravarTxt(pasta,nomeEptoFile,temporada,episodio,duracao,genero,fileFinal); // envia os dados para o gravartxt
	}

	public void gravarTxtFilmes(String pasta, String nomeEp, String ano, String genero, String pais, String file){
		//string que serve para fazer a criacao do txt
		String criarTxt = pasta + "\\" + genero + ".txt";
		
		//grava as informaões no txt
		try{
			FileWriter buffer = null;
			buffer = new FileWriter(criarTxt, true);
			String text = ano+"#"+genero+"#"+pais+"#"+nomeEp+"#"+file;
			buffer.write(text+"\r\n");
			buffer.close();
		}catch(IOException e21){
			System.out.println("Não foi possivel fazer a conexão com o txt.");
		}
	}
	//gravarTxt só está apto para séries, necessário criar outro para filmes,
	//o mesmo pode ser utilizado para animes também.
	public void gravarTxt(String pasta, String nomeEp, String temporada, String episodio,String duracao,String genero,String file){
		//String do diretorio do TXT
		String criarTxt = pasta + "\\"+genero+".txt";

		try {
			FileWriter buffer = null;  
			buffer = new FileWriter(criarTxt, true); 
			String texto = temporada+"#"+episodio+"#"+nomeEp+"#"+duracao+"#"+file;
			buffer.write(texto+"\r\n");  
			buffer.close();
		} catch (IOException e) {
			System.out.println("não foi posssivel fazer a conexao ocm o txt)");
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
