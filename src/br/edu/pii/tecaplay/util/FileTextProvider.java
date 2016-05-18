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
 * @since 08/05/2016
 * @author Marcelo
 * Classe que vai trabalhar na leitura dos arquivos .txt e recuperar as informações necessárias.
 */
public class FileTextProvider {
	 private static int numLines;
	private static LineNumberReader lineRead;
	/**
	 * @param path
	 * 		Passa o caminho do arquivo .txt
	 * @return
	 * 		Retorna um ArrayList com todas as linhas gravadas no arquivo.
	 */
    public static ArrayList<String> loadLines(String path){
        File arq = new File(path);
        System.out.println(arq.getAbsolutePath());
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
           
            lineRead = new LineNumberReader(new InputStreamReader(in));
            lineRead.skip(lengthFile);
            // conta o numero de linhas do arquivo
            numLines = lineRead.getLineNumber();
            //
            fs.close();
            in.close();
            return lista;
        }catch (Exception ex){

            return null;
        }
    }
    /**
     * 
     * @param separador
     * 		Caractere a ser usado como separador.
     * @param linha
     * 		Linha a ser percorrida.
     * @return
     * 		Retorna a String quebrada.
     */
    public static String[] readData(String separador, String linha){
        return linha.split(separador);
    }
    /**
     * 
     * @return
     * 	Retorna o número total de linhas que um arquivo possui.
     */
    public int numOfLines(){
    	return numLines;
    }
}
