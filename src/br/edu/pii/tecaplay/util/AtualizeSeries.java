package br.edu.pii.tecaplay.util;

import java.io.File;
import java.util.ArrayList;

public class AtualizeSeries {
	private ArrayList<String> namesSeries = new ArrayList<>();
	private String nameSerie = null;
	private int size = 0;
	
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
	public String NameSeries(int i) {
		nameSerie = namesSeries.get(i);
		return nameSerie;
	}
	public int Size() {
		return size;
	}
	
}
