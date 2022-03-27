package com.spring.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.model.Category;

@Repository(value = "categoryDAO")
@Transactional
public class CategoryDAO {

	@Autowired
    private EntityManager entityManager;
    
    private Session getSession() {
        return entityManager.unwrap(Session.class);
    }


    public Category save(Category c){
    	getSession().save(c);
    	getSession().flush();
        return c;
    }
    

    public List<Category> getAll(){
    	String sql = "from category";
        List<Category> categorys = getSession().createQuery(sql).list();
		/*
		 * for (int i = 0; i < categorys.size(); i++) {
		 * System.out.println(categorys.get(i).getName()); }
		 */
        return categorys;
    }

    public Category getCategoryByCode(String code) {
        String sql = "from category where code = '" + code + "'";
        List<Category> cList = getSession().createQuery(sql).list();
        return cList.get(0);

    }
    
    public Category getCategoryByName(String name) {
        String sql = "from category where name = '" + name + "'";
        List<Category> cList = getSession().createQuery(sql).list();
        return cList.get(0);

    }

    public Category update(Category c) {
        String hql = "update category set name = '"+c.getName()+"', description = '"+c.getDescription()+"'  where code = '"+c.getCode()+"'";
        Query q = getSession().createQuery(hql);
        q.executeUpdate();
        getSession().flush();
		/*
		 * getSession().update(c); getSession().flush();
		 */
        return c;
    }


    public Category delete(Category c) {
    	String sql = "delete category where code = '"+c.getCode()+"'";
        int delete = getSession().createQuery(sql).executeUpdate();
		/* getSession().delete(c); */
        return c;
    }
}
