package com.example.VirtualBookStore.model;

import com.fasterxml.jackson.databind.deser.Deserializers.Base;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;


@Entity
@Table(name="categorytable")
public class Category extends BaseEntity {
	
	private String categoryname;

	public String getCategoryname() {
		return categoryname;
	}

	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}
	
	

}
