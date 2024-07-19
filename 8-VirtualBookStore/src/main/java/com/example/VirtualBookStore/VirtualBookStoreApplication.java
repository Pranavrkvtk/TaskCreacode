package com.example.VirtualBookStore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication

public class VirtualBookStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(VirtualBookStoreApplication.class, args);

		System.out.println("books");
	}

}
