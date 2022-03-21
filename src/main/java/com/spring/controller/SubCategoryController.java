package com.spring.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.spring.controller.impl.ISubCategoryController;
import com.spring.dao.CategoryDAO;
import com.spring.dao.SubCategoryDAO;
import com.spring.model.Category;
import com.spring.model.SubCategory;
import com.spring.service.CategoryService;
import com.spring.service.SubCategoryService;

@RestController
@RequestMapping(value = "subcategory")
public class SubCategoryController implements ISubCategoryController{

	@Autowired
	CategoryDAO catdao;
	
	@Autowired
	SubCategoryService subCatService;
	
	@Override
	@RequestMapping(value = "/create")
	public ModelAndView create() {
		List<Category> categorys = catdao.getAll();
		return new ModelAndView("subcategory/create", "categorys", categorys);
	}

	@Override
	@RequestMapping(value = "/save")
	public ModelAndView save(HttpServletRequest request) {
		SubCategory sc = subCatService.save(request);
		return new ModelAndView("subcategory/create", "sc", sc);
	}

	@Override
	@RequestMapping(value = "/edit/{code}", method = RequestMethod.GET)
	public ModelAndView edit(@PathVariable String code) {
		String cCode = code;
		SubCategory sc = subCatService.getSubCategoryByCode(cCode);
		List<Category> categorys = catdao.getAll();
		Map data = new HashMap();
		data.put("subCategory", sc);
		data.put("category", categorys);
		return new ModelAndView("/subcategory/edit", "data", data);
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
	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public ModelAndView getAll() {
		List<SubCategory> subCategory = subCatService.getAll();
		return new ModelAndView("subcategory/view", "subCategory", subCategory);
	}

}
