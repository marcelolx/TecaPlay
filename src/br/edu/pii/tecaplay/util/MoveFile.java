package br.edu.pii.tecaplay.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;
/**
 * 
 * @author jonas
 *
 */
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
	public void AddFilme(String origem, String ano, String nome, String genero, String duracao, String pais, String usrName) {
		origem = origem.toLowerCase();
		genero = genero.toLowerCase();
		File destinoPasta = new File("c:\\TecaPlay\\" + usrName + "\\Videos\\filme\\" + genero);
		if (!(destinoPasta).exists()) {
			destinoPasta.mkdirs();
		}
		File arquivo = new File(origem);
		//pegando a extensao do arquivo a ser movido e renomeando o arquivo.
		String extensao = arquivo.getName().substring(arquivo.getName().lastIndexOf('.', arquivo.getName().length()));
		String newFileName = nome + extensao;
		boolean ok = arquivo.renameTo(new File(destinoPasta, newFileName));
		
		if (ok) {
			JOptionPane.showMessageDialog(null, "Arquivo foi movido com sucesso-"+destinoPasta.getName(), "Sucesso", 1);

		} else {
			JOptionPane.showMessageDialog(null, "Nao foi possivel mover o arquivo", "Erro", 0);
		}
		String pasta ="c:\\TecaPlay\\" + usrName + "\\Videos\\filme"  ;
		String fileFinal = destinoPasta.getAbsolutePath()+"\\"+newFileName;
		gravarTxtFilmes(pasta, nome, ano, genero, pais, fileFinal);
	}
	/**
	 * 
	 * @param origem
	 * 				Diretório de onde a série está no sistema
	 * @param temporada
	 * 				Numero da temporada a ser adicionado
	 * @param nome
	 * 				nome da série a ser adicionado
	 * @param nomeEp
	 * 				nome do episódio a ser adicionado
	 * @param genero
	 * 				genero da série
	 * @param duracao
	 * 				duração do episódio
	 * @param episodio
	 * 				numero do episódio		
	 * @param usrName
	 * 	usuario logado
	 * 
	 */
	public void AddSerie(String origem, String temporada, String nome, String nomeEp, String genero, String duracao, String episodio, String usrName) {
		nome = nome.toLowerCase();
		origem = origem.toLowerCase();
		String nomeEptoFile = episodio + " - "+ nomeEp;
		nomeEp = nomeEp.toLowerCase();
		genero = genero.toLowerCase();
		File destinoPasta = new File("c:\\TecaPlay\\" + usrName + "\\Videos\\serie\\" + genero+ "\\" + nome + "\\" + temporada);
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
		String pasta ="c:\\TecaPlay\\" + usrName + "\\Videos\\serie" ;
		String fileFinal = destinoPasta.getAbsolutePath()+"\\"+newFileName;//pega o caminho final do arquivo e acrescenta
																			//o nome final do arquivo a ser copiado 
		gravarTxt(pasta,nomeEptoFile,temporada,episodio,duracao,genero,fileFinal); // envia os dados para o gravartxt
	}

	/**
	 * 
	 * @param pasta pasta onde sera criado o arquivo txt
	 * @param nomeEp nome que sera adicionado ao arquivo txt
	 * @param ano	ano do filme	
	 * @param genero	genero para a criacao do nome do txt
	 * @param pais	pais
	 * @param file localização final do arquivo movido
	 */
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

	/**
	 * 
	 * @param pasta	 pasta pasta onde sera criado o arquivo txt
	 * @param nomeEp	 nome que sera adicionado ao arquivo txt
	 * @param temporada 	temporada da serie	
	 * @param episodio 		numro do episodio da serie	
	 * @param duracao 	duração	
	 * @param genero	genero para a criacao do nome do txt
	 * @param file		file localização final do arquivo movido
	 */
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
	//exemplo teste
	public boolean retornoPasta(String usrName, String genero) {
		File raiz = new File("c:\\TecaPlay\\"+usrName+"\\Video\\filme\\"+genero);
		File[] files = raiz.listFiles();
		if (!raiz.mkdir())
				return false;
		for (@SuppressWarnings("unused")
		File file : files) {
			System.out.println(raiz.listFiles());
		}
		for (int i = 0; i < files.length; i++) {
			System.out.println(files[i]);
		}
		return false;

	}
}
