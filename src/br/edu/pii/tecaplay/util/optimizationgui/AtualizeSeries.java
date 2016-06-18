package br.edu.pii.tecaplay.util.optimizationgui;

import java.io.File;
import java.util.ArrayList;
/**
 * Atualiza as séries
 * @author jonas
 *
 */
public class AtualizeSeries {
	private ArrayList<String> namesSeries = new ArrayList<>();
	private int size = 0;
	/**
	 * verifica se contem series no genero
	 * @param userName usuario logado
	 * @param currentGenero genero atual
	 */
	public AtualizeSeries(String userName, String currentGenero) {
		String location = "C:\\TecaPlay\\"+ userName + "\\Videos\\serie\\"+ currentGenero;
		File test = new File(location);
		if (!test.exists()) {
			test.mkdir();
		}
		File[] list = test.listFiles();
		for (int i = 0; i < list.length; i++) {
			String name = list[i].getName();
			namesSeries.add(name);
		}
		size = namesSeries.size();

	}
	/**
	 * 
	 * @param i linha para pegar
	 * @return o nome da serie
	 */
	public String NameSeries(int i) {
		String nameSerie = namesSeries.get(i);
		return nameSerie;
	}
	/**
	 * Tamanho de todas as linhas
	 * @return linha total do array
	 */
	public int Size() {
		return size;
	}
	
}
