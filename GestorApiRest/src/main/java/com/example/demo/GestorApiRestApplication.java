package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class GestorApiRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestorApiRestApplication.class, args);
	}

}
