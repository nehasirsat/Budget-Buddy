package com.budgetbuddy.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.budgetbuddy.entities.Expense;
import com.budgetbuddy.entities.User;
import com.budgetbuddy.service.ExpenseService;
import com.budgetbuddy.service.UserService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@CrossOrigin()
@RequestMapping
public class ExpenseController {

	@Autowired
	private UserService userService;
	private ExpenseService expenseService;
	
	@PostMapping("/addExpense")
	public ResponseEntity<?> addExpense(@RequestBody Expense expense,@RequestParam Long id)
	{
		User user=userService.getUserById(id);
		expense.setUser(user);
	    return ResponseEntity.status(HttpStatus.OK).body(expenseService.saveExpense(expense));
	}
	
}
