package com.genpact.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.genpact.lms.model.Library;

/**
 * @author Sapan
 *
 */
@Repository
public interface LibraryRepository extends JpaRepository<Library, Integer> {
	
}