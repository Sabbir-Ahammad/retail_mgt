package com.spring.service;

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
