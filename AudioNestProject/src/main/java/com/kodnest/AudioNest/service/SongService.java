package com.kodnest.AudioNest.service;

import java.util.List;

import com.kodnest.AudioNest.entity.Song;

public interface SongService {

	void saveSong(Song song);

	boolean songExists(String name);

	public List<Song> fetchAllSongs();

	void updateSong(Song song);

}
