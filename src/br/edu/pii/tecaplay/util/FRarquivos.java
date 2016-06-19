package br.edu.pii.tecaplay.util;

import java.io.File;

/**
 * 
 * @author jonas
 * @since 25/04/2016
 *
 */
public class FRarquivos {
	/**
	 * Verifica se existe arquivos � serem listados em tal gen�ro na op��o
	 * Filmes
	 * 
	 * @param usrName
	 *            recebe o nome do usuario que est� logado atualmente
	 * @param genero
	 *            recebe o tipo de genero que foi apertado para ser listado
	 * @return retorna um valor booleano se existe arquivos para serem listado
	 *         em tal genero
	 */
	public static boolean verificaGeneroExistenteFilmes(String usrName, String genero) {
		// string para o caminho do genero
		genero.toLowerCase();
		String caminho = "C:\\TecaPlay\\" + usrName + "\\Videos\\filme\\" + genero + ".txt";
		File file = new File(caminho);

		// verefica se o arquivo existe
		if (!file.exists()) {
			return false;
		} else
			return true;

	}

	/**
	 * Verifica se existe arquivos � serem listados em tal gen�ro na op��o
	 * s�ries
	 * 
	 * @param usrName
	 *            recebe o nome do usuario que est� logado atualmente
	 * @param genero
	 *            recebe o tipo de genero que foi apertado para ser listado
	 * @return retorna um valor booleano se existe arquivos para serem listado
	 *         em tal genero
	 */
	public static boolean verificaGeneroExistenteSerie(String usrName, String genero) {
		// string para o caminho do genero
		genero.toLowerCase();
		String caminho = "C:\\TecaPlay\\" + usrName + "\\Videos\\serie\\" + genero;
		File file = new File(caminho);

		// verefica se o arquivo existe
		if (!file.exists()) {
			return false;
		} else
			return true;

	}
	
	/**
	 * Verifica se existe arquivos � serem listados em tal gen�ro na op��o
	 * Playlist ou Favoritos.
	 * 
	 * @param usrName
	 *            recebe o nome do usuario que est� logado atualmente
	 * @param genero
	 *            recebe o tipo de genero que foi apertado para ser listado
	 * @return 
	 * 		retorna um valor booleano se existe arquivos para serem listado
	 *      em tal genero
	 */

	public static boolean verifyPlaylistOrFavoriteExist(String usrName, String genero) {
		// string para o caminho do genero
		genero.toLowerCase();
		String caminho;
		if(genero.equals("Playlist")){
			caminho = "C:\\TecaPlay\\" + usrName + "\\Musicas\\" + genero;
		}else{
			caminho = "C:\\TecaPlay\\" + usrName + "\\Videos\\" + genero;
		}
		
		File file = new File(caminho);

		// verefica se o arquivo existe
		if (!file.exists()) {
			return false;
		} else
			return true;

	}
	
	/**
	 * Verifica se existe arquivos � serem listados em tal gen�ro na op��o
	 * M�sica.
	 * 
	 * @param usrName
	 *          recebe o nome do usuario que est� logado atualmente.
	 * @param genero
	 *          recebe o tipo de genero que foi apertado para ser listado.
	 * @return 
	 * 			retorna um valor booleano se existe arquivos para serem listado
	 *        	em tal genero.
	 */
	public static boolean verificaGeneroExistenteMusica(String usrName, String genero) {
		// string para o caminho do genero
		genero.toLowerCase();
		String caminho = "C:\\TecaPlay\\" + usrName + "\\Musicas\\" + genero+"\\"+genero+".txt";
		File file = new File(caminho);

		// verefica se o arquivo existe
		if (!file.exists()) {
			return false;
		} else
			return true;

	}

}
