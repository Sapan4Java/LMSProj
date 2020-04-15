package com.genpact.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.genpact.lms.model.Book;

/**
 * @author Sapan
 *
 */
@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
	
	//public List<Book> findByLibraryCode(Integer LibraryCode);
	
}
