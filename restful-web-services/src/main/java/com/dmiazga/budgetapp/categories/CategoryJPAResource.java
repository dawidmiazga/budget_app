package com.dmiazga.budgetapp.categories;

import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.remoting.soap.SoapFaultException;
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
public class CategoryJPAResource {

	@Autowired
	private CategoryJpaRepository categoryJpaRepository;

	@GetMapping("/jpa/users/{usernameid}/categories")
	public List<Category> getAllCategories(@PathVariable long usernameid) {
		return categoryJpaRepository.findAllByUsernameid(usernameid);
	}

	@GetMapping("/jpa/users/{usernameid}/categories/{categoryid}")
	public Category getCategoryid(@PathVariable long usernameid, @PathVariable long categoryid) {
		return categoryJpaRepository.findById(categoryid).get();
	}

	@DeleteMapping("/jpa/users/{usernameid}/categories/{categoryid}")
	public ResponseEntity<Void> deleteCategory(@PathVariable long usernameid, @PathVariable long categoryid) {
		
//		long deletedRecords = categoryJpaRepository.deleteByCategoryname("Dom");
//	    assertThat(deletedRecords).isEqualTo(1);
	    
		categoryJpaRepository.deleteById(categoryid);
		return ResponseEntity.noContent().build();
	} 

	@PutMapping("/jpa/users/{usernameid}/categories/{categoryid}")
	public ResponseEntity<Category> updateCategory(@PathVariable long usernameid, @PathVariable long categoryid,
			@RequestBody Category category) {
		Category categoryUpdated = categoryJpaRepository.save(category);
		return new ResponseEntity<Category>(category, HttpStatus.OK);
	}

	@PostMapping("/jpa/users/{usernameid}/categories")
	public ResponseEntity<Void> createCategory(@PathVariable long usernameid, @RequestBody Category category) {
		Category createdCategory = categoryJpaRepository.save(category);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(createdCategory.getUsernameid()).toUri();

		return ResponseEntity.created(uri).build();
	}
}