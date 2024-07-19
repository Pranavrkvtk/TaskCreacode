package com.example.VirtualBookStore.service;

import java.util.UUID;

import com.example.VirtualBookStore.model.Category;

public interface CategoryService {

	Category savecategory (Category category);
	Category getBycategoryID(UUID id);
}
