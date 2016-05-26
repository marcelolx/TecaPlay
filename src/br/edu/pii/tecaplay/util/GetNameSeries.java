/**
 * 
 */
package br.edu.pii.tecaplay.util;

import java.io.File;
import java.util.ArrayList;

/**
 * @author jonas
 *	Classe para verifirar as séries já existentes
 * 
 */
public class GetNameSeries {
	private ArrayList<String> listArray= new ArrayList<String>();
	public GetNameSeries(String userName){
		String location = "C:\\TecaPlay\\"+ userName + "\\Videos\\serie\\Todas as Series";
		File file = new File(location);
		if (!file.exists()) {
			file.mkdir();
		}
		File[] list = file.listFiles();
		listArray.add("Selecione ou Crie Nova");
		for (int i = 0; i < list.length; i++) {
			String name = list[i].getName();
			listArray.add(name);
		}
	}
	public ArrayList<String> RetornoArray() {
		return listArray;
	}
}
