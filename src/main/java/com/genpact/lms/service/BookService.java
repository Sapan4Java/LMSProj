package com.genpact.lms.service;

import java.util.List;
import java.util.Optional;

import com.genpact.lms.model.Book;

/**
 * @author Sapan
 *
 */
public interface BookService {	

	public List<Book> getAllBooks();

	public Optional<Book> getBookByCode(Integer bookCode);
	
	public List<Book> addBook(Book book);

	public Book updateBook(Book book);

	public List<Book> deleteBook(Integer bookCode);
	
	public Book searchBook(Integer bookCode);
	
	// ------------------
	
	//public List<Book> getAllBooksByLibraryCode(Integer libraryCode);
}