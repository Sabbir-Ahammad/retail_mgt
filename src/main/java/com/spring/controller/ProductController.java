package com.spring.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.codec.multipart.Part;
import org.springframework.web.bind.annotation.ModelAttribute;
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
import com.spring.model.Supplier;
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
	ProductService productService;

//	Get Categories and suppliers
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView create() {
		List<Category> categorys = productService.getAllCategory();
		List<Supplier> suppliers = productService.getAllSupplier();
		Map data = new HashMap();
		data.put("categories", categorys);
		data.put("suppliers", suppliers);
		return new ModelAndView("product/create", "data", data);
	}
	
//	search subcategory through category
	@RequestMapping(value = "/searchSubcat/{category}", method = RequestMethod.POST)
	public List<SubCategory> getValue(HttpServletRequest request, @PathVariable("category") String category) {
		return productService.getSubCatValue(category);
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView save(HttpServletRequest request, @RequestParam("image") MultipartFile file) {
        Product p = productService.save(request, file);
		return new ModelAndView("product/create");
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public ModelAndView edit(@PathVariable String id) {
		int pid = Integer.valueOf(id);
		Product product = productService.getProductById(pid);
		String catCode = productService.getCatCode(product.getCategoryName());
		List<Category> categorys = productService.getAllCategory();
		List<Supplier> suppliers = productService.getAllSupplier();
		Map data = new HashMap();
		data.put("categories", categorys);
		data.put("suppliers", suppliers);
		data.put("product", product);
		data.put("catCode", catCode);
		data.put("imgLocation", FileSaveUtil.fileLocation());
		return new ModelAndView("product/edit", "data", data);
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ModelAndView update(HttpServletRequest request, @ModelAttribute Product product) {
		Product p = productService.update(product);
		List<Product> products = productService.getAll();
		return new ModelAndView("product/view", "products", products);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public ModelAndView delete(@PathVariable String id) {
		int pid = Integer.valueOf(id);
		Product p = productService.delete(pid);
		List<Product> products = productService.getAll();
		return new ModelAndView("product/view", "products", products);
	}

	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public ModelAndView view() {
		List<Product> products = productService.getAll();
		return new ModelAndView("product/view", "products", products);
	}

//	@RequestMapping(value = "/view", method = RequestMethod.GET)
//	public Object view1() {
//		List<Product> products = productService.getAll();
//		Gson g = new Gson();
//		return g.toJson(products.get(0));
//	}

}
