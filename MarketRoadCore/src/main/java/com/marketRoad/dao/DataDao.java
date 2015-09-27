/**
 * 
 */
package com.marketRoad.dao;

import java.util.List;

import com.marketRoad.model.Category;
import com.marketRoad.model.Customer;
import com.marketRoad.model.CustomerProfileInfo;

/**
 * @author Gaurav PC
 *
 */
public interface DataDao {

	public Customer getEntity(String userId) throws Exception;
	
	public CustomerProfileInfo getCustProfileInfo(String userId) throws Exception;
	
	public List<Category> getCategories() throws Exception;
}
