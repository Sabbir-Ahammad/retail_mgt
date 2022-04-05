package com.spring.controller;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.spring.controller.impl.IPurchaseDemandController;
import com.spring.model.Category;
import com.spring.model.Product;
import com.spring.model.PurchaseDemand;
import com.spring.model.SubCategory;
import com.spring.model.Supplier;
import com.spring.service.PurchaseDemandService;
@RestController
@RequestMapping(value = "purchasedemand")
public class PurchaseDemandController implements IPurchaseDemandController{

	@Autowired
	PurchaseDemandService purchaseDemandService;
	
	@Override
	@RequestMapping(value = "/create")
	public ModelAndView create() {
		Map data = new HashMap();
		List<Supplier> suppliers = purchaseDemandService.getAllSupppliers();
		/* List<Category> category = purchaseOrderService.getCategory(); */
		/* List<SubCategory> subCategory = purchaseOrderService.getSubCategory(); */
		data.put("suppliers", suppliers);
		return new ModelAndView("purchasedemand/demandproduct", "data", data);
	}
	
	@RequestMapping(value = "/searchCategory/{supplierName}", method = RequestMethod.POST)
	public List<Product> getCategoryBySupplier(HttpServletRequest request, @PathVariable("supplierName") String supplierName) {
		List<Product> p = purchaseDemandService.getProductBySupplier(supplierName);
		Set set = new LinkedHashSet();
		for (int i = 0; i < p.size(); i++) {
			set.add(p.get(i).getCategoryName());
		}
		p.clear();
		p.addAll(set);
		for (int j = 0; j < p.size(); j++) {
			System.out.println(p.get(j));
		}
		
		return p;
	}
	
	@RequestMapping(value = "/searchSubCategory/{categoryName}", method = RequestMethod.POST)
	public List<Product> getSubCategorybyCategory(HttpServletRequest request, @PathVariable("categoryName") String categoryName) {
		List<Product> p = purchaseDemandService.getProductByCategory(categoryName);
		return p;
	}
	
	@RequestMapping(value = "/getProducts/{data}", method = RequestMethod.POST)
	public List<Product> getProducts(HttpServletRequest request, @PathVariable("data") String data) {
		purchaseDemandService.getProductsOnMultipleCriteria(data);
		return null;
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

	@Override
	@RequestMapping(value = "/save")
	public ModelAndView save(@ModelAttribute PurchaseDemand p) {
		purchaseDemandService.save(p);
		return new ModelAndView("/purchasedemand/create");
	}

}
