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
import com.spring.dao.SupplierDAO;
import com.spring.model.Category;
import com.spring.model.PurchaseOrder;
import com.spring.model.SubCategory;
import com.spring.model.Supplier;
import com.spring.service.impl.IPurchaseOrderService;
@Service(value = "purchaseOrderService")
public class PurchaseOrderService implements IPurchaseOrderService{

	@Autowired
	SupplierService supplierService;
	@Autowired
	CategoryService categoryService;
	@Autowired
	SubCategoryService subcategoryService;
	
	public List<Supplier> getAllSupppliers(){
		return supplierService.getAll();
	}
	public List<Category> getCategory(){
		return categoryService.getAll();
	}
	public List<SubCategory> getSubCategory(){
		return subcategoryService.getAll();
	}
	@Override
	public PurchaseOrder save(HttpServletRequest request) {
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
	public PurchaseOrder edit(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PurchaseOrder update(HttpServletRequest request) {
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
	
	public PurchaseOrder save(PurchaseOrder p) {
		// TODO Auto-generated method stub
		return null;
	}

}
