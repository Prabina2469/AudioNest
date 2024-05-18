package com.kodnest.AudioNest.serviceimpl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodnest.AudioNest.entity.PlayList;
import com.kodnest.AudioNest.repository.PlaylistRepository;
import com.kodnest.AudioNest.service.PlaylistService;
@Service
public class PlaylistServiceImpl implements PlaylistService {
     
	@Autowired
	PlaylistRepository playlistRepository;

	@Override
	public void addPlayList(PlayList playlist) {
		PlayList explaylist =playlistRepository.findByName(playlist.getName());
		if(explaylist==null) {
				playlistRepository.save(playlist);
	}
		else {
			System.out.println("playlist already exists");
		}
}

	@Override
	public List<PlayList> fetchAllPlaylists() {
		List<PlayList> playlists=playlistRepository.findAll();		
		return playlists;
	}
}