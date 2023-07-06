package com.springmvc.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.springmvc.interceptor.exception.BadluckException;

public class MyInterceptor extends HandlerInterceptorAdapter{

	private double luck=0;
	private int length=0;
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("MyInterceptor-preHandle");
		
		String name=""+request.getParameter("txtname");
		System.out.println(name);
		if(name.equals(""))
		{
			throw new NullPointerException();
		}
		
		luck=Math.random()*10;
		System.out.println("Your Luck out of 10 is: "+luck);
		if(luck<5)
		{
			throw new BadluckException(luck);
		
		}
		request.setAttribute("score", luck);
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("MyInterceptor-postHandle");
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("MyInterceptor-afterCompletion");
		
	}
}
