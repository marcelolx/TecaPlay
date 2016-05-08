package br.edu.pii.tecaplay.util;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.ArrayList;

public class FileTextProvider {
	 private static int numLines;
	//Recebe como parãmetro o path do arquivo a ser lido
    //Retorna um ArrayList com todas as linhas gravadas no arquivo
    public static ArrayList<String> loadLines(String path){
        File arq = new File(path);
        try {
            FileReader fr = new FileReader(arq);
            BufferedReader br = new BufferedReader(fr);
            String linha=null;
            ArrayList<String> lista = new ArrayList<String>();
            while ((linha = br.readLine()) != null) {
                lista.add(linha);
            }
            br.close();
            fr.close();
            //contar o número de linhas no arquivo, já que esse valor sempre vai variar.
            // pega o tamanho
            long lengthFile = arq.length();
            FileInputStream fs = new FileInputStream(arq);
            DataInputStream in = new DataInputStream(fs);
           
            LineNumberReader lineRead = new LineNumberReader(new InputStreamReader(in));
            lineRead.skip(lengthFile);
            // conta o numero de linhas do arquivo
            numLines = lineRead.getLineNumber();
            //
            return lista;
        }catch (Exception ex){

            return null;
        }
    }

    //Recebe como parametro o simbolo separador e uma linha
    //e retorna um vetor de String preenchido com todos os dados separados pelo separado
    public static String[] readData(String separador, String linha){
        return linha.split(separador);
    }
    
    public int numOfLines(){
    	return numLines;
    }
}
