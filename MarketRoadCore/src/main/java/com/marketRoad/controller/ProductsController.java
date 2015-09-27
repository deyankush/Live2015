package com.marketRoad.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.marketRoad.model.Category;
import com.marketRoad.model.Subcategory;
import com.marketRoad.services.DataServices;
import com.marketRoad.vo.CategorizationVO;

@RestController
@RequestMapping("/unauth/products")
public class ProductsController {

	@Autowired
	DataServices dataServices;
	
	static final Logger logger = Logger.getLogger(ProductsController.class);
	
	@RequestMapping(value = "/getCategories", method=RequestMethod.GET, headers="Accept=application/json")
	public ArrayList<CategorizationVO> getAllCategories() throws Exception {
		ArrayList<CategorizationVO> categoryList = new ArrayList<CategorizationVO>();
		List<Category> allCategories = dataServices.getCategoriesList();		
		for(Category cat:  allCategories){
			CategorizationVO catVO = new CategorizationVO();
			catVO.setCategoryId(cat.getCategoryId());
			catVO.setCategoryName(cat.getCategoryName());
			
			catVO.setCategoryDescription(cat.getCategoryDescription());
			catVO.setCategory_status(cat.getCategoryStatus());
			catVO.setSubcategory(new ArrayList<Subcategory>(cat.getSubcategories()));
			categoryList.add(catVO);
		}
		return categoryList;
	}
	
	@RequestMapping(value = "/getProductsByFilter", method=RequestMethod.GET, headers="Accept=application/json")
	public ArrayList<CategorizationVO> getProductsByFilter() throws Exception {
		return new ArrayList<CategorizationVO>();
	}
	
	@RequestMapping(value = "/getProductsByShopId", method=RequestMethod.GET, headers="Accept=application/json")
	public ArrayList<CategorizationVO> getProductsByShopId() throws Exception {
		return new ArrayList<CategorizationVO>();
	}
	
	@RequestMapping(value = "/getShopsByAreaId", method=RequestMethod.GET, headers="Accept=application/json")
	public ArrayList<CategorizationVO> getShopsByAreaId() throws Exception {
		return new ArrayList<CategorizationVO>();
	}
	
	@RequestMapping(value = "/getShopsByCategoryId", method=RequestMethod.GET, headers="Accept=application/json")
	public ArrayList<CategorizationVO> getShopsByCategoryId() throws Exception {
		return new ArrayList<CategorizationVO>();
	}
	
	@RequestMapping(value = "/getShopsByName", method=RequestMethod.GET, headers="Accept=application/json")
	public ArrayList<CategorizationVO> getShopsByName() throws Exception {
		return new ArrayList<CategorizationVO>();
	}
}
