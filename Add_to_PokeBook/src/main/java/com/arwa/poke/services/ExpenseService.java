package com.arwa.poke.services;

import java.util.List;


import java.util.Optional;

import org.springframework.stereotype.Service;
import com.arwa.poke.models.Expense;
import com.arwa.poke.repositories.ExpenseRepository;

@Service
public class ExpenseService {

	private final ExpenseRepository expenseRepository;
	
	public ExpenseService(ExpenseRepository expenseRepository) {
		this.expenseRepository= expenseRepository;
	}
	
	public List<Expense> allpokebook(){
		return expenseRepository.findAll();
		
	}
	
	public Expense createpokebook(Expense pokebook) {
		return expenseRepository.save(pokebook);
	}
	
	
	public Expense FindExpense(Long id) {
		Optional<Expense>  OptionalExpense = expenseRepository.findById(id);
		if(OptionalExpense.isPresent()) {
			return OptionalExpense.get();
		}
		else {
			return null;
		}
		
	}
	public Expense updateExpense(Expense pokebook , Long id) {
		Expense edit = expenseRepository.findById(id).get();
		edit.setName(pokebook.getName());
		edit.setVender(pokebook.getVender());
		edit.setDescription(pokebook.getDescription());
		edit.setAmount(pokebook.getAmount());
		
		return expenseRepository.save(edit);
		
	}
	

}
