package br.edu.pii.tecaplay.util;

import java.io.File;

public class DeleteArchive {
	public boolean remove(String filePa) {
		File directory = new File(filePa);
		boolean sucess = directory.delete();
		if (sucess) {
			return true;
		}else{
		return false;

		}}

	
}
