package com.arwa.pokee.controllers;

import java.util.List;
import javax.validation.Valid;
import org.springframework.http.StreamingHttpOutputMessage.Body;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import javax.validation.Valid;
import com.arwa.pokee.models.Expense;
import com.arwa.pokee.services.ExpenseService;

@Controller
public class ExpenseControllers {
	//inject  ExpenseService .
	private ExpenseService expenseService;
	
	public ExpenseControllers (ExpenseService expenseService) {
		this.expenseService=expenseService;
	}
	@RequestMapping("/expenses")
	public String Retrive(Model model ,@ModelAttribute("pokebook") Expense pokebook ) {
		List<Expense> poke = expenseService.allExpense();
		model.addAttribute("poke", poke);
		return "index.jsp";
	}
	
	
	@RequestMapping("/form")
	public String form(@ModelAttribute("pokebook") Expense pokebook) {
		return "index.jsp";
	}


	@RequestMapping(value="/expenses", method=RequestMethod.POST)
	public String addPokeBook(@Valid @ModelAttribute("pokebook")Expense pokebook ,BindingResult result,Model model) {
		
		if(result.hasErrors()) {
			List<Expense> Poke = expenseService.allExpense();
			model.addAttribute("Poke",Poke);
			return "index.jsp";
		}
		else {
			expenseService.create(pokebook);
			return "redirect:/expenses";
		}}
	
	@GetMapping("/expenses/edit/{id}")
	public String edit(@PathVariable("id") Long id,Model model,@ModelAttribute("pokebook")Expense pokebook   ) {
		Expense editpokebook = expenseService.findPokebok(id);
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
	
	@RequestMapping(value="expenses/delete/{id}", method = RequestMethod.DELETE)
	public String remove (@PathVariable("id") Long id ) {
		expenseService.delete(id);
		return "redirect:/expenses";
		
	}
	
	@RequestMapping("/expenses/{id}")
	public String show(@PathVariable("id") Long id,Model model ) {
		Expense pokebook = expenseService.findPokebok(id);
		model.addAttribute("pokebook",pokebook);
				return "show.jsp";
		
	}
	

}
 