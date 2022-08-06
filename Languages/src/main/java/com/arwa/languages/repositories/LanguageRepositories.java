package com.arwa.languages.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.arwa.languages.models.Language;



@Repository
public interface LanguageRepositories  extends CrudRepository<Language,Long> {
    // this method retrieves all the Language from the database
	List<Language> findAll();
	
    Optional<Language> findById(Long id);


}
