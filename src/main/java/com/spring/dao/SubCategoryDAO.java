package com.spring.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.dao.impl.SubCategoryRepository;
import com.spring.model.Category;
import com.spring.model.SubCategory;

@Repository(value = "subCategoryDAO")
@Transactional
public class SubCategoryDAO implements SubCategoryRepository{

	@Autowired
    private EntityManager entityManager;
    
    private Session getSession() {
        return entityManager.unwrap(Session.class);
    }


    public SubCategory save(SubCategory c){
    	getSession().save(c);
    	getSession().flush();
        return c;
    }
    

    public List<SubCategory> getAll(){
    	String sql = "from subcategory";
        List<SubCategory> subCategorys = getSession().createQuery(sql).list();
        return subCategorys;
    }

    public SubCategory getSubCategoryByCode(String code) {
        String sql = "from subcategory where sub_category_code = '" + code + "'";
        List<SubCategory> cList = getSession().createQuery(sql).list();
        return cList.get(0);

    }

    public SubCategory update(SubCategory c) {
		
		 String hql = "update subcategory set sub_category_name = '"+c.getSubCategoryName()+"', category_code = '"+c.getCategoryCode()+"' where sub_category_code = '"+c.getSubCategoryCode()+"'"; 
		 Query q = getSession().createQuery(hql); q.executeUpdate();
		/* getSession().update(c); */
        getSession().flush();
        return c;
    }


    public SubCategory delete(SubCategory c) {
    	String sql = "delete subcategory where sub_category_code = '"+c.getSubCategoryCode()+"'";
        int delete = getSession().createQuery(sql).executeUpdate();
        return c;
    }
}
