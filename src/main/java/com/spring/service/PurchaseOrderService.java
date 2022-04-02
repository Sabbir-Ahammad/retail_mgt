package com.spring.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.spring.service.impl.IPurchaseOrderService;
@Service(value = "purchaseOrderService")
public class PurchaseOrderService implements IPurchaseOrderService{

	@Override
	public Object save(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object edit(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object update(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
