package com.budgetbuddy.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.budgetbuddy.entities.Expense;


@Service
public interface ExpenseService {
	public Expense saveExpense(Expense expense);
    public List<Expense> getByUserId(Long userId);
}
