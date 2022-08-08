package com.arwa.lookify.services;

import java.util.List;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.arwa.lookify.models.LookifyModel;
import com.arwa.lookify.repositories.LookifyRepository;

@Service
public class LookifyServices {
	private final LookifyRepository lookifyRepository;
	
	public LookifyServices(LookifyRepository lookifyRepository) {
		this.lookifyRepository =lookifyRepository ;
	}
	
    // returns all the playlist
	public List <LookifyModel> allPlaylist() {
		return lookifyRepository.findAll();
	}
	
	// create playlist
	public LookifyModel create(LookifyModel playlist) {
		return lookifyRepository.save(playlist);
	}
	
	 // retrieves a playlist
	public LookifyModel findPlayListById(Long id) {
		Optional <LookifyModel> OptionalPlayList = lookifyRepository.findById(id);
		if (OptionalPlayList.isPresent()) {
			return OptionalPlayList.get();
		}
		else {
			return null ; 
		}
		
	}
	
	
	public void DeletePlayList(Long id) {
		lookifyRepository.deleteById(id);
	}

	public List <LookifyModel> top(){
		return lookifyRepository.findTop10ByOrderByRatingDesc();
	}
	
	public List <LookifyModel> SearchByName(String artisit){
		return lookifyRepository.findByArtistContaining(artisit);
	}

}
