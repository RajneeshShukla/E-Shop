package com.rajneesh.eshop.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.rajneesh.eshop.exception.ProductNotFoundException;
import com.rajneesh.eshopbackend.dao.CategoryDAO;
import com.rajneesh.eshopbackend.dao.ProductDAO;
import com.rajneesh.eshopbackend.dto.Category;
import com.rajneesh.eshopbackend.dto.Product;


@Controller
public class PageController {
	
	private static final Logger logger = LoggerFactory.getLogger(PageController.class);
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private ProductDAO productDAO;
	
	@RequestMapping(value = { "/", "/index", "/home" })
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Home");
		mv.addObject("userClickHome", "true");
		mv.addObject("categories", categoryDAO.getCategoriesList());
		
		logger.info("Inside PageController index method - INFO");
		logger.debug("Inside PageController index method - DEBUG");
		return mv;
	}

	@RequestMapping(value = { "/about" })
	public ModelAndView about() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "About Us");
		mv.addObject("userClickAbout", "true");
		return mv;
	}

	@RequestMapping(value = { "/listProducts" })
	public ModelAndView listProducts() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Products List");
		mv.addObject("userClickProductList", "true");
		return mv;
	}

	@RequestMapping(value = { "/contact" })
	public ModelAndView contact() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Contact Us");
		mv.addObject("userClickContact", "true");
		return mv;
	}
	
	@RequestMapping(value = {"/show/all/products"})
	public ModelAndView showAllProducts() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "All Products");
		mv.addObject("userClickAllProducts", "true");
		
		// Passing the list of category
		mv.addObject("categories", categoryDAO.getCategoriesList());
		return mv;
	}
	
	@RequestMapping(value = {"/show/category/{id}/products"})
	public ModelAndView showCategoryProducts(@PathVariable("id") int id) {
		ModelAndView mv = new ModelAndView("page");
		
		mv.addObject("userClickCategoryProducts", "true");
		
		// Category DAO to fetch single category 
		Category category = null;
		category = categoryDAO.getCategory(id);
		mv.addObject("title", category.getName());
		
		mv.addObject("category", category);
		mv.addObject("categories", categoryDAO.getCategoriesList());
		return mv;
	}
	
	/**
	 *  Single product mapping
	 */
	@RequestMapping("/show/{id}/product")
	public ModelAndView showSingleProduct(@PathVariable int id) throws ProductNotFoundException {
		ModelAndView mv = new ModelAndView("page");
		
		Product product = productDAO.getProduct(id);
		
		if(product == null) throw new ProductNotFoundException();
		
		// Update views
		product.setViews(product.getViews() + 1);
		productDAO.updateProduct(product);
		
		mv.addObject("product", product);
		mv.addObject("userClickShowProduct", true);
		mv.addObject("title", product.getName());
		
		return mv;
	}
}
