package com.onion.OnionTestV2;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class OnionTestV2Application {

	public static void main(String[] args) {
		SpringApplication.run(OnionTestV2Application.class, args);
	}

	@Bean
	public CommandLineRunner run(EmployeeRepository repository) {
		return (args -> {
			insertJavaAdd(repository);
			System.out.println(repository.findAll());
		});
	}

	private void insertJavaAdd(EmployeeRepository repository){

	}

}
