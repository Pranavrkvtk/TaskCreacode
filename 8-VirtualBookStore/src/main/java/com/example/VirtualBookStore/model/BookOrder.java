package com.example.VirtualBookStore.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ordertable")
public class BookOrder extends BaseEntity {

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "book_id")
	private Books book;

	private int quantity;
	private double totalPrice;

	// Getters and Setters
	public Books getBook() {
		return book;
	}

	public void setBook(Books book) {
		this.book = book;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

}
