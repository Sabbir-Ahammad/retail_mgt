package com.spring.service.impl;

import com.spring.common.ICommonService;
import com.spring.model.Inventory;
import com.spring.model.Product;

public interface IInventoryService extends ICommonService<Inventory>{
	public Product updateSellingPrice(Product p);
}
