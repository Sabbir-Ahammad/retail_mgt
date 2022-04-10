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
	CategoryService categoryService;
	@Autowired
	SupplierService supplierService;
	@Autowired
	SubCategoryService subCategoryService;
	
	public List<Category> getAllCategory() {
		return categoryService.getAll();
	}
	public List<Supplier> getAllSupplier(){
		return supplierService.getAll();
	}
	
	public List<SubCategory> getSubCatValueByCat(String category) {
		return subCategoryService.getAllByCatCode(category);
	}
	public String getCatCode(String name) {
		return categoryService.getCategoryByName(name).getCode();
	}

    
	public Product save(HttpServletRequest request, MultipartFile file){
		Product p = new Product();
		String cCode = request.getParameter("category");
		String sCode = request.getParameter("subcategory");
		String cName = categoryService.getCategoryByCode(cCode).getName();
		String scName = subCategoryService.getSubCategoryByCode(sCode).getSubCategoryName();
		String supName = supplierService.getSupplierByCode(request.getParameter("supplier")).getSupplierName();
        p.setCategoryCode(cCode);
        p.setCategoryName(cName);
        p.setSubCategoryCode(sCode);
        p.setSubCategoryName(scName);
        p.setProductCode(request.getParameter("productCode"));
        p.setProductName(request.getParameter("productName"));
        p.setSupplierCode(request.getParameter("supplier"));
        p.setSupplierName(supName);
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
    
    public Product getProductDetailsByCode(String code) {
        return productDAO.getProductDetailsByCode(code);
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
    
    List<Product> getProductsByCategory(String categoryName){
    	return productDAO.getProductsByCategory(categoryName);
    }
    
    Product getProductsDetails(String productName){
    	return productDAO.getProductDetails(productName);
    }
}
