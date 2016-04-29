package br.edu.pii.tecaplay.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class FRarquivos{
	public boolean VerificaGeneroExistente(String usrName, String genero) {
		//string para o caminho do genero
		String caminho = "C:\\TecaPlay\\"+usrName+"\\Videos\\filme\\"+genero+".txt";
		File file = new File(caminho);
		
		//verefica se o arquivo existe
        if(!file.exists()){
        	return false;
        }
        else
        	return true;
        

	}

}
