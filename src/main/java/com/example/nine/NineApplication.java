package com.example.nine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = {"com.example.nine.menu.entity", "com.example.nine.global.entity"})
public class NineApplication {

	public static void main(String[] args) {
		SpringApplication.run(NineApplication.class, args);
	}

}
