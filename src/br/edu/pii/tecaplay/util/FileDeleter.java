package br.edu.pii.tecaplay.util;

import java.io.File;

/**
 * Remove folder if she is empty.
 * 
 * @author Jonas
 *
 */
public class FileDeleter {
	/**
	 * 
	 * @param PatchName folder name
	 * @param genero
	 * @return true or false
	 */
	public static boolean deletarPasta(String patchName, String genero){
		File remo = new File(patchName);
		File remo2 = new File(patchName);
		if (remo.delete() && remo2.delete()) {
			return true;
		}
		return false;
	}
}
