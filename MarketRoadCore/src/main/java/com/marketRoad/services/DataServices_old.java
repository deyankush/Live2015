package com.marketRoad.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.marketRoad.model.Customer;
import com.marketRoad.util.DBUtility;

public class DataServices_old {

	private Connection connection;

	public DataServices_old() {
		connection = DBUtility.getConnection();
	}

	public Customer getCustomerDtls(String user_id) throws SQLException {
		Customer cust = new Customer();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement
					.executeQuery("select * from mkt_cust_creds where user_id= '"
							+ user_id+"'");
			while (rs.next()) {
				cust.setUserID(rs.getString("user_id"));
				cust.setPassword(rs.getString("password"));
				cust.setPhone(rs.getString("mobile_no"));
				cust.setEmail(rs.getString("email_id"));

			}
			rs.close();
			statement.close();
		} catch (SQLException e) {
			cust = null;
			e.printStackTrace();
		}	
		return cust;
	}

}
