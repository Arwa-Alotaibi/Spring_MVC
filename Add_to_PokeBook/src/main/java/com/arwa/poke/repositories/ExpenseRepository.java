package com.arwa.poke.repositories;

import java.util.List;



import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.arwa.poke.models.Expense;

@Repository
public interface ExpenseRepository extends CrudRepository<Expense, Long>{
	
//Set up your ExpenseRepository (findAll is the only necessary query method to add at this time)

	List<Expense> findAll();
}
