package com.spring.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.dao.CategoryDAO;
import com.spring.dao.SubCategoryDAO;
import com.spring.model.Category;
import com.spring.model.SubCategory;
import com.spring.service.impl.ISubCategoryService;

@Service(value = "subCategoryService")
public class SubCategoryService implements ISubCategoryService {

	@Autowired
	CategoryDAO catdao;

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
	public SubCategory edit(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SubCategory update(HttpServletRequest request) {
		SubCategory sc = new SubCategory();
		sc.setCategoryCode(request.getParameter("categorycode"));
		sc.setSubCategoryCode(request.getParameter("scatcode"));
		sc.setSubCategoryName(request.getParameter("scatname"));
		/*
		 * System.out.println(sc.getCategoryCode() + "" + sc.getSubCategoryCode()+ ""
		 * +sc.getSubCategoryName());
		 */
		return subcatdao.update(sc);
	}

	@Override
	public List<SubCategory> getAll() {
		List<SubCategory> subCategory = subcatdao.getAll();
		List<Category> categorys = catdao.getAll();
		/* Get Category name from category through category code */

		for (int i = 0; i < subCategory.size(); i++) {
			for (int j = 0; j < categorys.size(); j++) {
				if (categorys.get(j).getCode().equals(subCategory.get(i).getCategoryCode())) {
					subCategory.get(i).setCategoryName(categorys.get(j).getName());
				}
			}
		}

		return subCategory;
	}

	
	public boolean delete(String id) {
		SubCategory sc = new SubCategory();
		sc = subcatdao.delete(sc);
		return true;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}
	
	List<SubCategory> getAllByCatCode(String catCode){
		return subcatdao.getAllByCatCode(catCode);
	}
}
