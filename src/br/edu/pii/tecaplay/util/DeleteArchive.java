package br.edu.pii.tecaplay.util;

import java.io.File;
/**
 * Remove file
 *
 * @author Jonas
 */
public class DeleteArchive {
	/**
	 * 
	 * @param filePa Path of file to remove
	 * @return true or false
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
