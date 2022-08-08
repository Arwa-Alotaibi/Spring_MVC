package com.arwa.lookify.repositories;

import java.util.List;
import java.util.Optional;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.arwa.lookify.models.LookifyModel;

@Repository
public interface LookifyRepository extends CrudRepository <LookifyModel , Long>{
		//retrieves all 
		List<LookifyModel> findAll();
	
	
		// this method finds artist containing the artisit string
		List<LookifyModel> findByArtistContaining(String Searchartisit);

		//top 10
		List<LookifyModel>findTop10ByOrderByRatingDesc();

	
	
}
