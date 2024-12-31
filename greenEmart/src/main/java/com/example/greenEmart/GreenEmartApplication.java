package com.example.greenEmart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@ComponentScan({"com.example.greenEmart.controller, com.example.greenEmart.model, com.example.greenEmart.repository, com.example.greenEmart.service"})
@CrossOrigin("*")
public class GreenEmartApplication {

	public static void main(String[] args) {
		SpringApplication.run(GreenEmartApplication.class, args);
	}

}
