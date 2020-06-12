package com.rajneesh.eshopbackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.rajneesh.eshopbackend.dao.CategoryDAO;
import com.rajneesh.eshopbackend.dto.Category;

@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {
	static List<Category> list;
	
	static {
		Category c1 = new Category();
		c1.setId(1);
		c1.setName("TV");
		
		Category c2 = new Category();
		c2.setId(2);
		c2.setName("Mobile");
		
		Category c3 = new Category();
		c3.setId(3);
		c3.setName("Computer");
		
		list  = new ArrayList<Category>();
		list.add(c1);
		list.add(c2);
		list.add(c3);
	}
	
	
	@Override
	public List<Category> getCategoriesList() {
		return list;
	}

	@Override
	public Category get(int id) {
		for (Category category : list) {
			if(category.getId() == id) {
				return category;
			}
		}
		return null;
	}
	
}
