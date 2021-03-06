package br.edu.pii.tecaplay.util.optimizationgui;

import java.util.ArrayList;

/**
 * Classe que cont�m os ArrayList com os nomes do bot�es das categorias de Filmes, S�ries e M�sicas.
 * 
 * @author Jonas
 *
 */
public class ArrayCategorias {
	/**
	 * ArrayList para o nome dos bot�es das categorias do tipo Filmes.
	 * 
	 * @return o ArrayList com os nomes.
	 */
	public static ArrayList<String> addFilmes() {
		ArrayList<String> listaGeneroFilmes = new ArrayList<>();
		listaGeneroFilmes.add("A��o");
		listaGeneroFilmes.add("Anima\u00E7\u00E3o");
		listaGeneroFilmes.add("Aventura");
		listaGeneroFilmes.add("Cl\u00E1ssico");
		listaGeneroFilmes.add("Com\u00E9dia");
		listaGeneroFilmes.add("Com\u00E9dia Rom\u00E2ntica");
		listaGeneroFilmes.add("Crime");
		listaGeneroFilmes.add("Document\u00E1rio");
		listaGeneroFilmes.add("Drama");
		listaGeneroFilmes.add("Faroeste");
		listaGeneroFilmes.add("Fic\u00E7\u00E3o Cientifica");
		listaGeneroFilmes.add("Guerra");
		listaGeneroFilmes.add("Musical");
		listaGeneroFilmes.add("Policial");
		listaGeneroFilmes.add("Romance");
		listaGeneroFilmes.add("Suspense");
		listaGeneroFilmes.add("Terror");
		listaGeneroFilmes.add("Thriller");
		return listaGeneroFilmes;
	}

	/**
	 * ArrayList para o nome dos bot�es das categorias do tipo S�ries.
	 * 
	 * @return o ArrayList com os nomes.
	 */
	public static ArrayList<String> addSeries() {
		ArrayList<String> listaGenero = new ArrayList<>();
		listaGenero.add("A\u00E7\u00E3o");
		listaGenero.add("Anima\u00E7\u00E3o");
		listaGenero.add("Aventura");
		listaGenero.add("Cl\u00E1ssico");
		listaGenero.add("Com\u00E9dia");
		listaGenero.add("Com\u00E9dia Rom\u00E2ntica");
		listaGenero.add("Crime");
		listaGenero.add("Document\u00E1rio");
		listaGenero.add("Drama");
		listaGenero.add("Faroeste");
		listaGenero.add("Fic\u00E7\u00E3o Cientifica");
		listaGenero.add("Guerra");
		listaGenero.add("M�dico");
		listaGenero.add("Musical");
		listaGenero.add("Policial");
		listaGenero.add("Romance");
		listaGenero.add("Suspense");
		listaGenero.add("Terror");
		return listaGenero;
	}

	/**
	 * ArrayList para o nome dos bot�es das categorias do tipo M�sica.
	 * 
	 * @return o ArrayList com os nomes.
	 */
	public static ArrayList<String> addMusicas() {
		ArrayList<String> listaGenero = new ArrayList<>();
		listaGenero.add("Antigas");
		listaGenero.add("Ax�");
		listaGenero.add("Black");
		listaGenero.add("Brega");
		listaGenero.add("Dance");
		listaGenero.add("Eletr�nica");
		listaGenero.add("Funk");
		listaGenero.add("Forr�");
		listaGenero.add("Folcl�ricas");
		listaGenero.add("Gospel");
		listaGenero.add("Internacionais");
		listaGenero.add("Moda de Viola");
		listaGenero.add("Novas");
		listaGenero.add("Pagode");
		listaGenero.add("Romantica");
		listaGenero.add("Reagge");
		listaGenero.add("Samba");
		listaGenero.add("Sertaneja");
		return listaGenero;
	}
}
