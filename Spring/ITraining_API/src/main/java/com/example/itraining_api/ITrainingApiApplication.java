package com.example.itraining_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class ITrainingApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ITrainingApiApplication.class, args);
	}

}
