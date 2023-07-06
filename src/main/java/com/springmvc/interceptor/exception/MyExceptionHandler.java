package com.springmvc.interceptor.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MyExceptionHandler {
	
	@ExceptionHandler(value = BadluckException.class)
	public String badluckHandler(Model m )
	{
		double luck=BadluckException.luckScore;
		m.addAttribute("msg1","You are unlucky , you did't pass the Interceptor...");
		m.addAttribute("msg2", "your luck score was: "+luck);
		return "customErrorPage";
	}
	
	@ExceptionHandler(NullPointerException.class)
	public String nullPointerhandler(Model m)
	{
		m.addAttribute("msg1","NullPointerExceptionOccured...");
		m.addAttribute("msg2","Please Fill your name..");
		return "customErrorPage";
	}
	@ExceptionHandler(Exception.class)
	public String genralExceptionHandler(Model m)
	{
		m.addAttribute("msg1","Something went wrong with server...");
		return "customErrorPage";
	}
}