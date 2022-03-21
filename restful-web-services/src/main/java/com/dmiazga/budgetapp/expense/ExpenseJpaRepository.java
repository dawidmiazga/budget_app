package com.dmiazga.budgetapp.expense;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseJpaRepository extends JpaRepository<Expense, Long> {
	List<Expense> findByUsername(String username);
}
