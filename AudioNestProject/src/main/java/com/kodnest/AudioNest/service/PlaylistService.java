package com.kodnest.AudioNest.service;

import java.util.List;

import com.kodnest.AudioNest.entity.PlayList;

public interface PlaylistService {

public void addPlayList(PlayList playlist);

public List<PlayList> fetchAllPlaylists();

}
