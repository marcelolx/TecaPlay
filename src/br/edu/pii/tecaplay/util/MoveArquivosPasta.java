package br.edu.pii.tecaplay.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

/**
 * @version 0.0.57
 * @author jonas
 * @since 05/05/2016
 *
 */
public class MoveArquivosPasta {
	/**
	 * 
	 * @param origem
	 * 				Diretório de onde a série está no sistema
	 * @param temporada
	 * 				Numero da temporada a ser adicionado
	 * @param nome
	 * 				nome da série a ser adicionado
	 * @param nomeEp
	 * 				nome do episódio a ser adicionado
	 * @param genero
	 * 				genero da série
	 * @param duracao
	 * 				duração do episódio
	 * @param episodio
	 * 				numero do episódio		
	 * @param usrName
	 * 	usuario logado
	 * 
	 */
	public boolean MovePasta(String origem, String temporada, String nome, String nomeEp, String genero, String duracao, String episodio, String usrName){
		File raiz = new File(origem);
		File[] files = raiz.listFiles();
		boolean contemPastas = false;
		for (int i = 0; i < files.length; i++) {
			contemPastas = files[i].isDirectory();
			if (contemPastas){
				return false;
			}
				
		}
		int epis = Integer.parseInt(episodio);
		for (int i = 0; i < files.length; i++) {
			boolean retorno = AddSerie(files[i].getAbsolutePath(), temporada, nome, nomeEp, genero, duracao, epis++, usrName);
			if (!retorno) {
				return false;
			}
		}
		return true;
	}
	/**
	 * 
	 * @param origem
	 * 				Diretório de onde a série está no sistema
	 * @param temporada
	 * 				Numero da temporada a ser adicionado
	 * @param nome
	 * 				nome da série a ser adicionado
	 * @param nomeEp
	 * 				nome do episódio a ser adicionado
	 * @param genero
	 * 				genero da série
	 * @param duracao
	 * 				duração do episódio
	 * @param episodio
	 * 				numero do episódio		
	 * @param usrName
	 * 				usuario logado
	 * @return 
	 * 				retorna se foi possivel mover o arquivo, se não o programa terminara a copia dos arquivos
	 */
	public boolean AddSerie(String origem, String temporada, String nome, String nomeEp, String genero, String duracao, int episodio, String usrName) {
		nome = nome.toLowerCase();
		origem = origem.toLowerCase();
		String nomeEptoFile = episodio + " - "+ nomeEp;
		nomeEp = nomeEp.toLowerCase();
		genero = genero.toLowerCase();
		File destinoPasta = new File("c:\\TecaPlay\\" + usrName + "\\Videos\\serie\\" + genero+ "\\" + nome + "\\" + temporada);
		if (!(destinoPasta).exists()) {
			destinoPasta.mkdirs();
		}
		File arquivo = new File(origem);
		//pegando a extensao do arquivo a ser movido e renomeando o arquivo.
		String extensao = arquivo.getName().substring(arquivo.getName().lastIndexOf('.', arquivo.getName().length()));
		String newFileName = nomeEptoFile + extensao;
		
		boolean ok = arquivo.renameTo(new File(destinoPasta, newFileName));
		
		if (ok) {
			String pasta ="c:\\TecaPlay\\" + usrName + "\\Videos\\serie" ;
			String fileFinal = destinoPasta.getAbsolutePath()+"\\"+newFileName;//pega o caminho final do arquivo e acrescenta																//o nome final do arquivo a ser copiado 
			gravarTxt(pasta,nomeEptoFile,temporada,episodio,duracao,genero,fileFinal); // envia os dados para o gravartxt
			return true;
		} else {
			JOptionPane.showMessageDialog(null, "Nao foi possivel mover o arquivo", "Erro", 0);
			return false;
		}
	}
	

	/**
	 * 
	 * @param pasta	 pasta pasta onde sera criado o arquivo txt
	 * @param nomeEp	 nome que sera adicionado ao arquivo txt
	 * @param temporada 	temporada da serie	
	 * @param episodio 		numro do episodio da serie	
	 * @param duracao 	duração	
	 * @param genero	genero para a criacao do nome do txt
	 * @param file		file localização final do arquivo movido
	 */
	public void gravarTxt(String pasta, String nomeEp, String temporada, int episodio,String duracao,String genero,String file){
		//String do diretorio do TXT
		String criarTxt = pasta + "\\"+genero+".txt";

		try {
			FileWriter buffer = null;  
			buffer = new FileWriter(criarTxt, true); 
			String texto = temporada+"#"+episodio+"#"+nomeEp+"#"+duracao+"#"+file;
			buffer.write(texto+"\r\n");  
			buffer.close();
		} catch (IOException e) {
			System.out.println("não foi posssivel fazer a conexao ocm o txt)");
		}
		
	}
}
