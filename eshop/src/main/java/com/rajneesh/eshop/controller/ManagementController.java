package com.rajneesh.eshop.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.rajneesh.eshopbackend.dao.CategoryDAO;
import com.rajneesh.eshopbackend.dao.ProductDAO;
import com.rajneesh.eshopbackend.dto.Category;
import com.rajneesh.eshopbackend.dto.Product;

@Controller
@RequestMapping("/manage")
public class ManagementController {
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private ProductDAO productDAO;
	
	private static final Logger logger = org.slf4j.LoggerFactory.getLogger(ManagementController.class);
	
	@RequestMapping("/products")
	public ModelAndView showManageProducts(@RequestParam(name = "operation", required = false)String operation) {
		ModelAndView mv  = new ModelAndView("page");
		mv.addObject("title", "Manage Products");
		mv.addObject("userClickManageProducts",  true);
		
		Product product  = new Product();
		product.setSupplierId(1);
		product.setActive(true);
		
		mv.addObject("product", product);
		
		if(operation != null) {
			if(operation.equals("product")) {
				mv.addObject("alertMsg", "Product Added Successfully");
			}
		}
		return mv;
	}
	
	@ModelAttribute("categories")
	public List<Category> getCategories(){
		return categoryDAO.getCategoriesList();
	}
	
	/**
	 * Save Product submission
	 */
	@RequestMapping(value = "/products", method = RequestMethod.POST)
	public String handleProductSubmission(@Valid @ModelAttribute("product") Product product, BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("title", "Manage Products");
			model.addAttribute("userClickManageProducts",  true);
			model.addAttribute("errorMsg", "Validation failed!");
			return "page";
		}
		
		logger.info(product.toString());
		productDAO.addProduct(product);
		return "redirect:/manage/products?operation=product";
	}
}
