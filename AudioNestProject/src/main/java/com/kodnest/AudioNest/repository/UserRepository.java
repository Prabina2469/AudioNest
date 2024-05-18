package com.kodnest.AudioNest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kodnest.AudioNest.entity.User;
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	 User findByEmail(String email);

	




}
