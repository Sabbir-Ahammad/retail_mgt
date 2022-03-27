package com.spring.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.spring.dao.SupplierDAO;
import com.spring.model.Supplier;
import com.spring.service.impl.ISupplierService;

@Service(value = "supplierService")
public class SupplierService implements ISupplierService {

	@Autowired
	SupplierDAO supplierDAO;

	public Supplier save(HttpServletRequest request, @ModelAttribute Supplier supplier) {
		Supplier sup = supplierDAO.save(supplier);
		return null;
	}

	public Supplier getById(int id) {
		return supplierDAO.getByID(id);
	}

	@Override
	public Supplier save(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Supplier edit(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Supplier update(HttpServletRequest request) {
		Supplier sp = new Supplier();
		sp.setId(Integer.valueOf(request.getParameter("id")));
		sp.setSupplierCode(request.getParameter("supplierCode"));
		sp.setSupplierName(request.getParameter("supplierName"));
		sp.setSupplierAddress(request.getParameter("supplierAddress"));
		return supplierDAO.update(sp);
	}

	@Override
	public List<Supplier> getAll() {
		return supplierDAO.getAll();
	}

	public boolean delete(Supplier sup) {
		supplierDAO.delete(sup);
		return true;
	}

	@Override
	public boolean delete(int id) {
		supplierDAO.delete(id);
		return true;
	}

}
