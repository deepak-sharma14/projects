package com.edusite;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com")
//@ComponentScan("com.edusite.dao", "com.edusite.controller",  "com.edusite.service","com.edusite.entity",
//"com.edusite.model","com.edusite.exceptionhandler")
public class EdusiteApplication {

	public static void main(String[] args) {
		SpringApplication.run(EdusiteApplication.class, args);
	}

}
