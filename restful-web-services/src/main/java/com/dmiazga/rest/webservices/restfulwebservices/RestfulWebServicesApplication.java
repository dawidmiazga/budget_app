package com.dmiazga.rest.webservices.restfulwebservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestfulWebServicesApplication {

	@Autowired
	public static void main(String[] args) {
		SpringApplication.run(RestfulWebServicesApplication.class, args);
			System.out.println("Works");
		}
}
