package com.example.GroupMangementSystem.Entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "booktabl")
public class Book extends BaseEntity {

	private double price;
	private String author;

	@ManyToOne
	@JoinColumn(name = "rack_id", referencedColumnName = "id")
	private Rack rack;

	public Rack getRack() {
		return rack;
	}

	public void setRack(Rack rack) {
		this.rack = rack;
	}

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
