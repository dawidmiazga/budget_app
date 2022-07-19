package com.dmiazga.budgetapp.expense;

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

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ExpenseJPAResource {

	@Autowired
	private ExpenseJpaRepository expenseJpaRepository;

	@GetMapping("/jpa/users/{usernameid}/expenses")
	public List<Expense> getAllExpenses(@PathVariable long usernameid) {
		return expenseJpaRepository.findAllByUsernameid(usernameid);
	}

	@GetMapping("/jpa/users/{usernameid}/expenses/{expenseid}")
	public Expense getExpense(@PathVariable long usernameid, @PathVariable long expenseid) {
		return expenseJpaRepository.findById(expenseid).get();
	}

	@DeleteMapping("/jpa/users/{usernameid}/expenses/{expenseid}")
	public ResponseEntity<Void> deleteExpense(@PathVariable long usernameid, @PathVariable long expenseid) {
		expenseJpaRepository.deleteById(expenseid);
		return ResponseEntity.noContent().build();
	}

	@PutMapping("/jpa/users/{usernameid}/expenses/{expenseid}")
	public ResponseEntity<Expense> updateExpense(@PathVariable long usernameid, @PathVariable long expenseid,
			@RequestBody Expense expense) {
		Expense expenseUpdated = expenseJpaRepository.save(expense);
		return new ResponseEntity<Expense>(expense, HttpStatus.OK);
	}

	@PostMapping("/jpa/users/{usernameid}/expenses")
	public ResponseEntity<Void> createExpense(@PathVariable long usernameid, @RequestBody Expense expense) {
		Expense createdExpense = expenseJpaRepository.save(expense);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{usernameid}")
				.buildAndExpand(createdExpense.getExpenseid()).toUri();
		return ResponseEntity.created(uri).build();
	}
}