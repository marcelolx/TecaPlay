package br.edu.pii.tecaplay.util;

import java.io.File;

/**
 * Classe para remover os arquivos se alguma pasta esta vazia e sem arquivos
 * @author jonas
 *
 */
public class FileDeleter {
	/**
	 * 
	 * @param PatchName nome da pasta com o genero
	 * @param genero - genero
	 * @return se falso não foi excluido, true, ao contrario
	 */
	public static boolean deletarPasta(String patchName, String genero){
		File remo = new File(patchName);
		File remo2 = new File(patchName);
		if (remo.delete()&&remo2.delete()) {
			return true;
		}
		return false;
	}
}
