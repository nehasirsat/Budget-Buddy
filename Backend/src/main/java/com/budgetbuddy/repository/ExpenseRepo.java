package com.budgetbuddy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.budgetbuddy.entities.Expense;

@Repository
public interface ExpenseRepo extends JpaRepository<Expense, Long>{
	 @Query("SELECT e FROM Expense e WHERE e.user.Id = :userId")
	    public List<Expense> getByUserId(@Param("userId") Long userId);
	
}
