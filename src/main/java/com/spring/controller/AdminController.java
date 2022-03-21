package com.spring.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping(value = "admin")
public class AdminController {
	
	@RequestMapping(value = "/dashboard", method = RequestMethod.GET)
	public ModelAndView create() {
		return new ModelAndView("admin/dashboard");
	}

}
