package com.spring.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.dao.impl.CustomerRepository;
import com.spring.model.Customer;
import com.spring.model.Product;
import com.spring.model.Supplier;
@Repository(value = "customerDAO")
@Transactional
public class CustomerDAO implements CustomerRepository{
	
	@Autowired
    private EntityManager entityManager;
    
    private Session getSession() {
        return entityManager.unwrap(Session.class);
    }
	
	@Override
	public Customer save(Customer t) {
		getSession().save(t);
    	getSession().flush();
        return t;
	}

	@Override
	public List<Customer> getAll() {
		String hql = "from customer";
		List<Customer> customers= getSession().createQuery(hql).list();
		return customers;
	}

	@Override
	public Customer getByID(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer delete(Customer t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer update(Customer t) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Customer getCustomerByCode(String code) {
        String sql = "from customer where customerCode = '" + code + "'";
        List<Customer> empList = getSession().createQuery(sql).list();
        return empList.get(0);

    }

}
