package com.spring.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.dao.CustomerDAO;
import com.spring.model.Customer;
import com.spring.service.impl.ICustomerService;
@Service(value = "customerService")
public class CustomerService implements ICustomerService{

	@Autowired
	CustomerDAO customerDAO;
	
	@Override
	public Customer save(HttpServletRequest request) {
		Customer customer = new Customer();
		customer.setCustomerCode(request.getParameter("customerCode"));
		customer.setCustomerName(request.getParameter("customerName"));
		customer.setCustomerContract(request.getParameter("customerContract"));
		customer.setCustomerAdderss(request.getParameter("customerAddress"));
		return customerDAO.save(customer);
	}

	@Override
	public Customer edit(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer update(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Customer> getAll() {
		List<Customer> customers= customerDAO.getAll();
		return customers;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
