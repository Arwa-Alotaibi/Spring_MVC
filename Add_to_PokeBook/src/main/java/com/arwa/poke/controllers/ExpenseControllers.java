package com.arwa.poke.controllers;

import org.springframework.stereotype.Controller;



import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.List;
import javax.validation.Valid;
import com.arwa.poke.models.Expense;
import com.arwa.poke.services.ExpenseService;
@Controller
public class ExpenseControllers {
	private final ExpenseService expenseService;
	
	public ExpenseControllers (ExpenseService expenseService) {
		this.expenseService = expenseService;
	}
		// retrieve all the records from the database and render them on the page 
		@RequestMapping("/expenses")
		public String Display(Model model,@ModelAttribute("pokebook") Expense pokebook) {
			List<Expense> Poke = expenseService.allpokebook();
			model.addAttribute("Poke",Poke);
			return "index.jsp";
		
		}

		//create pokebook 
		@RequestMapping(value="/expenses" ,method=RequestMethod.POST)
			public String CreatePokeBook(Model model,@Valid  @ModelAttribute("pokebook") Expense pokebook , BindingResult result) {
				if(result.hasErrors()) {
					List<Expense> Poke = expenseService.allpokebook();
					model.addAttribute("Poke",Poke);
	
					return "index.jsp";
				}
				else {
					expenseService.createpokebook(pokebook);
					return "redirect:/expenses";
					}
				
				
				
				
}
		@GetMapping("/expenses/edit/{id}")
		public String edit(@PathVariable("id") Long id,Model model,@ModelAttribute("pokebook")Expense pokebook   ) {
			Expense editpokebook = expenseService.FindExpense(id);
			model.addAttribute("editpokebook", editpokebook);
			return "edit.jsp";
		}

		
		
		@PutMapping("/expenses/edit/{id}")
		public String update(@Valid @ModelAttribute("pokebook")Expense pokebook , @PathVariable("id") Long id ,BindingResult result) {
			if(result.hasErrors()) {
				
				return "edit.jsp";
			}
			else {
				expenseService.updateExpense(pokebook,id);
				return "redirect:/expenses";
			}	
			
		}
}

	
		


