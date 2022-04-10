package com.spring.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
	InventoryService inventoryService;
	
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
		//string to date
		/*
		 * String dateString = request.getParameter("orderDate"); DateFormat formatter =
		 * new SimpleDateFormat("dd-MM-yyyy"); Date todayDate = null; try { todayDate =
		 * formatter.format(dateString); } catch (ParseException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 */
		//System.out.println(request.getParameter("productImage"));
		Date date = new Date(System.currentTimeMillis());
		//java.time.LocalDate.now();
		PurchaseDemand pd = new PurchaseDemand();
		pd.setOrderDate(date);
		pd.setPurchaseDemandCode(request.getParameter("purchaseDemandCode"));
		pd.setLotNumber(request.getParameter("lotNumber"));
		pd.setProductCode(request.getParameter("productCode"));
		pd.setProductName(request.getParameter("productName"));
		pd.setStatedPrice(Double.valueOf(request.getParameter("statedPrice")));
		pd.setDiscountRate(Double.valueOf(request.getParameter("discountRate")));
		pd.setDiscount(Double.valueOf(request.getParameter("discount")));
		pd.setTaxRate(Double.valueOf(request.getParameter("taxRate")));
		pd.setTax(Double.valueOf(request.getParameter("tax")));
		pd.setQuantity(Integer.valueOf(request.getParameter("quantity")));
		pd.setPurchasePrice(Double.valueOf(request.getParameter("purchasePrice")));
		pd.setSupplierName(request.getParameter("supplierName"));
		pd.setCategoryName(request.getParameter("categoryName"));
		pd.setSubCategoryName(request.getParameter("subCategoryName"));
		pd.setStatus("Demanded");
		pd.setProductImage(request.getParameter("productImage"));
		return purchaseDemandDAO.save(pd);
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
		return purchaseDemandDAO.getAll();
		
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

	@Override
	public PurchaseDemand updateStatus(PurchaseDemand p) {
		Date date = new Date(System.currentTimeMillis());
		p.setReceivedDate(date);
		PurchaseDemand pp = purchaseDemandDAO.updateStatus(p);
		PurchaseDemand pd = purchaseDemandDAO.getByID(p.getId());
		inventoryService.save(pd);
		return p;
	}
	
	public List<PurchaseDemand> getAllReceived(){
		return purchaseDemandDAO.getAllReceived();
	}

}
