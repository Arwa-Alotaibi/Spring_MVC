package com.arwa.languages.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.validation.BindingResult;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.arwa.languages.models.Language;
import com.arwa.languages.services.LanguageService;

import java.util.List;

@Controller
public class LanguageControoler {
	private LanguageService languageService;
	
	public LanguageControoler(LanguageService languageService) {
		this.languageService =languageService;
	}
	
	//The GET/languages route should show a table of all the languages with links to edit and delete the languages;
	//also include a form for creating new languages.
	
	@GetMapping("/languages")
	public String Show(Model model,@ModelAttribute("programming") Language programming) {
		List<Language> languages = languageService.FindAllLanguage();

		model.addAttribute("languages",languages);
		
		return "index.jsp";
		
	}
	//The POST /languages routes should create a language.
	
	@PostMapping("/languages")
	public String create(@Valid @ModelAttribute("programming") Language programming,BindingResult result, Model model) {
		if(result.hasErrors()) {
			List<Language> languages = languageService.FindAllLanguage();
			model.addAttribute("languages",languages);


			return "index.jsp";
		}
		else {
			languageService.CreateLanguage(programming);
			return "redirect:/languages";

		}
		
		
	}
	//The GET /languages/{id} route should return the specific language and details.
	@GetMapping("/languages/{id}")
	public String DisplayLanguage(@PathVariable("id") Long id , Model model ) {
		model.addAttribute("languages", languageService.findLanguage(id));
		
		return "show.jsp";
		

	}
	// The GET /languages/{id}/edit route should show the edit page to of a specific language
	@GetMapping("/languages/{id}/edit")
	public String edit(@PathVariable("id") Long id , Model model,@ModelAttribute("programming") Language programming ) {
		model.addAttribute("programming", languageService.findLanguage(id));
		return "edit.jsp";

	}
	
	// PUT /languages/{id} route should should update a language
	@PutMapping("/languages/{id}/edit")
	public String update(@Valid @ModelAttribute("programming") Language programming ,@PathVariable("id") Long id , Model model,BindingResult result) {
		if(result.hasErrors()) {
			return "edit.jsp";
		}
		else {
			languageService.updatelanguage(programming, id);
			return "redirect:/languages";
		}
		
		
	}
	
	//The DELETE /languages/{id} route should delete the specific language at that id.
	@DeleteMapping("/delete/languages/{id}")
	public String Delete(@PathVariable("id") Long id ) {
		languageService.deltelanguage(id);
		return "redirect:/languages";
	}




	
	







	
}
