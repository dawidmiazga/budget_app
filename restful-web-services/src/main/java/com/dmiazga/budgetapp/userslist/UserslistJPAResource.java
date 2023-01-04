package com.dmiazga.budgetapp.userslist;

import java.net.URI;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
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

import com.dmiazga.budgetapp.BudgetAppService;
import com.dmiazga.budgetapp.userslist.Userslist;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class UserslistJPAResource {

	@Autowired
	private UserslistJpaRepository userslistJpaRepository;

	@GetMapping("/jpa/users/userslist")
	public List<Userslist> getAllTests() {
		return userslistJpaRepository.findAll();
	}

	@GetMapping("/jpa/users/userslist/{usernameid}")
	public Userslist getUserslist(@PathVariable long usernameid) {
		return userslistJpaRepository.findById(usernameid).get();
	}

//	@GetMapping("/jpa/users/userslist/{usernameid}/year/{yearnumber}")
//	public Userslist getUserslistAndYear(@PathVariable long usernameid,@PathVariable long yearnumber) {
//
//		try {
//			String url = "jdbc:h2:mem:testdb";
//			Connection conn = DriverManager.getConnection(url, "sa", "");
//			Statement stmt = conn.createStatement();
//			ResultSet rs;
//
//			rs = stmt.executeQuery("Select SUM(Price) as sumeprice FROM Expense where year(target_date)='" + yearnumber + "' AND cycle='Nie'");
//
//			System.out.println(yearnumber);
//			
//			while (rs.next()) {
//				String sum = rs.getString("sumeprice");
//				System.out.println(sum);
//			}
//			conn.close();
//		} catch (Exception e) {
//			System.err.println("Got an exception! ");
//			System.err.println(e.getMessage());
//		}
//		return userslistJpaRepository.findById(usernameid).get();
//	} grammar rules, idioms, improving fluency

	@DeleteMapping("/jpa/users/userslist/{usernameid}")
	public ResponseEntity<Void> deleteUserslist(@PathVariable long usernameid) {
		userslistJpaRepository.deleteById(usernameid);
		return ResponseEntity.noContent().build();
	}

	@PutMapping("/jpa/users/userslist/{usernameid}")
	public ResponseEntity<Userslist> updateUserslist(@PathVariable long usernameid, @RequestBody Userslist userslist) {
		Userslist userslistUpdated = userslistJpaRepository.save(userslist);
		return new ResponseEntity<Userslist>(userslist, HttpStatus.OK);
	}

	@PostMapping("/jpa/users/userslist")
	public ResponseEntity<Void> createUserslist(@RequestBody Userslist userslist) {
		Userslist createdUserslist = userslistJpaRepository.save(userslist);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(createdUserslist.getUsernameid()).toUri();
		return ResponseEntity.created(uri).build();
	}
}