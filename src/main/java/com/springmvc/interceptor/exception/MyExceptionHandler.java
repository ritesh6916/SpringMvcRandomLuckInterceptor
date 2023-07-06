package com.springmvc.interceptor.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MyExceptionHandler {
	
	@ExceptionHandler(value = MyBadluckException.class)
	public String badluckHandler(Model m )
	{
		m.addAttribute("msg","You are unlucky please try again...");
		return "customErrorPage";
	}
	
	@ExceptionHandler(NullPointerException.class)
	public String nullPointerhandler(Model m)
	{
		m.addAttribute("msg","NullPointerExceptionOccured...");
		return "customErrorPage";
	}
}