package com.dmiazga.budgetapp.income;

import java.net.URI;
import java.util.ArrayList;
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

import com.dmiazga.budgetapp.income.Income;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class IncomeJPAResource {

	@Autowired
	private IncomeJpaRepository incomeJpaRepository;

	@GetMapping("/jpa/users/{usernameid}/incomes")
	public List<Income> getAllIncomes(@PathVariable long usernameid) {
		return incomeJpaRepository.findAllByUsernameid(usernameid);
	}

	@GetMapping("/jpa/users/{usernameid}/incomes/{id}")
	public Income getIncome(@PathVariable long usernameid, @PathVariable long id) {
		return incomeJpaRepository.findById(id).get();
	}

	@DeleteMapping("/jpa/users/{usernameid}/incomes/{id}")
	public ResponseEntity<Void> deleteIncome(@PathVariable long usernameid, @PathVariable long id) {
		incomeJpaRepository.deleteById(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping("/jpa/users/{usernameid}/incomes/{id}")
	public ResponseEntity<Income> updateIncome(@PathVariable long usernameid, @PathVariable long id,
			@RequestBody Income income) {
		Income incomeUpdated = incomeJpaRepository.save(income);
		return new ResponseEntity<Income>(income, HttpStatus.OK);
	}

	@PostMapping("/jpa/users/{usernameid}/incomes")
	public ResponseEntity<Void> createIncome(@PathVariable long usernameid, @RequestBody Income income) {
		Income createdIncome = incomeJpaRepository.save(income);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdIncome.getIncomeid())
				.toUri();
		return ResponseEntity.created(uri).build();
	}

}