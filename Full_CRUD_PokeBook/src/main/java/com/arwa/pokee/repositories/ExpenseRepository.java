package com.arwa.pokee.repositories;

import org.springframework.stereotype.Repository;



import com.arwa.pokee.models.Expense;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


@Repository
public interface ExpenseRepository  extends CrudRepository<Expense,Long>{
List<Expense> findAll();

}
