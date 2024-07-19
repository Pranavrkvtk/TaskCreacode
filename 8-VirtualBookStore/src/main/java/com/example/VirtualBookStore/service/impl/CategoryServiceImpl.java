package com.example.VirtualBookStore.service.impl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.VirtualBookStore.model.Category;
import com.example.VirtualBookStore.repository.ICategoryRepository;
import com.example.VirtualBookStore.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	
	@Autowired
	private ICategoryRepository dao;
	@Override
	public Category savecategory(Category category) {
		// TODO Auto-generated method stub
		return dao.save(category);
	}

	@Override
	public Category getBycategoryID(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

}
