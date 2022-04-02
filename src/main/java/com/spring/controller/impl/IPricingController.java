package com.spring.controller.impl;

import org.springframework.web.servlet.ModelAndView;

import com.spring.common.ICommonController;
import com.spring.model.Product;

public interface IPricingController extends ICommonController{

	public ModelAndView setPricing(Product p, int id);
}
