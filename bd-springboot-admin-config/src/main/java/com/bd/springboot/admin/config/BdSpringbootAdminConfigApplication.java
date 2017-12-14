package com.bd.springboot.admin.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.bd.springboot.admin")
public class BdSpringbootAdminConfigApplication {

	public static void main(String[] args) {
		SpringApplication.run(BdSpringbootAdminConfigApplication.class, args);
	}
}
