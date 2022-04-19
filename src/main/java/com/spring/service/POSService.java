package com.spring.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.spring.dao.POSDAO;
import com.spring.model.Inventory;
import com.spring.model.POSSales;
import com.spring.model.Product;
import com.spring.model.PurchaseDemand;
import com.spring.service.impl.IPOSService;
@Service(value = "posService")
public class POSService implements IPOSService{

	@Autowired
	ProductService productService;
	@Autowired
	InventoryService inventoryService;
	@Autowired
	POSDAO posDAO;
	
	@Override
	public POSSales save(HttpServletRequest request) {
		Map<String, String[]> map = request.getParameterMap();
		String str = request.getParameter("customer");
		List<String> customerCode = Arrays.asList(str.split(" "));
		Date date = new Date(System.currentTimeMillis());
		PurchaseDemand pd = new PurchaseDemand();
		for (int i = 0; i < map.get("product_code[]").length; i++) {
			  //Product p = productService.getProductDetailsByCode(map.get("product_code[]")[i]);
			  //System.out.println(p.getProductImage());
			Inventory inven = inventoryService.getProductsDetails(map.get("product_code[]")[i]);
			POSSales sales = new POSSales();
			sales.setSalesQuantity(Integer.valueOf(map.get("product_quantity[]")[i]));
			sales.setCustomerCode(customerCode.get(0));
			sales.setCustomerName(customerCode.get(1));
			sales.setSalesDate(date);
			sales.setProductCode(inven.getProductCode());
			sales.setProductName(inven.getProductName());
			sales.setProductImage(inven.getProductImage());
			sales.setProfit(inven.getProfitPerUnit() * sales.getSalesQuantity());
			sales.setSellingPrice(inven.getSellingPrice() * sales.getSalesQuantity());
			sales.setTransactionCode(Integer.valueOf(request.getParameter("transactionCode")));
			posDAO.save(sales);
			int quantity = inven.getStoredAmount() - Integer.valueOf(map.get("product_quantity[]")[i]);
			inventoryService.updateSold(map.get("product_code[]")[i], quantity);
			
		}
		
		/*
		 * Map<String, String[]> mapa = request.getParameterMap(); Set<String> key =
		 * map.keySet(); for (int i = 0; i < map.size(); i++) { for (String k : key) {
		 * System.out.println("... " + k + "   " + request.getParameter(k)); }
		 * 
		 * }
		 */
		 
		
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
		
		return posDAO.getAll();
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

	@Override
	public int getTransactionId() {
		try {
			return posDAO.getTransactionId();
		} catch (Exception e) {
			return 1;
		}
	}

}
