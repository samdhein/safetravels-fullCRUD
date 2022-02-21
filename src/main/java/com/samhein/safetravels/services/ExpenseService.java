package com.samhein.safetravels.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.samhein.safetravels.models.Expense;
import com.samhein.safetravels.repositories.ExpenseRepository;

@Service
public class ExpenseService {
	@Autowired
	private ExpenseRepository expenseRepo;
	
	//FindAll
	public List<Expense> allExpenses(){
		return expenseRepo.findAll();
	}
	
	// create
	public Expense createExpense(Expense expense) {
		return expenseRepo.save(expense);
	}
	// find one
	public Expense findExpense(Long id) {
		Optional<Expense> optionalExpense = expenseRepo.findById(id);
		if(optionalExpense.isPresent()) {
			return optionalExpense.get();
		} else {
			return null;
		}
	}
		
	// update (find One+Create)
	public Expense updateExpense(Expense expense) {
		return expenseRepo.save(expense);
	}
	
	// delete
	public void deleteExpense(Long id) {
		expenseRepo.deleteById(id);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
