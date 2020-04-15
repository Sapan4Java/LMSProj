package com.genpact.lms.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Entity
public class Library {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int libraryCode;
	private String LibraryName;
	
	//@OneToMany(targetEntity = Book.class, cascade = CascadeType.ALL)
	//@JoinColumn(name = "library_fk", referencedColumnName = "libraryCode")
	
	//@OneToMany
	//@JoinTable(joinColumns = @JoinColumn(name="Library_Code"),
	//inverseJoinColumns = @JoinColumn(name="Book_Code"))
	//private Collection<Book> books = new ArrayList<Book>();	
}