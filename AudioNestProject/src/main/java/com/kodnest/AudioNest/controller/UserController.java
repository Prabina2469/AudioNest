package com.kodnest.AudioNest.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.kodnest.AudioNest.entity.Song;
import com.kodnest.AudioNest.entity.User;
import com.kodnest.AudioNest.service.SongService;
import com.kodnest.AudioNest.service.UserService;

import jakarta.servlet.http.HttpSession;
@Controller
public class UserController {
 
	@Autowired
	 UserService userService;
	
	@Autowired
	SongService songService;
	
	@PostMapping("/register")
    public String addUser(@ModelAttribute User user) {
		
		//to check a user with a mail is present or not
		boolean userExists=userService.emailExists(user);   //email from user-form
		
		if(userExists==false) {
			userService.saveUser(user); //it save the user details
			System.out.println("user added ");
		}
		else {
			System.out.println("User already exists");
		}	
	
		return  "login"; 
	}
	
	@PostMapping("/validate")
	public String validate(@RequestParam("email") String email,
			@RequestParam("password") String password, HttpSession session, Model model) {

		if(userService.validUser(email, password) == true){

			String role = userService.getRole(email);

			session.setAttribute("email", email);

			if(role.equals("admin")) {
				return "adminhome";
			}
			else {

				User user = userService.getUser(email);
				boolean userstatus = user.isPremium();
				List<Song> fetchAllSongs = songService.fetchAllSongs();
				model.addAttribute("songs", fetchAllSongs);

				model.addAttribute("ispremium", userstatus);
				return "customerhome";
			}
		}	
		else {
			return "login";
		}	 
	    	
	}
	    
	    @GetMapping("/logout")
	    public String Logout(HttpSession session) {
		session.invalidate();			
			return "login";
}
//	    @GetMapping("/exploresongs")
//	    public String exploreSongs(String email);
//	    return email;
}
