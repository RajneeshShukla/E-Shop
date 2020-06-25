package com.rajneesh.eshop.exception;

import java.io.Serializable;

public class ProductNotFoundException extends Exception implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String message;
	
	public ProductNotFoundException() {
		this.message = "Product is not available";
	}
	
	public ProductNotFoundException(String message) {
		this.message = System.currentTimeMillis() + ": " + message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
