package br.edu.pii.tecaplay.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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
	private String criarTxt;

	public void Remove(String userName, int line, String generos, int lines) {
		genero = generos.toLowerCase();
		usrName = userName;
		locationFile = "c:\\TecaPlay\\" + usrName + "\\Videos\\filme\\" + genero + ".txt";
		criarTxt = "c:\\TecaPlay\\" + usrName + "\\Videos\\filme\\" + genero + "1.txt";
	
		try {
			file = new File(locationFile);
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String linha = null;
			ArrayList<String> lista = new ArrayList<String>();
			while ((linha = br.readLine()) != null) {
				lista.add(linha);
			}
			FileWriter buffer = null;
			buffer = new FileWriter(criarTxt, true);
			// lê as linhas antes do arquivo a ser excluido
			for (int i = 0; i < line; i++) {
				final String[] data = FileTextProvider.readData("#", lista.get(i));
				// grava as informaões no txt
				try {
					String text = data[0] + "#" + genero + "#" + data[2] + "#" + data[3] + "#" + data[4] + "#Assistir";
					buffer.write(text + "\r\n");
				} catch (IOException e21) {

				}
			}
			// lê as linhas depois do arquivo a ser excluido
			for (int i = line + 1; i < lines; i++) {
				// pega o que tem na linha e divide
				final String[] data = FileTextProvider.readData("#", lista.get(i));
				// grava as informaões no txt
				try {
					String text = data[0] + "#" + genero + "#" + data[2] + "#" + data[3] + "#" + data[4] + "#Assistir";
					buffer.write(text + "\r\n");
				} catch (IOException e) {
				}
			}
			buffer.flush();
			buffer.close();
			br.close();
			fr.close();

		} catch (Exception ex) {
			System.out.println("Erro no RemoveFile");
		}

	}

	public boolean teste() {
		if (file.canExecute()){
			boolean teste = file.delete();
			if (teste) {
				System.out.println("Arquivo Excluído");
			} else {
				System.out.println("Arquivo não Removido");
			}
		}

		File arquivo = new File(criarTxt);
		String extensao = arquivo.getName().substring(arquivo.getName().lastIndexOf('.', arquivo.getName().length()));
		String newFileName = genero + extensao;
		File destinoPasta = new File("c:\\TecaPlay\\" + usrName + "\\Videos\\filme\\" + genero);
		boolean ok = arquivo.renameTo(new File(destinoPasta, newFileName));
		if (!ok) {
			return false;
		}
		return true;
	}
}
