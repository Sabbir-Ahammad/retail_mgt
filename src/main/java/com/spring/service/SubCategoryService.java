package com.spring.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.dao.SubCategoryDAO;
import com.spring.model.Category;
import com.spring.model.SubCategory;
import com.spring.service.impl.ISubCategoryService;

@Service(value = "subCategoryService")
public class SubCategoryService implements ISubCategoryService{

	@Autowired
	SubCategoryDAO subcatdao;
	
	@Override
	public SubCategory save(HttpServletRequest request) {
		String stringPartToDevide = request.getParameter("categorycode");
		String[] stringPart = stringPartToDevide.split("-");
		String stringPart1 = stringPart[0];
		String stringPart2 = stringPart[1];
		SubCategory sc = new SubCategory();
		sc.setCategoryCode(stringPart1);
		sc.setSubCategoryCode(request.getParameter("subcode"));
		sc.setSubCategoryName(request.getParameter("subname"));
		return subcatdao.save(sc);
	}
	
	public SubCategory getSubCategoryByCode(String code) {
		return subcatdao.getSubCategoryByCode(code);
	}

	@Override
	public SubCategory edit(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SubCategory update(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SubCategory> getAll() {
		return subcatdao.getAll();
	}

	@Override
	public boolean delete(String id) {
		// TODO Auto-generated method stub
		return false;
	}

}
