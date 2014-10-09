package com.example.fw;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class JdbcHelper {

	private Connection conn;
	
	public JdbcHelper(ApplicationManager app, String url) {
		try {
			//includes driver for db mysql by name
			//DriverManager needs registered JDBC drivers to try to make Connections with
			//The easiest way to do this is to use Class.forName() on the class that implements the java.sql.Driver interface. With MySQL Connector/J, the name of this class is com.mysql.jdbc.Driver. 
			//MySQL Connector/J is the official JDBC driver for MySQL
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			//When you are using JDBC outside of an application server, the DriverManager class manages the establishment of connections
			conn = DriverManager.getConnection(url);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
