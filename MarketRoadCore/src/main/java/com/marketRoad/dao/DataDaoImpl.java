package com.marketRoad.dao;

import java.util.List;



import org.hibernate.Query;
import org.hibernate.Session;  
import org.hibernate.SessionFactory;  
import org.hibernate.Transaction;  
import org.springframework.beans.factory.annotation.Autowired;  

import com.marketRoad.model.Category;
import com.marketRoad.model.Customer;
import com.marketRoad.model.CustomerProfileInfo;

public class DataDaoImpl implements DataDao{

	@Autowired
	SessionFactory sessionFactory;
	
	Session session = null;
	Transaction tx = null;
	
	@Override
	public Customer getEntity(String userId) throws Exception {
		session = sessionFactory.openSession();
		Customer customer = (Customer) session.load(Customer.class, userId);
		tx = session.getTransaction();
		session.beginTransaction();
		tx.commit();
		return customer;
	}
	
	@Override
	public CustomerProfileInfo getCustProfileInfo(String userId) throws Exception {
		session = sessionFactory.openSession();
		CustomerProfileInfo customerProfileInfo = (CustomerProfileInfo) session.load(CustomerProfileInfo.class, userId);
		tx = session.getTransaction();
		session.beginTransaction();
		tx.commit();
		return customerProfileInfo;
	}
	
	@Override
	public List<Category> getCategories() throws Exception {		
		session = sessionFactory.openSession();
		Query query = session.createQuery("from Category");
		List<Category> categoryList = query.list();
		return categoryList;
	}
}
