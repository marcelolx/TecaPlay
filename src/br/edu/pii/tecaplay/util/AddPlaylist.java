package br.edu.pii.tecaplay.util;

import java.io.FileWriter;
import java.io.IOException;

import br.edu.pii.tecaplay.ui.ListPlaylists;
/**
 * Cria o arquivo das Playlist ou favoritos
 * @author Marcelo
 *
 */
public class AddPlaylist {
	/**
	 * ADD nova playlist
	 * @param usrName Nome do Usuário Logado
	 * @param nomePlaylist Nome da playlist
	 * @param caminho src da pasta
	 * @param catType Verefica se é Musicas ou Videos
	 */
	public static void addPlaylist(String usrName, String nomePlaylist, String caminho, String catType){
		String criarTxt;
		if(catType.equals("Videos")){
			criarTxt = "c:\\TecaPlay\\" + usrName + "\\"+catType+"\\Favoritos\\"+nomePlaylist+".txt";
		}else{
			criarTxt = "c:\\TecaPlay\\" + usrName + "\\"+catType+"\\Playlist\\"+nomePlaylist+".txt";
		}
		
		
		//cria o arquivo das informaões no txt
		
		try{
			FileWriter buffer = null;
			buffer = new FileWriter(criarTxt, true);
			buffer.close();
		}catch(IOException e21){
		}
		new ListPlaylists(usrName, caminho, catType);
	}
}
