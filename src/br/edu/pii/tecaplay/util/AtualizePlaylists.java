package br.edu.pii.tecaplay.util;

import java.io.File;
import java.util.ArrayList;

public class AtualizePlaylists {
	private ArrayList<String> nomePlaylist = new ArrayList<>();
	private int size = 0;
	
	public AtualizePlaylists(String userName){
		String location = "C:\\TecaPlay\\"+ userName + "\\Musicas\\Playlist";
		File test = new File(location);
		if(!test.exists()){
			test.mkdir();
		}
		
		File[] list = test.listFiles();
		for(int i = 0; i < list.length; i++){
			String name = list[i].getName();
			nomePlaylist.add(name);
		}
		size = nomePlaylist.size();
	}
	
	public String PlaylistNames(int i){
		String playName = nomePlaylist.get(i);
		return playName;
	}
	
	public int Size(){
		return size;
	}
}
