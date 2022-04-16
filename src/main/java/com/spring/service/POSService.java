package com.spring.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.spring.model.Inventory;
import com.spring.model.POSSales;
import com.spring.model.Product;
import com.spring.service.impl.IPOSService;
@Service(value = "posService")
public class POSService implements IPOSService{

	@Autowired
	ProductService productService;
	@Autowired
	InventoryService inventoryService;
	
	@Override
	public POSSales save(HttpServletRequest request) {
		Map<String, String[]> map = request.getParameterMap();
		Map<String, Integer> proList = new HashMap<>();
		for (int i = 0; i < map.get("product_name[]").length; i++) {
			for (int j = i+1; j <  map.get("product_name[]").length; j++) {
				if (map.get("product_name[]")[i] == map.get("product_name[]")[j]) {
					
				}
			}
			proList.put(map.get("product_name[]")[i], Integer.valueOf(map.get("product_quantity[]")[i]));
			System.out.println(map.get("product_name[]")[i]);
			System.out.println(map.get("product_quantity[]")[i]);	 
		}
		
		return null;
	}

	@Override
	public POSSales edit(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public POSSales update(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<POSSales> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Product> getAllProducts() {
		return productService.getAll();
	}
	
	public Inventory getProductDetail(String code) {
		return inventoryService.getProductsDetails(code);
	}

}
