package com.marketRoad.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.marketRoad.dao.DataDao;
import com.marketRoad.model.Category;
import com.marketRoad.model.Customer;
import com.marketRoad.model.CustomerProfileInfo;

public class DataServicesImpl implements DataServices{
	
	@Autowired
	DataDao dao;
	
	@Override
	public Customer getCustDtls(String userId) throws Exception {
		return dao.getEntity(userId);
	}
	
	@Override
	public CustomerProfileInfo getCustProfileDetails(String userId) throws Exception {
		return dao.getCustProfileInfo(userId);
	}
	
	@Override
	public List<Category> getCategoriesList() throws Exception {
		return dao.getCategories();
	}

}
