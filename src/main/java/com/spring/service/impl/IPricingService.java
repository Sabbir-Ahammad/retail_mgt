package com.spring.service.impl;

import java.util.List;

import com.spring.common.ICommonService;
import com.spring.model.Product;
import com.spring.model.Supplier;

public interface IPricingService extends ICommonService<Product>{

	public Product getProductById(int id);
	public Product getProductsDetails(String productName);
	public List<Product> getProductsBySupplierName(String supplierName);
	public List<Product> getAllProducts();
	public List<Supplier> getAllSupplier();
}
