package com.spring.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.dao.ProductDAO;
import com.spring.model.Product;
import com.spring.model.Supplier;
import com.spring.service.impl.IPricingService;

@Service(value = "pricingService")
public class PricingService implements IPricingService{

	@Autowired
	ProductService productService;
	@Autowired
	SupplierService supplierService;
	
	@Override
	public Product save(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product edit(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product update(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Product> getProductsBySupplierName(String supplierName) {
		return productService.getProductsBySupplier(supplierName);
	}

	@Override
	public List<Product> getAllProducts() {
		return productService.getAll();
	}

	@Override
	public List<Supplier> getAllSupplier() {
		return supplierService.getAll();
	}

}
