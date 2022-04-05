package com.spring.dao.impl;

import java.util.List;

import com.spring.common.ICommonDAO;
import com.spring.model.Product;

public interface ProductRepository extends ICommonDAO<Product>{
	public List<Product> getProductsBySupplier(String supplierName);
	public Product getProductDetails(String productName);
	public List<Product> getProductsByCategory(String categoryName);
}
