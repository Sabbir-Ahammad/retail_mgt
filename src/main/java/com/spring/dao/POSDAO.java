package com.spring.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.dao.impl.POSRepository;
import com.spring.model.Customer;
import com.spring.model.POSSales;
import com.spring.model.Product;
@Repository(value = "posDAO")
@Transactional
public class POSDAO implements POSRepository{
	
	@Autowired
	private EntityManager entityManager;

	private Session getSession() {
		return entityManager.unwrap(Session.class);
	}

	@Override
	public POSSales save(POSSales t) {
		getSession().save(t);
		getSession().flush();
		return t;
	}

	@Override
	public List<POSSales> getAll() {
		String hql = "from posSales";
		List<POSSales> posSales= getSession().createQuery(hql).list();
		return posSales;
	}

	@Override
	public POSSales getByID(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public POSSales delete(POSSales t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public POSSales update(POSSales t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getTransactionId() {
		String hql = "from posSales order by transactionCode DESC";
        List<POSSales> posSale = getSession().createQuery(hql).list();
        int a = posSale.get(0).getTransactionCode();
		return a;
	}

}
