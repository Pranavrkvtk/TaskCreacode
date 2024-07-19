package com.example.GroupMangementSystem.Entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "racktable")
public class Rack extends BaseEntity {

	@OneToMany(mappedBy = "rack",cascade = CascadeType.ALL)
	
	private List <Book> book;

	public List<Book> getBook() {
		return book;
	}

	public void setBook(List<Book> book) {
		this.book = book;
	}

	
	
	
}
