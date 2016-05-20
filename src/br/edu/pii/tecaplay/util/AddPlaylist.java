package br.edu.pii.tecaplay.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import br.edu.pii.tecaplay.ui.ListPlaylists;

public class AddPlaylist {
	public AddPlaylist(String usrName, String nomePlaylist, String caminho){
		String criarTxt = "c:\\TecaPlay\\" + usrName + "\\Musicas\\Playlist\\"+nomePlaylist+".txt";
		
		//grava as informaões no txt
		
		try{
			FileWriter buffer = null;
			buffer = new FileWriter(criarTxt, true);
			buffer.close();
		}catch(IOException e21){
		}
		ListPlaylists  teste= new ListPlaylists(usrName, caminho);
	}
}
