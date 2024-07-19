package com.example.GroupMangementSystem.dto;

import com.example.GroupMangementSystem.Entity.BaseEntity;

public class BookDto extends BaseEntity {

	private double price;
	private String author;
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
}
