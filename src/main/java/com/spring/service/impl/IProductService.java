package com.spring.service.impl;

import java.util.List;

import com.spring.common.ICommonService;
import com.spring.model.Product;

public interface IProductService extends ICommonService<Product>{
	public List<Product> getCategoryBySupplier(String supplierName);
}
