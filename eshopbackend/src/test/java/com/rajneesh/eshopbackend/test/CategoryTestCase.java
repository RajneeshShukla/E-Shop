package com.rajneesh.eshopbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.rajneesh.eshopbackend.dao.CategoryDAO;
import com.rajneesh.eshopbackend.dto.Category;

public class CategoryTestCase {
	private static AnnotationConfigApplicationContext context;
	private static CategoryDAO categoryDAO;
	private static Category category;
	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.rajneesh.eshopbackend");
		context.refresh();
		
		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");		 
	}
	
	@Test
	public void testAddCategory() {
		category = new Category();
		category.setName("Rajneesh");
		category.setActive(true);
		category.setDescription("He is good");
		category.setImageUrl("xxx.png");
		
		assertEquals("Successfully added new Category in table", true, categoryDAO.addCategory(category));
	}
	
	@Test
	public void getCategory() {
		category = categoryDAO.getCategory(1);
		assertEquals("Successfully fetched single category","TV" ,category.getName());
	}
	
	@Test
	public void updateCategory() {
		category = categoryDAO.getCategory(2);
		category.setName("Mobile");		
		assertEquals("Successfully fetched single category",true ,categoryDAO.updateCategory(category));
	}
	
	@Test
	public void getAllActiveCategory() {		
		assertEquals("Successfully fetched all active categories", 7 ,categoryDAO.getCategoriesList().size());
	}
}
