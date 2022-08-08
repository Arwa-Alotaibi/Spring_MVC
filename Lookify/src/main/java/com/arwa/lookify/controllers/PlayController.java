package com.arwa.lookify.controllers;

import java.util.List;


import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.arwa.lookify.models.LookifyModel;
import com.arwa.lookify.repositories.LookifyRepository;
import com.arwa.lookify.services.LookifyServices;


@Controller
public class PlayController {
	
	private  LookifyServices lookifyServices;
	
	public PlayController(LookifyServices lookifyServices) {
		this.lookifyServices = lookifyServices;
	}
	
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	@RequestMapping("/dashboard")
	public String dashboard(Model model) {
		List<LookifyModel> playlist  = lookifyServices.allPlaylist();
		model.addAttribute("playlist", playlist);

		return "dashboard.jsp";
		
	}
	
	
	@RequestMapping("/songs/new")
	public String CreateSong(@ModelAttribute("playlist")LookifyModel playlist) {
		return "add.jsp";
	}
	@PostMapping("/songs/new")
	public String Create(@Valid @ModelAttribute("playlist")LookifyModel playlist ,BindingResult result,Model model) {
		if(result.hasErrors()) {
			return "add.jsp";

		}
		else {
			lookifyServices.create(playlist);
			return "redirect:/dashboard";
		}
		
		
		
	}
	@GetMapping("/songs/{id}")
	public String ShowDetails(@PathVariable("id") Long id, @ModelAttribute("playlist")LookifyModel playlist, Model model) {
		
		model.addAttribute("playlist",lookifyServices.findPlayListById(id));
		

		return "details.jsp";
	}

	@RequestMapping("Search/TopTen")
	public String TopTen( Model model) {
		List<LookifyModel> playlist  = lookifyServices.top();
		model.addAttribute("playlist", playlist);

		return "top.jsp";
	}
	
	@GetMapping("/search")
	public String SearchArtist(@RequestParam("artist") @PathVariable("artist")String artist,Model model){
		List<LookifyModel> playlist  = lookifyServices.SearchByName(artist);
		model.addAttribute("playlist", playlist);
		model.addAttribute("artist", artist);

		return "search.jsp";
	}
	
	
	
	
	@DeleteMapping("/delete/{id}")
	public String Delete(@PathVariable("id") Long id) {
		lookifyServices.DeletePlayList(id);
		return "redirect:/dashboard";
	}



}
