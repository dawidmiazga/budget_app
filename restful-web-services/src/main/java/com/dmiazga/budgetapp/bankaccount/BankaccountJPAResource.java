package com.dmiazga.budgetapp.bankaccount;

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
public class BankaccountJPAResource {

	@Autowired
	private BankaccountJpaRepository bankaccountJpaRepository;

	@GetMapping("/jpa/users/{usernameid}/bankaccounts")
	public List<Bankaccount> getAllBankaccounts(@PathVariable long usernameid) {
		return bankaccountJpaRepository.findAllByUsernameid(usernameid);
	}

	@GetMapping("/jpa/users/{usernameid}/bankaccounts/{bankaccountid}")
	public Bankaccount getBankaccountid(@PathVariable long usernameid, @PathVariable long bankaccountid) {
		return bankaccountJpaRepository.findById(bankaccountid).get();
	}

	@DeleteMapping("/jpa/users/{usernameid}/bankaccounts/{bankaccountid}")
	public ResponseEntity<Void> deleteBankaccount(@PathVariable long usernameid, @PathVariable long bankaccountid) {
		
//		long deletedRecords = bankaccountJpaRepository.deleteByBankaccountname("Dom");
//	    assertThat(deletedRecords).isEqualTo(1);
	    
		bankaccountJpaRepository.deleteById(bankaccountid);
		return ResponseEntity.noContent().build();
	} 

	@PutMapping("/jpa/users/{usernameid}/bankaccounts/{bankaccountid}")
	public ResponseEntity<Bankaccount> updateBankaccount(@PathVariable long usernameid, @PathVariable long bankaccountid,
			@RequestBody Bankaccount bankaccount) {
		Bankaccount bankaccountUpdated = bankaccountJpaRepository.save(bankaccount);
		return new ResponseEntity<Bankaccount>(bankaccount, HttpStatus.OK);
	}

	@PostMapping("/jpa/users/{usernameid}/bankaccounts")
	public ResponseEntity<Void> createBankaccount(@PathVariable long usernameid, @RequestBody Bankaccount bankaccount) {
		Bankaccount createdBankaccount = bankaccountJpaRepository.save(bankaccount);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(createdBankaccount.getUsernameid()).toUri();

		return ResponseEntity.created(uri).build();
	}
}