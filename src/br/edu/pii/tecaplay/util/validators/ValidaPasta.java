package br.edu.pii.tecaplay.util.validators;

import java.io.File;
/**
 * @version 0.0.57
 * @author jonas
 * @since 05/05/2016
 */
public class ValidaPasta {
	/**
	 * 
	 * @param origem define o caminho do diretório para ser analizado
	 * @return retorna true como sendo caminho de pasta e false como caminho de arquivo
	 */
	public boolean validaPasta(String origem) {
		File arquivo = new File(origem);
		boolean extensao = arquivo.isDirectory();
		System.out.println(extensao);
		if (extensao) {
			return true;
		} else {
			return false;
		}
	}
}
