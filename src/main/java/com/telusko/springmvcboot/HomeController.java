package com.telusko.springmvcboot;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.telusko.springmvcboot.model.Alien;

@Controller
public class HomeController
{
	@Autowired
	AlienRepo repo;
	
	@ModelAttribute
	public void modelData(Model m) 
	{
	m.addAttribute("name","Aliens");
	}
	
	@RequestMapping("/")
	public String home()
	{
		return "index";
	}
	
	@GetMapping("getAliens")
	public String getAliens(Model m)
	{
		
		m.addAttribute("result", repo.findAll());
		
		return "showAliens";
		
	}
	
	@GetMapping("getAlien")
	public String getAlien(@RequestParam int aid, Model m)
	{
		//	List<Alien> alien= Arrays.asList(repo.getOne(aid));
		
	//	List<Alien> alien = repo.getByAid(aid);
		
		List<Alien> alien = repo.getByAid(aid);
		
		m.addAttribute("result", alien);
		
		return "showAliens";
		
	}
	
	@PostMapping("getAliensByName")
	public String getAliensByName(@RequestParam String aname, Model m) {
		
		m.addAttribute("result", repo.find(aname));
		
		return "showAliens";
	}
	
	@PostMapping(value="addAlien")
	public String addAlien(@ModelAttribute Alien a, Model m)
	{
		
		m.addAttribute("alien", repo.save(a));
	
		return "result";
		
	}
}


