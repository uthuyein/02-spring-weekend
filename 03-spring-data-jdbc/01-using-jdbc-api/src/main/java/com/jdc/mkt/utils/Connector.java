package com.jdc.mkt.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {

	private static final String URL = "jdbc:mysql://localhost:3306/testDb";
    private static final String user = "root";
    private static final String password = "admin";
    
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(URL, user, password);
	}
}
