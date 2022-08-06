package com.arwa.pokee.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.arwa.pokee.models.Expense;
import com.arwa.pokee.repositories.ExpenseRepository;


@Service
public class ExpenseService {
//inject  repository interface as a dependency.
	private ExpenseRepository expenseRepository;
	
	public ExpenseService(ExpenseRepository expenseRepository) {
		this.expenseRepository=expenseRepository;
		
	}
	
	// retrieve all the records from the database
	public List <Expense> allExpense(){
		return expenseRepository.findAll();
		
	}
	
	// creates a expense
	public Expense create(Expense pokebook) {
		return expenseRepository.save(pokebook);
	}
	
	//delete 
	public void delete(Long id) {
		expenseRepository.deleteById(id);
	}
	
	// find 
	
	public Expense findPokebok(Long id) {
		Optional<Expense> OptionalItem = expenseRepository.findById(id);
		if(OptionalItem.isPresent()) {
			return OptionalItem.get();
		}
		else {
			return null ;
		}
	}
		
		// update 
		public Expense updateExpense(Expense pokebook ,Long id) {
			Expense edit = expenseRepository.findById(id).get();
			edit.setName(pokebook.getName());
			edit.setVender(pokebook.getVender());
			edit.setAmount(pokebook.getAmount());
			edit.setDescription(pokebook.getDescription());
			
			return expenseRepository.save(edit);
			
		}
	
}

