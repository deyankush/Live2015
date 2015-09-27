package com.marketRoad.services;

import java.util.List;

import com.marketRoad.model.Category;
import com.marketRoad.model.Customer;
import com.marketRoad.model.CustomerProfileInfo;

public interface DataServices {

	public Customer getCustDtls(String userId) throws Exception;
	
	public CustomerProfileInfo getCustProfileDetails(String userId) throws Exception;

	public List<Category> getCategoriesList() throws Exception;
	
}
