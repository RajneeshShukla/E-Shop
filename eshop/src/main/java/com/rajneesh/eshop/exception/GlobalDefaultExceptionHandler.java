package com.rajneesh.eshop.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalDefaultExceptionHandler {
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public ModelAndView handleNoHandlerFoundException() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "404: Page not found");
		mv.addObject("errorDescription", "Page Not Found");
		mv.addObject("errorTitle","Error Code: 404");
		mv.addObject("errorPageClick", true);
		return mv;
	}
}
