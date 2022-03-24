package com.spring.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.codec.multipart.Part;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.spring.common.FileSaveUtil;
import com.spring.controller.impl.IProductController;
import com.spring.dao.CategoryDAO;
import com.spring.dao.SubCategoryDAO;
import com.spring.model.Category;
import com.spring.model.Product;
import com.spring.model.SubCategory;
import com.spring.service.ProductService;

@RestController
@RequestMapping(value = "product")
@MultipartConfig(
		  fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
		  maxFileSize = 1024 * 1024 * 10,      // 10 MB
		  maxRequestSize = 1024 * 1024 * 100   // 100 MB
		)
public class ProductController {

	@Autowired
	CategoryDAO catdao;

	@Autowired
	SubCategoryDAO subCategoryDAO;
	
	@Autowired
	ProductService productService;

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView create() {
		List<Category> categorys = catdao.getAll();
		return new ModelAndView("product/create", "categorys", categorys);
	}
	
	@RequestMapping(value = "/searchSubcat/{category}", method = RequestMethod.POST)
	public List<SubCategory> getValue(HttpServletRequest request, @PathVariable("category") String category) {
		List<SubCategory> subcat = productService.getSubCatValue(category);
		return subCategoryDAO.getAll(category);
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView save(HttpServletRequest request, @RequestParam("image") MultipartFile file) {
//        Product p = productService.save(request);
		String image = file.getOriginalFilename().toString();
		try {
			
			File saveFile = new File(FileSaveUtil.fileLocation(), image);
			InputStream imageFile = file.getInputStream();
			Files.copy(imageFile, saveFile.toPath());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("file name : " + image);
		
//		Map<String, String[]> map = request.getParameterMap();
//		Set<String> key = map.keySet();
//		for (int i = 0; i < map.size(); i++) {
//			for (String k : key) {
//				System.out.println("... " + k + "   " + request.getParameter(k));
//			}
//
//		}

		return new ModelAndView("product/create");
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public ModelAndView edit(@PathVariable String id) {
		int pid = Integer.valueOf(id);
		Product p = productService.getProductById(pid);
		return new ModelAndView("product/edit", "p", p);
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ModelAndView update(HttpServletRequest request) {
		Product p = productService.update(request);
		return new ModelAndView("product/show");
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public ModelAndView delete(@PathVariable String id) {
		int pid = Integer.valueOf(id);
		Product p = productService.delete(pid);
		return new ModelAndView("product/edit", "p", p);
	}

	@RequestMapping(value = "/show", method = RequestMethod.GET)
	public ModelAndView view() {
		List<Product> products = productService.getAll();
		return new ModelAndView("product/show", "products", products);
	}

	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public Object view1() {
		List<Product> products = productService.getAll();
		Gson g = new Gson();
		return g.toJson(products.get(0));
	}

}
