package br.edu.pii.tecaplay.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 
 * @author jonas, Marcelo
 *
 */
public class MoveFile {
	@SuppressWarnings("unused")
	private FileWriter escrita;
	// Aqui jaz o codigo para mover os arquivos do adicionar.
	/**
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
	public boolean AddFilme(String origem, String ano, String nome, String genero, String duracao, String pais, String usrName) {
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
			String pasta ="c:\\TecaPlay\\" + usrName + "\\Videos\\filme"  ;
			String fileFinal = destinoPasta.getAbsolutePath()+"\\"+newFileName;
			gravarTxtFilmes(pasta, nome, ano, genero, pais, fileFinal);
			return true;
		} else {
			return false;
		}
	
	}
	/**
	 * 
	 * @param origem
	 * 				Diret�rio de onde a s�rie est� no sistema
	 * @param temporada
	 * 				Numero da temporada a ser adicionado
	 * @param nome
	 * 				nome da s�rie a ser adicionado
	 * @param nomeEp
	 * 				nome do epis�dio a ser adicionado
	 * @param genero
	 * 				genero da s�rie
	 * @param duracao
	 * 				dura��o do epis�dio
	 * @param episodio
	 * 				numero do epis�dio		
	 * @param usrName
	 * 	usuario logado
	 * 
	 */
	public boolean AddSerie(String origem, String temporada, String nome, String nomeEp, String genero, String duracao, String episodio, String usrName) {
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
			String pasta ="c:\\TecaPlay\\" + usrName + "\\Videos\\serie" ;
			String fileFinal = destinoPasta.getAbsolutePath()+"\\"+newFileName;//pega o caminho final do arquivo e acrescenta																		//o nome final do arquivo a ser copiado 
			gravarTxt(pasta,nomeEptoFile,temporada,episodio,duracao,genero,fileFinal); // envia os dados para o gravartxt
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 
	 * @param pasta pasta onde sera criado o arquivo txt
	 * @param nomeEp nome que sera adicionado ao arquivo txt
	 * @param ano	ano do filme	
	 * @param genero	genero para a criacao do nome do txt
	 * @param pais	pais
	 * @param file localiza��o final do arquivo movido
	 */
	public void gravarTxtFilmes(String pasta, String nome, String ano, String genero, String pais, String file){
		//string que serve para fazer a criacao do txt
		String criarTxt = pasta + "\\" + genero + ".txt";
		
		//grava as informa�es no txt
		try{
			FileWriter buffer = null;
			buffer = new FileWriter(criarTxt, true);
			String text = nome+"#"+genero+"#"+pais+"#"+ano+"#"+file;
			buffer.write(text+"\r\n");
			buffer.close();
		}catch(IOException e21){
		}
	}
	//gravarTxt s� est� apto para s�ries, necess�rio criar outro para filmes,
	//o mesmo pode ser utilizado para animes tamb�m.

	/**
	 * 
	 * @param pasta	 pasta pasta onde sera criado o arquivo txt
	 * @param nomeEp	 nome que sera adicionado ao arquivo txt
	 * @param temporada 	temporada da serie	
	 * @param episodio 		numro do episodio da serie	
	 * @param duracao 	dura��o	
	 * @param genero	genero para a criacao do nome do txt
	 * @param file		file localiza��o final do arquivo movido
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
		}
	}
}
