package com.budgetbuddy.service;

import java.util.List;

import com.budgetbuddy.entities.Expense;
import com.budgetbuddy.entities.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public interface UserService {

	 public User getUserById(Long userId);

	    public User saveUser(User user);

	    public User findByUsernameAndPassword(String username, String password);

	    public List<Expense> getAllExpenses(Long user_id);

	    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
}
