package com.spring.service.impl;

import java.util.List;

import com.spring.common.ICommonService;
import com.spring.model.Product;

public interface IPricingService extends ICommonService<Product>{

	public List<Product> getProductsBySupplierName(String supplierName);
	public List<Product> getAllProducts();
}
