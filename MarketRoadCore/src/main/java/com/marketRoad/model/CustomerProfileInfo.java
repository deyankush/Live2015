package com.marketRoad.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "mkt_cust_profile_info")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class CustomerProfileInfo {

	@Id
	@GeneratedValue
	@Column(name="USER_ID")
	private String userID;
	
	@Column(name="CUST_FNAME")
	private String firstName;
	
	@Column(name="CUST_LNAME")
	private String lastName;
		
	@Column(name="CUST_GENDER")
	private char gender;
	
	@Column(name="BILLING_ADD_ID")
	private String billingAddress;

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public String getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(String billingAddress) {
		this.billingAddress = billingAddress;
	}
	
}
