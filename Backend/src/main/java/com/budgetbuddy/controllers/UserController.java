package com.budgetbuddy.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RestController;

import com.budgetbuddy.Utils.JwtUtils;
import com.budgetbuddy.entities.User;
import com.budgetbuddy.service.ExpenseService;
import com.budgetbuddy.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@CrossOrigin
@RequestMapping
public class UserController {

	@Autowired
	private UserService userService;
	private ExpenseService expenseService;
	private JwtUtils jwtUtil;
	private AuthenticationManager authenticationManager;
	
	@PostMapping("/RegisterUser")
	public ResponseEntity<?> postMethodName(@RequestBody User user) {
		System.out.println("hiii");
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.saveUser(user));
	}
	
	@GetMapping("/expenses")
	public ResponseEntity<?> getExpenses(@RequestBody Long id)
	{
		return ResponseEntity.status(HttpStatus.OK).body(userService.getAllExpenses(id));
	}
	
	@PostMapping("/login")
    public ResponseEntity<String> Login(@RequestBody String username,@RequestBody String password) {
        try{
        	System.out.println("in try");
        	User user=userService.findByUsernameAndPassword(username, password);
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
            UserDetails userDetails = userService.loadUserByUsername(user.getUsername());
            String jwt = jwtUtil.generateToken(userDetails.getUsername());
            
            return new ResponseEntity<>(jwt, HttpStatus.OK);
        }catch (Exception e){
        	System.out.println("in catch");
            //log.error("Exception occurred while createAuthenticationToken ", e);
            return new ResponseEntity<>("Incorrect username or password", HttpStatus.BAD_REQUEST);
        }
    }
	
}
