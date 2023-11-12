package com.example.final_project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.event.EventListener;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.crypto.password.PasswordEncoder;


@EnableScheduling
//@EntityScan(basePackages = "entity")
//@EnableJpaRepositories(basePackages = "repo")
//@ComponentScan(basePackages = {"controller", "config", "data", "service", "entity", "repo", "exception", "fasade", "form", "persistence.type", "repo", "token", "util"})
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class FinalProjectApplication {


	public static void main(String[] args) {
		SpringApplication.run(FinalProjectApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void run() {

	}
}

