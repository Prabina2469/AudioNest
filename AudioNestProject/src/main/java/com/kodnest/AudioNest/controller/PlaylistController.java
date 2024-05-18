package com.kodnest.AudioNest.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.kodnest.AudioNest.entity.PlayList;
import com.kodnest.AudioNest.entity.Song;
import com.kodnest.AudioNest.service.PlaylistService;
import com.kodnest.AudioNest.service.SongService;

@Controller
public class PlaylistController {
	
	@Autowired
	PlaylistService playlistService;
	
	@Autowired
	SongService songService;
	
	@GetMapping("/createplaylists")
	public String createPlayList(Model model) {
		List<Song> songList = songService.fetchAllSongs();		
		model.addAttribute("songs",songList);
		return "createplaylist";
		
	}
	@PostMapping("/addplaylist")
	public String addplaylist(@ModelAttribute PlayList playlist) {
		System.out.println(playlist);
	playlistService.addPlayList	(playlist);
		return "adminhome";
	}
	@GetMapping("/viewplaylists")
	public String viewPlaylists(Model model ) {
		List<PlayList>allplaylist =playlistService.fetchAllPlaylists();
		model.addAttribute("playlists", allplaylist);
		return "viewplaylists";
		
	}
}

