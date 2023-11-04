package com.contactUs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class ContactUsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContactUsApplication.class, args);
	}

}
