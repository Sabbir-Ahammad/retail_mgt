package com.spring.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.model.POSSales;
import com.spring.model.Product;
import com.spring.service.impl.IPOSService;
@Service(value = "posService")
public class POSService implements IPOSService{

	@Autowired
	ProductService productService;
	
	@Override
	public POSSales save(HttpServletRequest request) {
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
		return productService.getAll();
	}

}
