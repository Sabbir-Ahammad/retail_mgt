package com.spring.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.spring.controller.impl.ICategoryController;
import com.spring.model.Category;
import com.spring.model.Product;
import com.spring.service.CategoryService;
import com.spring.service.ProductService;

@RestController
@RequestMapping(value = "category")
public class CategoryController implements ICategoryController{
	
	@Autowired
    CategoryService categoryService;

	@Override
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView create() {
		return new ModelAndView("category/create");
	}

	@Override
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView save(HttpServletRequest request) {
		Category c = categoryService.save(request);
        return new ModelAndView("category/create");
	}

	
	@Override
	@RequestMapping(value = "/edit/{code}", method = RequestMethod.GET)
	public ModelAndView edit(@PathVariable String code) {
		String cCode = code;
		Category c = categoryService.getCategoryByCode(cCode);
		return new ModelAndView("category/edit", "c", c);
	}

	@Override
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ModelAndView update(HttpServletRequest request) {
        Category c = categoryService.update(request);
        return new ModelAndView("category/view");
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	@Override
	public ModelAndView delete(@PathVariable String id) {
		String cCode = id;
		boolean status = categoryService.delete(id);
		List<Category> categories = categoryService.getAll();
		return new ModelAndView("category/view", "categories", categories);
	}

	@RequestMapping(value = "/view", method = RequestMethod.GET)
	@Override
	public ModelAndView getAll() {
		List<Category> categories = categoryService.getAll();
		return new ModelAndView("category/view", "categories", categories);
	}
	
}
