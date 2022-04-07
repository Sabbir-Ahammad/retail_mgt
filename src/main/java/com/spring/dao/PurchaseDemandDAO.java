package com.spring.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.dao.impl.PurchaseDemandRepository;
import com.spring.model.PurchaseDemand;
@Repository(value = "purchaseDemandDAO")
@Transactional
public class PurchaseDemandDAO implements PurchaseDemandRepository{
	
	@Autowired
    private EntityManager entityManager;
    
    private Session getSession() {
        return entityManager.unwrap(Session.class);
    }

	@Override
	public PurchaseDemand save(PurchaseDemand t) {
		getSession().save(t);
    	getSession().flush();
		return null;
	}

	@Override
	public List<PurchaseDemand> getAll() {
		String sql = "from purchase_demand";
		List<PurchaseDemand> demands = getSession().createQuery(sql).list();
		return demands;
	}

	@Override
	public PurchaseDemand getByID(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PurchaseDemand delete(PurchaseDemand t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PurchaseDemand update(PurchaseDemand t) {
		// TODO Auto-generated method stub
		return null;
	}

}
