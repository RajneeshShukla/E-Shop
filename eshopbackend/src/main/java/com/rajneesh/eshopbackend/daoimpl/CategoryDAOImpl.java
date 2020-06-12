package com.rajneesh.eshopbackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.rajneesh.eshopbackend.dao.CategoryDAO;
import com.rajneesh.eshopbackend.dto.Category;

@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {
	
	@Override
	public List<Category> getCategoriesList() {
		Category c1 = new Category();
		c1.setName("TV");
		
		Category c2 = new Category();
		c2.setName("Mobile");
		
		Category c3 = new Category();
		c3.setName("Computer");
		
		List<Category> list  = new ArrayList<Category>();
		list.add(c1);
		list.add(c2);
		list.add(c3);
		
		return list;
	}
	
}
