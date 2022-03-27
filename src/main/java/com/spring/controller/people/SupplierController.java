package com.spring.controller.people;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.spring.controller.impl.ISupplierController;
import com.spring.model.Category;
import com.spring.model.Supplier;
import com.spring.service.SupplierService;

@RestController
@RequestMapping(value = "supplier/")
public class SupplierController implements ISupplierController{
	
	@Autowired
	SupplierService supplierService;

	
	@RequestMapping(value = "create", method = RequestMethod.GET)
	public ModelAndView create() {
		return new ModelAndView("/people/supplier/create");
	}

	
	@RequestMapping(value = "save", method = RequestMethod.POST)
	public ModelAndView save(HttpServletRequest request, @ModelAttribute Supplier supplier) {
		Supplier sc = supplierService.save(request, supplier);
		List<Supplier> suppliers = supplierService.getAll();
		return new ModelAndView("/people/supplier/view", "suppliers", suppliers);
	}
	
	@RequestMapping(value = "edit/{id}", method = RequestMethod.GET)
	public ModelAndView edit(@PathVariable int id) {
		Supplier supplier = supplierService.getById(id);
		return new ModelAndView("/people/supplier/edit", "supplier", supplier);
	}
	
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public ModelAndView update(HttpServletRequest request) {
        Supplier s = supplierService.update(request);
        List<Supplier> suppliers = supplierService.getAll();
        return new ModelAndView("/people/supplier/view", "suppliers", suppliers);
	}
	
	public ModelAndView edit(@ModelAttribute Supplier s) {
		// TODO Auto-generated method stub
		return null;
	}

	@RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
	public ModelAndView delete(@PathVariable int id) {
		int supId = id;
		boolean status = supplierService.delete(supId);
		List<Supplier> suppliers = supplierService.getAll();
		return new ModelAndView("/people/supplier/view", "suppliers", suppliers);
	}

	@RequestMapping(value = "view", method = RequestMethod.GET)
	public ModelAndView getAll() {
		List<Supplier> suppliers = supplierService.getAll();
		return new ModelAndView("/people/supplier/view", "suppliers", suppliers);
	}
	
}
