package com.spring.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.spring.controller.impl.IPurchaseOrderController;
import com.spring.model.Category;
import com.spring.model.PurchaseOrder;
import com.spring.model.SubCategory;
import com.spring.model.Supplier;
import com.spring.service.PurchaseOrderService;
@RestController
@RequestMapping(value = "purchaseorder")
public class PurchaseOrderController implements IPurchaseOrderController{

	@Autowired
	PurchaseOrderService purchaseOrderService;
	
	@Override
	@RequestMapping(value = "/create")
	public ModelAndView create() {
		Map data = new HashMap();
		List<Supplier> suppliers = purchaseOrderService.getAllSupppliers();
		List<Category> category = purchaseOrderService.getCategory();
		List<SubCategory> subCategory = purchaseOrderService.getSubCategory();
		data.put("suppliers", suppliers);
		data.put("category", category);
		data.put("subCategory", subCategory);
		return new ModelAndView("purchaseorder/orderproduct", "data", data);
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
	public ModelAndView save(@ModelAttribute PurchaseOrder p) {
		purchaseOrderService.save(p);
		return new ModelAndView("/purchaseorder/create");
	}

}
