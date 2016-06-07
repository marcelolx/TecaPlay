package br.edu.pii.tecaplay.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import br.edu.pii.tecaplay.ui.FilmesAdd;

/**
 * 
 * @author jonas, Marcelo
 *
 */
public class MoveFile {
	@SuppressWarnings("unused")
	private FileWriter escrita;
	private String usrName = "";

	// Aqui jaz o codigo para mover os arquivos do adicionar.
	/**
	 * @param origem
	 *            Diret�rio de onde o filme est�.
	 * @param ano
	 *            Ano do filme.
	 * @param nome
	 *            Nome do filme.
	 * @param genero
	 *            G�nero do filme
	 * @param duracao
	 *            Dura��o do filme.
	 * @param pais
	 *            Pa�s onde o filme foi lan�ado.
	 * @param tipo
	 *            v�riavel que vai armazenar se � filme, anime ou s�rie.
	 * @param usrName
	 *            Armazena o nome do usu�rio atual logado no TecaPlay.
	 */
	public boolean AddFilme(String origem, String ano, String nome, String genero, String duracao, String pais,
			String userName) {
		usrName = userName;
		origem = origem.toLowerCase();
		genero = genero.toLowerCase();
		File destinoPasta = new File("c:\\TecaPlay\\" + usrName + "\\Videos\\filme\\" + genero);
		if (!(destinoPasta).exists()) {
			destinoPasta.mkdirs();
		}
		File arquivo = new File(origem);
		// pegando a extensao do arquivo a ser movido e renomeando o arquivo.
		String extensao = arquivo.getName().substring(arquivo.getName().lastIndexOf('.', arquivo.getName().length()));
		String newFileName = nome + extensao;
		boolean ok = arquivo.renameTo(new File(destinoPasta, newFileName));

		if (ok) {
			String pasta = "c:\\TecaPlay\\" + usrName + "\\Videos\\filme";
			String fileFinal = destinoPasta.getAbsolutePath() + "\\" + newFileName;
			gravarTxtFilmes(pasta, nome, ano, genero, pais, fileFinal);
			return true;
		} else {
			return false;
		}

	}

	/**
	 * 
	 * @param origem
	 *            Diret�rio de onde a s�rie est� no sistema
	 * @param temporada
	 *            Numero da temporada a ser adicionado
	 * @param nomeSerie
	 *            nome da s�rie a ser adicionado
	 * @param nomeEp
	 *            nome do epis�dio a ser adicionado
	 * @param genero
	 *            genero da s�rie
	 * @param duracao
	 *            dura��o do epis�dio
	 * @param episodio
	 *            numero do epis�dio
	 * @param usrName
	 *            usuario logado
	 * 
	 */

	public boolean AddSerie(String origem, String temporada, String nomeSerie, String nomeEp, String genero,
			String duracao, String episodio, String userName) {
		
		origem = origem.toLowerCase();
		usrName = userName;
		String nomeEptoFile = episodio + " - " + nomeEp;
		nomeEp = nomeEp.toLowerCase();
		genero = genero.toLowerCase();
		File destinoPasta = new File(
				"c:\\TecaPlay\\" + usrName + "\\Videos\\serie\\" + genero + "\\" + nomeSerie.toLowerCase() + "\\" + temporada);
		if (!(destinoPasta).exists()) {
			destinoPasta.mkdirs();
		}
		File arquivo = new File(origem);
		// pegando a extensao do arquivo a ser movido e renomeando o arquivo.
		String extensao = arquivo.getName().substring(arquivo.getName().lastIndexOf('.', arquivo.getName().length()));
		String newFileName = nomeEptoFile + extensao;

		boolean ok = arquivo.renameTo(new File(destinoPasta, newFileName));

		if (ok) {
			String pasta = "c:\\TecaPlay\\" + usrName + "\\Videos\\serie";
			String fileFinal = destinoPasta.getAbsolutePath() + "\\" + newFileName;// pega
																					// o
																					// caminho
																					// final
																					// do
																					// arquivo
																					// e
																					// acrescenta
																					// //o
																					// nome
																					// final
																					// do
																					// arquivo
																					// a
																					// ser
																					// copiado
			gravarTxt(pasta, nomeSerie, temporada, episodio, duracao, genero, fileFinal,nomeEp); // envia
																							// os
																							// dados
																							// para
																							// o
																							// gravartxt
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 
	 * @param pasta
	 *            pasta onde sera criado o arquivo txt
	 * @param nomeEp
	 *            nome que sera adicionado ao arquivo txt
	 * @param ano
	 *            ano do filme
	 * @param genero
	 *            genero para a criacao do nome do txt
	 * @param pais
	 *            pais
	 * @param file
	 *            localiza��o final do arquivo movido
	 */
	public void gravarTxtFilmes(String pasta, String nome, String ano, String genero, String pais, String file) {
		// string que serve para fazer a criacao do txt
		String criarTxt = pasta + "\\" + genero + ".txt";

		// grava as informa�es no txt
		try {
			FileWriter buffer = null;
			buffer = new FileWriter(criarTxt, true);
			String text = nome + "#" + genero + "#" + pais + "#" + ano + "#" + file;
			buffer.write(text + "\r\n");
			buffer.close();
		} catch (IOException e21) {
		}
	}
	// gravarTxt s� est� apto para s�ries, necess�rio criar outro para filmes,
	// o mesmo pode ser utilizado para animes tamb�m.

	/**
	 * Fun��o realizada ap�s adicionar nova s�rie.
	 * ele ir� acionar tambem a classe SerieExiste, para verificar se a s�rie � nova ou n�o
	 * sendo nova, ele ir� adicionar o nome da nova s�rie no campo "Seriado" do JcomboBox
	 * 
	 * @param pasta
	 *            pasta do usuario na categoria s�ries
	 * @param nomeSerie
	 *            nome do seriado para servir de base de verifica��o de existencia de s�rie 
	 *            e listagem das s�ries
	 * @param temporada
	 *            numero da temporada da serie
	 * @param episodio
	 *            numero do episodio da serie
	 * @param duracao
	 *            dura��o m�dio do epis�dio
	 * @param genero
	 *            genero para a criacao do nome do txt(Ex: A��o)
	 * @param file
	 *            file localiza��o final da s�rie do arquivo movido
	 */
	public void gravarTxt(String pasta, String nomeSerie, String temporada, String episodio, String duracao,
			String genero, String file,String nomeEp) {
		// String do diretorio do TXT
		String criarTemp = pasta + "\\" + genero + "\\nomeSerie\\" + nomeSerie.toLowerCase() + ".txt";
		File pastaCriar = new File(pasta + "\\" + genero + "\\nomeSerie");
		if (!pastaCriar.exists()) {
			pastaCriar.mkdirs();
		}
		try {
			FileWriter buffer = null;
			buffer = new FileWriter(criarTemp, true);
			String texto = temporada + "#" + episodio + "#" + nomeSerie.toLowerCase() + "#"  + nomeEp.toLowerCase() + "#" + duracao + "#" + file;
			buffer.write(texto + "\r\n");
			buffer.close();
		} catch (IOException e) {

		}
		boolean sucesso = SerieExiste(nomeSerie, genero);
		if (sucesso) {
			new FilmesAdd(usrName);
		}

	}

	/**
	 * Verifica se a s�rie existe. caso o teste resulta que nao existe tal s�rie,
	 * ser� adicionada no arquivo txt.
	 * @param nomeSerie Nome da s�rie adicionado
	 * @param genero seu respectivo genero
	 * @return se a s�rie for nova, retorna verdadeiro e recarrega a pagina para a nova listagem
	 * das s�ries existentes
	 */
	public boolean SerieExiste(String nomeSerie, String genero) {
		String location = "C:\\TecaPlay\\" + usrName + "\\Videos\\serie\\Todas as Series.txt";
		ArrayList<String> fileProvider = FileTextProvider.loadLines(location);
		boolean existe = false;
		for (int i = 0; i < fileProvider.size(); i++) {
			final String[] data = FileTextProvider.readData("#", fileProvider.get(i));
			if (data[0].equals(nomeSerie)) {
				existe = true;
				break;
			}

		}
		if (!existe) {
			System.out.println("Entrou");
			try {
				FileWriter buffer = null;
				buffer = new FileWriter(location, true);
				String texto = nomeSerie + "#" + genero;
				buffer.write(texto + "\r\n");
				buffer.close();
				return true;
			} catch (IOException e) {
				return false;
			}
			
		}
		return false;
	}

}
