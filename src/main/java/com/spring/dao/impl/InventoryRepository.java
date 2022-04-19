package com.spring.dao.impl;

import com.spring.common.ICommonDAO;
import com.spring.model.Inventory;
import com.spring.model.Product;

public interface InventoryRepository extends ICommonDAO<Inventory>{
	public Inventory updateSellingprice(Product p);
	public Inventory updateSold(Inventory i);
}
