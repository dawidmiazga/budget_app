package com.dmiazga.budgetapp.userslist;

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

import com.dmiazga.budgetapp.userslist.Userslist;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class UserslistJPAResource {
	
	@Autowired
	private UserslistJpaRepository userslistJpaRepository;
	
	@GetMapping("/jpa/users/userslist")
	public List<Userslist> getAllTests(){
		return userslistJpaRepository.findAll();
	}
	
	@GetMapping("/jpa/users/userslist/{id}")
	public Userslist getUserslist(@PathVariable long id){
		return userslistJpaRepository.findById(id).get();
	}
	
	@DeleteMapping("/jpa/users/userslist/{id}")
	public ResponseEntity<Void> deleteUserslist(@PathVariable long id){
		userslistJpaRepository.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/jpa/users/userslist/{id}")
	public ResponseEntity<Userslist> updateUserslist(@PathVariable long id,@RequestBody Userslist userslist){
		Userslist userslistUpdated = userslistJpaRepository.save(userslist);
		return new ResponseEntity<Userslist>(userslist, HttpStatus.OK);
	}
	
	@PostMapping("/jpa/users/userslist")
	public ResponseEntity<Void> createUserslist(@RequestBody Userslist userslist){
		Userslist createdUserslist = userslistJpaRepository.save(userslist);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(createdUserslist.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
}