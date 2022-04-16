package com.spring.controller;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.spring.controller.impl.IPOSController;
import com.spring.model.Product;
import com.spring.model.Inventory;
import com.spring.service.InventoryService;
import com.spring.service.POSService;

@RestController
@RequestMapping(value = "posController")
public class POSController implements IPOSController{
	
	@Autowired
	POSService posService;

	@Override
	@RequestMapping(value = "/posView")
	public ModelAndView create() {
		List<Product> products = posService.getAllProducts();
		return new ModelAndView("/pos/pos", "products", products);
	}

	@Override
	@RequestMapping(value = "/posSave")
	public ModelAndView save(HttpServletRequest request) {
		System.out.println(request.getParameter("product_name[]"));
		System.out.println(request.getParameter("product_quantity[]"));
		Map<String, String[]> map = request.getParameterMap();
		for (int i = 0; i < map.get("product_name[]").length; i++) {
			System.out.println(map.get("product_name[]")[i]);
			System.out.println(map.get("product_quantity[]")[i]);
		}
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
	public ModelAndView getAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@RequestMapping(value = "/productDetail/{code}")
	public Inventory getProductDetail(@PathVariable String code) {
		return posService.getProductDetail(code);
	}

}
