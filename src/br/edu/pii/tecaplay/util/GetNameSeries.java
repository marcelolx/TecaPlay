/**
 * 
 */
package br.edu.pii.tecaplay.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author jonas
 *	Classe para verifirar as séries já existentes
 * 
 */
public class GetNameSeries {
	private ArrayList<String> listArrayRetorno= new ArrayList<String>();
	public GetNameSeries(String userName, int numOfPart){
		String location = "C:\\TecaPlay\\"+ userName + "\\Videos\\serie\\Todas as Series.txt";
		FileTextProvider file = new FileTextProvider();
		try {
			FileWriter buffer = null;
			buffer = new FileWriter(location, true);
			buffer.close();
		
		} catch (IOException e) {
		
		}
		ArrayList<String>listArray = file.loadLines(location);
		listArrayRetorno.add("Selecione ou Crie Nova");
		for (int i = 0; i < listArray.size(); i++) {
			final String[] data = FileTextProvider.readData("#", listArray.get(i));
			listArrayRetorno.add(data[numOfPart]);
		}
	}
	public ArrayList<String> RetornoArray() {
		return listArrayRetorno;
	}
}
