package com.spring.service;

import com.spring.dao.ProductDAO;
import com.spring.model.Product;
import com.spring.model.SubCategory;

import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.model.Product;


@Service(value = "productService")
public class ProductService{

	@Autowired
    ProductDAO productDAO;
	
	public SubCategory getValue(HttpServletRequest request) {
		String stringPartToDevide = request.getParameter("categorycode");
		String[] stringPart = stringPartToDevide.split("-");
		String stringPart1 = stringPart[0];
		String stringPart2 = stringPart[1];
		return null;
	}

    
    public Product save(HttpServletRequest request){
        //Map<String, String[]> map = request.getParameterMap();
        String name = request.getParameter("name");
        Product p = new Product();
        p.setName(name);
        p.setQuantity(Integer.valueOf(request.getParameter("qty")));
        p.setPrice(Double.valueOf(request.getParameter("price")));
        return productDAO.save(p);
    }

    public List<Product> getAll() {
        return productDAO.getAll();
    }

    public Product getProductById(int pid) {
        return productDAO.getProductById(pid);
    }

    public Product update(HttpServletRequest request) {
        String name = request.getParameter("name");
        Product p = new Product();
        p.setId(Integer.valueOf(request.getParameter("id")));
        p.setName(name);
        p.setQuantity(Integer.valueOf(request.getParameter("qty")));
        p.setPrice(Double.valueOf(request.getParameter("price")));
        return productDAO.update(p);
    }

    public Product delete(int pid) {
        Product p = productDAO.getProductById(pid);
        return productDAO.delete(p);
    }
	
}
