package com.spring.service;

import com.spring.common.FileSaveUtil;
import com.spring.dao.CategoryDAO;
import com.spring.dao.ProductDAO;
import com.spring.dao.SubCategoryDAO;
import com.spring.dao.SupplierDAO;
import com.spring.model.Category;
import com.spring.model.Product;
import com.spring.model.SubCategory;
import com.spring.model.Supplier;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.spring.model.Product;


@Service(value = "productService")
public class ProductService{

	@Autowired
    ProductDAO productDAO;
	@Autowired
	SubCategoryDAO subCategoryDAO;
	@Autowired
	CategoryDAO categoryDAO;
	@Autowired
	SupplierDAO supplierDAO;
	
	public List<Category> getAllCategory() {
		return categoryDAO.getAll();
	}
	public List<Supplier> getAllSupplier(){
		return supplierDAO.getAll();
	}
	
	public List<SubCategory> getSubCatValue(String category) {
		return subCategoryDAO.getAll(category);
	}
	public String getCatCode(String name) {
		return categoryDAO.getCategoryByName(name).getCode();
	}

    
	public Product save(HttpServletRequest request, MultipartFile file){
		String cCode = request.getParameter("category");
		String cName = categoryDAO.getCategoryByCode(cCode).getName();
        Product p = new Product();
        p.setProductCode(request.getParameter("productCode"));
        p.setProductName(request.getParameter("productName"));
        p.setCategoryName(cName);
        p.setSubCategoryName(request.getParameter("subcategory"));
        p.setSupplierName(request.getParameter("supplier"));
        p.setProductImage(file.getOriginalFilename());
        upload(file);
        return productDAO.save(p);
    }

	//	write file to local disk
	public MultipartFile upload(MultipartFile file) {
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
		return null;
	}
	
    public List<Product> getAll() {
        return productDAO.getAll();
    }

    public Product getProductById(int pid) {
        return productDAO.getProductById(pid);
    }

    public Product update(Product p) {
        return productDAO.update(p);
    }
    
    public Product updatepricing(Product p) {
    	return productDAO.updatePricing(p);
    }

    public Product delete(int pid) {
        Product p = productDAO.getProductById(pid);
        return productDAO.delete(p);
    }
	
    List<Product> getProductsBySupplier(String supplierName){
    	return productDAO.getProductsBySupplier(supplierName);
    }
    
    Product getProductsDetails(String productName){
    	return productDAO.getProductDetails(productName);
    }
}
