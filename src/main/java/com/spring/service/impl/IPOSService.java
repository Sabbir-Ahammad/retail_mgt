package com.spring.service.impl;

import java.util.List;

import com.spring.common.ICommonService;
import com.spring.model.POSSales;
import com.spring.model.Product;

public interface IPOSService extends ICommonService<POSSales>{
	List<Product> getAllProducts();
}
