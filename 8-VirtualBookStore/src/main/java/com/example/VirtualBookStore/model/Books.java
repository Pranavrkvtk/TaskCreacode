package com.example.VirtualBookStore.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="bookstable")
public class Books extends BaseEntity {


	private String bookname;
	private String author;
	private double price;
	
	
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
}
