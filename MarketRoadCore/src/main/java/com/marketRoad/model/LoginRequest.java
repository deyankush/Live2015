package com.marketRoad.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class LoginRequest implements Serializable {

	private static final long serialVersionUID = 1L;

	private String userID;

	@JsonIgnoreProperties
	private String password;

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
