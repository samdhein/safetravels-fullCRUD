package com.samhein.safetravels.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.samhein.safetravels.models.Expense;
import com.samhein.safetravels.services.ExpenseService;

@Controller
public class ExpenseController {
	
	@Autowired
	private ExpenseService expenseService;
	
	@GetMapping("/expenses")
	public String dashForm(Model model, @ModelAttribute("expense")Expense expense) {
		List<Expense> expenses = expenseService.allExpenses();
		model.addAttribute("expenses", expenses);
		return "dashForm.jsp";
	}
	@PostMapping("/expenses")
	public String dashCreate(@Valid @ModelAttribute("expense")Expense expense, BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("expenses", expenseService.allExpenses());
			return "dashForm.jsp";
		} else {
			expenseService.createExpense(expense);
			return "redirect:/expenses";
		}
			
	}
	@GetMapping("/expenses/{id}")
	public String showOne(@PathVariable("id")Long id, Model model) {
		Expense expense = expenseService.findExpense(id);
		model.addAttribute("expense", expense);
		return "showOne.jsp";
	}
	
	@GetMapping("/expenses/edit/{id}")
	public String editOne(@PathVariable("id")Long id, Model model) {
		Expense expense = expenseService.findExpense(id);
		model.addAttribute("expense", expense);
		return "edit.jsp";
	}
	
	@PutMapping("/expenses/edit/{id}")
	public String update(@Valid @ModelAttribute("expense")Expense expense, BindingResult result, @PathVariable("id") Long id,Model model) {
		if(result.hasErrors()) {
			return "edit.jsp";
		} else {
			expenseService.updateExpense(expense);
			return "redirect:/expenses";
		}
		
	}
	@DeleteMapping("/expenses/delete/{id}")
	public String deleteIcecream(@PathVariable("id")Long id) {
		expenseService.deleteExpense(id);
		return "redirect:/expenses";
	}
	
	
}
