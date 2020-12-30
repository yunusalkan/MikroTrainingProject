package com.training.ykb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.training.ykb")
public class CustomerProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerProjectApplication.class, args);
	}

}
