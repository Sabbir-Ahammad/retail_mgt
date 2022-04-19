package com.spring.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.spring.controller.impl.IPOSController;
import com.spring.model.Product;
import com.spring.model.Customer;
import com.spring.model.Inventory;
import com.spring.model.POSSales;
import com.spring.service.CustomerService;
import com.spring.service.InventoryService;
import com.spring.service.POSService;

@RestController
@RequestMapping(value = "posController")
public class POSController implements IPOSController{
	
	@Autowired
	POSService posService;
	@Autowired
	CustomerService customerService;

	@Override
	@RequestMapping(value = "/posView")
	public ModelAndView create() {
		Map data = new HashMap();
		List<Product> products = posService.getAllProducts();
		List<Customer> customers = customerService.getAll();
		int transactionCode = posService.getTransactionId();
		data.put("products", products);
		data.put("transactionCode", transactionCode);
		data.put("customers", customers);
		return new ModelAndView("/pos/pos", "data", data);
	}
	@Override
	@RequestMapping(value = "/posSave")
	public ModelAndView save(HttpServletRequest request) {
		posService.save(request);
		return null;
	}

	@Override
	public ModelAndView edit(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ModelAndView update(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ModelAndView delete(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public ModelAndView getAll() {
		// TODO Auto-generated method stub
		List<POSSales> pos = posService.getAll();
		return new ModelAndView("pos/salesreport", "pos", pos);
	}
	
	@RequestMapping(value = "/productDetail/{code}")
	public Inventory getProductDetail(@PathVariable String code) {
		return posService.getProductDetail(code);
	}

}
