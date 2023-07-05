package com.springmvc.interceptor.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String homeController()
	{
		return "Home";
	}
	
	@RequestMapping("welcome")
	public String welcomeController(@RequestParam("txtname") String name, Model m)
	{
		m.addAttribute("name", name);
		return "Welcome";
	}
}
