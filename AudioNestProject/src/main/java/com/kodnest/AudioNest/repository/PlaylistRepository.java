package com.kodnest.AudioNest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kodnest.AudioNest.entity.PlayList;
@Repository
public interface PlaylistRepository extends JpaRepository<PlayList,Integer> {

	public PlayList findByName(String string);

}
