package com.budgetbuddy.entities;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Expense {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long expenseId;

	    private BigDecimal amount;
	    private String category;
	    private String description;
	    
	    @ManyToOne
	    @JoinColumn(name="Id",nullable = false)
	    private User user;
	
}
