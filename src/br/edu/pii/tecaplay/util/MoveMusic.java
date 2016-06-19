
package br.edu.pii.tecaplay.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 
 * @author jonas
 * @since 17/05/2016
 *
 */
public class MoveMusic {
	@SuppressWarnings("unused")
	private FileWriter escrita;

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
	public static boolean addMusica(String origem, String ano, String nome, String genero, String usrName,
			String artista) {
		origem = origem.toLowerCase();
		genero = genero.toLowerCase();
		File destinoPasta = new File("c:\\TecaPlay\\" + usrName + "\\Musicas\\" + genero);
		if (!(destinoPasta).exists()) {
			destinoPasta.mkdirs();
		}
		File arquivo = new File(origem);
		// pegando a extensao do arquivo a ser movido e renomeando o arquivo.
		String extensao = arquivo.getName().substring(arquivo.getName().lastIndexOf('.', arquivo.getName().length()));
		String newFileName = nome + extensao;
		boolean ok = arquivo.renameTo(new File(destinoPasta, newFileName));

		if (ok) {
			String pasta = "c:\\TecaPlay\\" + usrName + "\\Musicas\\" + genero;
			String fileFinal = destinoPasta.getAbsolutePath() + "\\" + newFileName;
			boolean txt = gravarTxtMusica(pasta, nome, ano, genero, fileFinal, artista);
			if (txt) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}

	}

	/**
	 * 
	 * @param pasta
	 *            pasta onde sera criado o arquivo txt
	 * @param nome
	 *            nome que sera adicionado ao arquivo txt
	 * @param ano
	 *            ano da m�sica
	 * @param genero
	 *            genero para a criacao do nome do txt
	 * @param artista
	 *            nome do artista.
	 * @param file
	 *            localiza��o final do arquivo movido
	 */
	public static boolean gravarTxtMusica(String pasta, String nome, String ano, String genero, String file,
			String artista) {
		// string que serve para fazer a criacao do txt
		String criarTxt = pasta + "\\" + genero + ".txt";

		// grava as informa�es no txt
		try {
			FileWriter buffer = null;
			buffer = new FileWriter(criarTxt, true);
			String text = nome + "#" + genero + "#" + artista + "#" + ano + "#" + file;
			buffer.write(text + "\r\n");
			buffer.close();
		} catch (IOException e21) {
			return false;
		}
		return true;
	}
}
