package com.rajneesh.eshopbackend.dao;

import java.util.List;

import com.rajneesh.eshopbackend.dto.Product;

public interface ProductDAO {
	// Get a product by  id
	Product getProduct(int productId);
	
	// Get All product 
	List<Product> getAllProduct();
	
	//Add a Product
	boolean addProduct(Product product);
	
	//  Delete a Product
	boolean deleteProduct(Product product);
	
	// Update Product
	boolean updateProduct(Product product);
	
	// Business Methods
	
	// Return all active products
 	List<Product> listActiveProducts();

 	// List all active product by category
 	List<Product> listActiveProductByCategory(int categoryId);
 	
 	// List latest active product
 	List<Product> getLatestActiveProducts(int count);
}
