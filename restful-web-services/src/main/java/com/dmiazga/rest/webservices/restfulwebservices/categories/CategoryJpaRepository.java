package com.dmiazga.rest.webservices.restfulwebservices.categories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryJpaRepository extends JpaRepository<Category, Long> {
	List<Category> findByUsername(String username);
}
