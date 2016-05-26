package br.edu.pii.tecaplay.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import br.edu.pii.tecaplay.ui.FilmesAdd;

/**
 * 
 * @author jonas, Marcelo
 *
 */
public class MoveFile {
	@SuppressWarnings("unused")
	private FileWriter escrita;

	// Aqui jaz o codigo para mover os arquivos do adicionar.
	/**
	 * @param origem
	 *            Diretório de onde o filme está.
	 * @param ano
	 *            Ano do filme.
	 * @param nome
	 *            Nome do filme.
	 * @param genero
	 *            Gênero do filme
	 * @param duracao
	 *            Duração do filme.
	 * @param pais
	 *            País onde o filme foi lançado.
	 * @param tipo
	 *            váriavel que vai armazenar se é filme, anime ou série.
	 * @param usrName
	 *            Armazena o nome do usuário atual logado no TecaPlay.
	 */
	public boolean AddFilme(String origem, String ano, String nome, String genero, String duracao, String pais,
			String usrName) {
		origem = origem.toLowerCase();
		genero = genero.toLowerCase();
		File destinoPasta = new File("c:\\TecaPlay\\" + usrName + "\\Videos\\filme\\" + genero);
		if (!(destinoPasta).exists()) {
			destinoPasta.mkdirs();
		}
		File arquivo = new File(origem);
		// pegando a extensao do arquivo a ser movido e renomeando o arquivo.
		String extensao = arquivo.getName().substring(arquivo.getName().lastIndexOf('.', arquivo.getName().length()));
		String newFileName = nome + extensao;
		boolean ok = arquivo.renameTo(new File(destinoPasta, newFileName));

		if (ok) {
			String pasta = "c:\\TecaPlay\\" + usrName + "\\Videos\\filme";
			String fileFinal = destinoPasta.getAbsolutePath() + "\\" + newFileName;
			gravarTxtFilmes(pasta, nome, ano, genero, pais, fileFinal);
			return true;
		} else {
			return false;
		}

	}

	/**
	 * 
	 * @param origem
	 *            Diretório de onde a série está no sistema
	 * @param temporada
	 *            Numero da temporada a ser adicionado
	 * @param nomeSerie
	 *            nome da série a ser adicionado
	 * @param nomeEp
	 *            nome do episódio a ser adicionado
	 * @param genero
	 *            genero da série
	 * @param duracao
	 *            duração do episódio
	 * @param episodio
	 *            numero do episódio
	 * @param usrName
	 *            usuario logado
	 * 
	 */
	private String usrName = "";

	public boolean AddSerie(String origem, String temporada, String nomeSerie, String nomeEp, String genero,
			String duracao, String episodio, String userName) {
		
		origem = origem.toLowerCase();
		usrName = userName;
		String nomeEptoFile = episodio + " - " + nomeEp;
		nomeEp = nomeEp.toLowerCase();
		genero = genero.toLowerCase();
		File destinoPasta = new File(
				"c:\\TecaPlay\\" + usrName + "\\Videos\\serie\\" + genero + "\\" + nomeSerie.toLowerCase() + "\\" + temporada);
		if (!(destinoPasta).exists()) {
			destinoPasta.mkdirs();
		}
		File arquivo = new File(origem);
		// pegando a extensao do arquivo a ser movido e renomeando o arquivo.
		String extensao = arquivo.getName().substring(arquivo.getName().lastIndexOf('.', arquivo.getName().length()));
		String newFileName = nomeEptoFile + extensao;

		boolean ok = arquivo.renameTo(new File(destinoPasta, newFileName));

		if (ok) {
			String pasta = "c:\\TecaPlay\\" + usrName + "\\Videos\\serie";
			String fileFinal = destinoPasta.getAbsolutePath() + "\\" + newFileName;// pega
																					// o
																					// caminho
																					// final
																					// do
																					// arquivo
																					// e
																					// acrescenta
																					// //o
																					// nome
																					// final
																					// do
																					// arquivo
																					// a
																					// ser
																					// copiado
			gravarTxt(pasta, nomeSerie, temporada, episodio, duracao, genero, fileFinal); // envia
																							// os
																							// dados
																							// para
																							// o
																							// gravartxt
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 
	 * @param pasta
	 *            pasta onde sera criado o arquivo txt
	 * @param nomeEp
	 *            nome que sera adicionado ao arquivo txt
	 * @param ano
	 *            ano do filme
	 * @param genero
	 *            genero para a criacao do nome do txt
	 * @param pais
	 *            pais
	 * @param file
	 *            localização final do arquivo movido
	 */
	public void gravarTxtFilmes(String pasta, String nome, String ano, String genero, String pais, String file) {
		// string que serve para fazer a criacao do txt
		String criarTxt = pasta + "\\" + genero + ".txt";

		// grava as informaões no txt
		try {
			FileWriter buffer = null;
			buffer = new FileWriter(criarTxt, true);
			String text = nome + "#" + genero + "#" + pais + "#" + ano + "#" + file;
			buffer.write(text + "\r\n");
			buffer.close();
		} catch (IOException e21) {
		}
	}
	// gravarTxt só está apto para séries, necessário criar outro para filmes,
	// o mesmo pode ser utilizado para animes também.

	/**
	 * 
	 * @param pasta
	 *            pasta pasta onde sera criado o arquivo txt
	 * @param nomeSerie
	 *            nome que sera adicionado ao arquivo txt
	 * @param temporada
	 *            temporada da serie
	 * @param episodio
	 *            numro do episodio da serie
	 * @param duracao
	 *            duração
	 * @param genero
	 *            genero para a criacao do nome do txt
	 * @param file
	 *            file localização final do arquivo movido
	 */
	public void gravarTxt(String pasta, String nomeSerie, String temporada, String episodio, String duracao,
			String genero, String file) {
		// String do diretorio do TXT
		String criarTemp = pasta + "\\" + genero + "\\nomeSerie\\" + nomeSerie.toLowerCase() + ".txt";
		File pastaCriar = new File(pasta + "\\" + genero + "\\nomeSerie");
		if (!pastaCriar.exists()) {
			pastaCriar.mkdirs();
		}
		try {
			FileWriter buffer = null;
			buffer = new FileWriter(criarTemp, true);
			String texto = temporada + "#" + episodio + "#" + nomeSerie.toLowerCase() + "#" + duracao + "#" + file;
			buffer.write(texto + "\r\n");
			buffer.close();
		} catch (IOException e) {

		}
		boolean sucesso = SerieExiste(nomeSerie, nomeSerie, genero);
		if (sucesso) {
			FilmesAdd newAdd = new FilmesAdd(usrName);
		}else{
			System.err.println("Errou");
		}
		// Gravar os dados de uma nova série

	}

	/**
	 * 
	 * @return
	 */
	public boolean SerieExiste(String serie, String nomeSerie, String genero) {
		String location = "C:\\TecaPlay\\" + usrName + "\\Videos\\serie\\Todas as Series.txt";

		FileTextProvider file = new FileTextProvider();
		ArrayList<String> fileProvider = FileTextProvider.loadLines(location);
		boolean existe = false;
		for (int i = 0; i < fileProvider.size(); i++) {
			final String[] data = FileTextProvider.readData("#", fileProvider.get(i));
			if (data[0].equals(serie)) {
				existe = true;
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
				System.out.println("eRROU");
				return false;
			}
			
		}
		return false;
	}

}
