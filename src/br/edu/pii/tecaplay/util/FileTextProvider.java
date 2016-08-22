package br.edu.pii.tecaplay.util;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.ArrayList;
/**
 * Read .txt files and recover informations.
 * 
 * @since 08/05/2016
 * @author Marcelo
 */
public class FileTextProvider {
	 private static int numLines;
	private static LineNumberReader lineRead;
	/**
	 * @param path src of ile
	 * @return return an ArrayList with all lines of the file
	 */
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
            //count number of lines into file
            long lengthFile = arq.length();
            FileInputStream fs = new FileInputStream(arq);
            DataInputStream in = new DataInputStream(fs);
           
            lineRead = new LineNumberReader(new InputStreamReader(in));
            lineRead.skip(lengthFile);
            numLines = lineRead.getLineNumber();
            fs.close();
            in.close();
            return lista;
        }catch (Exception ex){

            return null;
        }
    }
    /**
     * 
     * @param separador caracter spliter.
     * @param linha row to be traveled
     * @return return line splited.
     */
    public static String[] readData(String separador, String linha){
        return linha.split(separador);
    }
    /**
     * 
     * @return return total lines of file have
     */
    public int numOfLines(){
    	return numLines;
    }
}
