package com.kodnest.AudioNest.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kodnest.AudioNest.entity.User;
import com.kodnest.AudioNest.repository.UserRepository;
import com.kodnest.AudioNest.service.UserService;

@Service
public class UserServiceImpl implements  UserService {
	@Autowired
	UserRepository userRepository;

	@Override
	public void saveUser(User user) {
		// TODO Auto-generated method stub
		userRepository.save(user);
		
	}
	@Override
	public boolean emailExists(User user) {
		
		User existinuser = userRepository.findByEmail(user.getEmail());
		
		if(existinuser!=null) {
			System.out.println("present");
			return true;
		}
		else {
			System.out.println("Absent");	
		return false;
	}
	}

	@Override
	public boolean validUser(String email, String password) {
		System.out.println(email+"______"+password);
		// TODO Auto-generated method stub	
		
		User user=userRepository.findByEmail(email);	
		
		System.out.println(user);
		
		String dbpwd = user.getPassword();
		if(password.equals(dbpwd)) {
			return true;			
		}else {
			return false;
		}
	}

	@Override
	public String getRole(String email) {
		// TODO Auto-generated method stub
		User user=userRepository.findByEmail(email);
		
		return user.getRole();
	
	}

	@Override
	public User getUser(String mail) {
      
		return userRepository.findByEmail(mail);
	}

	@Override
	public void updateUser(User user) {
		userRepository.save(user);
		
	}
}




	


