package com.rajneesh.eshopbackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rajneesh.eshopbackend.dao.ProductDAO;
import com.rajneesh.eshopbackend.dto.Product;

@Repository("productDAO")
@Transactional
public class ProductDAOImpl implements ProductDAO{

	@Autowired
	private SessionFactory mSessionFectory;
	
	@Override
	public Product getProduct(int productId) {
		try {
			return mSessionFectory.getCurrentSession().get(Product.class, Integer.valueOf(productId));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Product> getAllProduct() {
		return mSessionFectory.getCurrentSession().createQuery("From product", Product.class).getResultList();
	}

	@Override
	public boolean addProduct(Product product) {
		try {
			mSessionFectory.getCurrentSession().persist(product);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteProduct(Product product) {
		try {
			product.setActive(false);
			mSessionFectory.getCurrentSession().update(product);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateProduct(Product product) {
		try {
			mSessionFectory.getCurrentSession().update(product);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<Product> listActiveProducts() {
		String activeProductQuery = "FROM product WHERE active = :active";
		return mSessionFectory
				.getCurrentSession()
				.createQuery(activeProductQuery, Product.class)
				.setParameter("active", true)
				.getResultList();
	}

	@Override
	public List<Product> listActiveProductByCategory(int categoryId) {
		String query = "FROM product WHERE active = :active AND categoryId = :categoryId";
		return mSessionFectory
				.getCurrentSession()
				.createQuery(query, Product.class)
				.setParameter("active", true)
				.setParameter("categoryId", categoryId)
				.getResultList();
	}

	@Override
	public List<Product> getLatestActiveProducts(int count) {
		String query = "FROM product WHERE active = :active AND ORDER BY id";
		return mSessionFectory
				.getCurrentSession()
				.createQuery(query, Product.class)
				.setParameter("active", true)
				.setFirstResult(0)
				.setMaxResults(count)
				.getResultList();
	}

}
