package br.edu.pii.tecaplay.util.validators;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import br.edu.pii.tecaplay.util.FileTextProvider;

/**
 * Classe para verifirar as s�ries j� existentes.
 * 
 * @author jonas
 * 
 */
public class GetNameSeries {
	private ArrayList<String> listArrayRetorno = new ArrayList<String>();

	/**
	 * M�todo que pega o nome das s�ries.
	 * 
	 * @param userName
	 *            Nome de usu�rio logado.
	 * @param numOfPart
	 *            Posi��o no arquivo texto que est� o nome.(Passa a posi��o e
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
	 * @return Retorna uma lista com o nome das s�ries.
	 */
	public ArrayList<String> RetornoArray() {
		return listArrayRetorno;
	}
}
