package com.genpact.lms.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.genpact.lms.model.Book;
import com.genpact.lms.service.BookService;

import javassist.NotFoundException;

/**
 * @author Sapan
 *
 */
@RestController
@RequestMapping("/lms")
public class BookRestController {

	public static final Logger logger = LoggerFactory.getLogger(BookRestController.class);

	@Autowired
	private BookService bookService;

	@GetMapping(value = "/message")
	public String getMessage() {
		return "Welcome Genpact! LMS Project ...";
	}

	@GetMapping(value = "/all_books")
	public List<Book> getListBooks() {
		return bookService.getAllBooks();
	}

	@GetMapping(value = "/find_book/{code}")
	public Book getBookByCode(@PathVariable(name = "code") Integer bookCode) {
		Book bookObj = null;
		Optional<Book> optionalBook = bookService.getBookByCode(bookCode);
		if (optionalBook.isPresent()) {
			bookObj = optionalBook.get();
		} else {
			try {
				throw new NotFoundException("Book is not found for book code: " + bookCode);
			} catch (NotFoundException e) {
				e.printStackTrace();
			}
		}
		return bookObj;
	}

	@PostMapping(value = "/add_book")
	public List<Book> addBook(@RequestBody Book book, @PathVariable(name = "age") Integer age) {

		// call validation 
		
		
		if (age > 18)
			return bookService.addBook(book);
		else
			throw new RuntimeException("");
	}

	@PutMapping(value = "/update_book")
	public Book updateBook(@RequestBody Book book) {
		return bookService.updateBook(book);
	}

	@DeleteMapping(value = "/delete_book/{code}")
	public List<Book> updateBookByCode(@PathVariable(name = "code") Integer bookCode) {
		return bookService.deleteBook(bookCode);
	}

	// @GetMapping(value = "/find_book/{code}")
	// public List<Book> getBooksByLibraryCode(@PathVariable(name="code") Integer
	// libraryCode) {
	// return bookService.getAllBooksByLibraryCode(libraryCode);
	// }

}
