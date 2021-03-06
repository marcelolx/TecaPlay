package br.edu.pii.tecaplay.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import br.edu.pii.tecaplay.ui.FilmesAdd;

/**
 * @version 0.0.57
 * @author Jonas
 * @since 05/05/2016
 *
 */
public class MoveArquivosPasta {
	private String userName= null;
	/**
	 * Move o arquivo para um diret�rio especifico.
	 * 
	 * @param origem
	 * 				Diret�rio de onde a s�rie est� no sistema
	 * @param temporada
	 * 				Numero da temporada a ser adicionado
	 * @param nome
	 * 				nome da s�rie a ser adicionado
	 * @param nomeEp
	 * 				nome do epis�dio a ser adicionado
	 * @param genero
	 * 				genero da s�rie
	 * @param duracao
	 * 				dura��o do epis�dio
	 * @param episodio
	 * 				numero do epis�dio		
	 * @param usrName
	 * 				usuario logado
	 * 
	 */
	private String caminho = null;
	
	public boolean movePasta(String origem, String temporada, String nome, String nomeEp, String genero, String duracao, String episodio, String usrName){
		userName = usrName;
		File raiz = new File(origem);
		File[] files = raiz.listFiles();
		boolean contemPastas = false;
		// copia os sub-diret�rios para uma classe File de vetor
		for (int i = 0; i < files.length; i++) {
			contemPastas = files[i].isDirectory();
			if (contemPastas){
				return false;
			}	
		}
		//testa as exten��es dos arquivos se s�o compativeis com a categoria filmes
		boolean formatArquivo = false;
		for (int i = 0; i < files.length; i++) {
			caminho = files[i].getAbsolutePath();
			formatArquivo = validationFormat();
			if (!formatArquivo){
				return false;
			}	
		}

		boolean sucesso = serieExiste(nome, genero);
		if (sucesso) {
			new FilmesAdd(userName);
		}
		/**
		 * caso passe pelas valida��es anteriores, executar� as 
		 * a��es de mover os arquivos e gravar no txt
		 */
		int epis = Integer.parseInt(episodio);
		for (int i = 0; i < files.length; i++) {
			boolean retorno = addSerie(files[i].getAbsolutePath(), temporada, nome, nomeEp, genero, duracao, epis++, usrName);
			if (!retorno) {
				return false;
			}
		}
		return true;
	}
	/**
	 * Pega o arquivo e move ele para o diret�rio especifico.
	 * 
	 * @param origem
	 * 				Diret�rio de onde a s�rie est� no sistema
	 * @param temporada
	 * 				Numero da temporada a ser adicionado
	 * @param nome
	 * 				nome da s�rie a ser adicionado
	 * @param nomeEp
	 * 				nome do epis�dio a ser adicionado
	 * @param genero
	 * 				genero da s�rie
	 * @param duracao
	 * 				dura��o do epis�dio
	 * @param episodio
	 * 				numero do epis�dio		
	 * @param usrName
	 * 				usuario logado
	 * @return 
	 * 				retorna se foi possivel mover o arquivo, se n�o o programa terminara a copia dos arquivos
	 */
	public boolean addSerie(String origem, String temporada, String nomeSerie, String nomeEp, String genero, String duracao, int episodio, String usrName) {
		userName = usrName;
		origem = origem.toLowerCase();
	
		String nomeEptoFile = episodio + " - "+ nomeEp;
		nomeEp = nomeEp.toLowerCase();
		genero = genero.toLowerCase();
		File destinoPasta = new File("c:\\TecaPlay\\" + usrName + "\\Videos\\serie\\" + genero+ "\\" + nomeSerie.toLowerCase() + "\\" + temporada);
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
			gravarTxt(pasta,nomeEptoFile,temporada,episodio,duracao,genero,fileFinal,nomeSerie); // envia os dados para o gravartxt
			return true;
		} else {
			JOptionPane.showMessageDialog(null, "Nao foi possivel mover o arquivo", "Erro", 0);
			return false;
		}
	}
	

	/**
	 * Grava as informa��es da nova m�dia adicionada num .txt que ser� usado para depois listar
	 * as informa��es de cada arquivo num JTable.
	 * 
	 * @param pasta	 pasta pasta onde sera criado o arquivo txt
	 * @param nomeEp	 nome que sera adicionado ao arquivo txt
	 * @param temporada 	temporada da serie	
	 * @param episodio 		numro do episodio da serie	
	 * @param duracao 	dura��o	
	 * @param genero	genero para a criacao do nome do txt
	 * @param file		file localiza��o final do arquivo movido
	 */
	public void gravarTxt(String pasta, String nomeEp, String temporada, int episodio,String duracao,String genero,String file, String nomeSerie){
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
		
		String criarTemp = pasta + "\\" + genero + "\\nomeSerie\\" + nomeSerie.toLowerCase() + ".txt";
		File pastaCriar = new File(pasta + "\\" + genero + "\\nomeSerie");
		if (!pastaCriar.exists()) {
			pastaCriar.mkdirs();
		}
		try {
			FileWriter buffer = null;
			buffer = new FileWriter(criarTemp, true);
			String texto = temporada + "#" + episodio + "#" + nomeSerie.toLowerCase() + "#" + nomeEp.toLowerCase() + "#" + duracao + "#" + file;
			buffer.write(texto + "\r\n");
			buffer.close();
		} catch (IOException e) {

		}
	}
	
	/**
	 * Valida os tipos de arquivos que podem ser adicionados.
	 * 
	 * @return
	 * 		Se o tipo de arquivo for v�lido, retorna true, sen�o false. 
	 */
	public boolean validationFormat() {
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
	
	/**
	 * Verefica se s�rie X existe. 
	 * 
	 * @param nomeSerie - nome da S�rie.
	 * @param genero - genrero.
	 * @return true se existe, sen�o false.
	 */
	public boolean serieExiste(String nomeSerie, String genero) {
		String location = "C:\\TecaPlay\\" + userName + "\\Videos\\serie\\Todas as Series.txt";
		ArrayList<String> fileProvider = FileTextProvider.loadLines(location);
		boolean existe = false;
		for (int i = 0; i < fileProvider.size(); i++) {
			final String[] data = FileTextProvider.readData("#", fileProvider.get(i));
			if (data[0].equals(nomeSerie)) {
				existe = true;
				break;
			}

		}
		if (!existe) {
			System.out.println("Entrou");
			try {
				FileWriter buffer = null;
				buffer = new FileWriter(location, true);
				String texto = nomeSerie + "#" + genero;
				buffer.write(texto + "\r\n");
				buffer.close();
				return true;
			} catch (IOException e) {
				return false;
			}
			
		}
		return false;
	}

}
