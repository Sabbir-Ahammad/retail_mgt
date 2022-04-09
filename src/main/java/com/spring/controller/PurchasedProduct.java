package com.spring.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.spring.model.PurchaseDemand;
import com.spring.service.PurchaseDemandService;

@RestController
@RequestMapping(value = "purchasedProduct")
public class PurchasedProduct {
	
	@Autowired
	PurchaseDemandService purchaseDemandService;
	
	@RequestMapping(value = "/purchasedproductlist", method = RequestMethod.GET)
	public ModelAndView save(HttpServletRequest request) {
		List<PurchaseDemand> pd =  purchaseDemandService.getAllReceived();
		return new ModelAndView("/productpurchased/purchasedproductlist", "pd", pd);
	}
}
