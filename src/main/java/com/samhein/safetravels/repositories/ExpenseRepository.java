package com.samhein.safetravels.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.samhein.safetravels.models.Expense;

public interface ExpenseRepository extends CrudRepository<Expense, Long> {
	List<Expense> findAll();

}
