package br.edu.pii.tecaplay.util;

import java.io.File;
/**
 * Deleta o arquivo que é recebido
 *
 * @author Jonas
 */
public class DeleteArchive {
	/**
	 * 
	 * @param filePa Arquivo a ser removido
	 * @return true se consegue
	 */
	public boolean remove(String filePa) {
		File directory = new File(filePa);
		boolean sucess = directory.delete();
		if (sucess) {
			return true;
		}else{
		return false;

		}}

	
}
