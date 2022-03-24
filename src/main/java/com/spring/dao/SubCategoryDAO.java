package com.spring.dao;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.dao.impl.SubCategoryRepository;
import com.spring.model.Category;
import com.spring.model.SubCategory;

@Repository(value = "subCategoryDAO")
@Transactional
public class SubCategoryDAO implements SubCategoryRepository {

	@Autowired
	private EntityManager entityManager;

	private Session getSession() {
		return entityManager.unwrap(Session.class);
	}

	public SubCategory save(SubCategory c) {
		getSession().save(c);
		getSession().flush();
		return c;
	}

	/*
	 * public List<SubCategory> getAll() { String sql =
	 * "SELECT subcategory.sub_category_code, subcategory.sub_category_name, subcategory.category_code, category.name "
	 * +
	 * "FROM subcategory RIGHT JOIN category WITH subcategory.category_code=category.code"
	 * ;
	 * 
	 * String sql =
	 * "SELECT subcategory.sub_category_code, subcategory.sub_category_name, subcategory.category_code, category.name\r\n"
	 * +
	 * "FROM subcategory RIGHT JOIN category ON subcategory.category_code=category.code"
	 * ;
	 * 
	 * List<SubCategory> subCategorys = getSession().createQuery(sql).list();
	 * List<SubCategory> subCategorys = getSession().createSQLQuery(sql).list(); for
	 * (int i = 0; i < subCategorys.size(); i++) {
	 * System.out.println(subCategorys.get(i).getSubCategoryCode()); } return
	 * subCategorys; }
	 */

	public List<SubCategory> getAll() {
		//String sql = "from subcategory";
		//List<SubCategory> subCategorys = getSession().createQuery(sql).list();
		String sql = "select * from subcategory";
	    NativeQuery<SubCategory> q = getSession().createNativeQuery(sql, SubCategory.class);
	    List<SubCategory> scat = q.getResultList();
//		  for (int i = 0; i < scat.size(); i++) {
//		  System.out.println(scat.get(i).getCategoryName() + " ..............."); 
//		  }
//		
		return scat;
	}

	public SubCategory getSubCategoryByCode(String code) {
		String sql = "from subcategory where sub_category_code = '" + code + "'";
		List<SubCategory> cList = getSession().createQuery(sql).list();
		return cList.get(0);

	}

	public SubCategory update(SubCategory c) {

		String hql = "update subcategory set sub_category_name = '" + c.getSubCategoryName() + "', category_code = '"
				+ c.getCategoryCode() + "' where sub_category_code = '" + c.getSubCategoryCode() + "'";
		Query q = getSession().createQuery(hql);
		q.executeUpdate();
		/* getSession().update(c); */
		getSession().flush();
		return c;
	}

	public SubCategory delete(SubCategory c) {
		String sql = "delete subcategory where sub_category_code = '" + c.getSubCategoryCode() + "'";
		int delete = getSession().createQuery(sql).executeUpdate();
		return c;
	}
	
	public List<SubCategory> getAll(String catCode) {
		String sql = "from subcategory where category_code = '" + catCode + "'";
		List<SubCategory> cList = getSession().createQuery(sql).list();
		return cList;
	}
}
