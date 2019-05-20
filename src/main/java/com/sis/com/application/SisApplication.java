package com.sis.com.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaAuditing
@EntityScan(basePackages = { "com.sis.com.business.model" })
@EnableJpaRepositories(basePackages = { "com.sis.com.repository" })
@ComponentScan(basePackages = { 
		"com.sis.com.controller",
		"com.sis.com.business.service"})
public class SisApplication {
		
	public static void main(String[] args) {
		SpringApplication.run(SisApplication.class, args);
	}

}
