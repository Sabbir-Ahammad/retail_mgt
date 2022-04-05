package com.spring.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.dao.impl.ProductRepository;
import com.spring.model.Product;
import com.spring.model.SubCategory;

@Repository(value = "productDAO")
@Transactional
public class ProductDAO implements ProductRepository{

    @Autowired
    private EntityManager entityManager;
    
    private Session getSession() {
        return entityManager.unwrap(Session.class);
    }


    public Product save(Product p){
    	getSession().save(p);
    	getSession().flush();
        return p;
    }
    

    public List<Product> getAll(){
    	String sql = "from product";
        List<Product> products = getSession().createQuery(sql).list();
        return products;
    }

    public Product getProductById(int id) {
        String sql = "from product where id = '" + id + "'";
        List<Product> empList = getSession().createQuery(sql).list();
        return empList.get(0);

    }

    public Product update(Product p) {
        getSession().update(p);
        getSession().flush();
        return p;
    }

    public Product updatePricing(Product p) {
    	String hql = "update product set unit_cost = '"+p.getUnitCost()+"',tax_rate = '"+p.getTaxRate()
    	+"', discount = '"+p.getDiscount()+"', discount = '"+p.getDiscount()+"', profit_margin = '"+p.getProfitMargin()+"',selling_price = '"+p.getSellingPrice()+"' where id = '"+p.getId()+"'";
        Query q = getSession().createQuery(hql);
        q.executeUpdate();
        getSession().flush();
		/* String sql = "select * from subcategory"; */
		/*
		 * NativeQuery<SubCategory> q = getSession().createNativeQuery(sql,
		 * SubCategory.class); List<SubCategory> scat = q.getResultList();
		 */
    	return p;
    }

    public Product delete(Product p) {
    	getSession().delete(p);
    	getSession().flush();
		/*
		 * String sql = "delete product where id = '"+p+"'"; int delete =
		 * getSession().createQuery(sql).executeUpdate();
		 */
        return p;
    }


	@Override
	public Product getByID(int id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Product> getProductsBySupplier(String supplierName) {
		String sql = "from product where supplier_name = '" + supplierName + "'";
        List<Product> products = getSession().createQuery(sql).list();
		return products;
	}


	@Override
	public Product getProductDetails(String productName) {
		String sql = "from product where product_name = '" + productName + "'";
        List<Product> productList = getSession().createQuery(sql).list();
        return productList.get(0);
	}


	@Override
	public List<Product> getProductsByCategory(String categoryName) {
		String sql = "from product where category_name = '" + categoryName + "'";
        List<Product> products = getSession().createQuery(sql).list();
		return products;
	}

	
	
}
