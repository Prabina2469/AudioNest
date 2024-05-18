package com.kodnest.AudioNest.service;

import com.kodnest.AudioNest.entity.User;
public interface UserService {

boolean emailExists(User user);

void saveUser(User user);

boolean validUser(String email, String password);

String getRole(String email);

User getUser(String mail);
void updateUser(User user);

}
