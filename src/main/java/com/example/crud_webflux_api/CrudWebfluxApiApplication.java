package com.example.crud_webflux_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

//@EnableReactiveMongoRepositories(basePackages = "com.example.crud_webflux_api.repository")
@SpringBootApplication
public class CrudWebfluxApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudWebfluxApiApplication.class, args);
	}

}
