package com.edusite;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com")
public class EdusiteApplication {

	public static void main(String[] args) {
		SpringApplication.run(EdusiteApplication.class, args);
	}

}
