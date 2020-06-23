package com.rajneesh.eshopbackend.dao;

import java.util.List;

import com.rajneesh.eshopbackend.dto.Category;

public interface CategoryDAO {
	//Add new Category
	boolean addCategory(Category category);
	
	// Get All Categories
	List<Category> getCategoriesList();
	
	//Get a category by id
	Category getCategory(int id);
	
	// Update a category
	boolean updateCategory(Category category);
	
	// Delete a category
	boolean deleteCategory(Category category);
}
