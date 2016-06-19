package br.edu.pii.tecaplay.util.optimizationgui;

import java.io.File;
import java.util.ArrayList;
/**
 * Atualiza as Playlists ou os Favoritos.
 * 
 * @author Marcelo 
 *
 */
public class AtualizePlaylistsOrFavorites {
	private ArrayList<String> nomePlaylist = new ArrayList<>();
	private int size = 0;
	/**
	 * Inicia o processo de atualizar as playlist de Musica, ou os favoritos de Filmes.
	 * 
	 * @param userName Nome do usuário logado.
	 * @param favORplay Se favoritos ou playlist.
	 */
	public AtualizePlaylistsOrFavorites(String userName, String favORplay){
		String location;
		if(favORplay.equals("Playlist")){
			location = "C:\\TecaPlay\\"+ userName + "\\Musicas\\Playlist";
		}else{
			location = "C:\\TecaPlay\\"+ userName + "\\Videos\\Favoritos";
		}
		
		File test = new File(location);
		if(!test.exists()){
			test.mkdir();
		}
		
		File[] list = test.listFiles();
		for(int i = 0; i < list.length; i++){
			String name = list[i].getName();
			int num = name.indexOf(".");
			name = name.substring(0, num);
			nomePlaylist.add(name);
		}
		
		size = nomePlaylist.size();
	}
	
	/**
	 * @param i Posição na ArrayList que está o nome.
	 * @return O nome da playlist.
	 */
	public String PlaylistNames(int i){
		String playName = nomePlaylist.get(i);
		return playName;
	}
	
	/**
	 * 
	 * @return Total de linhas no Array.
	 */
	public int Size(){
		return size;
	}
}
