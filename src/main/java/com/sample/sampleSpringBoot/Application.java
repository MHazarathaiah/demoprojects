package com.sample.sampleSpringBoot;

import com.sample.sampleSpringBoot.repository.HospitalDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
	@Autowired
	HospitalDataRepository hospitalDataRepository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
