package com.dmiazga.budgetapp.bankaccount;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankaccountJpaRepository extends JpaRepository<Bankaccount, Long> {
	List<Bankaccount> findAllByUsernameid(long usernameid);
//	Long deleteByCategoryname(String categoryname);
	
}
