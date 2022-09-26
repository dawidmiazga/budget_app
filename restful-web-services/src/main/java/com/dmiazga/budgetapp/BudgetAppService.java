package com.dmiazga.budgetapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BudgetAppService {

	@Autowired
	public static void main(String[] args) {
		SpringApplication.run(BudgetAppService.class, args);
		System.out.println("Works");
	}
}
