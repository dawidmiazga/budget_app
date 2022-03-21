package com.dmiazga.budgetapp.categories;

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
public class CategoryJPAResource {

	@Autowired
	private CategoryJpaRepository categoryJpaRepository;
		
	@GetMapping("/jpa/users/{username}/categories")
	public List<Category> getAllCategories(@PathVariable String username){
		return categoryJpaRepository.findByUsername(username);
	}

	@GetMapping("/jpa/users/{username}/categories/{id}")
	public Category getCategory(@PathVariable String username, @PathVariable long id){
		return categoryJpaRepository.findById(id).get();
	}

	@DeleteMapping("/jpa/users/{username}/categories/{id}")
	public ResponseEntity<Void> deleteCategory(
			@PathVariable String username, @PathVariable long id){
		
		categoryJpaRepository.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/jpa/users/{username}/categories/{id}")
	public ResponseEntity<Category> updateCategory(
			@PathVariable String username,
			@PathVariable long id, @RequestBody Category category){
		
		Category categoryUpdated = categoryJpaRepository.save(category);
		return new ResponseEntity<Category>(category, HttpStatus.OK);
	}
	
	@PostMapping("/jpa/users/{username}/categories")
	public ResponseEntity<Void> createCategory(
			@PathVariable String username, @RequestBody Category category){
		Category createdCategory = categoryJpaRepository.save(category);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(createdCategory.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}	
}