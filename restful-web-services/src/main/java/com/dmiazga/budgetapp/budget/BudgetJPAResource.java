package com.dmiazga.budgetapp.budget;

import java.net.URI;
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
public class BudgetJPAResource {

	@Autowired
	private BudgetJpaRepository budgetJpaRepository;
		
	@GetMapping("/jpa/users/{username}/budgets")
	public List<Budget> getAllBudgets(@PathVariable String username){
		return budgetJpaRepository.findByUsername(username);
	}

	@GetMapping("/jpa/users/{username}/budgets/{id}")
	public Budget getBudget(@PathVariable String username, @PathVariable long id){
		return budgetJpaRepository.findById(id).get();
	}

	@DeleteMapping("/jpa/users/{username}/budgets/{id}")
	public ResponseEntity<Void> deleteBudget(
			@PathVariable String username, @PathVariable long id){
		
		budgetJpaRepository.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/jpa/users/{username}/budgets/{id}")
	public ResponseEntity<Budget> updateBudget(
			@PathVariable String username,
			@PathVariable long id, @RequestBody Budget budget){
		
		Budget budgetUpdated = budgetJpaRepository.save(budget);
		return new ResponseEntity<Budget>(budget, HttpStatus.OK);
	}
	
	@PostMapping("/jpa/users/{username}/budgets")
	public ResponseEntity<Void> createBudget(
			@PathVariable String username, @RequestBody Budget budget){
		Budget createdBudget = budgetJpaRepository.save(budget);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(createdBudget.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
		
}