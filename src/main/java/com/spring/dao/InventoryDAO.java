package com.spring.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.dao.impl.InventoryRepository;
import com.spring.model.Category;
import com.spring.model.Inventory;
@Repository(value = "inventoryDAO")
@Transactional
public class InventoryDAO implements InventoryRepository{
	
	@Autowired
    private EntityManager entityManager;
    
    private Session getSession() {
        return entityManager.unwrap(Session.class);
    }

	@Override
	public Inventory save(Inventory t) {
		getSession().save(t);
    	getSession().flush();
		return null;
	}

	@Override
	public List<Inventory> getAll() {
		String sql = "from inventory";
        List<Inventory> inventory = getSession().createQuery(sql).list();
        return inventory;
	}

	@Override
	public Inventory getByID(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Inventory delete(Inventory t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Inventory update(Inventory t) {
		String hql = "update inventory set average_price = '"+t.getAveragePrice()+"',average_discount = '"+t.getAverageDiscount()
    	+"', average_tax = '"+t.getAverageTax()+"', stored_amount = '"+t.getStoredAmount()+"' where product_code = '"+t.getProductCode()+"'";
        Query q = getSession().createQuery(hql);
        q.executeUpdate();
        getSession().flush();
		return t;
	}
	
	public Inventory getByProductCode(String code) {
		String sql = "from inventory where productCode = '" + code + "'";
        List<Inventory> cList = getSession().createQuery(sql).list();
        return cList.get(0);
	}

}
