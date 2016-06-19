package br.edu.pii.tecaplay.util.validators;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import br.edu.pii.tecaplay.util.FileTextProvider;

/**
 * Classe para verifirar as séries já existentes.
 * 
 * @author jonas
 * 
 */
public class GetNameSeries {
	private ArrayList<String> listArrayRetorno = new ArrayList<String>();

	/**
	 * Método que pega o nome das séries.
	 * 
	 * @param userName
	 *            Nome de usuário logado.
	 * @param numOfPart
	 *            Posição no arquivo texto que está o nome.(Passa a posição e
	 *            obtem-se o retorno do nome num arrayList).
	 */
	public GetNameSeries(String userName, int numOfPart) {
		String location = "C:\\TecaPlay\\" + userName + "\\Videos\\serie\\Todas as Series.txt";
		try {
			FileWriter buffer = null;
			buffer = new FileWriter(location, true);
			buffer.close();

		} catch (IOException e) {

		}
		ArrayList<String> listArray = FileTextProvider.loadLines(location);
		listArrayRetorno.add("Selecione ou Crie Nova");
		for (int i = 0; i < listArray.size(); i++) {
			final String[] data = FileTextProvider.readData("#", listArray.get(i));
			listArrayRetorno.add(data[numOfPart]);
		}
	}
	
	/**
	 * @return Retorna uma lista com o nome das séries.
	 */
	public ArrayList<String> RetornoArray() {
		return listArrayRetorno;
	}
}
