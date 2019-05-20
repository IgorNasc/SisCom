package com.sis.com.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = { "com.sis.com.model" })
@EnableJpaRepositories(basePackages = { "com.sis.com.repository" })
public class SisApplication {
		
	public static void main(String[] args) {
		SpringApplication.run(SisApplication.class, args);
	}

}
