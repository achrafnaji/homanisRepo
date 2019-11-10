package com.controller;

import java.security.Principal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.model.Role;
import com.model.Transaction;
import com.model.User;
import com.services.ProductService;
import com.services.TransactionService;
import com.services.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	@Autowired
	private ProductService productService;
	@Autowired
	private TransactionService transactionService;
	
	 @PostMapping("/api/user/registration")
	    public ResponseEntity<?> register(@RequestBody User user){
	        if(userService.findByUserName(user.getUserName())!=null){
	            return new ResponseEntity<>(HttpStatus.CONFLICT);
	        }
	        user.setRole(Role.USER);
	        return new ResponseEntity<>(userService.saveUser(user), HttpStatus.CREATED);
	    }
	 
	    @GetMapping("/api/user/login")
	    public ResponseEntity<?> getUser(Principal principal){

	        if(principal == null){
	            return ResponseEntity.ok(principal);
	        }
	        return new ResponseEntity<>(userService.findByUserName(principal.getName()), HttpStatus.OK);
	    }

	    @PostMapping("/api/user/purchase")
	    public ResponseEntity<?> purchaseProduct(@RequestBody Transaction transaction){
	        transaction.setPurchaseDate(LocalDateTime.now());
	         transactionService.saveTransaction(transaction);
	         return new ResponseEntity<>(transaction, HttpStatus.CREATED);
	    }

	    @GetMapping("/api/user/products")
	    public ResponseEntity<?> getAllProducts(){
	        return new ResponseEntity<>(productService.findAllProducts(), HttpStatus.OK);
	    }
		
	}
	

