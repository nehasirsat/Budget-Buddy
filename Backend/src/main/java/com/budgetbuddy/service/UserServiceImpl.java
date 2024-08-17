package com.budgetbuddy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.budgetbuddy.entities.Expense;
import com.budgetbuddy.entities.User;
import com.budgetbuddy.repository.ExpenseRepo;
import com.budgetbuddy.repository.UserRepo;

@Service
public class UserServiceImpl implements UserService{

	
	@Autowired
    private UserRepo userRepo;
	private ExpenseRepo expenseRepo;
	
	@Override
	public User getUserById(Long userId) {
		return userRepo.findById(userId).orElse(null);
	}

	@Override
	public User saveUser(User user) {
		return userRepo.save(user);
	}

	@Override
	public User findByUsernameAndPassword(String username, String password) {
		return userRepo.findByUsernameAndPassword(username,password);
	}

	@Override
	public List<Expense> getAllExpenses(Long user_id) {
	    return expenseRepo.getByUserId(user_id);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepo.findByusername(username);
        if (user != null) {
            return org.springframework.security.core.userdetails.User.builder()
                    .username(user.getUsername())
                    .password(user.getPassword())
                    .build();
        }
        throw new UsernameNotFoundException("User not found with username: " + username);
	}

	
}
