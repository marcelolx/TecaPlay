package br.edu.pii.tecaplay.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

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
	private String caminho = null;
	
	public boolean MovePasta(String origem, String temporada, String nome, String nomeEp, String genero, String duracao, String episodio, String usrName){
		File raiz = new File(origem);
		File[] files = raiz.listFiles();
		boolean contemPastas = false;
		// copia os sub-diretórios para uma classe File de vetor
		for (int i = 0; i < files.length; i++) {
			contemPastas = files[i].isDirectory();
			if (contemPastas){
				return false;
			}	
		}
		//testa as extenções dos arquivos se são compativeis com a categoria filmes
		boolean formatArquivo = false;
		for (int i = 0; i < files.length; i++) {
			caminho = files[i].getAbsolutePath();
			formatArquivo = ValidationFormat();
			if (!formatArquivo){
				return false;
			}	
		}
		/**
		 * caso passe pelas validações anteriores, executará as 
		 * ações de mover os arquivos e gravar no txt
		 */
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
		}
		
	}
	public boolean ValidationFormat() {
		File destino = new File(caminho);
		ArrayList<String> array = new ArrayList<String>();
		array.add(".MKV");
		array.add(".flv");
		array.add(".avi");
		array.add(".mov");
		array.add(".wmv");
		array.add(".rmvb");
		array.add(".vob");
		array.add(".cam");
		array.add(".mp4");
		array.add(".mp3");
		String extensao = destino.getName().substring(destino.getName().lastIndexOf('.', destino.getName().length()));
		for (int i = 0; i < array.size(); i++) {
			if (extensao.equals(array.get(i))) {
				return true;
			}	
		}
	
		return false;
	}
}
