package com.marketRoad.vo;

import java.util.ArrayList;

import com.marketRoad.model.Subcategory;

public class CategorizationVO {
	private String categoryId;
	
	private String categoryName;
	
	private String categoryStatus;
	
	private String categoryDescription;
	
	private ArrayList<Subcategory> subcategory;

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getCategoryStatus() {
		return categoryStatus;
	}

	public void setCategory_status(String categoryStatus) {
		this.categoryStatus = categoryStatus;
	}

	public String getCategoryDescription() {
		return categoryDescription;
	}

	public void setCategoryDescription(String categoryDescription) {
		this.categoryDescription = categoryDescription;
	}

	public ArrayList<Subcategory> getSubcategory() {
		return subcategory;
	}

	public void setSubcategory(ArrayList<Subcategory> subcategory) {
		this.subcategory = subcategory;
	}
	

}
