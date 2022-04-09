package com.spring.service.impl;

import java.util.List;

import org.springframework.web.servlet.ModelAndView;

import com.spring.common.ICommonService;
import com.spring.model.Product;
import com.spring.model.PurchaseDemand;

public interface IPurchaseDemandService extends ICommonService<PurchaseDemand>{
	public PurchaseDemand save(PurchaseDemand p);
	public List<Product> getProductByCategory(String categoryName);
	public List<Product> getProductsOnMultipleCriteria(String data);
	public PurchaseDemand updateStatus(PurchaseDemand p);
}
