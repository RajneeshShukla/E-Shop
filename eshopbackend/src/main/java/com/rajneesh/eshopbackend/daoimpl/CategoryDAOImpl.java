package com.rajneesh.eshopbackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rajneesh.eshopbackend.dao.CategoryDAO;
import com.rajneesh.eshopbackend.dto.Category;

@Repository("categoryDAO")
@Transactional
public class CategoryDAOImpl implements CategoryDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Category> getCategoriesList() {
		String selectAllActiveCate = "FROM Category WHERE active = :active";
		Query query = sessionFactory.getCurrentSession().createQuery(selectAllActiveCate);
		query.setParameter("active", true);
		return query.getResultList();
	}

	/**
	 * Get Single category
	 */
	@Override
	public Category getCategory(int id) {
		return sessionFactory.getCurrentSession().get(Category.class, Integer.valueOf(id));
	}

	/**
	 * Add a category
	 */
	@Override
	public boolean addCategory(Category category) {
		try {
			sessionFactory.getCurrentSession().persist(category);		
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Update category
	 */
	@Override
	public boolean updateCategory(Category category) {
		try {
			sessionFactory.getCurrentSession().update(category);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}	
	}

	/**
	 * Delete a Category
	 */
	@Override
	public boolean deleteCategory(Category category) {
		category.setActive(false);
		
		try {
			sessionFactory.getCurrentSession().update(category);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
}
