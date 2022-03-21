package com.spring.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.dao.CategoryDAO;
import com.spring.model.Category;
import com.spring.model.Product;
import com.spring.service.impl.ICategoryService;

@Service(value = "categoryService")
public class CategoryService implements ICategoryService{

	@Autowired
	CategoryDAO categoryDAO;

	@Override
	public Category save(HttpServletRequest request) {
		//Map<String, String[]> map = request.getParameterMap();
		/* String name = request.getParameter("name"); */
        Category c = new Category();
        c.setName(request.getParameter("name"));
        c.setDescription(request.getParameter("description"));
        c.setCode(request.getParameter("code"));
        return categoryDAO.save(c);
	}
	
	public Category getCategoryByCode(String code) {
		return categoryDAO.getCategoryByCode(code);
	}

	@Override
	public Category edit(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Category update(HttpServletRequest request) {
		Category c = new Category();
		c.setCode(request.getParameter("code"));
		c.setName(request.getParameter("name"));
		c.setDescription(request.getParameter("description"));
		return categoryDAO.update(c);
	}

	@Override
	public List<Category> getAll() {
		return categoryDAO.getAll();
	}

	@Override
	public boolean delete(String id) {
		Category c = categoryDAO.getCategoryByCode(id);
		categoryDAO.delete(c);
		return true;
	}
	
}
