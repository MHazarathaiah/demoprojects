package com.sample.sampleSpringBoot;

import com.sample.sampleSpringBoot.repository.EmployeeDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * h.hazarathaiah
 * 2020-01-09
 */

@SpringBootApplication
public class Application {
	@Autowired
	EmployeeDataRepository employeeDataRepository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
