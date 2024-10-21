package com.project.Banking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class Project2BankingmanegmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(Project2BankingmanegmentApplication.class, args);
	}

}
