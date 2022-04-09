package com.spring.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.dao.impl.PurchaseDemandRepository;
import com.spring.model.PurchaseDemand;
import com.spring.model.Supplier;
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
		String sql = "from purchaseDemand where status = '"+ "Demanded" +"'";
		List<PurchaseDemand> demands = getSession().createQuery(sql).list();
		return demands;
	}
	
	public List<PurchaseDemand> getAllReceived() {
		String sql = "from purchaseDemand where status = '"+ "Received" +"'";
		List<PurchaseDemand> demands = getSession().createQuery(sql).list();
		return demands;
	}

	@Override
	public PurchaseDemand getByID(int id) {
		String hql = "from purchaseDemand where id = '" + id + "'";
        List<PurchaseDemand> pd = getSession().createQuery(hql).list(); 
        return pd.get(0);
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

	@Override
	public PurchaseDemand updateStatus(PurchaseDemand p) {
		String hql = "update purchaseDemand set status = 'Received', receivedDate = '"+ p.getReceivedDate() +"' where id = '" + p.getId() + "'";
		Query q = getSession().createQuery(hql);
		q.executeUpdate();
		getSession().flush();
		return p;
	}

}
