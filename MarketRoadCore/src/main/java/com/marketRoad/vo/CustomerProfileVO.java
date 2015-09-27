package com.marketRoad.vo;

import com.marketRoad.model.CustomerProfileInfo;
import com.marketRoad.model.Status;

public class CustomerProfileVO {
	private Status status;
	
	private String email;

	private String phone;
	
	private CustomerProfileInfo profile;

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public CustomerProfileInfo getProfile() {
		return profile;
	}

	public void setProfile(CustomerProfileInfo profile) {
		this.profile = profile;
	}

}
