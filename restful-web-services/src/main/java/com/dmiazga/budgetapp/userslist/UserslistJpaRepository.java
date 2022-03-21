package com.dmiazga.budgetapp.userslist;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserslistJpaRepository extends JpaRepository<Userslist, Long> {
	List<Userslist> findAll();
}