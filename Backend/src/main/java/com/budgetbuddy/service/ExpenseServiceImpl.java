package com.budgetbuddy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.budgetbuddy.entities.Expense;
import com.budgetbuddy.repository.ExpenseRepo;


@Service
public class ExpenseServiceImpl implements ExpenseService{

	
	@Autowired
	private ExpenseRepo expenseRepo;
	
	@Override
	public Expense saveExpense(Expense expense) {
	return expenseRepo.save(expense);
	}

	@Override
	public List<Expense> getByUserId(Long userId) {
		return expenseRepo.getByUserId(userId);
	}
	
}
