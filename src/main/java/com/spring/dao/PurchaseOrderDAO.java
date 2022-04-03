package com.spring.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.dao.impl.PurchaseOrderRepository;
import com.spring.model.PurchaseOrder;
@Repository(value = "purchaseOrderDAO")
@Transactional
public class PurchaseOrderDAO implements PurchaseOrderRepository{
	
	@Autowired
    private EntityManager entityManager;
    
    private Session getSession() {
        return entityManager.unwrap(Session.class);
    }

	@Override
	public PurchaseOrder save(PurchaseOrder t) {
		
		getSession().save(t);
		return null;
	}

	@Override
	public List<PurchaseOrder> getAll() {
		
		return null;
	}

	@Override
	public PurchaseOrder getByID(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PurchaseOrder delete(PurchaseOrder t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PurchaseOrder update(PurchaseOrder t) {
		// TODO Auto-generated method stub
		return null;
	}

}
