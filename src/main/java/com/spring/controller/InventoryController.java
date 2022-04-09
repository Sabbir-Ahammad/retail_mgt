package com.spring.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.spring.controller.impl.IInventoryController;
import com.spring.model.Inventory;
import com.spring.service.InventoryService;
@RestController
@RequestMapping(value = "inventory")
public class InventoryController implements IInventoryController{
	
	@Autowired
	InventoryService inventoryService;

	@Override
	public ModelAndView create() {
		return null;
	}

	@Override
	public ModelAndView save(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
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
	@RequestMapping(value = "/showinventory", method = RequestMethod.GET)
	public ModelAndView getAll() {
		List<Inventory> inventory = inventoryService.getAll();
		return new ModelAndView("/inventory/showinventory", "in", inventory);
	}

}
