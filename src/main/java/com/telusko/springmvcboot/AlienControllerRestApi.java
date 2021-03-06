package com.telusko.springmvcboot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.telusko.springmvcboot.model.Alien;

/* 

@RestController == 

@Controller
@ResponseBody

*/

@RestController
public class AlienControllerRestApi {
	
	@Autowired
	AlienRepo repo; 
	
	@GetMapping(path ="aliens", produces = {"application/xml"})
//	@GetMapping(path ="aliens", produces = {"application/json"})
//	@ResponseBody
	public List<Alien> getAliens() {
		
		List<Alien> aliens = repo.findAll();
		int i = 9 / 0;
		System.out.println("Fetching Aliens");
		
		return aliens;
	}

	@GetMapping("alien/{aid}")
//	@ResponseBody
	public Alien getAlien(@PathVariable("aid") int aid) {
		
		Alien alien = repo.findById(aid).orElse(new Alien(0, ""));
		
		return alien;
	}
	
	@PostMapping(path = "alien", consumes = {"application/json"})
	public Alien addAlien(Alien alien) {
		
		repo.save(alien);
		
		return alien;
	}
	

}
