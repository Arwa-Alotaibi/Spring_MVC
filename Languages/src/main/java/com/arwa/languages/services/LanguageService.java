package com.arwa.languages.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.arwa.languages.models.Language;
import com.arwa.languages.repositories.LanguageRepositories;

@Service
public class LanguageService {
	private LanguageRepositories languageRepositories;
	
	public LanguageService(LanguageRepositories languageRepositories) {
		this.languageRepositories = languageRepositories;
		
	}
	
	// return all language
	
	public List <Language>FindAllLanguage(){
		return languageRepositories.findAll();
		
	}
	
	// create a language 
	public Language CreateLanguage(Language language) {
		return languageRepositories.save(language);
	}
	
	// retrives a language 
	
	public Language findLanguage(long id ) {
        Optional<Language> optionalLanguage= languageRepositories.findById(id);
        
        if(optionalLanguage.isPresent()) {
        	return optionalLanguage.get();
        }
        else {
        	return null ;
        }
        

	}
	
	// edit 
	
	public Language updatelanguage(Language language ,long id) {
		Language editlanguage= languageRepositories.findById(id).get();
		
		editlanguage.setName(language.getName());
		editlanguage.setCreator(language.getCreator());
		
		editlanguage.setVersion(language.getVersion());
		
		return languageRepositories.save(editlanguage);
	}
	
	// delete
	
	public void  deltelanguage(Long id ) {
		languageRepositories.deleteById(id);
	}
	
	

}
