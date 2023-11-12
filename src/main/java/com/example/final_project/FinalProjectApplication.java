package com.example.final_project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.crypto.password.PasswordEncoder;


@EnableScheduling
@SpringBootApplication
public class FinalProjectApplication {

	private  PasswordEncoder passwordEncoder;

	public static void main(String[] args) {

		SpringApplication.run(FinalProjectApplication.class, args);
	}
}

