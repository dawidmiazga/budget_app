package com.dmiazga.budgetapp.income;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IncomeJpaRepository extends JpaRepository<Income, Long> {
	List<Income> findByUsername(String username);
}