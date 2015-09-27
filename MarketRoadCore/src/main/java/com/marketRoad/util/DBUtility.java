package com.marketRoad.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtility {
	private static Connection conn = null;
	public static Connection getConnection(){
		if(conn != null){
			return conn;
		}else{
			try{
				String driver = "com.mysql.jdbc.Driver";
				String url = "jdbc:mysql://localhost:3306/market_road";
				String user = "root";
				String password = "";
				Class.forName(driver);
				conn = DriverManager.getConnection(url, user, password);
			}catch(ClassNotFoundException e){
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return conn;
		}
	}

}
