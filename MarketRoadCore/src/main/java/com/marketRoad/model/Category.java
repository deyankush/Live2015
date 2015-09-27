package com.marketRoad.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "mkt_category")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Category {
	
	@Id
	@GeneratedValue
	@Column(name="category_id")
	private String categoryId;
	
	@Column(name="category_name")
	private String categoryName;
	
	@Column(name="category_status")
	private String categoryStatus;
	
	@Column(name="category_description")
	private String categoryDescription;
	
	@OneToMany(fetch=FetchType.EAGER)
	@JoinColumn(name = "category_id")
	private List<Subcategory> subcategories = new ArrayList<Subcategory>();

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

	public void setCategoryStatus(String categoryStatus) {
		this.categoryStatus = categoryStatus;
	}

	public String getCategoryDescription() {
		return categoryDescription;
	}

	public void setCategoryDescription(String categoryDescription) {
		this.categoryDescription = categoryDescription;
	}

	public List<Subcategory> getSubcategories() {
		return subcategories;
	}

	public void setSubcategories(List<Subcategory> subcategories) {
		this.subcategories = subcategories;
	}
	
	
}
