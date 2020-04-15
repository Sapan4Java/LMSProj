package com.genpact.lms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.genpact.lms.model.Book;
import com.genpact.lms.service.BookService;

@SpringBootApplication
public class LmsProjApplication implements CommandLineRunner {
	
	@Autowired
	private BookService bookService;

	public static void main(String[] args) {
		SpringApplication.run(LmsProjApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		bookService.addBook(new Book(1001, "java", "Matthew"));
		bookService.addBook(new Book(1002, "spring", "Mark"));
		bookService.addBook(new Book(1003, "hibernate", "Luke"));			
	}
}
