package com.dmiazga.budgetapp.budget;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dmiazga.budgetapp.income.Income;

@Repository
public interface BudgetJpaRepository extends JpaRepository<Budget, Long> {
	List<Budget> findAllByUsernameid(long usernameid);
}
