package br.edu.pii.tecaplay.util;

import java.io.FileWriter;
import java.io.IOException;

import br.edu.pii.tecaplay.ui.ListPlaylists;
/**
 * Create file of Playlist and Favorites
 * @author Marcelo
 *
 */
public class AddPlaylist {
	/**
	 * Add new playlist or favorite
	 * @param usrName User logged
	 * @param nomePlaylist 
	 * @param src of folder
	 * @param catType Verify if is music or video
	 */
	public static void addPlaylist(String usrName, String nomePlaylist, String src, String catType){
		String criarTxt;
		if(catType.equals("Videos")){
			criarTxt = "c:\\TecaPlay\\" + usrName + "\\"+catType+"\\Favoritos\\"+nomePlaylist+".txt";
		}else{
			criarTxt = "c:\\TecaPlay\\" + usrName + "\\"+catType+"\\Playlist\\"+nomePlaylist+".txt";
		}
		
		//create txt file with informations of playlist or favorite
		try{
			FileWriter buffer = null;
			buffer = new FileWriter(criarTxt, true);
			buffer.close();
		}catch(IOException e21){
		}
		new ListPlaylists(usrName, src, catType);
	}
}
