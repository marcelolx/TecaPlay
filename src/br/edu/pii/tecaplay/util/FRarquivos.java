package br.edu.pii.tecaplay.util;

import java.io.File;

public class FRarquivos{
	public boolean VerificaGeneroExistente(String usrName, String genero) {
		//string para o caminho do genero
		genero.toLowerCase();
		String caminho = "C:\\TecaPlay\\"+usrName+"\\Videos\\filme\\"+genero+".txt";
		File file = new File(caminho);
		
		//verefica se o arquivo existe
        if(!file.exists()){
        	return false;
        }
        else
        	return true;
        

	}
	public boolean VerificaGeneroExistenteSerie(String usrName, String genero) {
		//string para o caminho do genero
		genero.toLowerCase();
		String caminho = "C:\\TecaPlay\\"+usrName+"\\Videos\\serie\\"+genero+".txt";
		File file = new File(caminho);
		
		//verefica se o arquivo existe
        if(!file.exists()){
        	return false;
        }
        else
        	return true;
        

	}

}
