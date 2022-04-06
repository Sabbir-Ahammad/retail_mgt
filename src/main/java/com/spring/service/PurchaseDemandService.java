package com.spring.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.dao.CategoryDAO;
import com.spring.dao.PurchaseDemandDAO;
import com.spring.dao.SupplierDAO;
import com.spring.model.Category;
import com.spring.model.Product;
import com.spring.model.PurchaseDemand;
import com.spring.model.SubCategory;
import com.spring.model.Supplier;
import com.spring.service.impl.IPurchaseDemandService;
@Service(value = "purchaseDemandService")
public class PurchaseDemandService implements IPurchaseDemandService{

	@Autowired
	SupplierService supplierService;
	@Autowired
	CategoryService categoryService;
	@Autowired
	SubCategoryService subcategoryService;
	@Autowired
	ProductService productService;
	
	@Autowired
	PurchaseDemandDAO purchaseDemandDAO;
	
	/*
	 * public List<Supplier> getAllSupppliers(){ return supplierService.getAll(); }
	 */
	public List<Product> getAllProducts(){
		return productService.getAll();
	}
	
	public List<Product> getProductBySupplier(String supplierName){
		return productService.getProductsBySupplier(supplierName);
	}

	/*
	 * public List<Category> getCategoryByName(){ return
	 * categoryService.getCategoryByName(); }
	 */
	public List<SubCategory> getSubCategory(){
		return subcategoryService.getAll();
	}
	@Override
	public PurchaseDemand save(HttpServletRequest request) {
		// TODO Auto-generated method stub
		//string to date
		String dateString = "2011-09-09";
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date myDate = formatter.parse(dateString);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public PurchaseDemand edit(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PurchaseDemand update(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	
	public PurchaseDemand save(PurchaseDemand p) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> getProductByCategory(String categoryName) {
		return productService.getProductsByCategory(categoryName);
	}

	@Override
	public List<Product> getProductsOnMultipleCriteria(String data) {
		String[] stringPart = data.split(",");
		for (int i = 0; i < stringPart.length; i++) {
			System.out.println(stringPart[i]);
		}
		return null;
	}

}
