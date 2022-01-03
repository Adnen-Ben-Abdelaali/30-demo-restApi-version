package com.telusko.springmvcboot;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.telusko.springmvcboot.model.Alien;

public interface AlienRepo extends JpaRepository<Alien, Integer>{
	
	/*
	
	default String getAliensByName(String aname) {
		
		return "LOOOOOOOoooolll";
	}
	
	*/
	
	List<Alien> findByAname(String aname);
	List<Alien> findByAnameOrderByAnameDesc(String aname);
	List<Alien> findByAnameOrderByAidDesc(String aname);
	List<Alien> findByAid(int aid);
	List<Alien> getByAid(int aid);
	List<Alien> getByAname(String aname);
	

}
