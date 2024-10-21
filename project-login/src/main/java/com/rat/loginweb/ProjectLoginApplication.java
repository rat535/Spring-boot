package com.rat.loginweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class ProjectLoginApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectLoginApplication.class, args);
	}

}
