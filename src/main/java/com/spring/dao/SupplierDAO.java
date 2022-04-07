package com.spring.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.dao.impl.SupplierRepository;
import com.spring.model.Supplier;

@Repository(value = "supplierDAO")
@Transactional
public class SupplierDAO implements SupplierRepository{

	@Autowired
	private EntityManager entityManager;
	private Session getSession() {
		return entityManager.unwrap(Session.class);
	}
	
	@Override
	public Supplier save(Supplier t) {
		getSession().save(t);
		getSession().flush();
		return t;
	}

	@Override
	public List<Supplier> getAll() {
		String hql = "from supplier";
		List<Supplier> suppliers= getSession().createQuery(hql).list();
		return suppliers;
	}

	@Override
	public Supplier getByID(int id) {
		String hql = "from supplier where id = '" + id + "'";
        List<Supplier> suppliers = getSession().createQuery(hql).list(); 
        return suppliers.get(0);
	}
	
	public Supplier getSupplierByCode(String code) {
		String hql = "from supplier where supplier_code = '" + code + "'";
        List<Supplier> suppliers = getSession().createQuery(hql).list(); 
        return suppliers.get(0);
	}

	public Supplier delete(int id) {
		String hql = "delete supplier where id = '" + id + "'";
		int delete = getSession().createQuery(hql).executeUpdate();
		return null;
	}
	@Override
	public Supplier delete(Supplier t) {
		getSession().delete(t);
		getSession().flush();
		return t;
	}

	@Override
	public Supplier update(Supplier t) {
		getSession().update(t);
		getSession().flush();
		return t;
	}

}
