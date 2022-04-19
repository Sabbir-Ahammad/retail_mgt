package com.spring.controller.people;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.spring.controller.impl.ICustomerController;
import com.spring.model.Customer;
import com.spring.service.CustomerService;

@RestController
@RequestMapping(value = "customer")
public class CustomerController implements ICustomerController{

	@Autowired
	CustomerService customerService;
	
	@Override
	@RequestMapping(value = "/addCustomer", method = RequestMethod.GET)
	public ModelAndView create() {
		// TODO Auto-generated method stub
		return new ModelAndView("/people/customer/addcustomer");
	}

	@Override
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView save(HttpServletRequest request) {
		// TODO Auto-generated method stub
		customerService.save(request);
		List<Customer> customers= customerService.getAll();
		return new ModelAndView("redirect:/customer/getAllCustomer", "customers", customers);
	}

	@Override
	public ModelAndView edit(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ModelAndView update(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ModelAndView delete(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@RequestMapping(value = "/getAllCustomer", method = RequestMethod.GET)
	public ModelAndView getAll() {
		List<Customer> customers= customerService.getAll();
		return new ModelAndView("people/customer/allcustomers", "customers", customers);
	}

}
