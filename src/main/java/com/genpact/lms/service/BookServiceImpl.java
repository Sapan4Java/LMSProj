package com.genpact.lms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.genpact.lms.model.Book;
import com.genpact.lms.repository.BookRepository;

/**
 * @author Sapan
 *
 */
@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepository;
	

	@Override
	public List<Book> getAllBooks() {
		return bookRepository.findAll();
	}	

	@Override
	public Optional<Book> getBookByCode(Integer bookCode) {
		return bookRepository.findById(bookCode);
	}
	
	@Override
	public List<Book> addBook(Book book) {
		bookRepository.save(book);
		return bookRepository.findAll();
	}

	@Override
	public Book updateBook(Book book) {
		return bookRepository.save(book);		
	}

	@Override
	public List<Book> deleteBook(Integer bookCode) {
		bookRepository.deleteById(bookCode);
		return this.getAllBooks();
	}

	@Override
	public Book searchBook(Integer bookCode) {
		return bookRepository.findAll().stream().filter(book -> book.getBookCode() == bookCode).findFirst().get();
	}	
	
	//@Override
	//public List<Book> getAllBooksByLibraryCode(Integer LibraryCode) {
	//	return bookRepository.findByLibraryCode(LibraryCode);
	//}
}
