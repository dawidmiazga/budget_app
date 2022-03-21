package com.dmiazga.rest.webservices.restfulwebservices.expense;

import java.net.URI;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.Statement;
//import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class ExpenseJPAResource {
	
	@Autowired
	private ExpenseJpaRepository expenseJpaRepository;
	
	@GetMapping("/jpa/users/{username}/expenses")
	public List<Expense> getAllExpenses(
			@PathVariable String username){
		return expenseJpaRepository.findByUsername(username);
	}
	
	@GetMapping("/jpa/users/{username}/expenses/{id}")
	public Expense getExpense(
			@PathVariable String username, 
			@PathVariable long id){
		return expenseJpaRepository.findById(id).get();
	}
	
	@DeleteMapping("/jpa/users/{username}/expenses/{id}")
	public ResponseEntity<Void> deleteExpense(
			@PathVariable String username, 
			@PathVariable long id){
		expenseJpaRepository.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/jpa/users/{username}/expenses/{id}")
	public ResponseEntity<Expense> updateExpense(
			@PathVariable String username,
			@PathVariable long id, 
			@RequestBody Expense expense){
		Expense expenseUpdated = expenseJpaRepository.save(expense);
		return new ResponseEntity<Expense>(expense, HttpStatus.OK);
	}
	
	@PostMapping("/jpa/users/{username}/expenses")
	public ResponseEntity<Void> createExpense(
			@PathVariable String username, 
			@RequestBody Expense expense){
		Expense createdExpense = expenseJpaRepository.save(expense);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(createdExpense.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
}