package com.kodnest.AudioNest.serviceimpl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodnest.AudioNest.entity.Song;
import com.kodnest.AudioNest.repository.SongRepository;
import com.kodnest.AudioNest.service.SongService;
@Service
public class SongServiceImpl implements SongService{
@Autowired
	SongRepository songRepository;

@Override
public void saveSong(Song song) {
	// TODO Auto-generated method stub
	songRepository.save(song);
}

@Override
public boolean songExists(String name) {
	// TODO Auto-generated method stub
	Song song = songRepository.findByName(name);
	if(song != null) {
		return true;
	}else {
	return false;
}
}

@Override
public List<Song> fetchAllSongs() {
	List<Song> songs=songRepository.findAll();
	return songs;
}

@Override
public void updateSong(Song song) {
	// TODO Auto-generated method stub
	songRepository.save(song);
	
}

}
