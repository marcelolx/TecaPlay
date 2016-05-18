package br.edu.pii.tecaplay.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
/**
 * Classe que remove os arquivos quando o usuario aperta o botao remover da lista
 * @author jonas
 *
 */
public class RemoveFile {
	private String locationFile;
	private String genero;
	private String usrName;
	private File file;
	private File arquivo;
	
	
	public void Remove(String userName, int line, String generos, int lines) {
		genero = generos.toLowerCase();
		usrName = userName;
		locationFile = "c:\\TecaPlay\\" + usrName + "\\Videos\\filme\\" + genero + ".txt";
		arquivo = new File(locationFile);
		try {
			file = new File(locationFile);
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String linha = null;
			ArrayList<String> lista = new ArrayList<String>();
			ArrayList<String> listaFinal = new ArrayList<String>();
			while ((linha = br.readLine()) != null) {
				lista.add(linha);
			}
			
	
			// lê as linhas antes do arquivo a ser excluido
			for (int i = 0; i < line; i++) {
				final String[] data = FileTextProvider.readData("#", lista.get(i));
				// grava as informaões no txt
					String text = data[0] + "#" + genero + "#" + data[2] + "#" + data[3] + "#" + data[4] + "#Assistir";
					listaFinal.add(text);
					
			}
			// lê as linhas depois do arquivo a ser excluido
			for (int i = line + 1; i < lines; i++) {
				// pega o que tem na linha e divide
				final String[] data = FileTextProvider.readData("#", lista.get(i));
				// grava as informaões no txt
					String text = data[0] + "#" + genero + "#" + data[2] + "#" + data[3] + "#" + data[4];
					listaFinal.add(text);

				
			}
			FileWriter buffer = null;
			buffer = new FileWriter(locationFile,false);
			for (int i = 0; i < listaFinal.size(); i++) {
				buffer.write(listaFinal.get(i) + "\r\n");
			}
			buffer.flush();
			buffer.close();
			br.close();
			fr.close();
		} catch (Exception ex) {
			System.out.println("Erro no RemoveFile");
		}

}
}