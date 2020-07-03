package com.rajneesh.eshop.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.rajneesh.eshopbackend.dto.Product;

public class ProductValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		
		
		return Product.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Product product = (Product) target;
		
		//Check image is selected or not
		if(product.getFile() == null || product.getFile().getOriginalFilename().equals("")) {
			errors.rejectValue("file", null, "Please select product image");
			return;
		}
		
		if( !(product.getFile().getContentType().equals("image/jpeg") ||
				product.getFile().getContentType().equals("image/png") ||
				product.getFile().getContentType().equals("image/gif"))) {
			errors.rejectValue("file", null, "Please select image file");
			return;
		}
			
	}

}
