package br.edu.pii.tecaplay.util;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class RemoveFile {
	private String locationFile;
	private String genero;
	private String usrName;
	private String criarTxt;
	public void Remove(String userName, int line, String generos, int lines) {
		genero = generos.toLowerCase();
		usrName = userName;
		locationFile = "c:\\TecaPlay\\" + usrName + "\\Videos\\filme\\"+genero+".txt";
		criarTxt ="c:\\TecaPlay\\" + usrName + "\\Videos\\filme\\"+genero+"1.txt";
		   File arq = new File(locationFile);
	        try {
	            FileReader fr = new FileReader(arq);
	            BufferedReader br = new BufferedReader(fr);
	            String linha=null;
	            ArrayList<String> lista = new ArrayList<String>();
	            while ((linha = br.readLine()) != null) {
	                lista.add(linha);
	            }
	            FileWriter buffer = null;
    			buffer = new FileWriter(criarTxt, true);
    			// l� as linhas antes do arquivo a ser excluido
	            for (int i = 0; i < line; i++) {
	            	final String[] data = FileTextProvider.readData("#", lista.get(i));
	        		//grava as informa�es no txt
	        		try{
	        			String text = data[0]+"#"+genero+"#"+data[2]+"#"+data[3]+"#"+data[4]+"#Assistir";
	        			buffer.write(text+"\r\n");
	        		}catch(IOException e21){
	        			
	        		}
				}
	         // l� as linhas depois do arquivo a ser excluido
	            for(int i = line+1; i<lines; i++){
	            	//pega o que tem na linha e divide 
	            	final String[] data = FileTextProvider.readData("#", lista.get(i));
	        		//grava as informa�es no txt
	        		try{
	        			String text = data[0]+"#"+genero+"#"+data[2]+"#"+data[3]+"#"+data[4]+"#Assistir";
	        			buffer.write(text+"\r\n");
	        		
	        		}catch(IOException e){
	        			
	        		}
				}
	            buffer.flush();
	        	buffer.close();
	            br.close();
	            fr.close();
	            //Remove e renomeia o arquivo
	           
	       
	}catch (Exception ex){
		System.out.println("Erro no RemoveFile");
    }
	
}
	public void teste() {
		 File arquivoRemovido = new File(locationFile);
         if (arquivoRemovido.canRead()){
         	  boolean teste = arquivoRemovido.delete();
	            if (teste) {
					System.out.println("Arquivo Excluido");
				}else{
					System.out.println("Arquivo n�o Removido");
				}
					
         } else {
         	System.out.println("Arquivo n�o existe");
         }
    System.out.println(arquivoRemovido);
         File arquivo = new File(criarTxt);
         String extensao = arquivo.getName().substring(arquivo.getName().lastIndexOf('.', arquivo.getName().length()));
 		String newFileName = genero+ extensao;
 		File destinoPasta = new File("c:\\TecaPlay\\" + usrName + "\\Videos\\filme\\" + genero);
 		boolean ok = arquivo.renameTo(new File(destinoPasta, newFileName));
 		if (ok){
 			System.out.println("Arquivo excluido");
 		}else {
 			System.out.println("n�o foi possiver renomear");
 		}
     
	}
}
