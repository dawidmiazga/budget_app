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

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class BudgetJPAResource {

	@Autowired
	private BudgetJpaRepository budgetJpaRepository;

	@GetMapping("/jpa/users/{usernameid}/budgets")
	public List<Budget> getAllBudgets(@PathVariable long usernameid) {
		return budgetJpaRepository.findAllByUsernameid(usernameid);
	}

	@GetMapping("/jpa/users/{usernameid}/budgets/{budgetid}")
	public Budget getBudget(@PathVariable long usernameid, @PathVariable long budgetid) {
		return budgetJpaRepository.findById(budgetid).get();
	}

	@DeleteMapping("/jpa/users/{usernameid}/budgets/{budgetid}")
	public ResponseEntity<Void> deleteBudget(@PathVariable long usernameid, @PathVariable long budgetid) {
		budgetJpaRepository.deleteById(budgetid);
		return ResponseEntity.noContent().build();
	}

	@PutMapping("/jpa/users/{usernameid}/budgets/{budgetid}")
	public ResponseEntity<Budget> updateBudget(@PathVariable long usernameid, @PathVariable long budgetid,
			@RequestBody Budget budget) {
		Budget budgetUpdated = budgetJpaRepository.save(budget);
		return new ResponseEntity<Budget>(budget, HttpStatus.OK);
	}

	@PostMapping("/jpa/users/{usernameid}/budgets")
	public ResponseEntity<Void> createBudget(@PathVariable long usernameid, @RequestBody Budget budget) {
		Budget createdBudget = budgetJpaRepository.save(budget);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(createdBudget.getBudgetid()).toUri();
		return ResponseEntity.created(uri).build();
	}

}