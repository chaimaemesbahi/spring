package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages ={"com.example.demo.entities"} )
@ComponentScan(basePackages ={"com.example.demo.Controller", "com.example.demo.service"} )
@EnableJpaRepositories(basePackages = "com.example.demo.repositories")
public class ElhorafiV2Application {

	public static void main(String[] args) {
		SpringApplication.run(ElhorafiV2Application.class, args);
	}
}
