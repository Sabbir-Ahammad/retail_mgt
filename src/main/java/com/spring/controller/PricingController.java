package com.spring.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.spring.controller.impl.IPricingController;
import com.spring.model.Product;
import com.spring.model.SubCategory;
import com.spring.model.Supplier;
import com.spring.service.PricingService;
import com.spring.service.SupplierService;
@RestController
@RequestMapping(value = "pricing")
public class PricingController implements IPricingController{

	@Autowired
	PricingService pricingService;

	
	@Override
	@RequestMapping(value = "/create")
	public ModelAndView create() {
		List<Supplier> suppliers = pricingService.getAllSupplier();
		List<Product> products = pricingService.getAllProducts();
		Map data = new HashMap();
		data.put("suppliers", suppliers);
		data.put("products", products);
		return new ModelAndView("pricing/create","data", data);
	}
	
	@RequestMapping(value = "/searchProduct/{supplier}", method = RequestMethod.POST)
	public List<Product> getValue(HttpServletRequest request, @PathVariable("supplier") String supplier) {
		return pricingService.getProductsBySupplierName(supplier);
	}

	@Override
	public ModelAndView save(HttpServletRequest request) {
		// TODO Auto-generated method stub
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

}
