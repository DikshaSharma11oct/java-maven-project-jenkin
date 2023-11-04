package com.ehcache.LibraryApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching //To enable Caching 
public class LibraryAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryAppApplication.class, args);
	}

}
