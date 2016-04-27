package br.edu.pii.tecaplay.util;

import java.io.File;

import javax.swing.JOptionPane;

public class MoveFile {
	// Aqui jaz o codigo para mover os arquivos do adicionar.
	/**
	 * 
	 * @param origem 
	 * 		Diret�rio de onde o filme est�.
	 * @param ano 
	 * 		Ano do filme.
	 * @param nome 
	 * 		Nome do filme.
	 * @param genero
	 * 		G�nero do filme
	 * @param duracao
	 * 		Dura��o do filme.
	 * @param pais
	 * 		Pa�s onde o filme foi lan�ado.
	 * @param tipo
	 * 		v�riavel que vai armazenar se � filme, anime ou s�rie.
	 * @param usrName
	 * 		Armazena o nome do usu�rio atual logado no TecaPlay.
	 */
	public void AddFilme(String origem, String ano, String nome, String genero, String duracao, String pais, String tipo, String usrName) {
		nome = nome.toLowerCase();
		origem = origem.toLowerCase();
		genero = genero.toLowerCase();
		File criar = new File("c:\\TecaPlay\\" + usrName + "\\Videos\\" + tipo + "\\" + genero);
		if (!(criar).exists()) {
			criar.mkdirs();
		}
		File arquivo = new File(origem);
		//pegando a extensao do arquivo a ser movido e renomeando o arquivo.
		String extensao = arquivo.getName().substring(arquivo.getName().lastIndexOf('.', arquivo.getName().length()));
		String newFileName = nome + "_" + genero + "_" + ano + "_" + duracao+"_"+pais+"_"+extensao;
		
		boolean ok = arquivo.renameTo(new File(criar, newFileName));

		if (ok) {
			JOptionPane.showMessageDialog(null, "Arquivo foi movido com sucesso-"+arquivo.getName(), "Sucesso", 1);

		} else {
			JOptionPane.showMessageDialog(null, "Nao foi possivel mover o arquivo", "Erro", 0);
		}
	}

	public void retornoPasta() {
		File raiz = new File("c:\\TecaPlay");
		File[] files = raiz.listFiles();

		for (@SuppressWarnings("unused")
		File file : files) {
			// copia os arquivos / subdiret�rios
		}
		for (int i = 0; i < files.length; i++) {
			System.out.println(files[i]);
		}

	}
}
