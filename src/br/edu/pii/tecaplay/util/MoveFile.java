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
	private String usrName = "";

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
			String userName) {
		usrName = userName;
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
			gravarTxt(pasta, nomeSerie, temporada, episodio, duracao, genero, fileFinal,nomeEp); // envia
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
	 * Função realizada após adicionar nova série.
	 * ele irá acionar tambem a classe SerieExiste, para verificar se a série é nova ou não
	 * sendo nova, ele irá adicionar o nome da nova série no campo "Seriado" do JcomboBox
	 * 
	 * @param pasta
	 *            pasta do usuario na categoria séries
	 * @param nomeSerie
	 *            nome do seriado para servir de base de verificação de existencia de série 
	 *            e listagem das séries
	 * @param temporada
	 *            numero da temporada da serie
	 * @param episodio
	 *            numero do episodio da serie
	 * @param duracao
	 *            duração médio do episódio
	 * @param genero
	 *            genero para a criacao do nome do txt(Ex: Ação)
	 * @param file
	 *            file localização final da série do arquivo movido
	 */
	public void gravarTxt(String pasta, String nomeSerie, String temporada, String episodio, String duracao,
			String genero, String file,String nomeEp) {
		// String do diretorio do TXT
		String criarTemp = pasta + "\\" + genero + "\\nomeSerie\\" + nomeSerie.toLowerCase() + ".txt";
		File pastaCriar = new File(pasta + "\\" + genero + "\\nomeSerie");
		if (!pastaCriar.exists()) {
			pastaCriar.mkdirs();
		}
		try {
			FileWriter buffer = null;
			buffer = new FileWriter(criarTemp, true);
			String texto = temporada + "#" + episodio + "#" + nomeSerie.toLowerCase() + "#"  + nomeEp.toLowerCase() + "#" + duracao + "#" + file;
			buffer.write(texto + "\r\n");
			buffer.close();
		} catch (IOException e) {

		}
		boolean sucesso = SerieExiste(nomeSerie, genero);
		if (sucesso) {
			new FilmesAdd(usrName);
		}

	}

	/**
	 * Verifica se a série existe. caso o teste resulta que nao existe tal série,
	 * será adicionada no arquivo txt.
	 * @param nomeSerie Nome da série adicionado
	 * @param genero seu respectivo genero
	 * @return se a série for nova, retorna verdadeiro e recarrega a pagina para a nova listagem
	 * das séries existentes
	 */
	public boolean SerieExiste(String nomeSerie, String genero) {
		String location = "C:\\TecaPlay\\" + usrName + "\\Videos\\serie\\Todas as Series.txt";
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
